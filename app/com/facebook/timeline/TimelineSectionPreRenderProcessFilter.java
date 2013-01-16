package com.facebook.timeline;

import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.graphql.model.LifeEventFeedUnit;
import com.facebook.graphql.model.Timeline;
import com.facebook.graphql.model.TimelineSection;
import com.facebook.graphql.model.TimelineUnitCollection;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import java.util.Iterator;
import java.util.List;

public class TimelineSectionPreRenderProcessFilter
  implements OrcaServiceHandler.Filter
{
  private final FeedLinkifyUtil a;

  public TimelineSectionPreRenderProcessFilter(FeedLinkifyUtil paramFeedLinkifyUtil)
  {
    this.a = paramFeedLinkifyUtil;
  }

  private void a(TimelineSection paramTimelineSection)
  {
    if ((paramTimelineSection != null) && (paramTimelineSection.units != null) && (paramTimelineSection.units.units != null))
    {
      Iterator localIterator = paramTimelineSection.units.units.iterator();
      while (localIterator.hasNext())
      {
        FeedUnit localFeedUnit = (FeedUnit)localIterator.next();
        if ((localFeedUnit instanceof FeedStory))
        {
          this.a.a((FeedStory)localFeedUnit);
          continue;
        }
        if (!(localFeedUnit instanceof LifeEventFeedUnit))
          continue;
        this.a.a((LifeEventFeedUnit)localFeedUnit);
      }
    }
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    if (localOperationResult.c())
    {
      if (!"fetch_section".equals(str))
        break label52;
      a((TimelineSection)((FetchParcelableResult)localOperationResult.h()).a);
    }
    while (true)
    {
      return localOperationResult;
      label52: if (!"fetch_first_units".equals(str))
        continue;
      a((TimelineSection)((GraphQueryResultEntry)((FetchParcelableResult)localOperationResult.h()).a).timeline.sections.get(0));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineSectionPreRenderProcessFilter
 * JD-Core Version:    0.6.0
 */