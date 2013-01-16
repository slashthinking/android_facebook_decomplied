package com.facebook.feed.ui.permalink;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.event.FbEventSubscriberListManager;
import com.facebook.composer.optimistic.FeedCommentPreview;
import com.facebook.composer.service.ComposerPublishService;
import com.facebook.composer.service.ComposerPublishService.Publisher;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.cache.PendingFeedbackCache;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedStoryMutator.Result;
import com.facebook.feed.data.PagedCommentCollection;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.photos.FeedPhotoStateManager;
import com.facebook.feed.photos.NewsFeedPhotoAnimator;
import com.facebook.feed.protocol.AddCommentParams;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.feed.protocol.FetchNodeListParams;
import com.facebook.feed.protocol.FetchSingleStoryParams;
import com.facebook.feed.protocol.FetchSingleStoryResult;
import com.facebook.feed.protocol.ToggleLikeParams;
import com.facebook.feed.protocol.ToggleLikeParams.Builder;
import com.facebook.feed.protocol.UFIService;
import com.facebook.feed.ui.FeedAdapterFactory;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.ScrollerRunnable;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.feed.util.composer.UniqueRequestIdGenerator;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.FeedStoryComments;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.ErrorCode;
import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.menu.CustomMenuActivityNeedsHandler;
import com.facebook.widget.menu.CustomMenuHandler;
import com.facebook.widget.menu.CustomMenuItem;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.nineoldandroids.animation.ObjectAnimator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.UUID;

