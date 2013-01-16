package com.facebook.appcenter.modules;

import android.content.Context;
import com.facebook.appcenter.renderer.DefaultAppBrowseListRenderer;
import com.facebook.appcenter.renderer.IAppBrowseListRenderer;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppCenterBrowseRendererProvider extends AbstractProvider<IAppBrowseListRenderer>
{
  private AppCenterModule$AppCenterBrowseRendererProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public IAppBrowseListRenderer a()
  {
    return new DefaultAppBrowseListRenderer((Context)b(Context.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterBrowseRendererProvider
 * JD-Core Version:    0.6.0
 */