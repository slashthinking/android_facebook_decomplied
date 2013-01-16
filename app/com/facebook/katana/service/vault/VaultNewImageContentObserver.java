package com.facebook.katana.service.vault;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.facebook.common.util.Log;

class VaultNewImageContentObserver extends ContentObserver
{
  private static final Class<?> a = VaultNewImageContentObserver.class;
  private Uri b;
  private Context c;

  public VaultNewImageContentObserver(Handler paramHandler, Uri paramUri, Context paramContext)
  {
    super(paramHandler);
    this.b = paramUri;
    this.c = paramContext;
  }

  public Uri a()
  {
    return this.b;
  }

  public boolean deliverSelfNotifications()
  {
    return false;
  }

  public void onChange(boolean paramBoolean)
  {
    Log.e(a, "Detected change from " + this.b.toString());
    VaultHelpers.c(this.c, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultNewImageContentObserver
 * JD-Core Version:    0.6.0
 */