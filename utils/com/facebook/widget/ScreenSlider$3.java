package com.facebook.widget;

import com.facebook.orca.ui.touch.DragMotionDetector;
import com.facebook.orca.ui.touch.Draggable;

class ScreenSlider$3
  implements Draggable
{
  ScreenSlider$3(ScreenSlider paramScreenSlider)
  {
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    ScreenSlider.a(this.a);
    this.a.d();
  }

  public void b(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1 - ScreenSlider.d(this.a);
    int i = ScreenSlider.c(this.a);
    if (this.a.j());
    for (float f2 = Math.max(0.0F, Math.min(f1 + i, i)); ; f2 = Math.min(0.0F, Math.max(f1 - i, -i)))
    {
      ScreenSlider.a(this.a, (int)f2);
      return;
    }
  }

  public void c(float paramFloat1, float paramFloat2)
  {
    if (ScreenSlider.g(this.a).a() > 20.0F)
      ScreenSlider.a(this.a, 50L);
    while (true)
    {
      return;
      ScreenSlider.a(this.a, 50, null);
    }
  }

  public void d(float paramFloat1, float paramFloat2)
  {
    this.a.n();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ScreenSlider.3
 * JD-Core Version:    0.6.2
 */