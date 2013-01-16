package com.facebook.katana;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.TextView;
import com.facebook.common.util.Log;
import com.facebook.katana.service.FacebookService;

class WidgetActivity$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = this.a.getText().toString().trim();
    if (str.length() == 0)
      this.b.finish();
    while (true)
    {
      return;
      WidgetActivity.a(this.b, str);
      try
      {
        Intent localIntent = new Intent(this.b, FacebookService.class);
        localIntent.putExtra("type", 92);
        localIntent.putExtra("status", str);
        PendingIntent.getService(this.b, 0, localIntent, 268435456).send();
        this.b.showDialog(2);
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        Log.a(this.b.x(), "widget share failed", localCanceledException);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.WidgetActivity.2
 * JD-Core Version:    0.6.0
 */