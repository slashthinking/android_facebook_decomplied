package com.facebook.katana.gifts;

import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.karmascience.gifts.ui.IViewChangedListener;
import com.karmascience.gifts.views.KSViewController;

class GiftsActivity$1
  implements IViewChangedListener
{
  public void a(KSViewController paramKSViewController)
  {
    if (paramKSViewController != null)
    {
      String str = paramKSViewController.b();
      if (str != null)
        this.a.a(TitleBarButtonSpec.newBuilder().b(str).i());
    }
    while (true)
    {
      return;
      this.a.a(null);
      continue;
      this.a.a(null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.gifts.GiftsActivity.1
 * JD-Core Version:    0.6.0
 */