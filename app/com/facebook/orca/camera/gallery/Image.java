package com.facebook.orca.camera.gallery;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.orca.camera.Util;

public class Image extends BaseImage
  implements IImage
{
  private static final Class<?> i = BaseImage.class;
  private static final String[] k = { "_id" };
  private int j;

  public Image(BaseImageList paramBaseImageList, ContentResolver paramContentResolver, long paramLong1, int paramInt1, Uri paramUri, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, String paramString4, int paramInt2)
  {
    super(paramBaseImageList, paramContentResolver, paramLong1, paramInt1, paramUri, paramString1, paramLong2, paramString2, paramLong3, paramString3, paramString4);
    this.j = paramInt2;
  }

  public Bitmap a(boolean paramBoolean)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = false;
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap = MediaStore.Images.Thumbnails.getThumbnail(this.a, this.c, 1, localOptions);
    if ((localBitmap != null) && (paramBoolean))
      localBitmap = Util.a(localBitmap, c());
    return localBitmap;
  }

  public int c()
  {
    return this.j;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.gallery.Image
 * JD-Core Version:    0.6.0
 */