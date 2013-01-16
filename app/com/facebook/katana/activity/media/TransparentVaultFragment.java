package com.facebook.katana.activity.media;

import android.support.v4.app.Fragment;
import android.view.View;

public class TransparentVaultFragment extends Fragment
{
  public View b(View paramView)
  {
    paramView.setOnTouchListener(new TransparentVaultFragment.1(this));
    return paramView;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.TransparentVaultFragment
 * JD-Core Version:    0.6.0
 */