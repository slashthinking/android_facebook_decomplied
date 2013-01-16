package com.facebook.orca.camera.gallery;

import android.content.ContentResolver;
import android.net.Uri;

public class SingleImageList
  implements IImageList
{
  private static final Class<?> a = BaseImageList.class;
  private IImage b;
  private Uri c;

  public SingleImageList(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.c = paramUri;
    this.b = new UriImage(this, paramContentResolver, paramUri);
  }

  public IImage a(int paramInt)
  {
    if (paramInt == 0);
    for (IImage localIImage = this.b; ; localIImage = null)
      return localIImage;
  }

  public IImage a(Uri paramUri)
  {
    if (paramUri.equals(this.c));
    for (IImage localIImage = this.b; ; localIImage = null)
      return localIImage;
  }

  public void a()
  {
    this.b = null;
    this.c = null;
  }

  public int b()
  {
    return 1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.gallery.SingleImageList
 * JD-Core Version:    0.6.0
 */