package com.facebook.katana.features.camera;

import android.os.Build.VERSION;
import com.facebook.camera.device.CameraHolder;
import com.facebook.camera.support.CameraGating;
import com.facebook.katana.features.Gatekeeper;

public final class CameraGatingHandler extends CameraGating
{
  public boolean a()
  {
    Boolean localBoolean = Gatekeeper.a(this.a, "fbandroid_custom_camera");
    if (localBoolean != null);
    for (boolean bool = localBoolean.booleanValue(); ; bool = true)
      return bool;
  }

  public boolean b()
  {
    Boolean localBoolean = Gatekeeper.a(this.a, "fbandroid_custom_video_recorder");
    if (localBoolean != null);
    for (boolean bool = localBoolean.booleanValue(); ; bool = false)
      return bool;
  }

  public boolean c()
  {
    Boolean localBoolean = Gatekeeper.a(this.a, "fbandroid_custom_camera_shutter_sound");
    if (localBoolean != null);
    for (boolean bool = localBoolean.booleanValue(); ; bool = false)
      return bool;
  }

  public boolean d()
  {
    boolean bool1 = CameraHolder.m();
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      Boolean localBoolean = Gatekeeper.a(this.a, "fbandroid_face_detection");
      bool2 = false;
      if (localBoolean == null)
        continue;
      bool2 = localBoolean.booleanValue();
    }
  }

  public boolean e()
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT < 9);
    while (true)
    {
      return bool;
      Boolean localBoolean = Gatekeeper.a(this.a, "android_force_camera_in_landscape");
      if (localBoolean != null)
      {
        bool = localBoolean.booleanValue();
        continue;
      }
      if (Build.VERSION.SDK_INT < 14)
        continue;
      bool = false;
    }
  }

  public boolean f()
  {
    Boolean localBoolean = Gatekeeper.a(this.a, "android_rotate_portrait_front_facing_pictures");
    if (localBoolean != null);
    for (boolean bool = localBoolean.booleanValue(); ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.camera.CameraGatingHandler
 * JD-Core Version:    0.6.0
 */