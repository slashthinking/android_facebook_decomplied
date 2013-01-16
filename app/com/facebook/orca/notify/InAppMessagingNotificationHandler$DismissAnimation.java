package com.facebook.orca.notify;

 enum InAppMessagingNotificationHandler$DismissAnimation
{
  static
  {
    FADE_OUT = new DismissAnimation("FADE_OUT", 2);
    DismissAnimation[] arrayOfDismissAnimation = new DismissAnimation[3];
    arrayOfDismissAnimation[0] = NONE;
    arrayOfDismissAnimation[1] = SLIDE_OUT;
    arrayOfDismissAnimation[2] = FADE_OUT;
    $VALUES = arrayOfDismissAnimation;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.InAppMessagingNotificationHandler.DismissAnimation
 * JD-Core Version:    0.6.0
 */