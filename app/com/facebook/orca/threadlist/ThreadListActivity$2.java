package com.facebook.orca.threadlist;

import android.content.Intent;
import com.facebook.fragment.NavigableFragment;
import com.facebook.fragment.NavigableFragment.Listener;
import com.google.common.base.Preconditions;

class ThreadListActivity$2
  implements NavigableFragment.Listener
{
  public void a(NavigableFragment paramNavigableFragment, Intent paramIntent)
  {
    Preconditions.checkArgument(paramIntent.hasExtra("thread_id"));
    String str = paramIntent.getStringExtra("thread_id");
    ThreadListActivity.a(this.a, str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListActivity.2
 * JD-Core Version:    0.6.0
 */