package com.facebook.timeline.page.hours;

import com.facebook.common.util.Log;
import com.facebook.graphql.model.GraphQLTimeRange;
import com.facebook.orca.common.util.Clock;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class PageHours
{
  private final List<GraphQLTimeRange> a;
  private final TimeZone b;
  private final Clock c;

  public PageHours(List<GraphQLTimeRange> paramList, TimeZone paramTimeZone, Clock paramClock)
  {
    Preconditions.checkNotNull(paramList);
    if (paramList.size() > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.a = a(paramList);
      this.b = ((TimeZone)Preconditions.checkNotNull(paramTimeZone));
      this.c = ((Clock)Preconditions.checkNotNull(paramClock));
      return;
    }
  }

  private PageHours.Status a(long paramLong)
  {
    GraphQLTimeRange localGraphQLTimeRange = b(paramLong);
    PageHours.Status localStatus;
    if (localGraphQLTimeRange == null)
      localStatus = PageHours.Status.UNKNOWN;
    while (true)
    {
      return localStatus;
      if (a(localGraphQLTimeRange.start, localGraphQLTimeRange.end, paramLong))
      {
        localStatus = PageHours.Status.OPEN;
        continue;
      }
      localStatus = PageHours.Status.CLOSED;
    }
  }

  private List<GraphQLTimeRange> a(List<GraphQLTimeRange> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    Collections.sort(localArrayList, new PageHours.1(this));
    Iterator localIterator = localArrayList.iterator();
    long l = -1L;
    while (localIterator.hasNext())
    {
      GraphQLTimeRange localGraphQLTimeRange = (GraphQLTimeRange)localIterator.next();
      if ((localGraphQLTimeRange.start <= l) || (localGraphQLTimeRange.end <= localGraphQLTimeRange.start))
        Log.a("Got invalid hours struct! (" + localGraphQLTimeRange.start + ", " + localGraphQLTimeRange.end + ")");
      l = localGraphQLTimeRange.end;
    }
    return localArrayList;
  }

  private boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 - 28800L) / 86400L == (paramLong2 - 28800L) / 86400L);
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean a(long paramLong1, long paramLong2, long paramLong3)
  {
    int i = 1;
    if (paramLong1 < paramLong2)
      if ((paramLong3 < paramLong1) || (paramLong3 > paramLong2));
    while (true)
    {
      return i;
      i = 0;
      continue;
      int j;
      if (paramLong3 < paramLong1)
      {
        boolean bool = paramLong3 < paramLong2;
        j = 0;
        if (bool);
      }
      else
      {
        j = i;
      }
      i = j;
    }
  }

  private GraphQLTimeRange b(long paramLong)
  {
    long l = 1L + ((GraphQLTimeRange)this.a.get(-1 + this.a.size())).end;
    Iterator localIterator = this.a.iterator();
    GraphQLTimeRange localGraphQLTimeRange;
    if (localIterator.hasNext())
    {
      localGraphQLTimeRange = (GraphQLTimeRange)localIterator.next();
      if (!a(l, localGraphQLTimeRange.end, paramLong));
    }
    while (true)
    {
      return localGraphQLTimeRange;
      l = 1L + localGraphQLTimeRange.end;
      break;
      Log.a("Timestamp didn't belong to any timerange!  This shouldn't be possible!");
      localGraphQLTimeRange = null;
    }
  }

  private long c(long paramLong)
  {
    return 28800L + (paramLong + this.b.getOffset(1000L * paramLong) / 1000) % 604800L;
  }

  public PageHours.Status a()
  {
    return a(d());
  }

  public GraphQLTimeRange b()
  {
    return b(d());
  }

  public GraphQLTimeRange c()
  {
    long l = d();
    GraphQLTimeRange localGraphQLTimeRange1 = b();
    GraphQLTimeRange localGraphQLTimeRange2;
    if ((localGraphQLTimeRange1 != null) && ((a(l, localGraphQLTimeRange1.start)) || (a(localGraphQLTimeRange1.start, localGraphQLTimeRange1.end, l))))
      localGraphQLTimeRange2 = localGraphQLTimeRange1;
    while (true)
    {
      return localGraphQLTimeRange2;
      Iterator localIterator = this.a.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          localGraphQLTimeRange2 = (GraphQLTimeRange)localIterator.next();
          if (!a(l, localGraphQLTimeRange2.start))
            continue;
          break;
        }
      localGraphQLTimeRange2 = null;
    }
  }

  public long d()
  {
    return c(this.c.a() / 1000L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.page.hours.PageHours
 * JD-Core Version:    0.6.0
 */