package com.facebook.katana.activity.media.vault;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.nineoldandroids.animation.IntEvaluator;

class VaultSyncScreenFragment$TopMarginEvaluator extends IntEvaluator
{
  private View b;

  public VaultSyncScreenFragment$TopMarginEvaluator(VaultSyncScreenFragment paramVaultSyncScreenFragment, View paramView)
  {
    this.b = paramView;
  }

  public Integer a(float paramFloat, Integer paramInteger1, Integer paramInteger2)
  {
    int i = super.a(paramFloat, paramInteger1, paramInteger2).intValue();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(new ViewGroup.MarginLayoutParams(-1, this.b.getHeight()));
    localLayoutParams.setMargins(0, i, 0, 0);
    this.b.setLayoutParams(localLayoutParams);
    return Integer.valueOf(i);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.TopMarginEvaluator
 * JD-Core Version:    0.6.0
 */