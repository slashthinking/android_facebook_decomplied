package android_src.drm.mobile1;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class DrmRawContent
{
  private BufferedInputStream a;
  private int b;
  private int c = -1;
  private String d;
  private String e;
  private int f;

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

  public DrmRawContent(InputStream paramInputStream, int paramInt, String paramString)
  {
    this.a = new BufferedInputStream(paramInputStream, 1024);
    this.b = paramInt;
    int i;
    if ("application/vnd.oma.drm.message".equals(paramString))
      i = 1;
    while (paramInt <= 0)
    {
      throw new IllegalArgumentException("len must be > 0");
      if ("application/vnd.oma.drm.content".equals(paramString))
      {
        i = 2;
        continue;
      }
      throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_MESSAGE or DRM_MIMETYPE_CONTENT");
    }
    this.c = nativeConstructDrmContent(this.a, this.b, i);
    if (-1 == this.c)
      throw new DrmException("nativeConstructDrmContent() returned JNI_DRM_FAILURE");
    this.d = nativeGetRightsAddress();
    this.f = nativeGetDeliveryMethod();
    if (-1 == this.f)
      throw new DrmException("nativeGetDeliveryMethod() returned JNI_DRM_FAILURE");
    this.e = nativeGetContentType();
    if (this.e == null)
      throw new DrmException("nativeGetContentType() returned null");
  }

  private native int nativeConstructDrmContent(InputStream paramInputStream, int paramInt1, int paramInt2);

  private native String nativeGetContentType();

  private native int nativeGetDeliveryMethod();

  private native String nativeGetRightsAddress();

  public String a()
  {
    return this.e;
  }

  protected native void finalize();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.drm.mobile1.DrmRawContent
 * JD-Core Version:    0.6.0
 */