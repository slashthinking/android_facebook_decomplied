package com.facebook.katana.activity.media.vault;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.katana.activity.media.TransparentVaultFragment;

public class VaultFailedPhotoFragment extends TransparentVaultFragment
{
  private VaultFailedPhotoFragment.OnFailedPhotoOptionSelectedListener a;

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return b(paramLayoutInflater.inflate(2130903622, paramViewGroup, false));
  }

  public void a(VaultFailedPhotoFragment.OnFailedPhotoOptionSelectedListener paramOnFailedPhotoOptionSelectedListener)
  {
    this.a = paramOnFailedPhotoOptionSelectedListener;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    A().findViewById(2131297943).setOnClickListener(new VaultFailedPhotoFragment.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultFailedPhotoFragment
 * JD-Core Version:    0.6.0
 */