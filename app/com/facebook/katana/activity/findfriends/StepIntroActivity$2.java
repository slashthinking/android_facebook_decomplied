package com.facebook.katana.activity.findfriends;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.SecureContextHelper;

class StepIntroActivity$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    StepIntroActivity.a(this.a, true);
    Intent localIntent = new Intent(this.a, StepHowItWorksActivity.class);
    StepIntroActivity.e(this.a).a(localIntent, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepIntroActivity.2
 * JD-Core Version:    0.6.0
 */