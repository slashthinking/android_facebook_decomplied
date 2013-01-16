package com.facebook.appcenter.modules;

import com.facebook.appcenter.annotations.IsNativeAppCenterEnabled;
import com.facebook.appcenter.intent.AppCenterUriIntentBuilder;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppCenterUriIntentBuilderProvider extends AbstractProvider<AppCenterUriIntentBuilder>
{
  private AppCenterModule$AppCenterUriIntentBuilderProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppCenterUriIntentBuilder a()
  {
    return new AppCenterUriIntentBuilder(a(Boolean.class, IsNativeAppCenterEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterUriIntentBuilderProvider
 * JD-Core Version:    0.6.0
 */