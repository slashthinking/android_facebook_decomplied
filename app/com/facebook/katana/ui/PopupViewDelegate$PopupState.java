package com.facebook.katana.ui;

public enum PopupViewDelegate$PopupState
{
  static
  {
    CLOSED = new PopupState("CLOSED", 3);
    PopupState[] arrayOfPopupState = new PopupState[4];
    arrayOfPopupState[0] = FRIEND_REQUESTS;
    arrayOfPopupState[1] = MESSAGES;
    arrayOfPopupState[2] = NOTIFICATIONS;
    arrayOfPopupState[3] = CLOSED;
    $VALUES = arrayOfPopupState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.PopupViewDelegate.PopupState
 * JD-Core Version:    0.6.0
 */