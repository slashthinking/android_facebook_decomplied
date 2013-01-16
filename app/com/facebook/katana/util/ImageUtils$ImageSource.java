package com.facebook.katana.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import java.io.InputStream;

class ImageUtils$ImageSource
{
  private final byte[] a;
  private final Uri b;

  ImageUtils$ImageSource(Uri paramUri)
  {
    this.a = null;
    this.b = paramUri;
  }

  ImageUtils$ImageSource(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.b = null;
  }

  Bitmap a(Context paramContext, BitmapFactory.Options paramOptions)
  {
    Object localObject2;
    if (this.a != null)
      localObject2 = BitmapFactory.decodeByteArray(this.a, 0, this.a.length, paramOptions);
    while (true)
    {
      return localObject2;
      InputStream localInputStream;
      if (this.b != null)
        localInputStream = paramContext.getContentResolver().openInputStream(this.b);
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, null, paramOptions);
        localObject2 = localBitmap;
        localInputStream.close();
      }
      finally
      {
        localInputStream.close();
      }
    }
  }

  BitmapFactory.Options a(Context paramContext)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    if (this.a != null)
      BitmapFactory.decodeByteArray(this.a, 0, this.a.length, localOptions);
    while (true)
    {
      return localOptions;
      if (this.b == null)
        break;
      InputStream localInputStream = paramContext.getContentResolver().openInputStream(this.b);
      BitmapFactory.decodeStream(localInputStream, null, localOptions);
      localInputStream.close();
    }
    throw new IllegalStateException("neither mData nor mUri are set");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.ImageUtils.ImageSource
 * JD-Core Version:    0.6.0
 */