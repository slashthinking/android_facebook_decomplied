package com.facebook.orca.app;

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$LocalBroadcastManagerProvider extends AbstractProvider<LocalBroadcastManager>
{
  private FbBaseModule$LocalBroadcastManagerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public LocalBroadcastManager a()
  {
    return LocalBroadcastManager.a((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.LocalBroadcastManagerProvider
 * JD-Core Version:    0.6.0
 */