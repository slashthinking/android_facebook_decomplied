package com.facebook.feed.data;

import com.facebook.graphql.model.Dedupable;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.List;

public class PagedGraphQLObjectCollection<T extends Dedupable>
{
  private final Comparator<T> a;
  private List<PagedGraphQLObjectSegment<T>> b = Lists.a();
  private T c;

  public PagedGraphQLObjectCollection(Comparator<T> paramComparator, T paramT)
  {
    this.a = paramComparator;
    this.c = paramT;
    b();
    j();
  }

  private void b()
  {
    this.b.add(0, new PagedGraphQLObjectSegment(this.a));
  }

  private void j()
  {
    if (this.b.size() > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }

  public int a()
  {
    int i = 0;
    int j = 0;
    while (i < this.b.size())
    {
      j += ((PagedGraphQLObjectSegment)this.b.get(i)).d();
      i++;
    }
    return -1 + (j + this.b.size());
  }

  public int a(List<? extends T> paramList)
  {
    return ((PagedGraphQLObjectSegment)this.b.get(0)).a(paramList);
  }

  public void a(List<? extends T> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    if (paramList.isEmpty());
    while (true)
    {
      return;
      if ((paramGraphQLPageInfo.hasNextPage) && (!((PagedGraphQLObjectSegment)this.b.get(0)).e()))
      {
        h();
        b();
      }
      ((PagedGraphQLObjectSegment)this.b.get(0)).a(paramList, paramGraphQLPageInfo);
    }
  }

  public boolean a(Dedupable paramDedupable)
  {
    return ((PagedGraphQLObjectSegment)this.b.get(0)).a(paramDedupable);
  }

  public T b(int paramInt)
  {
    int i = 0;
    if (i < this.b.size())
    {
      int j;
      if (paramInt >= ((PagedGraphQLObjectSegment)this.b.get(i)).d())
      {
        j = paramInt - ((PagedGraphQLObjectSegment)this.b.get(i)).d();
        if (j != 0);
      }
      for (Dedupable localDedupable = this.c; ; localDedupable = ((PagedGraphQLObjectSegment)this.b.get(i)).a(paramInt))
      {
        return localDedupable;
        paramInt = j - 1;
        i++;
        break;
      }
    }
    throw new IllegalStateException("An invalid index was accessed from PageGraphQLObjectCollection");
  }

  public void b(T paramT)
  {
    ((PagedGraphQLObjectSegment)this.b.get(0)).b(paramT);
  }

  public void b(List<? extends T> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    if (paramList.isEmpty());
    while (true)
    {
      return;
      ((PagedGraphQLObjectSegment)this.b.get(-1 + this.b.size())).b(paramList, paramGraphQLPageInfo);
    }
  }

  public T c(String paramString)
  {
    return ((PagedGraphQLObjectSegment)this.b.get(0)).a(paramString);
  }

  public String c()
  {
    return ((PagedGraphQLObjectSegment)this.b.get(0)).a();
  }

  public String d()
  {
    return ((PagedGraphQLObjectSegment)this.b.get(-1 + this.b.size())).b();
  }

  public boolean e()
  {
    return ((PagedGraphQLObjectSegment)this.b.get(-1 + this.b.size())).c();
  }

  public void f()
  {
    this.b.clear();
    b();
    j();
  }

  public boolean g()
  {
    if (a() == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void h()
  {
    if (this.b.size() <= 1);
    while (true)
    {
      return;
      this.b.subList(1, this.b.size()).clear();
      j();
    }
  }

  public int i()
  {
    if (this.b.size() > 1);
    for (int i = ((PagedGraphQLObjectSegment)this.b.get(0)).d(); ; i = -1)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.PagedGraphQLObjectCollection
 * JD-Core Version:    0.6.0
 */