package com.facebook.orca.notify;

public enum NewMessageNotification$PresenceLevel
{
  static
  {
    PresenceLevel[] arrayOfPresenceLevel = new PresenceLevel[4];
    arrayOfPresenceLevel[0] = IN_APP_ACTIVE_10S;
    arrayOfPresenceLevel[1] = IN_APP_ACTIVE_30S;
    arrayOfPresenceLevel[2] = IN_APP_IDLE;
    arrayOfPresenceLevel[3] = NOT_IN_APP;
    $VALUES = arrayOfPresenceLevel;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.NewMessageNotification.PresenceLevel
 * JD-Core Version:    0.6.0
 */