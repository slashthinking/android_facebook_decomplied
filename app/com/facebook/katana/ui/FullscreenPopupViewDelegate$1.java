package com.facebook.katana.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.facebook.katana.orca.InstallMessengerFragment;

class FullscreenPopupViewDelegate$1
  implements ViewPager.OnPageChangeListener
{
  public void a(int paramInt)
  {
    if (paramInt == PopupViewDelegate.PopupState.MESSAGES.ordinal())
    {
      Fragment localFragment = FullscreenPopupViewDelegate.a(this.b).d();
      if ((localFragment instanceof InstallMessengerFragment))
        ((InstallMessengerFragment)localFragment).a();
    }
    if (this.b.i() != PopupViewDelegate.PopupState.values()[paramInt])
      this.b.a(this.a, PopupViewDelegate.PopupState.values()[paramInt], null);
  }

  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void b(int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.FullscreenPopupViewDelegate.1
 * JD-Core Version:    0.6.0
 */