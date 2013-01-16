package com.facebook.katana.orca;

import com.facebook.common.util.GitHashUtil;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$GitHashProvider extends AbstractProvider<String>
{
  private FbandroidAppModule$GitHashProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public String a()
  {
    return GitHashUtil.a(FbandroidAppModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.GitHashProvider
 * JD-Core Version:    0.6.0
 */