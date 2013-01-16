package com.facebook.timeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.event.FbEventSubscriberListManager;
import com.facebook.composer.protocol.SimplePhotoUploadParams;
import com.facebook.composer.service.ComposerPublishService;
import com.facebook.composer.service.ComposerPublishService.Publisher;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.annotations.IsNativeNewsfeedSpamReportingEnabled;
import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.feed.cache.PendingStoryCentralCache;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.photos.FeedPhotoStateManager;
import com.facebook.feed.photos.NewsFeedPhotoAnimator;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.feed.protocol.FetchTimelineHeaderParams;
import com.facebook.feed.protocol.ToggleLikeParams;
import com.facebook.feed.protocol.ToggleLikeParams.Builder;
import com.facebook.feed.protocol.UFIService;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.renderer.recycle.FeedRecyclableViewPoolManager;
import com.facebook.feed.ui.FeedAdapterFactory;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedImagePrefetchViewPreloader;
import com.facebook.feed.ui.FeedImageWarmerViewPreloader;
import com.facebook.feed.ui.NewsFeedIncrementalPrefillTask;
import com.facebook.feed.ui.attachments.StoryAttachmentViewFactory;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.feed.util.composer.ComposerActivityReceiver;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.LikeClickedEvent;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackableGraphQLNode;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.task.IncrementalTaskExecutor;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.facebook.timeline.ui.titlebar.ITitleBarController;
import com.facebook.timeline.ui.titlebar.IsTimelineTitleBarControllerUsed;
import com.facebook.widget.BetterListView;
import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.UrlImage.LoadResolutionDuringScrollMode;
import com.facebook.widget.listview.recycle.FbListItemViewPoolManager;
import com.facebook.widget.listview.recycle.ManagedRecycleViewAdapter;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.nineoldandroids.animation.ObjectAnimator;
import java.util.UUID;
import java.util.concurrent.CancellationException;

