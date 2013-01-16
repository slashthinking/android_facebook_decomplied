package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.ui.widgets.CustomFilter;
import com.facebook.orca.users.UserIdentifierKey;
import com.google.common.collect.ImmutableList;

public abstract interface ContactPickerListFilter extends CustomFilter
{
  public abstract void a(ContactPickerListFilter.RowCreator paramRowCreator);

  public abstract void a(ContactPickerListFilterReceiver paramContactPickerListFilterReceiver);

  public abstract void a(ImmutableList<UserIdentifierKey> paramImmutableList);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerListFilter
 * JD-Core Version:    0.6.0
 */