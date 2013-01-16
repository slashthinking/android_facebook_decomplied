package com.facebook.katana.service.vault;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.util.logging.VaultLogger;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VaultSyncService extends Service
{
  private static final Class<?> a = VaultSyncService.class;
  private Looper b;
  private Handler c;
  private VaultLogger d;
  private long e;
  private VaultTable f;
  private VaultNotificationManager g;

  private long a(int paramInt)
  {
    long l;
    if (paramInt == 0)
      l = 30000L;
    while (true)
    {
      return l;
      l = 0L;
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      this.d.a(paramInt2, paramInt1);
      Class localClass = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      Log.e(localClass, StringUtil.a("%d jobs/images queued for sync reason: %d", arrayOfObject));
    }
  }

  private void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    while (true)
    {
      int i;
      VaultSyncJobGenerator localVaultSyncJobGenerator;
      try
      {
        i = paramIntent.getIntExtra("sync_reason", -1);
        localVaultSyncJobGenerator = (VaultSyncJobGenerator)FbInjector.a(paramContext).a(VaultSyncJobGenerator.class);
        if (!((VaultLocalImageFetcher)FbInjector.a(this).a(VaultLocalImageFetcher.class)).b())
          continue;
        Log.d(a, "bailing from doJobGen because there are no local images");
        this.g.c();
        return;
        if (VaultHelpers.a(this, i))
          continue;
        Log.d(a, "bailing from doJobGen because currently not eligible to sync");
        this.g.c();
        stopSelfResult(paramInt);
        continue;
        this.f.a(1800000L);
        Set localSet = this.f.b();
        this.g.a(localSet);
        j = 0;
        if (i != 8)
          continue;
        if (j != 0)
          break label372;
        Log.e(a, StringUtil.a("No syncable photos found.", new Object[0]));
        this.g.c();
        stopSelfResult(paramInt);
        continue;
        if (i == 3)
        {
          Log.e(a, "sync triggered from retry alarm");
          j = localVaultSyncJobGenerator.a(50);
          if (j != 0)
            continue;
          Log.d("no failures to retry, resetting retryInterval");
          UserValuesManager.c(paramContext, 120000L);
          continue;
        }
      }
      finally
      {
        stopSelfResult(paramInt);
      }
      if (i == 11)
      {
        String[] arrayOfString = paramIntent.getStringArrayExtra("photo_hashes");
        if (arrayOfString != null)
        {
          n = localVaultSyncJobGenerator.a(new HashSet(Arrays.asList(arrayOfString)), i);
          break label422;
        }
      }
      else
      {
        if (i == 12)
        {
          int m = localVaultSyncJobGenerator.a(50, i);
          j = m + localVaultSyncJobGenerator.b(Math.max(0, 50 - m));
          continue;
        }
        j = localVaultSyncJobGenerator.a(50, i);
        if ((j != 0) || (!UserValuesManager.h(paramContext)) || (!this.f.c()))
          continue;
        do
        {
          int k = b();
          j = localVaultSyncJobGenerator.a(50, 10);
          if (k <= 0)
            break;
        }
        while (j == 0);
        continue;
        label372: long l1 = UserValuesManager.g(paramContext);
        long l2 = System.currentTimeMillis();
        UserValuesManager.b(paramContext, l2);
        ((VaultDeviceSetup)FbInjector.a(paramContext).a(VaultDeviceSetup.class)).a(l1, l2);
        a(j, i);
        continue;
      }
      int n = 0;
      label422: int j = n;
    }
  }

  private int b()
  {
    Set localSet = this.f.a(6);
    this.g.a(localSet);
    return localSet.size();
  }

  private boolean b(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != 5) && (paramInt != 6) && (paramInt != 7) && (paramInt != 9) && (paramInt != 10))
    {
      i = 0;
      if (paramInt != 4);
    }
    else
    {
      if (System.currentTimeMillis() - this.e >= 2000L)
        break label65;
    }
    for (int i = 1; ; i = 0)
    {
      return i;
      label65: this.e = System.currentTimeMillis();
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    HandlerThread localHandlerThread = new HandlerThread("vault_thread");
    localHandlerThread.setUncaughtExceptionHandler(new VaultSyncService.1(this));
    localHandlerThread.start();
    this.b = localHandlerThread.getLooper();
    this.c = new Handler(this.b);
    this.e = 0L;
    this.d = new VaultLogger(this);
    this.f = ((VaultTable)FbInjector.a(this).a(VaultTable.class));
    this.g = ((VaultNotificationManager)FbInjector.a(this).a(VaultNotificationManager.class));
  }

  public void onDestroy()
  {
    super.onDestroy();
    Log.e(a, "Stopping VaultSyncService");
    this.b.quit();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
      ErrorReporting.a("VaultSyncService onStartCommand", "started with null intent");
    while (true)
    {
      return 2;
      if (!paramIntent.hasExtra("sync_reason"))
      {
        Log.a(a, "intent sent to VaultSyncService had no reason key, so no sync queued");
        continue;
      }
      int i = paramIntent.getIntExtra("sync_reason", -1);
      if (b(i))
      {
        Class localClass2 = a;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Integer.valueOf(i);
        arrayOfObject2[1] = Integer.valueOf(paramInt2);
        Log.d(localClass2, StringUtil.a("skip duplicate sync with reason: %d, start_id: %d", arrayOfObject2));
        continue;
      }
      if ((!((VaultDeviceSetup)FbInjector.a(this).a(VaultDeviceSetup.class)).a()) && (i != 4))
      {
        Log.a(a, "Device has not been setup, and sync reason not SYNC_REASON_SETUP");
        continue;
      }
      this.c.postDelayed(new VaultSyncService.VaultSyncServiceRunnable(this, this, paramIntent, paramInt2), a(i));
      Class localClass1 = a;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(paramInt2);
      arrayOfObject1[1] = Integer.valueOf(i);
      Log.e(localClass1, StringUtil.a("Scheduling JobGen (start_id: %d, reason: %d)", arrayOfObject1));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultSyncService
 * JD-Core Version:    0.6.0
 */