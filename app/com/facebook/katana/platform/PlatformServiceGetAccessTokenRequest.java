package com.facebook.katana.platform;

import android.os.Message;

public class PlatformServiceGetAccessTokenRequest extends PlatformServiceRequest
{
  public static Message b(Message paramMessage)
  {
    Message localMessage = Message.obtain(paramMessage);
    localMessage.arg1 = 20121101;
    localMessage.arg2 = paramMessage.arg2;
    localMessage.what = 65537;
    return localMessage;
  }

  protected int a()
  {
    return 65537;
  }

  protected boolean a(Message paramMessage)
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformServiceGetAccessTokenRequest
 * JD-Core Version:    0.6.0
 */