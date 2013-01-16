package com.facebook.orca.threadview;

import android.app.Activity;
import com.facebook.orca.threadlist.ThreadListActivity;

public class ThreadViewUtil
{
  public String a(Activity paramActivity)
  {
    String str;
    if ((paramActivity instanceof ThreadViewActivity))
      str = ((ThreadViewActivity)paramActivity).i();
    while (true)
    {
      return str;
      if ((paramActivity instanceof ThreadListActivity))
      {
        str = ((ThreadListActivity)paramActivity).i();
        continue;
      }
      str = null;
    }
  }

  public boolean b(Activity paramActivity)
  {
    if (((paramActivity instanceof ThreadViewActivity)) || (((paramActivity instanceof ThreadListActivity)) && (((ThreadListActivity)paramActivity).j())));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewUtil
 * JD-Core Version:    0.6.0
 */