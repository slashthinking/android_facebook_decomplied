package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GraphQueryResultEntry
  implements Parcelable
{

  @JsonProperty("__type__")
  public final GraphQLObjectType __type__ = null;

  @JsonProperty("about")
  public final GraphQLTextWithEntities about = null;

  @JsonProperty("address")
  public final GraphQLAddress address = null;

  @JsonProperty("alternate_name")
  public final String alternateName = null;

  @JsonProperty("birthday")
  public final String birthday = null;

  @JsonProperty("bylines")
  public final List<TimelineBylineFragment> bylines = null;

  @JsonProperty("can_message")
  public final boolean canMessage = false;

  @JsonProperty("can_viewer_post")
  public final boolean canViewerPost = false;

  @JsonProperty("can_viewer_post_photo_to_timeline")
  public final boolean canViewerPostPhoto = false;

  @JsonProperty("can_viewer_send_gift")
  public final boolean canViewerSendGift = false;

  @JsonProperty("category_names")
  public final List<String> categoryNames = null;

  @JsonProperty("timeline_cover_photo")
  public final GraphQLFocusedPhoto coverPhoto = null;

  @JsonProperty("current_city")
  public final GraphQLEntity currentCity = null;

  @JsonProperty("does_viewer_like")
  public final boolean doesViewerLike = false;

  @JsonProperty("expressed_as_place")
  public final boolean expressedAsPlace = false;

  @JsonProperty("featured_friends")
  public final GraphQLProfileList featuredFriends = null;

  @JsonProperty("feedback")
  private final Feedback feedback = null;

  @JsonProperty("friend_lists")
  public final FriendListList friendLists = null;

  @JsonProperty("friend_recommendations")
  public final PageRecommendationList friendRecommendations = null;

  @JsonProperty("friends")
  public final GraphQLProfileList friends = null;

  @JsonProperty("friends_here_now")
  public final PageFriendsHereNow friendsHereNow = null;

  @JsonProperty("friends_here_now_social_context")
  public final GraphQLTextWithEntities friendsHereNowSocialContext = null;

  @JsonProperty("friends_who_like")
  public final PageFriendsWhoLike friendsWhoLike = null;

  @JsonProperty("friends_who_visited")
  public final PageFriendsWhoVisited friendsWhoVisited = null;

  @JsonProperty("friendship_status")
  public final String friendshipStatus = null;

  @JsonProperty("gender")
  public final String gender = null;

  @JsonProperty("hours")
  public final List<GraphQLTimeRange> hours = null;

  @JsonProperty("is_viewer_friend")
  public final boolean isViewerFriend = false;

  @JsonProperty("liked_profiles")
  public final GraphQLProfileList likedProfiles = null;

  @JsonProperty("location")
  public final GraphQLLocation location = null;

  @JsonProperty("name")
  public final String name = null;

  @JsonProperty("nonfriend_recommendations")
  public final PageRecommendationList nonFriendRecommendations = null;

  @JsonProperty("overall_rating")
  public final double overallRating = 0.0D;

  @JsonProperty("page_likers")
  public final GraphQLProfileList pageLikers = null;

  @JsonProperty("raters")
  public final PageStarRatersList pageRaters = null;

  @JsonProperty("page_visits")
  public final GraphQLProfileList pageVisits = null;

  @JsonProperty("all_pending_posts")
  public final PendingPostsList pendingPosts = null;

  @JsonProperty("people_talking_about")
  public final GraphQLProfileList peopleTalkingAbout = null;

  @JsonProperty("phone_number")
  public final GraphQLPhoneNumber phoneNumber = null;

  @JsonProperty("place_type")
  public final String placeType = null;

  @JsonProperty("price_range_description")
  public final String priceRangeDescription = null;

  @JsonProperty("profile_photo")
  public final GraphQLMedia profilePhoto = null;

  @JsonProperty("profile_picture")
  public final GraphQLImage profilePicture = null;

  @JsonProperty("recent_photo")
  public final GraphQLFocusedPhoto recentPhoto = null;

  @JsonProperty("recommendations")
  public final PageRecommendationList recommendations = null;

  @JsonProperty("social_context_for_non_liking_viewer")
  public final GraphQLTextWithEntities socialContextForNonLikingViewer = null;

  @JsonProperty("subscribe_status")
  public final String subscribeStatus = null;

  @JsonProperty("subscribers")
  public final GraphQLProfileList subscribers = null;

  @JsonProperty("subscriptions")
  public final GraphQLProfileList subscriptions = null;

  @JsonProperty("super_category_type")
  public final String superCategoryType = null;

  @JsonProperty("tagged_photos")
  public final GraphQLMediaList taggedPhotos = null;

  @JsonProperty("timeline_sections")
  public final Timeline timeline = null;

  @JsonProperty("timeline_nav_app_sections")
  public final TimelineAppSectionList timelineAppSections = null;

  @JsonProperty("viewer_acts_as_profile")
  public final boolean viewerActsAsProfile = false;

  @JsonProperty("viewer_profile_permissions")
  public final List<String> viewerProfilePermissions = null;

  @JsonProperty("viewer_rating")
  public final int viewerRating = 0;

  @JsonProperty("viewer_visits")
  public final PageViewerVisitsList viewerVisits = null;

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQueryResultEntry
 * JD-Core Version:    0.6.2
 */