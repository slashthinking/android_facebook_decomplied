package com.facebook.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.orca.ui.touch.DragMotionDetector;

class ScreenSlider$6
  implements View.OnTouchListener
{
  ScreenSlider$6(ScreenSlider paramScreenSlider)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (ScreenSlider.d(this.a) < 0.0F)
    {
      int[] arrayOfInt = new int[2];
      ScreenSlider.i(this.a).getLocationInWindow(arrayOfInt);
      ScreenSlider.a(this.a, arrayOfInt[0] + ScreenSlider.i(this.a).getWidth() / 2.0F);
    }
    ScreenSlider.f(this.a).a(paramMotionEvent);
    return true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ScreenSlider.6
 * JD-Core Version:    0.6.2
 */