package com.facebook.orca.camera.gallery;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.orca.camera.Util;
import com.facebook.orca.debug.BLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class UriImage
  implements IImage
{
  private static final Class<?> a = UriImage.class;
  private final Uri b;
  private final IImageList c;
  private final ContentResolver d;

  UriImage(IImageList paramIImageList, ContentResolver paramContentResolver, Uri paramUri)
  {
    this.c = paramIImageList;
    this.d = paramContentResolver;
    this.b = paramUri;
  }

  private ParcelFileDescriptor e()
  {
    Object localObject;
    try
    {
      if (this.b.getScheme().equals("file"))
      {
        localObject = ParcelFileDescriptor.open(new File(this.b.getPath()), 268435456);
      }
      else
      {
        ParcelFileDescriptor localParcelFileDescriptor = this.d.openFileDescriptor(this.b, "r");
        localObject = localParcelFileDescriptor;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localObject = null;
    }
    return (ParcelFileDescriptor)localObject;
  }

  public Bitmap a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, true, false);
  }

  public Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramBoolean, false);
  }

  public Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      localObject = Util.a(paramInt1, paramInt2, e(), paramBoolean2);
      if ((localObject != null) && (paramBoolean1))
      {
        Bitmap localBitmap = Util.a((Bitmap)localObject, c());
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
      {
        BLog.e(a, "got exception decoding bitmap ", localException);
        Object localObject = null;
      }
    }
  }

  public Bitmap a(boolean paramBoolean)
  {
    return a(320, 196608, paramBoolean);
  }

  public String a()
  {
    return this.b.getPath();
  }

  public long b()
  {
    return 0L;
  }

  public int c()
  {
    try
    {
      boolean bool = this.b.getScheme().equals("file");
      i = 0;
      int j;
      if (bool)
      {
        j = new ExifInterface(this.b.getPath()).getAttributeInt("Orientation", 1);
        if (j != 3)
          break label53;
        i = 180;
      }
      while (true)
      {
        return i;
        label53: if (j == 6)
        {
          i = 90;
          continue;
        }
        i = 0;
        if (j != 8)
          continue;
        i = 270;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
        int i = 0;
    }
  }

  public String d()
  {
    return this.b.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.gallery.UriImage
 * JD-Core Version:    0.6.0
 */