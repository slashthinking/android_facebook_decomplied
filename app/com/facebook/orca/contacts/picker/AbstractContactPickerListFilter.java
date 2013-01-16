package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.ui.widgets.AbstractCustomFilter;
import com.facebook.orca.common.ui.widgets.CustomFilter.FilterResults;
import com.facebook.orca.users.UserIdentifierKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractContactPickerListFilter extends AbstractCustomFilter
  implements ContactPickerListFilter
{
  protected ContactPickerListFilter.RowCreator a;
  private ContactPickerListFilterReceiver b;
  private Set<UserIdentifierKey> c;

  public void a(ContactPickerListFilter.RowCreator paramRowCreator)
  {
    this.a = paramRowCreator;
  }

  public void a(ContactPickerListFilterReceiver paramContactPickerListFilterReceiver)
  {
    this.b = paramContactPickerListFilterReceiver;
    this.c = Sets.a();
  }

  public void a(ImmutableList<UserIdentifierKey> paramImmutableList)
  {
    this.c.clear();
    if (paramImmutableList != null)
    {
      Iterator localIterator = paramImmutableList.iterator();
      while (localIterator.hasNext())
      {
        UserIdentifierKey localUserIdentifierKey = (UserIdentifierKey)localIterator.next();
        this.c.add(localUserIdentifierKey);
      }
    }
  }

  protected void a(CharSequence paramCharSequence, CustomFilter.FilterResults paramFilterResults)
  {
    Preconditions.checkNotNull(paramFilterResults);
    Preconditions.checkNotNull(paramFilterResults.a);
    ContactPickerFilterResult localContactPickerFilterResult = (ContactPickerFilterResult)paramFilterResults.a;
    this.b.a(paramCharSequence, localContactPickerFilterResult);
  }

  protected boolean a(UserIdentifierKey paramUserIdentifierKey)
  {
    if (this.c == null);
    for (boolean bool = false; ; bool = this.c.contains(paramUserIdentifierKey))
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.AbstractContactPickerListFilter
 * JD-Core Version:    0.6.0
 */