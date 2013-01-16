package com.facebook.katana.util.logging;

public enum NotificationsLogger$Event
{
  static
  {
    ADD_TO_TRAY = new Event("ADD_TO_TRAY", 1);
    CLEAR_FROM_TRAY = new Event("CLEAR_FROM_TRAY", 2);
    CLICK_FROM_TRAY = new Event("CLICK_FROM_TRAY", 3);
    NOTIFICATION_CLICK = new Event("NOTIFICATION_CLICK", 4);
    JEWEL_CLICK = new Event("JEWEL_CLICK", 5);
    DROPPED_BY_INDIVIDUAL_SETTING = new Event("DROPPED_BY_INDIVIDUAL_SETTING", 6);
    DROPPED_BY_OVERALL_SETTING = new Event("DROPPED_BY_OVERALL_SETTING", 7);
    Event[] arrayOfEvent = new Event[8];
    arrayOfEvent[0] = PUSH_NOTIFICATION_RECEIVED;
    arrayOfEvent[1] = ADD_TO_TRAY;
    arrayOfEvent[2] = CLEAR_FROM_TRAY;
    arrayOfEvent[3] = CLICK_FROM_TRAY;
    arrayOfEvent[4] = NOTIFICATION_CLICK;
    arrayOfEvent[5] = JEWEL_CLICK;
    arrayOfEvent[6] = DROPPED_BY_INDIVIDUAL_SETTING;
    arrayOfEvent[7] = DROPPED_BY_OVERALL_SETTING;
    $VALUES = arrayOfEvent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.NotificationsLogger.Event
 * JD-Core Version:    0.6.0
 */