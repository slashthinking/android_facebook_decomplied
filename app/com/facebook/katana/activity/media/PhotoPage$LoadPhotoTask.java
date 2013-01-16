package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Pair;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.activity.media.crop.CroppedImageGenerator;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.ui.ImageViewTouchBase;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageException;
import com.facebook.katana.util.ImageUtils.ImageOutOfMemoryException;

class PhotoPage$LoadPhotoTask extends AsyncTask<Object, Void, Pair<PhotoItem, Bitmap>>
{
  private PhotoPage$LoadPhotoTask(PhotoPage paramPhotoPage)
  {
  }

  protected Pair<PhotoItem, Bitmap> a(Object[] paramArrayOfObject)
  {
    PhotoItem localPhotoItem = (PhotoItem)paramArrayOfObject[0];
    try
    {
      Bitmap localBitmap2;
      if (localPhotoItem.i())
        localBitmap2 = CroppedImageGenerator.a(localPhotoItem, PhotoPage.a(this.a, PhotoPage.a(this.a)), PhotoPage.a(this.a, PhotoPage.b(this.a)));
      Bitmap localBitmap1;
      for (Object localObject2 = localBitmap2; ; localObject2 = localBitmap1)
      {
        localObject1 = localObject2;
        if (localObject1 == null)
          break;
        localPair = new Pair(localPhotoItem, localObject1);
        return localPair;
        localBitmap1 = ImageUtils.a(localPhotoItem.b(), PhotoPage.a(this.a, PhotoPage.a(this.a)), PhotoPage.a(this.a, PhotoPage.b(this.a)));
      }
    }
    catch (ImageUtils.ImageOutOfMemoryException localImageOutOfMemoryException)
    {
      while (true)
      {
        localImageOutOfMemoryException.printStackTrace();
        ErrorReporting.a(PhotoPage.c(), "image decode error", localImageOutOfMemoryException);
        localObject1 = null;
      }
    }
    catch (ImageUtils.ImageException localImageException)
    {
      while (true)
      {
        localImageException.printStackTrace();
        ErrorReporting.a(PhotoPage.c(), "ImageException", localImageException);
        Object localObject1 = null;
        continue;
        Pair localPair = null;
      }
    }
  }

  protected void a(Pair<PhotoItem, Bitmap> paramPair)
  {
    if (paramPair == null)
      return;
    ImageViewTouchBase localImageViewTouchBase = (ImageViewTouchBase)this.a.findViewById(2131297064);
    if (((PhotoItem)paramPair.first).i())
      PhotoPage.a(this.a, (Bitmap)paramPair.second, 0);
    while (true)
    {
      localImageViewTouchBase.setRecycler(new PhotoPage.LoadPhotoTask.1(this));
      if (PhotoPage.d(this.a).o() != null)
        PhotoPage.d(this.a).o().a(localImageViewTouchBase);
      PhotoPage.a(this.a, true);
      break;
      PhotoPage.a(this.a, (Bitmap)paramPair.second, PhotoPage.c(this.a).h());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoPage.LoadPhotoTask
 * JD-Core Version:    0.6.0
 */