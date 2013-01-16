package com.facebook.orca.app;

import android.app.Activity;
import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$ActivityProvider extends AbstractProvider<Activity>
{
  private FbBaseModule$ActivityProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public Activity a()
  {
    return (Activity)b(Context.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ActivityProvider
 * JD-Core Version:    0.6.0
 */