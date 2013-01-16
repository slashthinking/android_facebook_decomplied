package com.facebook.katana.activity.findfriends;

import com.facebook.analytics.HoneyClientEvent;

public final class FindFriendsAnalyticsEvent extends HoneyClientEvent
{
  public FindFriendsAnalyticsEvent(String paramString)
  {
    super("flow");
    b("flow_name", "contact_importer");
    b("step_name", paramString);
  }

  public FindFriendsAnalyticsEvent a(int paramInt)
  {
    a("contacts_count", paramInt);
    return this;
  }

  public FindFriendsAnalyticsEvent b(int paramInt)
  {
    a("friends_added", paramInt);
    return this;
  }

  public FindFriendsAnalyticsEvent b(long paramLong)
  {
    a("delta_t", paramLong);
    return this;
  }

  public FindFriendsAnalyticsEvent b(boolean paramBoolean)
  {
    a("viewed_how_it_works", paramBoolean);
    return this;
  }

  public FindFriendsAnalyticsEvent c(int paramInt)
  {
    a("friend_candidates_count", paramInt);
    return this;
  }

  public FindFriendsAnalyticsEvent c(boolean paramBoolean)
  {
    a("nux", paramBoolean);
    return this;
  }

  public FindFriendsAnalyticsEvent d(int paramInt)
  {
    a("invite_candidates_count", paramInt);
    return this;
  }

  public FindFriendsAnalyticsEvent e(int paramInt)
  {
    a("invites_sent", paramInt);
    return this;
  }

  public FindFriendsAnalyticsEvent i(String paramString)
  {
    b("step_phase", paramString);
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.FindFriendsAnalyticsEvent
 * JD-Core Version:    0.6.0
 */