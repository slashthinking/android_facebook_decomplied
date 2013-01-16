package com.facebook.katana.platform;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class PlatformUtilitiesModule extends AbstractModule
{
  protected void a()
  {
    a(PlatformPackageUtilities.class).a(new PlatformUtilitiesModule.PlatformUtilitiesModuleProvider(this, null));
    a(AuthDialogActionExecutorFactory.class).a(new PlatformUtilitiesModule.AuthDialogActionHandlerFactoryProvider(this, null));
    a(ShareDialogActionExecutorFactory.class).a(new PlatformUtilitiesModule.ShareDialogActionExecutorFactoryProvider(this, null));
    a(ComposeDialogActionExecutorFactory.class).a(new PlatformUtilitiesModule.ComposeDialogActionExecutorFactoryProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformUtilitiesModule
 * JD-Core Version:    0.6.0
 */