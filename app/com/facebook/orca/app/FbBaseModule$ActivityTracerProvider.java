package com.facebook.orca.app;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.ActivityTracer;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$ActivityTracerProvider extends AbstractProvider<ActivityTracer>
{
  private FbBaseModule$ActivityTracerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public ActivityTracer a()
  {
    return new ActivityTracer((AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ActivityTracerProvider
 * JD-Core Version:    0.6.0
 */