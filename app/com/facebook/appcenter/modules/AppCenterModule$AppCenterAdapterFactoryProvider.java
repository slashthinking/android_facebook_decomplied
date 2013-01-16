package com.facebook.appcenter.modules;

import android.content.Context;
import com.facebook.appcenter.ui.AppCenterAdapterFactory;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppCenterAdapterFactoryProvider extends AbstractProvider<AppCenterAdapterFactory>
{
  private AppCenterModule$AppCenterAdapterFactoryProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppCenterAdapterFactory a()
  {
    return new AppCenterAdapterFactory((Context)b(Context.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterAdapterFactoryProvider
 * JD-Core Version:    0.6.0
 */