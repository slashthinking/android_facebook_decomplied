package com.facebook.appcenter.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticCounters;
import com.facebook.appcenter.activity.AppCenterDetailActivity;
import com.facebook.appcenter.cache.AppDetailCache;
import com.facebook.appcenter.data.LoadingStatus;
import com.facebook.appcenter.graphql.model.AppCenterPermissionSummary;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.graphql.model.SimilarAppDetail;
import com.facebook.appcenter.model.AppPrivacyOption;
import com.facebook.appcenter.model.AppPrivacyOptionList;
import com.facebook.appcenter.protocol.FetchAppDetailResult;
import com.facebook.appcenter.service.DeleteAppDetailParams;
import com.facebook.appcenter.service.FetchAppDetailParams;
import com.facebook.appcenter.service.GrantAppGdpParams;
import com.facebook.appcenter.ui.gdp.AppDetailInlineGDPView;
import com.facebook.appcenter.util.AppCenterInlineGDPHelper;
import com.facebook.appcenter.workflow.AppWorkflowManager;
import com.facebook.common.util.Log;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.facebook.widget.UrlImage;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public class AppDetailFragment extends FbFragment
{
  private static Class<?> a = AppDetailFragment.class;
  private static String b = "97534753161";
  private AppDetailInfoCardView Y;
  private AppDetailFriendsAndDescriptionCardView Z;
  private AppDetailScreenshotGalleryView aa;
  private AppDetailInlineGDPView ab;
  private List<SimilarAppDetail> ac;
  private TextView ad;
  private HorizontalImageGallery ae;
  private LayoutInflater af;
  private EmptyListViewItem ag;
  private ScrollView ah;
  private View ai;
  private SafeLocalBroadcastReceiver aj;
  private AppWorkflowManager ak;
  private String al;
  private SafeLocalBroadcastReceiver am;
  private OrcaNetworkManager an;
  private OrcaServiceOperationFactory c;
  private ListenableFuture<OperationResult> d;
  private ListenableFuture<OperationResult> e;
  private ListenableFuture<OperationResult> f;
  private FetchAppDetailResult g;
  private Button h;
  private String i;

  private void K()
  {
    if (TextUtils.isEmpty(this.al))
      Log.a(a, "Try to load app detail on empty app id");
    while (true)
    {
      return;
      a(LoadingStatus.LOADING, 2131362038);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchAppDetailParams", new FetchAppDetailParams(this.al));
      this.d = this.c.a("fetch_app_detail", localBundle).d();
      Futures.a(this.d, new AppDetailFragment.4(this));
    }
  }

  private void L()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("deleteAppDetailParams", new DeleteAppDetailParams(this.al));
    this.f = this.c.a("delete_app_detail", localBundle).d();
    Futures.a(this.f, new AppDetailFragment.6(this));
  }

  private GrantAppGdpParams M()
  {
    List localList = this.g.a().appCenterPermissionSummary.requiredPermissions;
    AppDetailInlineGDPView localAppDetailInlineGDPView = this.ab;
    String str = null;
    if (localAppDetailInlineGDPView != null)
    {
      int j = this.ab.getSelectedPrivacyOptionIndex();
      str = ((AppPrivacyOption)((AppPrivacyOptionList)R().a(AppPrivacyOptionList.class)).get(j)).a();
    }
    return new GrantAppGdpParams(this.al, localList, str);
  }

  private void N()
  {
    String str = "app_center_adp_button_" + this.al;
    AnalyticCounters localAnalyticCounters = (AnalyticCounters)R().a(AnalyticCounters.class);
    Preconditions.checkNotNull(localAnalyticCounters);
    if (localAnalyticCounters != null)
      localAnalyticCounters.a(str, 1L);
  }

  private boolean O()
  {
    AppDetail localAppDetail = this.g.a();
    return ((AppCenterInlineGDPHelper)R().a(AppCenterInlineGDPHelper.class)).a(localAppDetail.isFacebookApp, localAppDetail.viewerHasAuthorized, localAppDetail.appCenterPermissionSummary);
  }

  private void P()
  {
    if (AppWorkflowManager.a)
      this.ak.a(b);
    while (true)
    {
      return;
      if ((this.g != null) && (this.e == null))
      {
        if (!O())
        {
          c(this.g.a().mobileCanvasUrl);
          continue;
        }
        GrantAppGdpParams localGrantAppGdpParams = M();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("grantAppGdpParams", localGrantAppGdpParams);
        this.e = this.c.a("grant_app_gdp", localBundle).d();
        this.h.setText(2131362038);
        this.h.setEnabled(false);
        Futures.a(this.e, new AppDetailFragment.7(this));
        continue;
      }
    }
  }

  private void Q()
  {
    this.aj = new AppDetailFragment.8(this, n(), new IntentFilter("com.facebook.appcenter.workflow.display_state_update"));
    this.aj.a();
  }

  public static AppDetailFragment a(String paramString)
  {
    AppDetailFragment localAppDetailFragment = new AppDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localAppDetailFragment.f(localBundle);
    return localAppDetailFragment;
  }

  private void a(LoadingStatus paramLoadingStatus, int paramInt)
  {
    switch (AppDetailFragment.9.a[paramLoadingStatus.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if (paramInt >= 0)
        this.ag.setMessage(paramInt);
      return;
      this.ag.a(true);
      this.ag.setVisibility(0);
      this.ah.setVisibility(8);
      continue;
      this.ag.a(false);
      this.ag.setVisibility(8);
      this.ah.setVisibility(0);
      continue;
      this.ag.a(false);
      this.ag.setVisibility(8);
      this.ah.setVisibility(8);
      this.ai.setVisibility(0);
    }
  }

  private void a(AppDetail paramAppDetail)
  {
    this.Y.setAppDetailInfo(paramAppDetail);
    this.i = ((String)this.h.getText());
    this.Z.setAppDescription(paramAppDetail.shortDescription, paramAppDetail.detailedDescription);
    this.Z.setFriendsUsing(paramAppDetail.friendsWhoRecentlyUsed, paramAppDetail.isGame);
    this.ab.setAppDetailInfo(paramAppDetail);
    Preconditions.checkNotNull(paramAppDetail.screenshotsAndroid);
    if (paramAppDetail.screenshotsAndroid.size() > 0)
      this.aa.setScreenshots(paramAppDetail.screenshotsAndroid);
    while (true)
    {
      this.ac = paramAppDetail.a();
      a(this.ac);
      String str1 = e(2131362042);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramAppDetail.name;
      String str2 = StringLocaleUtil.b(str1, arrayOfObject);
      this.ad.setText(str2);
      return;
      Preconditions.checkNotNull(paramAppDetail.screenshotsMobileWeb);
      this.aa.setScreenshots(paramAppDetail.screenshotsMobileWeb);
    }
  }

  private void a(String paramString, boolean paramBoolean)
  {
    this.h.setText(paramString);
    this.h.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.h.setTextColor(-16777216);
      this.h.getBackground().setColorFilter(null);
    }
    while (true)
    {
      return;
      this.h.setTextColor(-7829368);
      this.h.getBackground().setColorFilter(Color.parseColor("#aaaaaaaa"), PorterDuff.Mode.SRC_ATOP);
    }
  }

  private void a(List<SimilarAppDetail> paramList)
  {
    if (paramList.size() < 2)
    {
      this.ae.setVisibility(8);
      this.ad.setVisibility(8);
    }
    while (true)
    {
      return;
      this.ae.getItemsContainer().removeAllViews();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      WindowManager localWindowManager = n().getWindowManager();
      Preconditions.checkNotNull(localWindowManager);
      Display localDisplay = localWindowManager.getDefaultDisplay();
      Preconditions.checkNotNull(localDisplay);
      localDisplay.getMetrics(localDisplayMetrics);
      int j = n().getResources().getDimensionPixelSize(2131230749);
      this.ae.getItemsContainer().setPadding(j, 0, j, 0);
      Resources localResources = q();
      Preconditions.checkNotNull(localResources);
      int k = localResources.getDimensionPixelSize(2131230754);
      int m = localResources.getDimensionPixelSize(2131230755);
      this.ae.setItemWidth(k + j);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        SimilarAppDetail localSimilarAppDetail = (SimilarAppDetail)localIterator.next();
        LinearLayout localLinearLayout = (LinearLayout)this.af.inflate(2130903057, null);
        UrlImage localUrlImage = (UrlImage)localLinearLayout.findViewById(2131296368);
        localUrlImage.setPlaceHolderDrawable(null);
        localUrlImage.setScaleType(ImageView.ScaleType.FIT_XY);
        localUrlImage.getImageView().setAdjustViewBounds(true);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, m);
        localUrlImage.setShowProgressBar(true);
        if (localSimilarAppDetail.bannerLogo.get(0) != null)
          localUrlImage.setImageParams(Uri.parse(((GraphQLImage)localSimilarAppDetail.bannerLogo.get(0)).uri));
        localUrlImage.setVisibility(0);
        localUrlImage.setOnClickListener(new AppDetailFragment.5(this, localSimilarAppDetail));
        localUrlImage.setLayoutParams(localLayoutParams);
        localUrlImage.setContentDescription(localSimilarAppDetail.name);
        localLinearLayout.setPadding(0, 0, 0, j);
        this.ae.addView(localLinearLayout);
      }
      this.ae.setVisibility(0);
      this.ad.setVisibility(0);
    }
  }

  private void b(View paramView)
  {
    this.ai = paramView.findViewById(2131296893);
    this.ai.setOnClickListener(new AppDetailFragment.3(this));
  }

  private void b(String paramString)
  {
    Intent localIntent = new Intent(n().getBaseContext(), AppCenterDetailActivity.class);
    localIntent.putExtra("id", paramString);
    n().startActivity(localIntent);
  }

  private void c()
  {
    this.am.a();
  }

  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      L();
    while (true)
    {
      return;
      if (paramString.startsWith("http://"))
        paramString = "https://" + paramString.substring("http://".length());
      Object localObject = paramString + "?fb_source=appcenter_mobile&ref=app_directory&fb_appcenter=1&app_center_enforce=2";
      try
      {
        String str2 = URLEncoder.encode((String)localObject, "UTF-8");
        localObject = str2;
        label85: String str1 = "fb://appcenter/mobile_canvas/f?href=" + (String)localObject;
        n().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str1)));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label85;
      }
    }
  }

  private void d()
  {
    if (this.am != null)
      this.am.b();
  }

  public void B()
  {
    super.B();
    if (this.e == null)
    {
      this.h.setText(this.i);
      this.h.setEnabled(true);
    }
    if ((((AppDetailCache)R().a(AppDetailCache.class)).a(this.al) == null) && (this.d == null))
      K();
  }

  public void D()
  {
    super.D();
    d();
    if (AppWorkflowManager.a)
      this.aj.b();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramBundle != null);
    while (true)
    {
      this.al = paramBundle.getString("id");
      this.af = paramLayoutInflater;
      View localView = paramLayoutInflater.inflate(2130903207, paramViewGroup, false);
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
    this.c = ((OrcaServiceOperationFactory)R().a(OrcaServiceOperationFactory.class));
    this.h = ((Button)i(2131296393));
    this.ae = ((HorizontalImageGallery)i(2131296892));
    this.Y = ((AppDetailInfoCardView)i(2131296887));
    this.Z = ((AppDetailFriendsAndDescriptionCardView)i(2131296889));
    this.aa = ((AppDetailScreenshotGalleryView)i(2131296890));
    this.ab = ((AppDetailInlineGDPView)i(2131296888));
    this.ad = ((TextView)i(2131296891));
    this.ag = ((EmptyListViewItem)i(2131296894));
    this.ah = ((ScrollView)i(2131296886));
    this.h.setOnClickListener(new AppDetailFragment.1(this));
    if (AppWorkflowManager.a)
    {
      this.ak = ((AppWorkflowManager)R().a(AppWorkflowManager.class));
      Preconditions.checkNotNull(this.ak);
      Q();
    }
    this.an = ((OrcaNetworkManager)R().a(OrcaNetworkManager.class));
    Preconditions.checkNotNull(this.an);
    IntentFilter localIntentFilter = new IntentFilter("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED");
    this.am = new AppDetailFragment.2(this, n(), localIntentFilter);
    K();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putString("id", this.al);
  }

  public void f()
  {
    super.f();
    c();
  }

  public void g()
  {
    super.g();
    d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppDetailFragment
 * JD-Core Version:    0.6.0
 */