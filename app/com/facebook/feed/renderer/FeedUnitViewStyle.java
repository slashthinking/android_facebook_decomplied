package com.facebook.feed.renderer;

public enum FeedUnitViewStyle
{
  public final boolean allowTruncation;
  public final boolean includeFeedback;

  static
  {
    PERMALINK_STORY = new FeedUnitViewStyle("PERMALINK_STORY", 2, false, true);
    TIMELINE_STORY = new FeedUnitViewStyle("TIMELINE_STORY", 3, true, true);
    FeedUnitViewStyle[] arrayOfFeedUnitViewStyle = new FeedUnitViewStyle[4];
    arrayOfFeedUnitViewStyle[0] = NEWSFEED_STORY;
    arrayOfFeedUnitViewStyle[1] = SUBSTORY;
    arrayOfFeedUnitViewStyle[2] = PERMALINK_STORY;
    arrayOfFeedUnitViewStyle[3] = TIMELINE_STORY;
    $VALUES = arrayOfFeedUnitViewStyle;
  }

  private FeedUnitViewStyle(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.allowTruncation = paramBoolean1;
    this.includeFeedback = paramBoolean2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.FeedUnitViewStyle
 * JD-Core Version:    0.6.0
 */