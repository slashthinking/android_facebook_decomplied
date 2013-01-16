package com.facebook.photos.photogallery.photogalleries.production;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.photos.photogallery.LaunchableGalleryFragment;
import com.facebook.photos.photogallery.PhotoFragment;
import com.facebook.photos.photogallery.PhotoFragmentFactory;
import com.facebook.photos.photogallery.PhotoGallery;
import com.facebook.photos.photogallery.PhotoSource;
import com.facebook.photos.photogallery.photos.LocalPhoto;
import com.facebook.photos.photogallery.tags.TaggedPhotoFragment;
import com.facebook.photos.photogallery.tags.TaggingInterface;

public class ProductionPhotoGalleryFragment extends LaunchableGalleryFragment<LocalPhoto, TaggedPhotoFragment>
{
  private TaggingInterface b;
  private ProductionPhotoDataAdapter c;

  protected void P()
  {
  }

  protected void Q()
  {
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903511, paramViewGroup, false);
    a((PhotoGallery)localView.findViewById(2131296552));
    this.b = ((TaggingInterface)localView.findViewById(2131296553));
    this.b.a(this.c.a(), new ProductionPhotoGalleryFragment.1(this));
    this.b.a(new ProductionPhotoGalleryFragment.TaggingInterfaceListener(this, null));
    return localView;
  }

  protected void a(int paramInt, PhotoFragment paramPhotoFragment)
  {
    ((TaggedPhotoFragment)paramPhotoFragment).a(true);
  }

  public void a(int paramInt, PhotoSource paramPhotoSource, PhotoFragmentFactory paramPhotoFragmentFactory, FragmentManager paramFragmentManager)
  {
    throw new IllegalArgumentException("Missing data adapter, use other init method");
  }

  public void a(int paramInt, PhotoSource paramPhotoSource, PhotoFragmentFactory paramPhotoFragmentFactory, FragmentManager paramFragmentManager, ProductionPhotoDataAdapter paramProductionPhotoDataAdapter)
  {
    super.a(paramInt, paramPhotoSource, paramPhotoFragmentFactory, paramFragmentManager);
    this.c = paramProductionPhotoDataAdapter;
  }

  protected void b(int paramInt, PhotoFragment paramPhotoFragment)
  {
    ((TaggedPhotoFragment)L()).a(new ProductionPhotoGalleryFragment.2(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.production.ProductionPhotoGalleryFragment
 * JD-Core Version:    0.6.0
 */