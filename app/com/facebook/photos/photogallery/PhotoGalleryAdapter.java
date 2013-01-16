package com.facebook.photos.photogallery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PhotoGalleryAdapter extends FragmentStatePagerAdapter
{
  private PhotoSource a;
  private PhotoFragmentFactory b;
  private PhotoGalleryAdapter.PhotoGalleryAdapterListener c;

  public PhotoGalleryAdapter(FragmentManager paramFragmentManager, PhotoSource paramPhotoSource, PhotoFragmentFactory paramPhotoFragmentFactory)
  {
    super(paramFragmentManager);
    this.a = paramPhotoSource;
    this.b = paramPhotoFragmentFactory;
  }

  public Fragment a(int paramInt)
  {
    Photo localPhoto = this.a.a(paramInt);
    PhotoFragment localPhotoFragment = this.b.a(localPhoto);
    this.c.a(paramInt, localPhotoFragment);
    return localPhotoFragment;
  }

  public void a(PhotoGalleryAdapter.PhotoGalleryAdapterListener paramPhotoGalleryAdapterListener)
  {
    this.c = paramPhotoGalleryAdapterListener;
  }

  public int b()
  {
    return this.a.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.PhotoGalleryAdapter
 * JD-Core Version:    0.6.0
 */