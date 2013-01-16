package com.facebook.katana.activity.media.vault;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.katana.activity.media.TransparentVaultFragment;

public class VaultSyncedPhotoFragment extends TransparentVaultFragment
{
  private VaultSyncedPhotoFragment.OnSyncedPhotoOptionSelectedListener a;

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return b(paramLayoutInflater.inflate(2130903631, paramViewGroup, false));
  }

  public void a(VaultSyncedPhotoFragment.OnSyncedPhotoOptionSelectedListener paramOnSyncedPhotoOptionSelectedListener)
  {
    this.a = paramOnSyncedPhotoOptionSelectedListener;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    A().findViewById(2131297978).setOnClickListener(new VaultSyncedPhotoFragment.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncedPhotoFragment
 * JD-Core Version:    0.6.0
 */