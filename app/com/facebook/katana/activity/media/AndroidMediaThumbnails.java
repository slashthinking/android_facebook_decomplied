package com.facebook.katana.activity.media;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;

class AndroidMediaThumbnails
{
  public Bitmap a(ContentResolver paramContentResolver, long paramLong, int paramInt, boolean paramBoolean, BitmapFactory.Options paramOptions)
  {
    if (paramBoolean);
    for (Bitmap localBitmap = MediaStore.Images.Thumbnails.getThumbnail(paramContentResolver, paramLong, paramInt, paramOptions); ; localBitmap = MediaStore.Video.Thumbnails.getThumbnail(paramContentResolver, paramLong, paramInt, paramOptions))
      return localBitmap;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.AndroidMediaThumbnails
 * JD-Core Version:    0.6.0
 */