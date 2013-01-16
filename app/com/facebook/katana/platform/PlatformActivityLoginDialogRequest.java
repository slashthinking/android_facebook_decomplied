package com.facebook.katana.platform;

import android.content.Intent;
import java.util.ArrayList;

public final class PlatformActivityLoginDialogRequest extends PlatformActivityRequest
{
  ArrayList<String> a;
  String b;

  protected final String a()
  {
    return "com.facebook.platform.action.reply.LOGIN_DIALOG";
  }

  protected final boolean a(Intent paramIntent)
  {
    boolean bool = true;
    PlatformActivityLoginDialogRequest.1 local1 = new PlatformActivityLoginDialogRequest.1(this);
    PlatformActivityLoginDialogRequest.2 local2 = new PlatformActivityLoginDialogRequest.2(this);
    if ((a(paramIntent, "com.facebook.platform.extra.PERMISSIONS", bool, local1)) && (a(paramIntent, "com.facebook.platform.extra.WRITE_PRIVACY", bool, String.class, local2)));
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
 * Qualified Name:     com.facebook.katana.platform.PlatformActivityLoginDialogRequest
 * JD-Core Version:    0.6.0
 */