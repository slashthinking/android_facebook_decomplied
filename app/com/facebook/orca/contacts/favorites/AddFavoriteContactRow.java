package com.facebook.orca.contacts.favorites;

import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.users.User;

public class AddFavoriteContactRow
  implements ContactPickerRow
{
  private final User a;
  private AddFavoriteContactRow.AddContactOnClickListener b;

  public AddFavoriteContactRow(User paramUser)
  {
    this.a = paramUser;
  }

  public User a()
  {
    return this.a;
  }

  public void a(AddFavoriteContactRow.AddContactOnClickListener paramAddContactOnClickListener)
  {
    this.b = paramAddContactOnClickListener;
  }

  public void b()
  {
    if (this.b != null)
      this.b.a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.AddFavoriteContactRow
 * JD-Core Version:    0.6.0
 */