package com.facebook.orca.images;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.widget.UrlImage;
import java.util.Collections;
import java.util.List;

public class ImageSearchListAdapter extends BaseAdapter
{
  private final Context a;
  private final LayoutInflater b;
  private List<Bundle> c = Collections.emptyList();

  public ImageSearchListAdapter(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    this.a = paramContext;
    this.b = paramLayoutInflater;
  }

  public Bundle a(int paramInt)
  {
    return (Bundle)this.c.get(paramInt);
  }

  public void a(List<Bundle> paramList)
  {
    this.c = paramList;
    notifyDataSetInvalidated();
  }

  public int getCount()
  {
    return this.c.size();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (UrlImage localUrlImage = (UrlImage)this.b.inflate(2130903349, paramViewGroup, false); ; localUrlImage = (UrlImage)paramView)
    {
      localUrlImage.setImageParams(new FetchImageParams(Uri.parse(((Bundle)((Bundle)this.c.get(paramInt)).getParcelable("Thumbnail")).getString("Url"))));
      return localUrlImage;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageSearchListAdapter
 * JD-Core Version:    0.6.0
 */