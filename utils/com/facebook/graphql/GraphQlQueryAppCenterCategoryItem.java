package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQueryAppCenterCategoryItem extends GraphQlQueryBaseCallable
{
  GraphQlQueryAppCenterCategoryItem(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQueryAppCenterCategoryItem a(List<GraphQlQueryAppCenterCategoryItem.AppCenterCategoryItemField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQueryAppCenterCategoryItem(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQueryAppCenterCategoryItem a(GraphQlQueryAppCenterCategoryItem.AppCenterCategoryItemField[] paramArrayOfAppCenterCategoryItemField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfAppCenterCategoryItemField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryAppCenterCategoryItem
 * JD-Core Version:    0.6.2
 */