package com.facebook.orca.contacts.picker;

import com.facebook.orca.contacts.favorites.TopLastActiveCache;
import com.facebook.orca.inject.AbstractProvider;

class MessagesContactPickerModule$TopLastActiveCacheProvider extends AbstractProvider<TopLastActiveCache>
{
  private MessagesContactPickerModule$TopLastActiveCacheProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public TopLastActiveCache a()
  {
    return new TopLastActiveCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.TopLastActiveCacheProvider
 * JD-Core Version:    0.6.0
 */