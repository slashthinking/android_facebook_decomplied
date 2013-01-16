package com.facebook.facedetection;

import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;

class NativeFDCrashHandler$1
  implements Runnable
{
  NativeFDCrashHandler$1(NativeFDCrashHandler paramNativeFDCrashHandler)
  {
  }

  public void run()
  {
    long l = 86400000L + System.currentTimeMillis();
    NativeFDCrashHandler.a(this.a).b().a(FaceDetectionPrefKeys.b, l).a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.facedetection.NativeFDCrashHandler.1
 * JD-Core Version:    0.6.2
 */