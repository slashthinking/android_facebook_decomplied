package com.facebook.zero;

import com.facebook.background.BackgroundTask;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.zero.annotations.IsZeroRatingFeatureEnabled;
import com.facebook.zero.annotations.ZeroTokenQueue;

public class ZeroModule extends AbstractModule
{
  protected void a()
  {
    a(ZeroTokenManager.class).a(new ZeroModule.ZeroTokenManagerProvider(this, null)).a();
    a(ZeroTokenHandler.class).a(new ZeroModule.ZeroTokenHandlerProvider(this, null));
    a(OrcaServiceHandler.class).a(ZeroTokenQueue.class).b(ZeroTokenHandler.class);
    a(ZeroValidateTokenBackgroundTask.class).a(new ZeroModule.ZeroValidateTokenBackgroundTaskProvider(this, null)).a();
    c(BackgroundTask.class).a(ZeroValidateTokenBackgroundTask.class);
    b(Boolean.class).a(IsZeroRatingFeatureEnabled.class).a(Boolean.valueOf(false));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.ZeroModule
 * JD-Core Version:    0.6.2
 */