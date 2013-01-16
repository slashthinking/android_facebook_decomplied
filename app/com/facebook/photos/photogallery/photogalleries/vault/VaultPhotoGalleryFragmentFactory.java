package com.facebook.photos.photogallery.photogalleries.vault;

import android.support.v4.app.FragmentManager;
import com.facebook.photos.photogallery.LaunchableGalleryFragment;
import com.facebook.photos.photogallery.LaunchableGalleryFragmentFactory;
import com.facebook.photos.photogallery.PhotoFragmentFactory;
import com.facebook.photos.photogallery.PhotoSource;

public class VaultPhotoGalleryFragmentFactory
  implements LaunchableGalleryFragmentFactory
{
  private PhotoSource a;
  private FragmentManager b;
  private VaultPhotoGalleryFragment.VaultPhotoGalleryFragmentListener c;

  public VaultPhotoGalleryFragmentFactory(PhotoSource paramPhotoSource, FragmentManager paramFragmentManager, VaultPhotoGalleryFragment.VaultPhotoGalleryFragmentListener paramVaultPhotoGalleryFragmentListener)
  {
    this.a = paramPhotoSource;
    this.b = paramFragmentManager;
    this.c = paramVaultPhotoGalleryFragmentListener;
  }

  public LaunchableGalleryFragment a(int paramInt)
  {
    VaultPhotoGalleryFragment localVaultPhotoGalleryFragment = new VaultPhotoGalleryFragment();
    localVaultPhotoGalleryFragment.a(paramInt, this.a, new PhotoFragmentFactory(), this.b);
    localVaultPhotoGalleryFragment.a(this.c);
    return localVaultPhotoGalleryFragment;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.vault.VaultPhotoGalleryFragmentFactory
 * JD-Core Version:    0.6.0
 */