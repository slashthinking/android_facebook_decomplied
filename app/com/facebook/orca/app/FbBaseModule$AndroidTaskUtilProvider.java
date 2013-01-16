package com.facebook.orca.app;

import android.app.ActivityManager;
import com.facebook.orca.common.util.AndroidTaskUtil;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$AndroidTaskUtilProvider extends AbstractProvider<AndroidTaskUtil>
{
  private FbBaseModule$AndroidTaskUtilProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public AndroidTaskUtil a()
  {
    return new AndroidTaskUtil((ActivityManager)b(ActivityManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.AndroidTaskUtilProvider
 * JD-Core Version:    0.6.0
 */