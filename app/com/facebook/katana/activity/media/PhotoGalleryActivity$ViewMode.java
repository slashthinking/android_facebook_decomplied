package com.facebook.katana.activity.media;

 enum PhotoGalleryActivity$ViewMode
{
  static
  {
    CONTROLS = new ViewMode("CONTROLS", 1);
    EDIT_CAPTION = new ViewMode("EDIT_CAPTION", 2);
    ViewMode[] arrayOfViewMode = new ViewMode[3];
    arrayOfViewMode[0] = DEFAULT;
    arrayOfViewMode[1] = CONTROLS;
    arrayOfViewMode[2] = EDIT_CAPTION;
    $VALUES = arrayOfViewMode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.ViewMode
 * JD-Core Version:    0.6.0
 */