package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import com.facebook.orca.contacts.picker.ContactPickerColorScheme;
import com.facebook.orca.contacts.picker.ContactPickerFilterResult;
import com.facebook.orca.contacts.picker.ContactPickerListFilter;
import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.contacts.picker.ContactPickerRows;
import com.facebook.orca.contacts.picker.ContactPickerSectionSplitterView;
import com.facebook.orca.contacts.picker.IContactPickerViewListAdapter;
import com.facebook.widget.DragSortListView.DragSortListAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import javax.inject.Provider;

public class FavoritesEditListAdapter extends BaseAdapter
  implements IContactPickerViewListAdapter, DragSortListView.DragSortListAdapter
{
  private static final Class<?> c = FavoritesEditListAdapter.class;
  protected final Context a;
  protected final LayoutInflater b;
  private final Provider<? extends ContactPickerListFilter> d;
  private ImmutableList<ContactPickerRow> e = ImmutableList.d();
  private ImmutableList<ContactPickerRow> f = ImmutableList.d();
  private ContactPickerListFilter g;
  private ContactPickerColorScheme h = ContactPickerColorScheme.DEFAULT_SCHEME;
  private int i = 0;

  public FavoritesEditListAdapter(Context paramContext, Provider<? extends ContactPickerListFilter> paramProvider, LayoutInflater paramLayoutInflater)
  {
    this.a = paramContext;
    this.d = paramProvider;
    this.b = paramLayoutInflater;
  }

  private View a(View paramView, ViewGroup paramViewGroup)
  {
    ContactPickerSectionSplitterView localContactPickerSectionSplitterView = (ContactPickerSectionSplitterView)paramView;
    if (localContactPickerSectionSplitterView == null)
    {
      localContactPickerSectionSplitterView = new ContactPickerSectionSplitterView(this.a);
      localContactPickerSectionSplitterView.setColorScheme(ContactPickerColorScheme.DIVEBAR_SCHEME);
    }
    return localContactPickerSectionSplitterView;
  }

  private View a(ViewGroup paramViewGroup, View paramView)
  {
    if (paramView != null);
    while (true)
    {
      return paramView;
      paramView = new NoFavoriteContactsItemView(this.a);
    }
  }

  private View a(AddFavoriteContactRow paramAddFavoriteContactRow, View paramView, ViewGroup paramViewGroup)
  {
    AddFavoriteContactItemView localAddFavoriteContactItemView = (AddFavoriteContactItemView)paramView;
    if (localAddFavoriteContactItemView == null)
      localAddFavoriteContactItemView = new AddFavoriteContactItemView(this.a);
    localAddFavoriteContactItemView.setContactRow(paramAddFavoriteContactRow);
    return localAddFavoriteContactItemView;
  }

  private View a(FavoriteContactRow paramFavoriteContactRow, View paramView, ViewGroup paramViewGroup)
  {
    FavoriteContactItemView localFavoriteContactItemView = (FavoriteContactItemView)paramView;
    if ((localFavoriteContactItemView == null) || (!localFavoriteContactItemView.a()))
      localFavoriteContactItemView = new FavoriteContactItemView(this.a);
    localFavoriteContactItemView.setContactRow(paramFavoriteContactRow);
    return localFavoriteContactItemView;
  }

  public int a()
  {
    Object localObject = this.f.get(0);
    ContactPickerRow localContactPickerRow = ContactPickerRows.f;
    int j = 0;
    if (localObject == localContactPickerRow)
      j = 1;
    return j;
  }

  public void a(ContactPickerColorScheme paramContactPickerColorScheme)
  {
    this.h = paramContactPickerColorScheme;
  }

  public void a(ImmutableList<ContactPickerRow> paramImmutableList)
  {
    this.e = paramImmutableList;
    this.f = this.e;
    notifyDataSetChanged();
    this.i = 0;
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
    {
      if (!((ContactPickerRow)localIterator.next() instanceof FavoriteContactRow))
        continue;
      this.i = (1 + this.i);
    }
  }

  public void a(CharSequence paramCharSequence, ContactPickerFilterResult paramContactPickerFilterResult)
  {
    Preconditions.checkNotNull(paramContactPickerFilterResult);
    switch (FavoritesEditListAdapter.2.a[paramContactPickerFilterResult.a().ordinal()])
    {
    default:
      b(ImmutableList.d());
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      b(paramContactPickerFilterResult.d());
      continue;
      e();
    }
  }

  public int b()
  {
    return -1 + this.i;
  }

  void b(ImmutableList<ContactPickerRow> paramImmutableList)
  {
    this.f = paramImmutableList;
    if (paramImmutableList.size() > 0)
      notifyDataSetChanged();
    while (true)
    {
      return;
      notifyDataSetInvalidated();
    }
  }

  public ContactPickerListFilter d()
  {
    if (this.g == null)
    {
      this.g = ((ContactPickerListFilter)this.d.b());
      this.g.a(this);
    }
    return this.g;
  }

  public void e()
  {
    this.f = this.e;
    if (this.f.size() > 0)
      notifyDataSetChanged();
    while (true)
    {
      return;
      notifyDataSetInvalidated();
    }
  }

  public int getCount()
  {
    return this.f.size();
  }

  public Filter getFilter()
  {
    return new FavoritesEditListAdapter.1(this);
  }

  public Object getItem(int paramInt)
  {
    return this.f.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    ContactPickerRow localContactPickerRow = (ContactPickerRow)this.f.get(paramInt);
    int j;
    if ((localContactPickerRow instanceof FavoriteContactRow))
      j = 0;
    while (true)
    {
      return j;
      if ((localContactPickerRow instanceof AddFavoriteContactRow))
      {
        j = 1;
        continue;
      }
      if (localContactPickerRow == ContactPickerRows.e)
      {
        j = 3;
        continue;
      }
      if (localContactPickerRow != ContactPickerRows.f)
        break;
      j = 2;
    }
    throw new IllegalArgumentException("Unknown object type " + localContactPickerRow.getClass());
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ContactPickerRow localContactPickerRow = (ContactPickerRow)this.f.get(paramInt);
    View localView;
    if (localContactPickerRow == ContactPickerRows.f)
      localView = a(paramViewGroup, paramView);
    while (true)
    {
      return localView;
      if ((localContactPickerRow instanceof FavoriteContactRow))
      {
        localView = a((FavoriteContactRow)localContactPickerRow, paramView, paramViewGroup);
        continue;
      }
      if ((localContactPickerRow instanceof AddFavoriteContactRow))
      {
        localView = a((AddFavoriteContactRow)localContactPickerRow, paramView, paramViewGroup);
        continue;
      }
      if (localContactPickerRow != ContactPickerRows.e)
        break;
      localView = a(paramView, paramViewGroup);
    }
    throw new IllegalArgumentException("Unknown object type " + localContactPickerRow.getClass());
  }

  public int getViewTypeCount()
  {
    return 4;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.FavoritesEditListAdapter
 * JD-Core Version:    0.6.0
 */