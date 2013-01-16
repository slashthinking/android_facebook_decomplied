package com.facebook.orca.app;

import com.facebook.analytics.AnalyticsDatabaseSupplier;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.data.ContactsDatabaseSupplier;
import com.facebook.location.LocationCache;
import com.facebook.orca.annotations.IsSmsOnlyModeActive;
import com.facebook.orca.audio.AudioCache;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.cache.ChatVisibilityCache;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.contacts.divebar.DivebarCache;
import com.facebook.orca.contacts.favorites.FavoriteContactsCache;
import com.facebook.orca.contacts.favorites.MobileAppDataCache;
import com.facebook.orca.contacts.favorites.TopLastActiveCache;
import com.facebook.orca.database.DbMessageCache;
import com.facebook.orca.database.ThreadsDatabaseSupplier;
import com.facebook.orca.database.UsersDatabaseSupplier;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.location.GeocodingCache;
import com.facebook.orca.prefs.OrcaSharedPreferencesImpl;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.rollout.OrcaRolloutManager;
import com.facebook.orca.server.OrcaServiceQueueManager;

class MessagesModule$OrcaDataManagerProvider extends AbstractProvider<OrcaDataManager>
{
  private MessagesModule$OrcaDataManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public OrcaDataManager a()
  {
    return new OrcaDataManager(MessagesModule.a(this.a), (MeUserAuthDataStore)b(MeUserAuthDataStore.class), a(Boolean.class, IsSmsOnlyModeActive.class), (ImageCache)b(ImageCache.class), (AudioCache)b(AudioCache.class), (ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (ThreadsCache)b(ThreadsCache.class), (ThreadDisplayCache)b(ThreadDisplayCache.class), (UsersDatabaseSupplier)b(UsersDatabaseSupplier.class), (AnalyticsDatabaseSupplier)b(AnalyticsDatabaseSupplier.class), (OrcaSharedPreferencesImpl)b(OrcaSharedPreferencesImpl.class), (UiCounters)b(UiCounters.class), (DivebarCache)b(DivebarCache.class), (FavoriteContactsCache)b(FavoriteContactsCache.class), (TopLastActiveCache)b(TopLastActiveCache.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (OrcaServiceQueueManager)b(OrcaServiceQueueManager.class), (OrcaHttpRequestProcessor)b(OrcaHttpRequestProcessor.class), (LocationCache)b(LocationCache.class), (GeocodingCache)b(GeocodingCache.class), (DbMessageCache)b(DbMessageCache.class), (ChatVisibilityCache)b(ChatVisibilityCache.class), (OrcaRolloutManager)b(OrcaRolloutManager.class), (OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), (ContactsDatabaseSupplier)b(ContactsDatabaseSupplier.class), (ContactsCache)b(ContactsCache.class), (MobileAppDataCache)b(MobileAppDataCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OrcaDataManagerProvider
 * JD-Core Version:    0.6.0
 */