package com.facebook.orca.contacts.picker;

import android.content.res.Resources;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.orca.common.ui.widgets.CustomFilter;
import com.facebook.orca.common.ui.widgets.CustomFilterable;

public class ContactPickerHackListAdapter
  implements Filterable, ListAdapter, CustomFilterable
{
  private final IContactPickerViewListAdapter a;
  private boolean b;

  public ContactPickerHackListAdapter(IContactPickerViewListAdapter paramIContactPickerViewListAdapter)
  {
    this.a = paramIContactPickerViewListAdapter;
  }

  private void a(ViewParent paramViewParent)
  {
    ViewParent localViewParent = paramViewParent;
    if (localViewParent != null)
      if (!(localViewParent instanceof ListView));
    for (ListView localListView = (ListView)localViewParent; ; localListView = null)
    {
      if (localListView != null)
      {
        localListView.setDividerHeight(0);
        localListView.setDivider(localListView.getResources().getDrawable(2130838995));
      }
      return;
      localViewParent = localViewParent.getParent();
      break;
    }
  }

  public boolean areAllItemsEnabled()
  {
    return this.a.areAllItemsEnabled();
  }

  public CustomFilter c()
  {
    return this.a.d();
  }

  public int getCount()
  {
    return this.a.getCount();
  }

  public Filter getFilter()
  {
    return this.a.getFilter();
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
    if (!this.b)
    {
      a(paramViewGroup);
      this.b = true;
    }
    return this.a.getView(paramInt, paramView, paramViewGroup);
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

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterDataSetObserver(paramDataSetObserver);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerHackListAdapter
 * JD-Core Version:    0.6.0
 */