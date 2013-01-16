package com.facebook.orca.threadlist;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.nux.ThreadListNuxController;

class ThreadListActivity$5
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ThreadListActivity.b(this.a).a(new HoneyClientEvent("click").e("view").f("find_contacts_progress_view"));
    ThreadListActivity.d(this.a).d();
    ThreadListActivity.e(this.a).f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListActivity.5
 * JD-Core Version:    0.6.0
 */