package com.facebook.katana.util;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import com.facebook.debug.Assert;

public class LocationSources$LocationSourcesDialogFragment extends DialogFragment
{
  private Checkable Y;
  private LocationSources.MessageType Z;

  public static LocationSourcesDialogFragment b(Context paramContext)
  {
    LocationSources.MessageType localMessageType = LocationSources.a(paramContext, true);
    LocationSourcesDialogFragment localLocationSourcesDialogFragment;
    if (localMessageType == null)
      localLocationSourcesDialogFragment = null;
    while (true)
    {
      return localLocationSourcesDialogFragment;
      localLocationSourcesDialogFragment = new LocationSourcesDialogFragment();
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("extra_message_type", localMessageType);
      localLocationSourcesDialogFragment.f(localBundle);
    }
  }

  public Dialog c(Bundle paramBundle)
  {
    this.Z = ((LocationSources.MessageType)m().getSerializable("extra_message_type"));
    Assert.a(this.Z);
    if (Build.VERSION.SDK_INT >= 14);
    for (AlertDialog.Builder localBuilder = new AlertDialog.Builder(n(), 4); ; localBuilder = new AlertDialog.Builder(n()))
    {
      localBuilder.setTitle(this.Z.titleResId);
      localBuilder.setIcon(17301659);
      localBuilder.setMessage(this.Z.messageResId);
      View localView = LayoutInflater.from(n()).inflate(2130903494, null);
      this.Y = ((Checkable)localView.findViewById(2131297688));
      localBuilder.setView(localView);
      localBuilder.setPositiveButton(2131363331, new LocationSources.LocationSourcesDialogFragment.1(this));
      localBuilder.setNegativeButton(2131363188, new LocationSources.LocationSourcesDialogFragment.2(this));
      return localBuilder.create();
    }
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.Y.isChecked())
      LocationSources.a(n(), this.Z, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.LocationSources.LocationSourcesDialogFragment
 * JD-Core Version:    0.6.0
 */