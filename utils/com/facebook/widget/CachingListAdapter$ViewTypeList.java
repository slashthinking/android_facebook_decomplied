package com.facebook.widget;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.orca.common.util.RingBuffer;
import com.facebook.task.IncrementalTaskExecutor;
import com.facebook.widget.listview.recycle.RecyclableView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class CachingListAdapter$ViewTypeList
{
  protected SparseArray<CachingListAdapter.CachedViewNode> a = new SparseArray();
  protected RingBuffer<View> b;

  public CachingListAdapter$ViewTypeList(CachingListAdapter paramCachingListAdapter)
  {
    this.b = new RingBuffer(CachingListAdapter.a(paramCachingListAdapter));
  }

  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof RecyclableView))
      ((RecyclableView)paramView).a(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = 0;
      int j = localViewGroup.getChildCount();
      while (i < j)
      {
        a(localViewGroup.getChildAt(i), paramBoolean);
        i++;
      }
    }
  }

  private void a(CachingListAdapter.CachedViewNode paramCachedViewNode)
  {
    if (paramCachedViewNode.b != null)
    {
      b(paramCachedViewNode);
      if (!this.b.b())
        this.b.a(paramCachedViewNode.b);
    }
    if ((paramCachedViewNode.a()) && (CachingListAdapter.d(this.c) != null))
      CachingListAdapter.d(this.c).d(paramCachedViewNode.c);
    paramCachedViewNode.b = null;
    paramCachedViewNode.c = null;
    paramCachedViewNode.d = null;
    paramCachedViewNode.a = -1;
  }

  private void a(CachingListAdapter.CachedViewNode paramCachedViewNode, boolean paramBoolean)
  {
    a(paramCachedViewNode.b, paramBoolean);
  }

  private void a(boolean paramBoolean)
  {
    int i = 0;
    int j = this.a.size();
    if (paramBoolean)
      for (int n = j - 1; n >= 0; n--)
        b(this.a.keyAt(n));
    HashMap localHashMap = new HashMap();
    for (int k = 0; k < j; k++)
    {
      CachingListAdapter.CachedViewNode localCachedViewNode2 = (CachingListAdapter.CachedViewNode)this.a.valueAt(k);
      localHashMap.put(localCachedViewNode2.d, localCachedViewNode2);
    }
    SparseArray localSparseArray = new SparseArray();
    while (i < j)
    {
      int m = this.a.keyAt(i);
      Object localObject = this.c.getItem(m);
      CachingListAdapter.CachedViewNode localCachedViewNode1 = (CachingListAdapter.CachedViewNode)localHashMap.get(localObject);
      if ((localCachedViewNode1 != null) && (this.c.a(m)))
      {
        localHashMap.remove(localObject);
        localCachedViewNode1.a = m;
        localSparseArray.put(m, localCachedViewNode1);
      }
      i++;
    }
    this.a = localSparseArray;
    Iterator localIterator = localHashMap.values().iterator();
    while (localIterator.hasNext())
      a((CachingListAdapter.CachedViewNode)localIterator.next());
  }

  private void b(View paramView)
  {
    if ((paramView instanceof RecyclableView))
      ((RecyclableView)paramView).b();
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = 0;
      int j = localViewGroup.getChildCount();
      while (i < j)
      {
        b(localViewGroup.getChildAt(i));
        i++;
      }
    }
  }

  private void b(CachingListAdapter.CachedViewNode paramCachedViewNode)
  {
    b(paramCachedViewNode.b);
  }

  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    CachingListAdapter.CachedViewNode localCachedViewNode = a(paramInt);
    if (localCachedViewNode.a())
      localCachedViewNode.c.f();
    if (localCachedViewNode.b == null)
      if (this.b.c() <= 0)
        break label143;
    label143: for (View localView = (View)this.b.a(); ; localView = null)
    {
      localCachedViewNode.b = this.c.a(paramInt, localView, paramViewGroup);
      localCachedViewNode.e = CachingListAdapter.ViewState.Ready;
      if ((CachingListAdapter.b(this.c) != null) && (localCachedViewNode.e == CachingListAdapter.ViewState.LaidOut))
      {
        CachingListAdapter.b(this.c).c(localCachedViewNode.b, paramInt);
        localCachedViewNode.e = CachingListAdapter.ViewState.Ready;
      }
      if (localCachedViewNode.e != CachingListAdapter.ViewState.OnScreen)
      {
        a(localCachedViewNode, true);
        localCachedViewNode.e = CachingListAdapter.ViewState.OnScreen;
      }
      return localCachedViewNode.b;
    }
  }

  protected final CachingListAdapter.CachedViewNode a(int paramInt)
  {
    CachingListAdapter.CachedViewNode localCachedViewNode = (CachingListAdapter.CachedViewNode)this.a.get(paramInt);
    if (localCachedViewNode == null)
    {
      localCachedViewNode = new CachingListAdapter.CachedViewNode();
      if (this.c.a(paramInt))
        this.a.put(paramInt, localCachedViewNode);
    }
    localCachedViewNode.a = paramInt;
    localCachedViewNode.d = this.c.getItem(paramInt);
    return localCachedViewNode;
  }

  public boolean a(View paramView)
  {
    int i = this.a.size();
    int j = 0;
    if (j < i)
      if (((CachingListAdapter.CachedViewNode)this.a.valueAt(j)).b != paramView);
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      j++;
      break;
    }
  }

  public void b(int paramInt)
  {
    CachingListAdapter.CachedViewNode localCachedViewNode = (CachingListAdapter.CachedViewNode)this.a.get(paramInt);
    if (localCachedViewNode != null)
    {
      a(localCachedViewNode);
      this.a.delete(paramInt);
    }
  }

  public void b(int paramInt, ViewGroup paramViewGroup)
  {
    if ((!CachingListAdapter.c(this.c)) || (!this.c.a(paramInt)));
    while (true)
    {
      return;
      CachingListAdapter.CachedViewNode localCachedViewNode = a(paramInt);
      if (!localCachedViewNode.a())
        if (localCachedViewNode.b != null)
        {
          if (localCachedViewNode.e == CachingListAdapter.ViewState.OnScreen)
          {
            a(localCachedViewNode, false);
            localCachedViewNode.e = CachingListAdapter.ViewState.Ready;
          }
          if (!localCachedViewNode.b.isLayoutRequested());
        }
        else
        {
          localCachedViewNode.c = new CachingListAdapter.ViewTypeList.IncrementalPreloadTask(this);
          View localView;
          if (localCachedViewNode.b == null)
            if (this.b.c() > 0)
            {
              localView = (View)this.b.a();
              label116: localCachedViewNode.c.a(paramInt, localView, paramViewGroup, localCachedViewNode);
            }
          while (true)
          {
            if (CachingListAdapter.d(this.c) != null)
              break label167;
            localCachedViewNode.c.f();
            break;
            localView = null;
            break label116;
            localCachedViewNode.c.a(paramInt, paramViewGroup, localCachedViewNode);
          }
          label167: CachingListAdapter.d(this.c).a(localCachedViewNode.c);
        }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CachingListAdapter.ViewTypeList
 * JD-Core Version:    0.6.2
 */