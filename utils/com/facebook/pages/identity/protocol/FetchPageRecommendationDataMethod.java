package com.facebook.pages.identity.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.Actor;
import com.facebook.graphql.GraphQl.ContactRecommendationField;
import com.facebook.graphql.GraphQl.Image;
import com.facebook.graphql.GraphQl.Node;
import com.facebook.graphql.GraphQl.Page;
import com.facebook.graphql.GraphQl.PageRecommendationsConnection;
import com.facebook.graphql.GraphQl.PageStarRatersConnection;
import com.facebook.graphql.GraphQl.PageStarRatersEdge;
import com.facebook.graphql.GraphQl.TextWithEntities;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryContactRecommendationField.ContactRecommendationFieldField;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryFieldActor;
import com.facebook.graphql.GraphQlQueryImage;
import com.facebook.graphql.GraphQlQueryImage.CallOnImage;
import com.facebook.graphql.GraphQlQueryPage.PageField;
import com.facebook.graphql.GraphQlQueryPageRecommendationsConnection;
import com.facebook.graphql.GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection;
import com.facebook.graphql.GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField;
import com.facebook.graphql.GraphQlQueryPageStarRatersConnection;
import com.facebook.graphql.GraphQlQueryPageStarRatersConnection.CallOnPageStarRatersConnection;
import com.facebook.graphql.GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField;
import com.facebook.graphql.GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.GraphQlQueryTextWithEntities.TextWithEntitiesField;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Arrays;
import java.util.List;

