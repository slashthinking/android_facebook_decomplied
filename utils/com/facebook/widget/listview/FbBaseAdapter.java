package com.facebook.widget.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.base.Preconditions;

public abstract class FbBaseAdapter extends BaseAdapter
{
  public abstract View a(int paramInt, ViewGroup paramViewGroup);

  public abstract void a(Object paramObject, View paramView, int paramInt, ViewGroup paramViewGroup);

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      paramView = a(i, paramViewGroup);
      if (paramView == null)
        break label48;
    }
    label48: for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "createView() shall not return null value!");
      a(getItem(paramInt), paramView, i, paramViewGroup);
      return paramView;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listview.FbBaseAdapter
 * JD-Core Version:    0.6.2
 */