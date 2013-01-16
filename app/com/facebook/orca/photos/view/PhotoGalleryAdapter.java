package com.facebook.orca.photos.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.base.Preconditions;
import java.util.List;

public class PhotoGalleryAdapter extends BaseAdapter
{
  private List<PhotoMessageItem> a;
  private Context b;

  public PhotoGalleryAdapter(Context paramContext, List<PhotoMessageItem> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }

  public int getCount()
  {
    return this.a.size();
  }

  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    Preconditions.checkNotNull(localObject, "Null item in PhotoGalleryAdapter.getView");
    PhotoMessageItem localPhotoMessageItem = (PhotoMessageItem)localObject;
    PhotoMessageView localPhotoMessageView = (PhotoMessageView)paramView;
    if (localPhotoMessageView == null)
      localPhotoMessageView = new PhotoMessageView(this.b);
    localPhotoMessageView.setPhotoMessageItem(localPhotoMessageItem);
    return localPhotoMessageView;
  }

  public int getViewTypeCount()
  {
    return 1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.view.PhotoGalleryAdapter
 * JD-Core Version:    0.6.0
 */