package com.facebook.katana.service.autoupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.config.AppBuildInfo;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import java.io.File;
import java.util.List;

public class AutoUpdateNotifier
{
  private OrcaSharedPreferences a;
  private AppBuildInfo b;
  private FbErrorReporter c;

  public AutoUpdateNotifier(OrcaSharedPreferences paramOrcaSharedPreferences, AppBuildInfo paramAppBuildInfo, FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = paramAppBuildInfo;
    this.c = paramFbErrorReporter;
  }

  public static Intent a(Uri paramUri)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(paramUri, "application/vnd.android.package-archive");
    return localIntent;
  }

  // ERROR //
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 17	com/facebook/katana/service/autoupdate/AutoUpdateNotifier:a	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   8: getstatic 48	com/facebook/katana/service/autoupdate/AutoUpdateConstants:i	Lcom/facebook/orca/prefs/PrefKey;
    //   11: iconst_0
    //   12: invokeinterface 53 3 0
    //   17: istore 4
    //   19: iload 4
    //   21: ifeq +111 -> 132
    //   24: aload_0
    //   25: getfield 17	com/facebook/katana/service/autoupdate/AutoUpdateNotifier:a	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   28: getstatic 56	com/facebook/katana/service/autoupdate/AutoUpdateConstants:d	Lcom/facebook/orca/prefs/PrefKey;
    //   31: iconst_m1
    //   32: invokeinterface 59 3 0
    //   37: istore 16
    //   39: iload 16
    //   41: istore_2
    //   42: aload_0
    //   43: getfield 19	com/facebook/katana/service/autoupdate/AutoUpdateNotifier:b	Lcom/facebook/config/AppBuildInfo;
    //   46: invokeinterface 64 1 0
    //   51: istore 8
    //   53: aload_0
    //   54: getfield 17	com/facebook/katana/service/autoupdate/AutoUpdateNotifier:a	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   57: getstatic 67	com/facebook/katana/service/autoupdate/AutoUpdateConstants:g	Lcom/facebook/orca/prefs/PrefKey;
    //   60: aconst_null
    //   61: invokeinterface 70 3 0
    //   66: astore 9
    //   68: aload_0
    //   69: getfield 17	com/facebook/katana/service/autoupdate/AutoUpdateNotifier:a	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   72: getstatic 73	com/facebook/katana/service/autoupdate/AutoUpdateConstants:e	Lcom/facebook/orca/prefs/PrefKey;
    //   75: aconst_null
    //   76: invokeinterface 70 3 0
    //   81: astore 10
    //   83: aload 9
    //   85: ifnull +9 -> 94
    //   88: iload 8
    //   90: iload_2
    //   91: if_icmplt +114 -> 205
    //   94: aload_0
    //   95: getfield 17	com/facebook/katana/service/autoupdate/AutoUpdateNotifier:a	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   98: invokeinterface 76 1 0
    //   103: getstatic 48	com/facebook/katana/service/autoupdate/AutoUpdateConstants:i	Lcom/facebook/orca/prefs/PrefKey;
    //   106: invokeinterface 81 2 0
    //   111: getstatic 84	com/facebook/katana/service/autoupdate/AutoUpdateConstants:h	Lcom/facebook/orca/prefs/PrefKey;
    //   114: invokeinterface 81 2 0
    //   119: getstatic 67	com/facebook/katana/service/autoupdate/AutoUpdateConstants:g	Lcom/facebook/orca/prefs/PrefKey;
    //   122: invokeinterface 81 2 0
    //   127: invokeinterface 86 1 0
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: astore 5
    //   137: aload_0
    //   138: getfield 17	com/facebook/katana/service/autoupdate/AutoUpdateNotifier:a	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   141: getstatic 56	com/facebook/katana/service/autoupdate/AutoUpdateConstants:d	Lcom/facebook/orca/prefs/PrefKey;
    //   144: ldc 88
    //   146: invokeinterface 70 3 0
    //   151: astore 15
    //   153: aload 15
    //   155: astore 7
    //   157: aload_0
    //   158: getfield 21	com/facebook/katana/service/autoupdate/AutoUpdateNotifier:c	Lcom/facebook/common/util/FbErrorReporter;
    //   161: ldc 90
    //   163: new 92	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   170: ldc 95
    //   172: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 7
    //   177: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokeinterface 108 3 0
    //   188: goto -146 -> 42
    //   191: astore_3
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_3
    //   195: athrow
    //   196: astore 6
    //   198: ldc 110
    //   200: astore 7
    //   202: goto -45 -> 157
    //   205: new 24	android/content/Intent
    //   208: dup
    //   209: aload_1
    //   210: ldc 112
    //   212: invokespecial 115	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   215: astore 11
    //   217: aload 11
    //   219: ldc 117
    //   221: aload 9
    //   223: invokevirtual 121	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   226: pop
    //   227: aload 10
    //   229: ifnull +13 -> 242
    //   232: aload 11
    //   234: ldc 123
    //   236: aload 10
    //   238: invokevirtual 121	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   241: pop
    //   242: aload 11
    //   244: ldc 125
    //   246: aload_0
    //   247: getfield 17	com/facebook/katana/service/autoupdate/AutoUpdateNotifier:a	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   250: getstatic 84	com/facebook/katana/service/autoupdate/AutoUpdateConstants:h	Lcom/facebook/orca/prefs/PrefKey;
    //   253: iconst_0
    //   254: invokeinterface 53 3 0
    //   259: invokevirtual 128	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   262: pop
    //   263: aload_1
    //   264: aload 11
    //   266: invokevirtual 134	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   269: goto -137 -> 132
    //
    // Exception table:
    //   from	to	target	type
    //   24	39	135	java/lang/ClassCastException
    //   4	19	191	finally
    //   24	39	191	finally
    //   42	132	191	finally
    //   137	153	191	finally
    //   157	188	191	finally
    //   198	269	191	finally
    //   137	153	196	java/lang/Exception
  }

  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = a(Uri.fromFile(new File(paramString)));
    if (paramContext.getPackageManager().queryIntentActivities(localIntent, 0).size() == 0)
      this.c.a("AutoUpdateService", "Failed to find intent for build package", false);
  }

  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext, paramString);
    this.a.b().a(AutoUpdateConstants.i, true).a(AutoUpdateConstants.h, paramBoolean).a(AutoUpdateConstants.g, paramString).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateNotifier
 * JD-Core Version:    0.6.0
 */