package com.facebook.photos.photogallery.photogalleries.vault;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.photos.photogallery.LaunchableGalleryFragment;
import com.facebook.photos.photogallery.PhotoFragment;
import com.facebook.photos.photogallery.PhotoGallery;
import com.facebook.photos.photogallery.photos.LocalPhoto;
import com.facebook.widget.ViewTransform;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class VaultPhotoGalleryFragment extends LaunchableGalleryFragment<LocalPhoto, PhotoFragment>
{
  private View b;
  private VaultPhotoGalleryFragment.VaultPhotoGalleryFragmentListener c;

  private void R()
  {
    if (this.c.a(a()))
      this.b.setVisibility(0);
    while (true)
    {
      return;
      this.b.setVisibility(8);
    }
  }

  protected void P()
  {
  }

  protected void Q()
  {
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903626, paramViewGroup, false);
    a((PhotoGallery)localView.findViewById(2131296552));
    this.b = localView.findViewById(2131297952);
    this.b.setOnClickListener(new VaultPhotoGalleryFragment.1(this));
    new ViewTransform(this.b).setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = ViewPropertyAnimator.a(this.b);
    localViewPropertyAnimator.a(100L);
    localViewPropertyAnimator.d(1.0F);
    R();
    return localView;
  }

  protected void a(int paramInt, PhotoFragment paramPhotoFragment)
  {
  }

  public void a(VaultPhotoGalleryFragment.VaultPhotoGalleryFragmentListener paramVaultPhotoGalleryFragmentListener)
  {
    this.c = paramVaultPhotoGalleryFragmentListener;
  }

  protected void b(int paramInt, PhotoFragment paramPhotoFragment)
  {
    R();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.vault.VaultPhotoGalleryFragment
 * JD-Core Version:    0.6.0
 */