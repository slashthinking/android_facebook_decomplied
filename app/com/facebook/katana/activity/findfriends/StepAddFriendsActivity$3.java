package com.facebook.katana.activity.findfriends;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.katana.features.Gatekeeper;

class StepAddFriendsActivity$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if ((this.a.getString(2131363390).equals(((Button)this.a.findViewById(2131296857)).getText().toString())) && (StepAddFriendsActivity.b(this.a)) && (this.a.k() == 0))
      if (Boolean.TRUE.equals(Gatekeeper.a(this.a, "new_android_ci_skip_add_all_dialog")))
        this.a.m();
    while (true)
    {
      return;
      DialogFragment localDialogFragment = StepAddFriendsActivity.AddAllDialogFragment.f(StepAddFriendsActivity.c(this.a).getCount());
      localDialogFragment.a(1, 0);
      localDialogFragment.a(this.a.g(), "add_all_dialog_fragment");
      continue;
      StepAddFriendsActivity.d(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepAddFriendsActivity.3
 * JD-Core Version:    0.6.0
 */