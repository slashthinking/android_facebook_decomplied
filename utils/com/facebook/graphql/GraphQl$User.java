package com.facebook.graphql;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class GraphQl$User
{
  public static final GraphQlQueryUser.UserField a = new GraphQlQueryUser.UserField("id");
  public static final GraphQlQueryUser.UserField b = new GraphQlQueryUser.UserField("url.site(mobile)");
  public static final GraphQlQueryUser.UserField c = new GraphQlQueryUser.UserField("name");
  public static final GraphQlQueryUser.UserField d = new GraphQlQueryUser.UserField("can_viewer_message");
  public static final GraphQlQueryUser.UserField e = new GraphQlQueryUser.UserField("can_viewer_post");
  public static final GraphQlQueryUser.UserField f = new GraphQlQueryUser.UserField("alternate_name");
  public static final GraphQlQueryUser.UserField g = new GraphQlQueryUser.UserField("gender");
  public static final GraphQlQueryUser.UserField h = new GraphQlQueryUser.UserField("is_viewer_friend");
  public static final GraphQlQueryUser.UserField i = new GraphQlQueryUser.UserField("viewer_affinity");
  public static final GraphQlQueryUser.UserField j = new GraphQlQueryUser.UserField("friendship_status");
  public static final GraphQlQueryUser.UserField k = new GraphQlQueryUser.UserField("subscribe_status");
  public static final GraphQlQueryUser.UserField l = new GraphQlQueryUser.UserField("is_mobile_pushable");
  public static final GraphQlQueryUser.UserField m = new GraphQlQueryUser.UserField("can_viewer_poke");
  public static final GraphQlQueryUser.UserField n = new GraphQlQueryUser.UserField("is_memorialized");
  public static final GraphQlQueryUser.UserField o = new GraphQlQueryUser.UserField("username");
  public static final GraphQlQueryUser.UserField p = new GraphQlQueryUser.UserField("can_viewer_send_gift");

  @Deprecated
  public static final GraphQlQueryUser.UserField q = new GraphQlQueryUser.UserField("pic_square");

  @Deprecated
  public static final GraphQlQueryUser.UserField r = new GraphQlQueryUser.UserField("can_message");

  @Deprecated
  public static final GraphQlQueryUser.UserField s = new GraphQlQueryUser.UserField("birthday");

  @Deprecated
  public static final GraphQlQueryUser.UserField t = new GraphQlQueryUser.UserField("follow_status");

  @Deprecated
  public static final GraphQlQueryUser.UserField u = new GraphQlQueryUser.UserField("first_name");

  @Deprecated
  public static final GraphQlQueryUser.UserField v = new GraphQlQueryUser.UserField("last_name");

  @Deprecated
  public static final GraphQlQueryUser.UserField w = new GraphQlQueryUser.UserField("middle_name");

  @Deprecated
  public static final GraphQlQueryUser.UserField x = new GraphQlQueryUser.UserField("rank");

  @Deprecated
  public static GraphQlQueryUser.UserField a(GraphQlQueryAllPendingPostsConnection paramGraphQlQueryAllPendingPostsConnection)
  {
    return new GraphQlQueryUser.UserField("all_pending_posts", paramGraphQlQueryAllPendingPostsConnection);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryBylineFragment paramGraphQlQueryBylineFragment)
  {
    return new GraphQlQueryUser.UserField("bylines", paramGraphQlQueryBylineFragment);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryFeaturedFriendsConnection paramGraphQlQueryFeaturedFriendsConnection)
  {
    return new GraphQlQueryUser.UserField("featured_friends", paramGraphQlQueryFeaturedFriendsConnection);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryFocusedPhoto paramGraphQlQueryFocusedPhoto)
  {
    return new GraphQlQueryUser.UserField("timeline_cover_photo", paramGraphQlQueryFocusedPhoto);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryFriendListsConnection paramGraphQlQueryFriendListsConnection)
  {
    return new GraphQlQueryUser.UserField("friend_lists", paramGraphQlQueryFriendListsConnection);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryUser.UserField("profile_picture", paramGraphQlQueryImage);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryLikedProfilesConnection paramGraphQlQueryLikedProfilesConnection)
  {
    return new GraphQlQueryUser.UserField("liked_profiles", paramGraphQlQueryLikedProfilesConnection);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryMutualFriendsConnection paramGraphQlQueryMutualFriendsConnection)
  {
    return new GraphQlQueryUser.UserField("mutual_friends", paramGraphQlQueryMutualFriendsConnection);
  }

  @Deprecated
  public static GraphQlQueryUser.UserField a(GraphQlQueryNewsFeedConnection paramGraphQlQueryNewsFeedConnection)
  {
    return new GraphQlQueryUser.UserField("news_feed", paramGraphQlQueryNewsFeedConnection);
  }

  @Deprecated
  public static GraphQlQueryUser.UserField a(GraphQlQueryNotificationStoriesConnection paramGraphQlQueryNotificationStoriesConnection)
  {
    return new GraphQlQueryUser.UserField("notification_stories", paramGraphQlQueryNotificationStoriesConnection);
  }

  @Deprecated
  public static GraphQlQueryUser.UserField a(GraphQlQueryPeopleYouMayKnowConnection paramGraphQlQueryPeopleYouMayKnowConnection)
  {
    return new GraphQlQueryUser.UserField("people_you_may_know", paramGraphQlQueryPeopleYouMayKnowConnection);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryPhoto paramGraphQlQueryPhoto)
  {
    return new GraphQlQueryUser.UserField("profile_photo", paramGraphQlQueryPhoto);
  }

  @Deprecated
  public static GraphQlQueryUser.UserField a(GraphQlQueryRecommendedApplicationsConnection paramGraphQlQueryRecommendedApplicationsConnection)
  {
    return new GraphQlQueryUser.UserField("recommended_applications", paramGraphQlQueryRecommendedApplicationsConnection);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryStaleClientNotification paramGraphQlQueryStaleClientNotification)
  {
    return new GraphQlQueryUser.UserField("stale_client_notification", paramGraphQlQueryStaleClientNotification);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQuerySubscribersConnection paramGraphQlQuerySubscribersConnection)
  {
    return new GraphQlQueryUser.UserField("subscribers", paramGraphQlQuerySubscribersConnection);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQuerySubscriptionsConnection paramGraphQlQuerySubscriptionsConnection)
  {
    return new GraphQlQueryUser.UserField("subscriptions", paramGraphQlQuerySubscriptionsConnection);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryTimelineNavAppSectionsConnection paramGraphQlQueryTimelineNavAppSectionsConnection)
  {
    return new GraphQlQueryUser.UserField("timeline_nav_app_sections", paramGraphQlQueryTimelineNavAppSectionsConnection);
  }

  public static GraphQlQueryUser.UserField a(GraphQlQueryTimelineSectionsConnection paramGraphQlQueryTimelineSectionsConnection)
  {
    return new GraphQlQueryUser.UserField("timeline_sections", paramGraphQlQueryTimelineSectionsConnection);
  }

  public static GraphQlQueryUser a(List<? extends GraphQlQueryUser.UserField> paramList)
  {
    return new GraphQlQueryUser(paramList, null);
  }

  public static GraphQlQueryUser a(GraphQlQueryUser.UserField[] paramArrayOfUserField)
  {
    return new GraphQlQueryUser(ImmutableList.a(paramArrayOfUserField), null);
  }

  public static GraphQlQueryUser.UserField b(GraphQlQueryFocusedPhoto paramGraphQlQueryFocusedPhoto)
  {
    return new GraphQlQueryUser.UserField("recent_photo", paramGraphQlQueryFocusedPhoto);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.User
 * JD-Core Version:    0.6.2
 */