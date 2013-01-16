package com.facebook.timeline;

public enum TimelineHeaderData$InitializeState
{
  static
  {
    PRELIM_DATA = new InitializeState("PRELIM_DATA", 1);
    FINAL_DATA = new InitializeState("FINAL_DATA", 2);
    InitializeState[] arrayOfInitializeState = new InitializeState[3];
    arrayOfInitializeState[0] = UNINITIALIZED;
    arrayOfInitializeState[1] = PRELIM_DATA;
    arrayOfInitializeState[2] = FINAL_DATA;
    $VALUES = arrayOfInitializeState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderData.InitializeState
 * JD-Core Version:    0.6.0
 */