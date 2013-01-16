package com.facebook.graphql;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class GraphQl$Application
{
  public static final GraphQlQueryApplication.ApplicationField a = new GraphQlQueryApplication.ApplicationField("id");
  public static final GraphQlQueryApplication.ApplicationField b = new GraphQlQueryApplication.ApplicationField("url.site(mobile)");
  public static final GraphQlQueryApplication.ApplicationField c = new GraphQlQueryApplication.ApplicationField("name");
  public static final GraphQlQueryApplication.ApplicationField d = new GraphQlQueryApplication.ApplicationField("terms_of_service_url");
  public static final GraphQlQueryApplication.ApplicationField e = new GraphQlQueryApplication.ApplicationField("privacy_url");
  public static final GraphQlQueryApplication.ApplicationField f = new GraphQlQueryApplication.ApplicationField("short_description");
  public static final GraphQlQueryApplication.ApplicationField g = new GraphQlQueryApplication.ApplicationField("detailed_description");
  public static final GraphQlQueryApplication.ApplicationField h = new GraphQlQueryApplication.ApplicationField("is_facebook_app");
  public static final GraphQlQueryApplication.ApplicationField i = new GraphQlQueryApplication.ApplicationField("is_game");
  public static final GraphQlQueryApplication.ApplicationField j = new GraphQlQueryApplication.ApplicationField("android_store_url");
  public static final GraphQlQueryApplication.ApplicationField k = new GraphQlQueryApplication.ApplicationField("ios_urls");
  public static final GraphQlQueryApplication.ApplicationField l = new GraphQlQueryApplication.ApplicationField("ios_app_store_url");
  public static final GraphQlQueryApplication.ApplicationField m = new GraphQlQueryApplication.ApplicationField("canvas_url.site(mobile)");
  public static final GraphQlQueryApplication.ApplicationField n = new GraphQlQueryApplication.ApplicationField("average_star_rating");
  public static final GraphQlQueryApplication.ApplicationField o = new GraphQlQueryApplication.ApplicationField("monthly_active_users");
  public static final GraphQlQueryApplication.ApplicationField p = new GraphQlQueryApplication.ApplicationField("viewer_has_authorized");
  public static final GraphQlQueryApplication.ApplicationField q = new GraphQlQueryApplication.ApplicationField("app_center_categories");
  public static final GraphQlQueryApplication.ApplicationField r = new GraphQlQueryApplication.ApplicationField("is_inline_app_store_flow_supported");
  public static final GraphQlQueryApplication.ApplicationField s = new GraphQlQueryApplication.ApplicationField("mobile_canvas_url");
  public static final GraphQlQueryApplication.ApplicationField t = new GraphQlQueryApplication.ApplicationField("username");

  @Deprecated
  public static final GraphQlQueryApplication.ApplicationField u = new GraphQlQueryApplication.ApplicationField("pic_square");

  @Deprecated
  public static final GraphQlQueryApplication.ApplicationField v = new GraphQlQueryApplication.ApplicationField("activity_suggested_privacy");

  public static GraphQlQueryApplication.ApplicationField a(GraphQlQueryAndroidAppConfig paramGraphQlQueryAndroidAppConfig)
  {
    return new GraphQlQueryApplication.ApplicationField("android_app_config", paramGraphQlQueryAndroidAppConfig);
  }

  public static GraphQlQueryApplication.ApplicationField a(GraphQlQueryAppCenterPermissionSummary paramGraphQlQueryAppCenterPermissionSummary)
  {
    return new GraphQlQueryApplication.ApplicationField("app_center_permission_summary", paramGraphQlQueryAppCenterPermissionSummary);
  }

  public static GraphQlQueryApplication.ApplicationField a(GraphQlQueryFriendsWhoRecentlyUsedAppConnection paramGraphQlQueryFriendsWhoRecentlyUsedAppConnection)
  {
    return new GraphQlQueryApplication.ApplicationField("friends_who_recently_used", paramGraphQlQueryFriendsWhoRecentlyUsedAppConnection);
  }

  public static GraphQlQueryApplication.ApplicationField a(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryApplication.ApplicationField("profile_picture", paramGraphQlQueryImage);
  }

  public static GraphQlQueryApplication.ApplicationField a(GraphQlQuerySimilarApplicationsConnection paramGraphQlQuerySimilarApplicationsConnection)
  {
    return new GraphQlQueryApplication.ApplicationField("similar_applications", paramGraphQlQuerySimilarApplicationsConnection);
  }

  public static GraphQlQueryApplication.ApplicationField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryApplication.ApplicationField("social_usage_summary_sentence", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryApplication a(List<? extends GraphQlQueryApplication.ApplicationField> paramList)
  {
    return new GraphQlQueryApplication(paramList, null);
  }

  public static GraphQlQueryApplication a(GraphQlQueryApplication.ApplicationField[] paramArrayOfApplicationField)
  {
    return new GraphQlQueryApplication(ImmutableList.a(paramArrayOfApplicationField), null);
  }

  public static GraphQlQueryApplication.ApplicationField b(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryApplication.ApplicationField("square_logo", paramGraphQlQueryImage);
  }

  public static GraphQlQueryApplication.ApplicationField b(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryApplication.ApplicationField("global_usage_summary_sentence", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryApplication.ApplicationField c(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryApplication.ApplicationField("app_center_cover_image", paramGraphQlQueryImage);
  }

  public static GraphQlQueryApplication.ApplicationField d(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryApplication.ApplicationField("screenshots", paramGraphQlQueryImage);
  }

  public static GraphQlQueryApplication.ApplicationField e(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryApplication.ApplicationField("banner_logo", paramGraphQlQueryImage);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Application
 * JD-Core Version:    0.6.0
 */