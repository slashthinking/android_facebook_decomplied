package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Pair;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.util.BitmapCache;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageDecodeException;
import com.facebook.katana.util.ImageUtils.ImageOutOfMemoryException;

class PhotoSetGridAdapter$LoadBitmap extends AsyncTask<Long, Void, Pair<Long, Bitmap>>
{
  private PhotoSetGridAdapter$LoadBitmap(PhotoSetGridAdapter paramPhotoSetGridAdapter)
  {
  }

  protected Pair<Long, Bitmap> a(Long[] paramArrayOfLong)
  {
    long l = paramArrayOfLong[0].longValue();
    FacebookPhoto localFacebookPhoto = FacebookPhoto.a(this.a.getContext(), l);
    Pair localPair;
    if ((localFacebookPhoto == null) || (localFacebookPhoto.i() == null))
      localPair = null;
    while (true)
    {
      return localPair;
      try
      {
        Bitmap localBitmap = ImageUtils.b(localFacebookPhoto.i());
        localPair = new Pair(Long.valueOf(l), localBitmap);
      }
      catch (ImageUtils.ImageOutOfMemoryException localImageOutOfMemoryException)
      {
        ErrorReporting.a("photoset-grid", "Cannot decode bitmap: OOM", localImageOutOfMemoryException);
        localPair = null;
      }
      catch (ImageUtils.ImageDecodeException localImageDecodeException)
      {
        while (true)
          Log.a("photoset-grid", "cannot decode image", localImageDecodeException);
      }
    }
  }

  protected void a(Pair<Long, Bitmap> paramPair)
  {
    if (paramPair == null);
    while (true)
    {
      return;
      long l = ((Long)paramPair.first).longValue();
      Bitmap localBitmap = (Bitmap)paramPair.second;
      if (localBitmap == null)
        continue;
      PhotoSetGridAdapter.c(this.a).a(Long.valueOf(l), localBitmap);
      PhotoSetGridAdapter.a(this.a, l, localBitmap);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoSetGridAdapter.LoadBitmap
 * JD-Core Version:    0.6.0
 */