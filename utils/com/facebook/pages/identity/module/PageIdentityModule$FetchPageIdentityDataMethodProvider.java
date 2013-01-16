package com.facebook.pages.identity.module;

import android.content.res.Resources;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.pages.identity.protocol.FetchPageIdentityDataMethod;

class PageIdentityModule$FetchPageIdentityDataMethodProvider extends AbstractProvider<FetchPageIdentityDataMethod>
{
  private PageIdentityModule$FetchPageIdentityDataMethodProvider(PageIdentityModule paramPageIdentityModule)
  {
  }

  public FetchPageIdentityDataMethod a()
  {
    return new FetchPageIdentityDataMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.module.PageIdentityModule.FetchPageIdentityDataMethodProvider
 * JD-Core Version:    0.6.2
 */