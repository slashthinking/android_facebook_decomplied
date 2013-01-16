package com.facebook.orca.fbwebrtc;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.debug.BLog;

class WebrtcIncallActivity$PhoneStateChangedAction
  implements SecureBroadcastReceiver.ActionReceiver
{
  private WebrtcIncallActivity$PhoneStateChangedAction(WebrtcIncallActivity paramWebrtcIncallActivity)
  {
  }

  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    int i = paramIntent.getIntExtra("CALL_STATE", 0);
    BLog.c(WebrtcIncallActivity.i(), "Phone state changed to " + i);
    if (i == 0)
      this.a.finish();
    while (true)
    {
      return;
      if (i == 1)
      {
        WebrtcIncallActivity.a(this.a);
        continue;
      }
      if (i != 2)
        continue;
      WebrtcIncallActivity.a(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcIncallActivity.PhoneStateChangedAction
 * JD-Core Version:    0.6.0
 */