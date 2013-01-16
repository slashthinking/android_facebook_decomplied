package com.facebook.feed.ui;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.data.AbstractDataLoader;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.model.FeedRowType;
import com.facebook.feed.model.FetchRequestState;
import com.facebook.feed.photos.NewsFeedPhotoAnimator;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.task.IncrementalTaskExecutor;
import com.facebook.widget.CachingListViewPreloader;
import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.UrlImage.LoadResolutionDuringScrollMode;
import com.facebook.widget.listview.recycle.FbListItemViewPoolManager;
import com.facebook.widget.listview.recycle.ManagedRecycleViewAdapter;
import com.google.common.collect.ImmutableMap;

public abstract class AbstractFeedFragment extends FbFragment
  implements AbsListView.OnScrollListener, AnalyticsActivity
{
  protected NewsFeedPhotoAnimator Y;
  protected ExpandablePhoto Z;
  protected RefreshableListViewContainer a;
  protected OrcaNetworkManager aa;
  protected boolean ab = true;
  protected int ac = 0;
  protected PagedFeedUnitCollection ad;
  protected FeedImageLoader ae;
  protected FeedImagePrefetchViewPreloader af;
  protected FeedImageWarmerViewPreloader ag;
  protected final Bundle ah = new Bundle(1);
  protected final Bundle ai;
  protected boolean aj = false;
  private FbListItemViewPoolManager ak;
  private FragmentManager.OnBackStackChangedListener al;
  protected CachingListViewPreloader b;
  protected NewsFeedListView c;
  protected NewsFeedAdapter d;
  protected TextView e;
  protected View f;
  protected View g;
  protected NewsFeedAnalyticsEventBuilder h;
  protected AnalyticsLogger i;

  public AbstractFeedFragment()
  {
    this.ah.putBoolean("uui", true);
    this.ai = new Bundle(1);
    this.ai.putBoolean("uui", false);
  }

  private void O()
  {
    N().a(this.ai);
  }

  private FragmentManager.OnBackStackChangedListener P()
  {
    if (this.al == null)
      this.al = new AbstractFeedFragment.6(this);
    return this.al;
  }

  @TargetApi(11)
  private void a(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    float f1 = 0.005F;
    if (Build.VERSION.SDK_INT < 11);
    while (true)
    {
      return;
      if (!paramOrcaSharedPreferences.a(FeedPrefKeys.p, true))
        continue;
      try
      {
        float f5 = Float.parseFloat(paramOrcaSharedPreferences.a(FeedPrefKeys.q, String.valueOf(0.005F)));
        f2 = f5;
        if (f2 <= 0.0F)
        {
          Log.c("AbstractFeedFragment", "The NNF ListView friction is " + f1);
          this.c.setFriction(f1);
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        while (true)
        {
          float f2;
          try
          {
            float f4 = Float.parseFloat(paramOrcaSharedPreferences.a(FeedPrefKeys.r, String.valueOf(1.0F)));
            f3 = f4;
            if (f3 > 0.0F)
              continue;
            f3 = 1.0F;
            Log.c("AbstractFeedFragment", "The NNF ListView velocity scale is " + f3);
            this.c.setVelocityScale(f3);
            break;
            localNumberFormatException1 = localNumberFormatException1;
            Log.a("AbstractFeedFragment", "friction number format error", localNumberFormatException1);
            if (!BuildConstants.a())
              continue;
            Toaster.a(n(), "News Feed: friction setting is not valid number!");
            f2 = f1;
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            Log.a("AbstractFeedFragment", "velocity scale number format error", localNumberFormatException2);
            if (!BuildConstants.a())
              continue;
            Toaster.a(n(), "News Feed: velocity scale setting is not valid number!");
            float f3 = 1.0F;
            continue;
          }
          f1 = f2;
        }
      }
    }
  }

  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    if (paramInt2 > 0)
    {
      j = 0;
      if (paramInt3 > 0)
        break label14;
    }
    while (true)
    {
      return j;
      label14: if (paramInt3 < 15);
      int k = 5 + (paramInt1 + paramInt2);
      j = 0;
      if (k <= paramInt3)
        continue;
      j = 1;
    }
  }

  private boolean a(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getFirstVisiblePosition() < this.d.a());
    for (int j = 1; ; j = 0)
      return j;
  }

  private boolean g(int paramInt)
  {
    if (paramInt >= N().g());
    for (int j = 1; ; j = 0)
      return j;
  }

  public void B()
  {
    n().overridePendingTransition(0, 0);
    super.B();
    O();
    N().a();
    if (P() != null)
      n().g().a(this.al);
  }

  public void C()
  {
    if (this.al != null)
    {
      n().g().b(this.al);
      this.al = null;
    }
    N().d();
    this.d.c();
    super.C();
  }

  public void D()
  {
    N().b();
    super.D();
  }

  protected boolean K()
  {
    if ((this.a != null) && (this.c != null));
    for (int j = 1; ; j = 0)
      return j;
  }

  protected void L()
  {
    N().a(new AbstractFeedFragment.2(this));
  }

  protected void M()
  {
    if (this.d != null)
      this.d.notifyDataSetChanged();
  }

  protected abstract AbstractDataLoader N();

  protected int a(AbstractFeedFragment.ErrorState paramErrorState)
  {
    switch (AbstractFeedFragment.7.b[paramErrorState.ordinal()])
    {
    default:
    case 1:
    }
    for (int j = 2131362131; ; j = 2131362130)
      return j;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool1 = true;
    View localView = paramLayoutInflater.inflate(2130903212, paramViewGroup, false);
    this.a = ((RefreshableListViewContainer)localView.findViewById(2131296903));
    this.a.setOnRefreshListener(new AbstractFeedFragment.1(this));
    this.c = ((NewsFeedListView)this.a.findViewById(16908298));
    this.c.setEmptyView(localView.findViewById(16908292));
    this.c.setOnScrollListener(this);
    FbInjector localFbInjector = R();
    OrcaSharedPreferences localOrcaSharedPreferences = (OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class);
    a(localOrcaSharedPreferences);
    if (Build.VERSION.SDK_INT <= 10)
      this.c.setScrollingCacheEnabled(false);
    this.c.setBroadcastInteractionChanges(bool1);
    boolean bool2 = localOrcaSharedPreferences.a(FeedPrefKeys.f, false);
    boolean bool3 = localOrcaSharedPreferences.a(FeedPrefKeys.h, false);
    ((IncrementalTaskExecutor)localFbInjector.a(IncrementalTaskExecutor.class)).a(bool3);
    boolean bool4 = localOrcaSharedPreferences.a(FeedPrefKeys.B, false);
    this.ad.a(bool4);
    L();
    FeedAdapterFactory localFeedAdapterFactory = (FeedAdapterFactory)localFbInjector.a(FeedAdapterFactory.class);
    this.d = localFeedAdapterFactory.a(this.ad);
    this.ak = ((FbListItemViewPoolManager)localFbInjector.a(FbListItemViewPoolManager.class));
    ManagedRecycleViewAdapter localManagedRecycleViewAdapter = localFeedAdapterFactory.a(this.c, this.d, this.ak);
    this.c.setAdapter(localManagedRecycleViewAdapter);
    FeedRendererOptions localFeedRendererOptions = (FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class);
    UserInteractionController localUserInteractionController = (UserInteractionController)localFbInjector.a(UserInteractionController.class);
    if (bool2)
    {
      this.b = new CachingListViewPreloader(this.c, this.d, localUserInteractionController, bool3);
      this.b.a(bool2);
    }
    this.ae = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
    NewsFeedListView localNewsFeedListView;
    NewsFeedAdapter localNewsFeedAdapter;
    FeedImageLoader localFeedImageLoader;
    if (localFeedRendererOptions.c)
    {
      localNewsFeedListView = this.c;
      localNewsFeedAdapter = this.d;
      localFeedImageLoader = this.ae;
      if (localFeedRendererOptions.d == UrlImage.LoadResolutionDuringScrollMode.NONE)
        break label475;
    }
    while (true)
    {
      this.af = new FeedImagePrefetchViewPreloader(localNewsFeedListView, localNewsFeedAdapter, localFeedImageLoader, localUserInteractionController, bool1);
      if (localFeedRendererOptions.b)
        this.ag = new FeedImageWarmerViewPreloader(this.c, this.d, this.ae, localUserInteractionController);
      this.e = ((TextView)localView.findViewById(2131296832));
      b(localView);
      d(localView);
      c(localView);
      return localView;
      label475: bool1 = false;
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.Y = ((NewsFeedPhotoAnimator)R().a(NewsFeedPhotoAnimator.class));
    this.aj = true;
  }

  protected void b()
  {
    FragmentActivity localFragmentActivity = n();
    ImmutableMap localImmutableMap = ImmutableMap.a(Integer.valueOf(FeedRowType.STORY_BASE.ordinal()), Integer.valueOf(3), Integer.valueOf(FeedRowType.STORY_EDGE_NARROW_OR_AGG.ordinal()), Integer.valueOf(3), Integer.valueOf(FeedRowType.STORY_EDGE_WIDE.ordinal()), Integer.valueOf(3));
    this.ak.a(localFragmentActivity, this.d.getClass(), this.d, localImmutableMap);
  }

  protected void b(View paramView)
  {
    this.g = paramView.findViewById(2131296700);
    this.g.findViewById(2131296701).setOnClickListener(new AbstractFeedFragment.3(this));
  }

  protected void c()
  {
    this.ad.h();
    this.d.notifyDataSetChanged();
  }

  protected void c(View paramView)
  {
    View localView1 = paramView.findViewById(2131296905);
    View localView2 = paramView.findViewById(2131296904);
    localView2.setOnClickListener(new AbstractFeedFragment.4(this));
    this.f = paramView.findViewById(2131296906);
    this.f.setOnClickListener(new AbstractFeedFragment.5(this));
    this.c.setupAnimationViews(paramView.findViewById(2131296875), localView1, paramView.findViewById(2131296878), localView2, this.f);
  }

  protected void d()
  {
    this.ac = 0;
    this.c.c(false);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.Z = NewsFeedPhotoAnimator.a(n());
  }

  protected abstract void d(View paramView);

  public void f()
  {
    super.f();
    if (this.ad.a() > 0)
      b();
  }

  protected void f(int paramInt)
  {
    if ((paramInt <= 0) || (t()))
      return;
    this.ac = (paramInt + this.ac);
    if (g(this.ac))
    {
      TextView localTextView2 = this.e;
      FragmentActivity localFragmentActivity2 = n();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(10);
      localTextView2.setText(localFragmentActivity2.getString(2131362113, arrayOfObject2));
    }
    while (true)
    {
      this.c.c(true);
      break;
      TextView localTextView1 = this.e;
      FragmentActivity localFragmentActivity1 = n();
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(this.ac);
      localTextView1.setText(localFragmentActivity1.getString(2131362112, arrayOfObject1));
    }
  }

  public void g()
  {
    super.g();
    this.ak.b();
  }

  public void h()
  {
    super.h();
    if (this.c != null)
    {
      this.c.setAdapter(null);
      this.c.destroyDrawingCache();
    }
    if (this.a != null)
    {
      this.a.setVisibility(8);
      this.a.destroyDrawingCache();
    }
    this.a = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.g = null;
    this.f = null;
    this.af = null;
    this.ag = null;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!K());
    while (true)
    {
      return;
      this.c.c();
      this.a.setOverflowListOverlap(2131230810);
      this.ae.a();
    }
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a(paramInt1, paramInt2, paramInt3))
      return;
    NewsFeedAdapter localNewsFeedAdapter = this.d;
    if (FetchRequestState.END_OF_FEED == N().a(N().h(), this.ai));
    for (boolean bool = true; ; bool = false)
    {
      localNewsFeedAdapter.a(bool);
      break;
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.ad == null) || (this.d == null));
    while (true)
    {
      return;
      if (paramInt == 0)
      {
        if (paramAbsListView.getLastVisiblePosition() < this.ad.i() + this.d.b())
          c();
        if ((!this.c.d()) && (!a(paramAbsListView)))
          continue;
        d();
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AbstractFeedFragment
 * JD-Core Version:    0.6.0
 */