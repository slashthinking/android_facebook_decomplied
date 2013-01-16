package com.facebook.orca.threadview;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.contacts.contactcard.ContactCardFragment;
import com.facebook.contacts.contactcard.GroupContactCardFragment.GroupContactCardListener;
import com.facebook.orca.users.UserKey;

class ThreadViewFragment$5
  implements GroupContactCardFragment.GroupContactCardListener
{
  public void a()
  {
    ThreadViewFragment.a(this.a, new HoneyClientEvent("click").e("map"));
    ThreadViewFragment.a(this.a, ThreadViewFragment.State.MAP);
  }

  public void a(UserKey paramUserKey)
  {
    ThreadViewFragment.a(this.a, new HoneyClientEvent("click").e("contact").f(paramUserKey.b()));
    ThreadViewFragment.h(this.a);
    ThreadViewFragment.e(this.a).P();
    ThreadViewFragment.e(this.a).a(paramUserKey, false);
    ThreadViewFragment.a(this.a, ThreadViewFragment.State.CONTACTCARD);
  }

  public void b()
  {
    this.a.P();
  }

  public void c()
  {
  }

  public void d()
  {
  }

  public void e()
  {
    ThreadViewFragment.a(this.a, new HoneyClientEvent("click").e("button").f("leave_conversation"));
    ThreadViewFragment.i(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewFragment.5
 * JD-Core Version:    0.6.0
 */