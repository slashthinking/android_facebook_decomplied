package com.facebook.katana.activity.media;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import com.facebook.katana.model.FacebookPhotoSet;
import java.util.Iterator;
import java.util.List;

public abstract class BasePhotosetAdapter extends ArrayAdapter<Long>
{
  private FacebookPhotoSet a;

  public BasePhotosetAdapter(Context paramContext)
  {
    super(paramContext, 0);
  }

  public LayoutInflater a()
  {
    return (LayoutInflater)getContext().getSystemService("layout_inflater");
  }

  public void a(FacebookPhotoSet paramFacebookPhotoSet)
  {
    setNotifyOnChange(false);
    clear();
    Iterator localIterator = paramFacebookPhotoSet.a().iterator();
    while (localIterator.hasNext())
      add((Long)localIterator.next());
    setNotifyOnChange(true);
    this.a = paramFacebookPhotoSet;
    notifyDataSetChanged();
  }

  public long getItemId(int paramInt)
  {
    return ((Long)getItem(paramInt)).longValue();
  }

  public boolean hasStableIds()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.BasePhotosetAdapter
 * JD-Core Version:    0.6.0
 */