package com.facebook.widget.animatablelistview;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AnimatingItemInfo<T>
{
  private final T a;
  private final Set<AnimatingItemInfo.AnimationListener> b = Sets.a();
  private float c = 1.0F;
  private float d = 1.0F;
  private float e = 1.0F;
  private int f = 0;
  private Map<Integer, AnimatingItemInfo<T>> g;

  public AnimatingItemInfo(T paramT)
  {
    this.a = paramT;
  }

  private void f()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((AnimatingItemInfo.AnimationListener)localIterator.next()).a();
  }

  public float a()
  {
    return this.c;
  }

  public AnimatingItemInfo<T> a(int paramInt)
  {
    if (this.g == null)
      this.g = Maps.a(2);
    AnimatingItemInfo localAnimatingItemInfo = (AnimatingItemInfo)this.g.get(Integer.valueOf(paramInt));
    if (localAnimatingItemInfo == null)
    {
      localAnimatingItemInfo = new AnimatingItemInfo(this.a);
      this.g.put(Integer.valueOf(paramInt), localAnimatingItemInfo);
    }
    return localAnimatingItemInfo;
  }

  public void a(AnimatingItemInfo.AnimationListener paramAnimationListener)
  {
    this.b.add(paramAnimationListener);
  }

  public float b()
  {
    return this.d;
  }

  public void b(AnimatingItemInfo.AnimationListener paramAnimationListener)
  {
    this.b.remove(paramAnimationListener);
  }

  public float c()
  {
    return this.e;
  }

  public int d()
  {
    return this.f;
  }

  public Map<Integer, AnimatingItemInfo<T>> e()
  {
    if (this.g != null);
    for (Map localMap = Collections.unmodifiableMap(this.g); ; localMap = Collections.emptyMap())
      return localMap;
  }

  public void setAnimationOffset(float paramFloat)
  {
    if ((paramFloat >= -1.0F) && (paramFloat <= 1.0F));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.c = paramFloat;
      f();
      return;
    }
  }

  public void setScaleX(float paramFloat)
  {
    this.d = paramFloat;
    f();
  }

  public void setScaleY(float paramFloat)
  {
    this.e = paramFloat;
    f();
  }

  public void setVisibility(int paramInt)
  {
    this.f = paramInt;
    f();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.AnimatingItemInfo
 * JD-Core Version:    0.6.2
 */