package com.facebook.katana.activity.media;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.facedetection.FaceDetectionGating;
import com.facebook.facedetection.Tracker;
import com.facebook.katana.features.camera.FaceDetectionGatingHandler;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.provider.LocalPhotoTagProvider;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MediaPickerGalleryAdapter extends PagerAdapter
{
  private List<MediaItem> a = new ArrayList();
  private final ViewPager b;
  private final LayoutInflater c;
  private volatile int d = 0;
  private volatile int e = 0;
  private Context f;
  private MediaTagController g;
  private MediaPickerGalleryAdapter.MediaImageLoadedListener h = null;
  private PhotoPage i;
  private MediaPickerGalleryAdapter.FaceboxClickedHandler j;
  private MediaTagController.FaceboxClickedListener k;
  private List<MediaItem> l;
  private List<MediaItem> m;
  private SelectionState n;
  private MediaPickerActivity.SelectedMode o;

  public MediaPickerGalleryAdapter(Context paramContext, ViewPager paramViewPager)
  {
    this.b = paramViewPager;
    this.f = paramContext;
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.g = new MediaTagController(this.f, (View)this.b.getParent(), this.c, this, Tracker.a(paramContext, (FaceDetectionGating)FbInjector.a(this.f).a(FaceDetectionGatingHandler.class)));
    this.j = new MediaPickerGalleryAdapter.FaceboxClickedHandler(this, null);
    this.g.a(this.j);
    this.l = Lists.a();
    this.m = Lists.a();
  }

  private void b(List<MediaItem> paramList)
  {
    this.a.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MediaItem localMediaItem = (MediaItem)localIterator.next();
      if (localMediaItem.e() != MediaItem.MediaType.PHOTO)
        continue;
      this.a.add(localMediaItem);
    }
    p();
  }

  private void c(MediaItem paramMediaItem)
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      MediaItem localMediaItem = (MediaItem)localIterator.next();
      if (localMediaItem.a() != paramMediaItem.a())
        continue;
      this.m.remove(localMediaItem);
    }
  }

  private void c(List<MediaItem> paramList)
  {
    this.l.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MediaItem localMediaItem = (MediaItem)localIterator.next();
      this.l.add(localMediaItem);
    }
  }

  private void p()
  {
    Collections.sort(this.a, MediaItem.a);
  }

  private void q()
  {
    this.m.clear();
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      MediaItem localMediaItem = (MediaItem)localIterator.next();
      if (!this.n.c(localMediaItem))
        continue;
      this.m.add(localMediaItem);
    }
  }

  public MediaItem a(int paramInt)
  {
    if (paramInt > -1);
    for (MediaItem localMediaItem = (MediaItem)this.a.get(paramInt); ; localMediaItem = null)
      return localMediaItem;
  }

  public MediaItem a(long paramLong)
  {
    Iterator localIterator = this.l.iterator();
    MediaItem localMediaItem;
    do
    {
      if (!localIterator.hasNext())
        break;
      localMediaItem = (MediaItem)localIterator.next();
    }
    while (localMediaItem.a() != paramLong);
    while (true)
    {
      return localMediaItem;
      localMediaItem = null;
    }
  }

  public Object a(ViewGroup paramViewGroup, int paramInt)
  {
    MediaItem localMediaItem = (MediaItem)this.a.get(paramInt);
    if ((this.d == 0) || (this.e == 0))
    {
      this.d = paramViewGroup.getHeight();
      this.e = paramViewGroup.getWidth();
    }
    PhotoPage localPhotoPage = new PhotoPage(this.f, (PhotoItem)localMediaItem, this, this.e, this.d);
    localPhotoPage.setTag(localMediaItem);
    ((ViewPager)paramViewGroup).addView(localPhotoPage, 0);
    return localPhotoPage;
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
      this.m.add(a(paramLong));
    while (true)
    {
      return;
      MediaItem localMediaItem = a(paramLong);
      c(localMediaItem);
      if (this.o != MediaPickerActivity.SelectedMode.SELECTED)
        continue;
      this.a.remove(localMediaItem);
      this.b.setAdapter(this);
    }
  }

  public void a(PointF paramPointF)
  {
    this.g.a(paramPointF);
  }

  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ((PhotoPage)paramObject).a();
    ((ViewPager)paramViewGroup).removeView((View)paramObject);
  }

  public void a(FacebookPhotoTagSet paramFacebookPhotoTagSet)
  {
    this.g.a((PhotoItem)d());
    this.g.a(e());
    this.g.a(paramFacebookPhotoTagSet);
  }

  public void a(MediaPickerActivity.SelectedMode paramSelectedMode)
  {
    this.o = paramSelectedMode;
    if (this.o == MediaPickerActivity.SelectedMode.SELECTED)
      b(this.m);
    while (true)
    {
      return;
      b(this.l);
    }
  }

  public void a(MediaPickerGalleryAdapter.MediaImageLoadedListener paramMediaImageLoadedListener)
  {
    this.h = paramMediaImageLoadedListener;
  }

  public void a(MediaTagController.FaceboxClickedListener paramFaceboxClickedListener)
  {
    this.k = paramFaceboxClickedListener;
  }

  public void a(SelectionState paramSelectionState)
  {
    this.n = paramSelectionState;
  }

  public void a(FacebookPhotoTag paramFacebookPhotoTag)
  {
    this.g.a(paramFacebookPhotoTag);
    ContentValues localContentValues = MediaTagController.a(d(), paramFacebookPhotoTag);
    this.f.getContentResolver().insert(LocalPhotoTagProvider.a, localContentValues);
    ((PhotoItem)d()).k().a(paramFacebookPhotoTag);
  }

  public void a(MediaItem paramMediaItem)
  {
    if (this.o == MediaPickerActivity.SelectedMode.SELECTED)
      this.a.remove(paramMediaItem);
  }

  public void a(List<MediaItem> paramList)
  {
    c(paramList);
    q();
    b(paramList);
  }

  public boolean a(View paramView, Object paramObject)
  {
    if (paramView == (View)paramObject);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public int b()
  {
    return this.a.size();
  }

  public int b(MediaItem paramMediaItem)
  {
    if (paramMediaItem == null);
    label61: for (int i1 = -1; ; i1 = -1)
    {
      return i1;
      for (i1 = 0; ; i1++)
      {
        if (i1 >= b())
          break label61;
        if ((this.a.get(i1) != null) && (paramMediaItem.a() == ((MediaItem)this.a.get(i1)).a()))
          break;
      }
    }
  }

  public void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    this.i = ((PhotoPage)paramObject);
  }

  public boolean b(long paramLong)
  {
    return this.g.a(paramLong);
  }

  public boolean b(PointF paramPointF)
  {
    return this.g.b(paramPointF);
  }

  public MediaItem d()
  {
    return a(this.b.getCurrentItem());
  }

  public Pair<MediaItem, MediaItem> e()
  {
    int i1 = this.b.getCurrentItem();
    if (i1 > 0);
    for (MediaItem localMediaItem1 = a(i1 - 1); ; localMediaItem1 = null)
    {
      int i2 = i1 + 1;
      int i3 = this.a.size();
      MediaItem localMediaItem2 = null;
      if (i2 < i3)
        localMediaItem2 = a(i1 + 1);
      return new Pair(localMediaItem1, localMediaItem2);
    }
  }

  public PhotoPage f()
  {
    return this.i;
  }

  public MediaPickerActivity.SelectedMode g()
  {
    return this.o;
  }

  public int h()
  {
    return this.g.d();
  }

  public void i()
  {
    this.g.e();
    this.g.h();
  }

  public FacebookPhotoTag[] j()
  {
    return this.g.f();
  }

  public FacebookPhotoTagSet k()
  {
    return this.g.g();
  }

  public void l()
  {
    this.g.i();
  }

  public void m()
  {
    f().b();
  }

  public void n()
  {
    this.g.k();
  }

  public MediaPickerGalleryAdapter.MediaImageLoadedListener o()
  {
    return this.h;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaPickerGalleryAdapter
 * JD-Core Version:    0.6.0
 */