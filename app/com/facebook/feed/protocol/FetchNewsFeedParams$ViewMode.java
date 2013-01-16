package com.facebook.feed.protocol;

public enum FetchNewsFeedParams$ViewMode
{
  public final String gqlModeName;

  static
  {
    FREEZE = new ViewMode("FREEZE", 2, "freeze");
    ViewMode[] arrayOfViewMode = new ViewMode[3];
    arrayOfViewMode[0] = NORMAL;
    arrayOfViewMode[1] = PREFETCH;
    arrayOfViewMode[2] = FREEZE;
    $VALUES = arrayOfViewMode;
  }

  private FetchNewsFeedParams$ViewMode(String paramString)
  {
    this.gqlModeName = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNewsFeedParams.ViewMode
 * JD-Core Version:    0.6.0
 */