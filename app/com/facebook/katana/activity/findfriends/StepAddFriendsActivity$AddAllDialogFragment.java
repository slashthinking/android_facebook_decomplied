package com.facebook.katana.activity.findfriends;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.katana.AlertDialogs;

class StepAddFriendsActivity$AddAllDialogFragment extends DialogFragment
{
  public static DialogFragment f(int paramInt)
  {
    AddAllDialogFragment localAddAllDialogFragment = new AddAllDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("add_all_friend_count", paramInt);
    localAddAllDialogFragment.f(localBundle);
    return localAddAllDialogFragment;
  }

  public Dialog c(Bundle paramBundle)
  {
    StepAddFriendsActivity localStepAddFriendsActivity = (StepAddFriendsActivity)n();
    int i = m().getInt("add_all_friend_count", -1);
    if (i < 1)
      throw new IllegalArgumentException("Expecting a positive number of candidates to add as friends");
    StepAddFriendsActivity.AddAllDialogFragment.1 local1 = new StepAddFriendsActivity.AddAllDialogFragment.1(this, localStepAddFriendsActivity);
    StepAddFriendsActivity.AddAllDialogFragment.2 local2 = new StepAddFriendsActivity.AddAllDialogFragment.2(this);
    Object[] arrayOfObject;
    if (i > 1)
    {
      arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i);
    }
    for (String str = a(2131363448, arrayOfObject); ; str = e(2131363447))
      return AlertDialogs.a(localStepAddFriendsActivity, null, 17301543, str, e(2131363449), local1, null, null, local2, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepAddFriendsActivity.AddAllDialogFragment
 * JD-Core Version:    0.6.0
 */