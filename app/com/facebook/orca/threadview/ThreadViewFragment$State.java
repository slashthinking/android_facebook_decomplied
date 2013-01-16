package com.facebook.orca.threadview;

public enum ThreadViewFragment$State
{
  static
  {
    GROUP_CONTACTCARD = new State("GROUP_CONTACTCARD", 1);
    CONTACTCARD = new State("CONTACTCARD", 2);
    MAP = new State("MAP", 3);
    State[] arrayOfState = new State[4];
    arrayOfState[0] = MESSAGES;
    arrayOfState[1] = GROUP_CONTACTCARD;
    arrayOfState[2] = CONTACTCARD;
    arrayOfState[3] = MAP;
    $VALUES = arrayOfState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewFragment.State
 * JD-Core Version:    0.6.0
 */