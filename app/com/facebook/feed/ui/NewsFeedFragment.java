package com.facebook.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.analytics.performance.PerformanceLogger.MarkerConfig;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.event.FbEventSubscriberListManager;
import com.facebook.composer.service.ComposerPublishService;
import com.facebook.composer.service.ComposerPublishService.Publisher;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.data.AbstractDataLoader;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedStoryMutator.Result;
import com.facebook.feed.data.NewsFeedFragmentDataLoader;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.model.DataLoaderConfig;
import com.facebook.feed.model.FeedType;
import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.photos.FeedPhotoStateManager;
import com.facebook.feed.photos.NewsFeedPhotoAnimator;
import com.facebook.feed.protocol.ClearCacheAfterCursorParams;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.feed.protocol.ToggleLikeParams;
import com.facebook.feed.protocol.ToggleLikeParams.Builder;
import com.facebook.feed.protocol.UFIService;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.feed.ui.attachments.StoryAttachmentViewFactory;
import com.facebook.feed.util.IFeedStoryImpressionLogger;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class NewsFeedFragment extends AbstractFeedFragment
  implements AnalyticsActivity
{
  private static final Class<?> ak = NewsFeedFragment.class;
  private FbEventSubscriberListManager aA;
  private NewsFeedFragment.LikeClickSubscriber aB;
  private NewsFeedFragment.PageLikeClickSubscriber aC;
  private NewsFeedFragment.SinglePhotoClickedSubscriber aD;
  private NewsFeedFragment.SinglePhotoAnimationEndedSubscriber aE;
  private NewsFeedFragment.GalleryPhotoClickedSubscriber aF;
  private NewsFeedFragment.GalleryPhotoAnimationEndedSubscriber aG;
  private NewsFeedFragment.LikeAnimationEndedEventSubscriber aH;
  private FeedFragmentOperationsManager aI;
  private OrcaServiceOperationFactory aJ;
  private PerformanceLogger aK;
  private IFeedIntentBuilder aL;
  private FeedPhotoState aM;
  private FeedPhotoStateManager aN;
  private int al = -1;
  private int am = -1;
  private int an = -1;
  private String ao;
  private NewsFeedFragmentDataLoader ap;
  private IFeedStoryImpressionLogger aq;
  private NewsFeedIncrementalPrefillTask ar;
  private FeedRecyclableViewPoolManager as;
  private AbsListView.OnScrollListener at;
  private GraphQLProfile au;
  private UFIService av;
  private FbErrorReporter aw;
  private FeedEventBus ax;
  private AndroidThreadUtil ay;
  private FeedStoryMutator az;

  private FeedType O()
  {
    Bundle localBundle = m();
    if (localBundle != null);
    for (FeedType localFeedType = (FeedType)localBundle.getParcelable("feed_type"); ; localFeedType = FeedType.b)
      return localFeedType;
  }

  private Intent P()
  {
    Intent localIntent = ((IFeedIntentBuilder)R().a(IFeedIntentBuilder.class)).a(null, null, -1L);
    localIntent.putExtra(ComposerConstants.c, true);
    localIntent.putExtra(ComposerConstants.b, true);
    localIntent.putExtra("nectar_module", "newsfeed_composer");
    return localIntent;
  }

  private Intent Q()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("nectar_module", "newsfeed_composer");
    return ((IFeedIntentBuilder)R().a(IFeedIntentBuilder.class)).a(-1L, true, ak.getSimpleName(), localBundle);
  }

  private Intent S()
  {
    Intent localIntent = ((IFeedIntentBuilder)R().a(IFeedIntentBuilder.class)).b(null, null, -1L);
    localIntent.putExtra("nectar_module", "newsfeed_composer");
    return localIntent;
  }

  private void T()
  {
    long l = SystemClock.b().a();
    this.aK.b("NNFWarmStartToNewsFeedFragmentCreate", null, l);
    this.aK.a(new PerformanceLogger.MarkerConfig("NewsFeedFragmentCreateToFetchNewsFeedSuccess").a(l));
  }

  public static NewsFeedFragment a(FeedType paramFeedType, String paramString)
  {
    NewsFeedFragment localNewsFeedFragment = new NewsFeedFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("feed_type", paramFeedType);
    localBundle.putString("operation_params_key", paramString);
    localNewsFeedFragment.f(localBundle);
    return localNewsFeedFragment;
  }

  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    View localView = paramView.findViewById(paramInt1);
    ((TextView)localView.findViewById(paramInt3)).setText(paramInt2);
    localView.setClickable(true);
    localView.setOnClickListener(new NewsFeedFragment.2(this, paramIntent));
  }

  private void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0);
    do
      return;
    while ((this.al == paramInt1) && (this.am == paramInt1 + paramInt2) && (this.an == paramInt3));
    this.al = paramInt1;
    this.am = (paramInt1 + paramInt2);
    this.an = paramInt3;
    int i = paramInt1;
    label54: Object localObject;
    if (i < paramInt1 + paramInt2)
    {
      localObject = paramAbsListView.getItemAtPosition(i);
      if ((localObject instanceof FeedEdge))
        break label84;
    }
    while (true)
    {
      i++;
      break label54;
      break;
      label84: FeedUnit localFeedUnit = ((FeedEdge)localObject).b();
      if ((localFeedUnit instanceof Sponsorable))
      {
        this.aq.a((Sponsorable)localFeedUnit);
        if ((localFeedUnit instanceof PagesYouMayLikeFeedUnit))
          this.aq.a((PagesYouMayLikeFeedUnit)localFeedUnit);
        ((Sponsorable)localFeedUnit).y();
        continue;
      }
      if (!(localFeedUnit instanceof PeopleYouMayKnowFeedUnit))
        continue;
      this.aq.a((PeopleYouMayKnowFeedUnit)localFeedUnit);
    }
  }

  private void a(FeedStory paramFeedStory)
  {
    if (paramFeedStory == null)
      return;
    FeedStoryMutator.Result localResult = this.az.a(paramFeedStory, this.au);
    FeedStory localFeedStory1 = localResult.b();
    FeedStory localFeedStory2 = this.az.a(localFeedStory1, this.au).a();
    PagedFeedUnitCollection localPagedFeedUnitCollection = this.ad;
    if (localResult.a() == null);
    for (FeedStory localFeedStory3 = localFeedStory1; ; localFeedStory3 = localResult.a())
    {
      localPagedFeedUnitCollection.a(localFeedStory3);
      Feedback localFeedback = localFeedStory1.S();
      ListenableFuture localListenableFuture = this.av.a(ToggleLikeParams.a().a(localFeedback.legacyApiPostId).a(localFeedStory1.D()).a(this.au).a(new FeedbackLoggingParams(localFeedStory1.k(), "newsfeed_ufi")).a(localFeedback).a());
      this.i.a(this.h.a("newsfeed_story_like", localFeedback.legacyApiPostId, String.valueOf(localFeedback.doesViewerLike)));
      this.aI.a(localListenableFuture);
      this.ay.a(localListenableFuture, new NewsFeedFragment.3(this, localListenableFuture, localFeedStory2, paramFeedStory, localFeedback));
      break;
    }
  }

  private void a(FeedStory paramFeedStory, GraphQLActionLink paramGraphQLActionLink)
  {
    FeedStory localFeedStory = this.az.a(paramFeedStory, paramGraphQLActionLink).b();
    this.ad.a(localFeedStory);
    GraphQLProfile localGraphQLProfile = localFeedStory.f().page;
    ToggleLikeParams localToggleLikeParams = ToggleLikeParams.a().a(localGraphQLProfile.id).a(localGraphQLProfile.doesViewerLike).a(new FeedbackLoggingParams(localFeedStory.k(), "newsfeed_ufi")).b(localFeedStory.cacheId).a();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("toggleLikeParams", localToggleLikeParams);
    ListenableFuture localListenableFuture = this.aJ.a("toggle_page_like", localBundle).d();
    this.i.a(this.h.a("newsfeed_page_like", localGraphQLProfile.b(), String.valueOf(localGraphQLProfile.doesViewerLike)));
    this.aI.a(localListenableFuture);
    this.ay.a(localListenableFuture, new NewsFeedFragment.4(this, localListenableFuture, paramFeedStory, localGraphQLProfile));
  }

  public void B()
  {
    super.B();
    if (BuildConstants.a())
      this.aw.b("news_feed_implementation", "native_feed");
    this.aK.b("NNFFragmentCreate");
    if (this.ax != null)
      this.aA.a(this.ax);
    this.Y.a(this.Z, p(), this.aM);
  }

  public void C()
  {
    if (BuildConstants.a())
      this.aw.b("news_feed_implementation");
    this.aK.c("NNFFragmentCreate");
    this.aK.c("NNFFragmentViewCreate");
    if (this.ax != null)
      this.aA.b(this.ax);
    this.aI.a();
    super.C();
  }

  public void D()
  {
    this.aN.b(this.ao);
    super.D();
  }

  protected AbstractDataLoader N()
  {
    return this.ap;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.aK.a("NNFFragmentViewCreate");
    View localView = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.aH == null)
      this.aH = new NewsFeedFragment.LikeAnimationEndedEventSubscriber(this, null);
    this.aA.a(this.aH);
    if (this.aj)
    {
      T();
      this.ap.a(DataFreshnessParam.STALE_DATA_OKAY, 10, this.ai);
    }
    this.aK.b("NNFFragmentViewCreate");
    return localView;
  }

  public String a()
  {
    return "newsfeed";
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1);
    while (true)
    {
      return;
      switch (paramInt1)
      {
      default:
        BLog.e(ak, "Unexpected request code received " + paramInt1);
        break;
      case 1756:
        if (paramIntent.getBooleanExtra("is_uploading_media", false))
          continue;
        ((ComposerPublishService)R().a(ComposerPublishService.class)).a(paramIntent, ComposerPublishService.Publisher.NEWSFEED);
      }
    }
  }

  public void a(Bundle paramBundle)
  {
    FbInjector localFbInjector = R();
    this.aK = ((PerformanceLogger)localFbInjector.a(PerformanceLogger.class));
    this.aK.a("NNFFragmentCreate");
    super.a(paramBundle);
    this.ao = UUID.randomUUID().toString();
    this.ad = ((PagedFeedUnitCollection)localFbInjector.a(PagedFeedUnitCollection.class));
    this.h = ((NewsFeedAnalyticsEventBuilder)localFbInjector.a(NewsFeedAnalyticsEventBuilder.class));
    this.i = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.aa = ((OrcaNetworkManager)localFbInjector.a(OrcaNetworkManager.class));
    this.aq = ((IFeedStoryImpressionLogger)localFbInjector.a(IFeedStoryImpressionLogger.class));
    this.au = ((GraphQLProfileCache)localFbInjector.a(GraphQLProfileCache.class)).a();
    this.av = ((UFIService)localFbInjector.a(UFIService.class));
    this.aw = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.ax = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
    this.aL = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
    this.aN = ((FeedPhotoStateManager)localFbInjector.a(FeedPhotoStateManager.class));
    this.ay = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.az = ((FeedStoryMutator)localFbInjector.a(FeedStoryMutator.class));
    this.aJ = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.aI = new FeedFragmentOperationsManager();
    this.aA = new FbEventSubscriberListManager();
    if (this.aB == null)
      this.aB = new NewsFeedFragment.LikeClickSubscriber(this, null);
    if (this.aC == null)
      this.aC = new NewsFeedFragment.PageLikeClickSubscriber(this, null);
    this.aA.a(this.aB);
    this.aA.a(this.aC);
    if (this.aD == null)
      this.aD = new NewsFeedFragment.SinglePhotoClickedSubscriber(this, null);
    if (this.aE == null)
      this.aE = new NewsFeedFragment.SinglePhotoAnimationEndedSubscriber(this, null);
    if (this.aF == null)
      this.aF = new NewsFeedFragment.GalleryPhotoClickedSubscriber(this, null);
    if (this.aG == null)
      this.aG = new NewsFeedFragment.GalleryPhotoAnimationEndedSubscriber(this, null);
    this.aA.a(this.aD);
    this.aA.a(this.aE);
    this.aA.a(this.aF);
    this.aA.a(this.aG);
    this.aA.a(this.ax);
    this.aM = ((FeedPhotoState)localFbInjector.a(FeedPhotoState.class));
    this.aN.a(this.ao, this.aM);
    Bundle localBundle = m();
    String str = null;
    if (localBundle != null)
      str = localBundle.getString("operation_params_key");
    this.ap = ((NewsFeedFragmentDataLoader)localFbInjector.a(NewsFeedFragmentDataLoader.class));
    this.ap.a(new DataLoaderConfig(O(), this.ad, this.ah, str));
    this.as = ((FeedRecyclableViewPoolManager)localFbInjector.a(FeedRecyclableViewPoolManager.class));
    this.ar = new NewsFeedIncrementalPrefillTask(this, this.as, (StoryAttachmentViewFactory)localFbInjector.a(StoryAttachmentViewFactory.class));
    this.at = new NewsFeedFragment.1(this);
  }

  protected void b()
  {
    super.b();
    this.ar.a();
  }

  protected void c()
  {
    super.c();
    FeedType localFeedType = O();
    String str = this.ad.d();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("clearCacheAfterCursorParamsKey", new ClearCacheAfterCursorParams(localFeedType, str));
    OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.aJ.a("clear_cache_after_cursor", localBundle);
    localOrcaServiceOperation.a(true);
    localOrcaServiceOperation.d();
  }

  protected void d(View paramView)
  {
    View localView = paramView.findViewById(2131296905);
    a(localView, 2131297765, 2131362103, 2131297767, P());
    a(localView, 2131297768, 2131362104, 2131297770, Q());
    a(localView, 2131297771, 2131362105, 2131297773, S());
  }

  public void f()
  {
    super.f();
    this.c.a(this.at);
  }

  public void g()
  {
    super.g();
    this.ar.b();
    if (this.c != null)
      this.c.b(this.at);
  }

  public void h()
  {
    this.aA.b(this.aH);
    super.h();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment
 * JD-Core Version:    0.6.0
 */