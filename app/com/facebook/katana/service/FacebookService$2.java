package com.facebook.katana.service;

import com.facebook.katana.service.method.ServiceOperation;
import java.util.Iterator;
import java.util.List;

class FacebookService$2
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((ServiceOperation)localIterator.next()).a(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.FacebookService.2
 * JD-Core Version:    0.6.0
 */