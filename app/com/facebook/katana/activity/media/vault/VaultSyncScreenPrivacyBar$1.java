package com.facebook.katana.activity.media.vault;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.katana.service.vault.VaultHelpers;

class VaultSyncScreenPrivacyBar$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (VaultHelpers.a(VaultSyncScreenPrivacyBar.a(this.a), 12))
    {
      this.a.c();
      VaultHelpers.c(VaultSyncScreenPrivacyBar.a(this.a), 12);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenPrivacyBar.1
 * JD-Core Version:    0.6.0
 */