package android_src.mms.drm;

import android.net.Uri;
import android_src.drm.mobile1.DrmException;
import android_src.drm.mobile1.DrmRawContent;
import android_src.drm.mobile1.DrmRights;
import android_src.drm.mobile1.DrmRightsManager;
import java.io.ByteArrayInputStream;

public class DrmWrapper
{
  private DrmRights a;
  private final DrmRawContent b;
  private final Uri c;
  private final byte[] d;

  public DrmWrapper(String paramString, Uri paramUri, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramArrayOfByte == null))
      throw new IllegalArgumentException("Content-Type or data may not be null.");
    this.c = paramUri;
    this.d = paramArrayOfByte;
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    this.b = new DrmRawContent(localByteArrayInputStream, localByteArrayInputStream.available(), paramString);
    if (!a())
      a(paramArrayOfByte);
  }

  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new DrmException("Right data may not be null.");
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    this.a = DrmRightsManager.a().a(localByteArrayInputStream, paramArrayOfByte.length, "application/vnd.oma.drm.message");
  }

  public boolean a()
  {
    int i = 1;
    if (this.a != null);
    while (true)
    {
      return i;
      this.a = DrmRightsManager.a().a(this.b);
      if (this.a != null)
        continue;
      i = 0;
    }
  }

  public String b()
  {
    return this.b.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.drm.DrmWrapper
 * JD-Core Version:    0.6.0
 */