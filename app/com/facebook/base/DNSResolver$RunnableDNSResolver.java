package com.facebook.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

class DNSResolver$RunnableDNSResolver
  implements Runnable
{
  private String a;
  private InetAddress b;

  public DNSResolver$RunnableDNSResolver(String paramString)
  {
    this.a = paramString;
  }

  public InetAddress a()
  {
    monitorenter;
    try
    {
      InetAddress localInetAddress = this.b;
      monitorexit;
      return localInetAddress;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(InetAddress paramInetAddress)
  {
    monitorenter;
    try
    {
      this.b = paramInetAddress;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void run()
  {
    try
    {
      a(InetAddress.getByName(this.a));
      label11: return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      break label11;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.base.DNSResolver.RunnableDNSResolver
 * JD-Core Version:    0.6.0
 */