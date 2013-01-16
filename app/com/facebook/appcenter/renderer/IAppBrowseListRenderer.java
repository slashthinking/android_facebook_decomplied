package com.facebook.appcenter.renderer;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.appcenter.graphql.model.AppDetail;

public abstract interface IAppBrowseListRenderer
{
  public abstract View a(AppDetail paramAppDetail, View paramView, ViewGroup paramViewGroup);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.renderer.IAppBrowseListRenderer
 * JD-Core Version:    0.6.0
 */