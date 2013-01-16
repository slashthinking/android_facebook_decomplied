package com.facebook.graphql.module;

import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class GraphQLModule$GraphQLJacksonInitializerProvider extends AbstractProvider<GraphQLJacksonInitializer>
{
  private GraphQLModule$GraphQLJacksonInitializerProvider(GraphQLModule paramGraphQLModule)
  {
  }

  public GraphQLJacksonInitializer a()
  {
    return new GraphQLJacksonInitializer((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.module.GraphQLModule.GraphQLJacksonInitializerProvider
 * JD-Core Version:    0.6.2
 */