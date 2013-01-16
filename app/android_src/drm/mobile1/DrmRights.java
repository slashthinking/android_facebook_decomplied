package android_src.drm.mobile1;

import java.io.PrintStream;

public class DrmRights
{
  private String a = "";

  static
  {
    try
    {
      System.loadLibrary("drm1_jni");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (true)
        System.err.println("WARNING: Could not load libdrm1_jni.so");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.drm.mobile1.DrmRights
 * JD-Core Version:    0.6.0
 */