package android_src.mms.transaction;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android_src.mms.ClassesToUse;
import android_src.mms.pdu.PduPersister;
import android_src.mms.util.DownloadManager;
import android_src.mms.util.SqliteWrapper;
import android_src.provider.Telephony.Mms.Inbox;
import android_src.provider.Telephony.Mms.Outbox;
import android_src.provider.Telephony.MmsSms.PendingMessages;
import com.facebook.orca.debug.BLog;

public class RetryScheduler
  implements Observer
{
  private static RetryScheduler c;
  private final Context a;
  private final ContentResolver b;

  private RetryScheduler(Context paramContext)
  {
    this.a = paramContext;
    this.b = paramContext.getContentResolver();
  }

  private int a(long paramLong)
  {
    Cursor localCursor = SqliteWrapper.a(this.a, this.b, Telephony.Mms.Outbox.a, null, "_id=" + paramLong, null, null);
    while (true)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          int j = localCursor.getInt(localCursor.getColumnIndexOrThrow("resp_st"));
          i = j;
          localCursor.close();
          if (i == 0)
            continue;
          BLog.e("fb-mms:RetryScheduler", "Response status is: " + i);
          return i;
        }
      }
      finally
      {
        localCursor.close();
      }
      int i = 0;
    }
  }

  public static RetryScheduler a(Context paramContext)
  {
    if (c == null)
      c = new RetryScheduler(paramContext);
    return c;
  }

  private void a(Uri paramUri)
  {
    long l1 = ContentUris.parseId(paramUri);
    Uri.Builder localBuilder = Telephony.MmsSms.PendingMessages.a.buildUpon();
    localBuilder.appendQueryParameter("protocol", "mms");
    localBuilder.appendQueryParameter("message", String.valueOf(l1));
    Cursor localCursor1 = SqliteWrapper.a(this.a, this.b, localBuilder.build(), null, null, null, null);
    if (localCursor1 != null);
    while (true)
    {
      try
      {
        if ((localCursor1.getCount() != 1) || (!localCursor1.moveToFirst()))
          continue;
        int i = localCursor1.getInt(localCursor1.getColumnIndexOrThrow("msg_type"));
        int j = 1 + localCursor1.getInt(localCursor1.getColumnIndexOrThrow("retry_index"));
        k = 1;
        DefaultRetryScheme localDefaultRetryScheme = new DefaultRetryScheme(this.a, j);
        ContentValues localContentValues1 = new ContentValues(4);
        long l2 = System.currentTimeMillis();
        if (i != 130)
          continue;
        int m = 1;
        int n = 1;
        int i1 = a(l1);
        if (m != 0)
          continue;
        int i2 = 0;
        switch (i1)
        {
        default:
          if (i2 == 0)
            continue;
          DownloadManager.b().a(i2);
          n = 0;
          if ((j >= localDefaultRetryScheme.a()) || (n == 0))
            continue;
          long l6 = l2 + localDefaultRetryScheme.b();
          if (!BLog.b(2))
            continue;
          BLog.a("fb-mms:RetryScheduler", "scheduleRetry: retry for " + paramUri + " is scheduled at " + (l6 - System.currentTimeMillis()) + "ms from now");
          localContentValues1.put("due_time", Long.valueOf(l6));
          if (m == 0)
            continue;
          DownloadManager.b().a(paramUri, 130);
          localContentValues1.put("err_type", Integer.valueOf(k));
          localContentValues1.put("retry_index", Integer.valueOf(j));
          localContentValues1.put("last_try", Long.valueOf(l2));
          long l3 = localCursor1.getLong(localCursor1.getColumnIndexOrThrow("_id"));
          SqliteWrapper.a(this.a, this.b, Telephony.MmsSms.PendingMessages.a, localContentValues1, "_id=" + l3, null);
          localCursor1.close();
          return;
          m = 0;
          break;
        case 132:
          i2 = 2131362158;
          break;
        case 130:
        case 225:
          i2 = 2131362159;
          break;
        case 134:
          i2 = 2131362160;
          break;
        case 194:
        case 228:
          i2 = 2131362161;
          break;
        }
        if (b(l1) != 228)
          continue;
        DownloadManager.b().a(2131362161);
        SqliteWrapper.a(this.a, this.a.getContentResolver(), paramUri, null, null);
        localCursor1.close();
        continue;
        if (m != 0)
        {
          localCursor2 = SqliteWrapper.a(this.a, this.a.getContentResolver(), paramUri, new String[] { "thread_id" }, null, null, null);
          l4 = -1L;
          if (localCursor2 == null)
            continue;
        }
      }
      finally
      {
        try
        {
          if (!localCursor2.moveToFirst())
            continue;
          long l5 = localCursor2.getLong(0);
          long l4 = l5;
          localCursor2.close();
          if (l4 == -1L)
            continue;
          MessagingNotification.a(this.a, l4);
          DownloadManager.b().a(paramUri, 135);
          k = 10;
        }
        finally
        {
          Cursor localCursor2;
          localCursor2.close();
        }
        localCursor1.close();
      }
      ContentValues localContentValues2 = new ContentValues(1);
      localContentValues2.put("read", Integer.valueOf(0));
      SqliteWrapper.a(this.a, this.a.getContentResolver(), paramUri, localContentValues2, null, null);
      MessagingNotification.a(this.a, true);
      int k = 10;
    }
  }

  private boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getNetworkInfo(2);
    if (localNetworkInfo == null);
    for (boolean bool = false; ; bool = localNetworkInfo.isConnected())
      return bool;
  }

  private int b(long paramLong)
  {
    Cursor localCursor = SqliteWrapper.a(this.a, this.b, Telephony.Mms.Inbox.a, null, "_id=" + paramLong, null, null);
    while (true)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          int j = localCursor.getInt(localCursor.getColumnIndexOrThrow("resp_st"));
          i = j;
          localCursor.close();
          if ((i == 0) || (!BLog.b(2)))
            continue;
          BLog.a("fb-mms:RetryScheduler", "Retrieve status is: " + i);
          return i;
        }
      }
      finally
      {
        localCursor.close();
      }
      int i = 0;
    }
  }

  public static void b(Context paramContext)
  {
    Cursor localCursor = PduPersister.a(paramContext).a(9223372036854775807L);
    if (localCursor != null);
    try
    {
      if (localCursor.moveToFirst())
      {
        long l = localCursor.getLong(localCursor.getColumnIndexOrThrow("due_time"));
        PendingIntent localPendingIntent = PendingIntent.getService(paramContext, 0, new Intent("android.intent.action.ACTION_ONALARM", null, paramContext, ClassesToUse.a), 1073741824);
        ((AlarmManager)paramContext.getSystemService("alarm")).set(1, l, localPendingIntent);
        if (BLog.b(2))
          BLog.a("fb-mms:RetryScheduler", "Next retry is scheduled at" + (l - System.currentTimeMillis()) + "ms from now");
      }
      return;
    }
    finally
    {
      localCursor.close();
    }
    throw localObject;
  }

  public void a(Observable paramObservable)
  {
    try
    {
      Transaction localTransaction = (Transaction)paramObservable;
      if (BLog.b(2))
        BLog.a("fb-mms:RetryScheduler", "[RetryScheduler] update " + paramObservable);
      if ((!(localTransaction instanceof NotificationTransaction)) && (!(localTransaction instanceof RetrieveTransaction)) && (!(localTransaction instanceof ReadRecTransaction)))
      {
        boolean bool = localTransaction instanceof SendTransaction;
        if (!bool)
          break label107;
      }
      try
      {
        TransactionState localTransactionState = localTransaction.d();
        if (localTransactionState.a() == 2)
        {
          Uri localUri = localTransactionState.b();
          if (localUri != null)
            a(localUri);
        }
        localTransaction.b(this);
        label107: if (a())
          b(this.a);
        return;
      }
      finally
      {
        localTransaction.b(this);
      }
    }
    finally
    {
      if (a())
        b(this.a);
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.RetryScheduler
 * JD-Core Version:    0.6.0
 */