package com.facebook.nearby.places;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.common.util.Toaster;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLProfileList;
import com.facebook.graphql.model.PageStarRatersList;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.nearby.model.NearbyPlaceEdge;
import com.facebook.nearby.model.NearbyTopic;
import com.facebook.nearby.prefs.NearbyPrefKeys;
import com.facebook.nearby.protocol.FetchNearbyPlacesParams;
import com.facebook.nearby.protocol.SearchArea;
import com.facebook.nearby.search.NearbySearchCategoryList;
import com.facebook.nearby.ui.SplitHideableListView;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.IntentUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.OperationResult;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.pages.identity.data.PageIdentityDataBuilder;
import com.facebook.uri.FbUriIntentHandler;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public class NearbyPlacesFragment extends OrcaFragment
  implements NearbyMapAreaFragment.NearbyMapFragmentHost
{
  private static final Class<?> a = NearbyPlacesFragment.class;
  private FbUriIntentHandler Y;
  private AndroidThreadUtil Z;
  private SecureContextHelper aa;
  private OrcaSharedPreferences ab;
  private NearbyPlacesAdapter ac;
  private NearbyMapAreaFragment ad;
  private Resources ae;
  private Button af;
  private ViewGroup ag;
  private TransitionDrawable ah;
  private SplitHideableListView ai;
  private ProgressBar aj;
  private ViewGroup ak;
  private DialogFragment al;
  private ViewGroup am;
  private String an = null;
  private ViewGroup ao;
  private ListenableFuture<OperationResult> ap;
  private NearbyTopic b;
  private List<NearbyPlaceEdge> c;
  private boolean d;
  private OrcaServiceOperationFactory e;
  private NearbyAnalytics f;
  private FragmentManager g;
  private LocationManager h;
  private ConnectivityManager i;

  private void L()
  {
    Location localLocation = this.ad.a();
    if (localLocation == null)
    {
      Toaster.a(p(), p().getResources().getString(2131361893));
      this.f.a(null);
    }
    while (true)
    {
      return;
      ab();
      SearchArea localSearchArea = this.ad.c();
      Intent localIntent = this.Y.a(p(), "fb://nearby/search");
      if (localIntent == null)
      {
        BLog.e(a, "Failed resolving nearby search uri");
        throw new RuntimeException("Missing binding for nearby search URI");
      }
      localIntent.putExtra("user_location", localLocation);
      localIntent.putExtra("search_area", localSearchArea);
      a(localIntent, 1);
    }
  }

  private void M()
  {
    this.aj.setVisibility(0);
    Y();
    this.ac.a();
  }

  private void N()
  {
    this.aj.setVisibility(8);
  }

  private boolean O()
  {
    int j = 1;
    if (!V())
      S();
    while (true)
    {
      return j;
      if (!W())
      {
        R();
        continue;
      }
      j = 0;
    }
  }

  private void P()
  {
    this.ao.setVisibility(0);
    this.ak.setVisibility(8);
  }

  private void R()
  {
    if (!u());
    while (true)
    {
      return;
      if (this.g.a("locationServicesDialog") == null)
      {
        this.ak.setVisibility(8);
        this.ao.setVisibility(0);
        this.al = new NearbyPlacesFragment.LocationSourcesDialogFragment(this.aa, this);
        this.al.a(this.g, "locationServicesDialog");
        continue;
      }
    }
  }

  private void S()
  {
    if (!u());
    while (true)
    {
      return;
      if (this.g.a("networkErrorDialog") == null)
      {
        this.al = new NearbyPlacesFragment.NetworkErrorDialogFragment();
        this.al.a(this.g, "networkErrorDialog");
        continue;
      }
    }
  }

  private void T()
  {
    if (!u());
    while (true)
    {
      return;
      if (this.g.a("emptyResultDialog") == null)
      {
        this.al = new NearbyPlacesFragment.NoResultsDialogFragment();
        this.al.a(this.g, "emptyResultDialog");
        continue;
      }
    }
  }

  private void U()
  {
    this.ao.setVisibility(8);
    this.ak.setVisibility(0);
  }

  private boolean V()
  {
    NetworkInfo localNetworkInfo = this.i.getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting()));
    for (int j = 1; ; j = 0)
      return j;
  }

  private boolean W()
  {
    return this.h.isProviderEnabled("network");
  }

  private void X()
  {
    this.ai.setDivider(this.ae.getDrawable(2131165319));
    int j = (int)TypedValue.applyDimension(1, 1.0F, this.ae.getDisplayMetrics());
    this.ai.setDividerHeight(j);
  }

  private void Y()
  {
    this.ai.setDivider(null);
    this.ai.setDividerHeight(0);
  }

  private void Z()
  {
    this.ab.b().a(NearbyPrefKeys.c, true).a();
  }

  private List<NearbyPlaceEdge> a(List<NearbyPlaceEdge> paramList)
  {
    return Lists.a(Iterables.a(paramList, new NearbyPlacesFragment.7(this)));
  }

  private void aa()
  {
    if ((!this.ab.a(NearbyPrefKeys.c, false)) && (!this.d))
    {
      this.d = true;
      Animation localAnimation = AnimationUtils.loadAnimation(p(), 2130968600);
      this.am.startAnimation(localAnimation);
      this.am.setVisibility(0);
    }
  }

  private void ab()
  {
    this.d = true;
    if (this.am.getVisibility() == 0)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(p(), 2130968601);
      this.am.startAnimation(localAnimation);
      this.am.setVisibility(8);
    }
  }

  private static Intent b(Context paramContext)
  {
    Intent localIntent;
    if (IntentUtil.a(paramContext, "android.settings.LOCATION_SOURCE_SETTINGS"))
      localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    while (true)
    {
      return localIntent;
      boolean bool = IntentUtil.a(paramContext, "android.settings.SETTINGS");
      localIntent = null;
      if (!bool)
        continue;
      localIntent = new Intent("android.settings.SETTINGS");
    }
  }

  private PageIdentityData b(NearbyPlaceEdge paramNearbyPlaceEdge)
  {
    PageIdentityDataBuilder localPageIdentityDataBuilder = new PageIdentityDataBuilder();
    localPageIdentityDataBuilder.a(Long.parseLong(paramNearbyPlaceEdge.place.b())).a(paramNearbyPlaceEdge.place.name).a(paramNearbyPlaceEdge.place.location).a(paramNearbyPlaceEdge.place.address).a(paramNearbyPlaceEdge.place.averageRating).a(paramNearbyPlaceEdge.place.categories).a(paramNearbyPlaceEdge.place.doesViewerLike).b(true);
    if (paramNearbyPlaceEdge.place.raters != null)
      localPageIdentityDataBuilder.a(new PageStarRatersList(paramNearbyPlaceEdge.place.raters.count, null));
    return localPageIdentityDataBuilder.z();
  }

  private static void b(Context paramContext, SecureContextHelper paramSecureContextHelper)
  {
    Intent localIntent = b(paramContext);
    if (localIntent == null)
      Toaster.a(paramContext, paramContext.getResources().getString(2131361902));
    while (true)
    {
      return;
      paramSecureContextHelper.b(localIntent, paramContext);
    }
  }

  public void B()
  {
    super.B();
    ListenableFuture localListenableFuture = this.ad.b();
    this.ac.b();
    this.Z.a(localListenableFuture, new NearbyPlacesFragment.5(this));
    if (!O())
      P();
  }

  public void C()
  {
    super.C();
    if (this.al != null)
      this.al.b();
  }

  public void D()
  {
    super.D();
    this.ad.a(null);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903285, paramViewGroup, false);
  }

  public void a()
  {
    this.ai.a();
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      this.b = ((NearbyTopic)paramIntent.getParcelableExtra("place_category_info"));
      this.af.setText(this.b.a);
      this.f.a(this.b.b, this.an);
      this.c = null;
    }
  }

  public void a(NearbyPlaceEdge paramNearbyPlaceEdge)
  {
    Location localLocation = this.ad.a();
    if (localLocation == null)
    {
      Toaster.a(p(), p().getResources().getString(2131361893));
      this.f.a(null);
    }
    while (true)
    {
      return;
      PageIdentityData localPageIdentityData = b(paramNearbyPlaceEdge);
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramNearbyPlaceEdge.place.id;
      String str = StringLocaleUtil.a("fb://localpage/%s", arrayOfObject1);
      this.f.a(paramNearbyPlaceEdge.place.id, this.an);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("current_location", localLocation);
      localBundle.putString("session_id", this.an);
      localBundle.putParcelable("page_data", localPageIdentityData);
      if (this.Y.a(p(), str, localBundle))
        continue;
      Class localClass = a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramNearbyPlaceEdge.place.id;
      BLog.e(localClass, "Failed navigating to page id = %s ", arrayOfObject2);
    }
  }

  public void a(SearchArea paramSearchArea)
  {
    Location localLocation = this.ad.a();
    if (localLocation == null)
      Toaster.a(p(), p().getResources().getString(2131361893));
    do
    {
      return;
      if (this.ap == null)
        continue;
      this.ap.cancel(false);
    }
    while (O());
    this.ad.a(paramSearchArea);
    NearbyTopic localNearbyTopic = NearbySearchCategoryList.a(p()).a;
    if ((this.b == null) || (this.b.equals(localNearbyTopic)));
    for (FetchNearbyPlacesParams localFetchNearbyPlacesParams = new FetchNearbyPlacesParams(paramSearchArea); ; localFetchNearbyPlacesParams = new FetchNearbyPlacesParams(paramSearchArea, Lists.a(this.b.b)))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchNearbyPlacesParams", localFetchNearbyPlacesParams);
      this.ac.a(Collections.emptyList(), localLocation);
      M();
      this.ap = this.e.a("fetch_nearby_places", localBundle).d();
      this.Z.a(this.ap, new NearbyPlacesFragment.6(this, paramSearchArea));
      break;
    }
  }

  public void b()
  {
    this.ai.b();
  }

  public NearbyAnalytics c()
  {
    return this.f;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (paramBundle != null)
    {
      this.b = ((NearbyTopic)paramBundle.getParcelable("currentTopic"));
      this.c = paramBundle.getParcelableArrayList("curNearbyPlaces");
      this.d = paramBundle.getBoolean("wasSearchButtonNuxShown");
    }
    FbInjector localFbInjector = Q();
    this.g = r();
    this.f = ((NearbyAnalytics)localFbInjector.a(NearbyAnalytics.class));
    this.i = ((ConnectivityManager)localFbInjector.a(ConnectivityManager.class));
    this.h = ((LocationManager)localFbInjector.a(LocationManager.class));
    this.Y = ((FbUriIntentHandler)localFbInjector.a(FbUriIntentHandler.class));
    this.e = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.Z = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.ae = ((Resources)localFbInjector.a(Resources.class));
    this.aa = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.ab = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.ai = ((SplitHideableListView)g(2131297126));
    this.ai.setOnItemClickListener(new NearbyPlacesFragment.1(this));
    this.ai.setExpandableHeader(b(paramBundle).inflate(2130903282, this.ai, false));
    this.ak = ((ViewGroup)g(2131297131));
    this.ak.setOnClickListener(new NearbyPlacesFragment.2(this));
    this.ao = ((RelativeLayout)g(2131297125));
    this.ad = ((NearbyMapAreaFragment)K().a(2131297112));
    this.ad.a(this);
    this.af = ((Button)g(2131297128));
    this.ag = ((ViewGroup)g(2131297127));
    this.ah = ((TransitionDrawable)this.ag.getBackground());
    this.af.setOnClickListener(new NearbyPlacesFragment.3(this));
    this.ac = new NearbyPlacesAdapter(p());
    this.ai.setAdapter(this.ac);
    this.ai.setOnSplitHeightChangedListener(new NearbyPlacesFragment.4(this));
    this.am = ((ViewGroup)g(2131297130));
    this.aj = ((ProgressBar)g(2131297129));
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putParcelable("currentTopic", this.b);
    paramBundle.putBoolean("wasSearchButtonNuxShown", this.d);
    if (this.c != null)
      paramBundle.putParcelableArrayList("curNearbyPlaces", Lists.a(this.c));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesFragment
 * JD-Core Version:    0.6.0
 */