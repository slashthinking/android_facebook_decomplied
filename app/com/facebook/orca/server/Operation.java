package com.facebook.orca.server;

import android.os.Bundle;

class Operation
{
  private final String a;
  private final String b;
  private final Bundle c;

  Operation(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBundle;
  }

  public String a()
  {
    return this.b;
  }

  String b()
  {
    return this.a;
  }

  public Bundle c()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.Operation
 * JD-Core Version:    0.6.0
 */