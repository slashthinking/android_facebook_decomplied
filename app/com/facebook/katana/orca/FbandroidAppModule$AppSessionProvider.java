package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$AppSessionProvider extends AbstractProvider<AppSession>
{
  private FbandroidAppModule$AppSessionProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public AppSession a()
  {
    return AppSession.b((Context)b(Context.class), false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.AppSessionProvider
 * JD-Core Version:    0.6.0
 */