package com.facebook.orca.contacts.picker;

import com.facebook.orca.contacts.favorites.InstallMessengerLoader;
import com.facebook.orca.contacts.favorites.InstallMessengerLoaderFactory;
import com.facebook.orca.inject.AbstractProvider;

class MessagesContactPickerModule$InstallMessengerLoaderFactoryProvider extends AbstractProvider<InstallMessengerLoaderFactory>
{
  private MessagesContactPickerModule$InstallMessengerLoaderFactoryProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public InstallMessengerLoaderFactory a()
  {
    return new InstallMessengerLoaderFactory(a(InstallMessengerLoader.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.InstallMessengerLoaderFactoryProvider
 * JD-Core Version:    0.6.0
 */