package com.facebook.orca.contacts.picker;

import android.widget.Filterable;
import android.widget.ListAdapter;
import com.facebook.orca.common.ui.widgets.CustomFilterable;
import com.google.common.collect.ImmutableList;

public abstract interface IContactPickerViewListAdapter extends Filterable, ListAdapter, CustomFilterable, ContactPickerListFilterReceiver
{
  public abstract void a(ContactPickerColorScheme paramContactPickerColorScheme);

  public abstract void a(ImmutableList<ContactPickerRow> paramImmutableList);

  public abstract ContactPickerListFilter d();

  public abstract void e();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.IContactPickerViewListAdapter
 * JD-Core Version:    0.6.0
 */