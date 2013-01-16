package com.facebook.graphql.model;

public class GraphQLProfile$Builder
{
  private String a = null;
  private String b = null;
  private String c = null;
  private GraphQLImage d = null;
  private boolean e = false;
  private boolean f = false;
  private GraphQLMutualFriends g = null;
  private GraphQLObjectType h = null;
  private GraphQLBirthdate i = null;

  public Builder a(GraphQLImage paramGraphQLImage)
  {
    this.d = paramGraphQLImage;
    return this;
  }

  public Builder a(GraphQLObjectType paramGraphQLObjectType)
  {
    this.h = paramGraphQLObjectType;
    return this;
  }

  public Builder a(GraphQLProfile paramGraphQLProfile)
  {
    this.a = paramGraphQLProfile.id;
    this.b = paramGraphQLProfile.name;
    this.c = paramGraphQLProfile.friendshipStatus;
    this.d = paramGraphQLProfile.profilePicture;
    this.e = paramGraphQLProfile.doesViewerLike;
    this.f = paramGraphQLProfile.canViewerSendGift;
    this.g = paramGraphQLProfile.mutualFriends;
    this.h = paramGraphQLProfile.objectType;
    return this;
  }

  public Builder a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public Builder b(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public GraphQLProfile b()
  {
    return new GraphQLProfile(this);
  }

  public Builder c(String paramString)
  {
    this.b = paramString;
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLProfile.Builder
 * JD-Core Version:    0.6.2
 */