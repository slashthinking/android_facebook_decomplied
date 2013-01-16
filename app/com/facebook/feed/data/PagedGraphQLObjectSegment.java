package com.facebook.feed.data;

import com.facebook.common.collect.MapWithSecondaryOrdering;
import com.facebook.graphql.model.Dedupable;
import com.facebook.graphql.model.GraphQLPageInfo;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PagedGraphQLObjectSegment<T extends Dedupable>
{
  private MapWithSecondaryOrdering<String, T> a;
  private String b;
  private String c;
  private boolean d = false;
  private boolean e = false;
  private Comparator<T> f;

  public PagedGraphQLObjectSegment(Comparator<T> paramComparator)
  {
    this.f = paramComparator;
    this.a = new MapWithSecondaryOrdering(paramComparator);
  }

  private void b(List<? extends T> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Dedupable localDedupable1 = (Dedupable)localIterator.next();
      Dedupable localDedupable2 = (Dedupable)this.a.get(localDedupable1.a());
      if ((localDedupable2 != null) && (this.f.compare(localDedupable1, localDedupable2) >= 0))
        continue;
      this.a.put(localDedupable1.a(), localDedupable1);
    }
  }

  public int a(List<T> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Dedupable localDedupable = (Dedupable)localIterator.next();
      if (this.a.containsKey(localDedupable.a()))
        break label59;
    }
    label59: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  public T a(int paramInt)
  {
    return (Dedupable)this.a.a().get(paramInt);
  }

  public T a(String paramString)
  {
    return (Dedupable)this.a.get(paramString);
  }

  public String a()
  {
    return this.b;
  }

  public void a(List<? extends T> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    if (paramList.isEmpty());
    while (true)
    {
      return;
      b(paramList);
      this.b = paramGraphQLPageInfo.startCursor;
      this.d = paramGraphQLPageInfo.hasPreviousPage;
      if (this.c != null)
        continue;
      this.c = paramGraphQLPageInfo.endCursor;
      this.e = paramGraphQLPageInfo.hasNextPage;
    }
  }

  public boolean a(Dedupable paramDedupable)
  {
    if (!this.a.containsKey(paramDedupable.a()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public String b()
  {
    return this.c;
  }

  public void b(T paramT)
  {
    this.a.put(paramT.a(), paramT);
  }

  public void b(List<? extends T> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    if (paramList.isEmpty());
    while (true)
    {
      return;
      b(paramList);
      this.c = paramGraphQLPageInfo.endCursor;
      this.e = paramGraphQLPageInfo.hasNextPage;
      if (this.b != null)
        continue;
      this.b = paramGraphQLPageInfo.startCursor;
      this.d = paramGraphQLPageInfo.hasPreviousPage;
    }
  }

  public boolean c()
  {
    return this.e;
  }

  public int d()
  {
    return this.a.size();
  }

  public boolean e()
  {
    if (d() == 0);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.PagedGraphQLObjectSegment
 * JD-Core Version:    0.6.0
 */