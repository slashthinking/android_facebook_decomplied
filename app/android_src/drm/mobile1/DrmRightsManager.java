package android_src.drm.mobile1;

import java.io.InputStream;
import java.io.PrintStream;

public class DrmRightsManager
{
  private static DrmRightsManager a = null;

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

  public static DrmRightsManager a()
  {
    monitorenter;
    try
    {
      if (a == null)
        a = new DrmRightsManager();
      DrmRightsManager localDrmRightsManager = a;
      monitorexit;
      return localDrmRightsManager;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private native int nativeInstallDrmRights(InputStream paramInputStream, int paramInt1, int paramInt2, DrmRights paramDrmRights);

  private native int nativeQueryRights(DrmRawContent paramDrmRawContent, DrmRights paramDrmRights);

  public DrmRights a(DrmRawContent paramDrmRawContent)
  {
    monitorenter;
    try
    {
      DrmRights localDrmRights = new DrmRights();
      int i = nativeQueryRights(paramDrmRawContent, localDrmRights);
      if (-1 == i)
        localDrmRights = null;
      monitorexit;
      return localDrmRights;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public DrmRights a(InputStream paramInputStream, int paramInt, String paramString)
  {
    monitorenter;
    int i;
    DrmRights localDrmRights;
    do
    {
      try
      {
        boolean bool = "application/vnd.oma.drm.rights+xml".equals(paramString);
        if (bool)
          i = 3;
        while (paramInt <= 0)
        {
          localDrmRights = null;
          return localDrmRights;
          if ("application/vnd.oma.drm.rights+wbxml".equals(paramString))
          {
            i = 4;
            continue;
          }
          if ("application/vnd.oma.drm.message".equals(paramString))
          {
            i = 1;
            continue;
          }
          throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_RIGHTS_XML or DRM_MIMETYPE_RIGHTS_WBXML or DRM_MIMETYPE_MESSAGE");
        }
      }
      finally
      {
        monitorexit;
      }
      localDrmRights = new DrmRights();
    }
    while (-1 != nativeInstallDrmRights(paramInputStream, paramInt, i, localDrmRights));
    throw new DrmException("nativeInstallDrmRights() returned JNI_DRM_FAILURE");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.drm.mobile1.DrmRightsManager
 * JD-Core Version:    0.6.0
 */