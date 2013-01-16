package com.facebook.feed.data;

import com.facebook.graphql.model.Dedupable;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AppendOnlyGraphQLObjectCollection<T extends Dedupable>
{
  private final Set<String> a = Sets.a();
  private final List<T> b = Lists.a();
  private String c;
  private String d;
  private boolean e = true;
  private boolean f = true;

  public T a(int paramInt)
  {
    return (Dedupable)this.b.get(paramInt);
  }

  public String a()
  {
    return this.d;
  }

  public void a(List<T> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    if (paramList.isEmpty());
    while (true)
    {
      return;
      Iterator localIterator = paramList.iterator();
      label158: 
      while (localIterator.hasNext())
      {
        Dedupable localDedupable = (Dedupable)localIterator.next();
        String str = localDedupable.a();
        if (!this.a.contains(str))
        {
          this.b.add(localDedupable);
          this.a.add(localDedupable.a());
          continue;
        }
        for (int i = -1 + this.b.size(); ; i--)
        {
          if (i < 0)
            break label158;
          if (!str.equals(((Dedupable)this.b.get(i)).a()))
            continue;
          this.b.set(i, localDedupable);
          break;
        }
      }
      this.d = paramGraphQLPageInfo.endCursor;
      this.f = paramGraphQLPageInfo.hasNextPage;
      if (this.c != null)
        continue;
      this.c = paramGraphQLPageInfo.startCursor;
      this.e = paramGraphQLPageInfo.hasPreviousPage;
    }
  }

  public boolean b()
  {
    return this.f;
  }

  public int c()
  {
    return this.b.size();
  }

  public void d()
  {
    this.a.clear();
    this.b.clear();
    this.c = null;
    this.d = null;
    this.e = true;
    this.f = true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AppendOnlyGraphQLObjectCollection
 * JD-Core Version:    0.6.0
 */