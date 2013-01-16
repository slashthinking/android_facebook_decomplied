package com.facebook.katana.orca;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.facebook.orca.contacts.favorites.InstallMessengerLoader.Result;
import com.facebook.orca.contacts.favorites.InstallMessengerLoaderFactory;

class InstallMessengerFragment$3
  implements LoaderManager.LoaderCallbacks<InstallMessengerLoader.Result>
{
  public Loader<InstallMessengerLoader.Result> a(int paramInt, Bundle paramBundle)
  {
    return InstallMessengerFragment.d(this.a).a();
  }

  public void a(Loader<InstallMessengerLoader.Result> paramLoader)
  {
  }

  public void a(Loader<InstallMessengerLoader.Result> paramLoader, InstallMessengerLoader.Result paramResult)
  {
    InstallMessengerFragment.a(this.a, paramResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.InstallMessengerFragment.3
 * JD-Core Version:    0.6.0
 */