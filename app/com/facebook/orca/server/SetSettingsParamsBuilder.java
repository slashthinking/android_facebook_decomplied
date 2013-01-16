package com.facebook.orca.server;

import com.facebook.orca.notify.NotificationSetting;

public class SetSettingsParamsBuilder
{
  private boolean a;
  private NotificationSetting b;

  public SetSettingsParamsBuilder a(NotificationSetting paramNotificationSetting)
  {
    this.b = paramNotificationSetting;
    return this;
  }

  public SetSettingsParamsBuilder a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }

  public boolean a()
  {
    return this.a;
  }

  public NotificationSetting b()
  {
    return this.b;
  }

  public SetSettingsParams c()
  {
    return new SetSettingsParams(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.SetSettingsParamsBuilder
 * JD-Core Version:    0.6.0
 */