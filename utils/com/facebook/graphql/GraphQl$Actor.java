package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Actor
{
  public static final GraphQlQueryActorImpl.ActorGenericField a = new GraphQlQueryActorImpl.ActorGenericField("name");
  public static final GraphQlQueryActorImpl.ActorGenericField b = new GraphQlQueryActorImpl.ActorGenericField("can_viewer_message");

  public static GraphQlQueryActorImpl.ActorGenericField a(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryActorImpl.ActorGenericField("profile_picture", paramGraphQlQueryImage);
  }

  public static GraphQlQueryActorImpl a(GraphQlQueryFieldActor[] paramArrayOfGraphQlQueryFieldActor)
  {
    return new GraphQlQueryActorImpl(ImmutableList.a(paramArrayOfGraphQlQueryFieldActor), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Actor
 * JD-Core Version:    0.6.2
 */