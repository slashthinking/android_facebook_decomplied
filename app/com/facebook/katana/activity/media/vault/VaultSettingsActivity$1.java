package com.facebook.katana.activity.media.vault;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.vault.VaultHelpers;

class VaultSettingsActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    boolean bool = ((CheckBox)paramView).isChecked();
    UserValuesManager.c(this.a, bool);
    new VaultSettingsActivity.1.1(this, bool).start();
    VaultSettingsActivity.a(this.a, bool);
    if (bool)
      VaultHelpers.c(this.a, 10);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSettingsActivity.1
 * JD-Core Version:    0.6.0
 */