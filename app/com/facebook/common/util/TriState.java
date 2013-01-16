package com.facebook.common.util;

public enum TriState
{
  static
  {
    NO = new TriState("NO", 1);
    UNSET = new TriState("UNSET", 2);
    TriState[] arrayOfTriState = new TriState[3];
    arrayOfTriState[0] = YES;
    arrayOfTriState[1] = NO;
    arrayOfTriState[2] = UNSET;
    $VALUES = arrayOfTriState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.TriState
 * JD-Core Version:    0.6.0
 */