package com.facebook.widget.listview.recycle;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;
import com.facebook.widget.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;

public class ManagedRecycleViewAdapter extends BaseAdapter
{
  private final FbBaseAdapter a;
  private final FbListItemViewPoolManager b;
  private final AbsListView.RecyclerListener c = new ManagedRecycleViewAdapter.1(this);
  private final DataSetObserver d = new ManagedRecycleViewAdapter.2(this);

  public ManagedRecycleViewAdapter(BetterListView paramBetterListView, FbBaseAdapter paramFbBaseAdapter, FbListItemViewPoolManager paramFbListItemViewPoolManager)
  {
    boolean bool2;
    boolean bool3;
    if (paramBetterListView != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramFbBaseAdapter == null)
        break label102;
      bool3 = bool1;
      label52: Preconditions.checkArgument(bool3);
      if (paramFbListItemViewPoolManager == null)
        break label108;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.a = paramFbBaseAdapter;
      this.b = paramFbListItemViewPoolManager;
      paramBetterListView.setRecyclerListener(this.c);
      this.a.registerDataSetObserver(this.d);
      return;
      bool2 = false;
      break;
      label102: bool3 = false;
      break label52;
      label108: bool1 = false;
    }
  }

  public boolean areAllItemsEnabled()
  {
    return this.a.areAllItemsEnabled();
  }

  protected void finalize()
  {
    this.a.unregisterDataSetObserver(this.d);
    super.finalize();
  }

  public int getCount()
  {
    return this.a.getCount();
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.a.getDropDownView(paramInt, paramView, paramViewGroup);
  }

  public Object getItem(int paramInt)
  {
    return this.a.getItem(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return this.a.getItemId(paramInt);
  }

  public int getItemViewType(int paramInt)
  {
    return this.a.getItemViewType(paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Integer localInteger = Integer.valueOf(this.a.getItemViewType(paramInt));
    RecycleViewWrapper localRecycleViewWrapper = (RecycleViewWrapper)paramView;
    if (localRecycleViewWrapper == null)
      localRecycleViewWrapper = new RecycleViewWrapper(paramViewGroup.getContext());
    localRecycleViewWrapper.setRecycleViewType(localInteger);
    localRecycleViewWrapper.setPositionInListView(paramInt);
    boolean bool;
    View localView1;
    label102: View localView2;
    if ((localRecycleViewWrapper.getChildCount() == 0) || (localRecycleViewWrapper.getChildCount() == 1))
    {
      bool = true;
      Preconditions.checkState(bool);
      if (localRecycleViewWrapper.getChildCount() != 0)
        break label145;
      localView1 = this.b.a(this.a.getClass(), localInteger, paramInt);
      localView2 = this.a.getView(paramInt, localView1, paramViewGroup);
      if (!(localView2 instanceof IViewAttachAware))
        break label178;
      localRecycleViewWrapper.attachRecyclableViewToParent(localView2, 0, localView2.getLayoutParams());
    }
    while (true)
    {
      return localRecycleViewWrapper;
      bool = false;
      break;
      label145: int i = localRecycleViewWrapper.getChildCount();
      localView1 = null;
      if (i != 1)
        break label102;
      localView1 = localRecycleViewWrapper.getChildAt(0);
      localRecycleViewWrapper.removeViewAt(0);
      break label102;
      label178: localRecycleViewWrapper.addView(localView2);
    }
  }

  public int getViewTypeCount()
  {
    return this.a.getViewTypeCount();
  }

  public boolean hasStableIds()
  {
    return this.a.hasStableIds();
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public boolean isEnabled(int paramInt)
  {
    return this.a.isEnabled(paramInt);
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerDataSetObserver(paramDataSetObserver);
  }

  public String toString()
  {
    return getClass().getSimpleName() + "[" + this.a.getClass().getName() + "]";
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterDataSetObserver(paramDataSetObserver);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listview.recycle.ManagedRecycleViewAdapter
 * JD-Core Version:    0.6.2
 */