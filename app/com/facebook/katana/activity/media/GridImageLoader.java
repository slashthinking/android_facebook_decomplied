package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import com.facebook.katana.activity.media.crop.CropInfo;
import com.facebook.katana.activity.media.crop.CroppedImageGenerator;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageDecodeException;
import com.facebook.katana.util.ImageUtils.ImageIOException;
import com.facebook.katana.util.ImageUtils.ImageOutOfMemoryException;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.images.ImageCacheKey;
import com.facebook.photos.photogallery.Photo.PhotoSize;
import com.facebook.photos.photogallery.photos.LocalPhoto;

public class GridImageLoader
{
  private static String a = "GridImageThumbnails";
  private AndroidMediaThumbnails b;
  private int c;
  private int d;
  private ImageCache e;
  private Context f;
  private LocalPhoto g;

  GridImageLoader(Context paramContext, AndroidMediaThumbnails paramAndroidMediaThumbnails, ImageCache paramImageCache)
  {
    this.b = paramAndroidMediaThumbnails;
    this.f = paramContext;
    this.e = paramImageCache;
    this.c = paramContext.getResources().getDimensionPixelSize(2131230926);
    this.d = paramContext.getResources().getDimensionPixelSize(2131230926);
    this.g = new LocalPhoto();
  }

  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt != 0)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    }
    return paramBitmap;
  }

  private ImageCacheKey a(Uri paramUri, CropInfo paramCropInfo)
  {
    return new ImageCacheKey(paramUri, ImageCacheKey.c, paramCropInfo.toString() + a);
  }

  private ImageCacheKey b(BitmapHolder paramBitmapHolder)
  {
    Uri localUri = Uri.parse(paramBitmapHolder.c().b());
    ImageCacheKey localImageCacheKey;
    if (paramBitmapHolder.c().e() == MediaItem.MediaType.PHOTO)
      if (((PhotoItem)paramBitmapHolder.c()).i())
        localImageCacheKey = a(localUri, ((PhotoItem)(PhotoItem)paramBitmapHolder.c()).j());
    while (true)
    {
      return localImageCacheKey;
      MediaItem localMediaItem = paramBitmapHolder.c();
      if ((localMediaItem instanceof PhotoItem));
      for (int i = ((PhotoItem)localMediaItem).h(); ; i = 0)
      {
        this.g.a(localMediaItem.b());
        this.g.a(i);
        localImageCacheKey = this.g.a(Photo.PhotoSize.THUMBNAIL).d();
        break;
      }
      localImageCacheKey = new ImageCacheKey(localUri, ImageCacheKey.c, a);
    }
  }

  private void c(BitmapHolder paramBitmapHolder)
  {
    ImageCacheKey localImageCacheKey = b(paramBitmapHolder);
    try
    {
      Bitmap localBitmap2 = (Bitmap)this.e.e(localImageCacheKey);
      localObject = localBitmap2;
      if (paramBitmapHolder.c().e() == MediaItem.MediaType.PHOTO)
      {
        i = 1;
        label39: if (localObject == null)
          if (i == 0)
            break label166;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      try
      {
        Object localObject;
        int i;
        if (((PhotoItem)paramBitmapHolder.c()).i())
          localObject = CroppedImageGenerator.a((PhotoItem)paramBitmapHolder.c(), this.c, this.d);
        while (true)
        {
          if (localObject != null)
            this.e.a(localImageCacheKey, localObject);
          paramBitmapHolder.a((Bitmap)localObject);
          return;
          localOutOfMemoryError1 = localOutOfMemoryError1;
          this.e.b();
          localObject = null;
          break;
          i = 0;
          break label39;
          localObject = ImageUtils.a(paramBitmapHolder.c().b(), this.c, this.d);
          localObject = a((Bitmap)localObject, ((PhotoItem)paramBitmapHolder.c()).h());
          continue;
          label166: BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inDither = true;
          localOptions.inSampleSize = 2;
          localOptions.inScaled = true;
          Bitmap localBitmap1 = this.b.a(this.f.getContentResolver(), paramBitmapHolder.c().a(), 1, false, localOptions);
          localObject = localBitmap1;
        }
      }
      catch (ImageUtils.ImageOutOfMemoryException localImageOutOfMemoryException)
      {
        while (true)
          this.e.b();
      }
      catch (ImageUtils.ImageDecodeException localImageDecodeException)
      {
        while (true)
          this.e.b();
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        while (true)
          this.e.b();
      }
      catch (ImageUtils.ImageIOException localImageIOException)
      {
        while (true)
          localImageIOException.printStackTrace();
      }
    }
  }

  void a()
  {
    this.e.b();
  }

  void a(BitmapHolder paramBitmapHolder)
  {
    monitorenter;
    try
    {
      if (!paramBitmapHolder.a())
        c(paramBitmapHolder);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.GridImageLoader
 * JD-Core Version:    0.6.0
 */