package com.facebook.orca.contacts.favorites;

import com.facebook.orca.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.users.UserWithIdentifier;

class EditFavoritesActivity$2
  implements ContactPickerListFilter.RowCreator
{
  public ContactPickerRow a(Object paramObject)
  {
    if (!(paramObject instanceof UserWithIdentifier))
    {
      BLog.d(EditFavoritesActivity.i(), "unexpected rowData of type: " + paramObject.getClass());
      throw new IllegalArgumentException();
    }
    AddFavoriteContactRow localAddFavoriteContactRow = new AddFavoriteContactRow(((UserWithIdentifier)paramObject).a());
    localAddFavoriteContactRow.a(new EditFavoritesActivity.2.1(this));
    return localAddFavoriteContactRow;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.EditFavoritesActivity.2
 * JD-Core Version:    0.6.0
 */