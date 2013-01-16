package com.facebook.katana.platform;

import android.content.Intent;
import java.util.ArrayList;

public final class PlatformActivityShareDialogRequest extends PlatformActivityRequest
{
  private boolean a;
  private String b;
  private String c;
  private Double d;
  private Double e;
  private ArrayList<String> f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;

  protected final String a()
  {
    return "com.facebook.platform.action.reply.SHARE_DIALOG";
  }

  protected final boolean a(Intent paramIntent)
  {
    PlatformActivityShareDialogRequest.1 local1 = new PlatformActivityShareDialogRequest.1(this);
    PlatformActivityShareDialogRequest.2 local2 = new PlatformActivityShareDialogRequest.2(this);
    PlatformActivityShareDialogRequest.3 local3 = new PlatformActivityShareDialogRequest.3(this);
    PlatformActivityShareDialogRequest.4 local4 = new PlatformActivityShareDialogRequest.4(this);
    PlatformActivityShareDialogRequest.5 local5 = new PlatformActivityShareDialogRequest.5(this);
    PlatformActivityShareDialogRequest.6 local6 = new PlatformActivityShareDialogRequest.6(this);
    PlatformActivityShareDialogRequest.7 local7 = new PlatformActivityShareDialogRequest.7(this);
    PlatformActivityShareDialogRequest.8 local8 = new PlatformActivityShareDialogRequest.8(this);
    PlatformActivityShareDialogRequest.9 local9 = new PlatformActivityShareDialogRequest.9(this);
    PlatformActivityShareDialogRequest.10 local10 = new PlatformActivityShareDialogRequest.10(this);
    PlatformActivityShareDialogRequest.11 local11 = new PlatformActivityShareDialogRequest.11(this);
    if ((a(paramIntent, "com.facebook.platform.extra.IS_USER_MESSAGE_OPTIONAL", true, Boolean.class, local1)) && (a(paramIntent, "com.facebook.platform.extra.PLACE", true, String.class, local2)) && (a(paramIntent, "com.facebook.platform.extra.PLACE_NAME", true, String.class, local3)) && (a(paramIntent, "com.facebook.platform.extra.LATITUDE", true, Double.class, local4)) && (a(paramIntent, "com.facebook.platform.extra.LONGITUDE", true, Double.class, local5)) && (a(paramIntent, "com.facebook.platform.extra.FRIENDS", true, local6)) && (a(paramIntent, "com.facebook.platform.extra.LINK", true, String.class, local7)) && (a(paramIntent, "com.facebook.platform.extra.IMAGE", true, String.class, local8)) && (a(paramIntent, "com.facebook.platform.extra.TITLE", true, String.class, local9)) && (a(paramIntent, "com.facebook.platform.extra.SUBTITLE", true, String.class, local10)) && (a(paramIntent, "com.facebook.platform.extra.DESCRIPTION", true, String.class, local11)));
    for (int m = 1; ; m = 0)
      return m;
  }

  public final boolean b()
  {
    return this.a;
  }

  public final String c()
  {
    return this.b;
  }

  public final String f()
  {
    return this.c;
  }

  public Double g()
  {
    return this.d;
  }

  public Double h()
  {
    return this.e;
  }

  public final ArrayList<String> i()
  {
    return this.f;
  }

  public final String j()
  {
    return this.g;
  }

  public final String k()
  {
    return this.h;
  }

  public final String l()
  {
    return this.i;
  }

  public final String m()
  {
    return this.j;
  }

  public final String n()
  {
    return this.k;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformActivityShareDialogRequest
 * JD-Core Version:    0.6.0
 */