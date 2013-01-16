package com.facebook.orca.fbwebrtc;

import com.facebook.orca.annotations.IsVoipEnabledForUser;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class WebrtcModule extends AbstractModule
{
  protected void a()
  {
    a(Boolean.class).a(IsVoipEnabledForUser.class).c(IsVoipEnabledForUserProvider.class).a();
    a(WebrtcManager.class).a(new WebrtcModule.WebrtcManagerProvider(this, null)).a();
    a(WebrtcUiHandler.class).a(new WebrtcModule.WebrtcUiHandlerProvider(this, null)).a();
    a(WebrtcSignalingHandler.class).a(new WebrtcModule.WebrtcSignalingHandlerProvider(this, null)).a();
    a(WebrtcLoggingHandler.class).a(new WebrtcModule.WebrtcLoggingHandlerProvider(this, null)).a();
    a(WebrtcNotificationManager.class).a(new WebrtcModule.WebrtcNotificationManagerProvider(this, null)).a();
    a(WebrtcConfig.class).a(new WebrtcModule.WebrtcConfigProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcModule
 * JD-Core Version:    0.6.0
 */