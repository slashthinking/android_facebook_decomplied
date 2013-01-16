package com.facebook.katana;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.facebook.common.util.ManifestReader;
import com.facebook.debug.Assert;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgent
{
  private static String a;

  public static String a()
  {
    return "FB4A";
  }

  public static String a(Context paramContext)
  {
    try
    {
      str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        String str = "unknown";
    }
  }

  public static String a(Context paramContext, Boolean paramBoolean)
  {
    return a(paramContext, paramBoolean, UserAgent.AppForegroundMode.None);
  }

  public static String a(Context paramContext, Boolean paramBoolean, UserAgent.AppForegroundMode paramAppForegroundMode)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (a == null)
    {
      a = new ManifestReader(paramContext).a("com.facebook.versioncontrol.branch");
      if (a == null)
        a = "";
    }
    localStringBuilder.append("[");
    Object[] arrayOfObject1 = new Object[8];
    arrayOfObject1[0] = "FBAN";
    arrayOfObject1[1] = a(a());
    arrayOfObject1[2] = "FBAV";
    arrayOfObject1[3] = a(a(paramContext));
    arrayOfObject1[4] = "FBDM";
    arrayOfObject1[5] = a(c(paramContext));
    arrayOfObject1[6] = "FBLC";
    arrayOfObject1[7] = a(e(paramContext));
    localStringBuilder.append(StringLocaleUtil.a("%s/%s;%s/%s;%s/%s;%s/%s;", arrayOfObject1));
    if (paramBoolean.booleanValue())
      localStringBuilder.append(StringLocaleUtil.a("%s/%s;", new Object[] { "FB_FW", "2" }));
    if ((FacebookAffiliation.b()) && (a.length() != 0))
    {
      Object[] arrayOfObject3 = new Object[4];
      arrayOfObject3[0] = "FBBR";
      arrayOfObject3[1] = a;
      arrayOfObject3[2] = "FBBV";
      arrayOfObject3[3] = Integer.valueOf(b(paramContext));
      localStringBuilder.append(StringLocaleUtil.a("%s/%s;%s/%s;", arrayOfObject3));
    }
    Object[] arrayOfObject2 = new Object[8];
    arrayOfObject2[0] = "FBCR";
    arrayOfObject2[1] = a(d(paramContext));
    arrayOfObject2[2] = "FBPN";
    arrayOfObject2[3] = paramContext.getPackageName();
    arrayOfObject2[4] = "FBDV";
    arrayOfObject2[5] = a(b());
    arrayOfObject2[6] = "FBSV";
    arrayOfObject2[7] = a(c());
    localStringBuilder.append(StringLocaleUtil.a("%s/%s;%s/%s;%s/%s;%s/%s;", arrayOfObject2));
    Assert.a(paramAppForegroundMode);
    if (paramAppForegroundMode != UserAgent.AppForegroundMode.None)
      localStringBuilder.append(StringLocaleUtil.a("%s/%s;", new Object[] { "FBBK", paramAppForegroundMode }));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  private static String a(String paramString)
  {
    return StringUtils.d(paramString).replace("/", "-").replace(";", "-");
  }

  public static int b(Context paramContext)
  {
    int i = 0;
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      label18: return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label18;
    }
  }

  public static String b()
  {
    return Build.MODEL;
  }

  public static String c()
  {
    return Build.VERSION.RELEASE;
  }

  public static String c(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    return "{density=" + localDisplayMetrics.density + ",width=" + localDisplayMetrics.widthPixels + ",height=" + localDisplayMetrics.heightPixels + "}";
  }

  public static String d(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
  }

  public static String e(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.toString();
  }

  public static String f(Context paramContext)
  {
    String str = e(paramContext);
    Matcher localMatcher = Pattern.compile("([^_]+)_([^_]+)_[^_]+").matcher(str);
    if (localMatcher.matches())
      str = localMatcher.group(1) + "_" + localMatcher.group(2);
    return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.UserAgent
 * JD-Core Version:    0.6.0
 */