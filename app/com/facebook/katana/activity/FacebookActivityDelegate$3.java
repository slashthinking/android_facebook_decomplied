package com.facebook.katana.activity;

import com.facebook.katana.service.method.MarkJewelSeen.Jewel;
import com.facebook.katana.ui.JewelTitleBar;
import com.facebook.katana.ui.PopupViewDelegate.OnStateChangedListener;
import com.facebook.katana.ui.PopupViewDelegate.PopupState;

class FacebookActivityDelegate$3
  implements PopupViewDelegate.OnStateChangedListener
{
  public void a(PopupViewDelegate.PopupState paramPopupState)
  {
    this.a.c().setActiveState(paramPopupState);
    switch (FacebookActivityDelegate.13.b[FacebookActivityDelegate.c(this.a).i().ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      FacebookActivityDelegate.a(this.a, MarkJewelSeen.Jewel.INBOX);
      continue;
      FacebookActivityDelegate.a(this.a, MarkJewelSeen.Jewel.NOTIFICATIONS);
      continue;
      FacebookActivityDelegate.a(this.a, MarkJewelSeen.Jewel.FRIEND_REQUESTS);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate.3
 * JD-Core Version:    0.6.0
 */