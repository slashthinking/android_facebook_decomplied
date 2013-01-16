package com.facebook.orca.appconfig;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AppConfigSerialization
{
  ObjectMapper a;

  public AppConfigSerialization(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  public AppConfig a(JsonNode paramJsonNode)
  {
    String str1 = StringUtil.b(JSONUtil.b(paramJsonNode.path("min_version")));
    String str2 = StringUtil.b(JSONUtil.b(paramJsonNode.path("current_version")));
    String str3 = StringUtil.b(JSONUtil.b(paramJsonNode.path("new_version_url")));
    int i = JSONUtil.d(paramJsonNode.path("min_version_code"));
    int j = JSONUtil.d(paramJsonNode.path("current_version_code"));
    return AppConfig.newBuilder().a(str1).b(str2).c(str3).a(i).b(j).f();
  }

  public AppConfig a(String paramString)
  {
    return a(this.a.readTree(paramString));
  }

  public String a(AppConfig paramAppConfig)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("min_version", paramAppConfig.a());
    localObjectNode.put("current_version", paramAppConfig.b());
    localObjectNode.put("new_version_url", paramAppConfig.c());
    localObjectNode.put("min_version_code", paramAppConfig.d());
    localObjectNode.put("current_version_code", paramAppConfig.e());
    return localObjectNode.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.appconfig.AppConfigSerialization
 * JD-Core Version:    0.6.0
 */