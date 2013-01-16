package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.common.util.Tuple;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.StringUtils.StringProcessor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class FacebookJsBridge
{
  protected static final StringUtils.StringProcessor a = new FacebookJsBridge.1();
  public final FacebookJsBridge.UriHandler b;
  protected final Class<?> c;
  protected final Map<String, Set<FacebookWebView.NativeCallHandler>> d;
  protected Map<String, Tuple<String, FacebookWebView.JsReturnHandler>> e;
  protected final AtomicInteger f;

  FacebookJsBridge(Class<?> paramClass)
  {
    this.c = paramClass;
    this.b = new FacebookJsBridge.UriHandler(this);
    this.d = new HashMap();
    this.e = new HashMap();
    this.f = new AtomicInteger();
    a("call_return", new FacebookJsBridge.NativeCallReturnHandler(this));
  }

  static String a(String paramString, List<?> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("(");
    StringUtils.a(localStringBuilder, ", ", a, new Object[] { paramList });
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }

  public String a(String paramString, FacebookWebView.JsReturnHandler paramJsReturnHandler)
  {
    String str = Integer.toString(this.f.getAndIncrement());
    monitorenter;
    try
    {
      this.e.put(str, new Tuple(paramString, paramJsReturnHandler));
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(String paramString, FacebookWebView.NativeCallHandler paramNativeCallHandler)
  {
    Object localObject = (Set)this.d.get(paramString);
    if (localObject == null)
    {
      localObject = new HashSet();
      this.d.put(paramString, localObject);
    }
    ((Set)localObject).add(paramNativeCallHandler);
  }

  public boolean a(Context paramContext, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    Set localSet = (Set)this.d.get(paramFacewebPalCall.a());
    if (localSet == null);
    for (int i = 0; ; i = 1)
    {
      return i;
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
        ((FacebookWebView.NativeCallHandler)localIterator.next()).a(paramContext, paramFacebookWebView, paramFacewebPalCall);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookJsBridge
 * JD-Core Version:    0.6.0
 */