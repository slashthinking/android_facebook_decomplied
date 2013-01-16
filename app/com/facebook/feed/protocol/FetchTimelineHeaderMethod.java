package com.facebook.feed.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.BylineFragment;
import com.facebook.graphql.GraphQl.Entity;
import com.facebook.graphql.GraphQl.EntityAtRange;
import com.facebook.graphql.GraphQl.FeaturedFriendsConnection;
import com.facebook.graphql.GraphQl.FocusedPhoto;
import com.facebook.graphql.GraphQl.Image;
import com.facebook.graphql.GraphQl.LikedProfilesConnection;
import com.facebook.graphql.GraphQl.Location;
import com.facebook.graphql.GraphQl.Node;
import com.facebook.graphql.GraphQl.Page;
import com.facebook.graphql.GraphQl.PageLikersConnection;
import com.facebook.graphql.GraphQl.PageVisitsConnection;
import com.facebook.graphql.GraphQl.PeopleTalkingAboutConnection;
import com.facebook.graphql.GraphQl.PhoneNumber;
import com.facebook.graphql.GraphQl.Photo;
import com.facebook.graphql.GraphQl.Profile;
import com.facebook.graphql.GraphQl.StreetAddress;
import com.facebook.graphql.GraphQl.SubscribersConnection;
import com.facebook.graphql.GraphQl.SubscriptionsConnection;
import com.facebook.graphql.GraphQl.TextWithEntities;
import com.facebook.graphql.GraphQl.TimeRange;
import com.facebook.graphql.GraphQl.TimelineAppSection;
import com.facebook.graphql.GraphQl.TimelineNavAppSectionsConnection;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryBylineFragment.BylineFragmentField;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryEntityAtRange.EntityAtRangeField;
import com.facebook.graphql.GraphQlQueryFeaturedFriendsConnection;
import com.facebook.graphql.GraphQlQueryFeaturedFriendsConnection.CallOnFeaturedFriendsConnection;
import com.facebook.graphql.GraphQlQueryFeaturedFriendsConnection.FeaturedFriendsConnectionField;
import com.facebook.graphql.GraphQlQueryFieldEntity;
import com.facebook.graphql.GraphQlQueryFocusedPhoto;
import com.facebook.graphql.GraphQlQueryFocusedPhoto.FocusedPhotoField;
import com.facebook.graphql.GraphQlQueryImage;
import com.facebook.graphql.GraphQlQueryImage.CallOnImage;
import com.facebook.graphql.GraphQlQueryImage.ImageField;
import com.facebook.graphql.GraphQlQueryLikedProfilesConnection;
import com.facebook.graphql.GraphQlQueryLikedProfilesConnection.CallOnLikedProfilesConnection;
import com.facebook.graphql.GraphQlQueryLikedProfilesConnection.LikedProfilesConnectionField;
import com.facebook.graphql.GraphQlQueryLocation.LocationField;
import com.facebook.graphql.GraphQlQueryPage.PageField;
import com.facebook.graphql.GraphQlQueryPageLikersConnection.PageLikersConnectionField;
import com.facebook.graphql.GraphQlQueryPageVisitsConnection.PageVisitsConnectionField;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryPeopleTalkingAboutConnection.PeopleTalkingAboutConnectionField;
import com.facebook.graphql.GraphQlQueryPhoneNumber.PhoneNumberField;
import com.facebook.graphql.GraphQlQueryPhoto;
import com.facebook.graphql.GraphQlQueryPhoto.PhotoField;
import com.facebook.graphql.GraphQlQueryRootCallActor;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.GraphQlQueryStreetAddress.StreetAddressField;
import com.facebook.graphql.GraphQlQuerySubscribersConnection.SubscribersConnectionField;
import com.facebook.graphql.GraphQlQuerySubscriptionsConnection;
import com.facebook.graphql.GraphQlQuerySubscriptionsConnection.CallOnSubscriptionsConnection;
import com.facebook.graphql.GraphQlQuerySubscriptionsConnection.SubscriptionsConnectionField;
import com.facebook.graphql.GraphQlQueryTextWithEntities;
import com.facebook.graphql.GraphQlQueryTextWithEntities.TextWithEntitiesField;
import com.facebook.graphql.GraphQlQueryTimeRange.TimeRangeField;
import com.facebook.graphql.GraphQlQueryTimelineAppSection.TimelineAppSectionField;
import com.facebook.graphql.GraphQlQueryTimelineNavAppSectionsConnection.TimelineNavAppSectionsConnectionField;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Arrays;
import java.util.List;

