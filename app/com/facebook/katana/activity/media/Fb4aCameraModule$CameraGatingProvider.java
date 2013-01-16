package com.facebook.katana.activity.media;

import com.facebook.camera.support.CameraGating;
import com.facebook.katana.features.camera.CameraGatingHandler;
import com.facebook.orca.inject.AbstractProvider;

class Fb4aCameraModule$CameraGatingProvider extends AbstractProvider<CameraGating>
{
  private Fb4aCameraModule$CameraGatingProvider(Fb4aCameraModule paramFb4aCameraModule)
  {
  }

  public CameraGating a()
  {
    return new CameraGatingHandler();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aCameraModule.CameraGatingProvider
 * JD-Core Version:    0.6.0
 */