package com.facebook.orca.database;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DbSharesSerialization
{
  private final ObjectMapper a;

  public DbSharesSerialization(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  private ArrayNode a(Collection<ShareProperty> paramCollection)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localArrayNode.add(a((ShareProperty)localIterator.next()));
    return localArrayNode;
  }

  private ObjectNode a(ShareMediaPhoto paramShareMediaPhoto)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("aid", paramShareMediaPhoto.a());
    localObjectNode.put("pid", paramShareMediaPhoto.b());
    localObjectNode.put("fbid", paramShareMediaPhoto.c());
    localObjectNode.put("owner", paramShareMediaPhoto.d());
    if ((paramShareMediaPhoto.e() != 0) && (paramShareMediaPhoto.f() != 0))
    {
      localObjectNode.put("width", paramShareMediaPhoto.e());
      localObjectNode.put("height", paramShareMediaPhoto.f());
    }
    return localObjectNode;
  }

  private ObjectNode a(ShareMediaVideo paramShareMediaVideo)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("display_url", paramShareMediaVideo.a());
    localObjectNode.put("source_url", paramShareMediaVideo.b());
    localObjectNode.put("source_type", paramShareMediaVideo.d());
    localObjectNode.put("owner", paramShareMediaVideo.c());
    return localObjectNode;
  }

  private ObjectNode a(ShareProperty paramShareProperty)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("name", paramShareProperty.a());
    localObjectNode.put("text", paramShareProperty.b());
    localObjectNode.put("href", paramShareProperty.c());
    return localObjectNode;
  }

  private ArrayNode b(List<ShareMedia> paramList)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      ShareMedia localShareMedia = (ShareMedia)localIterator.next();
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("type", localShareMedia.c());
      localObjectNode.put("src", localShareMedia.d());
      localObjectNode.put("href", localShareMedia.a());
      localObjectNode.put("alt", localShareMedia.b());
      if (localShareMedia.e() != null)
        localObjectNode.put("photo", a(localShareMedia.e()));
      while (true)
      {
        localArrayNode.add(localObjectNode);
        break;
        if (localShareMedia.f() == null)
          continue;
        localObjectNode.put("video", a(localShareMedia.f()));
      }
    }
    return localArrayNode;
  }

  private Share c(JsonNode paramJsonNode)
  {
    ShareBuilder localShareBuilder = new ShareBuilder();
    localShareBuilder.a(JSONUtil.b(paramJsonNode.get("name")));
    localShareBuilder.b(JSONUtil.b(paramJsonNode.get("caption")));
    localShareBuilder.c(JSONUtil.b(paramJsonNode.get("description")));
    localShareBuilder.a(a(paramJsonNode.get("media")));
    localShareBuilder.d(JSONUtil.b(paramJsonNode.get("href")));
    localShareBuilder.b(b(paramJsonNode.get("properties")));
    return localShareBuilder.g();
  }

  private ShareMedia d(JsonNode paramJsonNode)
  {
    ShareMediaBuilder localShareMediaBuilder = new ShareMediaBuilder();
    localShareMediaBuilder.a(JSONUtil.b(paramJsonNode.get("href")));
    localShareMediaBuilder.b(JSONUtil.b(paramJsonNode.get("alt")));
    localShareMediaBuilder.c(JSONUtil.b(paramJsonNode.get("type")));
    localShareMediaBuilder.d(JSONUtil.b(paramJsonNode.get("src")));
    if (paramJsonNode.has("photo"))
      localShareMediaBuilder.a(e(paramJsonNode.get("photo")));
    while (true)
    {
      return localShareMediaBuilder.g();
      if (!paramJsonNode.has("video"))
        continue;
      localShareMediaBuilder.a(f(paramJsonNode.get("video")));
    }
  }

  private ShareMediaPhoto e(JsonNode paramJsonNode)
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

  private ShareMediaVideo f(JsonNode paramJsonNode)
  {
    ShareMediaVideoBuilder localShareMediaVideoBuilder = new ShareMediaVideoBuilder();
    localShareMediaVideoBuilder.a(JSONUtil.b(paramJsonNode.get("display_url")));
    localShareMediaVideoBuilder.b(JSONUtil.b(paramJsonNode.get("source_url")));
    localShareMediaVideoBuilder.c(JSONUtil.b(paramJsonNode.get("owner")));
    localShareMediaVideoBuilder.d(JSONUtil.b(paramJsonNode.get("source_type")));
    return localShareMediaVideoBuilder.e();
  }

  ImmutableList<ShareMedia> a(JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.iterator();
    while (localIterator.hasNext())
      localBuilder.b(d((JsonNode)localIterator.next()));
    return localBuilder.b();
  }

  ImmutableList<Share> a(String paramString)
  {
    if (StringUtil.a(paramString));
    ImmutableList.Builder localBuilder;
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = localBuilder.b())
    {
      return localImmutableList;
      localBuilder = ImmutableList.e();
      Iterator localIterator = this.a.readTree(paramString).iterator();
      while (localIterator.hasNext())
        localBuilder.b(c((JsonNode)localIterator.next()));
    }
  }

  String a(List<Share> paramList)
  {
    if (paramList == null);
    ArrayNode localArrayNode;
    for (String str = null; ; str = localArrayNode.toString())
    {
      return str;
      localArrayNode = new ArrayNode(JsonNodeFactory.instance);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Share localShare = (Share)localIterator.next();
        ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
        localObjectNode.put("name", localShare.a());
        localObjectNode.put("caption", localShare.b());
        localObjectNode.put("description", localShare.c());
        localObjectNode.put("href", localShare.e());
        localObjectNode.put("media", b(localShare.d()));
        localObjectNode.put("properties", a(localShare.f()));
        localArrayNode.add(localObjectNode);
      }
    }
  }

  List<ShareProperty> b(JsonNode paramJsonNode)
  {
    ArrayList localArrayList = Lists.a();
    for (int i = 0; i < paramJsonNode.size(); i++)
    {
      JsonNode localJsonNode = paramJsonNode.get(i);
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
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbSharesSerialization
 * JD-Core Version:    0.6.0
 */