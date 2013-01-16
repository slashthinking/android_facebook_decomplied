package com.facebook.feed.protocol;

import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.Photo;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryPhoto.PhotoField;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class FetchSingleMediaMethod
  implements ApiMethod<FetchSingleMediaParams, FetchSingleMediaResult>
{
  private final GraphQLStoryHelper a;
  private final GraphQLHelper b;

  public FetchSingleMediaMethod(GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper)
  {
    this.a = paramGraphQLStoryHelper;
    this.b = paramGraphQLHelper;
  }

  public FetchSingleMediaResult a(FetchSingleMediaParams paramFetchSingleMediaParams, ApiResponse paramApiResponse)
  {
    JsonParser localJsonParser = this.b.a("fetch_single_media", 1, paramApiResponse.d());
    GraphQLMedia localGraphQLMedia = (GraphQLMedia)((ObjectMapper)localJsonParser.getCodec()).readValue(localJsonParser, GraphQLMedia.class);
    if (localGraphQLMedia == null)
      throw new Exception("Invalid JSON result");
    return new FetchSingleMediaResult(localGraphQLMedia);
  }

  public ApiRequest a(FetchSingleMediaParams paramFetchSingleMediaParams)
  {
    GraphQlQueryRootCallNode localGraphQlQueryRootCallNode = GraphQl.a(paramFetchSingleMediaParams.a());
    GraphQlQueryPhoto.PhotoField[] arrayOfPhotoField = new GraphQlQueryPhoto.PhotoField[2];
    arrayOfPhotoField[0] = GraphQl.Photo.a;
    arrayOfPhotoField[1] = GraphQl.Photo.a(GraphQlNewsFeedDefaults.n);
    GraphQlQuery localGraphQlQuery = localGraphQlQueryRootCallNode.a(GraphQl.Photo.a(arrayOfPhotoField));
    ImmutableMap localImmutableMap = new ImmutableMap.Builder().b(GraphQlNewsFeedDefaults.c, String.valueOf(paramFetchSingleMediaParams.c())).b(GraphQlNewsFeedDefaults.b, "null").b(GraphQlNewsFeedDefaults.a, "null").b(GraphQlNewsFeedDefaults.g, String.valueOf(paramFetchSingleMediaParams.b())).b(GraphQlNewsFeedDefaults.f, "null").b(GraphQlNewsFeedDefaults.e, "null").b(GraphQlQueryDefaults.e, this.a.a()).b();
    return this.b.a("fetch_single_media", localGraphQlQuery.a(localImmutableMap));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchSingleMediaMethod
 * JD-Core Version:    0.6.0
 */