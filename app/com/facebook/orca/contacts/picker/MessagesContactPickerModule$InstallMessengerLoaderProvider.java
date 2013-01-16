package com.facebook.orca.contacts.picker;

import android.content.Context;
import com.facebook.orca.annotations.ForMessages;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.contacts.favorites.InstallMessengerLoader;
import com.facebook.orca.contacts.favorites.MobileAppDataCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.FacebookUserIterator;

class MessagesContactPickerModule$InstallMessengerLoaderProvider extends AbstractProvider<InstallMessengerLoader>
{
  private MessagesContactPickerModule$InstallMessengerLoaderProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public InstallMessengerLoader a()
  {
    return new InstallMessengerLoader((Context)b(Context.class, FromApplication.class), a(FacebookUserIterator.class, ForMessages.class), (MobileAppDataCache)b(MobileAppDataCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.InstallMessengerLoaderProvider
 * JD-Core Version:    0.6.0
 */