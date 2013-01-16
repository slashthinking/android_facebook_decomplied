package com.facebook.feed.renderer.recycle;

import android.app.Activity;
import android.view.View;
import com.facebook.android.os.DeferredHandler;
import com.facebook.widget.FbCustomViewGroup;
import com.facebook.widget.listview.recycle.RecyclableView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FeedRecyclableViewPoolManager
{
  private static int a = 33;
  private final DeferredHandler b;
  private final Map<Class<?>, FeedRecyclableViewPoolManager.ViewPoolConfig> c;
  private final ArrayListMultimap<Class<?>, View> d = ArrayListMultimap.l();

  public FeedRecyclableViewPoolManager(DeferredHandler paramDeferredHandler, int paramInt)
  {
    this.b = paramDeferredHandler;
    int m;
    int n;
    label44: int i1;
    label52: int i2;
    label61: int i3;
    label69: int i4;
    if (paramInt <= a)
    {
      m = 1;
      if (m != 0)
        break label136;
      n = 12;
      if (m != 0)
        break label143;
      i1 = i;
      if (m != 0)
        break label149;
      i2 = 9;
      if (m != 0)
        break label155;
      i3 = 3;
      if (m != 0)
        break label161;
      i4 = j;
      label78: if (m != 0)
        break label167;
      label83: if (m != 0)
        break label173;
      label88: if ((m == 0) && (m != 0))
        break label179;
    }
    while (true)
    {
      this.c = Collections.unmodifiableMap(new FeedRecyclableViewPoolManager.1(this, n, i1, i2, i3, i4, k, j, 1, i));
      return;
      m = 0;
      break;
      label136: n = k;
      break label44;
      label143: i1 = 1;
      break label52;
      label149: i2 = 1;
      break label61;
      label155: i3 = 1;
      break label69;
      label161: i4 = 1;
      break label78;
      label167: k = 1;
      break label83;
      label173: j = 1;
      break label88;
      label179: i = 1;
    }
  }

  private <T extends View> boolean a(Class<T> paramClass, View paramView)
  {
    if (b(paramClass))
      this.d.a(paramClass).add(paramView);
    for (int i = 1; ; i = 0)
      return i;
  }

  private <T extends View> boolean b(Class<T> paramClass)
  {
    if (!this.c.containsKey(paramClass))
      Preconditions.checkState(false, paramClass.getSimpleName() + " isn't configured!");
    if (this.d.a(paramClass).size() < FeedRecyclableViewPoolManager.ViewPoolConfig.a((FeedRecyclableViewPoolManager.ViewPoolConfig)this.c.get(paramClass)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public <T extends View> T a(Class<T> paramClass)
  {
    boolean bool;
    List localList;
    if (paramClass != null)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      if (!this.d.d(paramClass))
        break label72;
      localList = this.d.a(paramClass);
      if (localList.isEmpty())
        break label72;
    }
    label72: for (View localView = (View)paramClass.cast(localList.remove(-1 + localList.size())); ; localView = null)
    {
      return localView;
      bool = false;
      break;
    }
  }

  public void a()
  {
    b();
    this.d.f();
  }

  public <T extends View> void a(Class<T> paramClass, View paramView, FbCustomViewGroup paramFbCustomViewGroup)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramClass != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      Preconditions.checkArgument(paramView instanceof RecyclableView, "RecyclableView interface is required!");
      if (paramFbCustomViewGroup == null)
        break label65;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      paramFbCustomViewGroup.detachRecyclableViewFromParent(paramView);
      if (!a(paramClass, paramView))
        paramFbCustomViewGroup.removeRecyclableViewFromParent(paramView, false);
      return;
      bool2 = false;
      break;
      label65: bool1 = false;
    }
  }

  public <T extends View> void a(Class<T> paramClass, IRecyclableViewFactory<T> paramIRecyclableViewFactory, Activity paramActivity)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramClass != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramIRecyclableViewFactory == null)
        break label43;
      label20: Preconditions.checkArgument(bool1);
      if ((paramActivity != null) && (!paramActivity.isFinishing()))
        break label49;
    }
    while (true)
    {
      return;
      bool2 = false;
      break;
      label43: bool1 = false;
      break label20;
      label49: FeedRecyclableViewPoolManager.ViewPoolConfig localViewPoolConfig = (FeedRecyclableViewPoolManager.ViewPoolConfig)this.c.get(paramClass);
      int i = 0;
      if (localViewPoolConfig == null)
      {
        Preconditions.checkState(false, paramClass.getSimpleName() + " isn't configured!");
        continue;
      }
      while (i < FeedRecyclableViewPoolManager.ViewPoolConfig.b(localViewPoolConfig))
      {
        this.b.b(new FeedRecyclableViewPoolManager.2(this, paramActivity, paramClass, paramIRecyclableViewFactory));
        i++;
      }
    }
  }

  public void b()
  {
    this.b.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager
 * JD-Core Version:    0.6.0
 */