package com.facebook.katana.util.logging;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.fragment.NotificationsFragment;
import com.facebook.orca.inject.FbInjector;

public class NotificationsLogger$NotificationsLogService extends IntentService
{
  public static String a = "REDIRECT_INTENT";

  public NotificationsLogger$NotificationsLogService()
  {
    super("NotificationsLogService");
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    NotificationsLogger.Event localEvent = (NotificationsLogger.Event)localBundle.get("EVENT_TYPE");
    NotificationsLogger.NotificationLogObject localNotificationLogObject = (NotificationsLogger.NotificationLogObject)localBundle.getSerializable("NOTIF_LOG");
    switch (NotificationsLogger.1.a[localEvent.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      NotificationsLogger.a(getApplicationContext(), localNotificationLogObject, NotificationsLogger.Event.CLEAR_FROM_TRAY);
      continue;
      NotificationsLogger.a(getApplicationContext(), localNotificationLogObject, NotificationsLogger.Event.CLICK_FROM_TRAY);
      Intent localIntent = (Intent)localBundle.getParcelable(a);
      String str1 = localIntent.getStringExtra("mobile_page");
      if (str1 != null)
      {
        String str2 = str1.split("\\?")[0];
        ((PerformanceLogger)FbInjector.a(this).a(PerformanceLogger.class)).a("LaunchFromPushNotification:" + str2, str1);
      }
      startActivity(localIntent);
      if (localNotificationLogObject == null)
        continue;
      AppSession localAppSession = AppSession.a(getApplicationContext(), false);
      Context localContext = getApplicationContext();
      long[] arrayOfLong = new long[1];
      arrayOfLong[0] = NotificationsLogger.NotificationLogObject.a(localNotificationLogObject);
      NotificationsFragment.a(localAppSession, localContext, arrayOfLong);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.NotificationsLogger.NotificationsLogService
 * JD-Core Version:    0.6.0
 */