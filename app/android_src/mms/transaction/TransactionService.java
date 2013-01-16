package android_src.mms.transaction;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android_src.mms.pdu.PduPersister;
import android_src.mms.util.RateController;
import android_src.provider.Telephony.Mms;
import com.facebook.orca.debug.BLog;
import java.io.IOException;
import java.util.ArrayList;

public class TransactionService extends Service
  implements Observer
{
  public Handler a = new TransactionService.1(this);
  private TransactionService.ServiceHandler b;
  private Looper c;
  private final ArrayList<Transaction> d = new ArrayList();
  private final ArrayList<Transaction> e = new ArrayList();
  private ConnectivityManager f;
  private TransactionService.ConnectivityBroadcastReceiver g;
  private PowerManager.WakeLock h;

  private void a(int paramInt)
  {
    synchronized (this.d)
    {
      if ((this.d.isEmpty()) && (this.e.isEmpty()))
      {
        if (BLog.b(2))
          BLog.a("fb-mms:TransactionService", "stopSelfIfIdle: STOP!");
        if (BLog.b(2))
          BLog.a("fb-mms:TransactionService", "stopSelfIfIdle: unRegisterForConnectionStateChanges");
        MmsSystemEventReceiver.b(getApplicationContext());
        stopSelf(paramInt);
      }
      return;
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    int i = 2;
    if (BLog.b(i))
      BLog.a("fb-mms:TransactionService", "onNetworkUnavailable: sid=" + paramInt1 + ", type=" + paramInt2);
    if (paramInt2 == 1);
    while (true)
    {
      if (i != -1)
        this.a.sendEmptyMessage(i);
      stopSelf(paramInt1);
      return;
      if (paramInt2 == i)
      {
        i = 1;
        continue;
      }
      i = -1;
    }
  }

  private void a(int paramInt, TransactionBundle paramTransactionBundle, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      BLog.d("fb-mms:TransactionService", "launchTransaction: no network error!");
      a(paramInt, paramTransactionBundle.a());
    }
    while (true)
    {
      return;
      Message localMessage = this.b.obtainMessage(1);
      localMessage.arg1 = paramInt;
      localMessage.obj = paramTransactionBundle;
      if (BLog.b(2))
        BLog.a("fb-mms:TransactionService", "launchTransaction: sending message " + localMessage);
      this.b.sendMessage(localMessage);
    }
  }

  private static boolean b(int paramInt)
  {
    if ((paramInt < 10) && (paramInt > 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  private int c(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default:
      BLog.d("fb-mms:TransactionService", "Unrecognized MESSAGE_TYPE: " + paramInt);
      i = -1;
    case 130:
    case 135:
    case 128:
    }
    while (true)
    {
      return i;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
    }
  }

  private boolean c()
  {
    NetworkInfo localNetworkInfo = this.f.getNetworkInfo(2);
    if (localNetworkInfo == null);
    for (boolean bool = false; ; bool = localNetworkInfo.isAvailable())
      return bool;
  }

  private void d()
  {
    monitorenter;
    try
    {
      if (this.h == null)
      {
        this.h = ((PowerManager)getSystemService("power")).newWakeLock(1, "MMS Connectivity");
        this.h.setReferenceCounted(false);
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void e()
  {
    this.h.acquire();
  }

  private void f()
  {
    if ((this.h != null) && (this.h.isHeld()))
      this.h.release();
  }

  private void g()
  {
    this.b.sendMessageDelayed(this.b.obtainMessage(3), 30000L);
  }

  protected int a()
  {
    d();
    int i = this.f.startUsingNetworkFeature(0, "enableMMS");
    if (BLog.b(2))
      BLog.a("fb-mms:TransactionService", "beginMmsConnectivity: result=" + i);
    switch (i)
    {
    default:
      throw new IOException("Cannot establish MMS connectivity");
    case 0:
    case 1:
    }
    e();
    return i;
  }

  public void a(Observable paramObservable)
  {
    Transaction localTransaction = (Transaction)paramObservable;
    int i = localTransaction.e();
    if (BLog.b(2))
      BLog.a("fb-mms:TransactionService", "update transaction " + i);
    while (true)
    {
      try
      {
        synchronized (this.d)
        {
          this.d.remove(localTransaction);
          if (this.e.size() <= 0)
            continue;
          if (!BLog.b(2))
            continue;
          BLog.a("fb-mms:TransactionService", "update: handle next pending transaction...");
          Message localMessage = this.b.obtainMessage(4, localTransaction.f());
          this.b.sendMessage(localMessage);
          Intent localIntent = new Intent("android.intent.action.TRANSACTION_COMPLETED_ACTION");
          TransactionState localTransactionState = localTransaction.d();
          int j = localTransactionState.a();
          localIntent.putExtra("state", j);
          localIntent.putExtra("uri", localTransactionState.b());
          switch (j)
          {
          default:
            if (!BLog.b(2))
              continue;
            BLog.a("fb-mms:TransactionService", "Transaction state unknown: " + i + " " + j);
            if (!BLog.b(2))
              continue;
            BLog.a("fb-mms:TransactionService", "update: broadcast transaction result " + j);
            sendBroadcast(localIntent);
            localTransaction.b(this);
            MmsSystemEventReceiver.b(getApplicationContext());
            stopSelf(i);
            return;
            if (!BLog.b(2))
              continue;
            BLog.a("fb-mms:TransactionService", "update: endMmsConnectivity");
            b();
          case 1:
          case 2:
          }
        }
      }
      finally
      {
        localTransaction.b(this);
        MmsSystemEventReceiver.b(getApplicationContext());
        stopSelf(i);
      }
      if (BLog.b(2))
        BLog.a("fb-mms:TransactionService", "Transaction complete: " + i);
      switch (localTransaction.b())
      {
      case 0:
      case 1:
        MessagingNotification.b(this, true, false);
        MessagingNotification.b(this);
        break;
      case 2:
        RateController.a().b();
        continue;
        if (!BLog.b(2))
          continue;
        BLog.a("fb-mms:TransactionService", "Transaction failed: " + i);
        continue;
      }
    }
  }

  protected void b()
  {
    try
    {
      if (BLog.b(2))
        BLog.a("fb-mms:TransactionService", "endMmsConnectivity");
      this.b.removeMessages(3);
      if (this.f != null)
        this.f.stopUsingNetworkFeature(0, "enableMMS");
      return;
    }
    finally
    {
      f();
    }
    throw localObject;
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    if (BLog.b(2))
      BLog.a("fb-mms:TransactionService", "Creating TransactionService");
    HandlerThread localHandlerThread = new HandlerThread("TransactionService");
    localHandlerThread.start();
    this.c = localHandlerThread.getLooper();
    this.b = new TransactionService.ServiceHandler(this, this.c);
    this.g = new TransactionService.ConnectivityBroadcastReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.g, localIntentFilter);
  }

  public void onDestroy()
  {
    if (BLog.b(2))
      BLog.a("fb-mms:TransactionService", "Destroying TransactionService");
    if (!this.e.isEmpty())
      BLog.d("fb-mms:TransactionService", "TransactionService exiting with transaction still pending");
    f();
    unregisterReceiver(this.g);
    this.b.sendEmptyMessage(100);
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    if (paramIntent == null);
    while (true)
    {
      return 2;
      this.f = ((ConnectivityManager)getSystemService("connectivity"));
      boolean bool2;
      label34: label109: Cursor localCursor;
      if (!c())
      {
        bool2 = bool1;
        if (BLog.b(2))
        {
          BLog.a("fb-mms:TransactionService", "onStart: #" + paramInt2 + ": " + paramIntent.getExtras() + " intent=" + paramIntent);
          StringBuilder localStringBuilder = new StringBuilder().append("    networkAvailable=");
          if (bool2)
            break label248;
          BLog.a("fb-mms:TransactionService", bool1);
        }
        if ((!"android.intent.action.ACTION_ONALARM".equals(paramIntent.getAction())) && (paramIntent.getExtras() != null))
          break label495;
        localCursor = PduPersister.a(this).a(System.currentTimeMillis());
        if (localCursor == null)
          break label468;
      }
      while (true)
      {
        try
        {
          int i = localCursor.getCount();
          if (!BLog.b(2))
            continue;
          BLog.a("fb-mms:TransactionService", "onStart: cursor.count=" + i);
          if (i != 0)
            continue;
          if (!BLog.b(2))
            continue;
          BLog.a("fb-mms:TransactionService", "onStart: no pending messages. Stopping service.");
          RetryScheduler.b(this);
          a(paramInt2);
          localCursor.close();
          break;
          bool2 = false;
          break label34;
          label248: bool1 = false;
          break label109;
          int j = localCursor.getColumnIndexOrThrow("msg_id");
          int k = localCursor.getColumnIndexOrThrow("msg_type");
          if (!bool2)
            continue;
          if (!BLog.b(2))
            continue;
          BLog.a("fb-mms:TransactionService", "onStart: registerForConnectionStateChanges");
          MmsSystemEventReceiver.a(getApplicationContext());
          if (!localCursor.moveToNext())
            break label458;
          int m = c(localCursor.getInt(k));
          if (!bool2)
            continue;
          a(paramInt2, m);
          localCursor.close();
          break;
          switch (m)
          {
          case -1:
          case 0:
          default:
            a(paramInt2, new TransactionBundle(m, ContentUris.withAppendedId(Telephony.Mms.a, localCursor.getLong(j)).toString()), false);
            continue;
          case 1:
          }
        }
        finally
        {
          localCursor.close();
        }
        boolean bool3 = b(localCursor.getInt(localCursor.getColumnIndexOrThrow("err_type")));
        if (bool3)
          continue;
      }
      label458: localCursor.close();
      continue;
      label468: if (BLog.b(2))
        BLog.a("fb-mms:TransactionService", "onStart: no pending messages. Stopping service.");
      RetryScheduler.b(this);
      a(paramInt2);
      continue;
      label495: if (BLog.b(2))
        BLog.a("fb-mms:TransactionService", "onStart: launch transaction...");
      a(paramInt2, new TransactionBundle(paramIntent.getExtras()), bool2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.TransactionService
 * JD-Core Version:    0.6.0
 */