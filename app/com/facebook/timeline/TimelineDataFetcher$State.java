package com.facebook.timeline;

 enum TimelineDataFetcher$State
{
  static
  {
    PAUSED = new State("PAUSED", 1);
    CANCELLED = new State("CANCELLED", 2);
    REFRESH_UNITS = new State("REFRESH_UNITS", 3);
    State[] arrayOfState = new State[4];
    arrayOfState[0] = VISIBLE;
    arrayOfState[1] = PAUSED;
    arrayOfState[2] = CANCELLED;
    arrayOfState[3] = REFRESH_UNITS;
    $VALUES = arrayOfState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineDataFetcher.State
 * JD-Core Version:    0.6.0
 */