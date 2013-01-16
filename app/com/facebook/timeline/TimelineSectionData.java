package com.facebook.timeline;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackableGraphQLNode;
import com.facebook.graphql.model.TimelineSection;
import com.facebook.graphql.model.TimelineUnitCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TimelineSectionData
{
  private List<Object> a = new ArrayList();
  private final String b;
  private boolean c = false;
  private boolean d = false;

  public TimelineSectionData(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.b = paramString1;
    if (!paramBoolean)
      this.a.add(new TimelineSectionData.TimelineSectionLabel(paramString1, paramString2));
    while (true)
    {
      return;
      this.d = true;
    }
  }

  public FeedbackableGraphQLNode a(String paramString1, String paramString2)
  {
    Iterator localIterator = this.a.iterator();
    FeedbackableGraphQLNode localFeedbackableGraphQLNode;
    while (true)
      if (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof FeedbackableGraphQLNode))
          continue;
        localFeedbackableGraphQLNode = (FeedbackableGraphQLNode)localObject;
        if ((paramString1 == null) || (!(localObject instanceof FeedUnit)) || (!paramString1.equals(((FeedUnit)localObject).getCacheId())))
          break;
      }
    while (true)
    {
      return localFeedbackableGraphQLNode;
      if (paramString2 == null)
        break;
      Feedback localFeedback = localFeedbackableGraphQLNode.S();
      if ((localFeedback == null) || (!paramString2.equals(localFeedback.legacyApiPostId)))
        break;
      continue;
      localFeedbackableGraphQLNode = null;
    }
  }

  public Object a(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public String a()
  {
    return this.b;
  }

  public void a(FeedUnit paramFeedUnit)
  {
    for (int i = 0; ; i++)
    {
      if (i < this.a.size())
      {
        Object localObject = this.a.get(i);
        if (!(localObject instanceof FeedUnit))
          continue;
        FeedUnit localFeedUnit = (FeedUnit)localObject;
        if ((localFeedUnit.getCacheId() == null) || (!localFeedUnit.getCacheId().equals(paramFeedUnit.getCacheId())))
          continue;
        this.a.set(i, paramFeedUnit);
      }
      return;
    }
  }

  public void a(TimelineSection paramTimelineSection, TimelineSectionData.MoreUnits paramMoreUnits)
  {
    while ((b() > 0) && ((a(-1 + b()) instanceof TimelineSectionData.MoreUnits)))
      this.a.remove(-1 + b());
    if ((!this.c) && (paramTimelineSection.units.units.size() <= 0) && (!this.d))
      this.a.add(new TimelineSectionData.NoStoriesMarker());
    this.a.addAll(paramTimelineSection.units.units);
    if (paramMoreUnits != null)
      this.a.add(paramMoreUnits);
    this.c = true;
  }

  public void a(TimelineSectionData.MoreUnits paramMoreUnits)
  {
    this.a.remove(paramMoreUnits);
  }

  public void a(String paramString)
  {
    for (int i = 0; ; i++)
    {
      if (i < this.a.size())
      {
        Object localObject = this.a.get(i);
        if (!(localObject instanceof FeedUnit))
          continue;
        FeedUnit localFeedUnit = (FeedUnit)localObject;
        if ((localFeedUnit.getCacheId() == null) || (!localFeedUnit.getCacheId().equals(paramString)))
          continue;
        this.a.remove(i);
      }
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      if (b() > 0)
      {
        Object localObject2 = a(-1 + b());
        if ((localObject2 instanceof TimelineSectionData.Scrubber))
          ((TimelineSectionData.Scrubber)localObject2).a = true;
      }
    while (true)
    {
      return;
      if (!(this.a.get(-1 + b()) instanceof TimelineSectionData.LoadingIndicator))
      {
        TimelineSectionData.LoadingIndicator localLoadingIndicator = new TimelineSectionData.LoadingIndicator();
        this.a.add(localLoadingIndicator);
        continue;
        if (b() <= 0)
          continue;
        Object localObject1 = a(-1 + b());
        if ((localObject1 instanceof TimelineSectionData.Scrubber))
        {
          ((TimelineSectionData.Scrubber)localObject1).a = false;
          continue;
        }
      }
      else
      {
        continue;
      }
      while ((b() > 0) && ((a(-1 + b()) instanceof TimelineSectionData.LoadingIndicator)))
        this.a.remove(-1 + b());
    }
  }

  public int b()
  {
    return this.a.size();
  }

  public boolean c()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineSectionData
 * JD-Core Version:    0.6.0
 */