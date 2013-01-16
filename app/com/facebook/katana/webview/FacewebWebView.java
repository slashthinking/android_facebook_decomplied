package com.facebook.katana.webview;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.webkit.WebSettings;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.UserAgent;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LogoutReason;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.WeakRef;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FacewebWebView extends FacebookWebView
{
  protected static Set<WeakRef<FacewebWebView>> f = new HashSet();
  private static final Class<?> n = FacewebWebView.class;
  protected FacewebComponentsStoreCache.Listener g;
  protected FacebookAuthentication.Callback h;
  protected FacewebWebView.FacewebWebViewListener i;
  protected boolean j;
  protected boolean k;
  protected FacewebWebView.PageState l = FacewebWebView.PageState.PAGE_STATE_UINITIALIZED;
  protected FacewebWebView.FacewebErrorType m;
  private boolean o = false;
  private List<FacewebPalCall> p = new ArrayList();
  private boolean q = false;
  private boolean r = false;

  protected FacewebWebView(Context paramContext, FacewebWebView.FacewebWebViewListener paramFacewebWebViewListener)
  {
    super(paramContext);
    l();
    this.i = paramFacewebWebViewListener;
    this.g = new FacewebWebView.7(this);
    this.j = true;
    this.k = false;
    setOnTouchListener(new FacewebWebView.8(this));
  }

  public static FacewebWebView a(Context paramContext, FacewebWebView.FacewebWebViewListener paramFacewebWebViewListener)
  {
    return new FacewebWebView(paramContext, paramFacewebWebViewListener);
  }

  protected static void a(FacewebWebView paramFacewebWebView)
  {
    synchronized (f)
    {
      f.add(new WeakRef(paramFacewebWebView));
      Log.d(n, "mRegisteredWebviews has " + f.size() + " items");
      return;
    }
  }

  protected static void b(FacewebWebView paramFacewebWebView)
  {
    synchronized (f)
    {
      f.remove(new WeakRef(paramFacewebWebView));
      Log.d(n, "mRegisteredWebviews has " + f.size() + " items");
      return;
    }
  }

  // ERROR //
  static List<FacewebWebView> getRegisteredFacewebWebViews()
  {
    // Byte code:
    //   0: new 48	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 49	java/util/ArrayList:<init>	()V
    //   7: astore_0
    //   8: getstatic 38	com/facebook/katana/webview/FacewebWebView:f	Ljava/util/Set;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: getstatic 38	com/facebook/katana/webview/FacewebWebView:f	Ljava/util/Set;
    //   17: invokeinterface 112 1 0
    //   22: istore_3
    //   23: getstatic 38	com/facebook/katana/webview/FacewebWebView:f	Ljava/util/Set;
    //   26: invokeinterface 142 1 0
    //   31: astore 4
    //   33: aload 4
    //   35: invokeinterface 148 1 0
    //   40: ifeq +53 -> 93
    //   43: aload 4
    //   45: invokeinterface 152 1 0
    //   50: checkcast 90	com/facebook/katana/util/WeakRef
    //   53: invokevirtual 155	com/facebook/katana/util/WeakRef:get	()Ljava/lang/Object;
    //   56: checkcast 2	com/facebook/katana/webview/FacewebWebView
    //   59: astore 5
    //   61: aload 5
    //   63: ifnonnull +18 -> 81
    //   66: aload 4
    //   68: invokeinterface 157 1 0
    //   73: goto -40 -> 33
    //   76: astore_2
    //   77: aload_1
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: aload_0
    //   82: aload 5
    //   84: invokeinterface 160 2 0
    //   89: pop
    //   90: goto -57 -> 33
    //   93: getstatic 40	com/facebook/katana/webview/FacewebWebView:n	Ljava/lang/Class;
    //   96: new 101	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   103: ldc 162
    //   105: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload_3
    //   109: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc 164
    //   114: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: getstatic 38	com/facebook/katana/webview/FacewebWebView:f	Ljava/util/Set;
    //   120: invokeinterface 112 1 0
    //   125: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc 117
    //   130: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 127	com/facebook/common/util/Log:d	(Ljava/lang/Class;Ljava/lang/String;)V
    //   139: aload_1
    //   140: monitorexit
    //   141: aload_0
    //   142: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   14	79	76	finally
    //   81	141	76	finally
  }

  private void l()
  {
    this.l = FacewebWebView.PageState.PAGE_STATE_UINITIALIZED;
    this.m = null;
  }

  protected void a(Context paramContext)
  {
    super.a(paramContext);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setUserAgentString(getBaseUserAgent() + " " + UserAgent.a(paramContext, Boolean.valueOf(true)));
    this.h = new FacewebWebView.2(this);
    setWebViewClient(new FacewebWebView.FacewebWebViewClient(this, paramContext, this.h));
    setWebChromeClient(new FacewebWebView.FacewebGeolocationWebChromeClient(this));
    Handler localHandler = new Handler();
    a("resetCache", new FacewebWebView.3(this, paramContext));
    a("startSyncFriends", new FacewebWebView.4(this));
    a("setRootVersion", new FacewebWebView.5(this));
    a("reloadCurrent", new FacewebWebView.6(this));
    a("broadcastScript", new FacewebWebView.BroadcastScriptHandler(this, localHandler));
  }

  protected void a(FacewebWebView.FacewebErrorType paramFacewebErrorType, AppSession.LogoutReason paramLogoutReason)
  {
    if (paramFacewebErrorType == FacewebWebView.FacewebErrorType.AUTHENTICATION_NETWORK_ERROR)
      Toaster.a(this.c, this.c.getString(paramFacewebErrorType.getErrorMessageId()));
    while (true)
    {
      return;
      if (paramFacewebErrorType == FacewebWebView.FacewebErrorType.AUTHENTICATION_ERROR)
      {
        AppSession localAppSession = AppSession.a(this.c, false);
        if (localAppSession == null)
          continue;
        localAppSession.b(this.c, paramLogoutReason);
        continue;
      }
    }
  }

  public void a(String paramString, boolean paramBoolean)
  {
    b(b(paramString), paramBoolean);
  }

  public String b(String paramString)
  {
    if (Constants.URL.b(paramString))
      paramString = Constants.URL.c(this.c, paramString);
    return paramString;
  }

  public void b()
  {
    b(this);
    this.i.a(FacewebWebView.PageState.PAGE_STATE_UINITIALIZED);
  }

  public void b(String paramString, boolean paramBoolean)
  {
    String str1 = IntentUriHandler.a(paramString);
    if (str1 == null);
    while (true)
    {
      return;
      l();
      String str2 = StringUtils.a(paramString);
      if (str2 != null)
      {
        this.e.a("FacewebPageNetworkLoad:" + str2);
        this.e.a("FacewebPageRPCLoadCompleted:" + str2);
      }
      if (paramBoolean)
        setMobilePage(str1);
      FacewebComponentsStoreCache.a(this.c, new FacewebWebView.1(this, str1));
      loadUrl(paramString);
    }
  }

  public void c()
  {
    l();
    a(Uri.parse(getMobilePage()).buildUpon().appendQueryParameter("fb4ar", Long.toString(System.currentTimeMillis() / 1000L)).build().toString(), false);
  }

  public void d()
  {
    l();
    super.reload();
  }

  public void destroy()
  {
    this.k = true;
    if (this.d)
    {
      AppSession localAppSession = AppSession.a(this.c, false);
      if ((localAppSession != null) && (!localAppSession.e()))
        localAppSession.e(this.c);
    }
    b(this);
    super.destroy();
  }

  public void e()
  {
    monitorenter;
    while (true)
    {
      try
      {
        boolean bool = this.o;
        if (!bool)
          return;
        Iterator localIterator = this.p.iterator();
        if (localIterator.hasNext())
        {
          FacewebPalCall localFacewebPalCall = (FacewebPalCall)localIterator.next();
          a(this.c, localFacewebPalCall);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      this.p.clear();
    }
  }

  public void f()
  {
    monitorenter;
    try
    {
      this.o = true;
      e();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void g()
  {
    a("(function(){try {if (window.fwHaveLoadedPage && fwHaveLoadedPage()) {return '1';}} catch (e) {return '0';}})()", new FacewebWebView.9(this));
  }

  protected void h()
  {
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
  }

  protected void i()
  {
    setVerticalScrollBarEnabled(true);
    setHorizontalScrollBarEnabled(true);
  }

  public boolean j()
  {
    return this.r;
  }

  public void loadUrl(String paramString)
  {
    if (!this.k)
      super.loadUrl(paramString);
  }

  public void setShouldCloseOnNavigatingAway(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView
 * JD-Core Version:    0.6.0
 */