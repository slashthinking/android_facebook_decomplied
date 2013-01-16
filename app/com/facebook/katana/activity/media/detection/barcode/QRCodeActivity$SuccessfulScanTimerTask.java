package com.facebook.katana.activity.media.detection.barcode;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.util.IntentUtils;
import com.facebook.orca.inject.FbInjector;
import java.util.TimerTask;

class QRCodeActivity$SuccessfulScanTimerTask extends TimerTask
{
  private final Context b;
  private final long c;

  public QRCodeActivity$SuccessfulScanTimerTask(QRCodeActivity paramQRCodeActivity, Context paramContext, long paramLong)
  {
    this.b = paramContext;
    this.c = paramLong;
  }

  public void run()
  {
    Intent localIntent = IntentUtils.a(this.b, this.c);
    ((SecureContextHelper)this.a.C().a(SecureContextHelper.class)).a(localIntent, this.b);
    this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.detection.barcode.QRCodeActivity.SuccessfulScanTimerTask
 * JD-Core Version:    0.6.0
 */