public class PermalinkFragment extends FbFragment
  implements AnalyticsActivity, CustomMenuActivityNeedsHandler
{
  private static final Class<?> a = PermalinkFragment.class;
  private int Y;
  private Handler Z;
  private FbErrorReporter aA;
  private FeedImageLoader aB;
  private FeedFragmentOperationsManager aC;
  private FeedPhotoState aD;
  private FeedPhotoStateManager aE;
  private FeedEventBus aF;
  private IFeedIntentBuilder aG;
  private FbEventSubscriberListManager aH;
  private PermalinkFragment.CommentClickSubscriber aI;
  private PermalinkFragment.CommentPostSubscriber aJ;
  private PermalinkFragment.LikeClickSubscriber aK;
  private PermalinkFragment.CommentLikeClickedEventSubscriber aL;
  private PermalinkFragment.SinglePhotoClickedSubscriber aM;
  private PermalinkFragment.SinglePhotoAnimationEndedSubscriber aN;
  private PermalinkFragment.GalleryPhotoClickedSubscriber aO;
  private PermalinkFragment.GalleryPhotoAnimationEndedSubscriber aP;
  private FeedNetworkConnectivityReceiver aa;
  private PermalinkFragment.ErrorBannerType ab = PermalinkFragment.ErrorBannerType.NONE;
  private String ac;
  private String ad;
  private String ae;
  private boolean af;
  private FeedStory ag;
  private PermalinkAdapter ah;
  private OrcaServiceOperationFactory ai;
  private boolean aj;
  private PagedCommentCollection ak;
  private NewsFeedAnalyticsEventBuilder al;
  private AnalyticsLogger am;
  private PerformanceLogger an;
  private CustomMenuHandler ao;
  private AndroidThreadUtil ap;
  private FeedStoryMutator aq;
  private ObjectMapper ar;
  private NewsFeedPhotoAnimator as;
  private ExpandablePhoto at;
  private OrcaNetworkManager au;
  private PendingFeedbackCache av;
  private UniqueRequestIdGenerator aw;
  private FeedAdapterFactory ax;
  private GraphQLProfile ay;
  private UFIService az;
  private RefreshableListViewContainer b;
  private PermalinkListView c;
  private ScrollerRunnable d;
  private Handler e;
  private String f;
  private LinearLayout g;
  private TextView h;
  private ObjectAnimator i;

  private void L()
  {
    Preconditions.checkNotNull(this.ag);
    Preconditions.checkNotNull(this.ah);
    if (this.ag.P())
      this.c.addFooterView(new PermalinkAddReplyView(n(), this.ag.S().legacyApiPostId));
    this.c.setAdapter(this.ah);
  }

  private void M()
  {
    if ((n() == null) || (n().isFinishing()))
      return;
    Preconditions.checkNotNull(this.ag);
    if (this.ak == null)
      this.ak = new PagedCommentCollection(this.av);
    if (this.ah == null)
    {
      this.ah = this.ax.a(this.ag, this.ak);
      this.ah.a(new PermalinkFragment.3(this));
      L();
    }
    while (true)
    {
      if (N())
      {
        this.ak.f();
        this.ak.a(new ArrayList(this.ag.S().comments.comments), this.ag.S().comments.pageInfo);
      }
      this.ah.notifyDataSetChanged();
      this.c.setAdapter(this.ah);
      Bundle localBundle = n().getIntent().getExtras();
      if (localBundle != null)
      {
        String str = localBundle.getString("NNFPerfMarkerIdKey");
        if (str != null)
          this.an.b("NNFStory", str);
      }
      if (this.ag.P())
      {
        if (this.aI == null)
          this.aI = new PermalinkFragment.CommentClickSubscriber(this, null);
        this.aH.a(this.aI);
        if (this.aJ == null)
          this.aJ = new PermalinkFragment.CommentPostSubscriber(this, null);
        this.aH.a(this.aJ);
      }
      if (this.ag.b())
      {
        if (this.aK == null)
          this.aK = new PermalinkFragment.LikeClickSubscriber(this, null);
        this.aH.a(this.aK);
      }
      if (this.aL == null)
        this.aL = new PermalinkFragment.CommentLikeClickedEventSubscriber(this, null);
      this.aH.a(this.aL);
      if (this.aM == null)
        this.aM = new PermalinkFragment.SinglePhotoClickedSubscriber(this, null);
      if (this.aN == null)
        this.aN = new PermalinkFragment.SinglePhotoAnimationEndedSubscriber(this, null);
      if (this.aO == null)
        this.aO = new PermalinkFragment.GalleryPhotoClickedSubscriber(this, null);
      if (this.aP == null)
        this.aP = new PermalinkFragment.GalleryPhotoAnimationEndedSubscriber(this, null);
      this.aH.a(this.aM);
      this.aH.a(this.aN);
      this.aH.a(this.aO);
      this.aH.a(this.aP);
      this.aH.a(this.aF);
      this.aE.a(this.f, this.aD);
      break;
      this.ah.a(this.ag);
    }
  }

  private boolean N()
  {
    if ((this.ag.S() != null) && (this.ag.S().comments != null) && (this.ag.S().comments.comments != null) && (this.ag.S().comments.pageInfo != null) && (!this.ag.S().comments.comments.isEmpty()));
    for (int j = 1; ; j = 0)
      return j;
  }

  private void O()
  {
    this.aj = false;
    if (this.ah != null)
    {
      this.ah.a(false);
      this.ah.notifyDataSetChanged();
    }
  }

  private void P()
  {
    b(PermalinkFragment.ErrorBannerType.NONE, false);
  }

  public static PermalinkFragment a(String paramString)
  {
    return a(paramString, null, null, false);
  }

  public static PermalinkFragment a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2, true);
  }

  public static PermalinkFragment a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    PermalinkFragment localPermalinkFragment = new PermalinkFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("permalink_story_json", paramString1);
    localBundle.putString("story_platform_id", paramString2);
    localBundle.putString("fallback_url", paramString3);
    localBundle.putBoolean("is_platform_id", paramBoolean);
    localPermalinkFragment.f(localBundle);
    return localPermalinkFragment;
  }

  private String a(PermalinkFragment.ErrorBannerType paramErrorBannerType)
  {
    FragmentActivity localFragmentActivity = n();
    String str = null;
    if (localFragmentActivity == null);
    while (true)
    {
      return str;
      switch (PermalinkFragment.11.a[paramErrorBannerType.ordinal()])
      {
      default:
        str = null;
        break;
      case 1:
        str = localFragmentActivity.getResources().getString(2131362130);
        break;
      case 2:
        str = localFragmentActivity.getResources().getString(2131362140);
        break;
      case 3:
        str = localFragmentActivity.getResources().getString(2131362141);
        break;
      case 4:
        str = localFragmentActivity.getResources().getString(2131362142);
      }
    }
  }

  private String a(String paramString, List<GraphQLEntityRange> paramList)
  {
    String str = this.aw.a();
    if (this.ay == null);
    while (true)
    {
      return str;
      FeedComment localFeedComment = FeedCommentPreview.a(this.ay, paramString, paramList);
      this.av.a(str, localFeedComment);
      this.ah.notifyDataSetChanged();
      this.c.setSelection(-1 + this.ak.a());
    }
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    int j = paramInt + this.ah.a();
    int k = this.ah.a();
    int m;
    View localView;
    int i1;
    if (!paramBoolean)
    {
      m = 1;
      int n = m + k - this.c.getFirstVisiblePosition();
      localView = this.c.getChildAt(n);
      if (localView != null)
        break label93;
      i1 = this.c.getChildAt(n - 1).getTop();
      j--;
    }
    while (true)
    {
      this.c.setSelectionFromTop(j, i1);
      return;
      m = 0;
      break;
      label93: i1 = localView.getTop();
    }
  }

  private void a(PermalinkFragment.ErrorBannerType paramErrorBannerType, boolean paramBoolean)
  {
    if (this.g == null);
    while (true)
    {
      return;
      if (this.g.getVisibility() == 0)
      {
        if (this.ab == paramErrorBannerType)
          continue;
        b(paramErrorBannerType, paramBoolean);
        continue;
      }
      this.h.setText(a(paramErrorBannerType));
      this.ab = paramErrorBannerType;
      LinearLayout localLinearLayout = this.g;
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = (-this.Y);
      arrayOfFloat[1] = 0.0F;
      this.i = ObjectAnimator.a(localLinearLayout, "translationY", arrayOfFloat);
      this.i.d(200L);
      this.i.a(new PermalinkFragment.9(this, paramBoolean));
      this.i.c();
    }
  }

  private void a(FeedStory paramFeedStory)
  {
    this.ag = b(paramFeedStory);
    if (paramFeedStory != null)
      M();
  }

  private void a(FeedStory paramFeedStory, Feedback paramFeedback, String paramString, boolean paramBoolean)
  {
    ToggleLikeParams.Builder localBuilder = ToggleLikeParams.a().a(paramFeedback.legacyApiPostId).a(this.ay).a(paramFeedback.doesViewerLike).a(new FeedbackLoggingParams(this.ag.k(), "permalink_ufi")).a(paramFeedback);
    if ((paramBoolean) && (paramFeedStory.S() != null))
      localBuilder.c(paramFeedStory.S().legacyApiPostId);
    ListenableFuture localListenableFuture = this.az.a(localBuilder.a());
    this.am.a(this.al.a(paramString, paramFeedback.legacyApiPostId, String.valueOf(paramFeedback.doesViewerLike)));
    this.aC.a(localListenableFuture);
    this.ap.a(localListenableFuture, new PermalinkFragment.8(this, localListenableFuture, paramFeedStory, paramString, paramFeedback));
  }

  private void a(ServiceException paramServiceException, PermalinkFragment.ErrorBannerType paramErrorBannerType)
  {
    if (paramServiceException.a() == ErrorCode.CONNECTION_FAILURE)
      a(PermalinkFragment.ErrorBannerType.NO_CONNECTION, false);
    while (true)
    {
      return;
      a(paramErrorBannerType, true);
    }
  }

  private void a(DataFreshnessParam paramDataFreshnessParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.ah != null) && (paramBoolean2))
    {
      this.ah.a(true);
      this.ah.notifyDataSetChanged();
    }
    if ((this.aj) || (this.ag == null) || (this.ag.S() == null))
    {
      if (this.b != null)
        this.b.d();
      return;
    }
    this.aj = true;
    Bundle localBundle = new Bundle();
    String str1 = this.ag.S().id;
    String str2;
    label104: String str3;
    if (paramBoolean1)
    {
      str2 = this.ak.c();
      str3 = null;
      if (!paramBoolean1)
        break label206;
    }
    while (true)
    {
      localBundle.putParcelable("fetchCommentsParams", new FetchNodeListParams(str1, 25, str2, str3, paramDataFreshnessParam));
      ListenableFuture localListenableFuture = this.ai.a("fetch_comments", localBundle).d();
      this.aC.a(localListenableFuture);
      this.ap.a(localListenableFuture, new PermalinkFragment.6(this, localListenableFuture, paramBoolean1));
      if (this.b == null)
        break;
      this.b.b();
      break;
      str2 = null;
      break label104;
      label206: str3 = this.ak.d();
    }
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null);
    while (true)
    {
      return;
      FbInjector localFbInjector = R();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable(paramString2, new FetchSingleStoryParams(paramString1, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, true, 25, 25));
      ListenableFuture localListenableFuture = this.ai.a(paramString3, localBundle).d();
      this.aC.a(localListenableFuture);
      this.ap.a(localListenableFuture, new PermalinkFragment.2(this, localListenableFuture, localFbInjector));
    }
  }

  private void a(String paramString1, String paramString2, String paramString3, List<GraphQLEntityRange> paramList)
  {
    if (p() == null)
      this.aA.a("PermalinkDetachedCommentPost", "Permalink fragment is detached when handling a comment post event", true);
    while (true)
    {
      return;
      if ((paramString2 != null) && (!paramString2.equals("")) && (this.ag.P()))
      {
        if (!Objects.equal(this.ag.S().legacyApiPostId, paramString1))
        {
          this.aA.a("PermalinkDoubleComment", "Permalink fragment still subscribed to CommentPostEvent in background.", true);
          continue;
        }
        String str = a(paramString3, paramList);
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("addCommentParams", new AddCommentParams(String.valueOf(this.ag.Q()), paramString2, this.av.a(str), new FeedbackLoggingParams(this.ag.k(), "permalink_ufi")));
        ListenableFuture localListenableFuture = this.ai.a("add_comment", localBundle).d();
        HoneyClientEvent localHoneyClientEvent = this.al.a("comment_request_permalink", paramString2);
        this.am.a(localHoneyClientEvent);
        this.ap.a(localListenableFuture, new PermalinkFragment.7(this, paramString2, str));
        this.c.setSelection(this.c.getBottom());
        continue;
      }
    }
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
      this.ak.f();
    a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, true, paramBoolean);
  }

  private FeedStory b(FeedStory paramFeedStory)
  {
    if (paramFeedStory.a == null);
    while (true)
    {
      return paramFeedStory;
      paramFeedStory = new FeedStoryBuilder(paramFeedStory).a(null).G();
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

  private void b(PermalinkFragment.ErrorBannerType paramErrorBannerType, boolean paramBoolean)
  {
    if (this.g == null);
    while (true)
    {
      return;
      ObjectAnimator localObjectAnimator = this.i;
      float f1 = 0.0F;
      if (localObjectAnimator != null)
      {
        boolean bool = this.i.f();
        f1 = 0.0F;
        if (bool)
        {
          f1 = ((Float)this.i.o()).floatValue();
          this.i.d();
        }
      }
      LinearLayout localLinearLayout = this.g;
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = (-this.Y);
      this.i = ObjectAnimator.a(localLinearLayout, "translationY", arrayOfFloat);
      this.i.d(200L);
      this.i.a(new PermalinkFragment.10(this, paramErrorBannerType, paramBoolean));
      this.i.c();
    }
  }

  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
      P();
    while (true)
    {
      return;
      a(PermalinkFragment.ErrorBannerType.NO_CONNECTION, false);
    }
  }

  private void c(FeedStory paramFeedStory)
  {
    this.ag = this.aq.a(paramFeedStory, this.ay).b();
    this.ah.a(this.ag);
    a(paramFeedStory, this.ag.S(), "permalink_story_like", false);
  }

  public void B()
  {
    super.B();
    if (this.ag != null)
    {
      FetchSingleStoryResult localFetchSingleStoryResult = ((NewsFeedCache)R().a(NewsFeedCache.class)).c(this.ag.cacheId);
      if ((localFetchSingleStoryResult != null) && (localFetchSingleStoryResult.a != null))
      {
        this.ag = b(localFetchSingleStoryResult.a);
        this.ah.a(this.ag);
        this.ah.notifyDataSetChanged();
      }
    }
    a(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, true, false);
    this.as.a(this.at, p(), this.aD);
    this.aH.a(this.aF);
    this.aa.a();
  }

  public void C()
  {
    this.aH.b(this.aF);
    this.aa.b();
    this.aC.a();
    super.C();
  }

  public void D()
  {
    super.D();
    this.aE.b(this.f);
  }

  public void K()
  {
    if (this.ao != null)
    {
      this.ao.d(2131296267);
      if (b())
        this.ao.a(2131296267, 2131362116, 17301560);
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903225, paramViewGroup, false);
    this.g = ((LinearLayout)localView.findViewById(2131296906));
    this.h = ((TextView)localView.findViewById(2131296699));
    this.g.setOnClickListener(new PermalinkFragment.4(this));
    this.b = ((RefreshableListViewContainer)localView.findViewById(2131296964));
    this.c = ((PermalinkListView)this.b.findViewById(16908298));
    if (this.ah != null)
      L();
    this.c.setEmptyView(localView.findViewById(16908292));
    this.d = new ScrollerRunnable(this.c);
    this.e = new Handler();
    this.b.setOnRefreshListener(new PermalinkFragment.5(this));
    return localView;
  }

  public String a()
  {
    return "story_view";
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
        BLog.e(a, "Unexpected request code received " + paramInt1);
        break;
      case 1756:
        ((ComposerPublishService)R().a(ComposerPublishService.class)).a(paramIntent, ComposerPublishService.Publisher.PERMALINK);
      }
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.f = UUID.randomUUID().toString();
    FbInjector localFbInjector = R();
    this.as = ((NewsFeedPhotoAnimator)localFbInjector.a(NewsFeedPhotoAnimator.class));
    this.av = ((PendingFeedbackCache)R().a(PendingFeedbackCache.class));
    this.aw = ((UniqueRequestIdGenerator)R().a(UniqueRequestIdGenerator.class));
    this.ax = ((FeedAdapterFactory)R().a(FeedAdapterFactory.class));
    this.ay = ((GraphQLProfileCache)R().a(GraphQLProfileCache.class)).a();
    this.az = ((UFIService)localFbInjector.a(UFIService.class));
    this.aA = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.aG = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
    this.aB = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
    this.aC = new FeedFragmentOperationsManager();
    this.aD = ((FeedPhotoState)localFbInjector.a(FeedPhotoState.class));
    this.aE = ((FeedPhotoStateManager)localFbInjector.a(FeedPhotoStateManager.class));
    this.aH = new FbEventSubscriberListManager();
  }

  public void a(CustomMenuHandler paramCustomMenuHandler)
  {
    this.ao = paramCustomMenuHandler;
  }

  public void a(CustomMenuItem paramCustomMenuItem)
  {
    if (paramCustomMenuItem.c() == 2131296267)
      c();
  }

  public boolean b()
  {
    FeedStory localFeedStory = this.ag;
    int j = 0;
    if (localFeedStory != null)
    {
      GraphQLActionLink localGraphQLActionLink = this.ag.v();
      j = 0;
      if (localGraphQLActionLink != null)
        j = 1;
    }
    return j;
  }

  public void c()
  {
    ((IFeedIntentBuilder)R().a(IFeedIntentBuilder.class)).a(n(), this.ag.v().url);
  }

  public void d()
  {
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    Bundle localBundle = m();
    this.ac = localBundle.getString("permalink_story_json");
    this.ad = localBundle.getString("story_platform_id");
    this.ae = localBundle.getString("fallback_url");
    this.af = localBundle.getBoolean("is_platform_id");
    this.an = ((PerformanceLogger)R().a(PerformanceLogger.class));
    this.ar = ((ObjectMapper)R().a(ObjectMapper.class));
    FbInjector localFbInjector = R();
    this.ai = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.al = ((NewsFeedAnalyticsEventBuilder)localFbInjector.a(NewsFeedAnalyticsEventBuilder.class));
    this.am = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.ap = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.aq = ((FeedStoryMutator)localFbInjector.a(FeedStoryMutator.class));
    this.aF = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
    this.au = ((OrcaNetworkManager)localFbInjector.a(OrcaNetworkManager.class));
    this.at = NewsFeedPhotoAnimator.a(n());
    FragmentActivity localFragmentActivity = n();
    this.Y = localFragmentActivity.getResources().getDimensionPixelSize(2131230780);
    this.Z = new Handler();
    this.aa = new PermalinkFragment.1(this, localFragmentActivity);
    NewsFeedCache localNewsFeedCache = (NewsFeedCache)localFbInjector.a(NewsFeedCache.class);
    Object localObject2;
    String str2;
    String str3;
    Object localObject1;
    if (this.af)
    {
      FetchSingleStoryResult localFetchSingleStoryResult2 = localNewsFeedCache.b(this.ad);
      if (localFetchSingleStoryResult2 != null)
      {
        localObject2 = localFetchSingleStoryResult2.a;
        str2 = "fetchPlatformStoryParams";
        str3 = "fetch_platform_story";
        localObject1 = this.ad;
        if (localObject2 != null)
          a((FeedStory)localObject2);
        if (localObject1 == null)
          break label562;
        a((String)localObject1, str2, str3);
      }
    }
    while (true)
    {
      return;
      localObject2 = null;
      break;
      if (this.ac != null)
      {
        FeedStory localFeedStory1;
        FetchSingleStoryResult localFetchSingleStoryResult1;
        try
        {
          JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(this.ac);
          localFeedStory1 = (FeedStory)this.ar.readValue(localJsonParser, FeedStory.class);
          localFeedStory1.a(null);
          if (localFeedStory1 == null)
          {
            BLog.e(a, "We came from newsfeed into Permalink with a bad JSON story: " + this.ac);
            n().finish();
          }
        }
        catch (JsonParseException localJsonParseException)
        {
          while (true)
            localFeedStory1 = null;
        }
        catch (IOException localIOException)
        {
          while (true)
            localFeedStory1 = null;
          localFetchSingleStoryResult1 = localNewsFeedCache.c(localFeedStory1.cacheId);
          if (localFetchSingleStoryResult1 == null)
            break label491;
        }
        localObject2 = localFetchSingleStoryResult1.a;
        localObject1 = localFetchSingleStoryResult1.a.id;
        while (true)
        {
          str2 = "fetchGrapgQLStoryParams";
          str3 = "fetch_graphql_story";
          break;
          label491: String str1 = localFeedStory1.id;
          BLog.e(a, "Story could not be found in cache with cacheId: " + localFeedStory1.cacheId);
          FeedStory localFeedStory2 = localFeedStory1;
          localObject1 = str1;
          localObject2 = localFeedStory2;
        }
      }
      BLog.e(a, "There is no information to fetch the feed story.");
      n().finish();
      continue;
      label562: a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, true, false);
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.aB.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment
 * JD-Core Version:    0.6.0
 */