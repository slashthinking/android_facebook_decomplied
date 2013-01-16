package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;

public final class GraphQlQueryTextWithEntities extends GraphQlQueryBaseObjectImpl
{
  GraphQlQueryTextWithEntities(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, false);
  }

  public GraphQlQueryTextWithEntities a(GraphQlQueryTextWithEntities.TextWithEntitiesField paramTextWithEntitiesField)
  {
    return a(new GraphQlQueryTextWithEntities.TextWithEntitiesField[] { paramTextWithEntitiesField });
  }

  public GraphQlQueryTextWithEntities a(String paramString)
  {
    if (this.b == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Alias already set");
      return new GraphQlQueryTextWithEntities(this.c, (String)Preconditions.checkNotNull(paramString));
    }
  }

  public GraphQlQueryTextWithEntities a(List<GraphQlQueryTextWithEntities.TextWithEntitiesField> paramList)
  {
    return new GraphQlQueryTextWithEntities(ImmutableList.e().b((Iterable)Preconditions.checkNotNull(this.c)).b(paramList).b(), this.b);
  }

  public GraphQlQueryTextWithEntities a(GraphQlQueryTextWithEntities.TextWithEntitiesField[] paramArrayOfTextWithEntitiesField)
  {
    return a(ImmutableList.a(paramArrayOfTextWithEntitiesField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryTextWithEntities
 * JD-Core Version:    0.6.2
 */