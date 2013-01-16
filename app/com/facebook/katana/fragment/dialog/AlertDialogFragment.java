package com.facebook.katana.fragment.dialog;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment
{
  public static DialogFragment f(int paramInt)
  {
    AlertDialogFragment localAlertDialogFragment = new AlertDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("message_res_id", paramInt);
    localAlertDialogFragment.f(localBundle);
    return localAlertDialogFragment;
  }

  public Dialog c(Bundle paramBundle)
  {
    int i = m().getInt("message_res_id");
    return new AlertDialog.Builder(n()).setMessage(i).setPositiveButton(2131361888, new AlertDialogFragment.1(this)).create();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.fragment.dialog.AlertDialogFragment
 * JD-Core Version:    0.6.0
 */