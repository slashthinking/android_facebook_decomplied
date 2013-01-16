package com.facebook.photos.photogallery;

public enum Photo$PhotoSize
{
  static
  {
    SCREENNAIL = new PhotoSize("SCREENNAIL", 1);
    PhotoSize[] arrayOfPhotoSize = new PhotoSize[2];
    arrayOfPhotoSize[0] = THUMBNAIL;
    arrayOfPhotoSize[1] = SCREENNAIL;
    $VALUES = arrayOfPhotoSize;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.Photo.PhotoSize
 * JD-Core Version:    0.6.0
 */