package com.facebook.katana.activity.media.vault;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;

public class VaultDeleteFailedDialog extends DialogFragment
{
  public Dialog c(Bundle paramBundle)
  {
    View localView = ((LayoutInflater)n().getSystemService("layout_inflater")).inflate(2130903621, null);
    return new AlertDialog.Builder(new ContextThemeWrapper(n(), 16973931)).setPositiveButton(2131361888, null).setTitle(2131363570).setIcon(17301624).setView(localView).create();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultDeleteFailedDialog
 * JD-Core Version:    0.6.0
 */