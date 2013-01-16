package com.facebook.katana.service;

 enum MediaUploadWorker$Type
{
  static
  {
    PLACES_SUGGESTION = new Type("PLACES_SUGGESTION", 2);
    Type[] arrayOfType = new Type[3];
    arrayOfType[0] = PHOTO;
    arrayOfType[1] = VIDEO;
    arrayOfType[2] = PLACES_SUGGESTION;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.MediaUploadWorker.Type
 * JD-Core Version:    0.6.0
 */