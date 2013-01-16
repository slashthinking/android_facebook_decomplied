package com.facebook.widget;

import android.content.Context;
import com.facebook.orca.common.util.SizeUtil;

public class ScreenSlider$ScreenSliderConfig
{
  public final int a;
  public final int b;
  float c;
  float d = -1.0F;
  public final float e;
  public final float f;
  public final float g;
  public final float h;

  public ScreenSlider$ScreenSliderConfig(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if ((paramInt != 1) && (paramInt != -1))
      throw new IllegalStateException("The direction should either be DragMotionDetector.LEFT_DRAG or DragMotionDetector.RIGHT_DRAG");
    this.a = paramInt;
    this.b = (0 - paramInt);
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
    this.f = paramFloat4;
    this.g = paramFloat5;
    this.h = paramFloat6;
  }

  public int a(Context paramContext)
  {
    return SizeUtil.a(paramContext, this.c);
  }

  public int b(Context paramContext)
  {
    return SizeUtil.a(paramContext, this.d);
  }

  public int c(Context paramContext)
  {
    return SizeUtil.a(paramContext, this.e);
  }

  public int d(Context paramContext)
  {
    return SizeUtil.a(paramContext, this.f);
  }

  public int e(Context paramContext)
  {
    return SizeUtil.a(paramContext, this.g);
  }

  public int f(Context paramContext)
  {
    return SizeUtil.a(paramContext, this.h);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ScreenSlider.ScreenSliderConfig
 * JD-Core Version:    0.6.2
 */