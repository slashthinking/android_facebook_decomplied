package com.facebook.katana.activity.media.vault;

import android.os.AsyncTask;
import com.facebook.common.util.Log;
import com.facebook.katana.service.vault.methods.VaultImageDeleteMethod;
import com.facebook.katana.service.vault.methods.VaultImageGetMethod;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.photos.photogallery.Photo.PhotoSize;
import com.facebook.photos.photogallery.photos.VaultPhoto;

class VaultSyncScreenFragment$DeleteImageTask extends AsyncTask<VaultPhoto, Void, Boolean>
{
  private VaultPhoto b;

  private VaultSyncScreenFragment$DeleteImageTask(VaultSyncScreenFragment paramVaultSyncScreenFragment)
  {
  }

  protected Boolean a(VaultPhoto[] paramArrayOfVaultPhoto)
  {
    this.b = paramArrayOfVaultPhoto[0];
    publishProgress(new Void[0]);
    SingleMethodRunner localSingleMethodRunner = (SingleMethodRunner)FbInjector.a(VaultSyncScreenFragment.h(this.a)).a(SingleMethodRunner.class);
    try
    {
      localSingleMethodRunner.a((VaultImageGetMethod)FbInjector.a(VaultSyncScreenFragment.h(this.a)).a(VaultImageGetMethod.class), Long.valueOf(this.b.a()));
    }
    catch (Exception localException1)
    {
      try
      {
        for (localBoolean = (Boolean)localSingleMethodRunner.a((VaultImageDeleteMethod)FbInjector.a(VaultSyncScreenFragment.h(this.a)).a(VaultImageDeleteMethod.class), Long.valueOf(this.b.a())); ; localBoolean = Boolean.valueOf(true))
        {
          return localBoolean;
          localException1 = localException1;
        }
      }
      catch (Exception localException2)
      {
        while (true)
        {
          Log.a(VaultSyncScreenFragment.class, "Error running SingleMethodRunner", localException2);
          new VaultDeleteFailedDialog().a(this.a.r(), "delete_failed_dialog");
          Boolean localBoolean = Boolean.valueOf(false);
        }
      }
    }
  }

  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      publishProgress(new Void[0]);
      VaultSyncScreenFragment.f(this.a).a(this.b);
      new VaultSyncScreenFragment.RefreshGridTask(this.a).execute(new Void[0]);
    }
    while (true)
    {
      return;
      VaultSyncScreenFragment.f(this.a).a(this.b.a(Photo.PhotoSize.THUMBNAIL).a());
    }
  }

  protected void a(Void[] paramArrayOfVoid)
  {
    VaultSyncScreenFragment.f(this.a).b(this.b.a(Photo.PhotoSize.THUMBNAIL).a());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.DeleteImageTask
 * JD-Core Version:    0.6.0
 */