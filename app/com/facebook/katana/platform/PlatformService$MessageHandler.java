package com.facebook.katana.platform;

import android.os.Binder;
import android.os.Handler;
import android.os.Message;

class PlatformService$MessageHandler extends Handler
{
  private String b;

  PlatformService$MessageHandler(PlatformService paramPlatformService)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      super.handleMessage(paramMessage);
    case 65536:
    }
    while (true)
    {
      return;
      PlatformService.a(this.a, this.b, paramMessage);
    }
  }

  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    this.b = PlatformService.a(this.a).a(Binder.getCallingUid());
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformService.MessageHandler
 * JD-Core Version:    0.6.0
 */