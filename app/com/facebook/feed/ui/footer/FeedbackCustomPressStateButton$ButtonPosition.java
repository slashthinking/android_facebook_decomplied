package com.facebook.feed.ui.footer;

public enum FeedbackCustomPressStateButton$ButtonPosition
{
  public final int newsfeedShadowResId;
  public final int substoryShadowResId;

  static
  {
    ButtonPosition[] arrayOfButtonPosition = new ButtonPosition[4];
    arrayOfButtonPosition[0] = LEFT;
    arrayOfButtonPosition[1] = MIDDLE;
    arrayOfButtonPosition[2] = RIGHT;
    arrayOfButtonPosition[3] = WHOLE;
    $VALUES = arrayOfButtonPosition;
  }

  private FeedbackCustomPressStateButton$ButtonPosition(int paramInt1, int paramInt2)
  {
    this.newsfeedShadowResId = paramInt1;
    this.substoryShadowResId = paramInt2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.FeedbackCustomPressStateButton.ButtonPosition
 * JD-Core Version:    0.6.0
 */