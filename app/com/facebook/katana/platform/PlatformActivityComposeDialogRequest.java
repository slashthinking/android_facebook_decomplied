package com.facebook.katana.platform;

import android.content.Intent;
import java.util.ArrayList;

public final class PlatformActivityComposeDialogRequest extends PlatformActivityRequest
{
  ArrayList<String> a;
  String b;

  protected final String a()
  {
    return "com.facebook.platform.action.reply.COMPOSE_DIALOG";
  }

  protected final boolean a(Intent paramIntent)
  {
    boolean bool = true;
    PlatformActivityComposeDialogRequest.1 local1 = new PlatformActivityComposeDialogRequest.1(this);
    PlatformActivityComposeDialogRequest.2 local2 = new PlatformActivityComposeDialogRequest.2(this);
    if ((a(paramIntent, "com.facebook.platform.extra.RECIPIENTS", bool, local1)) && (a(paramIntent, "com.facebook.platform.extra.BODY", bool, String.class, local2)));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public ArrayList<String> b()
  {
    return this.a;
  }

  public String c()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformActivityComposeDialogRequest
 * JD-Core Version:    0.6.0
 */