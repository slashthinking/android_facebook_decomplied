package com.facebook.contacts.contactslist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.contacts.models.ContactSummary;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.List;

public class ContactsListAdapter extends BaseAdapter
{
  private final Context a;
  private final ContactComparatorByName b;
  private List<ContactSummary> c = ImmutableList.d();

  public ContactsListAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ContactComparatorByName();
  }

  public void a(ImmutableList<ContactSummary> paramImmutableList)
  {
    this.c = Ordering.a(this.b).b(paramImmutableList);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.c.size();
  }

  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ContactSummary localContactSummary = (ContactSummary)this.c.get(paramInt);
    if (paramView == null);
    for (ContactRowView localContactRowView = new ContactRowView(this.a); ; localContactRowView = (ContactRowView)paramView)
    {
      localContactRowView.setContactSummary(localContactSummary);
      return localContactRowView;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactslist.ContactsListAdapter
 * JD-Core Version:    0.6.0
 */