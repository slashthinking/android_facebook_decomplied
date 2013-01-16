package com.facebook.widget;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.orca.debug.BLog;
import com.facebook.task.IncrementalTaskExecutor;
import com.facebook.widget.listview.FbBaseAdapter;

public abstract class CachingListAdapter extends FbBaseAdapter
{
  private SparseArray<CachingListAdapter.ViewTypeList> a = new SparseArray();
  private IncrementalTaskExecutor b;
  private CachingListAdapter.ViewPreparer c = null;
  private boolean d = false;
  private int e = 4;

  public CachingListAdapter(IncrementalTaskExecutor paramIncrementalTaskExecutor)
  {
    this.b = paramIncrementalTaskExecutor;
  }

  protected abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);

  public void a(CachingListAdapter.ViewPreparer paramViewPreparer)
  {
    this.c = paramViewPreparer;
  }

  protected boolean a(int paramInt)
  {
    return true;
  }

  public boolean a(View paramView)
  {
    int i = this.a.size();
    int j = 0;
    if (j < i)
      if (!((CachingListAdapter.ViewTypeList)this.a.valueAt(j)).a(paramView));
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      j++;
      break;
    }
  }

  protected boolean a(View paramView, int paramInt)
  {
    return true;
  }

  public void b(int paramInt)
  {
    if (this.d)
      c(paramInt).b(paramInt);
  }

  public void b(int paramInt, ViewGroup paramViewGroup)
  {
    if (this.d)
      c(paramInt).b(paramInt, paramViewGroup);
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean != this.d)
    {
      this.d = paramBoolean;
      if (!paramBoolean)
      {
        c(true);
        notifyDataSetInvalidated();
      }
    }
  }

  protected CachingListAdapter.ViewTypeList c(int paramInt)
  {
    int i = getItemViewType(paramInt);
    CachingListAdapter.ViewTypeList localViewTypeList = (CachingListAdapter.ViewTypeList)this.a.get(i);
    if (localViewTypeList == null)
    {
      localViewTypeList = new CachingListAdapter.ViewTypeList(this);
      this.a.put(i, localViewTypeList);
    }
    return localViewTypeList;
  }

  public void c()
  {
    this.a.clear();
  }

  public void c(boolean paramBoolean)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      CachingListAdapter.ViewTypeList.a((CachingListAdapter.ViewTypeList)this.a.valueAt(j), paramBoolean);
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (!this.d)
      localView = a(paramInt, paramView, paramViewGroup);
    while (true)
    {
      return localView;
      CachingListAdapter.ViewTypeList localViewTypeList = c(paramInt);
      localView = localViewTypeList.a(paramInt, paramViewGroup);
      if (!a(localView, paramInt))
      {
        BLog.e("BetterListAdapter", "View " + paramInt + " did not verify");
        localViewTypeList.b(paramInt);
        localView = localViewTypeList.a(paramInt, paramViewGroup);
      }
    }
  }

  public void notifyDataSetChanged()
  {
    c(false);
    super.notifyDataSetChanged();
  }

  public void notifyDataSetInvalidated()
  {
    c(false);
    super.notifyDataSetInvalidated();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CachingListAdapter
 * JD-Core Version:    0.6.2
 */