package com.facebook.katana.activity.findfriends;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.Log;
import com.facebook.katana.service.method.UsersInvite;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.ArrayList;
import java.util.Locale;

class StepInviteActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (!StepInviteActivity.a(this.a))
    {
      StepInviteActivity.a(this.a, true);
      Class localClass = StepInviteActivity.k();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(StepInviteActivity.b(this.a).size());
      Log.e(localClass, StringLocaleUtil.a("Sending invites to %d contacts.", arrayOfObject));
      UsersInvite.a(StepInviteActivity.c(this.a), this.a, StepInviteActivity.b(this.a), null, Locale.getDefault().getCountry());
    }
    StepInviteActivity.d(this.a);
    StepInviteActivity.e(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepInviteActivity.1
 * JD-Core Version:    0.6.0
 */