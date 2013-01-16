package com.facebook.photos.photogallery;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ViewTreeObserver;
import com.facebook.widget.CustomFrameLayout;
import java.util.ArrayList;
import java.util.List;

public class PhotoGallery extends CustomFrameLayout
{
  private int a;
  private PhotoSource b;
  private PhotoFragmentFactory c;
  private ZoomableViewPager d;
  private PhotoGallery.PhotoGalleryListenerAdapter e;

  public PhotoGallery(Context paramContext)
  {
    this(paramContext, null);
  }

  public PhotoGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903481);
    this.d = ((ZoomableViewPager)b(2131297670));
  }

  private PhotoFragment a(int paramInt)
  {
    return (PhotoFragment)this.d.getAdapter().a(this.d, paramInt);
  }

  public void a()
  {
    this.e.b();
    this.d.setAdapter(null);
  }

  public void a(int paramInt, PhotoSource paramPhotoSource, PhotoFragmentFactory paramPhotoFragmentFactory, FragmentManager paramFragmentManager)
  {
    this.a = paramInt;
    this.b = paramPhotoSource;
    this.c = paramPhotoFragmentFactory;
    PhotoGalleryAdapter localPhotoGalleryAdapter = new PhotoGalleryAdapter(paramFragmentManager, this.b, this.c);
    localPhotoGalleryAdapter.a(new PhotoGallery.1(this));
    this.d.setPageMargin(20);
    this.d.setAdapter(localPhotoGalleryAdapter);
    this.d.setCurrentItem(this.a);
    this.d.setOnPageChangeListener(new PhotoGallery.2(this));
    getViewTreeObserver().addOnGlobalLayoutListener(new PhotoGallery.3(this));
  }

  public void a(PhotoGallery.PhotoGalleryListenerAdapter paramPhotoGalleryListenerAdapter)
  {
    this.e = paramPhotoGalleryListenerAdapter;
  }

  public void b()
  {
    this.d.j();
  }

  public void c()
  {
    this.d.k();
  }

  public int getCurrentIndex()
  {
    return this.d.getCurrentItem();
  }

  public PhotoFragment getCurrentPhotoFragment()
  {
    return a(getCurrentIndex());
  }

  public List<Pair<Integer, PhotoFragment>> getPhotoFragments()
  {
    ArrayList localArrayList = new ArrayList();
    if (getCurrentIndex() > 0)
      localArrayList.add(new Pair(Integer.valueOf(-1 + getCurrentIndex()), a(-1 + getCurrentIndex())));
    localArrayList.add(new Pair(Integer.valueOf(getCurrentIndex()), a(getCurrentIndex())));
    if (getCurrentIndex() < -1 + this.b.a())
      localArrayList.add(new Pair(Integer.valueOf(1 + getCurrentIndex()), a(1 + getCurrentIndex())));
    return localArrayList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.PhotoGallery
 * JD-Core Version:    0.6.0
 */