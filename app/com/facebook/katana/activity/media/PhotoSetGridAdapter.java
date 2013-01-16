package com.facebook.katana.activity.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.util.BitmapCache;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhotoSetGridAdapter extends BasePhotosetAdapter
{
  private final AppSession a;
  private final Set<Long> b = new HashSet();
  private final LayoutInflater c;
  private final AbsListView d;
  private BitmapCache e = new BitmapCache();

  public PhotoSetGridAdapter(Context paramContext, AppSession paramAppSession, AbsListView paramAbsListView)
  {
    super(paramContext);
    this.a = paramAppSession;
    this.c = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.d = paramAbsListView;
  }

  private void a(long paramLong, Bitmap paramBitmap)
  {
    int i = this.d.getLastVisiblePosition() - this.d.getFirstVisiblePosition();
    int j = 0;
    if (j <= i)
    {
      View localView = this.d.getChildAt(j);
      if (localView == null);
      PhotoSetGridAdapter.ViewHolder localViewHolder;
      do
      {
        j++;
        break;
        localViewHolder = (PhotoSetGridAdapter.ViewHolder)localView.getTag();
      }
      while (localViewHolder.a != paramLong);
      localViewHolder.c.setImageBitmap(paramBitmap);
      localViewHolder.b = true;
    }
  }

  private boolean b(long paramLong)
  {
    return this.b.contains(Long.valueOf(paramLong));
  }

  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2);
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++)
      localArrayList.add(getItem(i));
    new PhotoSetGridAdapter.LoadPhotos(this, null).execute(new Object[] { localArrayList });
  }

  public void a(long paramLong)
  {
    PhotoSetGridAdapter.LoadBitmap localLoadBitmap = new PhotoSetGridAdapter.LoadBitmap(this, null);
    Long[] arrayOfLong = new Long[1];
    arrayOfLong[0] = Long.valueOf(paramLong);
    localLoadBitmap.execute(arrayOfLong);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PhotoSetGridAdapter.ViewHolder localViewHolder;
    long l;
    Bitmap localBitmap;
    if (paramView == null)
    {
      paramView = this.c.inflate(2130903484, paramViewGroup, false);
      localViewHolder = new PhotoSetGridAdapter.ViewHolder(null);
      localViewHolder.c = ((ImageView)paramView.findViewById(2131297397));
      paramView.setTag(localViewHolder);
      l = ((Long)getItem(paramInt)).longValue();
      localBitmap = (Bitmap)this.e.a(Long.valueOf(l));
      if (localBitmap != null)
        break label118;
      localViewHolder.b = false;
      localViewHolder.c.setImageResource(2130838835);
    }
    while (true)
    {
      localViewHolder.a = l;
      return paramView;
      localViewHolder = (PhotoSetGridAdapter.ViewHolder)paramView.getTag();
      break;
      label118: if ((localViewHolder.a == l) && (localViewHolder.b))
        continue;
      localViewHolder.c.setImageBitmap(localBitmap);
      localViewHolder.b = true;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoSetGridAdapter
 * JD-Core Version:    0.6.0
 */