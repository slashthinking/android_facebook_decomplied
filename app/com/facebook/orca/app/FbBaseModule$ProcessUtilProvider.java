package com.facebook.orca.app;

import android.app.ActivityManager;
import com.facebook.annotations.MyProcessId;
import com.facebook.common.util.ProcessUtil;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$ProcessUtilProvider extends AbstractProvider<ProcessUtil>
{
  private FbBaseModule$ProcessUtilProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public ProcessUtil a()
  {
    return new ProcessUtil(FbBaseModule.b(this.a), (ActivityManager)b(ActivityManager.class, FromApplication.class), a(Integer.class, MyProcessId.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ProcessUtilProvider
 * JD-Core Version:    0.6.0
 */