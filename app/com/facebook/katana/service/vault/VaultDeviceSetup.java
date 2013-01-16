package com.facebook.katana.service.vault;

import android.content.Context;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.katana.model.FacebookVaultDevice;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.vault.methods.VaultDeviceGetMethod;
import com.facebook.katana.service.vault.methods.VaultDeviceGetParams;
import com.facebook.katana.service.vault.methods.VaultDevicePostMethod;
import com.facebook.katana.service.vault.methods.VaultDevicePostParams;
import com.facebook.katana.service.vault.methods.VaultDeviceUpdateMethod;
import com.facebook.katana.service.vault.methods.VaultDeviceUpdateParams;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.protocol.base.ApiException;
import com.facebook.orca.protocol.base.SingleMethodRunner;

public class VaultDeviceSetup
{
  private static final String a = VaultDeviceSetup.class.getSimpleName();
  private final Context b;
  private final SingleMethodRunner c;
  private final VaultDevicePostMethod d;
  private final VaultDeviceGetMethod e;
  private final VaultDeviceUpdateMethod f;
  private final UniqueIdForDeviceHolder g;
  private long h;
  private long i;

  public VaultDeviceSetup(Context paramContext, SingleMethodRunner paramSingleMethodRunner, VaultDevicePostMethod paramVaultDevicePostMethod, VaultDeviceGetMethod paramVaultDeviceGetMethod, VaultDeviceUpdateMethod paramVaultDeviceUpdateMethod, UniqueIdForDeviceHolder paramUniqueIdForDeviceHolder)
  {
    this.b = paramContext;
    this.c = paramSingleMethodRunner;
    this.d = paramVaultDevicePostMethod;
    this.e = paramVaultDeviceGetMethod;
    this.f = paramVaultDeviceUpdateMethod;
    this.g = paramUniqueIdForDeviceHolder;
    this.h = UserValuesManager.g(this.b);
    this.i = UserValuesManager.i(this.b);
  }

  private void e()
  {
    UserValuesManager.a(this.b, this.h);
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(this.h);
    Log.d(str, StringLocaleUtil.a("stored device info -- device_id: %d", arrayOfObject));
  }

