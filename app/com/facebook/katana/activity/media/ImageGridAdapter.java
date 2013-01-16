package com.facebook.katana.activity.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.view.vault.GridItemController;
import com.facebook.katana.view.vault.GridItemController.OnClickListener;
import com.facebook.katana.view.vault.GridItemController.OnLongClickListener;
import com.facebook.katana.view.vault.GridItemController.SelectionListener;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class ImageGridAdapter<T extends GridItemController> extends ArrayAdapter<MediaItem>
  implements SelectionState.SelectionListener, GridItemController.OnClickListener, GridItemController.OnLongClickListener, GridItemController.SelectionListener
{
  private ImageGridAdapter.OnItemClickListener a;
  private AdapterView<?> b;
  private SelectionState c;
  private MediaPickerActivity.SelectedMode d;
  private List<MediaItem> e;
  private List<MediaItem> f;
  private ImageGridPhotoManager g;
  private ImageGridAdapter.OnItemLongClickListener h;

  public ImageGridAdapter(Context paramContext, AbsListView paramAbsListView)
  {
    this(paramContext, paramAbsListView, (ImageGridPhotoManager)FbInjector.a(paramContext).a(ImageGridPhotoManager.class));
  }

  public ImageGridAdapter(Context paramContext, AbsListView paramAbsListView, ImageGridPhotoManager paramImageGridPhotoManager)
  {
    super(paramContext, 0);
    this.g = paramImageGridPhotoManager;
    this.g.a(c());
    this.g.a(this);
    this.b = paramAbsListView;
    this.e = Lists.a();
    this.f = Lists.a();
    paramAbsListView.setOnScrollListener(d());
  }

  private void a(long paramLong)
  {
    Iterator localIterator = this.f.iterator();
    while (true)
    {
      MediaItem localMediaItem;
      if (localIterator.hasNext())
      {
        localMediaItem = (MediaItem)localIterator.next();
        if (localMediaItem.e() == MediaItem.MediaType.PHOTO)
          break label42;
      }
      while (true)
      {
        return;
        label42: if (localMediaItem.a() != paramLong)
          break;
        this.f.remove(localMediaItem);
        if (this.d != MediaPickerActivity.SelectedMode.SELECTED)
          continue;
        remove(localMediaItem);
      }
    }
  }

  private void a(MediaItem paramMediaItem, Bitmap paramBitmap)
  {
    if (paramBitmap == null);
    while (true)
    {
      return;
      View localView = b(paramMediaItem);
      if (localView == null)
        continue;
      ((GridItemController)localView.getTag()).a(paramBitmap);
    }
  }

  private MediaItem b(long paramLong)
  {
    Iterator localIterator = this.e.iterator();
    MediaItem localMediaItem;
    do
    {
      if (!localIterator.hasNext())
        break;
      localMediaItem = (MediaItem)localIterator.next();
    }
    while ((localMediaItem.a() != paramLong) || (localMediaItem.e() != MediaItem.MediaType.PHOTO));
    while (true)
    {
      return localMediaItem;
      localMediaItem = null;
    }
  }

  private void b(List<MediaItem> paramList)
  {
    clear();
    setNotifyOnChange(false);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      add((MediaItem)localIterator.next());
    g();
    notifyDataSetChanged();
  }

  private ImageLoadedCallback c()
  {
    return new ImageGridAdapter.1(this);
  }

  private void c(List<MediaItem> paramList)
  {
    this.e.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MediaItem localMediaItem = (MediaItem)localIterator.next();
      this.e.add(localMediaItem);
    }
  }

  private AbsListView.OnScrollListener d()
  {
    return new ImageGridAdapter.2(this);
  }

  private void e()
  {
    int i = this.b.getFirstVisiblePosition();
    int j = this.b.getLastVisiblePosition();
    if ((i >= 0) && (j >= 0))
      this.g.a(i, j);
  }

  private void f()
  {
    this.f.clear();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      MediaItem localMediaItem = (MediaItem)localIterator.next();
      if ((localMediaItem.e() != MediaItem.MediaType.PHOTO) || (!this.c.c(localMediaItem)))
        continue;
      this.f.add(localMediaItem);
    }
  }

  private void g()
  {
    sort(MediaItem.a);
  }

  public Bitmap a(MediaItem paramMediaItem)
  {
    Bitmap localBitmap = this.g.b(paramMediaItem);
    if (localBitmap == null)
    {
      this.g.c(paramMediaItem);
      localBitmap = this.g.b(paramMediaItem);
    }
    return localBitmap;
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, GridItemController paramGridItemController)
  {
    MediaItem localMediaItem = (MediaItem)getItem(paramInt);
    if (paramGridItemController.b(localMediaItem))
      return paramView;
    paramGridItemController.a(localMediaItem);
    Bitmap localBitmap = this.g.b(localMediaItem);
    if (localBitmap != null)
      paramGridItemController.a(localBitmap);
    while (true)
    {
      paramGridItemController.a(this.c.c(localMediaItem));
      break;
      this.g.c(localMediaItem);
    }
  }

  void a()
  {
    this.g.a();
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    MediaItem localMediaItem = b(paramLong);
    View localView;
    if (paramBoolean)
    {
      this.f.add(localMediaItem);
      localView = b(localMediaItem);
      if (localView != null)
        break label45;
    }
    while (true)
    {
      return;
      a(paramLong);
      break;
      label45: ((GridItemController)localView.getTag()).a(paramBoolean);
    }
  }

  public void a(ImageGridAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.a = paramOnItemClickListener;
  }

  public void a(MediaPickerActivity.SelectedMode paramSelectedMode)
  {
    this.d = paramSelectedMode;
    if (this.d == MediaPickerActivity.SelectedMode.SELECTED)
      b(this.f);
    while (true)
    {
      notifyDataSetInvalidated();
      return;
      b(this.e);
    }
  }

  public void a(SelectionState paramSelectionState)
  {
    if (this.c != null)
      this.c.b(this);
    this.c = paramSelectionState;
    this.c.a(this);
  }

  public void a(GridItemController paramGridItemController)
  {
    if ((this.a != null) && (paramGridItemController != null))
      this.a.a(paramGridItemController.c());
  }

  public void a(GridItemController paramGridItemController, boolean paramBoolean)
  {
    if (paramGridItemController.c().e() == MediaItem.MediaType.VIDEO)
      a(paramGridItemController);
    while (true)
    {
      return;
      if (paramBoolean)
      {
        if (this.c.a(paramGridItemController.c()))
          continue;
        this.c.a(getContext());
        paramGridItemController.a(false);
        continue;
      }
      this.c.b(paramGridItemController.c());
    }
  }

  public void a(List<MediaItem> paramList)
  {
    c(paramList);
    f();
    b(paramList);
  }

  public View b(MediaItem paramMediaItem)
  {
    int i = this.b.getLastVisiblePosition() - this.b.getFirstVisiblePosition();
    int j = 0;
    View localView2;
    if (j <= i)
    {
      localView2 = this.b.getChildAt(j);
      if (localView2 == null);
      GridItemController localGridItemController;
      do
      {
        j++;
        break;
        localGridItemController = (GridItemController)localView2.getTag();
      }
      while ((localGridItemController.c() == null) || (!localGridItemController.c().b().equals(paramMediaItem.b())));
    }
    for (View localView1 = localView2; ; localView1 = null)
      return localView1;
  }

  void b()
  {
    this.g.b();
  }

  public void b(GridItemController paramGridItemController)
  {
    if ((this.h != null) && (paramGridItemController != null))
      this.h.a(paramGridItemController.c());
  }

  public void c(MediaItem paramMediaItem)
  {
    this.g.a(paramMediaItem);
  }

  public boolean hasStableIds()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.ImageGridAdapter
 * JD-Core Version:    0.6.0
 */