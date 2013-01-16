package com.facebook.pages.identity.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.Actor;
import com.facebook.graphql.GraphQl.AggregatedEntitiesAtRange;
import com.facebook.graphql.GraphQl.ContactRecommendationField;
import com.facebook.graphql.GraphQl.EntityAtRange;
import com.facebook.graphql.GraphQl.FocusedPhoto;
import com.facebook.graphql.GraphQl.FriendsHereNowConnection;
import com.facebook.graphql.GraphQl.FriendsWhoLikeConnection;
import com.facebook.graphql.GraphQl.FriendsWhoVisitedConnection;
import com.facebook.graphql.GraphQl.Image;
import com.facebook.graphql.GraphQl.Location;
import com.facebook.graphql.GraphQl.Node;
import com.facebook.graphql.GraphQl.Page;
import com.facebook.graphql.GraphQl.PageLikersConnection;
import com.facebook.graphql.GraphQl.PageRecommendationsConnection;
import com.facebook.graphql.GraphQl.PageStarRatersConnection;
import com.facebook.graphql.GraphQl.PageVisitsConnection;
import com.facebook.graphql.GraphQl.PhoneNumber;
import com.facebook.graphql.GraphQl.Photo;
import com.facebook.graphql.GraphQl.StreetAddress;
import com.facebook.graphql.GraphQl.TextWithEntities;
import com.facebook.graphql.GraphQl.TimeRange;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQl.Vect2;
import com.facebook.graphql.GraphQl.ViewerVisitsConnection;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField;
import com.facebook.graphql.GraphQlQueryContactRecommendationField.ContactRecommendationFieldField;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryEntityAtRange.EntityAtRangeField;
import com.facebook.graphql.GraphQlQueryFieldActor;
import com.facebook.graphql.GraphQlQueryFocusedPhoto.FocusedPhotoField;
import com.facebook.graphql.GraphQlQueryFriendsHereNowConnection;
import com.facebook.graphql.GraphQlQueryFriendsHereNowConnection.CallOnFriendsHereNowConnection;
import com.facebook.graphql.GraphQlQueryFriendsHereNowConnection.FriendsHereNowConnectionField;
import com.facebook.graphql.GraphQlQueryFriendsWhoLikeConnection;
import com.facebook.graphql.GraphQlQueryFriendsWhoLikeConnection.CallOnFriendsWhoLikeConnection;
import com.facebook.graphql.GraphQlQueryFriendsWhoLikeConnection.FriendsWhoLikeConnectionField;
import com.facebook.graphql.GraphQlQueryFriendsWhoVisitedConnection;
import com.facebook.graphql.GraphQlQueryFriendsWhoVisitedConnection.CallOnFriendsWhoVisitedConnection;
import com.facebook.graphql.GraphQlQueryFriendsWhoVisitedConnection.FriendsWhoVisitedConnectionField;
import com.facebook.graphql.GraphQlQueryImage;
import com.facebook.graphql.GraphQlQueryImage.CallOnImage;
import com.facebook.graphql.GraphQlQueryLocation.LocationField;
import com.facebook.graphql.GraphQlQueryPage.PageField;
import com.facebook.graphql.GraphQlQueryPageLikersConnection.PageLikersConnectionField;
import com.facebook.graphql.GraphQlQueryPageRecommendationsConnection;
import com.facebook.graphql.GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection;
import com.facebook.graphql.GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField;
import com.facebook.graphql.GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField;
import com.facebook.graphql.GraphQlQueryPageVisitsConnection.PageVisitsConnectionField;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryPhoneNumber.PhoneNumberField;
import com.facebook.graphql.GraphQlQueryPhoto.PhotoField;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.GraphQlQueryStreetAddress.StreetAddressField;
import com.facebook.graphql.GraphQlQueryTextWithEntities.TextWithEntitiesField;
import com.facebook.graphql.GraphQlQueryTimeRange.TimeRangeField;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.GraphQlQueryVect2.Vect2Field;
import com.facebook.graphql.GraphQlQueryViewerVisitsConnection.ViewerVisitsConnectionField;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Arrays;
import java.util.List;

