package com.facebook.widget;

public enum ListViewPreloader$PreloadType
{
  static
  {
    ALL_OFFSCREEN = new PreloadType("ALL_OFFSCREEN", 1);
    PreloadType[] arrayOfPreloadType = new PreloadType[2];
    arrayOfPreloadType[0] = ALL_ONSCREEN_AND_OFFSCREEN;
    arrayOfPreloadType[1] = ALL_OFFSCREEN;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ListViewPreloader.PreloadType
 * JD-Core Version:    0.6.2
 */