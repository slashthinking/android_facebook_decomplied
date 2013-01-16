package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.katana.service.method.FacewebComponentsStoreFetcher;
import java.io.IOException;

class FacewebComponentsStoreCacheClient
  implements ManagedDataStore.Client<FacewebComponentsStoreCache.Key, FacewebComponentsStoreCache.Value>
{
  public FacewebComponentsStoreCache.Value a(String paramString)
  {
    try
    {
      localValue = new FacewebComponentsStoreCache.Value(FacewebComponentsStore.b(paramString));
      return localValue;
    }
    catch (IOException localIOException)
    {
      while (true)
        FacewebComponentsStoreCache.Value localValue = new FacewebComponentsStoreCache.Value(FacewebComponentsStoreCache.LoadError.DESERIALIZATION_ERROR, localIOException.getMessage());
    }
  }

  public String a(FacewebComponentsStoreCache.Key paramKey)
  {
    return paramKey.toString();
  }

  public void a(Context paramContext, FacewebComponentsStoreCache.Key paramKey, NetworkRequestCallback<FacewebComponentsStoreCache.Key, FacewebComponentsStoreCache.Value> paramNetworkRequestCallback)
  {
    monitorenter;
    try
    {
      AppSession localAppSession = AppSession.a(paramContext, false);
      if (localAppSession == null)
        paramNetworkRequestCallback.a(paramContext, false, paramKey, null, new FacewebComponentsStoreCache.Value(FacewebComponentsStoreCache.LoadError.NO_SESSION_ERROR, ""));
      while (true)
      {
        return;
        localAppSession.a(new FacewebComponentsStoreCacheClient.1(this, paramNetworkRequestCallback, paramContext, paramKey));
        FacewebComponentsStoreFetcher.a(paramContext);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean a(FacewebComponentsStoreCache.Key paramKey, FacewebComponentsStoreCache.Value paramValue)
  {
    return true;
  }

  public int b(FacewebComponentsStoreCache.Key paramKey, FacewebComponentsStoreCache.Value paramValue)
  {
    return 3600;
  }

  public int c(FacewebComponentsStoreCache.Key paramKey, FacewebComponentsStoreCache.Value paramValue)
  {
    return 3600;
  }

  public String getDiskKeyPrefix()
  {
    return FacewebComponentsStoreCache.class.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebComponentsStoreCacheClient
 * JD-Core Version:    0.6.0
 */