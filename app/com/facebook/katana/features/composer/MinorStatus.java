package com.facebook.katana.features.composer;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore;

public class MinorStatus
{
  protected static ManagedDataStore<Object, Boolean> a;

  public static Boolean a(Context paramContext)
  {
    return (Boolean)b(paramContext).a(null);
  }

  protected static ManagedDataStore<Object, Boolean> b(Context paramContext)
  {
    monitorenter;
    try
    {
      if (a == null)
        a = new ManagedDataStore(new MinorStatusClient(), paramContext);
      ManagedDataStore localManagedDataStore = a;
      monitorexit;
      return localManagedDataStore;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.MinorStatus
 * JD-Core Version:    0.6.0
 */