public class FetchTimelineHeaderMethod
  implements ApiMethod<FetchTimelineHeaderParams, GraphQueryResultEntry>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("profile_image_size");
  private static final GraphQlQueryParam b = GraphQlQueryParam.a("profile_photo_size");
  private static final GraphQlQueryParam c = GraphQlQueryParam.a("cover_image_portrait_size");
  private static final GraphQlQueryParam d = GraphQlQueryParam.a("cover_image_landscape_size");
  private static final GraphQlQueryParam e = GraphQlQueryParam.a("nav_facepile_large");
  private static final GraphQlQueryParam f = GraphQlQueryParam.a("nav_facepile_small");
  private static final GraphQlQueryParam g = GraphQlQueryParam.a("nav_facepile_single");
  private static final GraphQlQueryParam h = GraphQlQueryParam.a("nav_photo_size");
  private static final GraphQlQueryParam i = GraphQlQueryParam.a("nav_logo_width");
  private static final GraphQlQueryParam j = GraphQlQueryParam.a("nav_logo_height");
  private static final GraphQlQueryTextWithEntities k;
  private static final List<GraphQlQueryUser.UserField> l;
  private static final List<GraphQlQueryUser.UserField> m;
  private static final List<GraphQlQueryPage.PageField> n;
  private Resources o;
  private GraphQLHelper p;

  static
  {
    GraphQlQueryTextWithEntities.TextWithEntitiesField[] arrayOfTextWithEntitiesField = new GraphQlQueryTextWithEntities.TextWithEntitiesField[2];
    GraphQlQueryEntityAtRange.EntityAtRangeField[] arrayOfEntityAtRangeField = new GraphQlQueryEntityAtRange.EntityAtRangeField[3];
    GraphQlQueryFieldEntity[] arrayOfGraphQlQueryFieldEntity = new GraphQlQueryFieldEntity[1];
    arrayOfGraphQlQueryFieldEntity[0] = GraphQl.Page.a;
    arrayOfEntityAtRangeField[0] = GraphQl.EntityAtRange.a(GraphQl.Entity.a(arrayOfGraphQlQueryFieldEntity));
    arrayOfEntityAtRangeField[1] = GraphQl.EntityAtRange.b;
    arrayOfEntityAtRangeField[2] = GraphQl.EntityAtRange.a;
    arrayOfTextWithEntitiesField[0] = GraphQl.TextWithEntities.a(GraphQl.EntityAtRange.a(arrayOfEntityAtRangeField));
    arrayOfTextWithEntitiesField[1] = GraphQl.TextWithEntities.a;
    k = GraphQl.TextWithEntities.a(arrayOfTextWithEntitiesField);
    GraphQlQueryUser.UserField[] arrayOfUserField1 = new GraphQlQueryUser.UserField[3];
    arrayOfUserField1[0] = GraphQl.User.a(a(e, "facepile_large"));
    arrayOfUserField1[1] = GraphQl.User.a(a(f, "facepile_small"));
    arrayOfUserField1[2] = GraphQl.User.a(a(g, "facepile_single"));
    l = Arrays.asList(arrayOfUserField1);
    GraphQlQueryUser.UserField[] arrayOfUserField2 = new GraphQlQueryUser.UserField[18];
    arrayOfUserField2[0] = GraphQl.User.c;
    arrayOfUserField2[1] = GraphQl.User.f;
    arrayOfUserField2[2] = GraphQl.User.g;
    arrayOfUserField2[3] = GraphQl.User.j;
    arrayOfUserField2[4] = GraphQl.User.k;
    arrayOfUserField2[5] = GraphQl.User.r;
    arrayOfUserField2[6] = GraphQl.User.e;
    arrayOfUserField2[7] = GraphQl.User.p;
    arrayOfUserField2[8] = GraphQl.User.a(a(a));
    arrayOfUserField2[9] = GraphQl.User.a(b(b));
    GraphQlQueryFocusedPhoto.FocusedPhotoField[] arrayOfFocusedPhotoField = new GraphQlQueryFocusedPhoto.FocusedPhotoField[2];
    GraphQlQueryPhoto.PhotoField[] arrayOfPhotoField = new GraphQlQueryPhoto.PhotoField[4];
    arrayOfPhotoField[0] = GraphQl.Photo.a(GraphQlNewsFeedDefaults.k);
    arrayOfPhotoField[1] = GraphQl.Photo.a;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage1 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage1[0] = GraphQl.Image.a(c);
    arrayOfPhotoField[2] = GraphQl.Photo.a(GraphQl.Image.a(arrayOfCallOnImage1).a(GraphQlQueryDefaults.c).a("image_portrait"));
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage2 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage2[0] = GraphQl.Image.a(d);
    arrayOfPhotoField[3] = GraphQl.Photo.a(GraphQl.Image.a(arrayOfCallOnImage2).a(GraphQlQueryDefaults.c).a("image_landscape"));
    arrayOfFocusedPhotoField[0] = GraphQl.FocusedPhoto.a(GraphQl.Photo.a(arrayOfPhotoField));
    arrayOfFocusedPhotoField[1] = GraphQl.FocusedPhoto.a(GraphQlQueryDefaults.n);
    arrayOfUserField2[10] = GraphQl.User.a(GraphQl.FocusedPhoto.a(arrayOfFocusedPhotoField));
    GraphQlQueryTimelineNavAppSectionsConnection.TimelineNavAppSectionsConnectionField[] arrayOfTimelineNavAppSectionsConnectionField = new GraphQlQueryTimelineNavAppSectionsConnection.TimelineNavAppSectionsConnectionField[1];
    GraphQlQueryTimelineAppSection.TimelineAppSectionField[] arrayOfTimelineAppSectionField = new GraphQlQueryTimelineAppSection.TimelineAppSectionField[5];
    arrayOfTimelineAppSectionField[0] = GraphQl.TimelineAppSection.c;
    arrayOfTimelineAppSectionField[1] = GraphQl.TimelineAppSection.b;
    arrayOfTimelineAppSectionField[2] = GraphQl.TimelineAppSection.a;
    arrayOfTimelineAppSectionField[3] = GraphQl.TimelineAppSection.d;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage3 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage3[0] = GraphQl.Image.a(i, j);
    GraphQlQueryImage localGraphQlQueryImage = GraphQl.Image.a(arrayOfCallOnImage3);
    GraphQlQueryImage.ImageField[] arrayOfImageField = new GraphQlQueryImage.ImageField[1];
    arrayOfImageField[0] = GraphQl.Image.a;
    arrayOfTimelineAppSectionField[4] = GraphQl.TimelineAppSection.a(localGraphQlQueryImage.a(arrayOfImageField));
    arrayOfTimelineNavAppSectionsConnectionField[0] = GraphQl.TimelineNavAppSectionsConnection.a(GraphQl.TimelineAppSection.a(arrayOfTimelineAppSectionField));
    arrayOfUserField2[11] = GraphQl.User.a(GraphQl.TimelineNavAppSectionsConnection.a(arrayOfTimelineNavAppSectionsConnectionField));
    GraphQlQueryFeaturedFriendsConnection.CallOnFeaturedFriendsConnection[] arrayOfCallOnFeaturedFriendsConnection = new GraphQlQueryFeaturedFriendsConnection.CallOnFeaturedFriendsConnection[1];
    arrayOfCallOnFeaturedFriendsConnection[0] = GraphQl.FeaturedFriendsConnection.a(6L);
    GraphQlQueryFeaturedFriendsConnection localGraphQlQueryFeaturedFriendsConnection = GraphQl.FeaturedFriendsConnection.a(arrayOfCallOnFeaturedFriendsConnection);
    GraphQlQueryFeaturedFriendsConnection.FeaturedFriendsConnectionField[] arrayOfFeaturedFriendsConnectionField = new GraphQlQueryFeaturedFriendsConnection.FeaturedFriendsConnectionField[1];
    arrayOfFeaturedFriendsConnectionField[0] = GraphQl.FeaturedFriendsConnection.a(GraphQl.User.a(l));
    arrayOfUserField2[12] = GraphQl.User.a(localGraphQlQueryFeaturedFriendsConnection.a(arrayOfFeaturedFriendsConnectionField));
    GraphQlQueryLikedProfilesConnection.CallOnLikedProfilesConnection[] arrayOfCallOnLikedProfilesConnection = new GraphQlQueryLikedProfilesConnection.CallOnLikedProfilesConnection[1];
    arrayOfCallOnLikedProfilesConnection[0] = GraphQl.LikedProfilesConnection.a(3L);
    GraphQlQueryLikedProfilesConnection localGraphQlQueryLikedProfilesConnection = GraphQl.LikedProfilesConnection.a(arrayOfCallOnLikedProfilesConnection);
    GraphQlQueryLikedProfilesConnection.LikedProfilesConnectionField[] arrayOfLikedProfilesConnectionField = new GraphQlQueryLikedProfilesConnection.LikedProfilesConnectionField[1];
    arrayOfLikedProfilesConnectionField[0] = GraphQl.LikedProfilesConnection.a(GraphQl.Profile.a(l));
    arrayOfUserField2[13] = GraphQl.User.a(localGraphQlQueryLikedProfilesConnection.a(arrayOfLikedProfilesConnectionField));
    GraphQlQuerySubscriptionsConnection.CallOnSubscriptionsConnection[] arrayOfCallOnSubscriptionsConnection = new GraphQlQuerySubscriptionsConnection.CallOnSubscriptionsConnection[1];
    arrayOfCallOnSubscriptionsConnection[0] = GraphQl.SubscriptionsConnection.a(6L);
    GraphQlQuerySubscriptionsConnection localGraphQlQuerySubscriptionsConnection = GraphQl.SubscriptionsConnection.a(arrayOfCallOnSubscriptionsConnection);
    GraphQlQuerySubscriptionsConnection.SubscriptionsConnectionField[] arrayOfSubscriptionsConnectionField = new GraphQlQuerySubscriptionsConnection.SubscriptionsConnectionField[1];
    arrayOfSubscriptionsConnectionField[0] = GraphQl.SubscriptionsConnection.a(GraphQl.Profile.a(l));
    arrayOfUserField2[14] = GraphQl.User.a(localGraphQlQuerySubscriptionsConnection.a(arrayOfSubscriptionsConnectionField));
    arrayOfUserField2[15] = GraphQl.User.b(c(h));
    GraphQlQuerySubscribersConnection.SubscribersConnectionField[] arrayOfSubscribersConnectionField = new GraphQlQuerySubscribersConnection.SubscribersConnectionField[1];
    arrayOfSubscribersConnectionField[0] = GraphQl.SubscribersConnection.a;
    arrayOfUserField2[16] = GraphQl.User.a(GraphQl.SubscribersConnection.a(arrayOfSubscribersConnectionField));
    GraphQlQueryBylineFragment.BylineFragmentField[] arrayOfBylineFragmentField = new GraphQlQueryBylineFragment.BylineFragmentField[2];
    arrayOfBylineFragmentField[0] = GraphQl.BylineFragment.a(GraphQlQueryDefaults.h);
    arrayOfBylineFragmentField[1] = GraphQl.BylineFragment.a(k);
    arrayOfUserField2[17] = GraphQl.User.a(GraphQl.BylineFragment.a(arrayOfBylineFragmentField));
    m = Arrays.asList(arrayOfUserField2);
    GraphQlQueryPage.PageField[] arrayOfPageField = new GraphQlQueryPage.PageField[14];
    arrayOfPageField[0] = GraphQl.Page.a(k);
    arrayOfPageField[1] = GraphQl.Page.g;
    arrayOfPageField[2] = GraphQl.Page.h;
    GraphQlQueryTimeRange.TimeRangeField[] arrayOfTimeRangeField = new GraphQlQueryTimeRange.TimeRangeField[2];
    arrayOfTimeRangeField[0] = GraphQl.TimeRange.a;
    arrayOfTimeRangeField[1] = GraphQl.TimeRange.b;
    arrayOfPageField[3] = GraphQl.Page.a(GraphQl.TimeRange.a(arrayOfTimeRangeField));
    GraphQlQueryLocation.LocationField[] arrayOfLocationField = new GraphQlQueryLocation.LocationField[1];
    arrayOfLocationField[0] = GraphQl.Location.c;
    arrayOfPageField[4] = GraphQl.Page.a(GraphQl.Location.a(arrayOfLocationField));
    GraphQlQueryStreetAddress.StreetAddressField[] arrayOfStreetAddressField = new GraphQlQueryStreetAddress.StreetAddressField[1];
    arrayOfStreetAddressField[0] = GraphQl.StreetAddress.e;
    arrayOfPageField[5] = GraphQl.Page.a(GraphQl.StreetAddress.a(arrayOfStreetAddressField));
    GraphQlQueryPageLikersConnection.PageLikersConnectionField[] arrayOfPageLikersConnectionField = new GraphQlQueryPageLikersConnection.PageLikersConnectionField[1];
    arrayOfPageLikersConnectionField[0] = GraphQl.PageLikersConnection.a;
    arrayOfPageField[6] = GraphQl.Page.a(GraphQl.PageLikersConnection.a(arrayOfPageLikersConnectionField));
    GraphQlQueryPageVisitsConnection.PageVisitsConnectionField[] arrayOfPageVisitsConnectionField = new GraphQlQueryPageVisitsConnection.PageVisitsConnectionField[1];
    arrayOfPageVisitsConnectionField[0] = GraphQl.PageVisitsConnection.a;
    arrayOfPageField[7] = GraphQl.Page.a(GraphQl.PageVisitsConnection.a(arrayOfPageVisitsConnectionField));
    GraphQlQueryPeopleTalkingAboutConnection.PeopleTalkingAboutConnectionField[] arrayOfPeopleTalkingAboutConnectionField = new GraphQlQueryPeopleTalkingAboutConnection.PeopleTalkingAboutConnectionField[1];
    arrayOfPeopleTalkingAboutConnectionField[0] = GraphQl.PeopleTalkingAboutConnection.a;
    arrayOfPageField[8] = GraphQl.Page.a(GraphQl.PeopleTalkingAboutConnection.a(arrayOfPeopleTalkingAboutConnectionField));
    GraphQlQueryPhoneNumber.PhoneNumberField[] arrayOfPhoneNumberField = new GraphQlQueryPhoneNumber.PhoneNumberField[1];
    arrayOfPhoneNumberField[0] = GraphQl.PhoneNumber.b;
    arrayOfPageField[9] = GraphQl.Page.a(GraphQl.PhoneNumber.a(arrayOfPhoneNumberField));
    arrayOfPageField[10] = GraphQl.Page.o;
    arrayOfPageField[11] = GraphQl.Page.q;
    arrayOfPageField[12] = GraphQl.Page.s;
    arrayOfPageField[13] = GraphQl.Page.t;
    n = Arrays.asList(arrayOfPageField);
  }

  public FetchTimelineHeaderMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    this.o = paramResources;
    this.p = paramGraphQLHelper;
  }

  private static int a(int paramInt)
  {
    return GraphQLImage.a(new int[] { 84, 126, 168 }, paramInt);
  }

  private static final GraphQlQueryImage a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage[0] = GraphQl.Image.a(paramGraphQlQueryParam, paramGraphQlQueryParam);
    return GraphQl.Image.a(arrayOfCallOnImage).a(GraphQlQueryDefaults.c);
  }

  private static final GraphQlQueryImage a(GraphQlQueryParam paramGraphQlQueryParam, String paramString)
  {
    return a(paramGraphQlQueryParam).a(paramString);
  }

  private static int b(int paramInt)
  {
    return GraphQLImage.a(new int[] { 56, 84, 112 }, paramInt);
  }

  private static final GraphQlQueryPhoto b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    GraphQlQueryPhoto.PhotoField[] arrayOfPhotoField = new GraphQlQueryPhoto.PhotoField[3];
    arrayOfPhotoField[0] = GraphQl.Photo.a(GraphQlNewsFeedDefaults.k);
    arrayOfPhotoField[1] = GraphQl.Photo.a;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage[0] = GraphQl.Image.a(paramGraphQlQueryParam);
    arrayOfPhotoField[2] = GraphQl.Photo.a(GraphQl.Image.a(arrayOfCallOnImage).a(GraphQlQueryDefaults.c));
    return GraphQl.Photo.a(arrayOfPhotoField);
  }

  private String b(FetchTimelineHeaderParams paramFetchTimelineHeaderParams)
  {
    String[] arrayOfString;
    if (paramFetchTimelineHeaderParams.a() >= 0L)
    {
      arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramFetchTimelineHeaderParams.a());
    }
    for (GraphQlQuery localGraphQlQuery = GraphQl.a(arrayOfString).a(GraphQl.Node.a(new FetchTimelineHeaderMethod.1(this))); ; localGraphQlQuery = GraphQl.a().a(GraphQl.User.a(m)))
    {
      int i1 = this.o.getDimensionPixelSize(2131230765);
      int i2 = GraphQLImage.a(this.o.getDimensionPixelSize(2131230765));
      int i3 = this.o.getDimensionPixelSize(2131230767);
      int i4 = this.o.getDimensionPixelSize(2131230768);
      int i5 = this.o.getDimensionPixelSize(2131230766);
      int i6 = GraphQLImage.a(i5);
      int i7 = a(i5);
      int i8 = b(this.o.getDimensionPixelSize(2131230767));
      int i9 = GraphQLImage.a(paramFetchTimelineHeaderParams.b());
      int i10 = GraphQLImage.a(paramFetchTimelineHeaderParams.c());
      return localGraphQlQuery.a(new ImmutableMap.Builder().b(a, String.valueOf(i1)).b(b, String.valueOf(i2)).b(c, String.valueOf(i9)).b(d, String.valueOf(i10)).b(e, String.valueOf(i3)).b(f, String.valueOf(i4)).b(g, String.valueOf(i5)).b(h, String.valueOf(i6)).b(i, String.valueOf(i7)).b(j, String.valueOf(i8)).b());
    }
  }

  private static final GraphQlQueryFocusedPhoto c(GraphQlQueryParam paramGraphQlQueryParam)
  {
    GraphQlQueryFocusedPhoto.FocusedPhotoField[] arrayOfFocusedPhotoField = new GraphQlQueryFocusedPhoto.FocusedPhotoField[2];
    GraphQlQueryPhoto.PhotoField[] arrayOfPhotoField = new GraphQlQueryPhoto.PhotoField[1];
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage[0] = GraphQl.Image.a(paramGraphQlQueryParam);
    arrayOfPhotoField[0] = GraphQl.Photo.a(GraphQl.Image.a(arrayOfCallOnImage).a(GraphQlQueryDefaults.c));
    arrayOfFocusedPhotoField[0] = GraphQl.FocusedPhoto.a(GraphQl.Photo.a(arrayOfPhotoField));
    arrayOfFocusedPhotoField[1] = GraphQl.FocusedPhoto.a(GraphQlQueryDefaults.n);
    return GraphQl.FocusedPhoto.a(arrayOfFocusedPhotoField);
  }

  public GraphQueryResultEntry a(FetchTimelineHeaderParams paramFetchTimelineHeaderParams, ApiResponse paramApiResponse)
  {
    GraphQueryResultEntry localGraphQueryResultEntry = (GraphQueryResultEntry)this.p.a("fetch_timeline_header", 1, paramApiResponse.d()).readValueAs(GraphQueryResultEntry.class);
    if (localGraphQueryResultEntry == null)
      throw new Exception("Invalid JSON result");
    return localGraphQueryResultEntry;
  }

  public ApiRequest a(FetchTimelineHeaderParams paramFetchTimelineHeaderParams)
  {
    return this.p.a("fetch_timeline_header", b(paramFetchTimelineHeaderParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchTimelineHeaderMethod
 * JD-Core Version:    0.6.0
 */