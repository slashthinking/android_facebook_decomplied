package com.facebook.timeline;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.fragment.IFragmentFactory;

class TimelineFragmentFactoryInitializer$TimelineFragmentFactory
  implements IFragmentFactory
{
  private final Context a;

  public TimelineFragmentFactoryInitializer$TimelineFragmentFactory(Context paramContext)
  {
    this.a = paramContext;
  }

  public int a()
  {
    return 3;
  }

  public Fragment a(Intent paramIntent)
  {
    return TimelineFragment.a(paramIntent.getLongExtra("com.facebook.katana.profile.id", -1L), paramIntent.getParcelableExtra("gql_profile"), paramIntent.getStringExtra("timeline_filter"), paramIntent.getStringExtra("page_access_token"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFragmentFactoryInitializer.TimelineFragmentFactory
 * JD-Core Version:    0.6.0
 */