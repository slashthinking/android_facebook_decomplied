package com.facebook.orca.threadview;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.contacts.contactcard.ContactCardFragment.ContactCardListener;

class ThreadViewFragment$4
  implements ContactCardFragment.ContactCardListener
{
  public void a()
  {
    ThreadViewFragment.a(this.a, new HoneyClientEvent("click").e("map"));
    if (ThreadViewMapActivityTabShim.a())
      ThreadViewFragment.a(this.a, ThreadViewFragment.State.MAP);
  }

  public void b()
  {
    this.a.P();
  }

  public void c()
  {
    if (!this.a.w())
      ThreadViewFragment.f(this.a);
  }

  public void d()
  {
    ThreadViewFragment.g(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewFragment.4
 * JD-Core Version:    0.6.0
 */