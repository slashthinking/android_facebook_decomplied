package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQueryImage extends GraphQlQueryBaseCallable
{
  GraphQlQueryImage(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQueryImage a(String paramString)
  {
    if (this.b == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Alias already set");
      return new GraphQlQueryImage(this.a, this.c, (String)Preconditions.checkNotNull(paramString));
    }
  }

  public GraphQlQueryImage a(List<GraphQlQueryImage.ImageField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQueryImage(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQueryImage a(GraphQlQueryImage.ImageField[] paramArrayOfImageField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfImageField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryImage
 * JD-Core Version:    0.6.2
 */