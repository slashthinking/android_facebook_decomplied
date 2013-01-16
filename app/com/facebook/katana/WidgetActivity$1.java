package com.facebook.katana;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.Toaster;

class WidgetActivity$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a.removeDialog(2);
    if (paramIntent.getIntExtra("extra_error_code", 0) == 200)
    {
      Toaster.a(paramContext, 2131363279);
      this.a.finish();
    }
    while (true)
    {
      return;
      this.a.showDialog(1);
      Toaster.a(paramContext, 2131363206);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.WidgetActivity.1
 * JD-Core Version:    0.6.0
 */