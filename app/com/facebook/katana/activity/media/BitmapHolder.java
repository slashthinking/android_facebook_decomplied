package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import com.facebook.katana.model.MediaItem;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

class BitmapHolder
{
  private Reference<Bitmap> a;
  private MediaItem b;

  public BitmapHolder(MediaItem paramMediaItem)
  {
    this.b = paramMediaItem;
    this.a = null;
  }

  public void a(Bitmap paramBitmap)
  {
    this.a = new SoftReference(paramBitmap);
  }

  public boolean a()
  {
    if ((this.a != null) && (this.a.get() != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public Bitmap b()
  {
    if (this.a != null);
    for (Bitmap localBitmap = (Bitmap)this.a.get(); ; localBitmap = null)
      return localBitmap;
  }

  public MediaItem c()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.BitmapHolder
 * JD-Core Version:    0.6.0
 */