package com.facebook.photos.analytics;

public enum PhotoFlowLogger$ComposerType
{
  static
  {
    PHOTO = new ComposerType("PHOTO", 1);
    CHECKIN = new ComposerType("CHECKIN", 2);
    UNKNOWN = new ComposerType("UNKNOWN", 3);
    ComposerType[] arrayOfComposerType = new ComposerType[4];
    arrayOfComposerType[0] = STATUS;
    arrayOfComposerType[1] = PHOTO;
    arrayOfComposerType[2] = CHECKIN;
    arrayOfComposerType[3] = UNKNOWN;
    $VALUES = arrayOfComposerType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.analytics.PhotoFlowLogger.ComposerType
 * JD-Core Version:    0.6.0
 */