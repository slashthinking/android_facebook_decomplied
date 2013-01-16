package com.facebook.feed.data;

import com.facebook.graphql.model.GraphQLActionLink;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;

public class ActionLinkListMutator
{
  public ImmutableList<GraphQLActionLink> a(List<GraphQLActionLink> paramList, GraphQLActionLink paramGraphQLActionLink)
  {
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotNull(paramGraphQLActionLink);
    ImmutableList.Builder localBuilder = new ImmutableList.Builder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GraphQLActionLink localGraphQLActionLink = (GraphQLActionLink)localIterator.next();
      if (localGraphQLActionLink.equals(paramGraphQLActionLink))
        localGraphQLActionLink = paramGraphQLActionLink;
      localBuilder.b(localGraphQLActionLink);
    }
    return localBuilder.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.ActionLinkListMutator
 * JD-Core Version:    0.6.0
 */