package com.facebook.maps;

import android.graphics.drawable.Drawable;
import android.location.Location;
import android.view.View.OnTouchListener;
import com.facebook.orca.activity.OrcaFragment;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class MapFragment extends OrcaFragment
{
  public abstract void L();

  public abstract Location M();

  public abstract Location N();

  public abstract Location O();

  public abstract Location a();

  public abstract MapFragment.MapOverlayElement a(double paramDouble1, double paramDouble2, Drawable paramDrawable);

  public abstract void a(double paramDouble);

  public abstract void a(Location paramLocation);

  public abstract void a(View.OnTouchListener paramOnTouchListener);

  public abstract void a(MapFragment.MapOverlayElement paramMapOverlayElement);

  public abstract void a(boolean paramBoolean);

  public abstract Location b();

  public abstract ListenableFuture<Void> b(Location paramLocation);

  public abstract void b(MapFragment.MapOverlayElement paramMapOverlayElement);

  public abstract void b(boolean paramBoolean);

  public abstract ListenableFuture<Location> c();

  public abstract void d();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.MapFragment
 * JD-Core Version:    0.6.0
 */