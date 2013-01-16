package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;

public final class GraphQlQueryStoryAttachment extends GraphQlQueryBaseObjectImpl
{
  GraphQlQueryStoryAttachment(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, false);
  }

  public GraphQlQueryStoryAttachment a(GraphQlQueryStoryAttachment.StoryAttachmentField paramStoryAttachmentField)
  {
    return a(new GraphQlQueryStoryAttachment.StoryAttachmentField[] { paramStoryAttachmentField });
  }

  public GraphQlQueryStoryAttachment a(List<GraphQlQueryStoryAttachment.StoryAttachmentField> paramList)
  {
    return new GraphQlQueryStoryAttachment(ImmutableList.e().b((Iterable)Preconditions.checkNotNull(this.c)).b(paramList).b(), this.b);
  }

  public GraphQlQueryStoryAttachment a(GraphQlQueryStoryAttachment.StoryAttachmentField[] paramArrayOfStoryAttachmentField)
  {
    return a(ImmutableList.a(paramArrayOfStoryAttachmentField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryStoryAttachment
 * JD-Core Version:    0.6.2
 */