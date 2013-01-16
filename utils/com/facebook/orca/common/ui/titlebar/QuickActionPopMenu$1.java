package com.facebook.orca.common.ui.titlebar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

class QuickActionPopMenu$1
  implements View.OnTouchListener
{
  QuickActionPopMenu$1(QuickActionPopMenu paramQuickActionPopMenu)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
      QuickActionPopMenu.a(this.a).dismiss();
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.QuickActionPopMenu.1
 * JD-Core Version:    0.6.2
 */