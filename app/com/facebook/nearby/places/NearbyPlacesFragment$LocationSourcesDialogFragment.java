package com.facebook.nearby.places;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.content.SecureContextHelper;
import com.facebook.nearby.analytics.NearbyAnalytics;

public class NearbyPlacesFragment$LocationSourcesDialogFragment extends DialogFragment
{
  private SecureContextHelper Y;
  private NearbyPlacesFragment Z;

  public NearbyPlacesFragment$LocationSourcesDialogFragment(SecureContextHelper paramSecureContextHelper, NearbyPlacesFragment paramNearbyPlacesFragment)
  {
    this.Y = paramSecureContextHelper;
    this.Z = paramNearbyPlacesFragment;
  }

  public Dialog c(Bundle paramBundle)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(n());
    localBuilder.setTitle(2131361903);
    localBuilder.setMessage(2131361905);
    localBuilder.setPositiveButton(2131361909, new NearbyPlacesFragment.LocationSourcesDialogFragment.1(this));
    localBuilder.setNegativeButton(2131361910, new NearbyPlacesFragment.LocationSourcesDialogFragment.2(this));
    this.Z.c().b();
    return localBuilder.create();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesFragment.LocationSourcesDialogFragment
 * JD-Core Version:    0.6.0
 */