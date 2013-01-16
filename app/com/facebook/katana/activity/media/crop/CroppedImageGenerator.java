package com.facebook.katana.activity.media.crop;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.Dimension;
import com.facebook.katana.util.ImageUtils.ImageIOException;
import java.io.IOException;

public class CroppedImageGenerator
{
  public static Bitmap a(PhotoItem paramPhotoItem, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (!paramPhotoItem.i())
      localObject = ImageUtils.a(paramPhotoItem.b(), paramInt1, paramInt2);
    while (true)
    {
      return localObject;
      RectF localRectF = a(ImageUtils.a(paramPhotoItem.b()), paramPhotoItem.j(), paramPhotoItem.h());
      try
      {
        Rect localRect = a(localRectF);
        Bitmap localBitmap = ImageUtils.a(Uri.parse(paramPhotoItem.b()), localRect, paramPhotoItem.h(), paramInt1, paramInt2, true);
        localObject = localBitmap;
      }
      catch (IOException localIOException)
      {
      }
    }
    throw new ImageUtils.ImageIOException(paramPhotoItem.b(), localIOException);
  }

  private static Rect a(RectF paramRectF)
  {
    return new Rect((int)paramRectF.left, (int)paramRectF.top, (int)paramRectF.right, (int)paramRectF.bottom);
  }

  static RectF a(ImageUtils.Dimension paramDimension, CropInfo paramCropInfo, int paramInt)
  {
    RectF localRectF = new RectF(0.0F, 0.0F, paramDimension.b, paramDimension.a);
    float[] arrayOfFloat = paramCropInfo.a();
    return CropDatabaseHelper.a(new RectF(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[5]), localRectF, -paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CroppedImageGenerator
 * JD-Core Version:    0.6.0
 */