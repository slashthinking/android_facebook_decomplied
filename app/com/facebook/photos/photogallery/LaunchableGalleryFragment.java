package com.facebook.photos.photogallery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Pair;
import java.util.List;

public abstract class LaunchableGalleryFragment<T1 extends Photo, T2 extends PhotoFragment> extends Fragment
{
  protected PhotoGallery a;
  private int b;
  private PhotoSource c;
  private PhotoFragmentFactory d;
  private FragmentManager e;
  private LaunchableGalleryFragment.LaunchableGalleryFragmentListener f;

  protected T1 K()
  {
    return this.c.a(a());
  }

  protected T2 L()
  {
    return this.a.getCurrentPhotoFragment();
  }

  protected void M()
  {
    this.a.b();
  }

  protected void N()
  {
    this.a.c();
  }

  protected List<Pair<Integer, PhotoFragment>> O()
  {
    return this.a.getPhotoFragments();
  }

  protected abstract void P();

  protected abstract void Q();

  public int a()
  {
    return this.a.getCurrentIndex();
  }

  protected abstract void a(int paramInt, PhotoFragment paramPhotoFragment);

  public void a(int paramInt, PhotoSource paramPhotoSource, PhotoFragmentFactory paramPhotoFragmentFactory, FragmentManager paramFragmentManager)
  {
    this.b = paramInt;
    this.c = paramPhotoSource;
    this.d = paramPhotoFragmentFactory;
    this.e = paramFragmentManager;
  }

  public void a(LaunchableGalleryFragment.LaunchableGalleryFragmentListener paramLaunchableGalleryFragmentListener)
  {
    this.f = paramLaunchableGalleryFragmentListener;
  }

  protected void a(PhotoGallery paramPhotoGallery)
  {
    this.a = paramPhotoGallery;
    this.a.a(this.b, this.c, this.d, this.e);
    this.a.a(new LaunchableGalleryFragment.1(this));
  }

  public void b()
  {
    this.a.a();
  }

  protected abstract void b(int paramInt, PhotoFragment paramPhotoFragment);

  protected void c()
  {
    this.f.b();
  }

  protected PhotoSource d()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.LaunchableGalleryFragment
 * JD-Core Version:    0.6.0
 */