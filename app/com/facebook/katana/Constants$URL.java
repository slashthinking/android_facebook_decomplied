package com.facebook.katana;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.facebook.base.BuildConstants;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.orca.common.util.StringUtil;

public class Constants$URL
{
  private static String a = "https://www.%s/impression.php";

  public static String a(Context paramContext, String paramString)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Constants.a(paramContext).getString("sandbox", "facebook.com");
    return StringUtil.a(paramString, arrayOfObject);
  }

  public static boolean a()
  {
    if (!"FB4A".equals("FB4A"));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(Context paramContext)
  {
    if (!Constants.a(paramContext).getString("sandbox", "facebook.com").equals("facebook.com"));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(Uri paramUri)
  {
    if ((b(paramUri)) && (paramUri.getPath().equals("/l.php")));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(String paramString)
  {
    if (StringUtil.a(paramString));
    for (boolean bool = false; ; bool = b(Uri.parse(paramString)))
      return bool;
  }

  public static String b(Context paramContext)
  {
    return a(paramContext, "https://api.%s/restserver.php");
  }

  public static String b(Context paramContext, String paramString)
  {
    String str1 = UserAgent.f(paramContext);
    Uri.Builder localBuilder = Uri.parse(a(paramContext, "http://m.%s/") + paramString).buildUpon();
    String str2 = Long.toString(350685531728L);
    if (a())
      str2 = "236820239731947";
    localBuilder.appendQueryParameter("cid", str2).build();
    localBuilder.appendQueryParameter("locale", str1);
    return localBuilder.build().toString();
  }

  public static boolean b(Uri paramUri)
  {
    int i = 0;
    if (paramUri != null)
    {
      String str = paramUri.getHost();
      i = 0;
      if (str != null)
      {
        boolean bool = str.endsWith(".facebook.com");
        i = 0;
        if (bool)
          i = 1;
      }
    }
    return i;
  }

  public static boolean b(String paramString)
  {
    if (paramString.startsWith("/"));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static String c(Context paramContext)
  {
    return a(paramContext, "https://api-read.%s/restserver.php");
  }

  public static String c(Context paramContext, String paramString)
  {
    Boolean localBoolean = Gatekeeper.a(paramContext, "android_fw_ssl");
    String str;
    StringBuilder localStringBuilder;
    if (Boolean.TRUE.equals(localBoolean))
    {
      str = "https://m.%s/";
      localStringBuilder = new StringBuilder(a(paramContext, str));
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramString.charAt(0) != '/')
          break label75;
        localStringBuilder.append(paramString, 1, paramString.length());
      }
    }
    while (true)
    {
      return localStringBuilder.toString();
      str = "http://m.%s/";
      break;
      label75: localStringBuilder.append(paramString);
    }
  }

  public static boolean c(String paramString)
  {
    if ((a(paramString)) && ((paramString.startsWith("http://m.")) || (paramString.startsWith("https://m."))));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static String d(Context paramContext)
  {
    return a(paramContext, "https://graph.%s/");
  }

  public static String d(String paramString)
  {
    String str = paramString.trim().toLowerCase();
    if (str.endsWith("."))
      str = str.substring(0, -1 + str.length());
    if (str.length() == 0)
      str = "facebook.com";
    while (true)
    {
      return str;
      if (str.endsWith("facebook.com"))
        continue;
      str = str + "." + "facebook.com";
    }
  }

  protected static String e(Context paramContext)
  {
    return a(paramContext, "https://m.%s/dialog/oauth");
  }

  public static String f(Context paramContext)
  {
    return a(paramContext, "https://api.%s/method/auth.extendSSOAccessToken");
  }

  public static String g(Context paramContext)
  {
    return a(paramContext, "https://api-video.%s/restserver.php");
  }

  public static String h(Context paramContext)
  {
    return a(paramContext, a);
  }

  public static String i(Context paramContext)
  {
    return a(paramContext, "https://api.%s/");
  }

  public static String j(Context paramContext)
  {
    return a(paramContext, "https://m.%s/promotion.php");
  }

  public static String k(Context paramContext)
  {
    return a(paramContext, "https://m.%s/root.php");
  }

  public static String l(Context paramContext)
  {
    return a(paramContext, "https://m.%s/auth.php");
  }

  public static String m(Context paramContext)
  {
    if (BuildConstants.a());
    for (String str = a(paramContext, "https://www.%s/mobile/android_beta_crash_logs/"); ; str = a(paramContext, "https://www.%s/mobile/android_crash_logs/"))
      return str;
  }

  public static String n(Context paramContext)
  {
    return a(paramContext, "http://m.%s/jp/kddi/ml/relay.php?state=i2p&android_app=1");
  }

  public static String o(Context paramContext)
  {
    return a(paramContext, "https://www.%s/invite_history.php");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.Constants.URL
 * JD-Core Version:    0.6.0
 */