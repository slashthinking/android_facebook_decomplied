package com.facebook.common.util;

import com.facebook.orca.inject.AbstractProvider;

class FbBaseCommonUtilsModule$StatFsHelperProvider extends AbstractProvider<StatFsHelper>
{
  private FbBaseCommonUtilsModule$StatFsHelperProvider(FbBaseCommonUtilsModule paramFbBaseCommonUtilsModule)
  {
  }

  public StatFsHelper a()
  {
    return new StatFsHelper(FbBaseCommonUtilsModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FbBaseCommonUtilsModule.StatFsHelperProvider
 * JD-Core Version:    0.6.0
 */