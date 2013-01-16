package com.facebook.katana;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class LoginActivity$4
  implements Runnable
{
  public void run()
  {
    View localView = this.b.findViewById(2131296667);
    int i = (this.a.getHeight() - localView.getHeight()) / 2;
    LoginActivity.d(this.b);
    ((RelativeLayout.LayoutParams)localView.getLayoutParams()).topMargin = i;
    localView.requestLayout();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity.4
 * JD-Core Version:    0.6.0
 */