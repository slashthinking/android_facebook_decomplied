package com.facebook.orca.common.ui.widgets.listview;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class ScrollState
{
  private final ScrollState.ScrollPosition a;
  private final ImmutableMap<Long, Integer> b;

  public ScrollState(ScrollState.ScrollPosition paramScrollPosition, Map<Long, Integer> paramMap)
  {
    this.a = paramScrollPosition;
    this.b = ImmutableMap.a(paramMap);
  }

  public ScrollState.ScrollPosition a()
  {
    return this.a;
  }

  public ImmutableMap<Long, Integer> b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.listview.ScrollState
 * JD-Core Version:    0.6.0
 */