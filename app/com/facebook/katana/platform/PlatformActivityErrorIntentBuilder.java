package com.facebook.katana.platform;

import android.content.Intent;

public class PlatformActivityErrorIntentBuilder
{
  private final Intent a = new Intent();

  public PlatformActivityErrorIntentBuilder(String paramString1, String paramString2, String paramString3)
  {
    this.a.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 20121101);
    this.a.putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", paramString1);
    this.a.putExtra("com.facebook.platform.status.ERROR_TYPE", paramString2);
    this.a.putExtra("com.facebook.platform.status.ERROR_DESCRIPTION", paramString3);
  }

  public Intent a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformActivityErrorIntentBuilder
 * JD-Core Version:    0.6.0
 */