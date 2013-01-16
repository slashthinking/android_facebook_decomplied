package com.facebook.timeline;

import android.os.Parcelable;
import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.feed.protocol.FetchTimelineHeaderParams;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.server.OperationResult;

public class TimelineHeaderFetcher extends TimelineReplayableFetcher
{
  final boolean a;
  final boolean b;
  final TimelineAllSectionsData c;
  final FetchTimelineHeaderParams d;
  final TimelineDataFetcher.ViewCallback e;
  final TimelineHeaderData f;
  final TimelineDataFetcher g;
  final Clock h;
  GraphQueryResultEntry i;

  public TimelineHeaderFetcher(boolean paramBoolean1, boolean paramBoolean2, FetchTimelineHeaderParams paramFetchTimelineHeaderParams, TimelineAllSectionsData paramTimelineAllSectionsData, TimelineDataFetcher.ViewCallback paramViewCallback, TimelineHeaderData paramTimelineHeaderData, TimelineDataFetcher paramTimelineDataFetcher, Clock paramClock)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.d = paramFetchTimelineHeaderParams;
    this.c = paramTimelineAllSectionsData;
    this.e = paramViewCallback;
    this.f = paramTimelineHeaderData;
    this.g = paramTimelineDataFetcher;
    this.h = paramClock;
  }

  public Parcelable a()
  {
    return this.d;
  }

  public void a(OperationResult paramOperationResult)
  {
    FetchParcelableResult localFetchParcelableResult = (FetchParcelableResult)paramOperationResult.h();
    this.i = ((GraphQueryResultEntry)localFetchParcelableResult.a);
    this.f.a(this.i);
    if (this.e != null)
      this.e.a(localFetchParcelableResult.e());
  }

  public void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    this.e.c();
  }

  protected boolean a(long paramLong)
  {
    if (this.h.a() - paramLong > 86400000L);
    for (int j = 1; ; j = 0)
      return j;
  }

  public String b()
  {
    return "fetchTimelineHeaderParams";
  }

  public String c()
  {
    return "fetch_timeline_header";
  }

  public boolean d()
  {
    return this.b;
  }

  public int e()
  {
    return 2131361835;
  }

  public void f()
  {
    if (this.a)
    {
      TimelineSectionFetcher.Params localParams = new TimelineSectionFetcher.Params();
      localParams.b = true;
      localParams.c = this.b;
      localParams.e = this.g.a.intValue();
      localParams.f = this.g.b.intValue();
      this.g.a(localParams);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderFetcher
 * JD-Core Version:    0.6.0
 */