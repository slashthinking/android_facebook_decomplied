package com.facebook.orca.mqtt.messages;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class UnsubscribePayload
{
  private final ImmutableList<String> a;

  public UnsubscribePayload(List<String> paramList)
  {
    this.a = ImmutableList.a(paramList);
  }

  public ImmutableList<String> a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.UnsubscribePayload
 * JD-Core Version:    0.6.0
 */