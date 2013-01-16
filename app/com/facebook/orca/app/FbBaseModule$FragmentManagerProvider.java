package com.facebook.orca.app;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$FragmentManagerProvider extends AbstractProvider<FragmentManager>
{
  private FbBaseModule$FragmentManagerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public FragmentManager a()
  {
    Activity localActivity = (Activity)b(Activity.class);
    if ((localActivity instanceof FragmentActivity));
    for (FragmentManager localFragmentManager = ((FragmentActivity)localActivity).g(); ; localFragmentManager = null)
      return localFragmentManager;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.FragmentManagerProvider
 * JD-Core Version:    0.6.0
 */