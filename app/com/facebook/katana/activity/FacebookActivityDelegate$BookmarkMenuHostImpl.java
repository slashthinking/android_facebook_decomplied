package com.facebook.katana.activity;

import android.view.View;
import com.facebook.diagnostics.FPSView;
import com.facebook.katana.ui.JewelTitleBar;
import com.facebook.widget.ScreenSlider.OnConfigurationChangedListener;
import com.facebook.widget.ScreenSlider.ScreenSliderHost;
import com.facebook.widget.ScreenSlider.ScreenSliderOpenListener;

class FacebookActivityDelegate$BookmarkMenuHostImpl
  implements ScreenSlider.ScreenSliderHost
{
  private FacebookActivityDelegate$BookmarkMenuHostImpl(FacebookActivityDelegate paramFacebookActivityDelegate)
  {
  }

  public View a()
  {
    JewelTitleBar localJewelTitleBar = this.a.c();
    if (localJewelTitleBar != null);
    for (View localView = localJewelTitleBar.findViewById(2131297046); ; localView = null)
      return localView;
  }

  public void a(ScreenSlider.OnConfigurationChangedListener paramOnConfigurationChangedListener)
  {
    FacebookActivityDelegate.a(this.a, paramOnConfigurationChangedListener);
  }

  public void a(ScreenSlider.ScreenSliderOpenListener paramScreenSliderOpenListener)
  {
  }

  public boolean a(View paramView)
  {
    if ((paramView instanceof FPSView));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void b()
  {
  }

  public void c()
  {
    FacebookActivityDelegate.a(this.a, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate.BookmarkMenuHostImpl
 * JD-Core Version:    0.6.0
 */