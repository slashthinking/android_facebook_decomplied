package com.facebook.orca.app;

import android.os.Process;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$MyProcessIdProvider extends AbstractProvider<Integer>
{
  private FbBaseModule$MyProcessIdProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public Integer a()
  {
    return Integer.valueOf(Process.myPid());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.MyProcessIdProvider
 * JD-Core Version:    0.6.0
 */