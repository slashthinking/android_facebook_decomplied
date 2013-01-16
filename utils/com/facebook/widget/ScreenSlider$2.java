package com.facebook.widget;

import com.facebook.orca.ui.touch.DragMotionDetector;
import com.facebook.orca.ui.touch.Draggable;

class ScreenSlider$2
  implements Draggable
{
  ScreenSlider$2(ScreenSlider paramScreenSlider)
  {
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    ScreenSlider.e(this.a).a(paramFloat1 - ScreenSlider.d(this.a));
  }

  public void b(float paramFloat1, float paramFloat2)
  {
    ScreenSlider.e(this.a).b(paramFloat1 - ScreenSlider.d(this.a));
  }

  public void c(float paramFloat1, float paramFloat2)
  {
    ScreenSlider.ScreenSliderOpenListener localScreenSliderOpenListener = ScreenSlider.e(this.a);
    float f = paramFloat1 - ScreenSlider.d(this.a);
    if (ScreenSlider.f(this.a).a() < -20.0F);
    for (boolean bool = true; ; bool = false)
    {
      localScreenSliderOpenListener.a(f, bool);
      return;
    }
  }

  public void d(float paramFloat1, float paramFloat2)
  {
    ScreenSlider.e(this.a).a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ScreenSlider.2
 * JD-Core Version:    0.6.2
 */