package com.facebook.orca.mutators;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class LeaveThreadDialogFragment extends DialogFragment
{
  private LeaveThreadDialogFragment.LeaveThreadListener Y;

  public void a(LeaveThreadDialogFragment.LeaveThreadListener paramLeaveThreadListener)
  {
    this.Y = paramLeaveThreadListener;
  }

  public Dialog c(Bundle paramBundle)
  {
    return new AlertDialog.Builder(p()).setTitle(2131362502).setMessage(2131362503).setPositiveButton(2131362504, new LeaveThreadDialogFragment.2(this)).setNegativeButton(2131362168, new LeaveThreadDialogFragment.1(this)).create();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mutators.LeaveThreadDialogFragment
 * JD-Core Version:    0.6.0
 */