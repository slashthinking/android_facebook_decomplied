package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class GraphQLMailingAddresses
{

  @JsonProperty("nodes")
  public final List<GraphQLMailingAddress> addresses = ImmutableList.d();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLMailingAddresses
 * JD-Core Version:    0.6.2
 */