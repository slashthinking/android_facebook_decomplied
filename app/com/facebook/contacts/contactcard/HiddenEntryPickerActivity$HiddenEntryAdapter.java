package com.facebook.contacts.contactcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.facebook.contacts.models.entry.Entry;
import com.google.common.collect.ImmutableList;
import java.util.List;

class HiddenEntryPickerActivity$HiddenEntryAdapter extends ArrayAdapter<Entry>
{
  private final Context b;
  private final ImmutableList<Entry> c;

  public HiddenEntryPickerActivity$HiddenEntryAdapter(Context paramContext, ImmutableList<Entry> paramImmutableList)
  {
    super(paramImmutableList, 2130903395, localList);
    this.b = paramImmutableList;
    this.c = localList;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (HiddenEntryListRow localHiddenEntryListRow = new HiddenEntryListRow(this.b); ; localHiddenEntryListRow = (HiddenEntryListRow)paramView)
    {
      localHiddenEntryListRow.setEntry((Entry)this.c.get(paramInt));
      return localHiddenEntryListRow;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.HiddenEntryPickerActivity.HiddenEntryAdapter
 * JD-Core Version:    0.6.0
 */