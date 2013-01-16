package com.facebook.katana.service.autoupdate;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class AutoUpdateModule extends AbstractModule
{
  protected void a()
  {
    a(AutoUpdateDownloader.class).a(new AutoUpdateModule.AutoUpdateDownloaderProvider(this, null));
    a(AutoUpdateNotifier.class).a(new AutoUpdateModule.AutoUpdateNotifierProvider(this, null));
    a(AutoUpdateServiceStarter.class).a(new AutoUpdateModule.AutoUpdateServiceStarterProvider(this, null));
    a(AppApiMethod.class).a(new AutoUpdateModule.AppApiMethodProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateModule
 * JD-Core Version:    0.6.0
 */