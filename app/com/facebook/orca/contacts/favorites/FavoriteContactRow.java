package com.facebook.orca.contacts.favorites;

import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.users.User;

public class FavoriteContactRow
  implements ContactPickerRow
{
  private final User a;
  private FavoriteContactRow.DeletePersonOnClickListener b;

  public FavoriteContactRow(User paramUser)
  {
    this.a = paramUser;
  }

  public User a()
  {
    return this.a;
  }

  public void a(FavoriteContactRow.DeletePersonOnClickListener paramDeletePersonOnClickListener)
  {
    this.b = paramDeletePersonOnClickListener;
  }

  public void b()
  {
    if (this.b != null)
      this.b.a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.FavoriteContactRow
 * JD-Core Version:    0.6.0
 */