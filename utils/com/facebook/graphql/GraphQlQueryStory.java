package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;

public final class GraphQlQueryStory extends GraphQlQueryBaseCallable
  implements GraphQlQueryEntity, GraphQlQueryFeedUnit, GraphQlQueryNode
{
  GraphQlQueryStory(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, true);
  }

  public GraphQlQueryStory a(GraphQlQueryStory.StoryField paramStoryField)
  {
    return a(new GraphQlQueryStory.StoryField[] { paramStoryField });
  }

  public GraphQlQueryStory a(List<GraphQlQueryStory.StoryField> paramList)
  {
    ImmutableList localImmutableList = ImmutableList.e().b((Iterable)Preconditions.checkNotNull(this.c)).b((Iterable)Preconditions.checkNotNull(paramList)).b();
    return new GraphQlQueryStory(this.a, localImmutableList, this.b);
  }

  public GraphQlQueryStory a(GraphQlQueryStory.StoryField[] paramArrayOfStoryField)
  {
    return a(ImmutableList.a(paramArrayOfStoryField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryStory
 * JD-Core Version:    0.6.2
 */