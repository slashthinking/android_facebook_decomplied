package com.facebook.orca.activity;

import android.support.v4.app.ListFragment;
import com.facebook.orca.inject.FbInjector;

public class FbListFragment extends ListFragment
{
  public FbInjector c()
  {
    return FbInjector.a(p());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.FbListFragment
 * JD-Core Version:    0.6.2
 */