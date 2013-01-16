package com.facebook.feed.ui;

import android.content.Context;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.feed.data.PagedCommentCollection;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.flyout.FeedAggregatedEntitiesAdapter;
import com.facebook.feed.flyout.FeedFlyoutCommentsAdapter;
import com.facebook.feed.flyout.FeedFlyoutLikesAdapter;
import com.facebook.feed.flyout.FlyoutParams;
import com.facebook.feed.photos.NewsFeedPhotoGallery;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.ui.permalink.PermalinkAdapter;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.task.IncrementalTaskExecutor;
import com.facebook.widget.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.recycle.FbListItemViewPoolManager;
import com.facebook.widget.listview.recycle.ManagedRecycleViewAdapter;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class FeedAdapterFactory
{
  private final Context a;
  private final IFeedUnitRenderer b;
  private final IncrementalTaskExecutor c;
  private final FeedEventBus d;
  private final FeedStoryMenuHelper e;
  private final FeedImageLoader f;
  private final MegaphoneStore g;
  private final FbErrorReporter h;
  private final FeedUnitViewFactory i;
  private final OrcaSharedPreferences j;
  private final ExecutorService k;

  public FeedAdapterFactory(Context paramContext, IFeedUnitRenderer paramIFeedUnitRenderer, FeedImageLoader paramFeedImageLoader, IncrementalTaskExecutor paramIncrementalTaskExecutor, FeedEventBus paramFeedEventBus, FeedStoryMenuHelper paramFeedStoryMenuHelper, MegaphoneStore paramMegaphoneStore, FbErrorReporter paramFbErrorReporter, FeedUnitViewFactory paramFeedUnitViewFactory, OrcaSharedPreferences paramOrcaSharedPreferences, ExecutorService paramExecutorService)
  {
    this.a = ((Context)Preconditions.checkNotNull(paramContext));
    this.b = ((IFeedUnitRenderer)Preconditions.checkNotNull(paramIFeedUnitRenderer));
    this.c = paramIncrementalTaskExecutor;
    this.d = paramFeedEventBus;
    this.e = paramFeedStoryMenuHelper;
    this.f = paramFeedImageLoader;
    this.g = paramMegaphoneStore;
    this.h = paramFbErrorReporter;
    this.i = paramFeedUnitViewFactory;
    this.j = paramOrcaSharedPreferences;
    this.k = paramExecutorService;
  }

  public FeedAggregatedEntitiesAdapter a(List<GraphQLProfile> paramList)
  {
    return new FeedAggregatedEntitiesAdapter(paramList);
  }

  public FeedFlyoutCommentsAdapter a(PagedCommentCollection paramPagedCommentCollection, FlyoutParams paramFlyoutParams)
  {
    return new FeedFlyoutCommentsAdapter(this.a, this.d, paramPagedCommentCollection, paramFlyoutParams);
  }

  public FeedFlyoutLikesAdapter a(AppendOnlyGraphQLObjectCollection<GraphQLProfile> paramAppendOnlyGraphQLObjectCollection)
  {
    return new FeedFlyoutLikesAdapter(paramAppendOnlyGraphQLObjectCollection);
  }

  public NewsFeedAdapter a(PagedFeedUnitCollection paramPagedFeedUnitCollection)
  {
    boolean bool = this.j.a(FeedPrefKeys.g, false);
    return new NewsFeedAdapter(this.a, paramPagedFeedUnitCollection, this.b, this.c, this.e, this.g, this.i, bool, this.k, this.h);
  }

  public NewsFeedImageAdapter a(NewsFeedPhotoGallery paramNewsFeedPhotoGallery, List<FeedStoryAttachment> paramList)
  {
    return new NewsFeedImageAdapter(this.a, paramNewsFeedPhotoGallery, this.f, paramList);
  }

  public PermalinkAdapter a(FeedStory paramFeedStory, PagedCommentCollection paramPagedCommentCollection)
  {
    return new PermalinkAdapter(this.a, paramFeedStory, paramPagedCommentCollection);
  }

  public ManagedRecycleViewAdapter a(BetterListView paramBetterListView, FbBaseAdapter paramFbBaseAdapter, FbListItemViewPoolManager paramFbListItemViewPoolManager)
  {
    return new ManagedRecycleViewAdapter(paramBetterListView, paramFbBaseAdapter, paramFbListItemViewPoolManager);
  }

  public ProfileListAdapter b(AppendOnlyGraphQLObjectCollection<GraphQLProfile> paramAppendOnlyGraphQLObjectCollection)
  {
    return new ProfileListAdapter(this.a, paramAppendOnlyGraphQLObjectCollection);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FeedAdapterFactory
 * JD-Core Version:    0.6.0
 */