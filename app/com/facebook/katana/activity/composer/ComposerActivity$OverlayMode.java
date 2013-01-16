package com.facebook.katana.activity.composer;

 enum ComposerActivity$OverlayMode
{
  static
  {
    ALBUM_SELECTOR = new OverlayMode("ALBUM_SELECTOR", 1);
    TIME_SELECTOR = new OverlayMode("TIME_SELECTOR", 2);
    OverlayMode[] arrayOfOverlayMode = new OverlayMode[3];
    arrayOfOverlayMode[0] = AUDIENCE_SELECTOR;
    arrayOfOverlayMode[1] = ALBUM_SELECTOR;
    arrayOfOverlayMode[2] = TIME_SELECTOR;
    $VALUES = arrayOfOverlayMode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.OverlayMode
 * JD-Core Version:    0.6.0
 */