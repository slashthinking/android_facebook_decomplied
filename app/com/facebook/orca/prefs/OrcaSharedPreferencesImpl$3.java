package com.facebook.orca.prefs;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class OrcaSharedPreferencesImpl$3
  implements Runnable
{
  public void run()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList = Lists.a(OrcaSharedPreferencesImpl.a(this.a));
      OrcaSharedPreferencesImpl.a(this.a).clear();
      Iterator localIterator = localArrayList.iterator();
      if (localIterator.hasNext())
        ((Runnable)localIterator.next()).run();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesImpl.3
 * JD-Core Version:    0.6.0
 */