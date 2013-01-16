package com.facebook.timeline.page.hours;

public enum PageHours$Status
{
  static
  {
    CLOSED = new Status("CLOSED", 1);
    UNKNOWN = new Status("UNKNOWN", 2);
    Status[] arrayOfStatus = new Status[3];
    arrayOfStatus[0] = OPEN;
    arrayOfStatus[1] = CLOSED;
    arrayOfStatus[2] = UNKNOWN;
    $VALUES = arrayOfStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.page.hours.PageHours.Status
 * JD-Core Version:    0.6.0
 */