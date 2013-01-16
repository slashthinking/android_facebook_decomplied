package com.facebook.orca.contacts.picker;

import com.facebook.orca.annotations.IsDivebarMoreMobileFriendsEnabled;
import com.facebook.orca.annotations.IsDivebarMoreMobileFriendsNewSectionEnabled;
import com.facebook.orca.contacts.divebar.DivebarLoader;
import com.facebook.orca.contacts.divebar.DivebarLoaderFactory;
import com.facebook.orca.inject.AbstractProvider;

class MessagesContactPickerModule$DivebarLoaderFactoryProvider extends AbstractProvider<DivebarLoaderFactory>
{
  private MessagesContactPickerModule$DivebarLoaderFactoryProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public DivebarLoaderFactory a()
  {
    return new DivebarLoaderFactory(a(DivebarLoader.class), a(Boolean.class, IsDivebarMoreMobileFriendsEnabled.class), a(Boolean.class, IsDivebarMoreMobileFriendsNewSectionEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.DivebarLoaderFactoryProvider
 * JD-Core Version:    0.6.0
 */