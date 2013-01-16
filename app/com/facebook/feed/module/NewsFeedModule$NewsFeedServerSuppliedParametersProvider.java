package com.facebook.feed.module;

import com.facebook.abtest.qe.QuickExperimentManager;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedServerSuppliedParametersProvider extends AbstractProvider<NewsFeedServerSuppliedParameters>
{
  private NewsFeedModule$NewsFeedServerSuppliedParametersProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedServerSuppliedParameters a()
  {
    return new NewsFeedServerSuppliedParameters((QuickExperimentManager)b(QuickExperimentManager.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedServerSuppliedParametersProvider
 * JD-Core Version:    0.6.0
 */