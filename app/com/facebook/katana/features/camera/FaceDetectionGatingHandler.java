package com.facebook.katana.features.camera;

import android.content.Context;
import com.facebook.facedetection.FaceDetectionGating;
import com.facebook.katana.features.Gatekeeper;

public final class FaceDetectionGatingHandler
  implements FaceDetectionGating
{
  public boolean a(Context paramContext)
  {
    Boolean localBoolean = Gatekeeper.a(paramContext, "android_native_face_detector");
    if (localBoolean != null);
    for (boolean bool = localBoolean.booleanValue(); ; bool = true)
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.camera.FaceDetectionGatingHandler
 * JD-Core Version:    0.6.0
 */