package com.facebook.feed.flyout;

public enum FlyoutClickSource
{
  static
  {
    MESSAGE = new FlyoutClickSource("MESSAGE", 1);
    FEEDBACK = new FlyoutClickSource("FEEDBACK", 2);
    SUFFIX = new FlyoutClickSource("SUFFIX", 3);
    SUBTITLE = new FlyoutClickSource("SUBTITLE", 4);
    FlyoutClickSource[] arrayOfFlyoutClickSource = new FlyoutClickSource[5];
    arrayOfFlyoutClickSource[0] = TITLE;
    arrayOfFlyoutClickSource[1] = MESSAGE;
    arrayOfFlyoutClickSource[2] = FEEDBACK;
    arrayOfFlyoutClickSource[3] = SUFFIX;
    arrayOfFlyoutClickSource[4] = SUBTITLE;
    $VALUES = arrayOfFlyoutClickSource;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FlyoutClickSource
 * JD-Core Version:    0.6.0
 */