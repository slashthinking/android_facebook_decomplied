package com.facebook.appcenter.modules;

import android.content.res.Resources;
import com.facebook.appcenter.protocol.FetchAppListMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$FetchAppListMethodProvider extends AbstractProvider<FetchAppListMethod>
{
  private AppCenterModule$FetchAppListMethodProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public FetchAppListMethod a()
  {
    return new FetchAppListMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.FetchAppListMethodProvider
 * JD-Core Version:    0.6.0
 */