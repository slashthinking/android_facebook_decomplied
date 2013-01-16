package com.facebook.katana.service;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.LoggingProvider;
import com.facebook.orca.common.http.OrcaHttpClient;
import com.facebook.orca.inject.FbInjector;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class BackgroundRequestService extends IntentService
{
  private static final Class<?> a = BackgroundRequestService.class;
  private static final String b = a.getSimpleName();
  private PowerManager.WakeLock c;

  public BackgroundRequestService()
  {
    super(b);
  }

  private HttpRequestBase a(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("com.facebook.katana.service.BackgroundRequestService.data");
    String str2 = paramIntent.getStringExtra("com.facebook.katana.service.BackgroundRequestService.uri");
    try
    {
      localHttpPost = new HttpPost(str2);
    }
    catch (Exception localException2)
    {
      try
      {
        HttpPost localHttpPost;
        localHttpPost.setEntity(new StringEntity(str1));
        localHttpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        while (true)
        {
          label46: return localHttpPost;
          localException2 = localException2;
          localHttpPost = null;
        }
      }
      catch (Exception localException1)
      {
        break label46;
      }
    }
  }

  private void a()
  {
    monitorenter;
    try
    {
      if (this.c != null)
      {
        this.c.release();
        this.c = null;
      }
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

  private void a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (this.c == null)
      {
        this.c = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, getClass().getSimpleName());
        this.c.acquire();
      }
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

  private HttpRequestBase b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.facebook.katana.service.BackgroundRequestService.uri");
    try
    {
      localHttpGet = new HttpGet(str);
      return localHttpGet;
    }
    catch (Exception localException)
    {
      while (true)
        HttpGet localHttpGet = null;
    }
  }

  private void c(Intent paramIntent)
  {
    BackgroundRequestService.Operation localOperation = (BackgroundRequestService.Operation)paramIntent.getSerializableExtra("com.facebook.katana.service.BackgroundRequestService.operation");
    switch (BackgroundRequestService.1.a[localOperation.ordinal()])
    {
    default:
      return;
    case 1:
    case 2:
    }
    for (HttpRequestBase localHttpRequestBase = a(paramIntent); ; localHttpRequestBase = b(paramIntent))
    {
      try
      {
        OrcaHttpClient localOrcaHttpClient = (OrcaHttpClient)FbInjector.a(this).a(OrcaHttpClient.class);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localOrcaHttpClient.getConnectionManager(), localOrcaHttpClient.getParams());
        localDefaultHttpClient.removeRequestInterceptorByClass(RequestAddCookies.class);
        localDefaultHttpClient.removeResponseInterceptorByClass(ResponseProcessCookies.class);
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpRequestBase);
        int i = localHttpResponse.getStatusLine().getStatusCode();
        localHttpResponse.getEntity().consumeContent();
        if ((i != 200) || (localOperation != BackgroundRequestService.Operation.LOG))
          break;
        getContentResolver().delete(LoggingProvider.a, null, null);
      }
      catch (Exception localException)
      {
        Log.e(a, localException.toString());
      }
      break;
    }
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    a(this);
    try
    {
      c(paramIntent);
      return;
    }
    finally
    {
      a();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.BackgroundRequestService
 * JD-Core Version:    0.6.0
 */