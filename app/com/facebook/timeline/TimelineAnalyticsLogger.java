package com.facebook.timeline;

import android.app.Activity;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.InteractionLogger.ContentFlags;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.orca.activity.FbActivityUtils;
import com.facebook.orca.server.DataFreshnessResult;

public class TimelineAnalyticsLogger
{
  private InteractionLogger a;
  private Activity b;

  public TimelineAnalyticsLogger(Activity paramActivity)
  {
    this.b = paramActivity;
    this.a = new InteractionLogger(paramActivity);
  }

  public static TimelineAnalyticsLogger.RelationshipType a(TimelineHeaderData paramTimelineHeaderData)
  {
    TimelineAnalyticsLogger.RelationshipType localRelationshipType = TimelineAnalyticsLogger.RelationshipType.UNDEFINED;
    if (paramTimelineHeaderData.e() == GraphQLObjectType.ObjectType.User)
    {
      if (paramTimelineHeaderData.u() != TimelineHeaderData.UserFriendshipStatus.ARE_FRIENDS)
        break label30;
      localRelationshipType = TimelineAnalyticsLogger.RelationshipType.FRIEND;
    }
    while (true)
    {
      return localRelationshipType;
      label30: if (paramTimelineHeaderData.f())
      {
        localRelationshipType = TimelineAnalyticsLogger.RelationshipType.SELF;
        continue;
      }
      if (paramTimelineHeaderData.v() == TimelineHeaderData.SubscribeStatus.IS_SUBSCRIBED)
      {
        localRelationshipType = TimelineAnalyticsLogger.RelationshipType.SUBSCRIBED_TO;
        continue;
      }
      localRelationshipType = TimelineAnalyticsLogger.RelationshipType.UNKNOWN_RELATIONSHIP;
    }
  }

  private void a(InteractionLogger.ContentFlags paramContentFlags, long paramLong1, long paramLong2, TimelineAnalyticsLogger.RelationshipType paramRelationshipType)
  {
    HoneyClientEvent localHoneyClientEvent = this.a.a(paramContentFlags, "timeline", FbActivityUtils.a(this.b), paramLong1);
    localHoneyClientEvent.a("profile_id", paramLong2);
    if (paramRelationshipType != TimelineAnalyticsLogger.RelationshipType.UNDEFINED)
      localHoneyClientEvent.a("relationship_type", paramRelationshipType.getValue());
    this.a.b(localHoneyClientEvent);
  }

  private void a(InteractionLogger.ContentFlags paramContentFlags, long paramLong, TimelineAnalyticsLogger.RelationshipType paramRelationshipType)
  {
    a(paramContentFlags, -1L, paramLong, paramRelationshipType);
  }

  public void a(DataFreshnessResult paramDataFreshnessResult, long paramLong1, long paramLong2, TimelineAnalyticsLogger.RelationshipType paramRelationshipType)
  {
    if (paramDataFreshnessResult == DataFreshnessResult.FROM_SERVER)
    {
      a(InteractionLogger.ContentFlags.LOCAL_DATA, paramLong1, paramLong2, paramRelationshipType);
      a(InteractionLogger.ContentFlags.NETWORK_DATA, paramLong2, paramRelationshipType);
    }
    while (true)
    {
      return;
      if ((paramDataFreshnessResult == DataFreshnessResult.FROM_CACHE_UP_TO_DATE) || (paramDataFreshnessResult == DataFreshnessResult.FROM_CACHE_STALE))
      {
        a(InteractionLogger.ContentFlags.NO_DATA, paramLong2, paramRelationshipType);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineAnalyticsLogger
 * JD-Core Version:    0.6.0
 */