package com.facebook.orca.threadlist;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.widget.ConfirmationView.Listener;

class ThreadListActivity$4
  implements ConfirmationView.Listener
{
  public void a()
  {
    ThreadListActivity.b(this.a).a(new HoneyClientEvent("click").e("button").f("find_contacts_failed_dismiss"));
    ThreadListActivity.c(this.a).b();
  }

  public void b()
  {
    ThreadListActivity.b(this.a).a(new HoneyClientEvent("click").e("button").f("find_contacts_failed_try_again"));
    ThreadListActivity.c(this.a).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListActivity.4
 * JD-Core Version:    0.6.0
 */