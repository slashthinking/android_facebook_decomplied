package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.orca.annotations.ForFavoritePickerList;
import com.facebook.orca.contacts.favorites.FavoritesEditListAdapter;
import com.facebook.orca.inject.AbstractProvider;

class MessagesContactPickerModule$FavoritesEditListAdapterProvider extends AbstractProvider<FavoritesEditListAdapter>
{
  private MessagesContactPickerModule$FavoritesEditListAdapterProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public FavoritesEditListAdapter a()
  {
    return new FavoritesEditListAdapter((Context)b(Context.class), a(ContactPickerListFilter.class, ForFavoritePickerList.class), (LayoutInflater)b(LayoutInflater.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.FavoritesEditListAdapterProvider
 * JD-Core Version:    0.6.0
 */