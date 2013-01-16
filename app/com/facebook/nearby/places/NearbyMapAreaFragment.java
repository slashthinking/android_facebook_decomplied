package com.facebook.nearby.places;

import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.maps.MapFragment;
import com.facebook.maps.MapFragment.MapOverlayElement;
import com.facebook.maps.MapFragment.MapOverlayElement.OnSelectedListener;
import com.facebook.maps.MapFragmentFactory;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.nearby.model.NearbyPlaceEdge;
import com.facebook.nearby.prefs.NearbyPrefKeys;
import com.facebook.nearby.protocol.SearchArea;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.images.FetchImageExecutor;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Iterator;
import java.util.List;

public class NearbyMapAreaFragment extends OrcaFragment
{
  private static final Class<?> a = NearbyMapAreaFragment.class;
  private String Y = null;
  private SearchArea Z;
  private MapFragment aa;
  private Button ab;
  private ImageButton ac;
  private ImageButton ad;
  private ViewGroup ae;
  private View af;
  private ViewGroup ag;
  private Animation ah;
  private Animation ai;
  private Animation aj;
  private Animation ak;
  private NearbyPlaceDetailsView al;
  private NearbyMapAreaFragment.NearbyMapFragmentHost am;
  private FragmentManager b;
  private FetchImageExecutor c;
  private NearbyMapPinFactory d;
  private AndroidThreadUtil e;
  private OrcaSharedPreferences f;
  private NearbyAnalytics g;
  private List<MapFragment.MapOverlayElement> h;
  private List<NearbyPlaceEdge> i;

  private boolean M()
  {
    int j = 1;
    if ((this.aa == null) || (this.aa.a() == null));
    for (j = 0; ; j = 0)
      do
        return j;
      while ((this.Z == null) || (this.Z.a.distanceTo(this.aa.a()) > 1.0F));
  }

  private void N()
  {
    this.aa = ((MapFragment)this.b.a("nearbyMapFragment"));
    if (this.aa == null)
    {
      this.aa = ((MapFragmentFactory)Q().a(MapFragmentFactory.class)).a(false);
      this.aa.a(17.0D);
      this.aa.b(true);
      this.aa.a(true);
      FragmentTransaction localFragmentTransaction = this.b.a();
      localFragmentTransaction.a(2131297133, this.aa, "nearbyMapFragment");
      localFragmentTransaction.a();
    }
    GestureDetector localGestureDetector = new GestureDetector(p(), new NearbyMapAreaFragment.10(this));
    this.aa.a(new NearbyMapAreaFragment.11(this, localGestureDetector));
  }

