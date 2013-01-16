package com.facebook.photos.photogallery.photos;

import android.net.Uri;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCacheKey.Options;
import com.facebook.orca.images.ImageCacheKey.OptionsBuilder;
import com.facebook.photos.photogallery.Photo.PhotoSize;
import com.facebook.photos.photogallery.tags.Tag;
import com.facebook.photos.photogallery.tags.TaggedPhoto;
import java.util.List;

public class LocalPhoto extends TaggedPhoto
{
  private String a;
  private int b;

  public LocalPhoto()
  {
  }

  public LocalPhoto(long paramLong, List<Tag> paramList, String paramString, int paramInt)
  {
    super(paramLong, paramList);
    this.a = paramString;
    this.b = paramInt;
  }

  public FetchImageParams a(Photo.PhotoSize paramPhotoSize)
  {
    FetchImageParams localFetchImageParams;
    if (this.a == null)
    {
      localFetchImageParams = null;
      return localFetchImageParams;
    }
    ImageCacheKey.OptionsBuilder localOptionsBuilder = ImageCacheKey.Options.newBuilder();
    switch (LocalPhoto.1.a[paramPhotoSize.ordinal()])
    {
    default:
      throw new IllegalArgumentException("unknown size: " + paramPhotoSize);
    case 1:
      localOptionsBuilder.a(true);
    case 2:
    }
    for (LocalPhoto.LocalPhotoImageProcessor localLocalPhotoImageProcessor = new LocalPhoto.LocalPhotoImageProcessor(this.b, Photo.PhotoSize.SCREENNAIL); ; localLocalPhotoImageProcessor = new LocalPhoto.LocalPhotoImageProcessor(this.b, Photo.PhotoSize.THUMBNAIL))
    {
      ImageCacheKey.Options localOptions = localOptionsBuilder.d();
      localFetchImageParams = new FetchImageParams(Uri.parse("file://" + this.a), localLocalPhotoImageProcessor, localOptions);
      break;
      localOptionsBuilder.a(240, 240);
    }
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photos.LocalPhoto
 * JD-Core Version:    0.6.0
 */