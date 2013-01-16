package com.facebook.katana.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.facebook.katana.provider.PhotosProvider;

public class PhotoCleanupService extends IntentService
{
  private static final Class<?> a = PhotoCleanupService.class;
  private static final String b = a.getSimpleName();

  public PhotoCleanupService()
  {
    super(b);
  }

  public static void a(Context paramContext)
  {
    PendingIntent localPendingIntent = PendingIntent.getService(paramContext, 0, new Intent(paramContext, PhotoCleanupService.class), 0);
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    localAlarmManager.cancel(localPendingIntent);
    localAlarmManager.setInexactRepeating(3, SystemClock.elapsedRealtime(), 43200000L, localPendingIntent);
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    PhotosProvider.a(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.PhotoCleanupService
 * JD-Core Version:    0.6.0
 */