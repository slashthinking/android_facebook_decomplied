package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.common.util.Log;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.HttpOperationListener;
import com.facebook.katana.net.HttpOperation.Method;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.facebook.katana.util.FacebookPlatform;
import com.facebook.katana.util.URLQueryBuilder;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class ApiMethod extends NetworkServiceOperation
{
  private static final Class<?> a = ApiMethod.class;
  private static final String b = a.getSimpleName();
  protected final String c;
  protected final String d;
  protected final Map<String, String> e = new TreeMap();

  protected ApiMethod(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener);
    this.c = paramString2;
    this.d = paramString3;
    this.m = new NetworkServiceOperation.NetworkServiceOperationHttpListener(this);
  }

  protected ApiMethod(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, ServiceOperationListener paramServiceOperationListener, HttpOperation.HttpOperationListener paramHttpOperationListener)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener);
    this.c = paramString2;
    this.d = paramString3;
    this.m = paramHttpOperationListener;
  }

  protected static String a(String paramString, char paramChar)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    for (int i = 0; i < paramString.length(); i++)
    {
      if (paramString.charAt(i) == paramChar)
        continue;
      localStringBuffer.append(paramString.charAt(i));
    }
    return localStringBuffer.toString();
  }

  public static boolean a(int paramInt, Exception paramException)
  {
    if ((paramException != null) && ((paramException instanceof FacebookApiException)) && (((FacebookApiException)paramException).a() == 102));
    for (int i = 1; ; i = 0)
      return i;
  }

  protected static JsonParser b(String paramString)
  {
    JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(paramString);
    FbJsonChecker.a(localJsonParser);
    return localJsonParser;
  }

  protected String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(paramString);
    StringBuilder localStringBuilder2 = e();
    String str2;
    if (localStringBuilder2.length() == 0)
    {
      String str1 = getClass().getName();
      if (b != str1)
      {
        StringBuffer localStringBuffer = new StringBuffer(b);
        localStringBuffer.append("(");
        localStringBuffer.append(str1);
        localStringBuffer.append(")");
        str2 = localStringBuffer.toString();
        Log.a(str2, "We always should have something in the query (e.g., the signature)");
      }
    }
    while (true)
    {
      return paramString;
      str2 = b;
      break;
      localStringBuilder1.append("?");
      localStringBuilder1.append(localStringBuilder2);
      paramString = localStringBuilder1.toString();
    }
  }

  protected void a(HttpOperation.ResponseInputStream paramResponseInputStream)
  {
    JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(paramResponseInputStream);
    FbJsonChecker.a(localJsonParser);
    a(localJsonParser);
  }

  protected void a(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    if (a())
      paramException = new FacebookApiException(102, "Invalid credentials");
    super.a(paramServiceOperation, paramInt, paramString, paramException);
  }

  protected void a(JsonParser paramJsonParser)
  {
  }

  public void a(boolean paramBoolean)
  {
    if (this.l != null)
    {
      this.l.a();
      if (paramBoolean)
        a(this, 0, null, null);
      this.l = null;
    }
  }

  protected boolean a()
  {
    return false;
  }

  public void b()
  {
    try
    {
      c();
      d();
      if (this.k.equals("GET"))
        this.l = new HttpOperation(this.o, HttpOperation.Method.GET, a(this.d), this.m, true);
      while (true)
      {
        this.l.b();
        break;
        if (!this.k.equals("POST"))
          continue;
        this.l = new HttpOperation(this.o, this.d, e().toString(), "application/x-www-form-urlencoded", this.m, true);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (this.q != null)
        this.q.a_(this, 0, null, localException);
    }
  }

  protected void c()
  {
    this.e.put("api_key", "882a8490361da98702bf97a021ddc14d");
    this.e.put("format", "JSON");
    this.e.put("method", this.c);
    this.e.put("v", "1.0");
    this.e.put("migrations_override", "{'empty_json': true}");
    this.e.put("return_ssl_resources", "0");
    this.e.put("locale", this.o.getResources().getConfiguration().locale.toString());
  }

  protected void d()
  {
    this.e.put("sig", FacebookPlatform.a(this.e, f()));
  }

  protected StringBuilder e()
  {
    return URLQueryBuilder.a(this.e);
  }

  protected String f()
  {
    return this.p.getStringExtra("ApiMethod.secret");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ApiMethod
 * JD-Core Version:    0.6.0
 */