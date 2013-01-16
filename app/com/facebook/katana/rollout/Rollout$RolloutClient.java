package com.facebook.katana.rollout;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

 enum Rollout$RolloutClient
  implements ManagedDataStore.Client<String, String>
{
  private static int TTL;

  static
  {
    RolloutClient[] arrayOfRolloutClient = new RolloutClient[1];
    arrayOfRolloutClient[0] = INSTANCE;
    $VALUES = arrayOfRolloutClient;
    TTL = 3600;
  }

  public String deserialize(String paramString)
  {
    return paramString;
  }

  public int getCacheTtl(String paramString1, String paramString2)
  {
    return TTL;
  }

  public String getDiskKeyPrefix()
  {
    return Rollout.class.getSimpleName();
  }

  public String getDiskKeySuffix(String paramString)
  {
    return paramString;
  }

  public int getPersistentStoreTtl(String paramString1, String paramString2)
  {
    return TTL;
  }

  public void initiateNetworkRequest(Context paramContext, String paramString, NetworkRequestCallback<String, String> paramNetworkRequestCallback)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = Rollout.a.values().iterator();
    while (localIterator.hasNext())
      localHashSet.add((String)localIterator.next());
    FqlRolloutGetConditions.a(paramContext, localHashSet, paramNetworkRequestCallback);
  }

  public boolean staleDataAcceptable(String paramString1, String paramString2)
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.rollout.Rollout.RolloutClient
 * JD-Core Version:    0.6.0
 */