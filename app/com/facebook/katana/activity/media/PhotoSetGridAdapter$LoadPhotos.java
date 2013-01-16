package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.util.BitmapCache;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageDecodeException;
import com.facebook.katana.util.ImageUtils.ImageOutOfMemoryException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class PhotoSetGridAdapter$LoadPhotos extends AsyncTask<Object, Void, Map<Long, Bitmap>>
{
  private PhotoSetGridAdapter$LoadPhotos(PhotoSetGridAdapter paramPhotoSetGridAdapter)
  {
  }

  protected Map<Long, Bitmap> a(Object[] paramArrayOfObject)
  {
    List localList = (List)paramArrayOfObject[0];
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      FacebookPhoto localFacebookPhoto = FacebookPhoto.a(this.a.getContext(), localLong.longValue());
      if (localFacebookPhoto == null)
        continue;
      if (localFacebookPhoto.i() == null)
      {
        if (PhotoSetGridAdapter.a(this.a, localLong.longValue()))
          continue;
        PhotoSetGridAdapter.a(this.a).a(this.a.getContext(), localFacebookPhoto);
        PhotoSetGridAdapter.b(this.a).add(localLong);
        continue;
      }
      if ((Bitmap)PhotoSetGridAdapter.c(this.a).a(localLong) != null)
        continue;
      try
      {
        Bitmap localBitmap = ImageUtils.b(localFacebookPhoto.i());
        PhotoSetGridAdapter.c(this.a).a(localLong, localBitmap);
        localHashMap.put(localLong, localBitmap);
      }
      catch (ImageUtils.ImageOutOfMemoryException localImageOutOfMemoryException)
      {
        ErrorReporting.a("photoset-grid", "Cannot decode bitmap: OOM", localImageOutOfMemoryException);
      }
      catch (ImageUtils.ImageDecodeException localImageDecodeException)
      {
        Log.a("photoset-grid", "cannot decode image", localImageDecodeException);
      }
    }
    return localHashMap;
  }

  protected void a(Map<Long, Bitmap> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        PhotoSetGridAdapter.a(this.a, ((Long)localEntry.getKey()).longValue(), (Bitmap)localEntry.getValue());
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoSetGridAdapter.LoadPhotos
 * JD-Core Version:    0.6.0
 */