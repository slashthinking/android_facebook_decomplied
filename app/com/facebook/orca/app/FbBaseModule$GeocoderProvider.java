package com.facebook.orca.app;

import android.location.Geocoder;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$GeocoderProvider extends AbstractProvider<Geocoder>
{
  private FbBaseModule$GeocoderProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public Geocoder a()
  {
    return new Geocoder(FbBaseModule.b(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.GeocoderProvider
 * JD-Core Version:    0.6.0
 */