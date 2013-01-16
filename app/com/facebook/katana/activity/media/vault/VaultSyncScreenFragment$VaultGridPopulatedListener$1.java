package com.facebook.katana.activity.media.vault;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

class VaultSyncScreenFragment$VaultGridPopulatedListener$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(VaultSyncScreenFragment.h(this.a.a), 2130968589);
    localAnimation.setAnimationListener(new VaultSyncScreenFragment.VaultGridPopulatedListener.1.1(this));
    VaultSyncScreenFragment.p(this.a.a).setAnimation(localAnimation);
    VaultSyncScreenFragment.p(this.a.a).setVisibility(8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.VaultGridPopulatedListener.1
 * JD-Core Version:    0.6.0
 */