package com.facebook.photos.grid;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.Photo.PhotoSize;
import com.facebook.widget.UrlImage;
import java.util.Iterator;
import java.util.List;

public abstract class UrlImageGridAdapter<T extends Photo> extends ArrayAdapter<Photo>
{
  protected final Context c;
  protected final LayoutInflater d;
  protected final UrlImageGrid e;
  protected final AdapterView f;
  protected UrlImageGridAdapter.OnItemClickListener g;
  protected UrlImageGridAdapter.OnGridPopulatedListener h;

  public UrlImageGridAdapter(Context paramContext, UrlImageGrid paramUrlImageGrid, AdapterView paramAdapterView)
  {
    super(paramContext, 0);
    this.c = paramContext;
    this.d = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.e = paramUrlImageGrid;
    this.f = paramAdapterView;
  }

  protected abstract int a();

  public abstract void a(int paramInt1, int paramInt2);

  public void a(UrlImageGridAdapter.OnGridPopulatedListener paramOnGridPopulatedListener)
  {
    this.h = paramOnGridPopulatedListener;
  }

  public void a(UrlImageGridAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.g = paramOnItemClickListener;
  }

  public void a(Photo paramPhoto)
  {
    super.remove(paramPhoto);
    if (getCount() == 0)
      this.e.a(UrlImageGrid.UI_STATE.NO_PHOTO);
  }

  public void a(List<T> paramList)
  {
    if (paramList.size() > 0)
    {
      setNotifyOnChange(false);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Photo localPhoto = (Photo)localIterator.next();
        if (b(localPhoto))
          continue;
        add(localPhoto);
      }
      setNotifyOnChange(true);
      c();
      notifyDataSetChanged();
      e();
      this.e.a(UrlImageGrid.UI_STATE.HAS_PHOTO);
    }
  }

  protected abstract int b();

  public boolean b(Photo paramPhoto)
  {
    for (int i = 0; ; i++)
    {
      int j = getCount();
      int k = 0;
      if (i < j)
      {
        Photo localPhoto = (Photo)getItem(i);
        if (!paramPhoto.a(Photo.PhotoSize.THUMBNAIL).a().equals(localPhoto.a(Photo.PhotoSize.THUMBNAIL).a()))
          continue;
        k = 1;
      }
      return k;
    }
  }

  public abstract void c();

  protected void e()
  {
    if (this.h != null)
    {
      View localView = this.f.getChildAt(0);
      if (localView != null)
      {
        this.h.a(localView);
        this.h = null;
      }
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Photo localPhoto = (Photo)getItem(paramInt);
    if (paramView == null)
      paramView = this.d.inflate(a(), paramViewGroup, false);
    for (UrlImage localUrlImage = (UrlImage)paramView.findViewById(b()); ; localUrlImage = (UrlImage)paramView.findViewById(b()))
    {
      localUrlImage.setImageParams(localPhoto.a(Photo.PhotoSize.THUMBNAIL));
      localUrlImage.setOnClickListener(new UrlImageGridAdapter.1(this, paramInt));
      return paramView;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.grid.UrlImageGridAdapter
 * JD-Core Version:    0.6.0
 */