package com.facebook.orca.contacts.picker;

import com.facebook.orca.annotations.ForAddressBook;
import com.facebook.orca.annotations.ForDivebarList;
import com.facebook.orca.annotations.ForFacebookList;
import com.facebook.orca.annotations.ForFavoritePickerList;
import com.facebook.orca.annotations.ForMergedComposer;
import com.facebook.orca.annotations.IsDisplayGroupsInDivebarEnabled;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.contacts.divebar.DivebarCache;
import com.facebook.orca.contacts.divebar.DivebarLoader;
import com.facebook.orca.contacts.divebar.DivebarLoaderFactory;
import com.facebook.orca.contacts.divebar.DivebarPreloadBackgroundTask;
import com.facebook.orca.contacts.divebar.DivebarViewListener;
import com.facebook.orca.contacts.favorites.FavoriteContactsCache;
import com.facebook.orca.contacts.favorites.FavoritesEditListAdapter;
import com.facebook.orca.contacts.favorites.InstallMessengerLoader;
import com.facebook.orca.contacts.favorites.InstallMessengerLoaderFactory;
import com.facebook.orca.contacts.favorites.MobileAppDataCache;
import com.facebook.orca.contacts.favorites.TopLastActiveCache;
import com.facebook.orca.contacts.providers.IsDisplayGroupsInDivebarEnabledProvider;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.google.inject.Key;

public class MessagesContactPickerModule extends AbstractModule
{
  protected void a()
  {
    a(DivebarCache.class).a(new MessagesContactPickerModule.DivebarCacheProvider(this, null)).a();
    a(FavoriteContactsCache.class).a(new MessagesContactPickerModule.FavoriteContactsCacheProvider(this, null)).a();
    a(TopLastActiveCache.class).a(new MessagesContactPickerModule.TopLastActiveCacheProvider(this, null)).a();
    a(MobileAppDataCache.class).a(new MessagesContactPickerModule.MobileAppDataCacheProvider(this, null)).a();
    a(FavoritesEditListAdapter.class).a(new MessagesContactPickerModule.FavoritesEditListAdapterProvider(this, null));
    a(Boolean.class).a(IsDisplayGroupsInDivebarEnabled.class).c(IsDisplayGroupsInDivebarEnabledProvider.class);
    a(ContactPickerFriendFilter.class).a(new MessagesContactPickerModule.ContactPickerFriendFilterProvider(this, null));
    a(ContactPickerAddressBookFilter.class).a(new MessagesContactPickerModule.ContactPickerAddressBookFilterProvider(this, null));
    a(ContactPickerFriendsOfFriendsFilter.class).a(new MessagesContactPickerModule.ContactPickerFriendsOfFriendsFilterProvider(this, null));
    a(ContentPickerGroupFilter.class).a(new MessagesContactPickerModule.ContentPickerGroupFilterProvider(this, null));
    a(ContactPickerListFilter.class).a(ForDivebarList.class).a(new MessagesContactPickerModule.MergedDivebarContactPickerListFilterProvider(null));
    a(ContactPickerListFilter.class).a(ForMergedComposer.class).a(new MessagesContactPickerModule.MergedContactPickerListFilterProvider(null));
    a(ContactPickerListFilter.class).a(ForFacebookList.class).a(new MessagesContactPickerModule.ContactPickerListFilterProviderForFacebookList(null));
    a(ContactPickerListFilter.class).a(ForAddressBook.class).b(ContactPickerAddressBookFilter.class);
    a(ContactPickerListFilter.class).a(ForFavoritePickerList.class).a(new MessagesContactPickerModule.ContactPickerFriendFilterProvider(this, null));
    a(IContactPickerViewListAdapter.class).a(ForFacebookList.class).a(new MessagesContactPickerModule.ContactPickerViewListAdapterProvider(this, Key.a(ContactPickerListFilter.class, ForFacebookList.class), null));
    a(IContactPickerViewListAdapter.class).a(ForAddressBook.class).a(new MessagesContactPickerModule.ContactPickerViewListAdapterProvider(this, Key.a(ContactPickerListFilter.class, ForAddressBook.class), null));
    a(IContactPickerViewListAdapter.class).a(ForFavoritePickerList.class).a(new MessagesContactPickerModule.ContactPickerViewListAdapterProvider(this, Key.a(ContactPickerListFilter.class, ForFavoritePickerList.class), null));
    a(IContactPickerViewListAdapter.class).a(ForDivebarList.class).a(new MessagesContactPickerModule.ContactPickerViewListAdapterProvider(this, Key.a(ContactPickerListFilter.class, ForDivebarList.class), null));
    a(IContactPickerViewListAdapter.class).a(ForMergedComposer.class).a(new MessagesContactPickerModule.ContactPickerViewListAdapterProvider(this, Key.a(ContactPickerListFilter.class, ForMergedComposer.class), null));
    a(DivebarPreloadBackgroundTask.class).a(new MessagesContactPickerModule.DivebarPreloadBackgroundTaskProvider(this, null));
    a(DivebarLoader.class).a(new MessagesContactPickerModule.DivebarLoaderProvider(this, null));
    a(DivebarLoaderFactory.class).a(new MessagesContactPickerModule.DivebarLoaderFactoryProvider(this, null)).a();
    a(InstallMessengerLoader.class).a(new MessagesContactPickerModule.InstallMessengerLoaderProvider(this, null));
    a(InstallMessengerLoaderFactory.class).a(new MessagesContactPickerModule.InstallMessengerLoaderFactoryProvider(this, null)).a();
    a(DivebarController.class).a(new MessagesContactPickerModule.DivebarControllerProvider(this, null));
    c(DivebarViewListener.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule
 * JD-Core Version:    0.6.0
 */