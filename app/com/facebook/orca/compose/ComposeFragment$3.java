package com.facebook.orca.compose;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class ComposeFragment$3
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (ComposeFragment.d(this.a) == ComposeMode.SHRUNK)
      if (paramMotionEvent.getActionMasked() == 1)
      {
        ComposeFragment.e(this.a).requestFocusFromTouch();
        ((InputMethodManager)this.a.p().getSystemService("input_method")).showSoftInput(ComposeFragment.e(this.a), 0);
      }
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.3
 * JD-Core Version:    0.6.0
 */