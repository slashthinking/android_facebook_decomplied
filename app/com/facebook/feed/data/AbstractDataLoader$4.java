package com.facebook.feed.data;

import android.content.Intent;
import com.facebook.feed.util.composer.ComposerActivityReceiver.Listener;
import javax.inject.Provider;

class AbstractDataLoader$4
  implements ComposerActivityReceiver.Listener
{
  public void a()
  {
    this.a.q.b();
  }

  public void a(boolean paramBoolean)
  {
    this.a.q.a(paramBoolean);
  }

  public boolean a(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_target_id", -1L);
    if ((this.a.q.c()) && (Long.parseLong((String)AbstractDataLoader.a(this.a).b()) == l));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AbstractDataLoader.4
 * JD-Core Version:    0.6.0
 */