public class FetchPageIdentityDataMethod
  implements ApiMethod<FetchPageIdentityDataMethod.Params, GraphQueryResultEntry>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("cover_image_size");
  private static final GraphQlQueryParam b = GraphQlQueryParam.a("profile_image_size");
  private static final GraphQlQueryParam c = GraphQlQueryParam.a("user_image_size");
  private static final GraphQlQueryParam d = GraphQlQueryParam.a("num_top_recommendations");
  private static final GraphQlQueryParam e = GraphQlQueryParam.a("friends_max_num");
  private static final GraphQlQueryParam f = GraphQlQueryParam.a("friends_here_now_image_size");
  private static final List<GraphQlQueryPage.PageField> g = Arrays.asList(arrayOfPageField);
  private Resources h;
  private GraphQLHelper i;

  static
  {
    GraphQlQueryPage.PageField[] arrayOfPageField = new GraphQlQueryPage.PageField[24];
    GraphQlQueryStreetAddress.StreetAddressField[] arrayOfStreetAddressField = new GraphQlQueryStreetAddress.StreetAddressField[2];
    arrayOfStreetAddressField[0] = GraphQl.StreetAddress.e;
    arrayOfStreetAddressField[1] = GraphQl.StreetAddress.a;
    arrayOfPageField[0] = GraphQl.Page.a(GraphQl.StreetAddress.a(arrayOfStreetAddressField));
    arrayOfPageField[1] = GraphQl.Page.h;
    arrayOfPageField[2] = GraphQl.Page.i;
    arrayOfPageField[3] = GraphQl.Page.l;
    GraphQlQueryFriendsHereNowConnection.CallOnFriendsHereNowConnection[] arrayOfCallOnFriendsHereNowConnection = new GraphQlQueryFriendsHereNowConnection.CallOnFriendsHereNowConnection[1];
    arrayOfCallOnFriendsHereNowConnection[0] = GraphQl.FriendsHereNowConnection.a(e);
    GraphQlQueryFriendsHereNowConnection localGraphQlQueryFriendsHereNowConnection = GraphQl.FriendsHereNowConnection.a(arrayOfCallOnFriendsHereNowConnection);
    GraphQlQueryFriendsHereNowConnection.FriendsHereNowConnectionField[] arrayOfFriendsHereNowConnectionField = new GraphQlQueryFriendsHereNowConnection.FriendsHereNowConnectionField[1];
    GraphQlQueryUser.UserField[] arrayOfUserField1 = new GraphQlQueryUser.UserField[3];
    arrayOfUserField1[0] = GraphQl.User.a;
    arrayOfUserField1[1] = GraphQl.User.c;
    arrayOfUserField1[2] = GraphQl.User.a(a(f));
    arrayOfFriendsHereNowConnectionField[0] = GraphQl.FriendsHereNowConnection.a(GraphQl.User.a(arrayOfUserField1));
    arrayOfPageField[4] = GraphQl.Page.a(localGraphQlQueryFriendsHereNowConnection.a(arrayOfFriendsHereNowConnectionField));
    GraphQlQueryTextWithEntities.TextWithEntitiesField[] arrayOfTextWithEntitiesField1 = new GraphQlQueryTextWithEntities.TextWithEntitiesField[2];
    arrayOfTextWithEntitiesField1[0] = GraphQl.TextWithEntities.a;
    GraphQlQueryEntityAtRange.EntityAtRangeField[] arrayOfEntityAtRangeField1 = new GraphQlQueryEntityAtRange.EntityAtRangeField[2];
    arrayOfEntityAtRangeField1[0] = GraphQl.EntityAtRange.a;
    arrayOfEntityAtRangeField1[1] = GraphQl.EntityAtRange.b;
    arrayOfTextWithEntitiesField1[1] = GraphQl.TextWithEntities.a(GraphQl.EntityAtRange.a(arrayOfEntityAtRangeField1));
    arrayOfPageField[5] = GraphQl.Page.b(GraphQl.TextWithEntities.a(arrayOfTextWithEntitiesField1));
    GraphQlQueryTimeRange.TimeRangeField[] arrayOfTimeRangeField = new GraphQlQueryTimeRange.TimeRangeField[2];
    arrayOfTimeRangeField[0] = GraphQl.TimeRange.a;
    arrayOfTimeRangeField[1] = GraphQl.TimeRange.b;
    arrayOfPageField[6] = GraphQl.Page.a(GraphQl.TimeRange.a(arrayOfTimeRangeField));
    GraphQlQueryLocation.LocationField[] arrayOfLocationField = new GraphQlQueryLocation.LocationField[3];
    arrayOfLocationField[0] = GraphQl.Location.a;
    arrayOfLocationField[1] = GraphQl.Location.b;
    arrayOfLocationField[2] = GraphQl.Location.c;
    arrayOfPageField[7] = GraphQl.Page.a(GraphQl.Location.a(arrayOfLocationField));
    arrayOfPageField[8] = GraphQl.Page.c;
    arrayOfPageField[9] = GraphQl.Page.n;
    GraphQlQueryPageLikersConnection.PageLikersConnectionField[] arrayOfPageLikersConnectionField = new GraphQlQueryPageLikersConnection.PageLikersConnectionField[1];
    arrayOfPageLikersConnectionField[0] = GraphQl.PageLikersConnection.a;
    arrayOfPageField[10] = GraphQl.Page.a(GraphQl.PageLikersConnection.a(arrayOfPageLikersConnectionField));
    GraphQlQueryPageVisitsConnection.PageVisitsConnectionField[] arrayOfPageVisitsConnectionField = new GraphQlQueryPageVisitsConnection.PageVisitsConnectionField[1];
    arrayOfPageVisitsConnectionField[0] = GraphQl.PageVisitsConnection.a;
    arrayOfPageField[11] = GraphQl.Page.a(GraphQl.PageVisitsConnection.a(arrayOfPageVisitsConnectionField));
    GraphQlQueryPhoneNumber.PhoneNumberField[] arrayOfPhoneNumberField = new GraphQlQueryPhoneNumber.PhoneNumberField[1];
    arrayOfPhoneNumberField[0] = GraphQl.PhoneNumber.a;
    arrayOfPageField[12] = GraphQl.Page.a(GraphQl.PhoneNumber.a(arrayOfPhoneNumberField));
    arrayOfPageField[13] = GraphQl.Page.o;
    arrayOfPageField[14] = GraphQl.Page.a(a(b));
    GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField[] arrayOfPageStarRatersConnectionField = new GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField[1];
    arrayOfPageStarRatersConnectionField[0] = GraphQl.PageStarRatersConnection.a;
    arrayOfPageField[15] = GraphQl.Page.a(GraphQl.PageStarRatersConnection.a(arrayOfPageStarRatersConnectionField));
    GraphQlQueryFriendsWhoLikeConnection.CallOnFriendsWhoLikeConnection[] arrayOfCallOnFriendsWhoLikeConnection = new GraphQlQueryFriendsWhoLikeConnection.CallOnFriendsWhoLikeConnection[1];
    arrayOfCallOnFriendsWhoLikeConnection[0] = GraphQl.FriendsWhoLikeConnection.a(e);
    GraphQlQueryFriendsWhoLikeConnection localGraphQlQueryFriendsWhoLikeConnection = GraphQl.FriendsWhoLikeConnection.a(arrayOfCallOnFriendsWhoLikeConnection);
    GraphQlQueryFriendsWhoLikeConnection.FriendsWhoLikeConnectionField[] arrayOfFriendsWhoLikeConnectionField = new GraphQlQueryFriendsWhoLikeConnection.FriendsWhoLikeConnectionField[2];
    arrayOfFriendsWhoLikeConnectionField[0] = GraphQl.FriendsWhoLikeConnection.a;
    GraphQlQueryUser.UserField[] arrayOfUserField2 = new GraphQlQueryUser.UserField[3];
    arrayOfUserField2[0] = GraphQl.User.a;
    arrayOfUserField2[1] = GraphQl.User.c;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage1 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage1[0] = GraphQl.Image.a(c);
    arrayOfUserField2[2] = GraphQl.User.a(GraphQl.Image.a(arrayOfCallOnImage1).a(GraphQlQueryDefaults.c));
    arrayOfFriendsWhoLikeConnectionField[1] = GraphQl.FriendsWhoLikeConnection.a(GraphQl.User.a(arrayOfUserField2));
    arrayOfPageField[16] = GraphQl.Page.a(localGraphQlQueryFriendsWhoLikeConnection.a(arrayOfFriendsWhoLikeConnectionField));
    GraphQlQueryFriendsWhoVisitedConnection.CallOnFriendsWhoVisitedConnection[] arrayOfCallOnFriendsWhoVisitedConnection = new GraphQlQueryFriendsWhoVisitedConnection.CallOnFriendsWhoVisitedConnection[1];
    arrayOfCallOnFriendsWhoVisitedConnection[0] = GraphQl.FriendsWhoVisitedConnection.a(e);
    GraphQlQueryFriendsWhoVisitedConnection localGraphQlQueryFriendsWhoVisitedConnection = GraphQl.FriendsWhoVisitedConnection.a(arrayOfCallOnFriendsWhoVisitedConnection);
    GraphQlQueryFriendsWhoVisitedConnection.FriendsWhoVisitedConnectionField[] arrayOfFriendsWhoVisitedConnectionField = new GraphQlQueryFriendsWhoVisitedConnection.FriendsWhoVisitedConnectionField[2];
    arrayOfFriendsWhoVisitedConnectionField[0] = GraphQl.FriendsWhoVisitedConnection.a;
    GraphQlQueryUser.UserField[] arrayOfUserField3 = new GraphQlQueryUser.UserField[3];
    arrayOfUserField3[0] = GraphQl.User.a;
    arrayOfUserField3[1] = GraphQl.User.c;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage2 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage2[0] = GraphQl.Image.a(c);
    arrayOfUserField3[2] = GraphQl.User.a(GraphQl.Image.a(arrayOfCallOnImage2).a(GraphQlQueryDefaults.c));
    arrayOfFriendsWhoVisitedConnectionField[1] = GraphQl.FriendsWhoVisitedConnection.a(GraphQl.User.a(arrayOfUserField3));
    arrayOfPageField[17] = GraphQl.Page.a(localGraphQlQueryFriendsWhoVisitedConnection.a(arrayOfFriendsWhoVisitedConnectionField));
    GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection[] arrayOfCallOnPageRecommendationsConnection1 = new GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection[2];
    arrayOfCallOnPageRecommendationsConnection1[0] = GraphQl.PageRecommendationsConnection.a();
    arrayOfCallOnPageRecommendationsConnection1[1] = GraphQl.PageRecommendationsConnection.a(d);
    GraphQlQueryPageRecommendationsConnection localGraphQlQueryPageRecommendationsConnection1 = GraphQl.PageRecommendationsConnection.a(arrayOfCallOnPageRecommendationsConnection1);
    GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField[] arrayOfPageRecommendationsConnectionField1 = new GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField[2];
    arrayOfPageRecommendationsConnectionField1[0] = GraphQl.PageRecommendationsConnection.a;
    arrayOfPageRecommendationsConnectionField1[1] = a();
    arrayOfPageField[18] = GraphQl.Page.a(localGraphQlQueryPageRecommendationsConnection1.a(arrayOfPageRecommendationsConnectionField1).a("friend_recommendations"));
    GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection[] arrayOfCallOnPageRecommendationsConnection2 = new GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection[2];
    arrayOfCallOnPageRecommendationsConnection2[0] = GraphQl.PageRecommendationsConnection.b();
    arrayOfCallOnPageRecommendationsConnection2[1] = GraphQl.PageRecommendationsConnection.a(d);
    GraphQlQueryPageRecommendationsConnection localGraphQlQueryPageRecommendationsConnection2 = GraphQl.PageRecommendationsConnection.a(arrayOfCallOnPageRecommendationsConnection2);
    GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField[] arrayOfPageRecommendationsConnectionField2 = new GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField[1];
    arrayOfPageRecommendationsConnectionField2[0] = a();
    arrayOfPageField[19] = GraphQl.Page.a(localGraphQlQueryPageRecommendationsConnection2.a(arrayOfPageRecommendationsConnectionField2).a("nonfriend_recommendations"));
    GraphQlQueryTextWithEntities.TextWithEntitiesField[] arrayOfTextWithEntitiesField2 = new GraphQlQueryTextWithEntities.TextWithEntitiesField[3];
    arrayOfTextWithEntitiesField2[0] = GraphQl.TextWithEntities.a;
    GraphQlQueryEntityAtRange.EntityAtRangeField[] arrayOfEntityAtRangeField2 = new GraphQlQueryEntityAtRange.EntityAtRangeField[2];
    arrayOfEntityAtRangeField2[0] = GraphQl.EntityAtRange.a;
    arrayOfEntityAtRangeField2[1] = GraphQl.EntityAtRange.b;
    arrayOfTextWithEntitiesField2[1] = GraphQl.TextWithEntities.a(GraphQl.EntityAtRange.a(arrayOfEntityAtRangeField2));
    GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField[] arrayOfAggregatedEntitiesAtRangeField = new GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField[2];
    arrayOfAggregatedEntitiesAtRangeField[0] = GraphQl.AggregatedEntitiesAtRange.a;
    arrayOfAggregatedEntitiesAtRangeField[1] = GraphQl.AggregatedEntitiesAtRange.b;
    arrayOfTextWithEntitiesField2[2] = GraphQl.TextWithEntities.a(GraphQl.AggregatedEntitiesAtRange.a(arrayOfAggregatedEntitiesAtRangeField));
    arrayOfPageField[20] = GraphQl.Page.c(GraphQl.TextWithEntities.a(arrayOfTextWithEntitiesField2));
    GraphQlQueryFocusedPhoto.FocusedPhotoField[] arrayOfFocusedPhotoField = new GraphQlQueryFocusedPhoto.FocusedPhotoField[2];
    GraphQlQueryPhoto.PhotoField[] arrayOfPhotoField = new GraphQlQueryPhoto.PhotoField[1];
    arrayOfPhotoField[0] = GraphQl.Photo.a(a(a));
    arrayOfFocusedPhotoField[0] = GraphQl.FocusedPhoto.a(GraphQl.Photo.a(arrayOfPhotoField));
    GraphQlQueryVect2.Vect2Field[] arrayOfVect2Field = new GraphQlQueryVect2.Vect2Field[2];
    arrayOfVect2Field[0] = GraphQl.Vect2.a;
    arrayOfVect2Field[1] = GraphQl.Vect2.b;
    arrayOfFocusedPhotoField[1] = GraphQl.FocusedPhoto.a(GraphQl.Vect2.a(arrayOfVect2Field));
    arrayOfPageField[21] = GraphQl.Page.a(GraphQl.FocusedPhoto.a(arrayOfFocusedPhotoField));
    arrayOfPageField[22] = GraphQl.Page.u;
    GraphQlQueryViewerVisitsConnection.ViewerVisitsConnectionField[] arrayOfViewerVisitsConnectionField = new GraphQlQueryViewerVisitsConnection.ViewerVisitsConnectionField[1];
    arrayOfViewerVisitsConnectionField[0] = GraphQl.ViewerVisitsConnection.a;
    arrayOfPageField[23] = GraphQl.Page.a(GraphQl.ViewerVisitsConnection.a(arrayOfViewerVisitsConnectionField));
  }

  public FetchPageIdentityDataMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    this.h = paramResources;
    this.i = paramGraphQLHelper;
  }

  private static final GraphQlQueryImage a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage[0] = GraphQl.Image.a(paramGraphQlQueryParam);
    return GraphQl.Image.a(arrayOfCallOnImage).a(GraphQlQueryDefaults.c);
  }

  private static final GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField a()
  {
    GraphQlQueryContactRecommendationField.ContactRecommendationFieldField[] arrayOfContactRecommendationFieldField = new GraphQlQueryContactRecommendationField.ContactRecommendationFieldField[4];
    arrayOfContactRecommendationFieldField[0] = GraphQl.ContactRecommendationField.c;
    GraphQlQueryFieldActor[] arrayOfGraphQlQueryFieldActor = new GraphQlQueryFieldActor[3];
    arrayOfGraphQlQueryFieldActor[0] = GraphQl.Actor.a;
    arrayOfGraphQlQueryFieldActor[1] = GraphQl.User.j;
    arrayOfGraphQlQueryFieldActor[2] = GraphQl.Actor.a(a(c));
    arrayOfContactRecommendationFieldField[1] = GraphQl.ContactRecommendationField.a(GraphQl.Actor.a(arrayOfGraphQlQueryFieldActor));
    arrayOfContactRecommendationFieldField[2] = GraphQl.ContactRecommendationField.e;
    GraphQlQueryTextWithEntities.TextWithEntitiesField[] arrayOfTextWithEntitiesField = new GraphQlQueryTextWithEntities.TextWithEntitiesField[1];
    arrayOfTextWithEntitiesField[0] = GraphQl.TextWithEntities.a;
    arrayOfContactRecommendationFieldField[3] = GraphQl.ContactRecommendationField.a(GraphQl.TextWithEntities.a(arrayOfTextWithEntitiesField));
    return GraphQl.PageRecommendationsConnection.a(GraphQl.ContactRecommendationField.a(arrayOfContactRecommendationFieldField));
  }

  private String b(FetchPageIdentityDataMethod.Params paramParams)
  {
    long l = paramParams.a;
    if (l > 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Invalid profile id!");
      int j = GraphQLImage.a(paramParams.b);
      int k = this.h.getDimensionPixelSize(2131230733);
      int m = this.h.getDimensionPixelSize(2131230735);
      int n = this.h.getInteger(2131558401);
      int i1 = this.h.getInteger(2131558402);
      int i2 = this.h.getDimensionPixelSize(2131230737);
      return GraphQl.a(String.valueOf(l)).a(GraphQl.Node.a(g)).a(new ImmutableMap.Builder().b(a, String.valueOf(j)).b(b, String.valueOf(k)).b(c, String.valueOf(m)).b(d, String.valueOf(n)).b(e, String.valueOf(i1)).b(f, String.valueOf(i2)).b());
    }
  }

  public GraphQueryResultEntry a(FetchPageIdentityDataMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    GraphQueryResultEntry localGraphQueryResultEntry = (GraphQueryResultEntry)this.i.a("fetch_ragtime_page", 1, paramApiResponse.d()).readValueAs(GraphQueryResultEntry.class);
    if (localGraphQueryResultEntry == null)
      throw new Exception("Invalid JSON result");
    return localGraphQueryResultEntry;
  }

  public ApiRequest a(FetchPageIdentityDataMethod.Params paramParams)
  {
    return this.i.a("fetch_ragtime_page", b(paramParams));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.protocol.FetchPageIdentityDataMethod
 * JD-Core Version:    0.6.2
 */