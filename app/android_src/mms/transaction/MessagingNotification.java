package android_src.mms.transaction;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android_src.database.sqlite.SqliteWrapper;
import android_src.provider.Telephony.Mms.Inbox;

public class MessagingNotification
{
  private static final String[] a = { "thread_id", "date", "_id", "sub", "sub_cs" };
  private static final String[] b = { "thread_id", "date", "address", "subject", "body" };
  private static final MessagingNotification.MmsSmsNotificationInfoComparator c = new MessagingNotification.MmsSmsNotificationInfoComparator(null);
  private static final Uri d = Uri.parse("content://mms-sms/undelivered");
  private static MessagingNotification.OnDeletedReceiver e = new MessagingNotification.OnDeletedReceiver();
  private static Intent f;
  private static Handler g = new Handler();

  public static void a(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.android.mms.NOTIFICATION_DELETED_ACTION");
    paramContext.registerReceiver(e, localIntentFilter);
    f = new Intent("com.android.mms.NOTIFICATION_DELETED_ACTION");
  }

  public static void a(Context paramContext, int paramInt)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(paramInt);
  }

  public static void a(Context paramContext, long paramLong)
  {
    a(paramContext, true, paramLong, false);
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, false, 0L, paramBoolean);
  }

  private static void a(Context paramContext, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
  }

  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    new Thread(new MessagingNotification.1(paramContext, paramBoolean1, paramBoolean2)).start();
  }

  public static void b(Context paramContext)
  {
    if (c(paramContext) < 1)
      a(paramContext, 531);
  }

  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  private static int c(Context paramContext)
  {
    Cursor localCursor = SqliteWrapper.a(paramContext, paramContext.getContentResolver(), Telephony.Mms.Inbox.a, null, "m_type=" + String.valueOf(130) + " AND " + "st" + "=" + String.valueOf(135), null, null);
    int i;
    if (localCursor == null)
      i = 0;
    while (true)
    {
      return i;
      i = localCursor.getCount();
      localCursor.close();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.MessagingNotification
 * JD-Core Version:    0.6.0
 */