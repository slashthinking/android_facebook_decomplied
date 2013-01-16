package com.facebook.orca.common.ui.widgets.listview;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import java.util.Map;

public class ListViewScrollStateHelper
{
  public ScrollState.ScrollPosition a(ListView paramListView)
  {
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    ScrollState.ScrollPosition localScrollPosition;
    if (paramListView.isStackFromBottom())
      if ((paramListView.getCount() == 0) || (j == -1 + paramListView.getCount()))
        localScrollPosition = ScrollState.ScrollPosition.BOTTOM;
    while (true)
    {
      return localScrollPosition;
      if (i == 0)
      {
        localScrollPosition = ScrollState.ScrollPosition.TOP;
        continue;
        if ((paramListView.getCount() == 0) || (i == 0))
        {
          localScrollPosition = ScrollState.ScrollPosition.TOP;
          continue;
        }
        if (j == -1 + paramListView.getCount())
        {
          localScrollPosition = ScrollState.ScrollPosition.BOTTOM;
          continue;
        }
      }
      localScrollPosition = ScrollState.ScrollPosition.MIDDLE;
    }
  }

  public ImmutableMap<Long, Integer> b(ListView paramListView)
  {
    LinkedHashMap localLinkedHashMap = Maps.b();
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    ListAdapter localListAdapter = paramListView.getAdapter();
    int k = i;
    if ((k > j) || (k >= localListAdapter.getCount()))
      return ImmutableMap.a(localLinkedHashMap);
    long l = localListAdapter.getItemId(k);
    if (l == -9223372036854775808L);
    while (true)
    {
      k++;
      break;
      View localView = paramListView.getChildAt(k - i);
      if (localView == null)
        continue;
      localLinkedHashMap.put(Long.valueOf(l), Integer.valueOf(localView.getTop()));
    }
  }

  public ScrollState c(ListView paramListView)
  {
    return new ScrollState(a(paramListView), b(paramListView));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.listview.ListViewScrollStateHelper
 * JD-Core Version:    0.6.0
 */