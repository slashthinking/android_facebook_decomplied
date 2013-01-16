package com.facebook.katana.platform;

import com.facebook.analytics.HoneyClientEvent;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Optional;
import java.util.Iterator;
import java.util.List;

class GDPDialog$AnalyticsEventBuilder
{
  static HoneyClientEvent a(String paramString1, List<String> paramList, Optional<String> paramOptional, String paramString2)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("gdp_shown");
    localHoneyClientEvent.h(paramString2);
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayNode.add((String)localIterator.next());
    localHoneyClientEvent.b("app_id", paramString1);
    localHoneyClientEvent.a("permissions", localArrayNode);
    if (paramOptional.isPresent())
      localHoneyClientEvent.b("write_privacy", (String)paramOptional.get());
    return localHoneyClientEvent;
  }

  static HoneyClientEvent a(boolean paramBoolean, Optional<String> paramOptional, String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("gdp_user_selection");
    localHoneyClientEvent.h(paramString);
    if (paramBoolean);
    for (String str = "success"; ; str = "failure")
    {
      localHoneyClientEvent.b("result", str);
      if (paramOptional.isPresent())
        localHoneyClientEvent.b("error", (String)paramOptional.get());
      return localHoneyClientEvent;
    }
  }

  static HoneyClientEvent a(boolean paramBoolean, String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("gdp_user_selection");
    localHoneyClientEvent.h(paramString);
    if (paramBoolean);
    for (String str = "accepted"; ; str = "rejected")
    {
      localHoneyClientEvent.b("selection", str);
      return localHoneyClientEvent;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.GDPDialog.AnalyticsEventBuilder
 * JD-Core Version:    0.6.0
 */