  private void O()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      MapFragment.MapOverlayElement localMapOverlayElement = (MapFragment.MapOverlayElement)localIterator.next();
      this.aa.b(localMapOverlayElement);
    }
    this.h = Lists.a();
  }

  private void P()
  {
    this.al.setVisibility(8);
  }

  private int R()
  {
    float f1 = this.aa.M().distanceTo(this.aa.O()) / 2.0F;
    return (int)Math.floor(Math.min(this.aa.M().distanceTo(this.aa.N()) / 2.0F, f1));
  }

  private void S()
  {
    if (M())
      if (this.ab.getVisibility() != 0)
      {
        this.aj.reset();
        this.ab.startAnimation(this.aj);
        this.ab.setVisibility(0);
      }
    while (true)
    {
      return;
      if (this.ab.getVisibility() == 0)
      {
        this.ak.reset();
        this.ab.startAnimation(this.ak);
        this.ab.setVisibility(8);
        continue;
      }
    }
  }

  private void T()
  {
    this.f.b().a(NearbyPrefKeys.d, true).a();
  }

  private void U()
  {
    if (this.ag.getVisibility() == 0)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(p(), 2130968601);
      this.ag.startAnimation(localAnimation);
      this.ag.setVisibility(8);
    }
  }

  private void V()
  {
    if (!this.f.a(NearbyPrefKeys.d, false))
    {
      Animation localAnimation = AnimationUtils.loadAnimation(p(), 2130968599);
      this.ag.startAnimation(localAnimation);
      this.ag.setVisibility(0);
    }
  }

  private ListenableFuture<Drawable> a(String paramString)
  {
    FetchImageParams localFetchImageParams = new FetchImageParams(Uri.parse(paramString));
    return Futures.a(this.c.b(localFetchImageParams), new NearbyMapAreaFragment.13(this), MoreExecutors.a());
  }

  private void a(GraphQLPlace paramGraphQLPlace, MapFragment.MapOverlayElement.OnSelectedListener paramOnSelectedListener)
  {
    MapFragment.MapOverlayElement localMapOverlayElement = this.aa.a(paramGraphQLPlace.location.latitude, paramGraphQLPlace.location.longitude, this.d.a());
    localMapOverlayElement.a(paramOnSelectedListener);
    this.h.add(localMapOverlayElement);
    if (paramGraphQLPlace.profilePicture.uri != null)
      a(localMapOverlayElement, a(paramGraphQLPlace.profilePicture.uri), paramGraphQLPlace.profilePicture.uri);
  }

  private void a(MapFragment.MapOverlayElement paramMapOverlayElement, ListenableFuture<Drawable> paramListenableFuture, String paramString)
  {
    this.e.a(paramListenableFuture, new NearbyMapAreaFragment.12(this, paramMapOverlayElement, paramString));
  }

  private void a(NearbyPlaceEdge paramNearbyPlaceEdge)
  {
    NearbyPlaceEdge localNearbyPlaceEdge = this.al.getDisplayedPlaceEdge();
    if (localNearbyPlaceEdge == null);
    while (true)
    {
      return;
      if (localNearbyPlaceEdge.place.id == paramNearbyPlaceEdge.place.id)
      {
        P();
        continue;
      }
    }
  }

  private void a(List<NearbyPlaceEdge> paramList)
  {
    Location localLocation1 = this.aa.O();
    Location localLocation2 = this.aa.N();
    List localList = Lists.a(paramList, new NearbyMapAreaFragment.9(this));
    double d1 = Math.abs(localLocation2.getLatitude() - localLocation1.getLatitude());
    double d2 = Math.abs(localLocation2.getLongitude() - localLocation1.getLongitude());
    f(new MapZoomHelper().a(this.aa.a(), localList, new MapZoomHelper.LocationDelta(d1, d2)));
  }

  private void b(NearbyPlaceEdge paramNearbyPlaceEdge)
  {
    this.al.bringToFront();
    this.al.setVisibility(0);
    this.al.a(paramNearbyPlaceEdge, this.aa.b());
  }

  private void b(List<NearbyPlaceEdge> paramList)
  {
    O();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      NearbyPlaceEdge localNearbyPlaceEdge = (NearbyPlaceEdge)localIterator.next();
      GraphQLPlace localGraphQLPlace = localNearbyPlaceEdge.place;
      if ((localGraphQLPlace == null) || (localGraphQLPlace.location == null))
        continue;
      a(localGraphQLPlace, c(localNearbyPlaceEdge));
    }
  }

  private MapFragment.MapOverlayElement.OnSelectedListener c(NearbyPlaceEdge paramNearbyPlaceEdge)
  {
    return new NearbyMapAreaFragment.14(this, paramNearbyPlaceEdge);
  }

  private void f(int paramInt)
  {
    if (paramInt >= 0)
      for (int j = 0; j < paramInt; j++)
        this.aa.d();
    while (paramInt < 0)
    {
      this.aa.L();
      paramInt++;
    }
  }

  public void D()
  {
    super.D();
    this.aa.a(null);
  }

  public Location a()
  {
    return this.aa.b();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903286, paramViewGroup, false);
  }

  public void a(NearbyMapAreaFragment.NearbyMapFragmentHost paramNearbyMapFragmentHost)
  {
    this.am = paramNearbyMapFragmentHost;
  }

  public void a(SearchArea paramSearchArea)
  {
    this.Z = paramSearchArea;
    S();
  }

  public void a(List<NearbyPlaceEdge> paramList, SearchArea paramSearchArea, String paramString)
  {
    this.i = paramList;
    this.Y = paramString;
    a(paramSearchArea);
    ListenableFuture localListenableFuture = this.aa.b(paramSearchArea.a);
    this.e.a(localListenableFuture, new NearbyMapAreaFragment.8(this, paramList));
    b(paramList);
  }

  public ListenableFuture<Location> b()
  {
    return this.aa.c();
  }

  public SearchArea c()
  {
    return new SearchArea(this.aa.a(), R());
  }

  public void d()
  {
    V();
    this.ae.clearAnimation();
    this.ah.reset();
    this.ae.startAnimation(this.ah);
    this.ae.setVisibility(0);
    this.af.setVisibility(8);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (paramBundle != null)
    {
      this.Z = ((SearchArea)paramBundle.getParcelable("lastSearchArea"));
      this.i = paramBundle.getParcelableArrayList("curNearbyPlaces");
    }
    FbInjector localFbInjector = Q();
    this.b = ((FragmentManager)localFbInjector.a(FragmentManager.class));
    this.d = ((NearbyMapPinFactory)localFbInjector.a(NearbyMapPinFactory.class));
    this.c = ((FetchImageExecutor)localFbInjector.a(FetchImageExecutor.class));
    this.e = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.f = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.g = ((NearbyAnalytics)localFbInjector.a(NearbyAnalytics.class));
    this.h = Lists.a();
    this.ab = ((Button)g(2131297137));
    this.ad = ((ImageButton)g(2131297135));
    this.ag = ((ViewGroup)g(2131297138));
    this.ac = ((ImageButton)g(2131297136));
    this.ae = ((ViewGroup)g(2131297134));
    this.af = g(2131297139);
    this.al = ((NearbyPlaceDetailsView)g(2131297132));
    N();
    ListenableFuture localListenableFuture = this.aa.c();
    this.e.a(localListenableFuture, new NearbyMapAreaFragment.1(this));
    this.al.setOnTouchListener(new NearbyMapAreaFragment.2(this));
    this.al.setOnClickListener(new NearbyMapAreaFragment.3(this));
    NearbyMapAreaFragment.4 local4 = new NearbyMapAreaFragment.4(this);
    this.ab.setOnTouchListener(local4);
    this.ac.setOnTouchListener(local4);
    this.ad.setOnTouchListener(local4);
    this.ab.setOnClickListener(new NearbyMapAreaFragment.5(this));
    this.ac.setOnClickListener(new NearbyMapAreaFragment.6(this));
    this.ad.setOnClickListener(new NearbyMapAreaFragment.7(this));
    this.ai = AnimationUtils.loadAnimation(n(), 2130968598);
    this.ah = AnimationUtils.loadAnimation(n(), 2130968597);
    this.ak = AnimationUtils.loadAnimation(n(), 2130968598);
    this.aj = AnimationUtils.loadAnimation(n(), 2130968597);
    if (this.i != null)
      b(this.i);
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putParcelable("lastSearchArea", this.Z);
    if (this.i != null)
      paramBundle.putParcelableArrayList("curNearbyPlaces", Lists.a(this.i));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapAreaFragment
 * JD-Core Version:    0.6.0
 */