package com.facebook.orca.threadview;

import com.facebook.contacts.contactcard.ContactCardFragment;
import com.facebook.orca.common.ui.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.threads.ThreadSummary;

class ThreadViewFragment$3 extends FbTitleBar.OnToolbarButtonListener
{
  public void a(TitleBarButtonSpec paramTitleBarButtonSpec)
  {
    ThreadSummary localThreadSummary;
    if (paramTitleBarButtonSpec.a() == 1)
      if (ThreadViewFragment.c(this.a) == ThreadViewFragment.State.MESSAGES)
      {
        localThreadSummary = ThreadViewFragment.d(this.a);
        if (localThreadSummary != null)
          break label34;
      }
    while (true)
    {
      return;
      label34: if (localThreadSummary.g())
      {
        ThreadViewFragment.a(this.a, ThreadViewFragment.State.CONTACTCARD);
        continue;
      }
      ThreadViewFragment.a(this.a, ThreadViewFragment.State.GROUP_CONTACTCARD);
      continue;
      if (paramTitleBarButtonSpec.a() == 2)
      {
        if ((ThreadViewFragment.c(this.a) != ThreadViewFragment.State.CONTACTCARD) || (ThreadViewFragment.e(this.a) == null))
          continue;
        ThreadViewFragment.e(this.a).b();
        continue;
      }
      if ((paramTitleBarButtonSpec.a() != 3) || (ThreadViewFragment.c(this.a) != ThreadViewFragment.State.CONTACTCARD) || (ThreadViewFragment.e(this.a) == null))
        continue;
      ThreadViewFragment.e(this.a).c();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewFragment.3
 * JD-Core Version:    0.6.0
 */