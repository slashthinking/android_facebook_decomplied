package com.facebook.orca.threadlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

class ContactGridAdapter extends BaseAdapter
{
  private ImmutableList<User> a = ImmutableList.d();
  private final Context b;

  public ContactGridAdapter(Context paramContext, ImmutableList<User> paramImmutableList)
  {
    this.b = paramContext;
    this.a = paramImmutableList;
  }

  public void a(ImmutableList<User> paramImmutableList)
  {
    this.a = paramImmutableList;
  }

  public int getCount()
  {
    int i = 6;
    if (this.a.size() > i);
    while (true)
    {
      return i;
      i = this.a.size();
    }
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    User localUser = (User)this.a.get(paramInt);
    if (paramView == null);
    for (ContactGridCellView localContactGridCellView = new ContactGridCellView(this.b); ; localContactGridCellView = (ContactGridCellView)paramView)
    {
      localContactGridCellView.a(localUser);
      return localContactGridCellView;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ContactGridAdapter
 * JD-Core Version:    0.6.0
 */