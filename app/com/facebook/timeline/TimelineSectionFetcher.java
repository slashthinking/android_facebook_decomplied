package com.facebook.timeline;

import android.os.Parcelable;
import com.facebook.common.util.Log;
import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.feed.protocol.FetchTimelineFirstUnitsParams;
import com.facebook.feed.protocol.FetchTimelineSectionParams;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.graphql.model.PendingPostsList;
import com.facebook.graphql.model.Timeline;
import com.facebook.graphql.model.TimelineSection;
import com.facebook.graphql.model.TimelineUnitCollection;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.server.OperationResult;
import java.util.List;

public class TimelineSectionFetcher extends TimelineReplayableFetcher
{
  final TimelineSectionFetcher.Params a;
  TimelineSectionFetcher.Params b;
  final long c;
  final TimelineDataFetcher d;
  final TimelineAllSectionsData e;
  final TimelineHeaderData f;
  final TimelineDataFetcher.ViewCallback g;
  final boolean h;
  final Clock i;
  final long j;
  final String k;
  boolean l = false;

  public TimelineSectionFetcher(long paramLong, TimelineAllSectionsData paramTimelineAllSectionsData, TimelineHeaderData paramTimelineHeaderData, TimelineDataFetcher paramTimelineDataFetcher, TimelineDataFetcher.ViewCallback paramViewCallback, Clock paramClock, String paramString, TimelineSectionFetcher.Params paramParams)
  {
    this.c = paramLong;
    this.e = paramTimelineAllSectionsData;
    this.f = paramTimelineHeaderData;
    this.d = paramTimelineDataFetcher;
    this.g = paramViewCallback;
    this.a = paramParams;
    this.i = paramClock;
    this.k = paramString;
    this.j = this.i.a();
    this.h = "".equals(paramParams.d);
  }

  public Parcelable a()
  {
    boolean bool = true;
    Object localObject;
    if (this.a.b)
    {
      long l1 = this.c;
      if (this.f.e() == GraphQLObjectType.ObjectType.Page);
      while (true)
      {
        localObject = new FetchTimelineFirstUnitsParams(l1, bool, this.k);
        return localObject;
        bool = false;
      }
    }
    String str = this.a.a;
    if (this.f.e() == GraphQLObjectType.ObjectType.Page);
    while (true)
    {
      localObject = new FetchTimelineSectionParams(str, bool, this.a.d, this.k);
      break;
      bool = false;
    }
  }

  protected void a(OperationResult paramOperationResult)
  {
    boolean bool = true;
    FetchParcelableResult localFetchParcelableResult = (FetchParcelableResult)paramOperationResult.h();
    TimelineSection localTimelineSection;
    int m;
    label123: Object localObject;
    if (this.a.b)
    {
      this.e.a();
      GraphQueryResultEntry localGraphQueryResultEntry = (GraphQueryResultEntry)localFetchParcelableResult.a;
      localTimelineSection = (TimelineSection)localGraphQueryResultEntry.timeline.sections.get(0);
      if (localGraphQueryResultEntry.pendingPosts != null)
      {
        this.f.a(localGraphQueryResultEntry.pendingPosts.count);
        this.g.i();
      }
      this.l = bool;
      if ((!localTimelineSection.units.pageInfo.hasNextPage) || (localTimelineSection.units.pageInfo.endCursor == null))
        break label365;
      m = bool;
      if ((m == 0) || (this.a.e <= 0))
        break label371;
      label138: if ((m == 0) || (bool))
        break label412;
      if (this.a.f <= 0)
        break label376;
      localObject = new TimelineSectionData.ScrollLoadTrigger(localTimelineSection.id, localTimelineSection.units.pageInfo.endCursor, this.a.f);
    }
    while (true)
    {
      label189: this.e.a(this.a.a, false, this.a.b);
      this.e.a(localTimelineSection, (TimelineSectionData.MoreUnits)localObject);
      if (this.g != null)
        this.g.a(localFetchParcelableResult.e(), this.h, this.j);
      if (bool)
      {
        this.b = new TimelineSectionFetcher.Params();
        this.b.a = localTimelineSection.id;
        this.b.c = this.a.c;
        this.b.d = localTimelineSection.units.pageInfo.endCursor;
        this.b.e = (-1 + this.a.e);
        this.b.f = this.a.f;
      }
      while (true)
      {
        return;
        if (this.l)
          Log.a("Unsupported replay of timeline section");
        localTimelineSection = (TimelineSection)localFetchParcelableResult.a;
        break;
        label365: m = 0;
        break label123;
        label371: bool = false;
        break label138;
        label376: localObject = new TimelineSectionData.SeeMore(localTimelineSection.id, localTimelineSection.units.pageInfo.endCursor);
        break label189;
        this.b = null;
      }
      label412: localObject = null;
    }
  }

  protected void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    this.e.a(this.a.a, false, this.a.b);
    this.g.i();
    this.g.d();
  }

  protected boolean a(long paramLong)
  {
    boolean bool1 = this.a.b;
    int m = 0;
    if (bool1)
    {
      boolean bool2 = this.i.a() - paramLong < 300000L;
      m = 0;
      if (bool2)
        m = 1;
    }
    return m;
  }

  public String b()
  {
    if (this.a.b);
    for (String str = "fetchTimelineFirstUnitsParams"; ; str = "fetchTimelineSectionParams")
      return str;
  }

  public String c()
  {
    if (this.a.b);
    for (String str = "fetch_first_units"; ; str = "fetch_section")
      return str;
  }

  public boolean d()
  {
    return this.a.c;
  }

  public int e()
  {
    return 2131361835;
  }

  protected void f()
  {
    if (this.a.b)
    {
      this.d.a(this.a.c);
      if (this.f.G() == GraphQLObjectType.ObjectType.User)
      {
        this.d.b(this.a.c);
        this.d.c(this.a.c);
      }
    }
    if (this.b != null)
      this.d.a(this.b);
  }

  protected void g()
  {
    this.e.a(this.a.a, true, this.a.b);
    this.g.i();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineSectionFetcher
 * JD-Core Version:    0.6.0
 */