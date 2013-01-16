package com.facebook.orca.sms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android_src.mms.transaction.MessagingNotification;
import android_src.mms.util.DownloadManager;
import android_src.mms.util.RateController;
import android_src.provider.Telephony.MmsSms;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.sms.observe.ExternalSmsOperationsObserver;

public class MmsSmsInitializer
  implements INeedInit
{
  private final Context a;

  public MmsSmsInitializer(Context paramContext)
  {
    this.a = paramContext;
  }

  public void i_()
  {
    RateController.a(this.a);
    DownloadManager.a(this.a);
    MessagingNotification.a(this.a);
    android_src.mms.ClassesToUse.a = OrcaMmsTransactionService.class;
    FbInjector localFbInjector = FbInjector.a(this.a);
    ExternalSmsOperationsObserver localExternalSmsOperationsObserver = (ExternalSmsOperationsObserver)localFbInjector.a(ExternalSmsOperationsObserver.class);
    this.a.getContentResolver().registerContentObserver(Telephony.MmsSms.a, true, localExternalSmsOperationsObserver);
    Intent localIntent = new Intent(this.a, MmsSmsLogExternalMessagesLogic.MmsSmsLogExternalMessagesService.class);
    PendingIntent localPendingIntent = PendingIntent.getService(this.a, -1, localIntent, 0);
    ((AlarmManager)localFbInjector.a(AlarmManager.class)).setInexactRepeating(3, 30000L + SystemClock.elapsedRealtime(), 10800000L, localPendingIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsInitializer
 * JD-Core Version:    0.6.0
 */