package com.facebook.graphql.module;

import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class GraphQLModule$GraphQLHelperProvider extends AbstractProvider<GraphQLHelper>
{
  private GraphQLModule$GraphQLHelperProvider(GraphQLModule paramGraphQLModule)
  {
  }

  public GraphQLHelper a()
  {
    return new GraphQLHelper((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.module.GraphQLModule.GraphQLHelperProvider
 * JD-Core Version:    0.6.2
 */