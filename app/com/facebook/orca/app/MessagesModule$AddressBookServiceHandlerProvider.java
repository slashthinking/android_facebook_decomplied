package com.facebook.orca.app;

import com.facebook.contacts.data.DbInsertContactHandler;
import com.facebook.orca.annotations.IsLastActiveEnabled;
import com.facebook.orca.annotations.IsMobileAppDataEnabled;
import com.facebook.orca.annotations.IsMoreLastActiveEnabled;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.contacts.divebar.DivebarCache;
import com.facebook.orca.contacts.favorites.FavoriteContactsCache;
import com.facebook.orca.contacts.favorites.MobileAppDataCache;
import com.facebook.orca.contacts.favorites.TopLastActiveCache;
import com.facebook.orca.database.DbInsertFriendUsersHandler;
import com.facebook.orca.database.DbUsersPropertyUtil;
import com.facebook.orca.database.UsersDatabaseSupplier;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.FetchLastActiveMethod;
import com.facebook.orca.protocol.methods.FetchMessagingFavoritesMethod;
import com.facebook.orca.protocol.methods.FetchMobileAppDataMethod;
import com.facebook.orca.protocol.methods.GetFriendsMethod;
import com.facebook.orca.protocol.methods.UpdateMessagingFavoritesMethod;
import com.facebook.orca.users.AddressBookServiceHandler;

class MessagesModule$AddressBookServiceHandlerProvider extends AbstractProvider<AddressBookServiceHandler>
{
  private MessagesModule$AddressBookServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public AddressBookServiceHandler a()
  {
    return new AddressBookServiceHandler(a(SingleMethodRunner.class), (GetFriendsMethod)b(GetFriendsMethod.class), (UpdateMessagingFavoritesMethod)b(UpdateMessagingFavoritesMethod.class), (FetchMessagingFavoritesMethod)b(FetchMessagingFavoritesMethod.class), (FetchLastActiveMethod)b(FetchLastActiveMethod.class), (FetchMobileAppDataMethod)b(FetchMobileAppDataMethod.class), (DbInsertFriendUsersHandler)b(DbInsertFriendUsersHandler.class), (DbInsertContactHandler)b(DbInsertContactHandler.class), (FavoriteContactsCache)b(FavoriteContactsCache.class), (DivebarCache)b(DivebarCache.class), (TopLastActiveCache)b(TopLastActiveCache.class), (MobileAppDataCache)b(MobileAppDataCache.class), (UsersDatabaseSupplier)b(UsersDatabaseSupplier.class), (DbUsersPropertyUtil)b(DbUsersPropertyUtil.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), a(Boolean.class, IsLastActiveEnabled.class), a(Boolean.class, IsMoreLastActiveEnabled.class), a(Boolean.class, IsMobileAppDataEnabled.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AddressBookServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */