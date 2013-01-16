package com.facebook.katana.activity.media.vault;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout.LayoutParams;

class VaultSyncScreenFragment$1 extends GestureDetector.SimpleOnGestureListener
{
  private float[] b = new float[4];
  private int c = 0;

  private boolean a(float paramFloat)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    if (i < this.b.length)
    {
      if (this.b[i] > 0.0F)
        k++;
      while (true)
      {
        i++;
        break;
        j++;
      }
    }
    int m;
    if ((paramFloat < 0.0F) || (k <= j))
    {
      boolean bool = paramFloat < 0.0F;
      m = 0;
      if (bool)
      {
        m = 0;
        if (j <= k);
      }
    }
    else
    {
      m = 1;
    }
    return m;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i = VaultSyncScreenFragment.a(this.a).getHeight();
    float f = ((LinearLayout.LayoutParams)VaultSyncScreenFragment.a(this.a).getLayoutParams()).topMargin;
    if ((VaultSyncScreenFragment.b(this.a) == VaultSyncScreenFragment.VaultChromeVisibility.VISIBLE) && (paramFloat2 < -VaultSyncScreenFragment.c(this.a)) && (f > -i))
      this.a.a(false);
    while (true)
    {
      return false;
      if ((VaultSyncScreenFragment.b(this.a) != VaultSyncScreenFragment.VaultChromeVisibility.HIDDEN) || (paramFloat2 <= VaultSyncScreenFragment.c(this.a)))
        continue;
      this.a.a(true);
    }
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.b[this.c] = paramFloat2;
    this.c = ((1 + this.c) % this.b.length);
    if (!a(paramFloat2));
    int i;
    LinearLayout.LayoutParams localLayoutParams;
    float f;
    do
    {
      return true;
      i = VaultSyncScreenFragment.a(this.a).getHeight();
      localLayoutParams = new LinearLayout.LayoutParams(new ViewGroup.MarginLayoutParams(-1, i));
      f = ((LinearLayout.LayoutParams)VaultSyncScreenFragment.a(this.a).getLayoutParams()).topMargin;
    }
    while (((f <= -i) && (paramFloat2 > 0.0F)) || ((f >= 0.0F) && (paramFloat2 < 0.0F)));
    if (paramFloat2 < 0.0F);
    for (int j = Math.min((int)(f + Math.abs(paramFloat2 * 5.0F)), 0); ; j = Math.max((int)(f - paramFloat2 * 5.0F), -i))
    {
      VaultSyncScreenFragment.a(this.a, j);
      localLayoutParams.setMargins(0, j, 0, 0);
      VaultSyncScreenFragment.a(this.a).setLayoutParams(localLayoutParams);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.1
 * JD-Core Version:    0.6.0
 */