package com.facebook.feed.ui.footer;

 enum FeedbackCustomPressStateButton$ButtonType
{
  public final int drawableIconId;
  public final int textStringId;

  static
  {
    COMMENT = new ButtonType("COMMENT", 1, 2130839006, 2131362077);
    SHARE = new ButtonType("SHARE", 2, 2130839009, 2131362078);
    ButtonType[] arrayOfButtonType = new ButtonType[3];
    arrayOfButtonType[0] = LIKE;
    arrayOfButtonType[1] = COMMENT;
    arrayOfButtonType[2] = SHARE;
    $VALUES = arrayOfButtonType;
  }

  private FeedbackCustomPressStateButton$ButtonType(int paramInt1, int paramInt2)
  {
    this.drawableIconId = paramInt1;
    this.textStringId = paramInt2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.FeedbackCustomPressStateButton.ButtonType
 * JD-Core Version:    0.6.0
 */