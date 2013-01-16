package com.facebook.katana.service.vault;

import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.features.vault.VaultConstants;
import com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatus;
import com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatusMethod;
import com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatusParams;
import com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatusResult;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VaultImageStatusFetcher
{
  private static final String a = VaultImageStatusFetcher.class.getSimpleName();
  private final SingleMethodRunner b;
  private final VaultGetSyncedImageStatusMethod c;
  private final VaultConstants d;

  public VaultImageStatusFetcher(SingleMethodRunner paramSingleMethodRunner, VaultGetSyncedImageStatusMethod paramVaultGetSyncedImageStatusMethod, VaultConstants paramVaultConstants)
  {
    this.b = paramSingleMethodRunner;
    this.c = paramVaultGetSyncedImageStatusMethod;
    this.d = paramVaultConstants;
  }

  private Map<String, VaultGetSyncedImageStatus> b(Set<String> paramSet, long paramLong)
  {
    VaultGetSyncedImageStatusParams localVaultGetSyncedImageStatusParams = new VaultGetSyncedImageStatusParams(paramLong, paramSet, 0L);
    Maps.a();
    try
    {
      localMap = ((VaultGetSyncedImageStatusResult)this.b.a(this.c, localVaultGetSyncedImageStatusParams)).a();
      String str = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(localMap.size());
      Log.d(str, StringUtil.a("Found %d images that were already synced", arrayOfObject));
      return localMap;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a(a, localException);
        ErrorReporting.a("vault_local_image_status_api exception", localException.getMessage());
        Map localMap = Collections.emptyMap();
      }
    }
  }

  public Map<String, VaultGetSyncedImageStatus> a(Set<String> paramSet, long paramLong)
  {
    Object localObject;
    if ((paramSet == null) || (paramSet.size() == 0))
      localObject = Collections.emptyMap();
    while (true)
    {
      return localObject;
      HashSet localHashSet = new HashSet();
      if (paramSet.size() > this.d.a())
      {
        HashMap localHashMap = Maps.a();
        Iterator localIterator = paramSet.iterator();
        while (localIterator.hasNext())
        {
          localHashSet.add((String)localIterator.next());
          if (localHashSet.size() != this.d.a())
            continue;
          Log.e("dispatching a set of " + localHashSet.size() + " images");
          localHashMap.putAll(b(localHashSet, paramLong));
          localHashSet.clear();
        }
        if (localHashSet.size() > 0)
          localHashMap.putAll(b(localHashSet, paramLong));
        localObject = localHashMap;
        continue;
      }
      localObject = b(paramSet, paramLong);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultImageStatusFetcher
 * JD-Core Version:    0.6.0
 */