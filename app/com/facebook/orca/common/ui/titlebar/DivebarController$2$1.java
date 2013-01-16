package com.facebook.orca.common.ui.titlebar;

import com.facebook.orca.contacts.divebar.DivebarFragment;
import com.facebook.orca.ui.touch.SwipableLinearLayout;

class DivebarController$2$1
  implements Runnable
{
  public void run()
  {
    DivebarController.b(this.a.c);
    if (this.a.a == DivebarController.DivebarState.OPENED)
    {
      DivebarController.a(this.a.c).bringToFront();
      DivebarController.c(this.a.c).b();
      DivebarController.d(this.a.c);
    }
    while (true)
    {
      if (this.a.b != null)
        this.a.b.run();
      if (DivebarController.g(this.a.c) != null)
        DivebarController.g(this.a.c).b(DivebarController.h(this.a.c));
      return;
      DivebarController.e(this.a.c);
      DivebarController.f(this.a.c);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.DivebarController.2.1
 * JD-Core Version:    0.6.0
 */