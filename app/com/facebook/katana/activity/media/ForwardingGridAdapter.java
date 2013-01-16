package com.facebook.katana.activity.media;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.view.vault.GridItemController;
import com.facebook.katana.view.vault.GridItemController.OnClickListener;
import com.facebook.katana.view.vault.GridItemController.OnLongClickListener;
import com.facebook.katana.view.vault.GridItemController.SelectionListener;
import java.util.List;

public class ForwardingGridAdapter<T extends GridItemController>
  implements ListAdapter, SelectionState.SelectionListener, GridItemController.OnClickListener, GridItemController.OnLongClickListener, GridItemController.SelectionListener
{
  ImageGridAdapter<T> a;

  public ForwardingGridAdapter(ImageGridAdapter<T> paramImageGridAdapter)
  {
    this.a = paramImageGridAdapter;
  }

  public Context a()
  {
    return this.a.getContext();
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, GridItemController paramGridItemController)
  {
    return this.a.a(paramInt, paramView, paramViewGroup, paramGridItemController);
  }

  public View a(MediaItem paramMediaItem)
  {
    return this.a.b(paramMediaItem);
  }

  public MediaItem a(long paramLong)
  {
    int i = 0;
    if (i < this.a.getCount())
      if (((MediaItem)this.a.getItem(i)).a() != paramLong);
    for (MediaItem localMediaItem = (MediaItem)this.a.getItem(i); ; localMediaItem = null)
    {
      return localMediaItem;
      i++;
      break;
    }
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    this.a.a(paramLong, paramBoolean);
  }

  public void a(ImageGridAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.a.a(paramOnItemClickListener);
  }

  public void a(MediaPickerActivity.SelectedMode paramSelectedMode)
  {
    this.a.a(paramSelectedMode);
  }

  public void a(SelectionState paramSelectionState)
  {
    this.a.a(paramSelectionState);
  }

  public void a(GridItemController paramGridItemController)
  {
    this.a.a(paramGridItemController);
  }

  public void a(GridItemController paramGridItemController, boolean paramBoolean)
  {
    this.a.a(paramGridItemController, paramBoolean);
  }

  public void a(List<MediaItem> paramList)
  {
    this.a.a(paramList);
  }

  public boolean areAllItemsEnabled()
  {
    return this.a.areAllItemsEnabled();
  }

  public void b()
  {
    this.a.a();
  }

  public void b(MediaItem paramMediaItem)
  {
    this.a.c(paramMediaItem);
  }

  public void b(GridItemController paramGridItemController)
  {
    this.a.b(paramGridItemController);
  }

  public Bitmap c(MediaItem paramMediaItem)
  {
    return this.a.a(paramMediaItem);
  }

  public void c()
  {
    this.a.b();
  }

  public int d(MediaItem paramMediaItem)
  {
    int i = 0;
    if (i < this.a.getCount())
      if (((MediaItem)this.a.getItem(i)).a() != paramMediaItem.a());
    while (true)
    {
      return i;
      i++;
      break;
      i = -1;
    }
  }

  public int getCount()
  {
    return this.a.getCount();
  }

  public Object getItem(int paramInt)
  {
    return this.a.getItem(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return this.a.getItemId(paramInt);
  }

  public int getItemViewType(int paramInt)
  {
    return this.a.getItemViewType(paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.a.getView(paramInt, paramView, paramViewGroup);
  }

  public int getViewTypeCount()
  {
    return this.a.getViewTypeCount();
  }

  public boolean hasStableIds()
  {
    return this.a.hasStableIds();
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public boolean isEnabled(int paramInt)
  {
    return this.a.isEnabled(paramInt);
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerDataSetObserver(paramDataSetObserver);
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterDataSetObserver(paramDataSetObserver);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.ForwardingGridAdapter
 * JD-Core Version:    0.6.0
 */