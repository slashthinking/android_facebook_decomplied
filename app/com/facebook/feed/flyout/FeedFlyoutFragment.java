package com.facebook.feed.flyout;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.TriState;
import com.facebook.composer.mentions.MentionsAutoCompleteTextViewInterface;
import com.facebook.composer.optimistic.FeedCommentPreview;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.cache.PendingFeedbackCache;
import com.facebook.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.data.FeedbackMutator.Result;
import com.facebook.feed.data.PagedCommentCollection;
import com.facebook.feed.protocol.AddCommentParams;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.feed.protocol.FetchFeedbackParams;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.feed.protocol.FetchNodeListParams;
import com.facebook.feed.protocol.FetchSingleMediaParams;
import com.facebook.feed.protocol.FetchSingleStoryParams;
import com.facebook.feed.protocol.ToggleLikeParams;
import com.facebook.feed.protocol.ToggleLikeParams.Builder;
import com.facebook.feed.ui.FeedAdapterFactory;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.feed.ui.SoftKeyboardStateAwareEditTextInterface;
import com.facebook.feed.util.FeedUtils;
import com.facebook.feed.util.composer.UniqueRequestIdGenerator;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FlyoutEvents.CommentLikeActionResultEvent;
import com.facebook.feed.util.event.FlyoutEvents.SetupHeaderViewEvent;
import com.facebook.feed.util.event.UfiEvents.FeedbackUpdatedEvent;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedStoryComments;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.OperationResult;
import com.facebook.widget.flyout.FlyoutFragment;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FeedFlyoutFragment extends FlyoutFragment
{
  private final int Y = 20;
  private final int Z = 0;
  private View aA;
  private View aB;
  private View aC;
  private LayoutInflater aD;
  private ViewGroup aE;
  private int aF;
  private int aG;
  private boolean aH = false;
  private boolean aI = true;
  private boolean aJ = false;
  private boolean aK = false;
  private long aL = -1L;
  private int aM;
  private FlyoutParams aN;
  private Feedback aO;
  private String aP;
  private FeedEventBus aQ;
  private FeedFlyoutFragment.SwitchViewEventSubscriber aR;
  private FeedFlyoutFragment.LikeClickedEventSubscriber aS;
  private FeedFlyoutFragment.FetchPreviousCommentsSubscriber aT;
  private FeedFlyoutFragment.SwitchInlineCommentLikersEventSubscriber aU;
  private FeedFlyoutFragment.CommentLikeClickedEventSubscriber aV;
  private FeedFragmentOperationsManager aW;
  private OrcaServiceOperationFactory aa;
  private GraphQLProfile ab;
  private NewsFeedAnalyticsEventBuilder ac;
  private AnalyticsLogger ad;
  private AndroidThreadUtil ae;
  private Clock af;
  private UniqueRequestIdGenerator ag;
  private FeedbackMutator ah;
  private NewsFeedCache ai;
  private PendingFeedbackCache aj;
  private FeedFlyoutLikesAdapter ak;
  private FeedFlyoutCommentsAdapter al;
  private FeedAggregatedEntitiesAdapter am;
  private AppendOnlyGraphQLObjectCollection<GraphQLProfile> an;
  private PagedCommentCollection ao;
  private FbErrorReporter ap;
  private View aq;
  private View ar;
  private RelativeLayout as;
  private ListView at;
  private ListView au;
  private View av;
  private View aw;
  private EditText ax;
  private TextView ay;
  private View az;
  private final int b = 300;
  private final int c = 36;
  private final int d = 32;
  private final int e = -6;
  private final int f = -12;
  private final int g = -34;
  private final int h = -15;
  private final double i = 1.0D;

  private void K()
  {
    if ((this.aJ) || (this.aK) || (this.aH) || (!s()));
    Bundle localBundle;
    do
    {
      return;
      this.aJ = true;
      this.aK = true;
      localBundle = new Bundle();
    }
    while (this.aN == null);
    String str;
    if (this.aN.e != null)
    {
      str = "fetch_feedback";
      localBundle.putParcelable("fetchFeedbackParams", new FetchFeedbackParams(this.aN.e, 25, 25, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA));
    }
    while (true)
    {
      ListenableFuture localListenableFuture = this.aa.a(str, localBundle).e();
      this.aW.a(localListenableFuture);
      this.ae.a(localListenableFuture, new FeedFlyoutFragment.2(this, localListenableFuture));
      break;
      if (this.aN.d == null)
        break label181;
      localBundle.putParcelable("fetchPlatformStoryParams", new FetchSingleStoryParams(this.aN.d, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, true, 25, 25));
      str = "fetch_platform_story";
    }
    label181: throw new RuntimeException("Neither a legacy api post id or a feedback id exists.");
  }

  private void L()
  {
    if ((this.aJ) || (this.aH) || (!s()));
    while (true)
    {
      return;
      this.aJ = true;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchLikersFeedParams", new FetchNodeListParams(this.aN.e, 25, null, this.an.a(), DataFreshnessParam.STALE_DATA_OKAY));
      ListenableFuture localListenableFuture = this.aa.a("fetch_likers", localBundle).e();
      this.aW.a(localListenableFuture);
      this.ae.a(localListenableFuture, new FeedFlyoutFragment.3(this, localListenableFuture));
    }
  }

  private void M()
  {
    if (Strings.isNullOrEmpty(this.aP));
    while (true)
    {
      return;
      Feedback localFeedback = this.ai.e(this.aP);
      if (localFeedback == null)
        continue;
      b(localFeedback);
      f(localFeedback);
    }
  }

  private void N()
  {
    if ((this.aJ) || (this.aK) || (this.aH) || (!s()) || (Strings.isNullOrEmpty(this.aP)));
    while (true)
    {
      return;
      this.aJ = true;
      this.aK = true;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchMediaParams", new FetchSingleMediaParams(this.aP, 25, 25, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA));
      ListenableFuture localListenableFuture = this.aa.a("fetch_media", localBundle).e();
      this.aW.a(localListenableFuture);
      this.ae.a(localListenableFuture, new FeedFlyoutFragment.4(this, localListenableFuture));
    }
  }

  private void O()
  {
    if ((this.aK) || (this.aH) || (!s()));
    while (true)
    {
      return;
      this.aK = true;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchCommentsParams", new FetchNodeListParams(this.aN.e, 25, this.ao.c(), null, DataFreshnessParam.STALE_DATA_OKAY));
      ListenableFuture localListenableFuture = this.aa.a("fetch_comments", localBundle).e();
      this.aW.a(localListenableFuture);
      this.ae.a(localListenableFuture, new FeedFlyoutFragment.5(this, localListenableFuture));
    }
  }

  private void P()
  {
    if ((this.aK) || (this.aH) || (!s()));
    while (true)
    {
      return;
      this.aK = true;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchCommentsParams", new FetchNodeListParams(this.aN.e, 25, null, this.ao.d(), DataFreshnessParam.STALE_DATA_OKAY));
      ListenableFuture localListenableFuture = this.aa.a("fetch_comments", localBundle).e();
      this.aW.a(localListenableFuture);
      this.ae.a(localListenableFuture, new FeedFlyoutFragment.6(this, localListenableFuture));
    }
  }

  private void Q()
  {
    this.az = this.aD.inflate(2130903213, this.aE, true);
    this.az.setOnClickListener(new FeedFlyoutFragment.7(this));
    this.as = ((RelativeLayout)this.az.findViewById(2131296907));
    this.as.setClickable(false);
    this.az.findViewById(2131296908).setClickable(false);
    this.aA = this.az.findViewById(2131296909);
    this.aC = this.az.findViewById(2131296920);
    a(q().getConfiguration());
    b(q().getConfiguration());
    this.aB = new RelativeLayout(p());
    this.aB.setMinimumHeight(30);
    this.aq = this.az.findViewById(2131296924);
    this.ar = this.az.findViewById(2131296919);
    this.aF = q().getColor(2131165258);
    this.aG = q().getColor(2131165259);
    W();
    X();
    S();
  }

  private void S()
  {
    ((TextView)this.aq.findViewById(2131296504)).setOnClickListener(new FeedFlyoutFragment.8(this));
  }

  private void T()
  {
    this.aC.setVisibility(8);
    Object localObject2;
    String str1;
    Object localObject1;
    if ((this.ax instanceof MentionsAutoCompleteTextViewInterface))
    {
      MentionsAutoCompleteTextViewInterface localMentionsAutoCompleteTextViewInterface = (MentionsAutoCompleteTextViewInterface)this.ax;
      localObject2 = localMentionsAutoCompleteTextViewInterface.getEncodedText();
      str1 = localMentionsAutoCompleteTextViewInterface.getRawText();
      localObject1 = localMentionsAutoCompleteTextViewInterface.getMentionsEntityRanges();
    }
    while (true)
    {
      if ((localObject2 != null) && (!((String)localObject2).equals("")))
      {
        if ((this.aO != null) && (this.aO.canViewerComment))
        {
          String str2 = a(str1, (List)localObject1);
          Bundle localBundle = new Bundle();
          localBundle.putParcelable("addCommentParams", new AddCommentParams(this.aN.d, (String)localObject2, this.aj.a(str2), this.aN.f));
          ListenableFuture localListenableFuture = this.aa.a("add_comment", localBundle).e();
          this.aW.a(localListenableFuture);
          HoneyClientEvent localHoneyClientEvent = this.ac.a("comment_request_flyout", (String)localObject2);
          this.ad.a(localHoneyClientEvent);
          this.ae.a(localListenableFuture, new FeedFlyoutFragment.9(this, localListenableFuture, str2, (String)localObject2));
        }
        this.ax.setText("");
        U();
      }
      return;
      str1 = this.ax.getEditableText().toString();
      localObject1 = Lists.a();
      localObject2 = str1;
    }
  }

  private void U()
  {
    this.ax.setEnabled(false);
    this.ax.clearFocus();
    FeedUtils.a(n());
    this.ay.setTextColor(this.aG);
  }

  private void V()
  {
    this.ax.setEnabled(true);
    this.ay.setTextColor(this.aF);
  }

  private void W()
  {
    this.aw = this.az.findViewById(2131296917);
    this.au = ((ListView)this.az.findViewById(2131296923));
    this.au.setEmptyView(this.az.findViewById(16908292));
    this.au.addFooterView(this.aB);
    this.ax = ((EditText)this.aq.findViewById(2131296503));
    this.ax = FeedUtils.a(n(), this.ax, 2130903099);
    ((SoftKeyboardStateAwareEditTextInterface)this.ax).setOnSoftKeyboardVisibleListener(new FeedFlyoutFragment.10(this));
    this.ax.setImeOptions(6);
    this.ay = ((TextView)this.aq.findViewById(2131296504));
    this.ay.setVisibility(8);
    if (this.ao == null)
      this.ao = new PagedCommentCollection(this.aj);
    if (this.al == null)
      this.al = ((FeedAdapterFactory)R().a(FeedAdapterFactory.class)).a(this.ao, this.aN);
    this.au.setAdapter(this.al);
  }

  private void X()
  {
    this.av = this.az.findViewById(2131296911);
    this.at = ((ListView)this.az.findViewById(2131296916));
    this.at.setEmptyView(this.az.findViewById(16908292));
    this.at.setOnScrollListener(new FeedFlyoutFragment.11(this));
    TextView localTextView = (TextView)this.az.findViewById(2131296914);
    View localView = this.az.findViewById(2131296912);
    FeedFlyoutFragment.12 local12 = new FeedFlyoutFragment.12(this);
    localTextView.setOnClickListener(local12);
    localView.setOnClickListener(local12);
    this.an = new AppendOnlyGraphQLObjectCollection();
    this.ak = ((FeedAdapterFactory)R().a(FeedAdapterFactory.class)).a(this.an);
    this.at.setAdapter(this.ak);
  }

  private void Y()
  {
    a(-12, -34, -15);
  }

  private void Z()
  {
    FeedUtils.a(n());
    this.ax.clearFocus();
    TranslateAnimation localTranslateAnimation1;
    TranslateAnimation localTranslateAnimation2;
    if (this.aI)
    {
      localTranslateAnimation1 = new TranslateAnimation(this.az.getWidth(), 0.0F, 0.0F, 0.0F);
      localTranslateAnimation2 = new TranslateAnimation(0.0F, -1 * this.az.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation1.setAnimationListener(new FeedFlyoutFragment.13(this));
      localTranslateAnimation1.setDuration(300L);
      localTranslateAnimation1.setInterpolator(new AccelerateInterpolator());
      localTranslateAnimation1.setFillAfter(true);
      localTranslateAnimation2.setDuration(300L);
      localTranslateAnimation2.setInterpolator(new AccelerateInterpolator());
      localTranslateAnimation2.setFillAfter(true);
      this.av.setVisibility(0);
      this.av.bringToFront();
      this.av.startAnimation(localTranslateAnimation1);
      this.aw.startAnimation(localTranslateAnimation2);
      if (this.aI)
        break label216;
    }
    label216: for (boolean bool = true; ; bool = false)
    {
      this.aI = bool;
      return;
      localTranslateAnimation1 = new TranslateAnimation(0.0F, this.az.getWidth(), 0.0F, 0.0F);
      localTranslateAnimation2 = new TranslateAnimation(-1 * this.az.getWidth(), 0.0F, 0.0F, 0.0F);
      this.aw.setVisibility(0);
      break;
    }
  }

  private ListenableFuture<OperationResult> a(String paramString1, Feedback paramFeedback, boolean paramBoolean, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("toggleLikeParams", ToggleLikeParams.a().a(paramString1).a(paramFeedback).a(paramBoolean).a(this.aN.f).a(this.ab).c(paramString2).a());
    return this.aa.a("toggle_like", localBundle).e();
  }

  private String a(String paramString, List<GraphQLEntityRange> paramList)
  {
    String str = this.ag.a();
    if (this.ab == null);
    while (true)
    {
      return str;
      FeedComment localFeedComment = FeedCommentPreview.a(this.ab, paramString, paramList);
      this.aj.a(str, localFeedComment);
      this.al.notifyDataSetChanged();
      this.au.setSelection(-1 + this.ao.a());
    }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = q().getDisplayMetrics().density;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.as.getLayoutParams();
    localLayoutParams.topMargin = (int)(0.5F + f1 * paramInt1);
    localLayoutParams.bottomMargin = (int)(0.5F + f1 * paramInt2);
    localLayoutParams.leftMargin = (int)(0.5F + f1 * paramInt3);
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    this.as.setLayoutParams(localLayoutParams);
    this.as.requestLayout();
  }

  private void a(Configuration paramConfiguration)
  {
    int j = 32;
    int k;
    if (paramConfiguration.orientation == 1)
      k = 36;
    while (true)
    {
      a(k, j, -6);
      return;
      k = 0;
      j = 0;
    }
  }

  private void a(FeedComment paramFeedComment)
  {
    FeedbackMutator.Result localResult = this.ah.a(this.aO, paramFeedComment, this.ab);
    Feedback localFeedback = this.aO;
    this.aO = localResult.a;
    FeedComment localFeedComment = localResult.b;
    this.aQ.a(new FlyoutEvents.CommentLikeActionResultEvent(localFeedComment, TriState.UNSET));
    this.ao.b(localFeedComment);
    this.al.notifyDataSetChanged();
    ListenableFuture localListenableFuture = a(localFeedComment.S().legacyApiPostId, localFeedComment.S(), localFeedComment.S().doesViewerLike, localFeedback.d());
    this.ad.a(this.ac.a("feed_flyout_comment_like", localFeedComment.S().legacyApiPostId, String.valueOf(localFeedComment.S().doesViewerLike)));
    this.aW.a(localListenableFuture);
    FeedFlyoutFragment.1 local1 = new FeedFlyoutFragment.1(this, localFeedComment, localListenableFuture, paramFeedComment, localFeedback);
    this.ae.a(localListenableFuture, local1);
  }

  private void a(Feedback paramFeedback)
  {
    if (paramFeedback == null);
    while (true)
    {
      return;
      this.aQ.a(new FlyoutEvents.SetupHeaderViewEvent(paramFeedback));
    }
  }

  private void a(String paramString, Throwable paramThrowable)
  {
    this.ap.a(paramString, paramThrowable.getMessage(), false);
  }

  private void b()
  {
    if (!Strings.isNullOrEmpty(this.aP))
    {
      M();
      N();
    }
    while (true)
    {
      return;
      d();
      K();
      a(this.aO);
    }
  }

  private void b(Configuration paramConfiguration)
  {
    int j = 1;
    float f1 = q().getDisplayMetrics().density;
    if (f1 != 1.0D);
    View localView;
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localView = this.aC.findViewById(2131296921);
      localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    }
    while (localLayoutParams == null);
    if (paramConfiguration.orientation == j);
    while (true)
    {
      int k = 0;
      if (j != 0)
        k = (int)(0.5F + 20.0F * f1);
      localLayoutParams.bottomMargin = k;
      localView.setLayoutParams(localLayoutParams);
      break;
      j = 0;
    }
  }

  private void b(Feedback paramFeedback)
  {
    if (paramFeedback == null)
      return;
    if (this.aN == null)
      a(paramFeedback, null);
    while (true)
    {
      d(paramFeedback);
      c(paramFeedback);
      a(paramFeedback);
      break;
      a(paramFeedback, this.aN.f);
    }
  }

  private void c(Feedback paramFeedback)
  {
    if ((paramFeedback == null) || (paramFeedback.likers == null) || (paramFeedback.likers.likers == null) || (paramFeedback.likers.likers.isEmpty()));
    while (true)
    {
      return;
      FeedStoryLikers localFeedStoryLikers = paramFeedback.likers;
      if (this.at.getAdapter() != this.ak)
        this.at.setAdapter(this.ak);
      this.an.a(localFeedStoryLikers.likers, localFeedStoryLikers.pageInfo);
      this.ak.notifyDataSetChanged();
    }
  }

  private void d()
  {
    if ((this.aN == null) || (Strings.isNullOrEmpty(this.aN.e)));
    while (true)
    {
      return;
      FetchFeedbackResult localFetchFeedbackResult = this.ai.d(this.aN.e);
      if (localFetchFeedbackResult == null)
        continue;
      b(localFetchFeedbackResult.a);
      f(localFetchFeedbackResult.a);
    }
  }

  private void d(Feedback paramFeedback)
  {
    if ((paramFeedback == null) || (paramFeedback.comments == null) || (!paramFeedback.id.equals(this.aN.e)));
    while (true)
    {
      return;
      FeedStoryComments localFeedStoryComments = paramFeedback.comments;
      this.ao.a(new ArrayList(localFeedStoryComments.comments), localFeedStoryComments.pageInfo);
      if ((localFeedStoryComments.comments.size() > 0) && (this.al != null))
        this.al.notifyDataSetChanged();
      if (localFeedStoryComments.count <= 0)
        continue;
      this.aC.setVisibility(8);
    }
  }

  private void e(Feedback paramFeedback)
  {
    if ((paramFeedback == null) || (paramFeedback.comments == null) || (paramFeedback.comments.comments == null) || (paramFeedback.comments.comments.isEmpty()));
    while (true)
    {
      return;
      FeedStoryComments localFeedStoryComments = paramFeedback.comments;
      this.ao.b(new ArrayList(localFeedStoryComments.comments), localFeedStoryComments.pageInfo);
      if (localFeedStoryComments.comments.size() > 0)
        this.al.notifyDataSetChanged();
      if (localFeedStoryComments.count <= 0)
        continue;
      this.aC.setVisibility(8);
    }
  }

  private void f(Feedback paramFeedback)
  {
    int j = 8;
    if ((paramFeedback == null) || (this.aO == null) || (paramFeedback.comments == null) || ((paramFeedback.likeSentence == null) && (paramFeedback.viewerLikersSentence == null) && (paramFeedback.viewerDoesNotLikeSentence == null)) || ((this.aM > 1) && ((paramFeedback.comments.comments == null) || (paramFeedback.comments.comments.size() == 0))))
      return;
    this.aA.setVisibility(j);
    View localView1 = this.aq;
    int k;
    label100: View localView2;
    if (this.aO.canViewerComment)
    {
      k = 0;
      localView1.setVisibility(k);
      localView2 = this.ar;
      if (!this.aO.canViewerComment)
        break label184;
    }
    label184: for (int m = 0; ; m = j)
    {
      localView2.setVisibility(m);
      View localView3 = this.aw;
      if (this.aI)
        j = 0;
      localView3.setVisibility(j);
      if (this.aI)
        break;
      this.av.setVisibility(0);
      this.av.bringToFront();
      break;
      k = j;
      break label100;
    }
  }

  public void B()
  {
    super.B();
    this.aR = new FeedFlyoutFragment.SwitchViewEventSubscriber(this, null);
    this.aS = new FeedFlyoutFragment.LikeClickedEventSubscriber(this, null);
    this.aT = new FeedFlyoutFragment.FetchPreviousCommentsSubscriber(this, null);
    this.aU = new FeedFlyoutFragment.SwitchInlineCommentLikersEventSubscriber(this, null);
    this.aV = new FeedFlyoutFragment.CommentLikeClickedEventSubscriber(this, null);
    this.aQ.a(this.aR);
    this.aQ.a(this.aS);
    this.aQ.a(this.aT);
    this.aQ.a(this.aU);
    this.aQ.a(this.aV);
    b();
  }

  public void C()
  {
    if (this.aW != null)
      this.aW.a();
    if ((this.aO != null) && (this.aO.id != null))
      this.aQ.a(new UfiEvents.FeedbackUpdatedEvent(this.aO.id));
    if (this.aR != null)
    {
      this.aQ.b(this.aR);
      this.aR = null;
    }
    if (this.aS != null)
    {
      this.aQ.b(this.aS);
      this.aS = null;
    }
    if (this.aT != null)
    {
      this.aQ.b(this.aT);
      this.aT = null;
    }
    if (this.aU != null)
    {
      this.aQ.b(this.aU);
      this.aU = null;
    }
    if (this.aV != null)
    {
      this.aQ.b(this.aV);
      this.aV = null;
    }
    if (this.al != null)
      this.al.a();
    super.C();
  }

  public ListenableFuture<Void> a()
  {
    ListenableFuture localListenableFuture = super.a();
    if (s())
    {
      this.aH = true;
      FeedUtils.a(n());
    }
    return localListenableFuture;
  }

  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.aD = paramLayoutInflater;
    this.aE = paramViewGroup;
    FbInjector localFbInjector = R();
    this.ai = ((NewsFeedCache)localFbInjector.a(NewsFeedCache.class));
    this.aQ = ((FeedEventBus)localFbInjector.a(FeedEventBus.class));
    this.af = ((Clock)localFbInjector.a(Clock.class));
    this.ae = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.ag = ((UniqueRequestIdGenerator)localFbInjector.a(UniqueRequestIdGenerator.class));
    this.aa = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.ab = ((GraphQLProfileCache)localFbInjector.a(GraphQLProfileCache.class)).a();
    this.ac = ((NewsFeedAnalyticsEventBuilder)localFbInjector.a(NewsFeedAnalyticsEventBuilder.class));
    this.ad = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.aj = ((PendingFeedbackCache)localFbInjector.a(PendingFeedbackCache.class));
    this.ah = ((FeedbackMutator)localFbInjector.a(FeedbackMutator.class));
    this.ap = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.aW = new FeedFragmentOperationsManager();
  }

  public void a(Feedback paramFeedback, FeedbackLoggingParams paramFeedbackLoggingParams)
  {
    if (paramFeedback == null);
    while (true)
    {
      return;
      this.aO = paramFeedback;
      this.aN = FlyoutParams.a(this.aO, paramFeedbackLoggingParams);
      if ((paramFeedback.comments == null) || (paramFeedback.comments.count == 0))
        continue;
      this.aM = paramFeedback.comments.count;
    }
  }

  public void a(String paramString)
  {
    this.aP = paramString;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (paramBundle != null)
      this.aN = ((FlyoutParams)paramBundle.getParcelable("flyoutParams"));
    Q();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putParcelable("flyoutParams", this.aN);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    a(paramConfiguration);
    b(paramConfiguration);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment
 * JD-Core Version:    0.6.0
 */