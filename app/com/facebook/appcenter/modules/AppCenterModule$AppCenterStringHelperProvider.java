package com.facebook.appcenter.modules;

import android.content.res.Resources;
import com.facebook.appcenter.util.SocialTextStringGenerator;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppCenterStringHelperProvider extends AbstractProvider<SocialTextStringGenerator>
{
  private AppCenterModule$AppCenterStringHelperProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public SocialTextStringGenerator a()
  {
    return new SocialTextStringGenerator((Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterStringHelperProvider
 * JD-Core Version:    0.6.0
 */