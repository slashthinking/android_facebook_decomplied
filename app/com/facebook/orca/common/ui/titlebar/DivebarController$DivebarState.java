package com.facebook.orca.common.ui.titlebar;

public enum DivebarController$DivebarState
{
  static
  {
    ANIMATING = new DivebarState("ANIMATING", 2);
    DivebarState[] arrayOfDivebarState = new DivebarState[3];
    arrayOfDivebarState[0] = CLOSED;
    arrayOfDivebarState[1] = OPENED;
    arrayOfDivebarState[2] = ANIMATING;
    $VALUES = arrayOfDivebarState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.DivebarController.DivebarState
 * JD-Core Version:    0.6.0
 */