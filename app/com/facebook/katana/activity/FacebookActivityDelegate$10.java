package com.facebook.katana.activity;

import android.view.View;
import com.facebook.diagnostics.FPSView;
import com.facebook.katana.ui.PopupViewDelegate;
import com.facebook.orca.common.ui.titlebar.DivebarController.DivebarAnimationListener;
import com.facebook.orca.common.ui.titlebar.DivebarController.DivebarState;

class FacebookActivityDelegate$10
  implements DivebarController.DivebarAnimationListener
{
  public void a(DivebarController.DivebarState paramDivebarState)
  {
    if ((FacebookActivityDelegate.c(this.a) != null) && (FacebookActivityDelegate.c(this.a).d()))
      FacebookActivityDelegate.c(this.a).a(FacebookActivityDelegate.b(this.a), false);
  }

  public boolean a(View paramView)
  {
    int i = 1;
    if ((FacebookActivityDelegate.c(this.a) != null) && (paramView.equals(FacebookActivityDelegate.c(this.a).h())));
    while (true)
    {
      return i;
      if (paramView.getClass().equals(FPSView.class))
        continue;
      i = 0;
    }
  }

  public void b(DivebarController.DivebarState paramDivebarState)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate.10
 * JD-Core Version:    0.6.0
 */