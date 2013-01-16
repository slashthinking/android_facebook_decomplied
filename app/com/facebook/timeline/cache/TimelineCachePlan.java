package com.facebook.timeline.cache;

import android.os.Bundle;
import com.facebook.feed.protocol.FetchTimelineFirstUnitsParams;
import com.facebook.feed.protocol.FetchTimelineHeaderParams;
import com.facebook.feed.protocol.FetchTimelineSectionListParams;
import com.facebook.feed.protocol.FetchTimelineSectionParams;
import com.facebook.friends.protocol.FetchFriendListsWithMemberParams;
import com.facebook.graphql.model.FriendListList;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.graphql.model.Timeline;
import com.facebook.graphql.model.TimelineSection;
import com.facebook.orca.server.OperationParams;

public class TimelineCachePlan
{
  private String a;
  private long b;
  private TimelineCachePlan.Enabled c;
  private Class d;
  private long e;
  private String f;

  public TimelineCachePlan(OperationParams paramOperationParams)
  {
    this.f = paramOperationParams.a();
    Bundle localBundle = paramOperationParams.b();
    this.e = localBundle.getLong("profileId");
    TimelineCachePlan.Enabled localEnabled;
    if (localBundle.getBoolean("skipCache", false))
    {
      localEnabled = TimelineCachePlan.Enabled.SKIP_CACHE;
      this.c = localEnabled;
      this.b = 86400000L;
      this.a = null;
      this.d = null;
      if (!"fetch_timeline_header".equals(this.f))
        break label115;
      this.a = a(((FetchTimelineHeaderParams)localBundle.getParcelable("fetchTimelineHeaderParams")).a());
      this.d = GraphQueryResultEntry.class;
      this.b = 2419200000L;
    }
    while (true)
    {
      return;
      localEnabled = TimelineCachePlan.Enabled.CACHEABLE;
      break;
      label115: if ("fetch_section_list".equals(this.f))
      {
        FetchTimelineSectionListParams localFetchTimelineSectionListParams = (FetchTimelineSectionListParams)localBundle.getParcelable("fetchTimelineSectionListParams");
        this.a = (this.f + "_" + localFetchTimelineSectionListParams.a() + "_" + localFetchTimelineSectionListParams.b());
        this.d = Timeline.class;
        continue;
      }
      if ("fetch_section".equals(this.f))
      {
        FetchTimelineSectionParams localFetchTimelineSectionParams = (FetchTimelineSectionParams)(FetchTimelineSectionParams)localBundle.getParcelable("fetchTimelineSectionParams");
        this.a = (this.f + "_" + String.valueOf(localFetchTimelineSectionParams.a()) + "_" + localFetchTimelineSectionParams.d() + "_" + localFetchTimelineSectionParams.b());
        this.b = 86400000L;
        this.d = TimelineSection.class;
        continue;
      }
      if ("fetch_friendlists".equals(this.f))
      {
        this.a = this.f;
        this.e = 1L;
        this.d = FriendListList.class;
        continue;
      }
      if ("fetch_first_units".equals(this.f))
      {
        FetchTimelineFirstUnitsParams localFetchTimelineFirstUnitsParams = (FetchTimelineFirstUnitsParams)(FetchTimelineFirstUnitsParams)localBundle.getParcelable("fetchTimelineFirstUnitsParams");
        this.a = (this.f + "_" + String.valueOf(localFetchTimelineFirstUnitsParams.a()) + "_" + localFetchTimelineFirstUnitsParams.c());
        this.b = 2419200000L;
        this.d = GraphQueryResultEntry.class;
        continue;
      }
      if ("fetch_friendlists_with_member".equals(this.f))
      {
        FetchFriendListsWithMemberParams localFetchFriendListsWithMemberParams = (FetchFriendListsWithMemberParams)(FetchFriendListsWithMemberParams)localBundle.getParcelable("fetchFriendListsWithMemberParams");
        this.a = (this.f + "_" + String.valueOf(localFetchFriendListsWithMemberParams.a()));
        this.d = FriendListList.class;
        continue;
      }
      this.c = TimelineCachePlan.Enabled.NOT_CACHEABLE;
    }
  }

  public static String a(long paramLong)
  {
    return "fetch_timeline_header" + String.valueOf(paramLong);
  }

  public String a()
  {
    return this.a;
  }

  public long b()
  {
    return this.e;
  }

  public String c()
  {
    return this.f;
  }

  public long d()
  {
    return this.b;
  }

  public TimelineCachePlan.Enabled e()
  {
    return this.c;
  }

  public Class f()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.TimelineCachePlan
 * JD-Core Version:    0.6.0
 */