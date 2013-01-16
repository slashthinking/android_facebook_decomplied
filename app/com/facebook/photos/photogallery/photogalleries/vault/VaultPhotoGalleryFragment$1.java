package com.facebook.photos.photogallery.photogalleries.vault;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class VaultPhotoGalleryFragment$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.a.p());
    localBuilder.setTitle(this.a.e(2131362162));
    localBuilder.setIcon(this.a.p().getResources().getDrawable(17301543));
    localBuilder.setMessage(2131362163);
    localBuilder.setPositiveButton(2131362164, new VaultPhotoGalleryFragment.1.1(this));
    localBuilder.setNegativeButton(2131362165, null);
    localBuilder.setCancelable(true);
    localBuilder.create().show();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.vault.VaultPhotoGalleryFragment.1
 * JD-Core Version:    0.6.0
 */