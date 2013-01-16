package com.facebook.appcenter.renderer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.ui.AppBrowseInfoCardView;
import com.facebook.appcenter.ui.BindableInfoCardView;

public class DefaultAppBrowseListRenderer
  implements IAppBrowseListRenderer
{
  private final Context a;
  private final LayoutInflater b;

  public DefaultAppBrowseListRenderer(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
  }

  public View a(AppDetail paramAppDetail, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (View localView = a(paramAppDetail, paramViewGroup); ; localView = paramView)
    {
      if ((localView instanceof BindableInfoCardView))
        ((BindableInfoCardView)localView).a(paramAppDetail);
      return localView;
    }
  }

  public View a(AppDetail paramAppDetail, ViewGroup paramViewGroup)
  {
    return new AppBrowseInfoCardView(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.renderer.DefaultAppBrowseListRenderer
 * JD-Core Version:    0.6.0
 */