package com.facebook.timeline;

import android.content.Context;
import com.facebook.fragment.IFragmentFactory;
import com.facebook.fragment.IFragmentFactoryInitializer;
import com.google.common.collect.ImmutableList;

public class TimelineFragmentFactoryInitializer
  implements IFragmentFactoryInitializer
{
  private final Context a;

  public TimelineFragmentFactoryInitializer(Context paramContext)
  {
    this.a = paramContext;
  }

  public ImmutableList<IFragmentFactory> a()
  {
    return ImmutableList.a(new TimelineFragmentFactoryInitializer.TimelineFragmentFactory(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFragmentFactoryInitializer
 * JD-Core Version:    0.6.0
 */