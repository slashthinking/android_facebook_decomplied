package com.facebook.katana.activity.media;

import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.camera.support.CameraGating;
import com.facebook.camera.support.CameraSupport;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class Fb4aCameraModule extends AbstractModule
{
  protected void a()
  {
    a(CameraFlowLogger.class).a(new Fb4aCameraModule.CameraFlowLoggerProvider(this, null));
    a(CameraGating.class).a(new Fb4aCameraModule.CameraGatingProvider(this, null));
    a(CameraSupport.class).a(new Fb4aCameraModule.CameraSupportProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aCameraModule
 * JD-Core Version:    0.6.0
 */