public class TimelineFragment extends FbFragment
  implements AbsListView.OnScrollListener, AnalyticsActivity, TimelineDataFetcher.BackendFetch, TimelineDataFetcher.ViewCallback
{
  private static final Class<?> c = TimelineFragment.class;
  private ExpandablePhoto Y;
  private TimelineActionMenu Z;
  protected FeedImageLoader a;
  private FeedImagePrefetchViewPreloader aA;
  private FeedImageWarmerViewPreloader aB;
  private FeedNetworkConnectivityReceiver aC;
  private View aa;
  private View ab;
  private TimelineAdapter ac;
  private TimelineDataFetcher ad;
  private TimelineFriendingClient ae;
  private UFIService af;
  private FbListItemViewPoolManager ag;
  private IncrementalTaskExecutor ah;
  private FeedRecyclableViewPoolManager ai;
  private NewsFeedIncrementalPrefillTask aj;
  private FeedPhotoState ak;
  private FeedPhotoStateManager al;
  private FeedEventBus am;
  private FbEventSubscriberListManager an;
  private TimelineFlyoutUfiEventHandler ao;
  private FragmentManager.OnBackStackChangedListener ap;
  private IFeedIntentBuilder aq;
  private GraphQLProfile ar;
  private TimelineHeaderData as;
  private TimelineAllSectionsData at;
  private long au;
  private long av;
  private String aw;
  private String ax;
  private ComposerActivityReceiver ay;
  private FbErrorReporter az;
  protected OrcaNetworkManager b;
  private TimelineAnalyticsLogger d;
  private String e;
  private View f;
  private RefreshableListViewContainer g;
  private BetterListView h;
  private NewsFeedPhotoAnimator i;

  private void M()
  {
    FragmentActivity localFragmentActivity = n();
    ImmutableMap localImmutableMap = ImmutableMap.a(Integer.valueOf(TimelineAdapter.ViewTypes.STORY_BASE.ordinal()), Integer.valueOf(3), Integer.valueOf(TimelineAdapter.ViewTypes.STORY_EDGE_WIDE.ordinal()), Integer.valueOf(3), Integer.valueOf(TimelineAdapter.ViewTypes.STORY_EDGE_NARROW_OR_AGG.ordinal()), Integer.valueOf(3));
    this.ag.a(localFragmentActivity, this.ac.getClass(), this.ac, localImmutableMap);
  }

  private void N()
  {
    if ((this.aa == null) || (this.aa.getVisibility() != 0));
    while (true)
    {
      return;
      View localView = this.aa;
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = (-O());
      ObjectAnimator localObjectAnimator = ObjectAnimator.a(localView, "translationY", arrayOfFloat);
      localObjectAnimator.a(new TimelineFragment.12(this));
      localObjectAnimator.c();
    }
  }

  private int O()
  {
    return p().getResources().getDimensionPixelOffset(2131230780);
  }

  private void P()
  {
    if ((this.ab != null) && (this.ab.getVisibility() != 0))
      if (!this.b.b())
        break label50;
    label50: for (int j = 2131362131; ; j = 2131362130)
    {
      f(j);
      if (this.g != null)
        this.g.d();
      return;
    }
  }

  private void Q()
  {
    TimelineFragment.13 local13 = new TimelineFragment.13(this);
    PendingStoryCache localPendingStoryCache1 = this.at.c();
    PendingStoryCache localPendingStoryCache2 = (PendingStoryCache)R().a(PendingStoryCache.class, PendingStoryCentralCache.class);
    if (this.av == this.au);
    for (boolean bool = true; ; bool = false)
    {
      this.ay = new ComposerActivityReceiver(local13, localPendingStoryCache1, localPendingStoryCache2, bool, n());
      return;
    }
  }

  public static Fragment a(long paramLong, Parcelable paramParcelable, String paramString1, String paramString2)
  {
    TimelineFragment localTimelineFragment = new TimelineFragment();
    Bundle localBundle = new Bundle();
    localBundle.putLong("profile_id", paramLong);
    localBundle.putParcelable("gql_profile", paramParcelable);
    localBundle.putString("timeline_filter", paramString1);
    localBundle.putString("page_access_token", paramString2);
    localTimelineFragment.f(localBundle);
    return localTimelineFragment;
  }

  private void a(UfiEvents.LikeClickedEvent paramLikeClickedEvent)
  {
    FeedbackableGraphQLNode localFeedbackableGraphQLNode = this.at.a(paramLikeClickedEvent.a, paramLikeClickedEvent.b);
    if ((localFeedbackableGraphQLNode == null) || (localFeedbackableGraphQLNode.S() == null))
      this.az.a("timeline_story_like_fail_no_unit", "Could not find a unit in SectionData to modify", false);
    while (true)
    {
      return;
      FeedbackMutator localFeedbackMutator = (FeedbackMutator)R().a(FeedbackMutator.class);
      Feedback localFeedback1 = localFeedbackableGraphQLNode.S();
      Feedback localFeedback2 = localFeedbackMutator.a(localFeedback1, this.ar);
      this.at.a(localFeedbackableGraphQLNode, localFeedback2);
      this.ad.i();
      ToggleLikeParams.Builder localBuilder = ToggleLikeParams.a().a(localFeedback2.legacyApiPostId).a(localFeedback2.doesViewerLike).a(this.ar).a(localFeedback2);
      if ((localFeedbackableGraphQLNode instanceof FeedStory))
        localBuilder.a(new FeedbackLoggingParams(((FeedStory)localFeedbackableGraphQLNode).k(), "timeline_ufi"));
      Futures.a(this.af.a(localBuilder.a()), new TimelineFragment.7(this, localFeedbackableGraphQLNode, localFeedback1));
    }
  }

  private void a(GraphQLProfile paramGraphQLProfile)
  {
    if (paramGraphQLProfile != null)
      this.as.a(paramGraphQLProfile.name, paramGraphQLProfile.profilePicture, paramGraphQLProfile.objectType);
    while (true)
    {
      return;
      if (this.as.f())
      {
        if (this.ar == null)
          continue;
        this.as.a(this.ar.name, this.ar.profilePicture, this.ar.objectType);
        continue;
      }
      if (this.ax == null)
        continue;
      GraphQLProfile localGraphQLProfile = ((GraphQLProfileCache)R().a(GraphQLProfileCache.class)).a(this.au);
      if (localGraphQLProfile == null)
        continue;
      this.as.a(localGraphQLProfile.name, localGraphQLProfile.profilePicture, localGraphQLProfile.objectType);
    }
  }

  private void b(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent.setFlags(65536);
      FragmentActivity localFragmentActivity = n();
      if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
        localFragmentActivity.startActivity(paramIntent);
    }
  }

  private void b(View paramView)
  {
    ((TextView)paramView.findViewById(16908292).findViewById(2131296644)).setText(2131361794);
  }

  private void c(View paramView)
  {
    this.ab = paramView.findViewById(2131296700);
    this.ab.findViewById(2131296701).setOnClickListener(new TimelineFragment.10(this));
  }

  private void d(View paramView)
  {
    this.aa = paramView.findViewById(2131296906);
    this.aa.setOnClickListener(new TimelineFragment.11(this));
  }

  private void f(int paramInt)
  {
    if ((this.aa == null) || (this.aa.getVisibility() == 0));
    while (true)
    {
      return;
      ((TextView)this.aa.findViewById(2131296699)).setText(paramInt);
      this.aa.setVisibility(0);
      View localView = this.aa;
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = (-O());
      arrayOfFloat[1] = 0.0F;
      ObjectAnimator.a(localView, "translationY", arrayOfFloat).c();
    }
  }

  public void B()
  {
    this.az.b("native_timeline", "on");
    if (this.aC != null)
      this.aC.a();
    super.B();
    K();
    this.ad.c();
    if (this.i != null)
      this.i.a(this.Y, p(), this.ak);
    if (this.Z != null)
      this.Z.a();
    if (this.ap != null)
      n().g().a(this.ap);
  }

  public void C()
  {
    this.az.b("native_timeline");
    if (this.aC != null)
      this.aC.b();
    if (this.ap != null)
      n().g().b(this.ap);
    super.C();
  }

  public void D()
  {
    if (this.ay != null)
      this.ay.b();
    if (this.ad != null)
      this.ad.a();
    if (this.ao != null)
      this.ao.b();
    this.ad = null;
    this.as = null;
    this.at = null;
    this.ay = null;
    this.ai = null;
    this.ah = null;
    this.aj = null;
    this.i = null;
    this.Y = null;
    this.am = null;
    this.ao = null;
    this.af = null;
    this.ar = null;
    this.am = null;
    this.an = null;
    this.ap = null;
    this.Z = null;
    this.al.b(this.e);
    super.D();
  }

  public void K()
  {
    this.ao.c();
  }

  public void L()
  {
    this.ad.e();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.f = paramLayoutInflater.inflate(2130903228, paramViewGroup, false);
    this.g = ((RefreshableListViewContainer)this.f.findViewById(2131296970));
    this.g.setOnRefreshListener(new TimelineFragment.8(this));
    this.h = ((BetterListView)this.g.findViewById(16908298));
    this.h.setEmptyView(this.f.findViewById(16908292));
    this.h.setBroadcastInteractionChanges(true);
    if (Build.VERSION.SDK_INT >= 14)
      this.h.setOverScrollMode(2);
    FbInjector localFbInjector = R();
    this.ac = new TimelineAdapter(n(), r(), this.ad, this.ae, this.as, this.at, paramLayoutInflater, (IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class), (IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class), (SecureContextHelper)localFbInjector.a(SecureContextHelper.class), (FbErrorReporter)localFbInjector.a(FbErrorReporter.class), ((Boolean)localFbInjector.a(Boolean.class, IsNativeNewsfeedSpamReportingEnabled.class)).booleanValue());
    this.ag = ((FbListItemViewPoolManager)localFbInjector.a(FbListItemViewPoolManager.class));
    ManagedRecycleViewAdapter localManagedRecycleViewAdapter = ((FeedAdapterFactory)localFbInjector.a(FeedAdapterFactory.class)).a(this.h, this.ac, this.ag);
    this.h.setAdapter(localManagedRecycleViewAdapter);
    this.h.setOnScrollListener(this);
    b(this.f);
    c(this.f);
    d(this.f);
    this.aC = new TimelineFragment.9(this, n());
    if (Build.VERSION.SDK_INT <= 10)
      this.h.setScrollingCacheEnabled(false);
    FeedRendererOptions localFeedRendererOptions = (FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class);
    UserInteractionController localUserInteractionController;
    BetterListView localBetterListView;
    TimelineAdapter localTimelineAdapter;
    FeedImageLoader localFeedImageLoader;
    if ((localFeedRendererOptions.c) || (localFeedRendererOptions.b))
    {
      localUserInteractionController = (UserInteractionController)localFbInjector.a(UserInteractionController.class);
      this.a = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
      if (localFeedRendererOptions.c)
      {
        localBetterListView = this.h;
        localTimelineAdapter = this.ac;
        localFeedImageLoader = this.a;
        if (localFeedRendererOptions.d == UrlImage.LoadResolutionDuringScrollMode.NONE)
          break label477;
      }
    }
    label477: for (boolean bool = true; ; bool = false)
    {
      this.aA = new FeedImagePrefetchViewPreloader(localBetterListView, localTimelineAdapter, localFeedImageLoader, localUserInteractionController, bool);
      if (localFeedRendererOptions.b)
        this.aB = new FeedImageWarmerViewPreloader(this.h, this.ac, this.a, localUserInteractionController);
      return this.f;
    }
  }

  public ListenableFuture<OperationResult> a(String paramString, Bundle paramBundle)
  {
    FbFragmentActivity localFbFragmentActivity = (FbFragmentActivity)n();
    if (localFbFragmentActivity == null)
      throw new CancellationException();
    return ((OrcaServiceOperationFactory)FbInjector.a(localFbFragmentActivity).a(OrcaServiceOperationFactory.class)).a(paramString, paramBundle).d();
  }

  public String a()
  {
    return "timeline";
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
        BLog.e(c, "Unexpected request code received " + paramInt1);
        break;
      case 1756:
        if (!paramIntent.getBooleanExtra("is_uploading_media", false))
        {
          ((ComposerPublishService)R().a(ComposerPublishService.class)).a(paramIntent, ComposerPublishService.Publisher.TIMELINE);
          continue;
        }
        if (!paramIntent.hasExtra("simplePhotoUploadParams"))
          continue;
        SimplePhotoUploadParams localSimplePhotoUploadParams = (SimplePhotoUploadParams)paramIntent.getParcelableExtra("simplePhotoUploadParams");
        if ((localSimplePhotoUploadParams != null) && (this.ax != null))
          localSimplePhotoUploadParams.a(this.ax);
        ((ComposerPublishService)R().a(ComposerPublishService.class)).a(paramIntent, ComposerPublishService.Publisher.TIMELINE);
      }
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.e = UUID.randomUUID().toString();
    this.d = new TimelineAnalyticsLogger(n());
    FbInjector localFbInjector = R();
    this.az = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.b = ((OrcaNetworkManager)localFbInjector.a(OrcaNetworkManager.class));
    Bundle localBundle = m();
    this.av = Long.parseLong((String)localFbInjector.a(String.class, MeUserId.class));
    this.au = localBundle.getLong("profile_id");
    if (this.au < 0L)
      this.au = this.av;
    this.ar = ((GraphQLProfileCache)localFbInjector.a(GraphQLProfileCache.class)).a();
    this.aw = localBundle.getString("timeline_filter");
    this.ax = localBundle.getString("page_access_token");
    this.as = new TimelineHeaderData(this.av, this.au);
    this.at = new TimelineAllSectionsData(this.az);
    Parcelable localParcelable = localBundle.getParcelable("gql_profile");
    if ((localParcelable instanceof GraphQLProfile));
    for (GraphQLProfile localGraphQLProfile = (GraphQLProfile)localParcelable; ; localGraphQLProfile = null)
    {
      a(localGraphQLProfile);
      Display localDisplay = ((WindowManager)localFbInjector.a(WindowManager.class)).getDefaultDisplay();
      int j = Math.max(localDisplay.getWidth(), localDisplay.getHeight());
      int k = Math.min(localDisplay.getWidth(), localDisplay.getHeight());
      this.i = ((NewsFeedPhotoAnimator)localFbInjector.a(NewsFeedPhotoAnimator.class));
      this.ah = ((IncrementalTaskExecutor)R().a(IncrementalTaskExecutor.class));
      this.ai = ((FeedRecyclableViewPoolManager)R().a(FeedRecyclableViewPoolManager.class));
      this.aj = new NewsFeedIncrementalPrefillTask(this, this.ai, (StoryAttachmentViewFactory)R().a(StoryAttachmentViewFactory.class));
      this.ad = new TimelineDataFetcher(n().getApplicationContext(), this, this.au, new FetchTimelineHeaderParams(this.au, k, j), this.at, this.as, this, (TimelineUserDataCleaner)localFbInjector.a(TimelineUserDataCleaner.class), (Clock)localFbInjector.a(Clock.class), this.aw, this.ax);
      this.ae = new TimelineFriendingClient(p(), (FriendingClient)localFbInjector.a(FriendingClient.class), this.as, this.ad);
      this.af = ((UFIService)localFbInjector.a(UFIService.class));
      if (((Boolean)localFbInjector.a(Boolean.class, IsTimelineTitleBarControllerUsed.class)).booleanValue())
        this.Z = new TimelineActionMenu(p(), (ITitleBarController)localFbInjector.a(ITitleBarController.class), this.as, this.ad, (FriendingClient)localFbInjector.a(FriendingClient.class), (IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class), (SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
      this.am = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
      this.aq = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
      this.an = new FbEventSubscriberListManager();
      this.an.a(new TimelineFragment.1(this));
      this.an.a(new TimelineFragment.2(this));
      this.an.a(new TimelineFragment.3(this));
      this.an.a(new TimelineFragment.4(this));
      this.an.a(new TimelineFragment.5(this));
      this.ak = ((FeedPhotoState)localFbInjector.a(FeedPhotoState.class));
      this.al = ((FeedPhotoStateManager)localFbInjector.a(FeedPhotoStateManager.class));
      this.al.a(this.e, this.ak);
      this.ao = new TimelineFlyoutUfiEventHandler(this.at, this.am, (OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class), this.ad);
      if (this.ao != null)
        this.ao.a();
      this.ap = new TimelineFragment.6(this);
      Q();
      this.ad.a(true, false);
      return;
    }
  }

  public void a(DataFreshnessResult paramDataFreshnessResult)
  {
    b();
  }

  public void a(DataFreshnessResult paramDataFreshnessResult, boolean paramBoolean, long paramLong)
  {
    b();
    if (paramBoolean)
      this.d.a(paramDataFreshnessResult, paramLong, this.as.d(), TimelineAnalyticsLogger.a(this.as));
  }

  public void b()
  {
    if (!this.b.b())
      f(2131362130);
    while (true)
    {
      if (this.ac != null)
        this.ac.notifyDataSetChanged();
      if (this.g != null)
        this.g.d();
      return;
      N();
    }
  }

  public void b(DataFreshnessResult paramDataFreshnessResult)
  {
    b();
  }

  public void c()
  {
    if ((this.ab != null) && (this.as.a() == TimelineHeaderData.InitializeState.UNINITIALIZED))
    {
      ((TextView)this.ab.findViewById(2131296703)).setText(2131362131);
      this.ab.setVisibility(0);
    }
    P();
  }

  public void d()
  {
    P();
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.Y = NewsFeedPhotoAnimator.a(n());
  }

  public void f()
  {
    super.f();
    M();
    this.aj.a();
    if (this.an != null)
      this.an.a(this.am);
  }

  public void g()
  {
    super.g();
    this.ad.b();
    this.aj.b();
    this.ag.b();
    if (this.an != null)
      this.an.b(this.am);
  }

  public void h()
  {
    super.h();
    if (this.Z != null)
      this.Z.b();
    if (this.h != null)
      this.h.setAdapter(null);
    this.f = null;
    this.g = null;
    this.h = null;
    this.ac = null;
    this.aa = null;
    this.ab = null;
    this.ag = null;
    this.aA = null;
    this.aB = null;
  }

  public void i()
  {
    if (this.ac != null)
      this.ac.notifyDataSetChanged();
  }

  public void j_()
  {
    P();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.a.a();
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1 - 1;
    TimelineSectionData.ScrollLoadTrigger localScrollLoadTrigger = this.at.a(j, paramInt2);
    if (localScrollLoadTrigger == null);
    while (true)
    {
      return;
      this.at.a(localScrollLoadTrigger);
      TimelineSectionFetcher.Params localParams = new TimelineSectionFetcher.Params();
      localParams.a = localScrollLoadTrigger.a;
      localParams.d = localScrollLoadTrigger.b;
      localParams.f = (-1 + localScrollLoadTrigger.c);
      this.ad.a(localParams);
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFragment
 * JD-Core Version:    0.6.0
 */