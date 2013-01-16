package com.facebook.katana.service.vault.methods;

import android.content.Context;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import java.util.ArrayList;
import java.util.List;

class VaultBlacklistedSyncPathsGet$VaultBlacklistedSyncPathsStoreClient
  implements ManagedDataStore.Client<String, List<String>>
{
  public String a(String paramString)
  {
    return paramString;
  }

  public void a(Context paramContext, String paramString, NetworkRequestCallback<String, List<String>> paramNetworkRequestCallback)
  {
    VaultBlacklistedSyncPathsGet.a(paramContext);
  }

  public boolean a(String paramString, List<String> paramList)
  {
    return true;
  }

  public int b(String paramString, List<String> paramList)
  {
    return 1200;
  }

  public List<String> b(String paramString)
  {
    try
    {
      List localList = VaultBlacklistedSyncPathsGet.c(paramString);
      localObject = localList;
      if (localObject == null)
        localObject = new ArrayList();
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a(VaultBlacklistedSyncPathsGet.g(), localException.getMessage(), localException);
        Object localObject = null;
      }
    }
  }

  public int c(String paramString, List<String> paramList)
  {
    return b(paramString, paramList);
  }

  public String getDiskKeyPrefix()
  {
    return VaultBlacklistedSyncPathsGet.class.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultBlacklistedSyncPathsGet.VaultBlacklistedSyncPathsStoreClient
 * JD-Core Version:    0.6.0
 */