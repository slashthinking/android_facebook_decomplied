package com.facebook.orca.common.ui.widgets.listview;

public enum ScrollState$ScrollPosition
{
  static
  {
    MIDDLE = new ScrollPosition("MIDDLE", 2);
    ScrollPosition[] arrayOfScrollPosition = new ScrollPosition[3];
    arrayOfScrollPosition[0] = BOTTOM;
    arrayOfScrollPosition[1] = TOP;
    arrayOfScrollPosition[2] = MIDDLE;
    $VALUES = arrayOfScrollPosition;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.listview.ScrollState.ScrollPosition
 * JD-Core Version:    0.6.0
 */