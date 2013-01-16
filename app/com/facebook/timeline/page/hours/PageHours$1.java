package com.facebook.timeline.page.hours;

import com.facebook.graphql.model.GraphQLTimeRange;
import java.util.Comparator;

class PageHours$1
  implements Comparator<GraphQLTimeRange>
{
  public int a(GraphQLTimeRange paramGraphQLTimeRange1, GraphQLTimeRange paramGraphQLTimeRange2)
  {
    int i;
    if (paramGraphQLTimeRange1.start == paramGraphQLTimeRange2.start)
      i = 0;
    while (true)
    {
      return i;
      if (paramGraphQLTimeRange1.start > paramGraphQLTimeRange2.start)
      {
        i = 1;
        continue;
      }
      i = -1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.page.hours.PageHours.1
 * JD-Core Version:    0.6.0
 */