package com.facebook.katana.activity.media.vault;

import android.support.v4.app.Fragment;
import android.view.View.OnClickListener;

public abstract class VaultOptInFragment extends Fragment
  implements View.OnClickListener
{
  protected String a;
  protected int b;

  public VaultOptInFragment a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public abstract void a(VaultOptInFragment.OnOptionSelectedListener paramOnOptionSelectedListener);

  public VaultOptInFragment f(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultOptInFragment
 * JD-Core Version:    0.6.0
 */