package com.facebook.katana.binding;

import android.content.Context;

public abstract interface ManagedDataStore$Client<K, V>
{
  public abstract V deserialize(String paramString);

  public abstract int getCacheTtl(K paramK, V paramV);

  public abstract String getDiskKeyPrefix();

  public abstract String getDiskKeySuffix(K paramK);

  public abstract int getPersistentStoreTtl(K paramK, V paramV);

  public abstract void initiateNetworkRequest(Context paramContext, K paramK, NetworkRequestCallback<K, V> paramNetworkRequestCallback);

  public abstract boolean staleDataAcceptable(K paramK, V paramV);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ManagedDataStore.Client
 * JD-Core Version:    0.6.0
 */