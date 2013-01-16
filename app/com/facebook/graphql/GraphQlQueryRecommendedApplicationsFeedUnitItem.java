package com.facebook.graphql;

import com.google.common.base.Preconditions;
import java.util.List;

public final class GraphQlQueryRecommendedApplicationsFeedUnitItem extends GraphQlQueryBaseObjectImpl
  implements GraphQlQueryItemListFeedUnitItem
{
  GraphQlQueryRecommendedApplicationsFeedUnitItem(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, true);
  }

  public GraphQlQueryRecommendedApplicationsFeedUnitItem a(String paramString)
  {
    if (this.b == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Alias already set");
      return new GraphQlQueryRecommendedApplicationsFeedUnitItem(this.c, (String)Preconditions.checkNotNull(paramString));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryRecommendedApplicationsFeedUnitItem
 * JD-Core Version:    0.6.0
 */