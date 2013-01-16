package com.facebook.katana.service.vault;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.util.ErrorReporting;
import com.facebook.orca.common.util.StringUtil;

class VaultSyncJobProcessor$2 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      ErrorReporting.a(VaultSyncJobProcessor.a(), StringUtil.a("msg.what %d is not defined", new Object[0]), true);
    case 1:
    }
    while (true)
    {
      return;
      this.a.stopSelfResult(paramMessage.arg1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultSyncJobProcessor.2
 * JD-Core Version:    0.6.0
 */