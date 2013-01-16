package com.facebook.orca.contacts.favorites;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.facebook.orca.contacts.divebar.DivebarLoader.Result;
import com.facebook.orca.contacts.divebar.DivebarLoaderFactory;

class EditFavoritesActivity$3
  implements LoaderManager.LoaderCallbacks<DivebarLoader.Result>
{
  public Loader<DivebarLoader.Result> a(int paramInt, Bundle paramBundle)
  {
    return EditFavoritesActivity.c(this.a).b();
  }

  public void a(Loader<DivebarLoader.Result> paramLoader)
  {
  }

  public void a(Loader<DivebarLoader.Result> paramLoader, DivebarLoader.Result paramResult)
  {
    EditFavoritesActivity.a(this.a, paramResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.EditFavoritesActivity.3
 * JD-Core Version:    0.6.0
 */