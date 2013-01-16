package com.facebook.widget;

 enum UrlImage$CurrentMode
{
  static
  {
    LOADED_IMAGE = new CurrentMode("LOADED_IMAGE", 1);
    PROGRESS_BAR = new CurrentMode("PROGRESS_BAR", 2);
    CurrentMode[] arrayOfCurrentMode = new CurrentMode[3];
    arrayOfCurrentMode[0] = PLACEHOLDER;
    arrayOfCurrentMode[1] = LOADED_IMAGE;
    arrayOfCurrentMode[2] = PROGRESS_BAR;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.UrlImage.CurrentMode
 * JD-Core Version:    0.6.2
 */