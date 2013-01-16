package com.facebook.feed.analytics;

import com.facebook.analytics.HoneyClientEvent;
import com.fasterxml.jackson.databind.JsonNode;

public class NewsFeedAnalyticsEventBuilder
{
  public HoneyClientEvent a()
  {
    return new HoneyClientEvent("manual_refresh").d("native_newsfeed");
  }

  public HoneyClientEvent a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new HoneyClientEvent("prefetch_insertion").a("prefetch_period", paramInt1).a("prefetch_calls", paramInt2).a("snapshot_age", paramInt3).a("story_count", paramInt4).d("native_newsfeed");
  }

  public HoneyClientEvent a(JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("open_permalink_view").a("tracking", paramJsonNode).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent a(JsonNode paramJsonNode, boolean paramBoolean)
  {
    HoneyClientEvent localHoneyClientEvent;
    if (paramJsonNode == null)
    {
      localHoneyClientEvent = null;
      return localHoneyClientEvent;
    }
    if (paramBoolean);
    for (String str = "pyml_fan"; ; str = "pyml_unfan")
    {
      localHoneyClientEvent = new HoneyClientEvent(str).a("tracking", paramJsonNode).d("native_newsfeed");
      break;
    }
  }

  public HoneyClientEvent a(String paramString, JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0) || (paramString == null));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("open_link").a("tracking", paramJsonNode).e("url").f(paramString).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent(paramString1).b("comment", paramString2).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent a(String paramString1, String paramString2, JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0) || (paramString1 == null) || (paramString2 == null));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("photo_swipe").a("tracking", paramJsonNode).g(paramString2).b("src_obj_id", paramString1).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent(paramString1).b("legacy_api_post_id", paramString2).b("does_viewer_like", paramString3).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("open_application").a("tracking", paramJsonNode).g(paramString1).b("unit_type", paramString2).b("application_link_type", paramString3).a("sponsored", paramBoolean).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent a(String paramString1, String paramString2, boolean paramBoolean, JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0) || (paramString1 == null) || (paramString2 == null));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("open_open_graph_object").a("tracking", paramJsonNode).g(paramString1).b("unit_type", paramString2).a("sponsored", paramBoolean).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent b(JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("open_people_list").a("tracking", paramJsonNode).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent b(String paramString, JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0) || (paramString == null));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("open_photo").a("tracking", paramJsonNode).g(paramString).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent c(JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("pymk_imp").a("tracking", paramJsonNode).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent c(String paramString, JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0) || (paramString == null));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("open_video").a("tracking", paramJsonNode).g(paramString).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent d(JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.size() == 0));
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("pyml_imp").a("tracking", paramJsonNode).d("native_newsfeed"))
      return localHoneyClientEvent;
  }

  public HoneyClientEvent e(JsonNode paramJsonNode)
  {
    if (paramJsonNode == null);
    for (HoneyClientEvent localHoneyClientEvent = null; ; localHoneyClientEvent = new HoneyClientEvent("pyml_profile").a("tracking", paramJsonNode).d("native_newsfeed"))
      return localHoneyClientEvent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder
 * JD-Core Version:    0.6.0
 */