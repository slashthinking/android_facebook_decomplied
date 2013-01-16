package com.facebook.timeline;

import android.content.Intent;
import com.facebook.feed.util.composer.ComposerActivityReceiver.Listener;

class TimelineFragment$13
  implements ComposerActivityReceiver.Listener
{
  public void a()
  {
    if (this.a.s())
    {
      if (TimelineFragment.d(this.a) != null)
        TimelineFragment.d(this.a).a(false);
      this.a.i();
      if (TimelineFragment.e(this.a) != null)
        TimelineFragment.e(this.a).f();
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      if (TimelineFragment.d(this.a) != null)
        TimelineFragment.d(this.a).a(true);
    while (true)
    {
      this.a.b();
      return;
      if (TimelineFragment.e(this.a) == null)
        continue;
      TimelineFragment.e(this.a).f();
    }
  }

  public boolean a(Intent paramIntent)
  {
    if (paramIntent.getLongExtra("extra_target_id", -1L) == TimelineFragment.j(this.a));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFragment.13
 * JD-Core Version:    0.6.0
 */