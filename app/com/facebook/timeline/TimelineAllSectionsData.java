package com.facebook.timeline;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackableGraphQLNode;
import com.facebook.graphql.model.LifeEventFeedUnit;
import com.facebook.graphql.model.LifeEventFeedUnitBuilder;
import com.facebook.graphql.model.Timeline;
import com.facebook.graphql.model.TimelineSection;
import com.facebook.graphql.model.TimelineUnitCollection;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TimelineAllSectionsData
{
  private static final Class<?> g = TimelineAllSectionsData.class;
  public final Integer a = Integer.valueOf(7);
  private final FbErrorReporter b;
  private List<TimelineSectionData> c = new ArrayList();
  private TimelineSectionData.LoadingIndicator d = new TimelineSectionData.LoadingIndicator();
  private PendingStoryCache e;
  private boolean f;

  public TimelineAllSectionsData(FbErrorReporter paramFbErrorReporter)
  {
    this.b = paramFbErrorReporter;
    this.e = new PendingStoryCache();
  }

  private void a(FeedUnit paramFeedUnit)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
      ((TimelineSectionData)localIterator.next()).a(paramFeedUnit);
  }

  private TimelineSectionData c(String paramString)
  {
    int i = 0;
    if (i < this.c.size())
      if (!paramString.equals(((TimelineSectionData)this.c.get(i)).a()));
    for (TimelineSectionData localTimelineSectionData = (TimelineSectionData)this.c.get(i); ; localTimelineSectionData = null)
    {
      return localTimelineSectionData;
      i++;
      break;
    }
  }

  public int a(TimelineSection paramTimelineSection, TimelineSectionData.MoreUnits paramMoreUnits)
  {
    TimelineSectionData localTimelineSectionData;
    if (this.c.isEmpty())
    {
      localTimelineSectionData = new TimelineSectionData(paramTimelineSection.id, "", true);
      this.c.add(localTimelineSectionData);
      if (localTimelineSectionData == null)
        break label77;
      localTimelineSectionData.a(paramTimelineSection, paramMoreUnits);
    }
    label77: for (int i = paramTimelineSection.units.units.size(); ; i = 0)
    {
      return i;
      localTimelineSectionData = c(paramTimelineSection.id);
      break;
    }
  }

  public FeedbackableGraphQLNode a(String paramString1, String paramString2)
  {
    Iterator localIterator = this.c.iterator();
    FeedbackableGraphQLNode localFeedbackableGraphQLNode;
    do
    {
      if (!localIterator.hasNext())
        break;
      localFeedbackableGraphQLNode = ((TimelineSectionData)localIterator.next()).a(paramString1, paramString2);
    }
    while (localFeedbackableGraphQLNode == null);
    while (true)
    {
      return localFeedbackableGraphQLNode;
      localFeedbackableGraphQLNode = null;
    }
  }

  public TimelineSectionData.ScrollLoadTrigger a(int paramInt1, int paramInt2)
  {
    int i = Math.max(paramInt1, 0);
    Object localObject;
    if ((i < b()) && (i < paramInt1 + paramInt2 + this.a.intValue()))
    {
      localObject = a(i);
      if (!(localObject instanceof TimelineSectionData.ScrollLoadTrigger));
    }
    for (TimelineSectionData.ScrollLoadTrigger localScrollLoadTrigger = (TimelineSectionData.ScrollLoadTrigger)localObject; ; localScrollLoadTrigger = null)
    {
      return localScrollLoadTrigger;
      i++;
      break;
    }
  }

  public Object a(int paramInt)
  {
    int i = 0;
    Object localObject;
    if ((paramInt == 0) && ((this.c.isEmpty()) || (this.f)))
    {
      localObject = this.d;
      return localObject;
    }
    if (this.f);
    int k;
    for (int j = 1; ; j = 0)
    {
      k = paramInt - j;
      if (k >= this.e.c())
        break label92;
      localObject = ((FeedEdge)this.e.b().get(k)).b();
      break;
    }
    label92: int n;
    for (int m = k - this.e.c(); ; m = n)
    {
      if (i >= this.c.size())
        break label192;
      if (m < ((TimelineSectionData)this.c.get(i)).b())
      {
        localObject = ((TimelineSectionData)this.c.get(i)).a(m);
        break;
      }
      n = m - ((TimelineSectionData)this.c.get(i)).b();
      i++;
    }
    label192: throw new IllegalArgumentException("Invalid index:" + paramInt);
  }

  public void a()
  {
    this.c.clear();
    this.e.a();
  }

  public void a(FeedbackableGraphQLNode paramFeedbackableGraphQLNode, Feedback paramFeedback)
  {
    if ((paramFeedbackableGraphQLNode instanceof FeedStory))
      a(new FeedStoryBuilder((FeedStory)paramFeedbackableGraphQLNode).a(paramFeedback).b(System.currentTimeMillis()).G());
    while (true)
    {
      return;
      if ((paramFeedbackableGraphQLNode instanceof LifeEventFeedUnit))
      {
        a(new LifeEventFeedUnitBuilder((LifeEventFeedUnit)paramFeedbackableGraphQLNode).a(paramFeedback).a(System.currentTimeMillis()).b());
        continue;
      }
      this.b.a("timeline_story_update_fail", "Unable to update unit of type " + paramFeedbackableGraphQLNode.getClass().toString(), true);
    }
  }

  public void a(Timeline paramTimeline)
  {
    int i = 0;
    boolean bool1;
    label81: label87: List localList;
    String str1;
    String str2;
    if ((i >= this.c.size()) || (i >= paramTimeline.sections.size()) || (!((TimelineSection)paramTimeline.sections.get(i)).id.equals(((TimelineSectionData)this.c.get(i)).a())))
    {
      if (i != this.c.size())
        break label175;
      bool1 = true;
      Preconditions.checkState(bool1, "Unexpected sections in mSections while merging");
      if (i >= paramTimeline.sections.size())
        return;
      TimelineSection localTimelineSection = (TimelineSection)paramTimeline.sections.get(i);
      localList = this.c;
      str1 = localTimelineSection.id;
      str2 = localTimelineSection.label;
      if (i != 0)
        break label180;
    }
    label175: label180: for (boolean bool2 = true; ; bool2 = false)
    {
      localList.add(new TimelineSectionData(str1, str2, bool2));
      i++;
      break label87;
      i++;
      break;
      bool1 = false;
      break label81;
    }
  }

  public void a(TimelineSectionData.MoreUnits paramMoreUnits)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
      ((TimelineSectionData)localIterator.next()).a(paramMoreUnits);
  }

  public void a(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
      ((TimelineSectionData)localIterator.next()).a(paramString);
  }

  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
      a(paramBoolean1);
    while (true)
    {
      return;
      TimelineSectionData localTimelineSectionData = c(paramString);
      if (localTimelineSectionData == null)
        continue;
      localTimelineSectionData.a(paramBoolean1);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public int b()
  {
    int i = 1;
    int j = 0;
    if (this.c.isEmpty());
    while (true)
    {
      return i;
      if (this.f);
      int k;
      while (true)
      {
        int m;
        for (k = i + this.e.c(); j < this.c.size(); k = m)
        {
          m = k + ((TimelineSectionData)this.c.get(j)).b();
          j++;
        }
        i = 0;
      }
      i = k;
    }
  }

  public boolean b(String paramString)
  {
    TimelineSectionData localTimelineSectionData = c(paramString);
    if (localTimelineSectionData != null);
    for (boolean bool = localTimelineSectionData.c(); ; bool = false)
      return bool;
  }

  public PendingStoryCache c()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineAllSectionsData
 * JD-Core Version:    0.6.0
 */