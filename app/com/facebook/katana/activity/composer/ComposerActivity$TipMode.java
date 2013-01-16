package com.facebook.katana.activity.composer;

 enum ComposerActivity$TipMode
{
  static
  {
    TAG_PHOTO_PLACE_TIP = new TipMode("TAG_PHOTO_PLACE_TIP", 2);
    TAG_PHOTOS_PLACE_TIP = new TipMode("TAG_PHOTOS_PLACE_TIP", 3);
    TAG_VIDEO_PLACE_TIP = new TipMode("TAG_VIDEO_PLACE_TIP", 4);
    TAG_EVENT_EDUCATION_TIP = new TipMode("TAG_EVENT_EDUCATION_TIP", 5);
    TipMode[] arrayOfTipMode = new TipMode[6];
    arrayOfTipMode[0] = NONE;
    arrayOfTipMode[1] = TAG_WITH_TIP;
    arrayOfTipMode[2] = TAG_PHOTO_PLACE_TIP;
    arrayOfTipMode[3] = TAG_PHOTOS_PLACE_TIP;
    arrayOfTipMode[4] = TAG_VIDEO_PLACE_TIP;
    arrayOfTipMode[5] = TAG_EVENT_EDUCATION_TIP;
    $VALUES = arrayOfTipMode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.TipMode
 * JD-Core Version:    0.6.0
 */