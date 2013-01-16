package com.facebook.timeline;

import android.app.Application;
import com.facebook.feed.annotations.IsUFIShareActionEnabled;
import com.facebook.feed.module.TimelineServicesInitializer;
import com.facebook.feed.protocol.DeleteStoryMethod;
import com.facebook.feed.protocol.FetchTimelineFirstUnitsMethod;
import com.facebook.feed.protocol.FetchTimelineHeaderMethod;
import com.facebook.feed.protocol.FetchTimelineSectionListMethod;
import com.facebook.feed.protocol.FetchTimelineSectionMethod;
import com.facebook.feed.protocol.HideTimelineStoryMethod;
import com.facebook.feed.protocol.TimelineHeaderQueue;
import com.facebook.feed.protocol.TimelineSectionQueue;
import com.facebook.feed.protocol.TimelineServiceHandler;
import com.facebook.fragment.IFragmentFactoryInitializer;
import com.facebook.friends.FriendingServiceModule;
import com.facebook.friends.protocol.AddFriendListMemberMethod;
import com.facebook.friends.protocol.FetchFriendListsMethod;
import com.facebook.friends.protocol.FetchFriendListsWithMemberMethod;
import com.facebook.friends.protocol.RemoveFriendListMemberMethod;
import com.facebook.graphql.module.GraphQLModule;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnUiThread;
import com.facebook.orca.app.IHaveUserData;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.timeline.annotations.IsNativeTimelineEnabled;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.facebook.timeline.cache.db.TimelineDatabaseInitializer;
import com.facebook.timeline.cache.db.TimelineDatabaseSupplier;
import com.facebook.timeline.cache.db.TimelineDbModule;
import com.facebook.timeline.cache.ram.TimelineCacheServiceHandler;
import com.facebook.timeline.cache.ram.TimelineRamCache;
import com.facebook.uri.UriIntentBuilder;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class TimelineModule extends AbstractModule
{
  private Application a;

  public TimelineModule(Application paramApplication)
  {
    this.a = paramApplication;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    e(GraphQLModule.class);
    a(new FriendingServiceModule());
    a(new TimelineDbModule(this.a));
    a(SystemClock.class).a(new TimelineModule.SystemClockProvider(null)).a();
    a(FetchTimelineHeaderMethod.class).a(new TimelineModule.FetchTimelineHeaderMethodProvider(this, null));
    a(FetchTimelineSectionMethod.class).a(new TimelineModule.FetchTimelineSectionMethodProvider(this, null));
    a(FetchTimelineFirstUnitsMethod.class).a(new TimelineModule.FetchTimelineFirstUnitsMethodProvider(this, null));
    a(FetchTimelineSectionListMethod.class).a(new TimelineModule.FetchTimelineSectionListMethodProvider(this, null));
    a(AddFriendListMemberMethod.class).a(new TimelineModule.AddFriendListMemberMethodProvider(this, null));
    a(RemoveFriendListMemberMethod.class).a(new TimelineModule.RemoveFriendListMemberMethodProvider(this, null));
    a(FetchFriendListsMethod.class).a(new TimelineModule.FetchFriendListsMethodProvider(this, null));
    a(FetchFriendListsWithMemberMethod.class).a(new TimelineModule.FetchFriendListsWithMemberMethodProvider(this, null));
    a(DeleteStoryMethod.class).a(new TimelineModule.DeleteStoryMethodProvider(this, null));
    a(HideTimelineStoryMethod.class).a(new TimelineModule.HideTimelineStoryMethodProvider(this, null));
    a(TimelineCacheServiceHandler.class).a(new TimelineModule.TimelineCacheServiceHandlerProvider(this, null)).a();
    a(TimelineSectionPreRenderProcessFilter.class).a(new TimelineModule.TimelineSectionPreRenderProcessFilterProvider(this, null)).a();
    a(TimelineServiceHandler.class).a(new TimelineModule.TimelineServiceHandlerProvider(this, null));
    a(TimelineHeaderQueue.class, new TimelineModule.OrcaServiceHandlerForTimelineQueueProvider(this, null));
    a(TimelineSectionQueue.class, new TimelineModule.OrcaServiceHandlerForTimelineQueueProvider(this, null));
    a(TimelineServicesInitializer.class).a(new TimelineModule.TimelineServicesInitializerProvider(this, null));
    a(TimelineUriIntentBuilder.class).a(new TimelineModule.TimelineUriIntentBuilderProvider(this, null)).a();
    c(UriIntentBuilder.class).a(TimelineUriIntentBuilder.class);
    a(TimelineDatabaseInitializer.class).a(new TimelineModule.TimelineDatabaseInitializerProvider(this, null)).a();
    a(TimelineRamCache.class).a(new TimelineModule.TimelineRamCacheProvider(this, null)).a();
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(TimelineServicesInitializer.class).a(TimelineDatabaseInitializer.class);
    a(INeedInit.class, NeedsLowPriorityInitOnUiThread.class);
    a(INeedInit.class, NeedsLowPriorityInitOnBackgroundThread.class);
    c(IHaveUserData.class).a(TimelineCacheServiceHandler.class).a(TimelineDatabaseSupplier.class);
    a(TimelineUserDataCleaner.class).a(new TimelineModule.TimelineUserDataCleanerProvider(this, null)).a();
    b(Boolean.class).a(IsNativeTimelineEnabled.class).a(Boolean.valueOf(false));
    b(Boolean.class).a(IsUFIShareActionEnabled.class).a(Boolean.valueOf(true));
    a(TimelineFragmentFactoryInitializer.class).a(new TimelineModule.TimelineFragmentFactoryInitializerProvider(this, null)).a();
    c(IFragmentFactoryInitializer.class).a(TimelineFragmentFactoryInitializer.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule
 * JD-Core Version:    0.6.0
 */