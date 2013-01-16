package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Page
{

  @Deprecated
  public static final GraphQlQueryPage.PageField A = new GraphQlQueryPage.PageField("short_categories");
  public static final GraphQlQueryPage.PageField a = new GraphQlQueryPage.PageField("id");
  public static final GraphQlQueryPage.PageField b = new GraphQlQueryPage.PageField("url.site(mobile)");
  public static final GraphQlQueryPage.PageField c = new GraphQlQueryPage.PageField("name");
  public static final GraphQlQueryPage.PageField d = new GraphQlQueryPage.PageField("place_type");
  public static final GraphQlQueryPage.PageField e = new GraphQlQueryPage.PageField("can_viewer_message");
  public static final GraphQlQueryPage.PageField f = new GraphQlQueryPage.PageField("can_viewer_post");
  public static final GraphQlQueryPage.PageField g = new GraphQlQueryPage.PageField("can_viewer_post_photo_to_timeline");
  public static final GraphQlQueryPage.PageField h = new GraphQlQueryPage.PageField("category_names");
  public static final GraphQlQueryPage.PageField i = new GraphQlQueryPage.PageField("does_viewer_like");
  public static final GraphQlQueryPage.PageField j = new GraphQlQueryPage.PageField("does_viewer_recommend");
  public static final GraphQlQueryPage.PageField k = new GraphQlQueryPage.PageField("subscribe_status");
  public static final GraphQlQueryPage.PageField l = new GraphQlQueryPage.PageField("expressed_as_place");
  public static final GraphQlQueryPage.PageField m = new GraphQlQueryPage.PageField("is_owned");
  public static final GraphQlQueryPage.PageField n = new GraphQlQueryPage.PageField("overall_rating");
  public static final GraphQlQueryPage.PageField o = new GraphQlQueryPage.PageField("price_range_description");
  public static final GraphQlQueryPage.PageField p = new GraphQlQueryPage.PageField("short_category_names");
  public static final GraphQlQueryPage.PageField q = new GraphQlQueryPage.PageField("super_category_type");
  public static final GraphQlQueryPage.PageField r = new GraphQlQueryPage.PageField("username");
  public static final GraphQlQueryPage.PageField s = new GraphQlQueryPage.PageField("viewer_acts_as_profile");
  public static final GraphQlQueryPage.PageField t = new GraphQlQueryPage.PageField("viewer_profile_permissions");
  public static final GraphQlQueryPage.PageField u = new GraphQlQueryPage.PageField("viewer_rating");

  @Deprecated
  public static final GraphQlQueryPage.PageField v = new GraphQlQueryPage.PageField("pic_square");

  @Deprecated
  public static final GraphQlQueryPage.PageField w = new GraphQlQueryPage.PageField("can_message");

  @Deprecated
  public static final GraphQlQueryPage.PageField x = new GraphQlQueryPage.PageField("average_rating");

  @Deprecated
  public static final GraphQlQueryPage.PageField y = new GraphQlQueryPage.PageField("categories");

  @Deprecated
  public static final GraphQlQueryPage.PageField z = new GraphQlQueryPage.PageField("follow_status");

  public static GraphQlQueryPage.PageField a(GraphQlQueryFocusedPhoto paramGraphQlQueryFocusedPhoto)
  {
    return new GraphQlQueryPage.PageField("timeline_cover_photo", paramGraphQlQueryFocusedPhoto);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryFriendsHereNowConnection paramGraphQlQueryFriendsHereNowConnection)
  {
    return new GraphQlQueryPage.PageField("friends_here_now", paramGraphQlQueryFriendsHereNowConnection);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryFriendsWhoLikeConnection paramGraphQlQueryFriendsWhoLikeConnection)
  {
    return new GraphQlQueryPage.PageField("friends_who_like", paramGraphQlQueryFriendsWhoLikeConnection);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryFriendsWhoVisitedConnection paramGraphQlQueryFriendsWhoVisitedConnection)
  {
    return new GraphQlQueryPage.PageField("friends_who_visited", paramGraphQlQueryFriendsWhoVisitedConnection);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryPage.PageField("profile_picture", paramGraphQlQueryImage);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryLocation paramGraphQlQueryLocation)
  {
    return new GraphQlQueryPage.PageField("location", paramGraphQlQueryLocation);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryPageLikersConnection paramGraphQlQueryPageLikersConnection)
  {
    return new GraphQlQueryPage.PageField("page_likers", paramGraphQlQueryPageLikersConnection);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryPageRecommendationsConnection paramGraphQlQueryPageRecommendationsConnection)
  {
    return new GraphQlQueryPage.PageField("recommendations", paramGraphQlQueryPageRecommendationsConnection);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryPageStarRatersConnection paramGraphQlQueryPageStarRatersConnection)
  {
    return new GraphQlQueryPage.PageField("raters", paramGraphQlQueryPageStarRatersConnection);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryPageVisitsConnection paramGraphQlQueryPageVisitsConnection)
  {
    return new GraphQlQueryPage.PageField("page_visits", paramGraphQlQueryPageVisitsConnection);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryPeopleTalkingAboutConnection paramGraphQlQueryPeopleTalkingAboutConnection)
  {
    return new GraphQlQueryPage.PageField("people_talking_about", paramGraphQlQueryPeopleTalkingAboutConnection);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryPhoneNumber paramGraphQlQueryPhoneNumber)
  {
    return new GraphQlQueryPage.PageField("phone_number", paramGraphQlQueryPhoneNumber);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryStreetAddress paramGraphQlQueryStreetAddress)
  {
    return new GraphQlQueryPage.PageField("address", paramGraphQlQueryStreetAddress);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryPage.PageField("about", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryTimeRange paramGraphQlQueryTimeRange)
  {
    return new GraphQlQueryPage.PageField("hours", paramGraphQlQueryTimeRange);
  }

  public static GraphQlQueryPage.PageField a(GraphQlQueryViewerVisitsConnection paramGraphQlQueryViewerVisitsConnection)
  {
    return new GraphQlQueryPage.PageField("viewer_visits", paramGraphQlQueryViewerVisitsConnection);
  }

  public static GraphQlQueryPage a(GraphQlQueryPage.PageField[] paramArrayOfPageField)
  {
    return new GraphQlQueryPage(ImmutableList.a(paramArrayOfPageField), null);
  }

  public static GraphQlQueryPage.PageField b(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryPage.PageField("friends_here_now_social_context", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryPage.PageField c(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryPage.PageField("social_context_for_non_liking_viewer", paramGraphQlQueryTextWithEntities);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Page
 * JD-Core Version:    0.6.2
 */