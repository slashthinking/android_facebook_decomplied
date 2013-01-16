package com.facebook.orca.app;

import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.DefaultAndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import java.util.concurrent.ExecutorService;

class FbBaseModule$AndroidThreadUtilProvider extends AbstractProvider<AndroidThreadUtil>
{
  private FbBaseModule$AndroidThreadUtilProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public AndroidThreadUtil a()
  {
    return new DefaultAndroidThreadUtil((ExecutorService)b(ExecutorService.class, DefaultExecutorService.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.AndroidThreadUtilProvider
 * JD-Core Version:    0.6.0
 */