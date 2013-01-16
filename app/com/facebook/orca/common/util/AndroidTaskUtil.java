package com.facebook.orca.common.util;

import android.app.ActivityManager;
import com.google.common.base.Preconditions;

public class AndroidTaskUtil
{
  private final ActivityManager a;

  public AndroidTaskUtil(ActivityManager paramActivityManager)
  {
    this.a = ((ActivityManager)Preconditions.checkNotNull(paramActivityManager));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.AndroidTaskUtil
 * JD-Core Version:    0.6.0
 */