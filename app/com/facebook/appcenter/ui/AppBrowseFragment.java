package com.facebook.appcenter.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.appcenter.activity.AppCenterDetailActivity;
import com.facebook.appcenter.app.AppCenterDataManager;
import com.facebook.appcenter.data.AppCenterCategoryCollection;
import com.facebook.appcenter.data.LoadingStatus;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.protocol.FetchAppCategoryResult;
import com.facebook.appcenter.protocol.FetchAppListResult;
import com.facebook.appcenter.service.FetchAppCategoryParams;
import com.facebook.appcenter.service.FetchAppListParams;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.facebook.widget.UrlImage;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrowseFragment extends FbFragment
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  public static String a = "category";
  private LayoutInflater Y;
  private FetchAppListResult Z;
  private FetchAppListResult aa;
  private FetchAppCategoryResult ab;
  private OrcaServiceOperationFactory ac;
  private ListenableFuture<OperationResult> ad;
  private ListenableFuture<OperationResult> ae;
  private ListenableFuture<OperationResult> af;
  private String ag;
  private AppBrowseCategoryFilterView ah;
  private EmptyListViewItem ai;
  private RelativeLayout aj;
  private LinearLayout ak;
  private ConcurrentHashMap<String, LoadingStatus> al;
  private AppCenterDataManager am;
  private int an;
  private View ao;
  private SafeLocalBroadcastReceiver ap;
  private OrcaNetworkManager aq;
  private ListView b;
  private HorizontalImageGallery c;
  private ImageView d;
  private float e = 0.0F;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private boolean i = false;

  private void K()
  {
    FetchAppCategoryParams localFetchAppCategoryParams = new FetchAppCategoryParams();
    AppBrowseFragment.2 local2 = new AppBrowseFragment.2(this);
    if (this.ac == null)
      this.ac = ((OrcaServiceOperationFactory)R().a(OrcaServiceOperationFactory.class));
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("fetchAppCategoryParams", localFetchAppCategoryParams);
    this.af = this.ac.a("fetch_app_categories", localBundle).d();
    Futures.a(this.af, local2);
  }

  private void L()
  {
    FetchAppListParams localFetchAppListParams = new FetchAppListParams(FetchAppListParams.a, FetchAppListParams.m);
    AppBrowseFragment.3 local3 = new AppBrowseFragment.3(this);
    a(localFetchAppListParams, this.ae, local3);
  }

  private void M()
  {
    if (this.ag == null)
      this.ag = FetchAppListParams.a;
    FetchAppListParams localFetchAppListParams = new FetchAppListParams(this.ag, FetchAppListParams.o);
    AppBrowseFragment.5 local5 = new AppBrowseFragment.5(this);
    a(localFetchAppListParams, this.ad, local5);
  }

  private void N()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(0L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new AppBrowseFragment.8(this));
    this.ak.startAnimation(localTranslateAnimation);
  }

  public static AppBrowseFragment a(String paramString, int paramInt)
  {
    AppBrowseFragment localAppBrowseFragment = new AppBrowseFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString(a, paramString);
    localBundle.putInt("category_index", paramInt);
    localAppBrowseFragment.f(localBundle);
    return localAppBrowseFragment;
  }

  private void a()
  {
    this.ap.a();
  }

  private void a(View paramView, float paramFloat)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(this.e, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    paramView.startAnimation(localAlphaAnimation);
    this.e = paramFloat;
  }

  private void a(View paramView, boolean paramBoolean)
  {
    if (this.i);
    while (true)
    {
      return;
      if (paramBoolean)
      {
        paramView.setOverScrollMode(0);
        continue;
      }
      paramView.setOverScrollMode(2);
    }
  }

  private void a(LoadingStatus paramLoadingStatus, String paramString)
  {
    boolean bool = true;
    monitorenter;
    while (true)
    {
      try
      {
        this.al.put(paramString, paramLoadingStatus);
        Preconditions.checkNotNull(this.al);
        if (this.al.size() <= 0)
          continue;
        Preconditions.checkArgument(bool);
        Collection localCollection = this.al.values();
        localObject2 = LoadingStatus.SUCCESS;
        Iterator localIterator = localCollection.iterator();
        if (!localIterator.hasNext())
          continue;
        LoadingStatus localLoadingStatus = (LoadingStatus)localIterator.next();
        if (localLoadingStatus != LoadingStatus.LOADING)
          continue;
        localObject2 = LoadingStatus.LOADING;
        int j = AppBrowseFragment.9.a[localObject2.ordinal()];
        switch (j)
        {
        default:
          return;
          bool = false;
          continue;
          if ((localLoadingStatus != LoadingStatus.SUCCESS) || (localObject2 != LoadingStatus.SUCCESS))
            continue;
          localObject3 = LoadingStatus.SUCCESS;
          break label392;
          if (localLoadingStatus != LoadingStatus.FAIL)
            break label388;
          localObject2 = LoadingStatus.FAIL;
          break;
        case 1:
          if (!this.ai.a())
            continue;
          this.ai.a(false);
          if (this.ai.getVisibility() == 8)
            continue;
          this.ai.setVisibility(8);
          if (this.aj.getVisibility() == 0)
            continue;
          this.aj.setVisibility(0);
          continue;
        case 2:
        case 3:
        }
      }
      finally
      {
        monitorexit;
      }
      if (this.ai.a())
        this.ai.a(false);
      if (this.ai.getVisibility() != 8)
        this.ai.setVisibility(8);
      if (this.aj.getVisibility() != 8)
        this.aj.setVisibility(8);
      if (this.ao.getVisibility() == 0)
        continue;
      this.ao.setVisibility(0);
      continue;
      if (!this.ai.a())
        this.ai.a(true);
      if (this.ai.getVisibility() != 0)
        this.ai.setVisibility(0);
      if (this.aj.getVisibility() == 8)
        continue;
      this.aj.setVisibility(8);
      continue;
      label388: Object localObject3 = localObject2;
      label392: Object localObject2 = localObject3;
    }
  }

  private void a(FetchAppListParams paramFetchAppListParams, ListenableFuture<OperationResult> paramListenableFuture, FutureCallback<OperationResult> paramFutureCallback)
  {
    if (this.ac == null)
      this.ac = ((OrcaServiceOperationFactory)R().a(OrcaServiceOperationFactory.class));
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("fetchAppListParams", paramFetchAppListParams);
    Futures.a(this.ac.a("fetch_app_list", localBundle).d(), paramFutureCallback);
  }

  private void a(String paramString)
  {
    Intent localIntent = new Intent(n().getBaseContext(), AppCenterDetailActivity.class);
    localIntent.putExtra("id", paramString);
    n().startActivity(localIntent);
  }

  private void a(List<AppDetail> paramList)
  {
    if (paramList.size() > 0)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      WindowManager localWindowManager = n().getWindowManager();
      Preconditions.checkNotNull(localWindowManager);
      Display localDisplay = localWindowManager.getDefaultDisplay();
      Preconditions.checkNotNull(localDisplay);
      localDisplay.getMetrics(localDisplayMetrics);
      ((AppDetail)paramList.get(0));
      Resources localResources = n().getResources();
      Preconditions.checkNotNull(localResources);
      int j = localResources.getDimensionPixelSize(2131230755);
      int k = localResources.getDimensionPixelSize(2131230754);
      this.c.setItemWidth(k);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        AppDetail localAppDetail = (AppDetail)localIterator.next();
        RelativeLayout localRelativeLayout = (RelativeLayout)this.Y.inflate(2130903048, null);
        UrlImage localUrlImage = (UrlImage)localRelativeLayout.findViewById(2131296368);
        localUrlImage.setPlaceHolderDrawable(null);
        localUrlImage.setScaleType(ImageView.ScaleType.FIT_XY);
        localUrlImage.getImageView().setAdjustViewBounds(true);
        localUrlImage.setLayoutParams(new RelativeLayout.LayoutParams(k, j));
        localUrlImage.setShowProgressBar(true);
        localUrlImage.setImageParams(Uri.parse(((GraphQLImage)localAppDetail.bannerLogo.get(0)).uri));
        localUrlImage.setVisibility(0);
        localUrlImage.setOnClickListener(new AppBrowseFragment.4(this, localAppDetail));
        localUrlImage.setContentDescription(localAppDetail.name);
        localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(k, j));
        this.c.addView(localRelativeLayout);
      }
    }
  }

  private void b()
  {
    if (this.ap != null)
      this.ap.b();
  }

  private void b(View paramView)
  {
    this.ao = paramView.findViewById(2131296879);
    this.ao.setOnClickListener(new AppBrowseFragment.6(this));
  }

  private void c()
  {
    d();
    N();
    M();
    L();
    K();
  }

  private void d()
  {
    this.al = new ConcurrentHashMap();
    this.al.put("list_categories", LoadingStatus.LOADING);
    this.al.put("list_all_apps", LoadingStatus.LOADING);
    this.al.put("list_featured_apps", LoadingStatus.LOADING);
    this.ai.setMessage(2131362038);
    this.aj.setVisibility(8);
    this.ai.setVisibility(0);
    this.ai.a(true);
  }

  public void D()
  {
    super.D();
    b();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramBundle != null);
    while (true)
    {
      this.Y = paramLayoutInflater;
      this.ag = FetchAppListParams.a;
      if (paramBundle != null)
        this.ag = paramBundle.getString(a);
      if (this.ag == null)
        this.ag = FetchAppListParams.a;
      View localView = paramLayoutInflater.inflate(2130903204, paramViewGroup, false);
      this.b = ((ListView)localView.findViewById(2131296872));
      Preconditions.checkNotNull(this.b);
      a(this.b, false);
      this.c = ((HorizontalImageGallery)localView.findViewById(2131296874));
      Preconditions.checkNotNull(this.c);
      this.b.setOnItemClickListener(this);
      b(localView);
      return localView;
      paramBundle = m();
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    AppInitLockHelper.a(n());
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    AppCenterCategoryCollection localAppCenterCategoryCollection = (AppCenterCategoryCollection)R().a(AppCenterCategoryCollection.class);
    Preconditions.checkNotNull(localAppCenterCategoryCollection);
    this.am = ((AppCenterDataManager)R().a(AppCenterDataManager.class));
    Preconditions.checkNotNull(this.am);
    this.aj = ((RelativeLayout)i(2131296871));
    Preconditions.checkNotNull(this.aj);
    this.ai = ((EmptyListViewItem)i(2131296880));
    Preconditions.checkNotNull(this.ai);
    this.ak = ((LinearLayout)i(2131296873));
    Preconditions.checkNotNull(this.ak);
    int j = m().getInt("category_index", 0);
    Preconditions.checkPositionIndex(j, localAppCenterCategoryCollection.a());
    this.an = this.am.b();
    Preconditions.checkPositionIndex(this.an, localAppCenterCategoryCollection.a());
    this.am.a(j);
    this.ah = ((AppBrowseCategoryFilterView)i(2131296876));
    Preconditions.checkNotNull(this.ah);
    this.d = ((ImageView)i(2131296878));
    Preconditions.checkNotNull(this.d);
    a(this.d, 0.0F);
    this.b.setOnScrollListener(this);
    this.aq = ((OrcaNetworkManager)R().a(OrcaNetworkManager.class));
    Preconditions.checkNotNull(this.aq);
    IntentFilter localIntentFilter = new IntentFilter("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED");
    this.ap = new AppBrowseFragment.1(this, n(), localIntentFilter);
    if (Build.VERSION.SDK_INT <= 11);
    for (boolean bool = true; ; bool = false)
    {
      this.i = bool;
      c();
      return;
    }
  }

  public void f()
  {
    super.f();
    a();
  }

  public void g()
  {
    super.g();
    b();
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramAdapterView.getAdapter().getItemViewType(paramInt) == AppBrowseListAdapter.RowType.APP_BROWSE_CARD.ordinal())
    {
      AppDetail localAppDetail = (AppDetail)paramAdapterView.getAdapter().getItem(paramInt);
      Preconditions.checkNotNull(localAppDetail);
      a(localAppDetail.id);
    }
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.g == 0)
      return;
    float f1 = 2.5F * this.d.getHeight();
    if (!this.i);
    for (int j = this.c.getHeight(); ; j = 0)
    {
      int k = this.b.getHeight();
      if ((j <= 0) || (k <= 0) || (f1 <= 0.0F) || (this.b.getChildCount() <= 0))
        break;
      View localView = this.b.getChildAt(0);
      int m = -localView.getTop() + this.b.getFirstVisiblePosition() * localView.getHeight();
      if (m - j > f1)
        a(this.d, 1.0F);
      while (true)
      {
        if ((this.i) || (m > j * 2))
          break label256;
        int n = Math.min(m, j);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.f + this.h, -n + this.h);
        this.f = n;
        localTranslateAnimation.setStartOffset(0L);
        localTranslateAnimation.setDuration(0L);
        localTranslateAnimation.setFillAfter(true);
        this.ak.startAnimation(localTranslateAnimation);
        break;
        if (m < j)
        {
          a(this.d, 0.0F);
          continue;
        }
        a(this.d, (m - j) / f1);
      }
      label256: break;
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.g = paramInt;
    if ((!this.i) && (paramInt == 0))
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.f + this.h, 0.0F);
      localTranslateAnimation.setDuration(0L);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setAnimationListener(new AppBrowseFragment.7(this));
      this.ak.startAnimation(localTranslateAnimation);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseFragment
 * JD-Core Version:    0.6.0
 */