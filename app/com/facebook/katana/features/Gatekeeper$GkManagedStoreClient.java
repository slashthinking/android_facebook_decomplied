package com.facebook.katana.features;

import android.content.Context;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.service.method.FqlGetGatekeeperSettings;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

 enum Gatekeeper$GkManagedStoreClient
  implements ManagedDataStore.Client<String, Boolean>
{
  private static final Set<String> HOURLY_UPDATED_PROJECTS;
  private static final String STORE_TAG;

  static
  {
    GkManagedStoreClient[] arrayOfGkManagedStoreClient = new GkManagedStoreClient[1];
    arrayOfGkManagedStoreClient[0] = INSTANCE;
    $VALUES = arrayOfGkManagedStoreClient;
    STORE_TAG = Gatekeeper.class.getSimpleName();
    HOURLY_UPDATED_PROJECTS = getHourlyUpdatedProjects(Gatekeeper.b);
  }

  private static Set<String> getHourlyUpdatedProjects(Map<String, Gatekeeper.Settings> paramMap)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Gatekeeper.Settings localSettings = (Gatekeeper.Settings)localEntry.getValue();
      if ((localSettings.a != Gatekeeper.CachePolicy.CACHE_1HOUR) || (localSettings.b != Gatekeeper.CachePolicy.CACHE_1HOUR))
        continue;
      localHashSet.add(localEntry.getKey());
    }
    return localHashSet;
  }

  public Boolean deserialize(String paramString)
  {
    return Boolean.valueOf(paramString);
  }

  public int getCacheTtl(String paramString, Boolean paramBoolean)
  {
    Gatekeeper.Settings localSettings = (Gatekeeper.Settings)Gatekeeper.b.get(paramString);
    if (localSettings == null)
      Log.a(STORE_TAG, "received a request for an unknown project: " + paramString);
    for (int i = 0; ; i = mapPolicyToTtl(localSettings.a, paramBoolean))
      return i;
  }

  public String getDiskKeyPrefix()
  {
    return Gatekeeper.class.getSimpleName();
  }

  public String getDiskKeySuffix(String paramString)
  {
    return paramString;
  }

  public int getPersistentStoreTtl(String paramString, Boolean paramBoolean)
  {
    Gatekeeper.Settings localSettings = (Gatekeeper.Settings)Gatekeeper.b.get(paramString);
    if (localSettings == null)
      Log.a(STORE_TAG, "received a request for an unknown project: " + paramString);
    for (int i = 0; ; i = mapPolicyToTtl(localSettings.b, paramBoolean))
      return i;
  }

  public void initiateNetworkRequest(Context paramContext, String paramString, NetworkRequestCallback<String, Boolean> paramNetworkRequestCallback)
  {
    Object localObject;
    if (HOURLY_UPDATED_PROJECTS.contains(paramString))
      localObject = HOURLY_UPDATED_PROJECTS;
    while (true)
    {
      FqlGetGatekeeperSettings.a(paramContext, (Set)localObject, paramNetworkRequestCallback);
      return;
      localObject = new HashSet();
      ((Set)localObject).add(paramString);
    }
  }

  protected int mapPolicyToTtl(Gatekeeper.CachePolicy paramCachePolicy, Boolean paramBoolean)
  {
    if (((paramCachePolicy.mCacheIfTrue) && (paramBoolean.booleanValue() == true)) || ((paramCachePolicy.mCacheIfFalse) && (!paramBoolean.booleanValue())));
    for (int i = 31536000; ; i = paramCachePolicy.mFallbackTtl)
      return i;
  }

  public boolean staleDataAcceptable(String paramString, Boolean paramBoolean)
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.Gatekeeper.GkManagedStoreClient
 * JD-Core Version:    0.6.0
 */