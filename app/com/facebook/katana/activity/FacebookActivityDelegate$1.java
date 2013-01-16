package com.facebook.katana.activity;

import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.widget.ScreenSlider.BaseStateListener;

class FacebookActivityDelegate$1 extends ScreenSlider.BaseStateListener
{
  public void a()
  {
    this.a.k();
  }

  public void b()
  {
    super.b();
    FacebookActivityDelegate.a(this.a).a(FB4A_AnalyticEntities.Modules.g, true);
  }

  public void c()
  {
    super.c();
    FacebookActivityDelegate.a(this.a).a(FB4A_AnalyticEntities.Modules.g);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate.1
 * JD-Core Version:    0.6.0
 */