public class FetchPageRecommendationDataMethod
  implements ApiMethod<FetchPageRecommendationDataMethod.Params, GraphQueryResultEntry>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("recommender_image_size");
  private static final List<GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField> b;
  private static final GraphQlQueryPage.PageField c = GraphQl.Page.a(localGraphQlQueryPageStarRatersConnection.a(arrayOfPageStarRatersConnectionField));
  private Resources d;
  private GraphQLHelper e;

  static
  {
    GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField[] arrayOfPageRecommendationsConnectionField = new GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField[2];
    GraphQlQueryContactRecommendationField.ContactRecommendationFieldField[] arrayOfContactRecommendationFieldField = new GraphQlQueryContactRecommendationField.ContactRecommendationFieldField[4];
    arrayOfContactRecommendationFieldField[0] = GraphQl.ContactRecommendationField.c;
    GraphQlQueryFieldActor[] arrayOfGraphQlQueryFieldActor = new GraphQlQueryFieldActor[3];
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage1 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage1[0] = GraphQl.Image.a(a);
    arrayOfGraphQlQueryFieldActor[0] = GraphQl.Actor.a(GraphQl.Image.a(arrayOfCallOnImage1).a(GraphQlQueryDefaults.c));
    arrayOfGraphQlQueryFieldActor[1] = GraphQl.Actor.a;
    arrayOfGraphQlQueryFieldActor[2] = GraphQl.User.j;
    arrayOfContactRecommendationFieldField[1] = GraphQl.ContactRecommendationField.a(GraphQl.Actor.a(arrayOfGraphQlQueryFieldActor));
    arrayOfContactRecommendationFieldField[2] = GraphQl.ContactRecommendationField.e;
    GraphQlQueryTextWithEntities.TextWithEntitiesField[] arrayOfTextWithEntitiesField = new GraphQlQueryTextWithEntities.TextWithEntitiesField[1];
    arrayOfTextWithEntitiesField[0] = GraphQl.TextWithEntities.a;
    arrayOfContactRecommendationFieldField[3] = GraphQl.ContactRecommendationField.a(GraphQl.TextWithEntities.a(arrayOfTextWithEntitiesField));
    arrayOfPageRecommendationsConnectionField[0] = GraphQl.PageRecommendationsConnection.a(GraphQl.ContactRecommendationField.a(arrayOfContactRecommendationFieldField));
    arrayOfPageRecommendationsConnectionField[1] = GraphQl.PageRecommendationsConnection.a;
    b = Arrays.asList(arrayOfPageRecommendationsConnectionField);
    GraphQlQueryPageStarRatersConnection.CallOnPageStarRatersConnection[] arrayOfCallOnPageStarRatersConnection = new GraphQlQueryPageStarRatersConnection.CallOnPageStarRatersConnection[1];
    arrayOfCallOnPageStarRatersConnection[0] = GraphQl.PageStarRatersConnection.a();
    GraphQlQueryPageStarRatersConnection localGraphQlQueryPageStarRatersConnection = GraphQl.PageStarRatersConnection.a(arrayOfCallOnPageStarRatersConnection);
    GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField[] arrayOfPageStarRatersConnectionField = new GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField[2];
    arrayOfPageStarRatersConnectionField[0] = GraphQl.PageStarRatersConnection.a;
    GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField[] arrayOfPageStarRatersEdgeField = new GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField[2];
    arrayOfPageStarRatersEdgeField[0] = GraphQl.PageStarRatersEdge.b;
    GraphQlQueryUser.UserField[] arrayOfUserField = new GraphQlQueryUser.UserField[3];
    arrayOfUserField[0] = GraphQl.User.a;
    arrayOfUserField[1] = GraphQl.User.c;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage2 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage2[0] = GraphQl.Image.a(a);
    arrayOfUserField[2] = GraphQl.User.a(GraphQl.Image.a(arrayOfCallOnImage2).a(GraphQlQueryDefaults.c));
    arrayOfPageStarRatersEdgeField[1] = GraphQl.PageStarRatersEdge.a(GraphQl.User.a(arrayOfUserField));
    arrayOfPageStarRatersConnectionField[1] = GraphQl.PageStarRatersConnection.a(GraphQl.PageStarRatersEdge.a(arrayOfPageStarRatersEdgeField));
  }

  public FetchPageRecommendationDataMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    this.d = paramResources;
    this.e = paramGraphQLHelper;
  }

  private List<GraphQlQueryPage.PageField> a(boolean paramBoolean)
  {
    GraphQlQueryPage.PageField[] arrayOfPageField2;
    if (paramBoolean)
    {
      arrayOfPageField2 = new GraphQlQueryPage.PageField[2];
      GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection[] arrayOfCallOnPageRecommendationsConnection2 = new GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection[2];
      arrayOfCallOnPageRecommendationsConnection2[0] = GraphQl.PageRecommendationsConnection.a();
      arrayOfCallOnPageRecommendationsConnection2[1] = GraphQl.PageRecommendationsConnection.a(20L);
      arrayOfPageField2[0] = GraphQl.Page.a(GraphQl.PageRecommendationsConnection.a(arrayOfCallOnPageRecommendationsConnection2).a(b));
      arrayOfPageField2[1] = c;
    }
    GraphQlQueryPage.PageField[] arrayOfPageField1;
    for (List localList = Arrays.asList(arrayOfPageField2); ; localList = Arrays.asList(arrayOfPageField1))
    {
      return localList;
      arrayOfPageField1 = new GraphQlQueryPage.PageField[2];
      GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection[] arrayOfCallOnPageRecommendationsConnection1 = new GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection[2];
      arrayOfCallOnPageRecommendationsConnection1[0] = GraphQl.PageRecommendationsConnection.b();
      arrayOfCallOnPageRecommendationsConnection1[1] = GraphQl.PageRecommendationsConnection.a(20L);
      arrayOfPageField1[0] = GraphQl.Page.a(GraphQl.PageRecommendationsConnection.a(arrayOfCallOnPageRecommendationsConnection1).a(b));
      arrayOfPageField1[1] = c;
    }
  }

  private String b(FetchPageRecommendationDataMethod.Params paramParams)
  {
    long l = paramParams.a;
    if (l > 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Invalid profile id!");
      GraphQlQuery localGraphQlQuery = GraphQl.a(String.valueOf(l)).a(GraphQl.Node.a(a(paramParams.b)));
      int i = this.d.getDimensionPixelSize(2131230735);
      return localGraphQlQuery.a(new ImmutableMap.Builder().b(a, String.valueOf(i)).b());
    }
  }

  public GraphQueryResultEntry a(FetchPageRecommendationDataMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    GraphQueryResultEntry localGraphQueryResultEntry = (GraphQueryResultEntry)this.e.a("fetch_page_recommendation", 1, paramApiResponse.d()).readValueAs(GraphQueryResultEntry.class);
    if (localGraphQueryResultEntry == null)
      throw new RuntimeException("Invalid JSON result");
    return localGraphQueryResultEntry;
  }

  public ApiRequest a(FetchPageRecommendationDataMethod.Params paramParams)
  {
    return this.e.a("fetch_page_recommendation", b(paramParams));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.protocol.FetchPageRecommendationDataMethod
 * JD-Core Version:    0.6.2
 */