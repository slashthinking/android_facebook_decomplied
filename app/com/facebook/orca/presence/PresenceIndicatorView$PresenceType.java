package com.facebook.orca.presence;

public enum PresenceIndicatorView$PresenceType
{
  static
  {
    NONE = new PresenceType("NONE", 2);
    PresenceType[] arrayOfPresenceType = new PresenceType[3];
    arrayOfPresenceType[0] = ONLINE;
    arrayOfPresenceType[1] = PUSHABLE;
    arrayOfPresenceType[2] = NONE;
    $VALUES = arrayOfPresenceType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.presence.PresenceIndicatorView.PresenceType
 * JD-Core Version:    0.6.0
 */