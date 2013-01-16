package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.model.FacebookSessionInfo;

 enum PostLoginSyncRequest$DataStoreClient
  implements ManagedDataStore.Client<PostLoginSyncRequest.None, PostLoginSyncRequest.None>
{
  static
  {
    DataStoreClient[] arrayOfDataStoreClient = new DataStoreClient[1];
    arrayOfDataStoreClient[0] = INSTANCE;
    $VALUES = arrayOfDataStoreClient;
  }

  public PostLoginSyncRequest.None deserialize(String paramString)
  {
    return PostLoginSyncRequest.None.INSTANCE;
  }

  public int getCacheTtl(PostLoginSyncRequest.None paramNone1, PostLoginSyncRequest.None paramNone2)
  {
    return 31536000;
  }

  public String getDiskKeyPrefix()
  {
    return PostLoginSyncRequest.class.getSimpleName();
  }

  public String getDiskKeySuffix(PostLoginSyncRequest.None paramNone)
  {
    return "loginSyncStoreKey";
  }

  public int getPersistentStoreTtl(PostLoginSyncRequest.None paramNone1, PostLoginSyncRequest.None paramNone2)
  {
    return 31536000;
  }

  public void initiateNetworkRequest(Context paramContext, PostLoginSyncRequest.None paramNone, NetworkRequestCallback<PostLoginSyncRequest.None, PostLoginSyncRequest.None> paramNetworkRequestCallback)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    while (true)
    {
      return;
      localAppSession.a(paramContext, new PostLoginSyncRequest.PostLoginMultiQuery(paramContext, localAppSession.b().sessionKey), 1001, 1020, null);
    }
  }

  public boolean staleDataAcceptable(PostLoginSyncRequest.None paramNone1, PostLoginSyncRequest.None paramNone2)
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PostLoginSyncRequest.DataStoreClient
 * JD-Core Version:    0.6.0
 */