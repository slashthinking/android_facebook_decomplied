package com.facebook.orca.compose;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class ComposeFragment$11
  implements View.OnKeyListener
{
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
      ComposeFragment.c(this.a, false);
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.11
 * JD-Core Version:    0.6.0
 */