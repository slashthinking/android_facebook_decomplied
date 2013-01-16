package com.facebook.katana.service.vault;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.util.Log;

public class VaultObserverService extends Service
{
  private static final Class<?> a = VaultObserverService.class;
  private VaultNewImageContentObserver b;

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    Log.e(a, "Enabling Vault Observer Service");
    this.b = new VaultNewImageContentObserver(new Handler(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this);
    getContentResolver().registerContentObserver(this.b.a(), true, this.b);
    VaultHelpers.c(this, 1);
  }

  public void onDestroy()
  {
    Log.e(a, "Disabling Vault Observer Service");
    getContentResolver().unregisterContentObserver(this.b);
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Log.e(a, "Starting Vault Observer Service");
    return 1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultObserverService
 * JD-Core Version:    0.6.0
 */