package com.facebook.orca.threadlist;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.facebook.orca.contacts.divebar.DivebarLoader.Result;
import com.facebook.orca.contacts.divebar.DivebarLoaderFactory;

class ThreadListFragment$5
  implements LoaderManager.LoaderCallbacks<DivebarLoader.Result>
{
  public Loader<DivebarLoader.Result> a(int paramInt, Bundle paramBundle)
  {
    return ThreadListFragment.b(this.a).a();
  }

  public void a(Loader<DivebarLoader.Result> paramLoader)
  {
  }

  public void a(Loader<DivebarLoader.Result> paramLoader, DivebarLoader.Result paramResult)
  {
    ThreadListFragment.a(this.a, paramResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListFragment.5
 * JD-Core Version:    0.6.0
 */