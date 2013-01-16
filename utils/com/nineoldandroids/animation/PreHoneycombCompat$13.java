package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class PreHoneycombCompat$13 extends FloatProperty<View>
{
  PreHoneycombCompat$13(String paramString)
  {
    super(paramString);
  }

  public Float a(View paramView)
  {
    return Float.valueOf(AnimatorProxy.a(paramView).getX());
  }

  public void a(View paramView, float paramFloat)
  {
    AnimatorProxy.a(paramView).setX(paramFloat);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.PreHoneycombCompat.13
 * JD-Core Version:    0.6.2
 */