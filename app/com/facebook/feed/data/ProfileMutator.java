package com.facebook.feed.data;

import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfile.Builder;
import com.google.common.base.Preconditions;

public class ProfileMutator
{
  public GraphQLProfile a(GraphQLProfile paramGraphQLProfile)
  {
    Preconditions.checkArgument(GraphQLObjectType.ObjectType.Page.equals(paramGraphQLProfile.objectType.a()), "Cannot like a profile that is not a page.");
    if (!paramGraphQLProfile.doesViewerLike);
    for (boolean bool = true; ; bool = false)
    {
      GraphQLProfile.Builder localBuilder = new GraphQLProfile.Builder().a(paramGraphQLProfile);
      localBuilder.a(bool);
      return localBuilder.b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.ProfileMutator
 * JD-Core Version:    0.6.0
 */