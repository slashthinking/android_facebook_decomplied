package com.facebook.feed.module;

import android.content.Context;
import com.facebook.abtest.qe.QuickExperimentModule;
import com.facebook.annotations.LibraryPreferencesList;
import com.facebook.composer.ComposerLibModule;
import com.facebook.content.ContentModule;
import com.facebook.feed.NewsFeedIntentUriBuilder;
import com.facebook.feed.activity.FbChromeActivityFragmentFactory;
import com.facebook.feed.activity.NewsFeedFragmentFactoryInitializer;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.annotations.ForNewsfeed;
import com.facebook.feed.annotations.IsNativeNewsFeedEnabled;
import com.facebook.feed.annotations.IsNativeNewsFeedLogFetchErrorsEnabled;
import com.facebook.feed.annotations.IsNativeNewsFeedPrefetchEnabled;
import com.facebook.feed.annotations.IsUFIShareActionEnabled;
import com.facebook.feed.cache.NFCacheServiceHandler;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.feed.cache.PendingStoryCentralCache;
import com.facebook.feed.cache.PendingStoryFragmentCache;
import com.facebook.feed.cache.PrefetchedFeedCache;
import com.facebook.feed.data.ActionLinkListMutator;
import com.facebook.feed.data.ActionLinkMutator;
import com.facebook.feed.data.AttachmentListMutator;
import com.facebook.feed.data.AttachmentMutator;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.data.NewsFeedFragmentDataLoader;
import com.facebook.feed.data.NewsFeedJsonParserInitializer;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.data.ProfileMutator;
import com.facebook.feed.db.NewsFeedDatabaseInitializer;
import com.facebook.feed.db.NewsFeedDbModule;
import com.facebook.feed.db.NewsFeedUserDataCleaner;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import com.facebook.feed.photos.AlbumIndexCache;
import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.photos.FeedPhotoStateManager;
import com.facebook.feed.photos.NewsFeedPhotoAnimation;
import com.facebook.feed.photos.NewsFeedPhotoAnimator;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.feed.protocol.AddCommentMethod;
import com.facebook.feed.protocol.DeleteCommentMethod;
import com.facebook.feed.protocol.FetchCommentsMethod;
import com.facebook.feed.protocol.FetchFeedbackMethod;
import com.facebook.feed.protocol.FetchFriendListFeedMethod;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.feed.protocol.FetchLikersMethod;
import com.facebook.feed.protocol.FetchNewsFeedMethod;
import com.facebook.feed.protocol.FetchPlatformStoryMethod;
import com.facebook.feed.protocol.FetchSingleMediaMethod;
import com.facebook.feed.protocol.NewsFeedMainQueue;
import com.facebook.feed.protocol.NewsFeedPostingQueue;
import com.facebook.feed.protocol.PrefetchNewsFeedMethod;
import com.facebook.feed.protocol.ToggleLikeMethod;
import com.facebook.feed.protocol.UFIService;
import com.facebook.feed.protocol.coupons.ClaimCouponMethod;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.feed.server.FeedUnitPreRenderProcessFilter;
import com.facebook.feed.server.NewsFeedFilterHandler;
import com.facebook.feed.server.NewsFeedServiceHandler;
import com.facebook.feed.service.FeedService;
import com.facebook.feed.ui.FeedAdapterFactory;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedStoryMenuHelper;
import com.facebook.feed.ui.FeedUnitViewFactory;
import com.facebook.feed.ui.attachments.StoryAttachmentViewFactory;
import com.facebook.feed.ui.footer.ShouldDisplayInsightsFooter;
import com.facebook.feed.ui.footer.UFIStyle;
import com.facebook.feed.ui.location.StoryLocationViewFactory;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.feed.util.IFeedStoryImpressionLogger;
import com.facebook.feed.util.composer.UniqueRequestIdGenerator;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.fragment.IFragmentFactoryInitializer;
import com.facebook.graphql.module.GraphQLModule;
import com.facebook.megaphone.module.MegaphoneModule;
import com.facebook.orca.activity.IProvidePreferences;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnUiThread;
import com.facebook.orca.app.IHaveUserData;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.uri.UriIntentBuilder;
import com.facebook.widget.listview.recycle.FbListItemViewPoolManager;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class NewsFeedModule extends AbstractModule
{
  private final Context a;

  public NewsFeedModule(Context paramContext)
  {
    this.a = paramContext;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    e(GraphQLModule.class);
    e(ContentModule.class);
    e(QuickExperimentModule.class);
    a(new ComposerLibModule(this.a));
    a(new NewsFeedDbModule(this.a));
    a(new MegaphoneModule(this.a));
    a(GraphQLStoryHelper.class).a(new NewsFeedModule.GraphQLApiMethodHelperProvider(this, null));
    a(FetchNewsFeedMethod.class).a(new NewsFeedModule.FetchNewsFeedMethodProvider(this, null));
    a(PrefetchNewsFeedMethod.class).a(new NewsFeedModule.PrefetchNewsFeedMethodProvider(this, null));
    a(FetchFriendListFeedMethod.class).a(new NewsFeedModule.FetchFriendListFeedMethodProvider(this, null));
    a(FetchSingleMediaMethod.class).a(new NewsFeedModule.FetchSingleMediaMethodProvider(this, null));
    a(FetchCommentsMethod.class).a(new NewsFeedModule.FetchCommentsMethodProvider(this, null));
    a(FetchLikersMethod.class).a(new NewsFeedModule.FetchLikersMethodProvider(this, null));
    a(FetchFeedbackMethod.class).a(new NewsFeedModule.FetchFeedbackProvider(this, null));
    a(FetchPlatformStoryMethod.class).a(new NewsFeedModule.FetchPlatformStoryMethodProvider(this, null));
    a(FetchGraphQLStoryMethod.class).a(new NewsFeedModule.FetchGraphQLStoryMethodProvider(this, null));
    a(DeleteCommentMethod.class).a(new NewsFeedModule.DeleteCommentMethodProvider(this, null));
    a(AddCommentMethod.class).a(new NewsFeedModule.AddCommentMethodProvider(this, null));
    a(ToggleLikeMethod.class).a(new NewsFeedModule.ToggleLikeMethodProvider(this, null));
    a(UFIService.class).a(new NewsFeedModule.UFIServiceProvider(this, null));
    a(PagedFeedUnitCollection.class).a(new NewsFeedModule.PagedFeedUnitCollectionProvider(this, null));
    a(ClaimCouponMethod.class).a(new NewsFeedModule.ClaimCouponMethodProvider(this, null));
    a(StoryAttachmentViewFactory.class).a(new NewsFeedModule.StoryAttachmentViewFactoryProvider(null)).a();
    a(StoryLocationViewFactory.class).a(new NewsFeedModule.StoryLocationViewFactoryProvider(null)).a();
    a(IFeedUnitRenderer.class).a(new NewsFeedModule.FeedUnitRendererProvider(this, null));
    a(FeedLinkifyUtil.class).a(new NewsFeedModule.FeedLinkifyUtilProvider(this, null)).a();
    a(FeedStoryMenuHelper.class).a(new NewsFeedModule.FeedStoryMenuHelperProvider(this, null));
    a(FlyoutAnimationHandler.class).a(new NewsFeedModule.FlyoutAnimationHandlerProvider(this, null)).a();
    a(FeedPhotoState.class).a(new NewsFeedModule.FeedPhotoStateProvider(this, null));
    a(FeedPhotoStateManager.class).a(new NewsFeedModule.FeedPhotoStateManagerProvider(this, null)).a();
    a(NewsFeedPhotoAnimation.class).a(new NewsFeedModule.NewsFeedPhotoAnimationProvider(this, null)).a();
    a(NewsFeedPhotoAnimator.class).a(new NewsFeedModule.NewsFeedPhotoAnimatorProvider(this, null)).a();
    a(NewsFeedPhotoAnimation.class).a(new NewsFeedModule.NewsFeedPhotoAnimationProvider(this, null)).a();
    a(Boolean.class).a(ShouldDisplayInsightsFooter.class).a(Boolean.valueOf(false));
    a(FeedRendererOptions.class).a(new NewsFeedModule.FeedRendererOptionsProvider(this, null)).e();
    a(FbListItemViewPoolManager.class).a(new NewsFeedModule.FbListItemViewPoolManagerProvider(null)).e();
    a(FeedRecyclableViewPoolManager.class).a(new NewsFeedModule.FeedRecyclableViewPoolManagerProvider(null)).e();
    a(FeedImageLoader.class).a(new NewsFeedModule.FeedImageLoaderProvider(this, null)).e();
    a(UFIStyle.class).a(new NewsFeedModule.UFIStyleProvider(this, null)).e();
    a(FeedEventBus.class).a(new NewsFeedModule.FeedEventHandlerProvider(this, null)).a();
    a(NewsFeedCache.class).a(new NewsFeedModule.NewsFeedCacheProvider(this, null)).a();
    a(PrefetchedFeedCache.class).a(new NewsFeedModule.PrefetchedFeedCacheProvider(this, null)).a();
    a(NFCacheServiceHandler.class).a(new NewsFeedModule.NFCacheServiceHandlerProvider(this, null)).a();
    a(NewsFeedServiceHandler.class).a(new NewsFeedModule.NewsFeedServiceHandlerProvider(this, null));
    a(NewsFeedFilterHandler.class).a(new NewsFeedModule.NewsFeedFilterHandlerProvider(this, null));
    a(FeedStoryMutator.class).a(new NewsFeedModule.FeedStoryMutatorProvider(this, null)).a();
    a(FeedbackMutator.class).a(new NewsFeedModule.FeedbackMutatorProvider(this, null)).a();
    a(AttachmentMutator.class).a(new NewsFeedModule.AttachmentMutatorProvider(this, null)).a();
    a(AttachmentListMutator.class).a(new NewsFeedModule.AttachmentListMutatorProvider(this, null)).a();
    a(ActionLinkMutator.class).a(new NewsFeedModule.ActionLinkMutatorProvider(this, null)).a();
    a(ActionLinkListMutator.class).a(new NewsFeedModule.ActionLinkListMutatorProvider(this, null)).a();
    a(ProfileMutator.class).a(new NewsFeedModule.ProfileMutatorProvider(this, null)).a();
    a(NewsFeedMainQueue.class, new NewsFeedModule.OrcaServiceHandlerForNewsFeedQueueProvider(this, null));
    a(NewsFeedPostingQueue.class, new NewsFeedModule.OrcaServiceHandlerForNewsFeedQueueProvider(this, null));
    a(NewsFeedIntentUriBuilder.class).a(new NewsFeedModule.NewsFeedIntentUriBuilderProvider(this, null)).a();
    c(UriIntentBuilder.class).a(NewsFeedIntentUriBuilder.class);
    a(NewsFeedAnalyticsEventBuilder.class).a(new NewsFeedModule.NewsFeedAnalyticsEventBuilderProvider(this, null)).a();
    a(IFeedStoryImpressionLogger.class).a(new NewsFeedModule.SponsoredStoryImpressionLoggerProvider(this, null));
    a(NewsFeedJsonParserInitializer.class).a(new NewsFeedModule.NewsFeedJsonParserInitializerProvider(this, null));
    a(NewsFeedDatabaseInitializer.class).a(new NewsFeedModule.NewsFeedDatabaseInitializerProvider(this, null)).a();
    a(NewsFeedUserDataCleaner.class).a(new NewsFeedModule.NewsFeedDatabaseCleanerProvider(this, null)).a();
    a(PendingStoryCache.class).a(PendingStoryCentralCache.class).a(new NewsFeedModule.PendingStoryCentralCacheProvider(this, null)).a();
    a(PendingStoryCache.class).a(PendingStoryFragmentCache.class).a(new NewsFeedModule.PendingStoryFragmentCacheProvider(this, null));
    a(UniqueRequestIdGenerator.class).a(new NewsFeedModule.UniqueRequestIdGeneratorProvider(this, null)).a();
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(NewsFeedJsonParserInitializer.class).a(NewsFeedDatabaseInitializer.class);
    a(INeedInit.class, NeedsLowPriorityInitOnUiThread.class);
    a(INeedInit.class, NeedsLowPriorityInitOnBackgroundThread.class).a(NewsFeedServerSuppliedParameters.class);
    c(IHaveUserData.class).a(NewsFeedUserDataCleaner.class);
    a(FeedAdapterFactory.class).a(new NewsFeedModule.FeedAdapterFactoryProvider(this, null));
    a(AlbumIndexCache.class).a(new NewsFeedModule.AlbumIndexCacheProvider(this, null)).a();
    a(FeedUnitViewFactory.class).a(new NewsFeedModule.FeedUnitViewFactoryProvider(this, null));
    a(FeedUnitPreRenderProcessFilter.class).a(new NewsFeedModule.FeedUnitPreRenderProcessFilterProvider(this, null));
    c(IFragmentFactoryInitializer.class);
    a(FbChromeActivityFragmentFactory.class).a(new NewsFeedModule.FbChromeActivityFragmentFactoryProvider(this, null));
    a(NewsFeedFragmentFactoryInitializer.class).a(new NewsFeedModule.NewsFeedFragmentFactoryInitializerProvider(this, null));
    c(IFragmentFactoryInitializer.class).a(NewsFeedFragmentFactoryInitializer.class);
    a(IProvidePreferences.class, LibraryPreferencesList.class).a(IProvidePreferences.class, ForNewsfeed.class);
    a(IProvidePreferences.class).a(ForNewsfeed.class).a(new NewsFeedModule.NativeFeedPreferencesProvider(this, null));
    a(NewsFeedServerSuppliedParameters.class).a(new NewsFeedModule.NewsFeedServerSuppliedParametersProvider(this, null)).a();
    a(NewsFeedFragmentDataLoader.class).a(new NewsFeedModule.NewsFeedFragmentDataLoaderProvider(this, null));
    b(Boolean.class).a(IsNativeNewsFeedEnabled.class).a(Boolean.valueOf(false));
    b(Boolean.class).a(IsNativeNewsFeedPrefetchEnabled.class).a(Boolean.valueOf(false));
    b(Boolean.class).a(IsNativeNewsFeedLogFetchErrorsEnabled.class).a(Boolean.valueOf(false));
    b(Boolean.class).a(IsUFIShareActionEnabled.class).a(Boolean.valueOf(true));
  }

  public void a(FbInjector paramFbInjector)
  {
    OrcaServiceRegistry localOrcaServiceRegistry = (OrcaServiceRegistry)paramFbInjector.a(OrcaServiceRegistry.class);
    localOrcaServiceRegistry.a(NewsFeedMainQueue.class, FeedService.class);
    localOrcaServiceRegistry.a(NewsFeedPostingQueue.class, FeedService.class);
    localOrcaServiceRegistry.a("fetch_news_feed_before", NewsFeedPostingQueue.class);
    localOrcaServiceRegistry.a("prefetch_news_feed", NewsFeedPostingQueue.class);
    localOrcaServiceRegistry.a("fetch_friend_list_feed_before", NewsFeedPostingQueue.class);
    localOrcaServiceRegistry.a("publish_checkin", NewsFeedPostingQueue.class);
    localOrcaServiceRegistry.a("publish_post", NewsFeedPostingQueue.class);
    localOrcaServiceRegistry.a("publish_share", NewsFeedPostingQueue.class);
    localOrcaServiceRegistry.a("clear_cache_after_cursor", NewsFeedPostingQueue.class);
    localOrcaServiceRegistry.a("fetch_news_feed_after", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("fetch_friend_list_feed_after", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("add_comment", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("delete_comment", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("toggle_like", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("toggle_page_like", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("fetch_platform_story", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("fetch_graphql_story", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("fetch_comments", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("fetch_media", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("fetch_likers", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("fetch_feedback", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("claim_coupon", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("fetch_news_feed_updates", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("clear_newsfeed_cache", NewsFeedMainQueue.class);
    localOrcaServiceRegistry.a("mark_impression_logged", NewsFeedMainQueue.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule
 * JD-Core Version:    0.6.0
 */