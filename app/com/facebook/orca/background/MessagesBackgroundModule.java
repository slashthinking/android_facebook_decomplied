package com.facebook.orca.background;

import com.facebook.background.BackgroundTask;
import com.facebook.orca.contacts.divebar.DivebarPreloadBackgroundTask;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class MessagesBackgroundModule extends AbstractModule
{
  protected void a()
  {
    a(AppConfigBackgroundTask.class).a(new MessagesBackgroundModule.AppConfigBackgroundTaskProvider(this, null)).a();
    a(FetchThreadListBackgroundTask.class).a(new MessagesBackgroundModule.FetchTheadListBackgroundTaskProvider(this, null)).a();
    a(FetchOutOfDateThreadsBackgroundTask.class).a(new MessagesBackgroundModule.FetchOutOfDateThreadsBackgroundTaskProvider(this, null)).a();
    a(FetchThreadsIntoMemoryCacheBackgroundTask.class).a(new MessagesBackgroundModule.FetchThreadsIntoMemoryCacheBackgroundTaskProvider(this, null)).a();
    a(FlushMmsPendingReceivesBackgroundTask.class).a(new MessagesBackgroundModule.FlushMmsPendingReceivesBackgroundTaskProvider(this, null)).a();
    a(SyncLastActiveForTopContactsBackgroundTask.class).a(new MessagesBackgroundModule.SyncLastActiveForTopContactsBackgroundTaskProvider(this, null)).a();
    a(SyncMobileAppDataForTopContactsBackgroundTask.class).a(new MessagesBackgroundModule.SyncMobileAppDataForTopContactsBackgroundTaskProvider(this, null)).a();
    c(BackgroundTask.class).a(AppConfigBackgroundTask.class).a(FetchThreadListBackgroundTask.class).a(FetchOutOfDateThreadsBackgroundTask.class).a(FetchThreadsIntoMemoryCacheBackgroundTask.class).a(FlushMmsPendingReceivesBackgroundTask.class).a(SyncLastActiveForTopContactsBackgroundTask.class).a(DivebarPreloadBackgroundTask.class).a(SyncMobileAppDataForTopContactsBackgroundTask.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.MessagesBackgroundModule
 * JD-Core Version:    0.6.0
 */