package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.orca.annotations.FromApplication;
import javax.inject.Inject;
import javax.inject.Provider;

public class FbandroidIsMobileAppDataEnabledProvider
  implements Provider<Boolean>
{
  private final ForceMessenger a;
  private final Context b;

  @Inject
  public FbandroidIsMobileAppDataEnabledProvider(@FromApplication Context paramContext, ForceMessenger paramForceMessenger)
  {
    this.b = paramContext;
    this.a = paramForceMessenger;
  }

  public Boolean a()
  {
    if ((this.a.b(this.b)) && (!ApplicationUtils.c(this.b)));
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidIsMobileAppDataEnabledProvider
 * JD-Core Version:    0.6.0
 */