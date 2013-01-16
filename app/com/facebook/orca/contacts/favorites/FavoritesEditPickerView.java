package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.widget.Button;
import com.facebook.orca.common.ui.widgets.FavoritesDragSortListView;
import com.facebook.orca.contacts.picker.ContactPickerView;
import com.facebook.orca.contacts.picker.ContactPickerViewFilterState;
import com.facebook.orca.contacts.picker.IContactPickerViewListAdapter;

public class FavoritesEditPickerView extends ContactPickerView
{
  private Button b;
  private Button c;
  private FavoritesEditPickerView.OnDoneClickedListener d;

  public FavoritesEditPickerView(Context paramContext, IContactPickerViewListAdapter paramIContactPickerViewListAdapter)
  {
    super(paramContext, paramIContactPickerViewListAdapter, 2130903333);
    a();
  }

  protected void a()
  {
    this.b = ((Button)getView(2131297243));
    this.c = ((Button)getView(2131297244));
    this.b.setOnClickListener(new FavoritesEditPickerView.1(this));
    this.c.setOnClickListener(new FavoritesEditPickerView.2(this));
  }

  protected void a(ContactPickerViewFilterState paramContactPickerViewFilterState)
  {
    super.a(paramContactPickerViewFilterState);
    if ((paramContactPickerViewFilterState == ContactPickerViewFilterState.NONE) || (paramContactPickerViewFilterState == ContactPickerViewFilterState.UNFILTERED))
    {
      this.b.setVisibility(0);
      this.c.setVisibility(8);
    }
    while (true)
    {
      return;
      this.b.setVisibility(8);
      this.c.setVisibility(0);
    }
  }

  public FavoritesDragSortListView getDraggableList()
  {
    return (FavoritesDragSortListView)this.a;
  }

  public void setOnDoneClickedListener(FavoritesEditPickerView.OnDoneClickedListener paramOnDoneClickedListener)
  {
    this.d = paramOnDoneClickedListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.FavoritesEditPickerView
 * JD-Core Version:    0.6.0
 */