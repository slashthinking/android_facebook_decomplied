package com.facebook.orca.mqtt.messages;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class SubAckPayload
{
  private final ImmutableList<Integer> a;

  public SubAckPayload(List<Integer> paramList)
  {
    this.a = ImmutableList.a(paramList);
  }

  public ImmutableList<Integer> a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.SubAckPayload
 * JD-Core Version:    0.6.0
 */