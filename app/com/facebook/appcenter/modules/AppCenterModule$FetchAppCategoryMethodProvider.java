package com.facebook.appcenter.modules;

import android.content.res.Resources;
import com.facebook.appcenter.protocol.FetchAppCategoryMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$FetchAppCategoryMethodProvider extends AbstractProvider<FetchAppCategoryMethod>
{
  private AppCenterModule$FetchAppCategoryMethodProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public FetchAppCategoryMethod a()
  {
    return new FetchAppCategoryMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.FetchAppCategoryMethodProvider
 * JD-Core Version:    0.6.0
 */