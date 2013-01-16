package com.facebook.orca.telephone;

import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.orca.annotations.FromApplication;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsTelephonyAvailableProvider
  implements Provider<Boolean>
{
  private final Context a;

  @Inject
  public IsTelephonyAvailableProvider(@FromApplication Context paramContext)
  {
    this.a = paramContext;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.a.getPackageManager().hasSystemFeature("android.hardware.telephony"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.telephone.IsTelephonyAvailableProvider
 * JD-Core Version:    0.6.0
 */