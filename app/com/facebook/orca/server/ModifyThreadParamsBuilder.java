package com.facebook.orca.server;

import com.facebook.orca.media.MediaResource;
import com.facebook.orca.notify.NotificationSetting;

public class ModifyThreadParamsBuilder
{
  private String a;
  private boolean b;
  private String c;
  private MediaResource d;
  private boolean e;
  private boolean f;
  private NotificationSetting g;

  public ModifyThreadParamsBuilder a(MediaResource paramMediaResource)
  {
    this.d = paramMediaResource;
    return this;
  }

  public ModifyThreadParamsBuilder a(NotificationSetting paramNotificationSetting)
  {
    this.g = paramNotificationSetting;
    return this;
  }

  public ModifyThreadParamsBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public ModifyThreadParamsBuilder a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public ModifyThreadParamsBuilder b(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public ModifyThreadParamsBuilder b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public boolean b()
  {
    return this.b;
  }

  public ModifyThreadParamsBuilder c(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }

  public String c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.e;
  }

  public MediaResource e()
  {
    return this.d;
  }

  public boolean f()
  {
    return this.f;
  }

  public NotificationSetting g()
  {
    return this.g;
  }

  public ModifyThreadParams h()
  {
    return new ModifyThreadParams(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ModifyThreadParamsBuilder
 * JD-Core Version:    0.6.0
 */