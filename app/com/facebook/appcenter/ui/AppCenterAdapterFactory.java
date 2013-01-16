package com.facebook.appcenter.ui;

import android.content.Context;
import com.facebook.appcenter.graphql.model.AppDetail;
import java.util.List;

public class AppCenterAdapterFactory
{
  private final Context a;

  public AppCenterAdapterFactory(Context paramContext)
  {
    this.a = paramContext;
  }

  public AppBrowseListAdapter a(List<AppDetail> paramList)
  {
    return new AppBrowseListAdapter(this.a, paramList);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppCenterAdapterFactory
 * JD-Core Version:    0.6.0
 */