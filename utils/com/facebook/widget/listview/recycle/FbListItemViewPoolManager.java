package com.facebook.widget.listview.recycle;

import android.app.Activity;
import android.view.View;
import com.facebook.android.os.DeferredHandler;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FbListItemViewPoolManager
{
  private static int a = 10;
  private final Map<Class<? extends FbBaseAdapter>, ArrayListMultimap<Integer, FbListItemViewPoolManager.Entry>> b;
  private final DeferredHandler c;

  public FbListItemViewPoolManager(DeferredHandler paramDeferredHandler, int paramInt)
  {
    this.c = paramDeferredHandler;
    this.b = Maps.a();
    if (paramInt >= 33);
    for (int i = 10; ; i = 2)
    {
      a = i;
      return;
    }
  }

  private void a(Class<? extends FbBaseAdapter> paramClass, FbBaseAdapter paramFbBaseAdapter, FbListItemViewPoolManager.PreinflationHelperViewGroup paramPreinflationHelperViewGroup, int paramInt)
  {
    ArrayListMultimap localArrayListMultimap = (ArrayListMultimap)this.b.get(paramClass);
    if ((localArrayListMultimap != null) && (localArrayListMultimap.a(Integer.valueOf(paramInt)).size() >= a))
      return;
    View localView = paramFbBaseAdapter.a(paramInt, paramPreinflationHelperViewGroup);
    if (localView != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "The view factory cannot return null!");
      if (!(localView instanceof IViewAttachAware))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localView.getClass().getSimpleName();
        arrayOfObject[1] = IViewAttachAware.class.getSimpleName();
        Preconditions.checkState(false, "%s must implement %s", arrayOfObject);
      }
      a(paramClass, Integer.valueOf(paramInt), -1, localView);
      break;
    }
  }

  private boolean a(Class<? extends FbBaseAdapter> paramClass, Integer paramInteger, int paramInt, View paramView)
  {
    ArrayListMultimap localArrayListMultimap = (ArrayListMultimap)this.b.get(paramClass);
    if (localArrayListMultimap == null)
    {
      localArrayListMultimap = ArrayListMultimap.l();
      this.b.put(paramClass, localArrayListMultimap);
    }
    List localList = localArrayListMultimap.a(paramInteger);
    if (localList.size() < a)
      localList.add(new FbListItemViewPoolManager.Entry(paramView, paramInt));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public View a(Class<? extends FbBaseAdapter> paramClass, Integer paramInteger, int paramInt)
  {
    ArrayListMultimap localArrayListMultimap = (ArrayListMultimap)this.b.get(paramClass);
    List localList;
    int i;
    View localView;
    if (localArrayListMultimap != null)
    {
      localList = localArrayListMultimap.a(paramInteger);
      i = -1 + localList.size();
      if (i >= 0)
        if (FbListItemViewPoolManager.Entry.a((FbListItemViewPoolManager.Entry)localList.get(i)) == paramInt)
          localView = FbListItemViewPoolManager.Entry.b((FbListItemViewPoolManager.Entry)localList.remove(i));
    }
    while (true)
    {
      return localView;
      i--;
      break;
      if (!localList.isEmpty())
        localView = FbListItemViewPoolManager.Entry.b((FbListItemViewPoolManager.Entry)localList.remove(0));
      else
        localView = null;
    }
  }

  public void a()
  {
    b();
    this.b.clear();
  }

  public void a(Activity paramActivity, Class<? extends FbBaseAdapter> paramClass, FbBaseAdapter paramFbBaseAdapter, Map<Integer, Integer> paramMap)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    label24: boolean bool4;
    if (paramActivity != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramClass == null)
        break label171;
      bool3 = bool1;
      Preconditions.checkArgument(bool3);
      if (paramFbBaseAdapter == null)
        break label177;
      bool4 = bool1;
      label37: Preconditions.checkArgument(bool4);
      if (paramMap == null)
        break label183;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      FbListItemViewPoolManager.PreinflationHelperViewGroup localPreinflationHelperViewGroup = new FbListItemViewPoolManager.PreinflationHelperViewGroup(paramActivity);
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        int i = ((Integer)localEntry.getKey()).intValue();
        int j = ((Integer)localEntry.getValue()).intValue();
        for (int k = 0; k < j; k++)
          this.c.b(new FbListItemViewPoolManager.1(this, paramClass, paramFbBaseAdapter, localPreinflationHelperViewGroup, i));
      }
      bool2 = false;
      break;
      label171: bool3 = false;
      break label24;
      label177: bool4 = false;
      break label37;
      label183: bool1 = false;
    }
  }

  public boolean a(Class<? extends FbBaseAdapter> paramClass, RecycleViewWrapper paramRecycleViewWrapper)
  {
    View localView;
    boolean bool1;
    if (paramRecycleViewWrapper == null)
    {
      localView = null;
      bool1 = false;
      if (paramClass != null)
      {
        bool1 = false;
        if (localView != null)
          break label31;
      }
    }
    while (true)
    {
      return bool1;
      localView = paramRecycleViewWrapper.getEligibleContentView();
      break;
      label31: boolean bool2 = a(paramClass, paramRecycleViewWrapper.getRecyleViewType(), paramRecycleViewWrapper.getPositionInListView(), localView);
      bool1 = false;
      if (bool2)
      {
        paramRecycleViewWrapper.detachRecyclableViewFromParent(localView);
        bool1 = true;
      }
    }
  }

  public void b()
  {
    this.c.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listview.recycle.FbListItemViewPoolManager
 * JD-Core Version:    0.6.2
 */