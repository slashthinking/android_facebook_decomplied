package com.facebook.katana.activity.findfriends;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.service.method.ContinuousImport;
import com.facebook.katana.util.GrowthUtils;

class StepIntroActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    StepIntroActivity.d(this.a).a(new FindFriendsAnalyticsEvent("legal_consent").i("submitted").c(StepIntroActivity.c(this.a)).b(StepIntroActivity.b(this.a)).b(SystemClock.elapsedRealtime() - StepIntroActivity.a(this.a)));
    ContinuousImport.a(this.a, true);
    Intent localIntent = new Intent(this.a, StepAddFriendsActivity.class);
    localIntent.putExtra("is_part_of_nux", StepIntroActivity.c(this.a));
    StepIntroActivity.e(this.a).a(localIntent, this.a);
    GrowthUtils.a().f(this.a);
    StepIntroActivity.e(this.a).a(localIntent, 2001, this.a);
    if (!StepIntroActivity.c(this.a))
      this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepIntroActivity.1
 * JD-Core Version:    0.6.0
 */