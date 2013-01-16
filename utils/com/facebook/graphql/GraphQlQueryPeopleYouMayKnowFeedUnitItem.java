package com.facebook.graphql;

import com.google.common.base.Preconditions;
import java.util.List;

public final class GraphQlQueryPeopleYouMayKnowFeedUnitItem extends GraphQlQueryBaseObjectImpl
  implements GraphQlQueryItemListFeedUnitItem
{
  GraphQlQueryPeopleYouMayKnowFeedUnitItem(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, true);
  }

  public GraphQlQueryPeopleYouMayKnowFeedUnitItem a(String paramString)
  {
    if (this.b == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Alias already set");
      return new GraphQlQueryPeopleYouMayKnowFeedUnitItem(this.c, (String)Preconditions.checkNotNull(paramString));
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryPeopleYouMayKnowFeedUnitItem
 * JD-Core Version:    0.6.2
 */