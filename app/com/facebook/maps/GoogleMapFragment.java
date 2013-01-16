package com.facebook.maps;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.facebook.orca.common.util.LocationUtils;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Projection;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GoogleMapFragment extends MapFragment
{
  private Location Y = null;
  private View.OnTouchListener Z = null;
  private LocalActivityManager a;
  private String aa = null;
  private boolean ab = false;
  private List<SettableFuture<Location>> ac = new CopyOnWriteArrayList();
  private LinkedList<GoogleMapFragment.SelectableOverlayItem> ad = Lists.b();
  private boolean ae = false;
  private boolean af = true;
  private GoogleEmbeddableMapActivity b;
  private MapView c;
  private FrameLayout d;
  private FixedMyLocationOverlay e = null;
  private GoogleMapFragment.AddedOverlaysItemizedOverlay f;
  private GoogleMapFragment.SelectableOverlayItem g;
  private boolean h = true;
  private int i = -1;

  private void P()
  {
    if (this.b != null);
    while (true)
    {
      return;
      if (LocationUtils.a())
      {
        Intent localIntent = new Intent().setClass(n(), GoogleEmbeddableMapActivity.class);
        localIntent.putExtra(GoogleEmbeddableMapActivity.a, this.aa);
        Window localWindow = this.a.startActivity("map", localIntent);
        this.b = ((GoogleEmbeddableMapActivity)this.a.getActivity("map"));
        this.c = this.b.a();
        a(this.h);
        if (this.i != -1)
          a(this.i);
        if (this.Y != null)
          a(this.Y);
        if (this.Z != null)
          a(this.Z);
        if (this.ab)
          b(true);
        this.f = new GoogleMapFragment.AddedOverlaysItemizedOverlay(q().getDrawable(2130838660), this.af);
        Iterator localIterator = this.ad.iterator();
        while (localIterator.hasNext())
          a((GoogleMapFragment.SelectableOverlayItem)localIterator.next());
        this.f.setOnFocusChangeListener(new GoogleMapFragment.1(this));
        this.ad.clear();
        this.ad = null;
        this.c.getOverlays().add(this.f);
        this.d.addView(localWindow.getDecorView());
        continue;
      }
    }
  }

  public static GoogleMapFragment a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("apiKey", paramString);
    localBundle.putBoolean("overlayShadowDrawingEnabled", paramBoolean);
    GoogleMapFragment localGoogleMapFragment = new GoogleMapFragment();
    localGoogleMapFragment.f(localBundle);
    return localGoogleMapFragment;
  }

  private MapFragment.MapOverlayElement a(GoogleMapFragment.SelectableOverlayItem paramSelectableOverlayItem)
  {
    if (this.b != null)
    {
      this.f.a(paramSelectableOverlayItem);
      this.c.invalidate();
    }
    while (true)
    {
      return new GoogleMapFragment.GoogleMapOverlayElement(this, paramSelectableOverlayItem, null);
      this.ad.add(paramSelectableOverlayItem);
    }
  }

  private void b(GoogleMapFragment.SelectableOverlayItem paramSelectableOverlayItem)
  {
    if (paramSelectableOverlayItem == null)
      if (this.g != null)
        this.g.b();
    for (this.g = null; ; this.g = paramSelectableOverlayItem)
    {
      return;
      if (this.g != null)
        this.g.b();
      paramSelectableOverlayItem.a();
    }
  }

  public void B()
  {
    super.B();
    this.ae = true;
    if (this.e != null)
      this.e.enableMyLocation();
    if (!w())
    {
      P();
      this.a.dispatchResume();
    }
  }

  public void C()
  {
    super.C();
    this.ae = false;
    if (this.e != null)
      this.e.disableMyLocation();
    if (!w())
      this.a.dispatchPause(n().isFinishing());
  }

  public void D()
  {
    super.D();
    if (this.f != null)
      this.f.setOnFocusChangeListener(null);
    this.a.dispatchDestroy(n().isFinishing());
  }

  public void L()
  {
    if (this.b == null);
    while (true)
    {
      return;
      this.c.getController().zoomOut();
    }
  }

  public Location M()
  {
    if (this.b == null);
    for (Location localLocation = null; ; localLocation = Locations.a(this.c.getProjection().fromPixels(0, 0)))
      return localLocation;
  }

  public Location N()
  {
    if (this.b == null);
    for (Location localLocation = null; ; localLocation = Locations.a(this.c.getProjection().fromPixels(this.c.getRight(), 0)))
      return localLocation;
  }

  public Location O()
  {
    if (this.b == null);
    for (Location localLocation = null; ; localLocation = Locations.a(this.c.getProjection().fromPixels(0, this.c.getHeight())))
      return localLocation;
  }

  public Location a()
  {
    if (this.b == null);
    for (Location localLocation = this.Y; ; localLocation = Locations.a(this.c.getMapCenter()))
      return localLocation;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.d = new FrameLayout(n());
    return this.d;
  }

  public MapFragment.MapOverlayElement a(double paramDouble1, double paramDouble2, Drawable paramDrawable)
  {
    return a(new GoogleMapFragment.SelectableOverlayItem(Locations.a(Locations.a(paramDouble1, paramDouble2)), paramDrawable, null, null));
  }

  public void a(double paramDouble)
  {
    int j = (int)paramDouble;
    if (this.b == null)
      this.i = j;
    while (true)
    {
      return;
      this.c.getController().setZoom(j);
    }
  }

  public void a(Location paramLocation)
  {
    if (this.b == null)
      this.Y = paramLocation;
    while (true)
    {
      return;
      this.c.getController().setCenter(Locations.a(paramLocation));
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.aa = ((String)Preconditions.checkNotNull(m().getString("apiKey"), "Must call #setMapApiKey with a valid key before instantiating the fragment"));
    this.af = m().getBoolean("overlayShadowDrawingEnabled");
    Object localObject = null;
    if (paramBundle != null)
    {
      Bundle localBundle = paramBundle.getBundle("activityManagerSavedInstanceState");
      this.h = paramBundle.getBoolean("clickable");
      this.ab = paramBundle.getBoolean("showLocation");
      this.i = paramBundle.getInt("latestMapZoom");
      this.Y = ((Location)paramBundle.getParcelable("latestMapCenter"));
      localObject = localBundle;
    }
    this.a = new LocalActivityManager(n(), false);
    this.a.dispatchCreate(localObject);
  }

  public void a(View.OnTouchListener paramOnTouchListener)
  {
    if (this.b == null)
      this.Z = paramOnTouchListener;
    while (true)
    {
      return;
      this.c.setOnTouchListener(paramOnTouchListener);
    }
  }

  public void a(MapFragment.MapOverlayElement paramMapOverlayElement)
  {
    if (paramMapOverlayElement == null)
      this.f.setFocus(null);
    while (true)
    {
      return;
      GoogleMapFragment.SelectableOverlayItem localSelectableOverlayItem = GoogleMapFragment.GoogleMapOverlayElement.a((GoogleMapFragment.GoogleMapOverlayElement)paramMapOverlayElement);
      this.f.setFocus(localSelectableOverlayItem);
    }
  }

  public void a(boolean paramBoolean)
  {
    if (this.b == null)
      this.h = paramBoolean;
    while (true)
    {
      return;
      this.c.setClickable(paramBoolean);
    }
  }

  public Location b()
  {
    GoogleEmbeddableMapActivity localGoogleEmbeddableMapActivity = this.b;
    Location localLocation = null;
    if (localGoogleEmbeddableMapActivity == null);
    while (true)
    {
      return localLocation;
      FixedMyLocationOverlay localFixedMyLocationOverlay = this.e;
      localLocation = null;
      if (localFixedMyLocationOverlay == null)
        continue;
      localLocation = this.e.getLastFix();
    }
  }

  public ListenableFuture<Void> b(Location paramLocation)
  {
    Preconditions.checkNotNull(paramLocation);
    Object localObject;
    if (this.b == null)
    {
      this.Y = paramLocation;
      localObject = Futures.a(null);
    }
    while (true)
    {
      return localObject;
      localObject = SettableFuture.c();
      this.c.getController().animateTo(Locations.a(paramLocation), new GoogleMapFragment.3(this, (SettableFuture)localObject));
    }
  }

  public void b(MapFragment.MapOverlayElement paramMapOverlayElement)
  {
    GoogleMapFragment.SelectableOverlayItem localSelectableOverlayItem = GoogleMapFragment.GoogleMapOverlayElement.a((GoogleMapFragment.GoogleMapOverlayElement)paramMapOverlayElement);
    if (this.b != null)
    {
      this.f.b(localSelectableOverlayItem);
      this.c.invalidate();
    }
    while (true)
    {
      return;
      this.ad.remove(localSelectableOverlayItem);
    }
  }

  public void b(boolean paramBoolean)
  {
    if (this.b == null)
      this.ab = paramBoolean;
    while (true)
    {
      return;
      if (paramBoolean)
      {
        this.e = new FixedMyLocationOverlay(this.b, this.c);
        if ((this.ac != null) && (this.ac.size() > 0))
          this.e.runOnFirstFix(new GoogleMapFragment.4(this));
        this.c.getOverlays().add(this.e);
        this.c.postInvalidate();
        if (!this.ae)
          continue;
        this.e.enableMyLocation();
        continue;
      }
      if (this.e == null)
        continue;
      if (this.ae)
        this.e.disableMyLocation();
      this.e = null;
    }
  }

  public ListenableFuture<Location> c()
  {
    Object localObject;
    if (this.e == null)
    {
      localObject = SettableFuture.c();
      this.ac.add(localObject);
    }
    while (true)
    {
      return localObject;
      Location localLocation = this.e.getLastFix();
      if (localLocation != null)
      {
        localObject = Futures.a(localLocation);
        continue;
      }
      localObject = SettableFuture.c();
      this.e.runOnFirstFix(new GoogleMapFragment.2(this, (SettableFuture)localObject));
    }
  }

  public void d()
  {
    if (this.b == null);
    while (true)
    {
      return;
      this.c.getController().zoomIn();
    }
  }

  public void d(boolean paramBoolean)
  {
    if (u())
    {
      if (!paramBoolean)
        break label20;
      this.a.dispatchPause(false);
    }
    while (true)
    {
      return;
      label20: P();
      this.a.dispatchResume();
    }
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putBundle("activityManagerSavedInstanceState", this.a.saveInstanceState());
    paramBundle.putBoolean("clickable", this.h);
    paramBundle.putBoolean("showLocation", this.ab);
    int j;
    if (this.c == null)
    {
      j = this.i;
      paramBundle.putInt("latestMapZoom", j);
      if (this.c != null)
        break label93;
    }
    label93: for (Location localLocation = this.Y; ; localLocation = Locations.a(this.c.getMapCenter()))
    {
      paramBundle.putParcelable("latestMapCenter", localLocation);
      return;
      j = this.c.getZoomLevel();
      break;
    }
  }

  public void g()
  {
    super.g();
    this.a.dispatchStop();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.GoogleMapFragment
 * JD-Core Version:    0.6.0
 */