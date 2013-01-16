package com.facebook.widget;

public enum ListViewPreloader$PreloadDirection
{
  static
  {
    CLOSEST_FIRST = new PreloadDirection("CLOSEST_FIRST", 1);
    PreloadDirection[] arrayOfPreloadDirection = new PreloadDirection[2];
    arrayOfPreloadDirection[0] = FURTHEST_FIRST;
    arrayOfPreloadDirection[1] = CLOSEST_FIRST;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ListViewPreloader.PreloadDirection
 * JD-Core Version:    0.6.2
 */