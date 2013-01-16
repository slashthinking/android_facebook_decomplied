package com.facebook.orca.protocol.base;

import java.util.Comparator;
import org.apache.http.NameValuePair;

class SingleMethodRunner$1
  implements Comparator<NameValuePair>
{
  SingleMethodRunner$1(SingleMethodRunner paramSingleMethodRunner)
  {
  }

  public int a(NameValuePair paramNameValuePair1, NameValuePair paramNameValuePair2)
  {
    return paramNameValuePair1.getName().compareToIgnoreCase(paramNameValuePair2.getName());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.SingleMethodRunner.1
 * JD-Core Version:    0.6.2
 */