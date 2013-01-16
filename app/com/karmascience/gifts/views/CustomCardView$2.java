package com.karmascience.gifts.views;

import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class CustomCardView$2
  implements TextView.OnEditorActionListener
{
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) && (this.a.y() != null) && (this.a.y().isEnabled()))
      this.a.y().performClick();
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CustomCardView.2
 * JD-Core Version:    0.6.0
 */