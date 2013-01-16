package com.facebook.orca.protocol.methods;

import com.facebook.base.GatekeeperSetProvider;
import com.google.common.collect.ImmutableSet;

public class OrcaSessionlessGateKeeperSetProvider
  implements GatekeeperSetProvider
{
  public ImmutableSet<String> b()
  {
    return ImmutableSet.b("messenger_wildfire_android");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.OrcaSessionlessGateKeeperSetProvider
 * JD-Core Version:    0.6.0
 */