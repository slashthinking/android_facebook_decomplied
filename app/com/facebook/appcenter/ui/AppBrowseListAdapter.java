package com.facebook.appcenter.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.renderer.IAppBrowseListRenderer;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import java.util.List;

public class AppBrowseListAdapter extends BaseAdapter
{
  private static final int a = AppBrowseListAdapter.RowType.values().length;
  private List<AppDetail> b;
  private final IAppBrowseListRenderer c;

  public AppBrowseListAdapter(Context paramContext, List<AppDetail> paramList)
  {
    this.b = paramList;
    this.c = ((IAppBrowseListRenderer)FbInjector.a(paramContext).a(IAppBrowseListRenderer.class));
  }

  public int getCount()
  {
    return 1 + this.b.size();
  }

  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt - 1);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0);
    for (int i = AppBrowseListAdapter.RowType.FAKE_ITEM.ordinal(); ; i = AppBrowseListAdapter.RowType.APP_BROWSE_CARD.ordinal())
      return i;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramInt == 0)
    {
      int i = paramViewGroup.getResources().getDimensionPixelSize(2131230753);
      localView = new View(paramViewGroup.getContext());
      localView.setFocusable(false);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      localView.setBackgroundDrawable(paramViewGroup.getResources().getDrawable(2131165240));
    }
    while (true)
    {
      return localView;
      Object localObject = getItem(paramInt);
      Preconditions.checkNotNull(localObject);
      localView = this.c.a((AppDetail)localObject, paramView, paramViewGroup);
    }
  }

  public int getViewTypeCount()
  {
    return a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseListAdapter
 * JD-Core Version:    0.6.0
 */