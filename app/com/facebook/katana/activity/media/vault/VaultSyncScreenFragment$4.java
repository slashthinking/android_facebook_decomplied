package com.facebook.katana.activity.media.vault;

import com.facebook.photos.photogallery.photogalleries.vault.VaultPhotoGalleryFragment.VaultPhotoGalleryFragmentListener;
import com.facebook.photos.photogallery.photos.VaultPhoto;

class VaultSyncScreenFragment$4
  implements VaultPhotoGalleryFragment.VaultPhotoGalleryFragmentListener
{
  public boolean a(int paramInt)
  {
    if (((VaultPhoto)VaultSyncScreenFragment.f(this.a).getItem(paramInt)).a() != 0L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void b(int paramInt)
  {
    VaultPhoto localVaultPhoto = (VaultPhoto)VaultSyncScreenFragment.f(this.a).getItem(paramInt);
    VaultSyncScreenFragment.a(this.a, localVaultPhoto);
    new VaultSyncScreenFragment.DeleteImageTask(this.a, null).execute(new VaultPhoto[] { localVaultPhoto });
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.4
 * JD-Core Version:    0.6.0
 */