package com.facebook.graphql;

import com.google.common.base.Preconditions;
import java.util.List;

public final class GraphQlQueryCelebrationsFeedUnitItem extends GraphQlQueryBaseObjectImpl
  implements GraphQlQueryItemListFeedUnitItem
{
  GraphQlQueryCelebrationsFeedUnitItem(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, true);
  }

  public GraphQlQueryCelebrationsFeedUnitItem a(String paramString)
  {
    if (this.b == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Alias already set");
      return new GraphQlQueryCelebrationsFeedUnitItem(this.c, (String)Preconditions.checkNotNull(paramString));
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryCelebrationsFeedUnitItem
 * JD-Core Version:    0.6.2
 */