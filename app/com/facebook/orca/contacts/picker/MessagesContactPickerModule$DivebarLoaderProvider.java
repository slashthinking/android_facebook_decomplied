package com.facebook.orca.contacts.picker;

import android.content.Context;
import com.facebook.contacts.annotations.IsRolodexPickerEnabled;
import com.facebook.contacts.annotations.WithContacts;
import com.facebook.contacts.data.DbContactsPropertyUtil;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.IsLastActiveEnabled;
import com.facebook.orca.annotations.IsPresenceEnabled;
import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.annotations.ShowOtherContactsDivebar;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.contacts.divebar.DivebarCache;
import com.facebook.orca.contacts.divebar.DivebarLoader;
import com.facebook.orca.contacts.favorites.FavoriteContactsCache;
import com.facebook.orca.database.DbUsersPropertyUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.users.FacebookUserIterator;
import com.facebook.orca.users.User;

class MessagesContactPickerModule$DivebarLoaderProvider extends AbstractProvider<DivebarLoader>
{
  private MessagesContactPickerModule$DivebarLoaderProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public DivebarLoader a()
  {
    return new DivebarLoader((Context)b(Context.class, FromApplication.class), (DbUsersPropertyUtil)b(DbUsersPropertyUtil.class), (DivebarCache)b(DivebarCache.class), (FavoriteContactsCache)b(FavoriteContactsCache.class), a(FacebookUserIterator.class, WithContacts.class), (PresenceManager)b(PresenceManager.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class), a(Boolean.class, IsLastActiveEnabled.class), a(Boolean.class, IsPresenceEnabled.class), a(Boolean.class, ShowOtherContactsDivebar.class), a(User.class, MeUser.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (DbContactsPropertyUtil)b(DbContactsPropertyUtil.class), a(Boolean.class, IsRolodexPickerEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.DivebarLoaderProvider
 * JD-Core Version:    0.6.0
 */