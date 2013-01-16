package com.facebook.katana.binding;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.activity.composer.ComposerActivity;
import com.facebook.katana.activity.media.PendingUploadActivity;
import com.facebook.katana.activity.media.PendingUploadActivity.UploadStatus;
import com.facebook.katana.activity.media.UploadPhotoActivity;
import com.facebook.katana.service.FacebookService;
import com.facebook.katana.util.logging.NotificationsLogger;
import com.facebook.katana.util.logging.NotificationsLogger.Event;
import com.facebook.katana.util.logging.NotificationsLogger.NotificationLogObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SystemTrayNotificationManager
{
  private static Map<Integer, SystemTrayNotificationManager.MyNotification> a = new LinkedHashMap();

  private static Notification a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    PendingIntent localPendingIntent = null;
    if (paramIntent != null)
      localPendingIntent = PendingIntent.getActivity(paramContext, 0, paramIntent, 134217728);
    Notification localNotification = new Notification(paramInt, paramString, System.currentTimeMillis());
    localNotification.setLatestEventInfo(paramContext, paramContext.getResources().getString(2131362037), paramString, localPendingIntent);
    localNotification.flags = (0x10 | localNotification.flags);
    return localNotification;
  }

  public static Map<Integer, SystemTrayNotificationManager.MyNotification> a()
  {
    return a;
  }

  protected static void a(Context paramContext)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancelAll();
    a.clear();
  }

  protected static void a(Context paramContext, int paramInt)
  {
    SystemTrayNotificationManager.MyNotification localMyNotification = (SystemTrayNotificationManager.MyNotification)a.remove(Integer.valueOf(paramInt));
    if (localMyNotification != null)
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(SystemTrayNotificationManager.MyNotification.a(localMyNotification));
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Resources localResources = paramContext.getResources();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    Notification localNotification = a(paramContext, localResources.getString(2131363247, arrayOfObject), paramIntent, 17301624);
    ((NotificationManager)paramContext.getSystemService("notification")).notify(29, localNotification);
  }

  public static void a(Context paramContext, int paramInt, NotificationBuilder paramNotificationBuilder, Intent paramIntent, NotificationsLogger.NotificationLogObject paramNotificationLogObject)
  {
    paramNotificationBuilder.a(PendingIntent.getService(paramContext, (int)System.currentTimeMillis(), NotificationsLogger.a(paramContext, paramNotificationLogObject, paramIntent), 268435456));
    Intent localIntent = NotificationsLogger.a(paramContext, paramNotificationLogObject);
    if (localIntent != null)
      paramNotificationBuilder.b(PendingIntent.getService(paramContext, (int)System.currentTimeMillis(), localIntent, 0));
    NotificationsLogger.a(paramContext, paramNotificationLogObject, NotificationsLogger.Event.ADD_TO_TRAY);
    ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, paramNotificationBuilder.d());
  }

  private static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Intent paramIntent, int paramInt2, int paramInt3)
  {
    Notification localNotification = new Notification(2130838952, null, System.currentTimeMillis());
    localNotification.flags = (0x2 | localNotification.flags);
    localNotification.setLatestEventInfo(paramContext, paramContext.getResources().getString(2131362037), null, PendingIntent.getActivity(paramContext, 0, paramIntent, 0));
    a.put(Integer.valueOf(paramInt1), new SystemTrayNotificationManager.MyNotification(paramInt1 + 100, localNotification, 0, paramString1, paramString2, 0, paramInt2, paramInt3));
  }

  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = IntentUriHandler.a(paramContext, "fb://feed/");
    localIntent.setFlags(335544320);
    a(paramContext, paramInt, paramString1, paramString3, localIntent, 1, 1);
  }

  protected static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, PendingUploadActivity.class);
    localIntent.setAction("com.facebook.katana.upload.notification.pending." + paramInt1);
    localIntent.putExtra("android.intent.extra.STREAM", Uri.parse(paramString3));
    localIntent.putExtra("extra_photo_is_scaled", true);
    if (paramString1 != null)
      localIntent.putExtra("extra_album_id", paramString1);
    localIntent.setFlags(335544320);
    a(paramContext, paramInt1, paramString2, paramString3, localIntent, paramInt2, paramInt3);
  }

  public static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    SystemTrayNotificationManager.MyNotification localMyNotification = (SystemTrayNotificationManager.MyNotification)a.get(Integer.valueOf(paramInt1));
    if (localMyNotification != null)
      localMyNotification.a(paramContext, paramInt2);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    int i = 1;
    SystemTrayNotificationManager.MyNotification localMyNotification = (SystemTrayNotificationManager.MyNotification)a.get(Integer.valueOf(paramInt1));
    Notification localNotification;
    int j;
    if (localMyNotification != null)
    {
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(SystemTrayNotificationManager.MyNotification.a(localMyNotification));
      localNotification = new Notification();
      if (paramInt2 == 200)
      {
        localNotification.icon = 2130838948;
        Intent localIntent1 = new Intent(paramContext, FacebookService.class);
        localIntent1.setAction("com.facebook.katana.clear_notification");
        localIntent1.putExtra("type", 300);
        localIntent1.putExtra("android.intent.extra.SUBJECT", paramInt1);
        localNotification.deleteIntent = PendingIntent.getService(paramContext, 0, localIntent1, 0);
        Intent localIntent2 = IntentUriHandler.a(paramContext, "fb://feed/");
        localIntent2.setFlags(335544320);
        if (localMyNotification.b() != null)
          localIntent2.putExtra("android.intent.extra.TITLE", localMyNotification.b());
        localNotification.contentIntent = PendingIntent.getActivity(paramContext, 0, localIntent2, 0);
        if (paramInt2 != 200)
          break label201;
        j = 2;
        label178: localMyNotification.a(paramContext, localNotification, j);
      }
    }
    while (true)
    {
      return i;
      localNotification.icon = 17301624;
      break;
      label201: j = i;
      break label178;
      i = 0;
    }
  }

  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    int i = 1;
    SystemTrayNotificationManager.MyNotification localMyNotification = (SystemTrayNotificationManager.MyNotification)a.get(Integer.valueOf(paramInt1));
    boolean bool4;
    boolean bool2;
    Notification localNotification;
    label86: Intent localIntent2;
    boolean bool3;
    label173: int j;
    int k;
    label233: AppSession localAppSession;
    Intent localIntent3;
    if (localMyNotification != null)
      if (paramInt3 == 507)
        if (paramInt2 == 200)
        {
          bool4 = i;
          bool2 = bool4;
          ((NotificationManager)paramContext.getSystemService("notification")).cancel(SystemTrayNotificationManager.MyNotification.a(localMyNotification));
          localNotification = new Notification();
          if (!bool2)
            break label394;
          localNotification.icon = 2130838948;
          Intent localIntent1 = new Intent(paramContext, FacebookService.class);
          localIntent1.setAction("com.facebook.katana.clear_notification");
          localIntent1.putExtra("type", 300);
          localIntent1.putExtra("android.intent.extra.SUBJECT", paramInt1);
          localNotification.deleteIntent = PendingIntent.getService(paramContext, 0, localIntent1, 0);
          localIntent2 = new Intent(paramContext, UploadPhotoActivity.class);
          localIntent2.putExtra("extra_album_id", paramString2);
          if (paramInt3 != 507)
            break label424;
          bool3 = i;
          localIntent2.putExtra("places_suggestion", bool3);
          if (!bool2)
            break label430;
          localIntent2.setAction("com.facebook.katana.upload.notification.ok" + paramString3);
          localIntent2.putExtra("extra_photo_id", paramString3);
          j = 2;
          k = 0;
          localIntent2.putExtra("android.intent.extra.STREAM", Uri.parse(paramString1));
          localIntent2.putExtra("extra_photo_is_scaled", i);
          localIntent2.putExtra("android.intent.extra.SUBJECT", paramInt1);
          localIntent2.setFlags(335544320);
          if (localMyNotification.b() != null)
            localIntent2.putExtra("android.intent.extra.TITLE", localMyNotification.b());
          localAppSession = AppSession.b(paramContext, false);
          if (k == 0)
            break label469;
          localIntent3 = localAppSession.b(paramString1);
          if (localIntent3 != null)
            localIntent3.setClass(paramContext, ComposerActivity.class);
          label328: if (localIntent3 != null)
            localNotification.contentIntent = PendingIntent.getActivity(paramContext, 0, localIntent3, 0);
          localMyNotification.a(paramContext, localNotification, j);
        }
    while (true)
    {
      return i;
      bool4 = false;
      break;
      if ((paramInt2 == 200) && (paramString3 != null));
      for (boolean bool1 = i; ; bool1 = false)
      {
        bool2 = bool1;
        break;
      }
      label394: if (paramInt2 == PendingUploadActivity.UploadStatus.CANCELED.ordinal())
      {
        localNotification.icon = 2130838948;
        break label86;
      }
      localNotification.icon = 17301624;
      break label86;
      label424: bool3 = false;
      break label173;
      label430: if (paramInt2 == PendingUploadActivity.UploadStatus.CANCELED.ordinal())
      {
        localIntent2.setAction("com.facebook.katana.upload_notification_canceled");
        j = 3;
        k = 0;
        break label233;
      }
      j = i;
      k = i;
      break label233;
      label469: localAppSession.c(paramString1);
      localIntent3 = localIntent2;
      break label328;
      i = 0;
    }
  }

  protected static void b(Context paramContext)
  {
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      SystemTrayNotificationManager.MyNotification localMyNotification = (SystemTrayNotificationManager.MyNotification)localIterator.next();
      if ((localMyNotification.a() != 1) && (localMyNotification.a() != 2) && (localMyNotification.a() != 3))
        continue;
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(SystemTrayNotificationManager.MyNotification.a(localMyNotification));
      localIterator.remove();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.SystemTrayNotificationManager
 * JD-Core Version:    0.6.0
 */