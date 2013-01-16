package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class PreHoneycombCompat$12 extends IntProperty<View>
{
  PreHoneycombCompat$12(String paramString)
  {
    super(paramString);
  }

  public Integer a(View paramView)
  {
    return Integer.valueOf(AnimatorProxy.a(paramView).getScrollY());
  }

  public void a(View paramView, int paramInt)
  {
    AnimatorProxy.a(paramView).setScrollY(paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.PreHoneycombCompat.12
 * JD-Core Version:    0.6.2
 */