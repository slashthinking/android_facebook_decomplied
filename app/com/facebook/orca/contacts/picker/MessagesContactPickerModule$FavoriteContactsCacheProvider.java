package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.contacts.favorites.FavoriteContactsCache;
import com.facebook.orca.inject.AbstractProvider;

class MessagesContactPickerModule$FavoriteContactsCacheProvider extends AbstractProvider<FavoriteContactsCache>
{
  private MessagesContactPickerModule$FavoriteContactsCacheProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public FavoriteContactsCache a()
  {
    return new FavoriteContactsCache((Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.FavoriteContactsCacheProvider
 * JD-Core Version:    0.6.0
 */