package com.facebook.katana.webview;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.common.util.Log;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.debug.Assert;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.util.FacebookPlatform;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.inject.FbInjector;
import java.util.HashSet;
import java.util.Set;

public class FacebookAuthentication
{
  public static final Class<?> a = FacebookAuthentication.class;
  protected static boolean b = true;
  protected static boolean c = false;
  protected static Set<FacebookAuthentication.Callback> d = new HashSet();
  private static WebView e;
  private static NetAccessLogger f = null;

  protected static Uri a(Uri paramUri)
  {
    return paramUri.buildUpon().scheme("http").query(null).fragment(null).build();
  }

  public static NetAccessLogger a(Context paramContext)
  {
    if (f == null)
      f = (NetAccessLogger)FbInjector.a(paramContext).a(NetAccessLogger.class);
    return f;
  }

  public static void a(Context paramContext, FacebookAuthentication.Callback paramCallback)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    monitorenter;
    if (paramCallback != null);
    try
    {
      d.add(paramCallback);
      if ((c) || (localAppSession == null))
      {
        monitorexit;
      }
      else
      {
        c = true;
        monitorexit;
        Log.e(a, "authenticated -> false");
        b = false;
        Assert.b(e);
        e = new BaseWebView(paramContext);
        e.getSettings().setJavaScriptEnabled(false);
        e.setWebViewClient(new FacebookAuthentication.FacewebAuthenticationWebViewClient(paramContext, Constants.URL.k(paramContext)));
        String str = FacebookPlatform.a(paramContext, Constants.URL.k(paramContext));
        e.loadUrl(str);
      }
    }
    finally
    {
      monitorexit;
    }
  }

  static boolean a(String paramString1, String paramString2)
  {
    Uri localUri = Uri.parse(paramString1);
    String str1 = localUri.getScheme();
    boolean bool2;
    if (!StringUtils.a(str1, "http"))
    {
      boolean bool4 = StringUtils.a(str1, "https");
      bool2 = false;
      if (bool4);
    }
    while (true)
    {
      return bool2;
      String str2 = localUri.getHost();
      boolean bool1 = str2.startsWith("m.");
      bool2 = false;
      if (!bool1)
        continue;
      boolean bool3 = str2.endsWith(".facebook.com");
      bool2 = false;
      if (!bool3)
        continue;
      bool2 = StringUtils.a(localUri.getPath(), paramString2);
    }
  }

  public static boolean matchUrlLiberally(String paramString1, String paramString2)
  {
    boolean bool1 = true;
    if (paramString1.equals(paramString2));
    while (true)
    {
      return bool1;
      Uri localUri1 = Uri.parse(paramString1);
      Uri localUri2 = Uri.parse(paramString2);
      String str1 = localUri1.getScheme();
      String str2 = localUri2.getScheme();
      boolean bool2;
      if ((StringUtils.a(str1, "http")) || (StringUtils.a(str1, "https")))
      {
        bool2 = bool1;
        label59: if ((!StringUtils.a(str2, "http")) && (!StringUtils.a(str2, "https")))
          break label109;
      }
      while (true)
      {
        if (((bool2) && (bool1)) || (StringUtils.a(str1, str2)))
          break label114;
        bool1 = false;
        break;
        bool2 = false;
        break label59;
        label109: bool1 = false;
      }
      label114: bool1 = a(localUri1).equals(a(localUri2));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookAuthentication
 * JD-Core Version:    0.6.0
 */