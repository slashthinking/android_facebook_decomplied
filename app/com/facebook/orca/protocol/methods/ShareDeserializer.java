package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.share.Share;
import com.facebook.orca.share.ShareBuilder;
import com.facebook.orca.share.ShareMedia;
import com.facebook.orca.share.ShareMediaBuilder;
import com.facebook.orca.share.ShareMediaPhoto;
import com.facebook.orca.share.ShareMediaPhotoBuilder;
import com.facebook.orca.share.ShareMediaVideo;
import com.facebook.orca.share.ShareMediaVideoBuilder;
import com.facebook.orca.share.ShareProperty;
import com.facebook.orca.share.SharePropertyBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareDeserializer
{
  private ShareMedia e(JsonNode paramJsonNode)
  {
    ShareMediaBuilder localShareMediaBuilder = new ShareMediaBuilder();
    localShareMediaBuilder.a(JSONUtil.b(paramJsonNode.get("href")));
    localShareMediaBuilder.b(JSONUtil.b(paramJsonNode.get("alt")));
    localShareMediaBuilder.c(JSONUtil.b(paramJsonNode.get("type")));
    localShareMediaBuilder.d(JSONUtil.b(paramJsonNode.get("src")));
    if (paramJsonNode.has("photo"))
      localShareMediaBuilder.a(f(paramJsonNode.get("photo")));
    while (true)
    {
      return localShareMediaBuilder.g();
      if (!paramJsonNode.has("video"))
        continue;
      localShareMediaBuilder.a(g(paramJsonNode.get("video")));
    }
  }

  private ShareMediaPhoto f(JsonNode paramJsonNode)
  {
    ShareMediaPhotoBuilder localShareMediaPhotoBuilder = new ShareMediaPhotoBuilder();
    localShareMediaPhotoBuilder.a(JSONUtil.b(paramJsonNode.get("aid")));
    localShareMediaPhotoBuilder.b(JSONUtil.b(paramJsonNode.get("pid")));
    localShareMediaPhotoBuilder.c(JSONUtil.b(paramJsonNode.get("fbid")));
    localShareMediaPhotoBuilder.d(JSONUtil.b(paramJsonNode.get("owner")));
    if ((paramJsonNode.has("height")) && (paramJsonNode.has("width")))
    {
      localShareMediaPhotoBuilder.b(JSONUtil.d(paramJsonNode.get("height")));
      localShareMediaPhotoBuilder.a(JSONUtil.d(paramJsonNode.get("width")));
    }
    return localShareMediaPhotoBuilder.g();
  }

  private ShareMediaVideo g(JsonNode paramJsonNode)
  {
    ShareMediaVideoBuilder localShareMediaVideoBuilder = new ShareMediaVideoBuilder();
    localShareMediaVideoBuilder.a(JSONUtil.b(paramJsonNode.get("display_url")));
    localShareMediaVideoBuilder.b(JSONUtil.b(paramJsonNode.get("source_url")));
    localShareMediaVideoBuilder.c(JSONUtil.b(paramJsonNode.get("owner")));
    localShareMediaVideoBuilder.d(JSONUtil.b(paramJsonNode.get("source_type")));
    return localShareMediaVideoBuilder.e();
  }

  ImmutableList<Share> a(JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.fieldNames();
    while (localIterator.hasNext())
      localBuilder.b(b(paramJsonNode.get((String)localIterator.next())));
    return localBuilder.b();
  }

  Share b(JsonNode paramJsonNode)
  {
    ShareBuilder localShareBuilder = new ShareBuilder();
    localShareBuilder.a(JSONUtil.b(paramJsonNode.get("name")));
    localShareBuilder.b(JSONUtil.b(paramJsonNode.get("caption")));
    localShareBuilder.c(JSONUtil.b(paramJsonNode.get("description")));
    localShareBuilder.d(JSONUtil.b(paramJsonNode.get("href")));
    if (paramJsonNode.has("media"))
      localShareBuilder.a(d(paramJsonNode.get("media")));
    if (paramJsonNode.has("properties"))
      localShareBuilder.b(c(paramJsonNode.get("properties")));
    return localShareBuilder.g();
  }

  List<ShareProperty> c(JsonNode paramJsonNode)
  {
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = paramJsonNode.iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode = (JsonNode)localIterator.next();
      if ((!localJsonNode.has("name")) || (!localJsonNode.has("text")))
        continue;
      SharePropertyBuilder localSharePropertyBuilder = new SharePropertyBuilder();
      localSharePropertyBuilder.a(JSONUtil.b(localJsonNode.get("name")));
      localSharePropertyBuilder.b(JSONUtil.b(localJsonNode.get("text")));
      localSharePropertyBuilder.c(JSONUtil.b(localJsonNode.get("href")));
      localArrayList.add(localSharePropertyBuilder.d());
    }
    return localArrayList;
  }

  ImmutableList<ShareMedia> d(JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.iterator();
    while (localIterator.hasNext())
      localBuilder.b(e((JsonNode)localIterator.next()));
    return localBuilder.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.ShareDeserializer
 * JD-Core Version:    0.6.0
 */