  public void a(long paramLong1, long paramLong2)
  {
    VaultDeviceUpdateParams localVaultDeviceUpdateParams = new VaultDeviceUpdateParams(paramLong1);
    localVaultDeviceUpdateParams.a(paramLong2 / 1000L);
    try
    {
      this.c.a(this.f, localVaultDeviceUpdateParams);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a(a, localException);
        if (!(localException instanceof ApiException))
          continue;
        ErrorReporting.a("vault_device_update_api exception", localException.getMessage());
      }
    }
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    VaultDeviceUpdateParams localVaultDeviceUpdateParams = new VaultDeviceUpdateParams(paramLong);
    localVaultDeviceUpdateParams.b(paramBoolean);
    try
    {
      this.c.a(this.f, localVaultDeviceUpdateParams);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a(a, localException);
        if (!(localException instanceof ApiException))
          continue;
        ErrorReporting.a("vault_device_update_api exception", localException.getMessage());
      }
    }
  }

  public boolean a()
  {
    if (this.h > 0L);
    for (int j = 1; ; j = 0)
      return j;
  }

  public boolean b()
  {
    String str1 = this.g.b();
    Log.e("fetching VaultDevice and updating device to match local prefs");
    String str2 = UserValuesManager.j(this.b);
    boolean bool = UserValuesManager.h(this.b);
    VaultDevicePostParams localVaultDevicePostParams;
    if (FacebookVaultDevice.a(str2))
      localVaultDevicePostParams = new VaultDevicePostParams(str1, true, str2, bool);
    try
    {
      FacebookVaultDevice localFacebookVaultDevice = (FacebookVaultDevice)this.c.a(this.d, localVaultDevicePostParams);
      if (localFacebookVaultDevice != null)
      {
        this.h = localFacebookVaultDevice.mFbid;
        e();
        if (localFacebookVaultDevice.mLastSyncTime > 0L)
        {
          String str4 = a;
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = Long.valueOf(this.h);
          arrayOfObject2[1] = Long.valueOf(localFacebookVaultDevice.mLastSyncTime);
          Log.e(str4, StringUtil.a("Setting up previously registered device id: %d, last sync %d", arrayOfObject2));
          this.i = (1000L * localFacebookVaultDevice.mLastSyncTime);
          UserValuesManager.b(this.b, this.i);
          UserValuesManager.e(this.b, 1000L * localFacebookVaultDevice.mTimeCreated);
          UserValuesManager.c(this.b, localFacebookVaultDevice.mSyncOlderPhotos);
        }
        for (j = 1; ; j = 0)
        {
          return j;
          localVaultDevicePostParams = new VaultDevicePostParams(str1);
          break;
          long l1 = System.currentTimeMillis();
          long l2 = l1 / 1000L;
          this.i = l1;
          UserValuesManager.b(this.b, this.i);
          UserValuesManager.e(this.b, l1);
          ((VaultDeviceSetup)FbInjector.a(this.b).a(VaultDeviceSetup.class)).a(this.h, l2);
          String str3 = a;
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Long.valueOf(this.h);
          arrayOfObject1[1] = Long.valueOf(l1);
          Log.e(str3, StringUtil.a("Setting up new device id: %d, last sync %d", arrayOfObject1));
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a(a, localException);
        if ((localException instanceof ApiException))
          ErrorReporting.a(a, "exception when running mDevicePostMethod", localException);
        int j = 0;
      }
    }
  }

  public boolean c()
  {
    VaultDeviceGetParams localVaultDeviceGetParams = new VaultDeviceGetParams(this.g.b());
    int j;
    try
    {
      FacebookVaultDevice localFacebookVaultDevice = (FacebookVaultDevice)this.c.a(this.e, localVaultDeviceGetParams);
      if (localFacebookVaultDevice != null)
      {
        this.h = localFacebookVaultDevice.mFbid;
        this.i = (1000L * localFacebookVaultDevice.mLastSyncTime);
        if (!localFacebookVaultDevice.mEnabled)
        {
          Log.e(a, "Switching local sync_mode to off per server.");
          UserValuesManager.e(this.b, "OFF");
        }
        while (true)
        {
          e();
          UserValuesManager.e(this.b, 1000L * localFacebookVaultDevice.mTimeCreated);
          UserValuesManager.c(this.b, localFacebookVaultDevice.mSyncOlderPhotos);
          j = 1;
          break;
          if (!FacebookVaultDevice.a(localFacebookVaultDevice.mSyncMode))
          {
            Log.a(a, "invalid sync mode for device: " + localFacebookVaultDevice.mSyncMode);
            ErrorReporting.a("vault_device_setup bad sync mode", "invalid sync mode for device: " + localFacebookVaultDevice.mSyncMode);
            j = 0;
            break;
          }
          String str = a;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localFacebookVaultDevice.mSyncMode;
          Log.e(str, StringUtil.a("Switching local sync_mode to on (%s) per server.", arrayOfObject));
          UserValuesManager.e(this.b, localFacebookVaultDevice.mSyncMode);
        }
      }
    }
    catch (Exception localException)
    {
      Log.a(a, localException);
      if ((localException instanceof ApiException))
        ErrorReporting.a(a, "exception when running mDevicePostMethod", localException);
      j = 0;
    }
    return j;
  }

  public boolean d()
  {
    long l = UserValuesManager.g(this.b);
    String str1 = UserValuesManager.j(this.b);
    boolean bool1;
    if (!str1.equals("OFF"))
      bool1 = true;
    while (true)
    {
      String str2 = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Long.valueOf(l);
      arrayOfObject[1] = str1;
      Log.e(str2, StringLocaleUtil.a("updating device (%d) to %s", arrayOfObject));
      VaultDeviceUpdateParams localVaultDeviceUpdateParams = new VaultDeviceUpdateParams(l);
      localVaultDeviceUpdateParams.a(bool1);
      if (bool1)
        localVaultDeviceUpdateParams.a(str1);
      try
      {
        boolean bool4 = ((Boolean)this.c.a(this.f, localVaultDeviceUpdateParams)).booleanValue();
        bool3 = bool4;
        return bool3;
        bool1 = false;
      }
      catch (Exception localException)
      {
        while (true)
        {
          Log.a(a, localException);
          boolean bool2 = localException instanceof ApiException;
          boolean bool3 = false;
          if (!bool2)
            continue;
          ErrorReporting.a("vault_device_update_api exception: " + localException.getMessage(), localException.getMessage(), localException);
          bool3 = false;
        }
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultDeviceSetup
 * JD-Core Version:    0.6.0
 */