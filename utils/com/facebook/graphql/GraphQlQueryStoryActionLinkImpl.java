package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;

public final class GraphQlQueryStoryActionLinkImpl extends GraphQlQueryBaseObjectImpl
  implements GraphQlQueryStoryActionLink
{
  GraphQlQueryStoryActionLinkImpl(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, true);
  }

  public GraphQlQueryStoryActionLinkImpl a(GraphQlQueryFieldStoryActionLink paramGraphQlQueryFieldStoryActionLink)
  {
    return a(new GraphQlQueryFieldStoryActionLink[] { paramGraphQlQueryFieldStoryActionLink });
  }

  public GraphQlQueryStoryActionLinkImpl a(List<GraphQlQueryFieldStoryActionLink> paramList)
  {
    return new GraphQlQueryStoryActionLinkImpl(ImmutableList.e().b((Iterable)Preconditions.checkNotNull(this.c)).b(paramList).b(), this.b);
  }

  public GraphQlQueryStoryActionLinkImpl a(GraphQlQueryFieldStoryActionLink[] paramArrayOfGraphQlQueryFieldStoryActionLink)
  {
    return a(ImmutableList.a(paramArrayOfGraphQlQueryFieldStoryActionLink));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryStoryActionLinkImpl
 * JD-Core Version:    0.6.2
 */