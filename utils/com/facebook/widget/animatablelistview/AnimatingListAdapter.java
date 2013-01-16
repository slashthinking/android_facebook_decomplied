package com.facebook.widget.animatablelistview;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AnimatingListAdapter<T>
  implements ListAdapter
{
  private static final Class<?> a = AnimatingListAdapter.class;
  private final Context b;
  private final ItemBasedListAdapter<T> c;
  private final Map<T, AnimatingItemInfo<T>> d;
  private final Map<View, List<AnimatingItemView>> e;
  private DataSetObservable f;
  private AnimatingListAdapter.State g = AnimatingListAdapter.State.STEADY_STATE;
  private final List<AnimatingListTransaction<T>> h;
  private AnimatingListTransaction<T> i;
  private ImmutableList<T> j;
  private ImmutableList<T> k;
  private Set<Animator.AnimatorListener> l = Sets.a();
  private Set<ValueAnimator.AnimatorUpdateListener> m = Sets.a();
  private boolean n;
  private AnimatingListTransactionBuilder<T> o;
  private AnimatorSet p;

  public AnimatingListAdapter(Context paramContext, ItemBasedListAdapter<T> paramItemBasedListAdapter)
  {
    this.b = paramContext;
    this.c = paramItemBasedListAdapter;
    this.d = new MapMaker().f().n();
    this.e = new MapMaker().f().n();
    this.h = Lists.a();
    this.j = ImmutableList.d();
    this.k = ImmutableList.d();
    this.l.add(h());
  }

  private ObjectAnimator a(AnimatingListMutation<T> paramAnimatingListMutation)
  {
    AnimatingItemInfo localAnimatingItemInfo = f(paramAnimatingListMutation);
    ObjectAnimator localObjectAnimator = ObjectAnimator.a(localAnimatingItemInfo, "animationOffset", new float[] { 0.0F, -1.0F });
    localObjectAnimator.d(300L);
    if (paramAnimatingListMutation.e())
      a(localObjectAnimator, localAnimatingItemInfo);
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
      localObjectAnimator.a((ValueAnimator.AnimatorUpdateListener)localIterator.next());
    return localObjectAnimator;
  }

  private void a(ObjectAnimator paramObjectAnimator, AnimatingItemInfo<?> paramAnimatingItemInfo)
  {
    paramObjectAnimator.a(new AnimatingListAdapter.1(this, paramAnimatingItemInfo));
  }

  private ObjectAnimator b(AnimatingListMutation<T> paramAnimatingListMutation)
  {
    AnimatingItemInfo localAnimatingItemInfo = f(paramAnimatingListMutation);
    ObjectAnimator localObjectAnimator = ObjectAnimator.a(localAnimatingItemInfo, "animationOffset", new float[] { 0.0F, 1.0F });
    localObjectAnimator.d(300L);
    if (paramAnimatingListMutation.e())
      a(localObjectAnimator, localAnimatingItemInfo);
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
      localObjectAnimator.a((ValueAnimator.AnimatorUpdateListener)localIterator.next());
    return localObjectAnimator;
  }

  private ObjectAnimator c(AnimatingListMutation<T> paramAnimatingListMutation)
  {
    AnimatingItemInfo localAnimatingItemInfo = f(paramAnimatingListMutation);
    ObjectAnimator localObjectAnimator = ObjectAnimator.a(localAnimatingItemInfo, "animationOffset", new float[] { 1.0F, 0.0F });
    localObjectAnimator.d(300L);
    if (paramAnimatingListMutation.e())
      a(localObjectAnimator, localAnimatingItemInfo);
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
      localObjectAnimator.a((ValueAnimator.AnimatorUpdateListener)localIterator.next());
    return localObjectAnimator;
  }

  private ObjectAnimator d(AnimatingListMutation<T> paramAnimatingListMutation)
  {
    AnimatingItemInfo localAnimatingItemInfo = f(paramAnimatingListMutation);
    ObjectAnimator localObjectAnimator = ObjectAnimator.a(localAnimatingItemInfo, "animationOffset", new float[] { -1.0F, 0.0F });
    localObjectAnimator.d(300L);
    if (paramAnimatingListMutation.e())
      a(localObjectAnimator, localAnimatingItemInfo);
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
      localObjectAnimator.a((ValueAnimator.AnimatorUpdateListener)localIterator.next());
    return localObjectAnimator;
  }

  private Animator e(AnimatingListMutation<T> paramAnimatingListMutation)
  {
    AnimatingItemInfo localAnimatingItemInfo = f(paramAnimatingListMutation);
    Animator localAnimator1 = paramAnimatingListMutation.d();
    localAnimator1.a(localAnimatingItemInfo);
    if ((localAnimator1 instanceof AnimatorSet))
    {
      Iterator localIterator2 = ((AnimatorSet)localAnimator1).a().iterator();
      while (localIterator2.hasNext())
      {
        Animator localAnimator2 = (Animator)localIterator2.next();
        if ((localAnimator2 instanceof ObjectAnimator))
        {
          ObjectAnimator localObjectAnimator2 = (ObjectAnimator)localAnimator2;
          Iterator localIterator3 = this.m.iterator();
          while (localIterator3.hasNext())
            localObjectAnimator2.a((ValueAnimator.AnimatorUpdateListener)localIterator3.next());
        }
      }
    }
    if ((localAnimator1 instanceof ObjectAnimator))
    {
      ObjectAnimator localObjectAnimator1 = (ObjectAnimator)localAnimator1;
      Iterator localIterator1 = this.m.iterator();
      while (localIterator1.hasNext())
        localObjectAnimator1.a((ValueAnimator.AnimatorUpdateListener)localIterator1.next());
    }
    BLog.e(a, "Unsupported animation: " + localAnimator1);
    localAnimator1 = null;
    return localAnimator1;
  }

  private void e()
  {
    int i1 = 0;
    if (this.g != AnimatingListAdapter.State.STEADY_STATE);
    while (true)
    {
      return;
      if (!this.h.isEmpty())
      {
        this.i = ((AnimatingListTransaction)this.h.remove(0));
        this.j = this.i.b();
        g();
        i();
        ArrayList localArrayList = Lists.a();
        Iterator localIterator1 = this.i.a().iterator();
        while (localIterator1.hasNext())
        {
          AnimatingListMutation localAnimatingListMutation = (AnimatingListMutation)localIterator1.next();
          AnimatingListMutation.MutationType localMutationType = localAnimatingListMutation.a();
          if ((localMutationType == AnimatingListMutation.MutationType.ADD_WITH_ANIMATION_UP) || (localMutationType == AnimatingListMutation.MutationType.ADD_WITH_ANIMATION_DOWN) || (localMutationType == AnimatingListMutation.MutationType.REMOVE_WITH_ANIMATION_DOWN) || (localMutationType == AnimatingListMutation.MutationType.REMOVE_WITH_ANIMATION_UP) || (localMutationType == AnimatingListMutation.MutationType.CUSTOM))
            i1 = 1;
          if (!this.n)
            if (localMutationType == AnimatingListMutation.MutationType.ADD_WITH_ANIMATION_UP)
              localArrayList.add(b(localAnimatingListMutation));
            else if (localMutationType == AnimatingListMutation.MutationType.ADD_WITH_ANIMATION_DOWN)
              localArrayList.add(a(localAnimatingListMutation));
            else if (localMutationType == AnimatingListMutation.MutationType.REMOVE_WITH_ANIMATION_DOWN)
              localArrayList.add(c(localAnimatingListMutation));
            else if (localMutationType == AnimatingListMutation.MutationType.REMOVE_WITH_ANIMATION_UP)
              localArrayList.add(d(localAnimatingListMutation));
            else if (localMutationType == AnimatingListMutation.MutationType.CUSTOM)
              localArrayList.add(e(localAnimatingListMutation));
        }
        if (i1 == 0)
        {
          this.i = null;
          this.g = AnimatingListAdapter.State.STEADY_STATE;
          e();
        }
        else if (this.n)
        {
          this.g = AnimatingListAdapter.State.WAITING_FOR_ANIMATION_TO_FINISH;
        }
        else
        {
          this.p = new AnimatorSet();
          Iterator localIterator2 = this.l.iterator();
          while (localIterator2.hasNext())
          {
            Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator2.next();
            this.p.a(localAnimatorListener);
          }
          this.p.a(localArrayList);
          this.p.c();
          this.g = AnimatingListAdapter.State.WAITING_FOR_ANIMATION_TO_FINISH;
        }
      }
    }
  }

  private AnimatingItemInfo<?> f(AnimatingListMutation<T> paramAnimatingListMutation)
  {
    Object localObject = paramAnimatingListMutation.b();
    AnimatingItemInfo localAnimatingItemInfo = (AnimatingItemInfo)this.d.get(localObject);
    if (paramAnimatingListMutation.c() != -1)
      localAnimatingItemInfo = localAnimatingItemInfo.a(paramAnimatingListMutation.c());
    return localAnimatingItemInfo;
  }

  private void f()
  {
    this.j = this.i.c();
    g();
    i();
    this.i = null;
    this.p = null;
    this.g = AnimatingListAdapter.State.STEADY_STATE;
    e();
  }

  private void g()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((AnimatingItemInfo)this.d.get(localObject) == null)
      {
        AnimatingItemInfo localAnimatingItemInfo = new AnimatingItemInfo(localObject);
        this.d.put(localObject, localAnimatingItemInfo);
      }
    }
  }

  private Animator.AnimatorListener h()
  {
    return new AnimatingListAdapter.2(this);
  }

  private void i()
  {
    try
    {
      if (this.f != null)
        this.f.notifyChanged();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void j()
  {
    try
    {
      if (this.f != null)
        this.f.notifyInvalidated();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public AnimatingListTransactionBuilder<T> a()
  {
    if (this.o == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Already a pending transaction");
      this.o = new AnimatingListTransactionBuilder(this);
      return this.o;
    }
  }

  void a(AnimatingListTransactionBuilder<?> paramAnimatingListTransactionBuilder, ImmutableList<T> paramImmutableList1, ImmutableList<T> paramImmutableList2, ImmutableList<AnimatingListMutation<T>> paramImmutableList)
  {
    if (this.o == paramAnimatingListTransactionBuilder);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Wrong transaction");
      AnimatingListTransaction localAnimatingListTransaction = new AnimatingListTransaction(paramImmutableList, paramImmutableList1, paramImmutableList2);
      this.h.add(localAnimatingListTransaction);
      this.k = paramImmutableList2;
      this.o = null;
      e();
      return;
    }
  }

  public void a(Animator paramAnimator)
  {
    if ((paramAnimator == this.p) && (this.g == AnimatingListAdapter.State.WAITING_FOR_ANIMATION_TO_FINISH))
      f();
  }

  void a(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.m.add(paramAnimatorUpdateListener);
  }

  public boolean areAllItemsEnabled()
  {
    return this.c.b();
  }

  public void b()
  {
    this.j = ImmutableList.d();
    this.k = ImmutableList.d();
    this.h.clear();
    this.p = null;
    this.o = null;
    this.i = null;
    this.g = AnimatingListAdapter.State.STEADY_STATE;
    j();
  }

  public void b(Animator paramAnimator)
  {
    if ((paramAnimator == this.p) && (this.g == AnimatingListAdapter.State.WAITING_FOR_ANIMATION_TO_FINISH))
      f();
  }

  public ImmutableList<T> c()
  {
    return this.j;
  }

  public ImmutableList<T> d()
  {
    return this.k;
  }

  public int getCount()
  {
    return this.j.size();
  }

  public T getItem(int paramInt)
  {
    if (paramInt >= this.j.size());
    for (Object localObject = null; ; localObject = this.j.get(paramInt))
      return localObject;
  }

  public long getItemId(int paramInt)
  {
    return this.c.b(getItem(paramInt));
  }

  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject == null);
    for (int i1 = -1; ; i1 = this.c.c(localObject))
      return i1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AnimatingItemView localAnimatingItemView1 = (AnimatingItemView)paramView;
    Object localObject1 = getItem(paramInt);
    if (localAnimatingItemView1 == null)
    {
      localAnimatingItemView1 = new AnimatingItemView(this.b);
      localAnimatingItemView1.addView(this.c.a(localObject1, null, localAnimatingItemView1));
    }
    AnimatingItemInfo localAnimatingItemInfo;
    List localList;
    while (true)
    {
      localAnimatingItemInfo = (AnimatingItemInfo)this.d.get(localObject1);
      localAnimatingItemView1.setItemInfo(localAnimatingItemInfo);
      localList = (List)this.e.get(localAnimatingItemView1);
      if (localList == null)
        break;
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
        ((AnimatingItemView)localIterator2.next()).setItemInfo(null);
      View localView2 = localAnimatingItemView1.getChildAt(0);
      View localView3 = this.c.a(localObject1, localView2, localAnimatingItemView1);
      if (localView3 != localView2)
      {
        localAnimatingItemView1.removeAllViews();
        localAnimatingItemView1.addView(localView3);
      }
    }
    Iterator localIterator1 = localAnimatingItemInfo.e().entrySet().iterator();
    Object localObject2 = localList;
    Object localObject3;
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      View localView1 = localAnimatingItemView1.findViewById(((Integer)localEntry.getKey()).intValue());
      if (!(localView1 instanceof AnimatingItemView))
        break label322;
      AnimatingItemView localAnimatingItemView2 = (AnimatingItemView)localView1;
      localAnimatingItemView2.setItemInfo((AnimatingItemInfo)localEntry.getValue());
      if (localObject2 != null)
        break label315;
      localObject3 = Lists.c(1);
      this.e.put(localAnimatingItemView1, localObject3);
      label295: ((List)localObject3).add(localAnimatingItemView2);
    }
    while (true)
    {
      localObject2 = localObject3;
      break;
      return localAnimatingItemView1;
      label315: localObject3 = localObject2;
      break label295;
      label322: localObject3 = localObject2;
    }
  }

  public int getViewTypeCount()
  {
    return this.c.a();
  }

  public boolean hasStableIds()
  {
    return true;
  }

  public boolean isEmpty()
  {
    if (getCount() == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isEnabled(int paramInt)
  {
    return this.c.a(getItem(paramInt));
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    try
    {
      if (this.f == null)
        this.f = new DataSetObservable();
      this.f.registerObserver(paramDataSetObserver);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    try
    {
      if (this.f != null)
        this.f.unregisterObserver(paramDataSetObserver);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.AnimatingListAdapter
 * JD-Core Version:    0.6.2
 */