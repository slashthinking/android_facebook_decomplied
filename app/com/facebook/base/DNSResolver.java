package com.facebook.base;

import java.io.IOException;
import java.net.InetAddress;

public class DNSResolver
{
  public static InetAddress a(String paramString, int paramInt)
  {
    DNSResolver.RunnableDNSResolver localRunnableDNSResolver = new DNSResolver.RunnableDNSResolver(paramString);
    Thread localThread = new Thread(localRunnableDNSResolver);
    localThread.start();
    long l = paramInt;
    label32: InetAddress localInetAddress;
    try
    {
      localThread.join(l);
      localInetAddress = localRunnableDNSResolver.a();
      localThread.interrupt();
      if (localInetAddress == null)
        throw new IOException("Unable to DNS resolve");
    }
    catch (InterruptedException localInterruptedException)
    {
      break label32;
    }
    return localInetAddress;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.base.DNSResolver
 * JD-Core Version:    0.6.0
 */