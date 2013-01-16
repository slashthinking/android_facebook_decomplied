package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;

public final class GraphQlQueryFeedback extends GraphQlQueryBaseObjectImpl
  implements GraphQlQueryNode
{
  GraphQlQueryFeedback(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, true);
  }

  public GraphQlQueryFeedback a(GraphQlQueryFeedback.FeedbackField paramFeedbackField)
  {
    return a(new GraphQlQueryFeedback.FeedbackField[] { paramFeedbackField });
  }

  public GraphQlQueryFeedback a(List<GraphQlQueryFeedback.FeedbackField> paramList)
  {
    return new GraphQlQueryFeedback(ImmutableList.e().b((Iterable)Preconditions.checkNotNull(this.c)).b(paramList).b(), this.b);
  }

  public GraphQlQueryFeedback a(GraphQlQueryFeedback.FeedbackField[] paramArrayOfFeedbackField)
  {
    return a(ImmutableList.a(paramArrayOfFeedbackField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryFeedback
 * JD-Core Version:    0.6.2
 */