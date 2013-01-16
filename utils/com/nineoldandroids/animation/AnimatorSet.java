package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class AnimatorSet extends Animator
{
  boolean b = false;
  private ArrayList<Animator> c = new ArrayList();
  private HashMap<Animator, AnimatorSet.Node> d = new HashMap();
  private ArrayList<AnimatorSet.Node> e = new ArrayList();
  private ArrayList<AnimatorSet.Node> f = new ArrayList();
  private boolean g = true;
  private AnimatorSet.AnimatorSetListener h = null;
  private boolean i = false;
  private long j = 0L;
  private ValueAnimator k = null;
  private long l = -1L;

  private void h()
  {
    if (this.g)
    {
      this.f.clear();
      ArrayList localArrayList1 = new ArrayList();
      int i3 = this.e.size();
      for (int i4 = 0; i4 < i3; i4++)
      {
        AnimatorSet.Node localNode4 = (AnimatorSet.Node)this.e.get(i4);
        if ((localNode4.b == null) || (localNode4.b.size() == 0))
          localArrayList1.add(localNode4);
      }
      ArrayList localArrayList2 = new ArrayList();
      while (localArrayList1.size() > 0)
      {
        int i5 = localArrayList1.size();
        for (int i6 = 0; i6 < i5; i6++)
        {
          AnimatorSet.Node localNode2 = (AnimatorSet.Node)localArrayList1.get(i6);
          this.f.add(localNode2);
          if (localNode2.e != null)
          {
            int i7 = localNode2.e.size();
            for (int i8 = 0; i8 < i7; i8++)
            {
              AnimatorSet.Node localNode3 = (AnimatorSet.Node)localNode2.e.get(i8);
              localNode3.d.remove(localNode2);
              if (localNode3.d.size() == 0)
                localArrayList2.add(localNode3);
            }
          }
        }
        localArrayList1.clear();
        localArrayList1.addAll(localArrayList2);
        localArrayList2.clear();
      }
      this.g = false;
      if (this.f.size() != this.e.size())
        throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
    }
    else
    {
      int m = this.e.size();
      for (int n = 0; n < m; n++)
      {
        AnimatorSet.Node localNode1 = (AnimatorSet.Node)this.e.get(n);
        if ((localNode1.b != null) && (localNode1.b.size() > 0))
        {
          int i1 = localNode1.b.size();
          for (int i2 = 0; i2 < i1; i2++)
          {
            AnimatorSet.Dependency localDependency = (AnimatorSet.Dependency)localNode1.b.get(i2);
            if (localNode1.d == null)
              localNode1.d = new ArrayList();
            if (!localNode1.d.contains(localDependency.a))
              localNode1.d.add(localDependency.a);
          }
        }
        localNode1.f = false;
      }
    }
  }

  public AnimatorSet.Builder a(Animator paramAnimator)
  {
    if (paramAnimator != null)
      this.g = true;
    for (AnimatorSet.Builder localBuilder = new AnimatorSet.Builder(this, paramAnimator); ; localBuilder = null)
      return localBuilder;
  }

  public AnimatorSet a(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("duration must be a value of zero or greater");
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((AnimatorSet.Node)localIterator.next()).a.c(paramLong);
    this.l = paramLong;
    return this;
  }

  public ArrayList<Animator> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((AnimatorSet.Node)localIterator.next()).a);
    return localArrayList;
  }

  public void a(Interpolator paramInterpolator)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((AnimatorSet.Node)localIterator.next()).a.a(paramInterpolator);
  }

  public void a(Object paramObject)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((AnimatorSet.Node)localIterator.next()).a.a(paramObject);
  }

  public void a(Collection<Animator> paramCollection)
  {
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      this.g = true;
      Object localObject1 = null;
      Iterator localIterator = paramCollection.iterator();
      if (localIterator.hasNext())
      {
        Animator localAnimator = (Animator)localIterator.next();
        if (localObject1 == null);
        for (Object localObject2 = a(localAnimator); ; localObject2 = localObject1)
        {
          localObject1 = localObject2;
          break;
          localObject1.a(localAnimator);
        }
      }
    }
  }

  public void a(Animator[] paramArrayOfAnimator)
  {
    int m = 1;
    if (paramArrayOfAnimator != null)
    {
      this.g = m;
      AnimatorSet.Builder localBuilder = a(paramArrayOfAnimator[0]);
      while (m < paramArrayOfAnimator.length)
      {
        localBuilder.a(paramArrayOfAnimator[m]);
        m++;
      }
    }
  }

  public AnimatorSet b()
  {
    AnimatorSet localAnimatorSet = (AnimatorSet)super.j();
    localAnimatorSet.g = true;
    localAnimatorSet.b = false;
    localAnimatorSet.i = false;
    localAnimatorSet.c = new ArrayList();
    localAnimatorSet.d = new HashMap();
    localAnimatorSet.e = new ArrayList();
    localAnimatorSet.f = new ArrayList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.e.iterator();
    while (localIterator1.hasNext())
    {
      AnimatorSet.Node localNode3 = (AnimatorSet.Node)localIterator1.next();
      AnimatorSet.Node localNode4 = localNode3.a();
      localHashMap.put(localNode3, localNode4);
      localAnimatorSet.e.add(localNode4);
      localAnimatorSet.d.put(localNode4.a, localNode4);
      localNode4.b = null;
      localNode4.c = null;
      localNode4.e = null;
      localNode4.d = null;
      ArrayList localArrayList1 = localNode4.a.k();
      if (localArrayList1 != null)
      {
        Iterator localIterator4 = localArrayList1.iterator();
        ArrayList localArrayList2 = null;
        while (localIterator4.hasNext())
        {
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator4.next();
          if ((localAnimatorListener instanceof AnimatorSet.AnimatorSetListener))
          {
            if (localArrayList2 == null)
              localArrayList2 = new ArrayList();
            localArrayList2.add(localAnimatorListener);
          }
        }
        if (localArrayList2 != null)
        {
          Iterator localIterator5 = localArrayList2.iterator();
          while (localIterator5.hasNext())
            localArrayList1.remove((Animator.AnimatorListener)localIterator5.next());
        }
      }
    }
    Iterator localIterator2 = this.e.iterator();
    while (localIterator2.hasNext())
    {
      AnimatorSet.Node localNode1 = (AnimatorSet.Node)localIterator2.next();
      AnimatorSet.Node localNode2 = (AnimatorSet.Node)localHashMap.get(localNode1);
      if (localNode1.b != null)
      {
        Iterator localIterator3 = localNode1.b.iterator();
        while (localIterator3.hasNext())
        {
          AnimatorSet.Dependency localDependency = (AnimatorSet.Dependency)localIterator3.next();
          localNode2.a(new AnimatorSet.Dependency((AnimatorSet.Node)localHashMap.get(localDependency.a), localDependency.b));
        }
      }
    }
    return localAnimatorSet;
  }

  public void c()
  {
    int m = 0;
    this.b = false;
    this.i = true;
    h();
    int n = this.f.size();
    for (int i1 = 0; i1 < n; i1++)
    {
      AnimatorSet.Node localNode3 = (AnimatorSet.Node)this.f.get(i1);
      ArrayList localArrayList4 = localNode3.a.k();
      if ((localArrayList4 != null) && (localArrayList4.size() > 0))
      {
        Iterator localIterator2 = new ArrayList(localArrayList4).iterator();
        while (localIterator2.hasNext())
        {
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator2.next();
          if (((localAnimatorListener instanceof AnimatorSet.DependencyListener)) || ((localAnimatorListener instanceof AnimatorSet.AnimatorSetListener)))
            localNode3.a.b(localAnimatorListener);
        }
      }
    }
    ArrayList localArrayList1 = new ArrayList();
    int i2 = 0;
    if (i2 < n)
    {
      AnimatorSet.Node localNode2 = (AnimatorSet.Node)this.f.get(i2);
      if (this.h == null)
        this.h = new AnimatorSet.AnimatorSetListener(this, this);
      if ((localNode2.b == null) || (localNode2.b.size() == 0))
        localArrayList1.add(localNode2);
      while (true)
      {
        localNode2.a.a(this.h);
        i2++;
        break;
        int i6 = localNode2.b.size();
        for (int i7 = 0; i7 < i6; i7++)
        {
          AnimatorSet.Dependency localDependency = (AnimatorSet.Dependency)localNode2.b.get(i7);
          localDependency.a.a.a(new AnimatorSet.DependencyListener(this, localNode2, localDependency.b));
        }
        localNode2.c = ((ArrayList)localNode2.b.clone());
      }
    }
    if (this.j <= 0L)
    {
      Iterator localIterator1 = localArrayList1.iterator();
      while (localIterator1.hasNext())
      {
        AnimatorSet.Node localNode1 = (AnimatorSet.Node)localIterator1.next();
        localNode1.a.c();
        this.c.add(localNode1.a);
      }
    }
    this.k = ValueAnimator.b(new float[] { 0.0F, 1.0F });
    this.k.b(this.j);
    this.k.a(new AnimatorSet.1(this, localArrayList1));
    this.k.c();
    if (this.a != null)
    {
      ArrayList localArrayList3 = (ArrayList)this.a.clone();
      int i4 = localArrayList3.size();
      for (int i5 = 0; i5 < i4; i5++)
        ((Animator.AnimatorListener)localArrayList3.get(i5)).b(this);
    }
    if ((this.e.size() == 0) && (this.j == 0L))
    {
      this.i = false;
      if (this.a != null)
      {
        ArrayList localArrayList2 = (ArrayList)this.a.clone();
        int i3 = localArrayList2.size();
        while (m < i3)
        {
          ((Animator.AnimatorListener)localArrayList2.get(m)).a(this);
          m++;
        }
      }
    }
  }

  public void d()
  {
    this.b = true;
    ArrayList localArrayList2;
    if (g())
    {
      if (this.a == null)
        break label181;
      localArrayList2 = (ArrayList)this.a.clone();
      Iterator localIterator3 = localArrayList2.iterator();
      while (localIterator3.hasNext())
        ((Animator.AnimatorListener)localIterator3.next()).c(this);
    }
    label181: for (ArrayList localArrayList1 = localArrayList2; ; localArrayList1 = null)
    {
      if ((this.k != null) && (this.k.f()))
        this.k.d();
      while (localArrayList1 != null)
      {
        Iterator localIterator2 = localArrayList1.iterator();
        while (localIterator2.hasNext())
          ((Animator.AnimatorListener)localIterator2.next()).a(this);
        if (this.f.size() > 0)
        {
          Iterator localIterator1 = this.f.iterator();
          while (localIterator1.hasNext())
            ((AnimatorSet.Node)localIterator1.next()).a.d();
        }
      }
      this.i = false;
      return;
    }
  }

  public void e()
  {
    this.b = true;
    if (g())
    {
      if (this.f.size() != this.e.size())
      {
        h();
        Iterator localIterator3 = this.f.iterator();
        while (localIterator3.hasNext())
        {
          AnimatorSet.Node localNode = (AnimatorSet.Node)localIterator3.next();
          if (this.h == null)
            this.h = new AnimatorSet.AnimatorSetListener(this, this);
          localNode.a.a(this.h);
        }
      }
      if (this.k != null)
        this.k.d();
      if (this.f.size() > 0)
      {
        Iterator localIterator2 = this.f.iterator();
        while (localIterator2.hasNext())
          ((AnimatorSet.Node)localIterator2.next()).a.e();
      }
      if (this.a != null)
      {
        Iterator localIterator1 = ((ArrayList)this.a.clone()).iterator();
        while (localIterator1.hasNext())
          ((Animator.AnimatorListener)localIterator1.next()).a(this);
      }
      this.i = false;
    }
  }

  public boolean f()
  {
    Iterator localIterator = this.e.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((AnimatorSet.Node)localIterator.next()).a.f());
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean g()
  {
    return this.i;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet
 * JD-Core Version:    0.6.2
 */