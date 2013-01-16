package com.facebook.katana;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.FrameLayout;

class MyTabHost$1
  implements View.OnKeyListener
{
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default:
      MyTabHost.a(this.a).requestFocus(2);
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    case 66:
    }
    for (boolean bool = MyTabHost.a(this.a).dispatchKeyEvent(paramKeyEvent); ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.MyTabHost.1
 * JD-Core Version:    0.6.0
 */