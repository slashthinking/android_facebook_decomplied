package com.facebook.katana.util.logging;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MobileEvent
{
  protected final String a;
  protected final long b;
  protected final ObjectNode c;
  protected boolean d = false;

  public MobileEvent(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = new ObjectNode(JsonNodeFactory.instance);
    this.c.put("log_type", a());
    this.c.put("time", a(this.b));
  }

  public static String a(long paramLong)
  {
    return Long.toString(paramLong);
  }

  public String a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.MobileEvent
 * JD-Core Version:    0.6.0
 */