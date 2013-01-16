package com.facebook.katana.features;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.ClearType;
import com.facebook.katana.binding.ManagedDataStore.Expirer;

public class Gatekeeper$Expirer
  implements ManagedDataStore.Expirer
{
  public void a(Context paramContext)
  {
    Gatekeeper.a(paramContext).b(ManagedDataStore.ClearType.CLEAR_ALL);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.Gatekeeper.Expirer
 * JD-Core Version:    0.6.0
 */