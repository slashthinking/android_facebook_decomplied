package com.karmascience.gifts.widget;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;

public class AddressEntryDialogFragment extends DialogFragment
{
  private final AddressEntryDialogFragment.AddressEntryDialogListener Y;
  private View Z;

  public AddressEntryDialogFragment(AddressEntryDialogFragment.AddressEntryDialogListener paramAddressEntryDialogListener)
  {
    this.Y = paramAddressEntryDialogListener;
  }

  public Dialog c(Bundle paramBundle)
  {
    LayoutInflater localLayoutInflater = n().getLayoutInflater();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(n());
    AddressEntryDialogFragment.1 local1 = new AddressEntryDialogFragment.1(this);
    this.Z = localLayoutInflater.inflate(2130903043, null);
    return localBuilder.setView(this.Z).setTitle(2131362331).setPositiveButton(2131362232, local1).setNegativeButton(2131362233, null).create();
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.widget.AddressEntryDialogFragment
 * JD-Core Version:    0.6.0
 */