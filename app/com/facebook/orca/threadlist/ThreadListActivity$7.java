package com.facebook.orca.threadlist;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.common.ui.titlebar.DivebarController.DivebarState;
import com.facebook.orca.creation.CreateThreadActivity;

class ThreadListActivity$7
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ThreadListActivity.b(this.a).a(new HoneyClientEvent("click").e("button").f("floating_compose_btn").b("divebar_state", ThreadListActivity.e(this.a).c().toString()));
    Intent localIntent = new Intent(this.a, CreateThreadActivity.class);
    localIntent.putExtra(CreateThreadActivity.s, true);
    localIntent.putExtra("trigger", "floating_compose_btn");
    this.a.startActivity(localIntent);
    ThreadListActivity.e(this.a).k();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListActivity.7
 * JD-Core Version:    0.6.0
 */