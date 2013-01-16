package com.facebook.nearby.analytics;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import java.util.Set;

public class NearbyAnalytics
{
  private final InteractionLogger a;

  public NearbyAnalytics(InteractionLogger paramInteractionLogger)
  {
    this.a = paramInteractionLogger;
  }

  public void a()
  {
    this.a.a(new HoneyClientEvent("recommendation_request_cancelled").d("places_recommendations"));
  }

  public void a(int paramInt, String paramString)
  {
    this.a.a(new HoneyClientEvent("results_loaded").d("places_recommendations").a("result_count", paramInt).b("session_id", paramString));
  }

  public void a(String paramString)
  {
    this.a.a(new HoneyClientEvent("location_error").d("places_recommendations").b("error", paramString));
  }

  public void a(String paramString1, String paramString2)
  {
    this.a.a(new HoneyClientEvent("page_selected").d("places_recommendations").b("page_id", paramString1).b("session_id", paramString2));
  }

  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    this.a.a(new HoneyClientEvent("search_result_user_selection").d("places_recommendations").b("search_query_string", paramString1).b("selection_type", paramString2).a("selection_id", paramLong1).a("selection_rank", paramLong2).b("session_id", paramString3));
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.a.a(new HoneyClientEvent("search_results_error").d("places_recommendations").b("search_error", paramString1).b("search_query_string", paramString2).b("session_id", paramString3));
  }

  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.a.a(new HoneyClientEvent("tap_result_in_list").d("places_recommendations").b("page_id", paramString1).a("has_friend_context", paramBoolean).b("session_id", paramString2));
  }

  public void a(Set<Long> paramSet, String paramString)
  {
    if (!paramSet.isEmpty())
      this.a.a(new HoneyClientEvent("category_selected").d("places_search").a("topic_ids", ((Long)paramSet.toArray()[0]).longValue()).b("session_id", paramString));
  }

  public void b()
  {
    this.a.a(new HoneyClientEvent("viewed_with_location_off").d("places_recommendations"));
  }

  public void b(String paramString)
  {
    this.a.a(new HoneyClientEvent("results_error").d("places_recommendations").b("error", paramString));
  }

  public void b(String paramString1, String paramString2)
  {
    this.a.a(new HoneyClientEvent("tooltip_tapped").d("places_recommendations").b("page_id", paramString1).b("session_id", paramString2));
  }

  public void c()
  {
    this.a.a(new HoneyClientEvent("opened_location_setting").d("places_recommendations"));
  }

  public void c(String paramString)
  {
    this.a.a(new HoneyClientEvent("view_result_list").d("places_recommendations").b("session_id", paramString));
  }

  public void c(String paramString1, String paramString2)
  {
    this.a.a(new HoneyClientEvent("search_cancel").d("places_search").b("search_query_string", paramString1).b("session_id", paramString2));
  }

  public void d(String paramString)
  {
    this.a.a(new HoneyClientEvent("current_location_button").d("places_recommendations").b("session_id", paramString));
  }

  public void d(String paramString1, String paramString2)
  {
    this.a.a(new HoneyClientEvent("search_results_loaded").d("places_recommendations").b("search_query_string", paramString1).b("session_id", paramString2));
  }

  public void e(String paramString)
  {
    this.a.a(new HoneyClientEvent("search_this_location").d("places_recommendations").b("session_id", paramString));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.analytics.NearbyAnalytics
 * JD-Core Version:    0.6.0
 */