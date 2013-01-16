package com.facebook.widget.animatablelistview;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnimatingListTransactionBuilder<T>
{
  private final AnimatingListAdapter<T> a;
  private final ImmutableList<T> b;
  private final List<T> c;
  private final List<AnimatingListMutation<T>> d = Lists.a();
  private final Set<T> e;
  private final Map<T, T> f;

  public AnimatingListTransactionBuilder(AnimatingListAdapter<T> paramAnimatingListAdapter)
  {
    this.a = paramAnimatingListAdapter;
    this.b = ImmutableList.a(paramAnimatingListAdapter.d());
    this.c = new ArrayList(this.b);
    this.e = Sets.a();
    this.f = Maps.a();
  }

  private ImmutableList<T> a(List<T> paramList)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!this.e.contains(localObject))
        if (this.f.containsKey(localObject))
          localBuilder.b(this.f.get(localObject));
        else
          localBuilder.b(localObject);
    }
    return localBuilder.b();
  }

  public int a()
  {
    return this.c.size();
  }

  public void a(int paramInt)
  {
    Object localObject = this.c.get(paramInt);
    this.c.remove(paramInt);
    this.d.add(new AnimatingListMutation(localObject, AnimatingListMutation.MutationType.REMOVE));
  }

  public void a(int paramInt1, int paramInt2, AnimationType paramAnimationType)
  {
    Object localObject = this.c.get(paramInt1);
    this.d.add(new AnimatingListMutation(localObject, paramAnimationType.toMutationType(), paramInt2));
  }

  public void a(int paramInt, T paramT)
  {
    this.d.add(new AnimatingListMutation(paramT, AnimatingListMutation.MutationType.ADD));
    this.c.add(paramInt, paramT);
  }

  public void a(int paramInt, T paramT, boolean paramBoolean)
  {
    this.d.add(new AnimatingListMutation(paramT, AnimatingListMutation.MutationType.ADD_WITH_ANIMATION_UP, paramBoolean));
    this.c.add(paramInt, paramT);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.c.get(paramInt);
    this.d.add(new AnimatingListMutation(localObject, AnimatingListMutation.MutationType.REMOVE_WITH_ANIMATION_DOWN, paramBoolean));
    this.e.add(localObject);
  }

  public void a(T paramT)
  {
    a(paramT, false);
  }

  public void a(T paramT, boolean paramBoolean)
  {
    this.d.add(new AnimatingListMutation(paramT, AnimatingListMutation.MutationType.ADD_WITH_ANIMATION_UP, paramBoolean));
    this.c.add(paramT);
  }

  public void a(Collection<? extends T> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      this.d.add(new AnimatingListMutation(localObject, AnimatingListMutation.MutationType.ADD));
    }
    this.c.addAll(paramCollection);
  }

  public void b()
  {
    ImmutableList localImmutableList1 = ImmutableList.a(this.c);
    ImmutableList localImmutableList2 = a(localImmutableList1);
    ImmutableList localImmutableList3 = ImmutableList.a(this.d);
    this.a.a(this, localImmutableList1, localImmutableList2, localImmutableList3);
  }

  public void b(int paramInt)
  {
    a(paramInt, false);
  }

  public void b(int paramInt, T paramT)
  {
    a(paramInt, paramT, false);
  }

  public void b(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.c.get(paramInt);
    this.d.add(new AnimatingListMutation(localObject, AnimatingListMutation.MutationType.REMOVE_WITH_ANIMATION_UP, paramBoolean));
    this.e.add(localObject);
  }

  public void c(int paramInt)
  {
    b(paramInt, false);
  }

  public void c(int paramInt, T paramT)
  {
    this.c.set(paramInt, paramT);
    this.d.add(new AnimatingListMutation(paramT, AnimatingListMutation.MutationType.REPLACE));
  }

  public void d(int paramInt, T paramT)
  {
    Object localObject = this.c.get(paramInt);
    this.d.add(new AnimatingListMutation(paramT, AnimatingListMutation.MutationType.MARKED_FOR_REPLACE));
    this.f.put(localObject, paramT);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.AnimatingListTransactionBuilder
 * JD-Core Version:    0.6.2
 */