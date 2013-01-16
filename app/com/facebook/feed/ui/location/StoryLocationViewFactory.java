package com.facebook.feed.ui.location;

import android.content.Context;
import com.facebook.orca.debug.BLog;

public class StoryLocationViewFactory
{
  private static final Class<?> a = StoryLocationViewFactory.class;

  public StoryLocationView a(Context paramContext, StoryLocationView.StoryLocationViewType paramStoryLocationViewType)
  {
    Object localObject;
    switch (StoryLocationViewFactory.1.a[paramStoryLocationViewType.ordinal()])
    {
    default:
      BLog.e(a, "Cannot construct the view type: " + paramStoryLocationViewType);
      localObject = null;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localObject;
      localObject = new StoryLocationViewProfile(paramContext);
      continue;
      localObject = new StoryLocationViewPlace(paramContext);
      continue;
      localObject = new StoryLocationViewMore(paramContext);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.location.StoryLocationViewFactory
 * JD-Core Version:    0.6.0
 */