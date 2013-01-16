package com.facebook.katana.activity.media;

import com.facebook.camera.support.CameraSupport;
import com.facebook.orca.inject.AbstractProvider;

class Fb4aCameraModule$CameraSupportProvider extends AbstractProvider<CameraSupport>
{
  private Fb4aCameraModule$CameraSupportProvider(Fb4aCameraModule paramFb4aCameraModule)
  {
  }

  public CameraSupport a()
  {
    return new Fb4aCameraSupport();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aCameraModule.CameraSupportProvider
 * JD-Core Version:    0.6.0
 */