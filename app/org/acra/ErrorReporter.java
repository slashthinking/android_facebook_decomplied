package org.acra;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.acra.reporter.ReportsCrashes;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;
import org.acra.util.Installation;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.SimpleTraceLogger;

public class ErrorReporter
  implements Thread.UncaughtExceptionHandler
{
  public static final String ACRA_DIRNAME = "acra-reports";
  static final String APPROVED_SUFFIX = "-approved";
  public static final long DEFAULT_MAX_REPORT_SIZE = 51200L;
  static final String EXTRA_REPORT_FILE_NAME = "REPORT_FILE_NAME";
  public static final long MAX_REPORT_AGE = 86400000L;
  private static final int MAX_SEND_REPORTS = 5;
  public static final long MAX_STORED_REPORTS = 3L;
  public static final String REPORTFILE_EXTENSION = ".stacktrace";
  static final String SILENT_SUFFIX;
  private static int TRACE_COUNT_LIMIT;
  private static SimpleTraceLogger activityLogger;
  private static boolean enabled = false;
  private static Context mContext;
  private static CrashReportData mCrashProperties;
  private static ErrorReporter mInstanceSingleton;
  private static long mMaxReportSize = 51200L;
  private static ArrayList<ReportSender> mReportSenders = new ArrayList();
  Map<String, String> mCustomParameters = new HashMap();
  private Thread.UncaughtExceptionHandler mDfltExceptionHandler;
  private String mInitialConfiguration;
  private ReportingInteractionMode mReportingInteractionMode = ReportingInteractionMode.SILENT;

  static
  {
    mCrashProperties = new CrashReportData();
    SILENT_SUFFIX = "-" + ReportField.IS_SILENT;
    TRACE_COUNT_LIMIT = 5;
    activityLogger = new SimpleTraceLogger(TRACE_COUNT_LIMIT);
  }

  // ERROR //
  private static void addUserDataToReport(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   3: new 76	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   10: ldc 142
    //   12: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 148	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   25: pop
    //   26: aload_1
    //   27: ifnull +148 -> 175
    //   30: aload_2
    //   31: ifnull +144 -> 175
    //   34: new 150	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: aload_1
    //   40: invokestatic 154	org/acra/ErrorReporter:fileForName	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   43: invokespecial 157	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore 5
    //   48: new 71	org/acra/CrashReportData
    //   51: dup
    //   52: invokespecial 72	org/acra/CrashReportData:<init>	()V
    //   55: astore 6
    //   57: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   60: ldc 159
    //   62: invokestatic 148	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   65: pop
    //   66: aload 6
    //   68: aload 5
    //   70: invokevirtual 163	org/acra/CrashReportData:load	(Ljava/io/InputStream;)V
    //   73: aload 5
    //   75: invokevirtual 166	java/io/FileInputStream:close	()V
    //   78: aload 6
    //   80: getstatic 169	org/acra/ReportField:USER_COMMENT	Lorg/acra/ReportField;
    //   83: aload_2
    //   84: invokevirtual 173	org/acra/CrashReportData:put	(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: getstatic 176	org/acra/ReportField:USER_EMAIL	Lorg/acra/ReportField;
    //   91: astore 16
    //   93: aload_3
    //   94: ifnonnull +6 -> 100
    //   97: ldc 178
    //   99: astore_3
    //   100: aload 6
    //   102: aload 16
    //   104: aload_3
    //   105: invokevirtual 173	org/acra/CrashReportData:put	(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload_0
    //   110: aload_1
    //   111: aload 6
    //   113: invokestatic 182	org/acra/ErrorReporter:saveCrashReportFile	(Landroid/content/Context;Ljava/lang/String;Lorg/acra/CrashReportData;)Ljava/lang/String;
    //   116: pop
    //   117: goto +58 -> 175
    //   120: astore 7
    //   122: aload 5
    //   124: invokevirtual 166	java/io/FileInputStream:close	()V
    //   127: aload 7
    //   129: athrow
    //   130: astore 12
    //   132: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   135: ldc 184
    //   137: aload 12
    //   139: invokestatic 188	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   142: pop
    //   143: goto +32 -> 175
    //   146: astore 10
    //   148: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   151: ldc 184
    //   153: aload 10
    //   155: invokestatic 188	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   158: pop
    //   159: goto +16 -> 175
    //   162: astore 8
    //   164: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   167: ldc 184
    //   169: aload 8
    //   171: invokestatic 188	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   174: pop
    //   175: return
    //
    // Exception table:
    //   from	to	target	type
    //   57	73	120	finally
    //   34	57	130	java/io/FileNotFoundException
    //   73	130	130	java/io/FileNotFoundException
    //   34	57	146	java/util/InvalidPropertiesFormatException
    //   73	130	146	java/util/InvalidPropertiesFormatException
    //   34	57	162	java/io/IOException
    //   73	130	162	java/io/IOException
  }

  // ERROR //
  private static int cleanupReportDir(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 10
    //   3: iconst_0
    //   4: invokevirtual 198	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   7: invokevirtual 204	java/io/File:listFiles	()[Ljava/io/File;
    //   10: astore 5
    //   12: aload 5
    //   14: arraylength
    //   15: istore 6
    //   17: iload 6
    //   19: i2l
    //   20: ldc2_w 28
    //   23: lcmp
    //   24: ifle +84 -> 108
    //   27: iconst_0
    //   28: istore 7
    //   30: iconst_0
    //   31: istore 8
    //   33: iload 7
    //   35: aload 5
    //   37: arraylength
    //   38: if_icmpge +74 -> 112
    //   41: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   44: new 76	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   51: ldc 206
    //   53: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 5
    //   58: iload 7
    //   60: aaload
    //   61: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 208	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   70: pop
    //   71: aload 5
    //   73: iload 7
    //   75: aaload
    //   76: invokevirtual 212	java/io/File:delete	()Z
    //   79: istore 11
    //   81: iload 11
    //   83: ifeq +19 -> 102
    //   86: iconst_1
    //   87: istore 12
    //   89: iload 8
    //   91: iload 12
    //   93: iadd
    //   94: istore 8
    //   96: iinc 7 1
    //   99: goto -66 -> 33
    //   102: iconst_0
    //   103: istore 12
    //   105: goto -16 -> 89
    //   108: iconst_m1
    //   109: istore_2
    //   110: iload_2
    //   111: ireturn
    //   112: iload 8
    //   114: istore_2
    //   115: goto -5 -> 110
    //   118: astore_1
    //   119: iconst_0
    //   120: istore_2
    //   121: aload_1
    //   122: astore_3
    //   123: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   126: new 76	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   133: ldc 214
    //   135: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 208	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   148: pop
    //   149: goto -39 -> 110
    //   152: astore 9
    //   154: aload 9
    //   156: astore_3
    //   157: iload 8
    //   159: istore_2
    //   160: goto -37 -> 123
    //
    // Exception table:
    //   from	to	target	type
    //   0	17	118	java/lang/Throwable
    //   33	81	152	java/lang/Throwable
  }

  private boolean containsOnlySilentOrApprovedReports(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    int j = 0;
    int k;
    if (j < i)
    {
      boolean bool = isApproved(paramArrayOfString[j]);
      k = 0;
      if (bool);
    }
    while (true)
    {
      return k;
      j++;
      break;
      k = 1;
    }
  }

  private String createCustomInfoString()
  {
    Iterator localIterator = this.mCustomParameters.keySet().iterator();
    String str2;
    String str3;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + " = " + str3 + "\n")
    {
      str2 = (String)localIterator.next();
      str3 = (String)this.mCustomParameters.get(str2);
    }
    return str1;
  }

  private void deleteFile(Context paramContext, String paramString)
  {
    if (!fileForName(paramContext, paramString).delete())
      Log.w(ACRA.LOG_TAG, "Could not delete error report : " + paramString);
  }

  private void deletePendingReports(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    String[] arrayOfString = getCrashReportFilesList();
    Arrays.sort(arrayOfString);
    if (arrayOfString != null)
      for (int i = 0; i < arrayOfString.length - paramInt; i++)
      {
        String str = arrayOfString[i];
        boolean bool = isApproved(str);
        if (((!bool) || (!paramBoolean1)) && ((bool) || (!paramBoolean2)))
          continue;
        new File(mContext.getDir("acra-reports", 0), str).delete();
      }
  }

  private static File fileForName(Context paramContext, String paramString)
  {
    return new File(paramContext.getDir("acra-reports", 0), paramString);
  }

  private void gatherCrashData(Throwable paramThrowable, OutputStream paramOutputStream)
  {
    if (paramThrowable == null)
      paramThrowable = new Exception("Report requested by developer");
    Writer localWriter = null;
    if (paramOutputStream != null)
      localWriter = CrashReportData.getWriter(paramOutputStream);
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    for (Throwable localThrowable = paramThrowable.getCause(); localThrowable != null; localThrowable = localThrowable.getCause())
      localThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.close();
    try
    {
      mCrashProperties.put(ReportField.STACK_TRACE, localStringWriter.toString(), localWriter);
      retrieveCrashData(mContext, localWriter);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Log.e("ACRA", "Crash in gatherCrashData:" + localException);
    }
  }

  private static String genCrashReportFileName(String paramString, CrashReportData paramCrashReportData)
  {
    try
    {
      Log.d(ACRA.LOG_TAG, "Generating crash report file.");
      if (paramCrashReportData == null)
        paramCrashReportData = mCrashProperties;
      if (paramString == null)
      {
        Time localTime = new Time();
        localTime.setToNow();
        long l = localTime.toMillis(false);
        String str1 = paramCrashReportData.getProperty(ReportField.IS_SILENT);
        StringBuilder localStringBuilder = new StringBuilder().append("").append(l);
        if (str1 != null);
        for (String str2 = SILENT_SUFFIX; ; str2 = "")
        {
          paramString = str2 + ".stacktrace";
          break;
        }
      }
    }
    catch (Exception localException)
    {
      Log.e(ACRA.LOG_TAG, "An error occured while generating the report file...", localException);
      paramString = null;
    }
    return paramString;
  }

  private static long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks();
  }

  public static ErrorReporter getInstance()
  {
    if (mInstanceSingleton == null)
      mInstanceSingleton = new ErrorReporter();
    return mInstanceSingleton;
  }

  private String getLatestNonSilentReport(String[] paramArrayOfString)
  {
    int i;
    String str;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      i = -1 + paramArrayOfString.length;
      if (i >= 0)
        if (!isSilent(paramArrayOfString[i]))
          str = paramArrayOfString[i];
    }
    while (true)
    {
      return str;
      i--;
      break;
      str = paramArrayOfString[(-1 + paramArrayOfString.length)];
      continue;
      str = null;
    }
  }

  private String getProcessName()
  {
    int i = Process.myPid();
    Iterator localIterator = ((ActivityManager)mContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext())
        break;
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    }
    while (localRunningAppProcessInfo.pid != i);
    for (String str = localRunningAppProcessInfo.processName; ; str = "")
      return str;
  }

  private static long getTotalInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount();
  }

  private boolean isApproved(String paramString)
  {
    if ((isSilent(paramString)) || (paramString.contains("-approved")));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean isSilent(String paramString)
  {
    return paramString.contains(SILENT_SUFFIX);
  }

  private CrashReportData loadCrashReport(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    CrashReportData localCrashReportData = new CrashReportData();
    File localFile = fileForName(paramContext, paramString);
    if (localFile.lastModified() - System.currentTimeMillis() > 86400000L)
    {
      Log.w(ACRA.LOG_TAG, "crash report " + paramString + " was too old; deleted");
      deleteFile(paramContext, paramString);
    }
    while (true)
    {
      return localObject1;
      if (localFile.length() > mMaxReportSize)
      {
        Log.w(ACRA.LOG_TAG, "" + localFile.length() + "-byte crash report " + paramString + " exceeded max size of " + mMaxReportSize + " bytes; deleted");
        deleteFile(paramContext, paramString);
        localObject1 = null;
        continue;
      }
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      int i = 0;
      try
      {
        localCrashReportData.load(localFileInputStream);
        localFileInputStream.close();
        localObject1 = localCrashReportData;
        continue;
      }
      catch (Throwable localThrowable)
      {
        while (true)
        {
          Log.e(ACRA.LOG_TAG, "Could not load crash report:" + paramString + " " + localThrowable);
          localFileInputStream.close();
          i = 1;
          paramContext.deleteFile(paramString);
          Log.e(ACRA.LOG_TAG, "Crash report:" + paramString + " deleted");
        }
      }
      finally
      {
        if (i == 0)
          localFileInputStream.close();
      }
    }
    throw localObject2;
  }

  private void retrieveCrashData(Context paramContext, Writer paramWriter)
  {
    try
    {
      ReportsCrashes localReportsCrashes = ACRA.getConfig();
      ReportField[] arrayOfReportField = localReportsCrashes.customReportContent();
      List localList;
      SharedPreferences localSharedPreferences;
      PackageManagerWrapper localPackageManagerWrapper;
      if (arrayOfReportField.length == 0)
      {
        if ((localReportsCrashes.mailTo() == null) || ("".equals(localReportsCrashes.mailTo())))
          arrayOfReportField = ACRA.DEFAULT_REPORT_FIELDS;
      }
      else
      {
        localList = Arrays.asList(arrayOfReportField);
        localSharedPreferences = ACRA.getACRASharedPreferences();
        if (localList.contains(ReportField.REPORT_ID))
          mCrashProperties.put(ReportField.REPORT_ID, UUID.randomUUID().toString(), paramWriter);
        if (localList.contains(ReportField.DUMPSYS_MEMINFO))
          mCrashProperties.put(ReportField.DUMPSYS_MEMINFO, DumpSysCollector.collectMemInfo(paramContext), paramWriter);
        localPackageManagerWrapper = new PackageManagerWrapper(paramContext);
        if (localPackageManagerWrapper != null)
        {
          if ((!localSharedPreferences.getBoolean("acra.syslog.enable", true)) || (!localPackageManagerWrapper.hasPermission("android.permission.READ_LOGS")))
            break label1223;
          Log.i(ACRA.LOG_TAG, "READ_LOGS granted! ACRA can include LogCat and DropBox data.");
          if (localList.contains(ReportField.LOGCAT))
            mCrashProperties.put(ReportField.LOGCAT, LogCatCollector.collectLogCat(null).toString(), paramWriter);
          if (localList.contains(ReportField.EVENTSLOG))
            mCrashProperties.put(ReportField.EVENTSLOG, LogCatCollector.collectLogCat("events").toString(), paramWriter);
          if (localList.contains(ReportField.RADIOLOG))
            mCrashProperties.put(ReportField.RADIOLOG, LogCatCollector.collectLogCat("radio").toString(), paramWriter);
          if (localList.contains(ReportField.DROPBOX))
            mCrashProperties.put(ReportField.DROPBOX, DropBoxCollector.read(mContext, ACRA.getConfig().additionalDropBoxTags()), paramWriter);
        }
      }
      while (true)
      {
        if ((localList.contains(ReportField.DEVICE_ID)) && (localSharedPreferences.getBoolean("acra.deviceid.enable", true)) && (localPackageManagerWrapper.hasPermission("android.permission.READ_PHONE_STATE")))
        {
          String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
          if (str2 != null)
            mCrashProperties.put(ReportField.DEVICE_ID, str2, paramWriter);
        }
        if (localList.contains(ReportField.INSTALLATION_ID))
          mCrashProperties.put(ReportField.INSTALLATION_ID, Installation.id(mContext), paramWriter);
        if (localList.contains(ReportField.INITIAL_CONFIGURATION))
          mCrashProperties.put(ReportField.INITIAL_CONFIGURATION, this.mInitialConfiguration, paramWriter);
        if (localList.contains(ReportField.CRASH_CONFIGURATION))
        {
          Configuration localConfiguration = paramContext.getResources().getConfiguration();
          mCrashProperties.put(ReportField.CRASH_CONFIGURATION, ConfigurationInspector.toString(localConfiguration), paramWriter);
        }
        PackageInfo localPackageInfo = localPackageManagerWrapper.getPackageInfo();
        if (localPackageInfo == null)
          break label1259;
        if (localList.contains(ReportField.APP_VERSION_CODE))
          mCrashProperties.put(ReportField.APP_VERSION_CODE, Integer.toString(localPackageInfo.versionCode), paramWriter);
        if (localList.contains(ReportField.APP_VERSION_NAME))
        {
          CrashReportData localCrashReportData = mCrashProperties;
          ReportField localReportField = ReportField.APP_VERSION_NAME;
          if (localPackageInfo.versionName == null)
            break label1251;
          str1 = localPackageInfo.versionName;
          localCrashReportData.put(localReportField, str1, paramWriter);
        }
        if (localList.contains(ReportField.PACKAGE_NAME))
          mCrashProperties.put(ReportField.PACKAGE_NAME, paramContext.getPackageName(), paramWriter);
        if (localList.contains(ReportField.BUILD))
          mCrashProperties.put(ReportField.BUILD, ReflectionCollector.collectConstants(Build.class), paramWriter);
        if (localList.contains(ReportField.PHONE_MODEL))
          mCrashProperties.put(ReportField.PHONE_MODEL, Build.MODEL, paramWriter);
        if (localList.contains(ReportField.ANDROID_VERSION))
          mCrashProperties.put(ReportField.ANDROID_VERSION, Build.VERSION.RELEASE, paramWriter);
        if (localList.contains(ReportField.BRAND))
          mCrashProperties.put(ReportField.BRAND, Build.BRAND, paramWriter);
        if (localList.contains(ReportField.PRODUCT))
          mCrashProperties.put(ReportField.PRODUCT, Build.PRODUCT, paramWriter);
        if (localList.contains(ReportField.TOTAL_MEM_SIZE))
          mCrashProperties.put(ReportField.TOTAL_MEM_SIZE, Long.toString(getTotalInternalMemorySize()), paramWriter);
        if (localList.contains(ReportField.AVAILABLE_MEM_SIZE))
          mCrashProperties.put(ReportField.AVAILABLE_MEM_SIZE, Long.toString(getAvailableInternalMemorySize()), paramWriter);
        if (localList.contains(ReportField.FILE_PATH))
          mCrashProperties.put(ReportField.FILE_PATH, paramContext.getFilesDir().getAbsolutePath(), paramWriter);
        if (localList.contains(ReportField.DISPLAY))
        {
          Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
          mCrashProperties.put(ReportField.DISPLAY, toString(localDisplay), paramWriter);
        }
        if (localList.contains(ReportField.USER_CRASH_DATE))
        {
          Time localTime = new Time();
          localTime.setToNow();
          mCrashProperties.put(ReportField.USER_CRASH_DATE, localTime.format3339(false), paramWriter);
        }
        if (localList.contains(ReportField.CUSTOM_DATA))
          mCrashProperties.put(ReportField.CUSTOM_DATA, createCustomInfoString(), paramWriter);
        if (localList.contains(ReportField.USER_EMAIL))
          mCrashProperties.put(ReportField.USER_EMAIL, localSharedPreferences.getString("acra.user.email", "N/A"), paramWriter);
        if (localList.contains(ReportField.DEVICE_FEATURES))
          mCrashProperties.put(ReportField.DEVICE_FEATURES, DeviceFeaturesCollector.getFeatures(paramContext), paramWriter);
        if (localList.contains(ReportField.ENVIRONMENT))
          mCrashProperties.put(ReportField.ENVIRONMENT, ReflectionCollector.collectStaticGettersResults(Environment.class), paramWriter);
        if (localList.contains(ReportField.SETTINGS_SYSTEM))
          mCrashProperties.put(ReportField.SETTINGS_SYSTEM, SettingsCollector.collectSystemSettings(mContext), paramWriter);
        if (localList.contains(ReportField.SETTINGS_SECURE))
          mCrashProperties.put(ReportField.SETTINGS_SECURE, SettingsCollector.collectSecureSettings(mContext), paramWriter);
        if (localList.contains(ReportField.SHARED_PREFERENCES))
          mCrashProperties.put(ReportField.SHARED_PREFERENCES, SharedPreferencesCollector.collect(mContext), paramWriter);
        if (localList.contains(ReportField.PROCESS_NAME))
          mCrashProperties.put(ReportField.PROCESS_NAME, getProcessName(), paramWriter);
        if ((!localList.contains(ReportField.ACTIVITY_LOG)) || (!localSharedPreferences.getBoolean("acra.activitylog.enable", true)))
          return;
        mCrashProperties.put(ReportField.ACTIVITY_LOG, activityLogger.toString(), paramWriter);
        return;
        if ("".equals(localReportsCrashes.mailTo()))
          break;
        arrayOfReportField = ACRA.DEFAULT_MAIL_REPORT_FIELDS;
        break;
        label1223: Log.i(ACRA.LOG_TAG, "READ_LOGS not allowed. ACRA will not include LogCat and DropBox data.");
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.e(ACRA.LOG_TAG, "Error while retrieving crash data", localException);
        break;
        label1251: String str1 = "not set";
        continue;
        label1259: mCrashProperties.put(ReportField.APP_VERSION_NAME, "Package info unavailable", paramWriter);
      }
    }
  }

  // ERROR //
  private static String saveCrashReportFile(Context paramContext, String paramString, CrashReportData paramCrashReportData)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   5: ldc_w 779
    //   8: invokestatic 148	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   11: pop
    //   12: aload_1
    //   13: aload_2
    //   14: invokestatic 781	org/acra/ErrorReporter:genCrashReportFileName	(Ljava/lang/String;Lorg/acra/CrashReportData;)Ljava/lang/String;
    //   17: astore 7
    //   19: aconst_null
    //   20: astore_3
    //   21: aload_2
    //   22: ifnonnull +7 -> 29
    //   25: getstatic 74	org/acra/ErrorReporter:mCrashProperties	Lorg/acra/CrashReportData;
    //   28: astore_2
    //   29: aload_0
    //   30: invokestatic 783	org/acra/ErrorReporter:cleanupReportDir	(Landroid/content/Context;)I
    //   33: istore 8
    //   35: aconst_null
    //   36: astore_3
    //   37: iload 8
    //   39: ifne +18 -> 57
    //   42: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   45: ldc_w 785
    //   48: invokestatic 319	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   51: pop
    //   52: aconst_null
    //   53: astore_3
    //   54: goto +61 -> 115
    //   57: new 787	java/io/FileOutputStream
    //   60: dup
    //   61: aload_0
    //   62: aload 7
    //   64: invokestatic 154	org/acra/ErrorReporter:fileForName	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   67: invokespecial 788	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: astore 9
    //   72: aload_2
    //   73: aload 9
    //   75: ldc 178
    //   77: invokevirtual 792	org/acra/CrashReportData:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   80: aload 9
    //   82: invokevirtual 793	java/io/FileOutputStream:close	()V
    //   85: aload 7
    //   87: astore_3
    //   88: goto +27 -> 115
    //   91: astore 10
    //   93: aload 9
    //   95: invokevirtual 793	java/io/FileOutputStream:close	()V
    //   98: aload 10
    //   100: athrow
    //   101: astore 4
    //   103: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   106: ldc_w 795
    //   109: aload 4
    //   111: invokestatic 344	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   114: pop
    //   115: aload_3
    //   116: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   72	80	91	finally
    //   2	72	101	java/lang/Exception
    //   80	101	101	java/lang/Exception
  }

  private static void sendCrashReport(Context paramContext, CrashReportData paramCrashReportData)
  {
    Iterator localIterator = mReportSenders.iterator();
    int i = 0;
    while (true)
      if (localIterator.hasNext())
      {
        ReportSender localReportSender = (ReportSender)localIterator.next();
        try
        {
          localReportSender.send(paramCrashReportData);
          j = 1;
          i = j;
        }
        catch (ReportSenderException localReportSenderException)
        {
          while (true)
          {
            if (i == 0)
              throw localReportSenderException;
            Log.w(ACRA.LOG_TAG, "ReportSender of class " + localReportSender.getClass().getName() + " failed but other senders completed their task. ACRA will not send this report again.");
            int j = i;
          }
        }
      }
  }

  private static String toString(Display paramDisplay)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramDisplay.getMetrics(localDisplayMetrics);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("width=").append(paramDisplay.getWidth()).append('\n').append("height=").append(paramDisplay.getHeight()).append('\n').append("pixelFormat=").append(paramDisplay.getPixelFormat()).append('\n').append("refreshRate=").append(paramDisplay.getRefreshRate()).append("fps").append('\n').append("metrics.density=x").append(localDisplayMetrics.density).append('\n').append("metrics.scaledDensity=x").append(localDisplayMetrics.scaledDensity).append('\n').append("metrics.widthPixels=").append(localDisplayMetrics.widthPixels).append('\n').append("metrics.heightPixels=").append(localDisplayMetrics.heightPixels).append('\n').append("metrics.xdpi=").append(localDisplayMetrics.xdpi).append('\n').append("metrics.ydpi=").append(localDisplayMetrics.ydpi);
    return localStringBuilder.toString();
  }

  @Deprecated
  public void addCustomData(String paramString1, String paramString2)
  {
    this.mCustomParameters.put(paramString1, paramString2);
  }

  public void addReportSender(ReportSender paramReportSender)
  {
    mReportSenders.add(paramReportSender);
  }

  public void approvePendingReports()
  {
    Log.d(ACRA.LOG_TAG, "Mark all pending reports as approved.");
    for (String str1 : getCrashReportFilesList())
    {
      if (isApproved(str1))
        continue;
      File localFile = new File(mContext.getDir("acra-reports", 0), str1);
      String str2 = str1.replace(".stacktrace", "-approved.stacktrace");
      localFile.renameTo(new File(mContext.getDir("acra-reports", 0), str2));
    }
  }

  // ERROR //
  void checkAndSendReports(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   7: ldc_w 921
    //   10: invokestatic 148	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual 262	org/acra/ErrorReporter:getCrashReportFilesList	()[Ljava/lang/String;
    //   18: astore 6
    //   20: aload 6
    //   22: invokestatic 268	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   25: aload 6
    //   27: arraylength
    //   28: istore 7
    //   30: iconst_0
    //   31: istore 8
    //   33: iload 8
    //   35: iload 7
    //   37: if_icmpge +26 -> 63
    //   40: aload 6
    //   42: iload 8
    //   44: aaload
    //   45: astore 10
    //   47: iload_2
    //   48: ifeq +203 -> 251
    //   51: aload_0
    //   52: aload 10
    //   54: invokespecial 375	org/acra/ErrorReporter:isSilent	(Ljava/lang/String;)Z
    //   57: ifne +194 -> 251
    //   60: goto +185 -> 245
    //   63: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   66: ldc_w 923
    //   69: invokestatic 148	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   79: new 76	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 925
    //   89: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload 10
    //   94: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 520	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   103: pop
    //   104: aload_0
    //   105: aload_1
    //   106: aload 10
    //   108: invokespecial 927	org/acra/ErrorReporter:loadCrashReport	(Landroid/content/Context;Ljava/lang/String;)Lorg/acra/CrashReportData;
    //   111: astore 18
    //   113: aload 18
    //   115: ifnull +16 -> 131
    //   118: aload_1
    //   119: aload 18
    //   121: invokestatic 929	org/acra/ErrorReporter:sendCrashReport	(Landroid/content/Context;Lorg/acra/CrashReportData;)V
    //   124: aload_0
    //   125: aload_1
    //   126: aload 10
    //   128: invokespecial 428	org/acra/ErrorReporter:deleteFile	(Landroid/content/Context;Ljava/lang/String;)V
    //   131: iinc 3 1
    //   134: goto +111 -> 245
    //   137: astore 16
    //   139: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   142: ldc_w 931
    //   145: aload 16
    //   147: invokestatic 344	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   150: pop
    //   151: aload_0
    //   152: aload_1
    //   153: aload 10
    //   155: invokespecial 428	org/acra/ErrorReporter:deleteFile	(Landroid/content/Context;Ljava/lang/String;)V
    //   158: goto -95 -> 63
    //   161: astore 4
    //   163: aload_0
    //   164: monitorexit
    //   165: aload 4
    //   167: athrow
    //   168: astore 14
    //   170: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   173: new 76	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 933
    //   183: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 10
    //   188: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: aload 14
    //   196: invokestatic 344	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   199: pop
    //   200: aload_0
    //   201: aload_1
    //   202: aload 10
    //   204: invokespecial 428	org/acra/ErrorReporter:deleteFile	(Landroid/content/Context;Ljava/lang/String;)V
    //   207: goto -144 -> 63
    //   210: astore 12
    //   212: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   215: new 76	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 935
    //   225: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 10
    //   230: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: aload 12
    //   238: invokestatic 344	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   241: pop
    //   242: goto -179 -> 63
    //   245: iinc 8 1
    //   248: goto -215 -> 33
    //   251: iload_3
    //   252: iconst_5
    //   253: if_icmplt -177 -> 76
    //   256: goto -193 -> 63
    //
    // Exception table:
    //   from	to	target	type
    //   104	131	137	java/lang/RuntimeException
    //   4	73	161	finally
    //   76	104	161	finally
    //   104	131	161	finally
    //   139	158	161	finally
    //   170	242	161	finally
    //   104	131	168	java/io/IOException
    //   104	131	210	org/acra/sender/ReportSenderException
  }

  public void checkReportsOnApplicationStart()
  {
    String[] arrayOfString = getCrashReportFilesList();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      boolean bool = containsOnlySilentOrApprovedReports(arrayOfString);
      if ((this.mReportingInteractionMode != ReportingInteractionMode.SILENT) && (this.mReportingInteractionMode != ReportingInteractionMode.TOAST) && ((this.mReportingInteractionMode != ReportingInteractionMode.NOTIFICATION) || (!bool)))
        break label108;
      if ((this.mReportingInteractionMode == ReportingInteractionMode.TOAST) && (!bool))
        Toast.makeText(mContext, ACRA.getConfig().resToastText(), 1).show();
      Log.v(ACRA.LOG_TAG, "About to start ReportSenderWorker from #checkReportOnApplicationStart");
      new ErrorReporter.ReportsSenderWorker(this).start();
    }
    while (true)
    {
      return;
      label108: if (ACRA.getConfig().deleteUnapprovedReportsOnApplicationStart())
      {
        getInstance().deletePendingNonApprovedReports();
        continue;
      }
      getInstance().notifySendReport(getLatestNonSilentReport(arrayOfString));
    }
  }

  public void deletePendingNonApprovedReports()
  {
    if (this.mReportingInteractionMode == ReportingInteractionMode.NOTIFICATION);
    for (int i = 1; ; i = 0)
    {
      deletePendingReports(false, true, i);
      return;
    }
  }

  public void deletePendingReports()
  {
    deletePendingReports(true, true, 0);
  }

  public void deletePendingSilentReports()
  {
    deletePendingReports(true, false, 0);
  }

  public void disable()
  {
    if (mContext != null)
      Log.d(ACRA.LOG_TAG, "ACRA is disabled for " + mContext.getPackageName());
    while (true)
    {
      if (this.mDfltExceptionHandler != null)
      {
        Thread.setDefaultUncaughtExceptionHandler(this.mDfltExceptionHandler);
        enabled = false;
      }
      return;
      Log.d(ACRA.LOG_TAG, "ACRA is disabled.");
    }
  }

  String[] getCrashReportFilesList()
  {
    String[] arrayOfString;
    if (mContext == null)
    {
      Log.e(ACRA.LOG_TAG, "Trying to get ACRA reports but ACRA is not initialized.");
      arrayOfString = new String[0];
    }
    while (true)
    {
      return arrayOfString;
      File localFile = mContext.getDir("acra-reports", 0);
      if (localFile != null)
      {
        Log.d(ACRA.LOG_TAG, "Looking for error files in " + localFile.getAbsolutePath());
        arrayOfString = localFile.list(new ErrorReporter.2(this));
        if (arrayOfString != null)
          continue;
        arrayOfString = new String[0];
        continue;
      }
      Log.w(ACRA.LOG_TAG, "Application files directory does not exist! The application may not be installed correctly. Please try reinstalling.");
      arrayOfString = new String[0];
    }
  }

  public String getCustomData(String paramString)
  {
    return (String)this.mCustomParameters.get(paramString);
  }

  public ErrorReporter.ReportsSenderWorker handleException(Throwable paramThrowable)
  {
    return handleException(paramThrowable, this.mReportingInteractionMode);
  }

  // ERROR //
  ErrorReporter.ReportsSenderWorker handleException(Throwable paramThrowable, ReportingInteractionMode paramReportingInteractionMode)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +205 -> 206
    //   4: aload_0
    //   5: getfield 120	org/acra/ErrorReporter:mReportingInteractionMode	Lorg/acra/ReportingInteractionMode;
    //   8: astore_2
    //   9: iconst_0
    //   10: istore_3
    //   11: aload_2
    //   12: getstatic 941	org/acra/ReportingInteractionMode:TOAST	Lorg/acra/ReportingInteractionMode;
    //   15: if_acmpeq +21 -> 36
    //   18: aload_2
    //   19: getstatic 944	org/acra/ReportingInteractionMode:NOTIFICATION	Lorg/acra/ReportingInteractionMode;
    //   22: if_acmpne +25 -> 47
    //   25: invokestatic 451	org/acra/ACRA:getConfig	()Lorg/acra/reporter/ReportsCrashes;
    //   28: invokeinterface 947 1 0
    //   33: ifeq +14 -> 47
    //   36: new 1019	org/acra/ErrorReporter$1
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 1020	org/acra/ErrorReporter$1:<init>	(Lorg/acra/ErrorReporter;)V
    //   44: invokevirtual 1021	org/acra/ErrorReporter$1:start	()V
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokestatic 781	org/acra/ErrorReporter:genCrashReportFileName	(Ljava/lang/String;Lorg/acra/CrashReportData;)Ljava/lang/String;
    //   52: astore 4
    //   54: new 787	java/io/FileOutputStream
    //   57: dup
    //   58: getstatic 124	org/acra/ErrorReporter:mContext	Landroid/content/Context;
    //   61: aload 4
    //   63: invokestatic 154	org/acra/ErrorReporter:fileForName	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   66: invokespecial 788	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: astore 5
    //   71: aload_0
    //   72: aload_1
    //   73: aload 5
    //   75: invokespecial 1023	org/acra/ErrorReporter:gatherCrashData	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   78: aload 5
    //   80: invokevirtual 793	java/io/FileOutputStream:close	()V
    //   83: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   86: new 76	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 1025
    //   96: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokestatic 1029	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   103: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 520	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   112: pop
    //   113: getstatic 74	org/acra/ErrorReporter:mCrashProperties	Lorg/acra/CrashReportData;
    //   116: getstatic 89	org/acra/ReportField:IS_SILENT	Lorg/acra/ReportField;
    //   119: invokevirtual 1032	org/acra/CrashReportData:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: getstatic 74	org/acra/ErrorReporter:mCrashProperties	Lorg/acra/CrashReportData;
    //   126: getstatic 169	org/acra/ReportField:USER_COMMENT	Lorg/acra/ReportField;
    //   129: invokevirtual 1032	org/acra/CrashReportData:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload_2
    //   134: getstatic 118	org/acra/ReportingInteractionMode:SILENT	Lorg/acra/ReportingInteractionMode;
    //   137: if_acmpeq +25 -> 162
    //   140: aload_2
    //   141: getstatic 941	org/acra/ReportingInteractionMode:TOAST	Lorg/acra/ReportingInteractionMode;
    //   144: if_acmpeq +18 -> 162
    //   147: invokestatic 476	org/acra/ACRA:getACRASharedPreferences	()Landroid/content/SharedPreferences;
    //   150: ldc_w 1034
    //   153: iconst_0
    //   154: invokeinterface 510 3 0
    //   159: ifeq +112 -> 271
    //   162: aload_0
    //   163: invokevirtual 1036	org/acra/ErrorReporter:approvePendingReports	()V
    //   166: aload_1
    //   167: instanceof 1038
    //   170: ifne +85 -> 255
    //   173: new 963	org/acra/ErrorReporter$ReportsSenderWorker
    //   176: dup
    //   177: aload_0
    //   178: iload_3
    //   179: invokespecial 1041	org/acra/ErrorReporter$ReportsSenderWorker:<init>	(Lorg/acra/ErrorReporter;Z)V
    //   182: astore 11
    //   184: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   187: ldc_w 1043
    //   190: invokestatic 961	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   193: pop
    //   194: aload 11
    //   196: invokevirtual 969	org/acra/ErrorReporter$ReportsSenderWorker:start	()V
    //   199: aload 11
    //   201: astore 13
    //   203: aload 13
    //   205: areturn
    //   206: aload_2
    //   207: getstatic 118	org/acra/ReportingInteractionMode:SILENT	Lorg/acra/ReportingInteractionMode;
    //   210: if_acmpne +77 -> 287
    //   213: aload_0
    //   214: getfield 120	org/acra/ErrorReporter:mReportingInteractionMode	Lorg/acra/ReportingInteractionMode;
    //   217: getstatic 118	org/acra/ReportingInteractionMode:SILENT	Lorg/acra/ReportingInteractionMode;
    //   220: if_acmpeq +67 -> 287
    //   223: iconst_1
    //   224: istore_3
    //   225: goto -214 -> 11
    //   228: astore 6
    //   230: aload 5
    //   232: invokevirtual 793	java/io/FileOutputStream:close	()V
    //   235: aload 6
    //   237: athrow
    //   238: astore 7
    //   240: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   243: ldc_w 1045
    //   246: aload 7
    //   248: invokestatic 344	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   251: pop
    //   252: goto -139 -> 113
    //   255: getstatic 140	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   258: ldc_w 1047
    //   261: invokestatic 961	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   264: pop
    //   265: aconst_null
    //   266: astore 13
    //   268: goto -65 -> 203
    //   271: aload_2
    //   272: getstatic 944	org/acra/ReportingInteractionMode:NOTIFICATION	Lorg/acra/ReportingInteractionMode;
    //   275: if_acmpne -10 -> 265
    //   278: aload_0
    //   279: aload 4
    //   281: invokevirtual 982	org/acra/ErrorReporter:notifySendReport	(Ljava/lang/String;)V
    //   284: goto -19 -> 265
    //   287: iconst_0
    //   288: istore_3
    //   289: goto -278 -> 11
    //
    // Exception table:
    //   from	to	target	type
    //   71	78	228	finally
    //   54	71	238	java/lang/Exception
    //   78	113	238	java/lang/Exception
    //   230	238	238	java/lang/Exception
  }

  public Thread handleSilentException(Throwable paramThrowable)
  {
    if (enabled)
      mCrashProperties.put(ReportField.IS_SILENT, "true");
    for (ErrorReporter.ReportsSenderWorker localReportsSenderWorker = handleException(paramThrowable, ReportingInteractionMode.SILENT); ; localReportsSenderWorker = null)
    {
      return localReportsSenderWorker;
      Log.d(ACRA.LOG_TAG, "ACRA is disabled. Silent report not sent.");
    }
  }

  public void init(Context paramContext)
  {
    if (this.mDfltExceptionHandler == null)
    {
      this.mDfltExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      enabled = true;
      Thread.setDefaultUncaughtExceptionHandler(this);
      mContext = paramContext;
      this.mInitialConfiguration = ConfigurationInspector.toString(mContext.getResources().getConfiguration());
    }
  }

  void notifySendReport(String paramString)
  {
    NotificationManager localNotificationManager = (NotificationManager)mContext.getSystemService("notification");
    ReportsCrashes localReportsCrashes = ACRA.getConfig();
    Notification localNotification = new Notification(localReportsCrashes.resNotifIcon(), mContext.getText(localReportsCrashes.resNotifTickerText()), System.currentTimeMillis());
    CharSequence localCharSequence1 = mContext.getText(localReportsCrashes.resNotifTitle());
    CharSequence localCharSequence2 = mContext.getText(localReportsCrashes.resNotifText());
    Intent localIntent = new Intent(mContext, CrashReportDialog.class);
    Log.d(ACRA.LOG_TAG, "Creating Notification for " + paramString);
    localIntent.putExtra("REPORT_FILE_NAME", paramString);
    PendingIntent localPendingIntent = PendingIntent.getActivity(mContext, 0, localIntent, 134217728);
    localNotification.setLatestEventInfo(mContext, localCharSequence1, localCharSequence2, localPendingIntent);
    localNotificationManager.cancelAll();
    localNotificationManager.notify(666, localNotification);
  }

  public String putCustomData(String paramString1, String paramString2)
  {
    return (String)this.mCustomParameters.put(paramString1, paramString2);
  }

  public void registerActivity(String paramString)
  {
    if (paramString != null)
      activityLogger.append(paramString);
  }

  public void removeAllReportSenders()
  {
    mReportSenders.clear();
  }

  public String removeCustomData(String paramString)
  {
    return (String)this.mCustomParameters.remove(paramString);
  }

  public void removeReportSender(ReportSender paramReportSender)
  {
    mReportSenders.remove(paramReportSender);
  }

  public void removeReportSenders(Class<?> paramClass)
  {
    if (ReportSender.class.isAssignableFrom(paramClass))
    {
      Iterator localIterator = mReportSenders.iterator();
      while (localIterator.hasNext())
      {
        ReportSender localReportSender = (ReportSender)localIterator.next();
        if (!paramClass.isInstance(localReportSender))
          continue;
        mReportSenders.remove(localReportSender);
      }
    }
  }

  public void setAppStartDate(Time paramTime)
  {
    mCrashProperties.put(ReportField.USER_APP_START_DATE, paramTime.format3339(false));
  }

  public void setMaxReportSize(long paramLong)
  {
    mMaxReportSize = paramLong;
  }

  public void setReportSender(ReportSender paramReportSender)
  {
    removeAllReportSenders();
    addReportSender(paramReportSender);
  }

  void setReportingInteractionMode(ReportingInteractionMode paramReportingInteractionMode)
  {
    this.mReportingInteractionMode = paramReportingInteractionMode;
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Log.e(ACRA.LOG_TAG, "ACRA caught a " + paramThrowable.getClass().getSimpleName() + " exception for " + mContext.getPackageName() + ". Building report.");
    mCrashProperties.remove(ReportField.IS_SILENT);
    ErrorReporter.ReportsSenderWorker localReportsSenderWorker = handleException(paramThrowable);
    if (this.mReportingInteractionMode == ReportingInteractionMode.TOAST);
    try
    {
      Thread.sleep(4000L);
      if (localReportsSenderWorker != null)
        while (localReportsSenderWorker.isAlive())
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException1)
          {
            Log.e(ACRA.LOG_TAG, "Error : ", localInterruptedException1);
          }
    }
    catch (InterruptedException localInterruptedException2)
    {
      while (true)
        Log.e(ACRA.LOG_TAG, "Error : ", localInterruptedException2);
      if (this.mReportingInteractionMode == ReportingInteractionMode.SILENT)
        break label174;
    }
    if ((this.mReportingInteractionMode == ReportingInteractionMode.TOAST) && (ACRA.getConfig().forceCloseDialogAfterToast()))
      label174: this.mDfltExceptionHandler.uncaughtException(paramThread, paramThrowable);
    while (true)
    {
      return;
      Log.e(ACRA.LOG_TAG, mContext.getPackageName() + " fatal error: " + paramThrowable.getMessage(), paramThrowable);
      Process.killProcess(Process.myPid());
      System.exit(10);
    }
  }

  // ERROR //
  public void writeReportToStream(Throwable paramThrowable, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 1023	org/acra/ErrorReporter:gatherCrashData	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   6: aload_2
    //   7: invokevirtual 1197	java/io/OutputStream:close	()V
    //   10: goto +40 -> 50
    //   13: astore_3
    //   14: aload_2
    //   15: invokevirtual 1197	java/io/OutputStream:close	()V
    //   18: aload_3
    //   19: athrow
    //   20: astore 4
    //   22: ldc_w 314
    //   25: new 76	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 1199
    //   35: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload 4
    //   40: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 319	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	13	finally
    //   6	20	20	java/lang/Exception
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.ErrorReporter
 * JD-Core Version:    0.6.0
 */