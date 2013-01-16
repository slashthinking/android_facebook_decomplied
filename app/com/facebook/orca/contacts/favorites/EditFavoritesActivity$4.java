package com.facebook.orca.contacts.favorites;

import com.facebook.orca.users.User;
import com.facebook.widget.DragSortListView.DropListener;
import java.util.List;

class EditFavoritesActivity$4
  implements DragSortListView.DropListener
{
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 < EditFavoritesActivity.d(this.a).size()))
    {
      User localUser = (User)EditFavoritesActivity.d(this.a).get(paramInt1);
      EditFavoritesActivity.d(this.a).remove(localUser);
      EditFavoritesActivity.d(this.a).add(paramInt2, localUser);
      EditFavoritesActivity.e(this.a);
      EditFavoritesActivity.f(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.EditFavoritesActivity.4
 * JD-Core Version:    0.6.0
 */