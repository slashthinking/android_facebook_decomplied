package com.facebook.katana.service.vault;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.orca.app.AppInitLockHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class VaultSyncJobProcessor extends Service
{
  private static final Class<?> a = VaultSyncJobProcessor.class;
  private static final String b = a.getSimpleName();
  private Looper c;
  private Handler d;
  private Context e;
  private VaultSyncJobProcessor.RetryType f = VaultSyncJobProcessor.RetryType.NO_RETRY;

  private void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = VaultHelpers.b(paramContext, 3);
    long l1 = UserValuesManager.k(paramContext);
    long l2;
    if (paramBoolean)
      l2 = 120000L;
    while (true)
    {
      PendingIntent localPendingIntent = PendingIntent.getService(paramContext, 0, localIntent, 0);
      ((AlarmManager)paramContext.getSystemService("alarm")).set(0, l2 + System.currentTimeMillis(), localPendingIntent);
      Log.e(b, "scheduling retry with interval: " + l2);
      UserValuesManager.c(paramContext, Math.min(l2 * 2L, 43200000L));
      return;
      l2 = l1;
    }
  }

  private void a(VaultImageProviderRow paramVaultImageProviderRow, int paramInt)
  {
    this.d.postAtFrontOfQueue(new VaultSyncJobProcessor.VaultSyncJobRunnable(this, paramVaultImageProviderRow, paramInt));
  }

  private void b(VaultImageProviderRow paramVaultImageProviderRow, int paramInt)
  {
    this.d.post(new VaultSyncJobProcessor.VaultSyncJobRunnable(this, paramVaultImageProviderRow, paramInt));
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    HandlerThread localHandlerThread = new HandlerThread("vault_sync_job_processor");
    localHandlerThread.setUncaughtExceptionHandler(new VaultSyncJobProcessor.1(this));
    localHandlerThread.start();
    this.e = this;
    this.c = localHandlerThread.getLooper();
    this.d = new VaultSyncJobProcessor.2(this, this.c);
  }

  public void onDestroy()
  {
    super.onDestroy();
    Log.e(a, "VaultSyncJobProcessor's message queue is now empty, notify SyncService and stop the JobProcessor service");
    this.c.quit();
    VaultHelpers.c(this.e, 7);
    Context localContext;
    if (this.f != VaultSyncJobProcessor.RetryType.NO_RETRY)
    {
      localContext = this.e;
      if (this.f != VaultSyncJobProcessor.RetryType.RESET_RETRY)
        break label69;
    }
    label69: for (boolean bool = true; ; bool = false)
    {
      a(localContext, bool);
      this.f = VaultSyncJobProcessor.RetryType.NO_RETRY;
      return;
    }
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
      ErrorReporting.a("VaultSyncJobProcessor onStartCommand", "started with null intent");
    while (true)
    {
      return 2;
      Log.e(a, "Starting VaultSyncJobProcessor Service with startId " + paramInt2);
      int i = paramIntent.getIntExtra("sync_reason", -1);
      int j = paramIntent.getIntExtra("queuing_type", 2);
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("queuing_objects");
      if ((localArrayList == null) || (localArrayList.size() <= 0))
        continue;
      if (j == 1)
        Collections.reverse(localArrayList);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        VaultImageProviderRow localVaultImageProviderRow = (VaultImageProviderRow)localIterator.next();
        if (j == 2)
        {
          b(localVaultImageProviderRow, i);
          continue;
        }
        a(localVaultImageProviderRow, i);
      }
      this.d.sendMessage(Message.obtain(this.d, 1, paramInt2, 0));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultSyncJobProcessor
 * JD-Core Version:    0.6.0
 */