package com.facebook.katana.activity.events;

import android.content.DialogInterface;
import com.facebook.katana.AlertDialogs.MenuOption;
import com.facebook.katana.service.method.GraphEventCreate.PrivacyType;

class EventCreationActivity$EventPrivacyMenuOption extends AlertDialogs.MenuOption
{
  private int b;
  private int c;
  private GraphEventCreate.PrivacyType d;

  public EventCreationActivity$EventPrivacyMenuOption(EventCreationActivity paramEventCreationActivity, int paramInt1, int paramInt2, GraphEventCreate.PrivacyType paramPrivacyType)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramPrivacyType;
  }

  public int a()
  {
    return this.c;
  }

  public int b()
  {
    return this.b;
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EventCreationActivity.a(this.a, this.d);
    EventCreationActivity.a(this.a, EventCreationActivity.j(this.a), 0, this.b, this.a.getString(this.c));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.events.EventCreationActivity.EventPrivacyMenuOption
 * JD-Core Version:    0.6.0
 */