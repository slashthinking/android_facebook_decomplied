package com.facebook.feed.data;

import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLActionLink.Builder;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLProfile;
import com.google.common.base.Preconditions;

public class ActionLinkMutator
{
  private final ProfileMutator a;

  public ActionLinkMutator(ProfileMutator paramProfileMutator)
  {
    this.a = paramProfileMutator;
  }

  public GraphQLActionLink a(GraphQLActionLink paramGraphQLActionLink)
  {
    Preconditions.checkArgument(GraphQLObjectType.ObjectType.LikePageActionLink.equals(paramGraphQLActionLink.type.a()), "Cannot toggle page like on a non-page_like action link.");
    GraphQLProfile localGraphQLProfile = this.a.a(paramGraphQLActionLink.page);
    GraphQLActionLink.Builder localBuilder = new GraphQLActionLink.Builder().a(paramGraphQLActionLink);
    localBuilder.a(localGraphQLProfile);
    return localBuilder.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.ActionLinkMutator
 * JD-Core Version:    0.6.0
 */