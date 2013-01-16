package com.facebook.analytics;

import com.facebook.orca.common.util.StringUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class HoneyClientEvent extends HoneyAnalyticsEvent
{
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private ObjectNode h;

  public HoneyClientEvent(String paramString)
  {
    this(paramString, "AUTO_SET");
  }

  public HoneyClientEvent(String paramString1, String paramString2)
  {
    super("client_event", paramString2);
    this.b = paramString1;
  }

  public HoneyClientEvent a(String paramString, double paramDouble)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Double.valueOf(paramDouble);
    return b(paramString, StringUtil.a("%4.2f", arrayOfObject));
  }

  public HoneyClientEvent a(String paramString, int paramInt)
  {
    return b(paramString, Integer.toString(paramInt));
  }

  public HoneyClientEvent a(String paramString, long paramLong)
  {
    return b(paramString, Long.toString(paramLong));
  }

  public HoneyClientEvent a(String paramString, JsonNode paramJsonNode)
  {
    if (this.h == null)
      this.h = new ObjectNode(JsonNodeFactory.instance);
    this.h.put(paramString, paramJsonNode);
    return this;
  }

  public HoneyClientEvent a(String paramString, boolean paramBoolean)
  {
    return b(paramString, Boolean.toString(paramBoolean));
  }

  public HoneyClientEvent b(String paramString1, String paramString2)
  {
    if (this.h == null)
      this.h = new ObjectNode(JsonNodeFactory.instance);
    if (paramString2 != null)
      this.h.put(paramString1, paramString2);
    return this;
  }

  public HoneyClientEvent d(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public HoneyClientEvent e(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public JsonNode e()
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("time", HoneyProtocolUtils.a(b()));
    localObjectNode.put("log_type", a());
    localObjectNode.put("name", this.b);
    if (this.c != null)
      localObjectNode.put("module", this.c);
    if (this.d != null)
      localObjectNode.put("obj_type", this.d);
    if (this.e != null)
      localObjectNode.put("obj_id", this.e);
    if (this.f != null)
      localObjectNode.put("uuid", this.f);
    if (this.h != null)
      localObjectNode.put("extra", this.h);
    if (this.g != null)
      localObjectNode.put("interface", this.g);
    if (d())
      localObjectNode.put("bg", true);
    return localObjectNode;
  }

  public HoneyClientEvent f(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public HoneyClientEvent g(String paramString)
  {
    this.d = "fbobj";
    this.e = paramString;
    return this;
  }

  public String g()
  {
    return this.b;
  }

  public HoneyClientEvent h(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public String h()
  {
    return this.c;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.HoneyClientEvent
 * JD-Core Version:    0.6.2
 */