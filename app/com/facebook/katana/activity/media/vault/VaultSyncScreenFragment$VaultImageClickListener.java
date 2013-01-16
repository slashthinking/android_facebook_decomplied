package com.facebook.katana.activity.media.vault;

import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.katana.service.vault.VaultTable;
import com.facebook.photos.grid.UrlImageGridAdapter.OnItemClickListener;
import com.facebook.photos.photogallery.GalleryLauncher;
import com.facebook.photos.photogallery.photos.VaultLocalPhoto;
import com.facebook.photos.photogallery.photos.VaultPhoto;

class VaultSyncScreenFragment$VaultImageClickListener
  implements UrlImageGridAdapter.OnItemClickListener
{
  private VaultSyncScreenFragment$VaultImageClickListener(VaultSyncScreenFragment paramVaultSyncScreenFragment)
  {
  }

  public void a(int paramInt)
  {
    VaultSyncScreenFragment.a(this.a, (VaultPhoto)VaultSyncScreenFragment.f(this.a).getItem(paramInt));
    if ((VaultSyncScreenFragment.m(this.a) instanceof VaultLocalPhoto))
      if (VaultSyncScreenFragment.g(this.a).a(((VaultLocalPhoto)VaultSyncScreenFragment.m(this.a)).b()).b())
        VaultSyncScreenFragment.a(this.a, VaultSyncScreenFragment.n(this.a));
    while (true)
    {
      return;
      VaultSyncScreenFragment.o(this.a).a(paramInt);
      continue;
      VaultSyncScreenFragment.o(this.a).a(paramInt);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.VaultImageClickListener
 * JD-Core Version:    0.6.0
 */