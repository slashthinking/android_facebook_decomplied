package com.facebook.katana.fragment.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ProgressDialogFragment extends DialogFragment
{
  public static DialogFragment a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ProgressDialogFragment localProgressDialogFragment = new ProgressDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("message_res_id", paramInt);
    localBundle.putBoolean("indeterminate", paramBoolean1);
    localBundle.putBoolean("cancelable", paramBoolean2);
    localProgressDialogFragment.f(localBundle);
    return localProgressDialogFragment;
  }

  public Dialog c(Bundle paramBundle)
  {
    Bundle localBundle = m();
    int i = localBundle.getInt("message_res_id");
    boolean bool1 = localBundle.getBoolean("indeterminate");
    boolean bool2 = localBundle.getBoolean("cancelable");
    ProgressDialog localProgressDialog = new ProgressDialog(n());
    localProgressDialog.setProgressStyle(0);
    localProgressDialog.setMessage(d(i));
    localProgressDialog.setIndeterminate(bool1);
    localProgressDialog.setCancelable(bool2);
    return localProgressDialog;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.fragment.dialog.ProgressDialogFragment
 * JD-Core Version:    0.6.0
 */