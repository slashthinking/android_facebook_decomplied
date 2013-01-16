package com.facebook.appcenter.modules;

import android.content.res.Resources;
import com.facebook.appcenter.protocol.FetchAppDetailMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$FetchAppDetailMethodProvider extends AbstractProvider<FetchAppDetailMethod>
{
  private AppCenterModule$FetchAppDetailMethodProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public FetchAppDetailMethod a()
  {
    return new FetchAppDetailMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.FetchAppDetailMethodProvider
 * JD-Core Version:    0.6.0
 */