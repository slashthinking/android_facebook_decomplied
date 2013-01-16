package com.facebook.orca.prefs;

class OrcaSharedPreferencesImpl$5
  implements Runnable
{
  public void run()
  {
    synchronized (this.a)
    {
      OrcaSharedPreferencesImpl.a(this.a, false);
      OrcaSharedPreferencesImpl.b(this.a);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesImpl.5
 * JD-Core Version:    0.6.0
 */