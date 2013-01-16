package com.facebook.orca.mqtt.messages;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class SubscribePayload
{
  private final ImmutableList<SubscribeTopic> a;

  public SubscribePayload(List<SubscribeTopic> paramList)
  {
    this.a = ImmutableList.a(paramList);
  }

  public ImmutableList<SubscribeTopic> a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.SubscribePayload
 * JD-Core Version:    0.6.0
 */