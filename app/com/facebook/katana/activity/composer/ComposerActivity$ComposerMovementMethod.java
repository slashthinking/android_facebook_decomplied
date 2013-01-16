package com.facebook.katana.activity.composer;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

class ComposerActivity$ComposerMovementMethod extends ArrowKeyMovementMethod
{
  ComposerActivity$ComposerMovementMethod(ComposerActivity paramComposerActivity)
  {
  }

  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = i - paramTextView.getTotalPaddingLeft();
      int m = j - paramTextView.getTotalPaddingTop();
      int n = k + paramTextView.getScrollX();
      int i1 = m + paramTextView.getScrollY();
      Layout localLayout = paramTextView.getLayout();
      int i2 = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(i1), n);
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramSpannable.getSpans(i2, i2, ClickableSpan.class);
      if (arrayOfClickableSpan.length != 0)
        arrayOfClickableSpan[0].onClick(paramTextView);
    }
    for (boolean bool = true; ; bool = super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent))
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.ComposerMovementMethod
 * JD-Core Version:    0.6.0
 */