package com.facebook.katana.activity.media.vault;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.photos.grid.UrlImageGridAdapter.OnGridPopulatedListener;

class VaultSyncScreenFragment$VaultGridPopulatedListener
  implements UrlImageGridAdapter.OnGridPopulatedListener
{
  private VaultSyncScreenFragment$VaultGridPopulatedListener(VaultSyncScreenFragment paramVaultSyncScreenFragment)
  {
  }

  public void a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)VaultSyncScreenFragment.p(this.a).getLayoutParams();
    localLayoutParams.leftMargin = arrayOfInt[0];
    localLayoutParams.topMargin = (30 + arrayOfInt[1]);
    VaultSyncScreenFragment.p(this.a).setLayoutParams(localLayoutParams);
    VaultSyncScreenFragment.p(this.a).setOnClickListener(new VaultSyncScreenFragment.VaultGridPopulatedListener.1(this));
    VaultSyncScreenFragment.p(this.a).bringToFront();
    VaultSyncScreenFragment.p(this.a).setVisibility(0);
    this.a.m().putBoolean("from_nux", false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.VaultGridPopulatedListener
 * JD-Core Version:    0.6.0
 */