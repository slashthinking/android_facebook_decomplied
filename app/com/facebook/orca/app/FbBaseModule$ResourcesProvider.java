package com.facebook.orca.app;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$ResourcesProvider extends AbstractProvider<Resources>
{
  private FbBaseModule$ResourcesProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public Resources a()
  {
    return FbBaseModule.b(this.a).getResources();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ResourcesProvider
 * JD-Core Version:    0.6.0
 */