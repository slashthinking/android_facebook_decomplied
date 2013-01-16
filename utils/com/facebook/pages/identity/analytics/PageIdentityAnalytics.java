package com.facebook.pages.identity.analytics;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;

public class PageIdentityAnalytics
{
  private final InteractionLogger a;

  public PageIdentityAnalytics(InteractionLogger paramInteractionLogger)
  {
    this.a = paramInteractionLogger;
  }

  public void a(long paramLong, String paramString)
  {
    this.a.a(new HoneyClientEvent("page_details_loaded").d("places_page").a("page_id", paramLong).b("session_id", paramString));
  }

  public void a(String paramString)
  {
    this.a.a(new HoneyClientEvent("directions_button").d("places_page").b("session_id", paramString));
  }

  public void a(String paramString, int paramInt)
  {
    this.a.a(new HoneyClientEvent("checked_into").d("places_page").b("session_id", paramString).a("checked_in_before", paramInt));
  }

  public void b(long paramLong, String paramString)
  {
    this.a.a(new HoneyClientEvent("page_details_load_error").d("places_page").a("page_id", paramLong).b("error", paramString));
  }

  public void b(String paramString)
  {
    this.a.a(new HoneyClientEvent("page_liked").d("places_page").b("session_id", paramString));
  }

  public void c(long paramLong, String paramString)
  {
    this.a.a(new HoneyClientEvent("page_rating_successful").d("places_page").a("page_id", paramLong).b("session_id", paramString));
  }

  public void c(String paramString)
  {
    this.a.a(new HoneyClientEvent("page_unliked").d("places_page").b("session_id", paramString));
  }

  public void d(long paramLong, String paramString)
  {
    this.a.a(new HoneyClientEvent("page_rating_error").d("places_page").a("page_id", paramLong).b("session_id", paramString));
  }

  public void d(String paramString)
  {
    this.a.a(new HoneyClientEvent("call_button").d("places_page").b("session_id", paramString));
  }

  public void e(String paramString)
  {
    this.a.a(new HoneyClientEvent("viewed_friend_likers_or_visitors").d("places_page").b("session_id", paramString));
  }

  public void f(String paramString)
  {
    this.a.a(new HoneyClientEvent("viewed_friends_here_now").d("places_page").b("session_id", paramString));
  }

  public void g(String paramString)
  {
    this.a.a(new HoneyClientEvent("viewed_recommendation").d("places_page").b("session_id", paramString));
  }

  public void h(String paramString)
  {
    this.a.a(new HoneyClientEvent("viewed_all_recommendations").d("places_page").b("session_id", paramString));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.analytics.PageIdentityAnalytics
 * JD-Core Version:    0.6.2
 */