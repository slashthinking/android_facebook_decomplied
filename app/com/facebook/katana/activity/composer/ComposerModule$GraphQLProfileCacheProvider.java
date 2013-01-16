package com.facebook.katana.activity.composer;

import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.katana.provider.ConnectionsProviderInjectable;
import com.facebook.orca.inject.AbstractProvider;

class ComposerModule$GraphQLProfileCacheProvider extends AbstractProvider<GraphQLProfileCache>
{
  private ComposerModule$GraphQLProfileCacheProvider(ComposerModule paramComposerModule)
  {
  }

  public GraphQLProfileCache a()
  {
    return new DefaultGraphQLProfileCache(ComposerModule.a(this.a), (ConnectionsProviderInjectable)b(ConnectionsProviderInjectable.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerModule.GraphQLProfileCacheProvider
 * JD-Core Version:    0.6.0
 */