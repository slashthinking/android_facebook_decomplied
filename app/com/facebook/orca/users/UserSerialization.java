package com.facebook.orca.users;

import com.facebook.common.util.TriState;
import com.facebook.orca.common.util.JSONUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserSerialization
{
  private static final Pattern d = Pattern.compile("^https://");
  private final ObjectMapper a;
  private final ThreadLocal<SimpleDateFormat> b = new UserSerialization.1(this);
  private final ThreadLocal<SimpleDateFormat> c = new UserSerialization.2(this);

  public UserSerialization(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  private String a(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (true)
    {
      return paramString;
      Matcher localMatcher = d.matcher(paramString);
      if (!localMatcher.find())
        continue;
      paramString = localMatcher.replaceFirst("http://");
    }
  }

  public PicCropInfo a(JsonNode paramJsonNode)
  {
    String str;
    int i;
    int j;
    float f1;
    float f2;
    if ((paramJsonNode.has("uri")) && (paramJsonNode.has("width")) && (paramJsonNode.has("height")) && (paramJsonNode.has("left")) && (paramJsonNode.has("right")) && (paramJsonNode.has("top")) && (paramJsonNode.has("bottom")))
    {
      str = a(JSONUtil.b(paramJsonNode.get("uri")));
      i = JSONUtil.d(paramJsonNode.get("width"));
      j = JSONUtil.d(paramJsonNode.get("height"));
      f1 = (float)JSONUtil.e(paramJsonNode.get("left"));
      f2 = (float)JSONUtil.e(paramJsonNode.get("right"));
    }
    for (PicCropInfo localPicCropInfo = new PicCropInfo(str, i, j, f1, (float)JSONUtil.e(paramJsonNode.get("top")), f2, (float)JSONUtil.e(paramJsonNode.get("bottom"))); ; localPicCropInfo = null)
      return localPicCropInfo;
  }

  public ArrayNode a(ImmutableList<UserEmailAddress> paramImmutableList)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
      localArrayNode.add(((UserEmailAddress)localIterator.next()).a());
    return localArrayNode;
  }

  public ObjectNode a(LastActive paramLastActive)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("time", paramLastActive.a() / 1000L);
    localObjectNode.put("active", paramLastActive.b());
    return localObjectNode;
  }

  public ObjectNode a(MobileAppData paramMobileAppData)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    ObjectMapper localObjectMapper = new ObjectMapper();
    localObjectNode.put("has_push", localObjectMapper.valueToTree(Maps.a(paramMobileAppData.a())));
    localObjectNode.put("is_installed", localObjectMapper.valueToTree(Maps.a(paramMobileAppData.b())));
    localObjectNode.put("last_used", localObjectMapper.valueToTree(Maps.a(paramMobileAppData.c())));
    return localObjectNode;
  }

  public ObjectNode a(PicCropInfo paramPicCropInfo)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("uri", paramPicCropInfo.a());
    localObjectNode.put("width", paramPicCropInfo.c());
    localObjectNode.put("height", paramPicCropInfo.d());
    localObjectNode.put("left", paramPicCropInfo.e());
    localObjectNode.put("right", paramPicCropInfo.g());
    localObjectNode.put("top", paramPicCropInfo.f());
    localObjectNode.put("bottom", paramPicCropInfo.h());
    return localObjectNode;
  }

  public ImmutableList<User> a(User.Type paramType, JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.iterator();
    while (localIterator.hasNext())
      localBuilder.b(b(paramType, (JsonNode)localIterator.next()));
    return localBuilder.b();
  }

  public Name b(JsonNode paramJsonNode)
  {
    if (paramJsonNode.has("first_name"));
    for (String str1 = JSONUtil.b(paramJsonNode.get("first_name")); ; str1 = null)
    {
      if (paramJsonNode.has("last_name"));
      for (String str2 = JSONUtil.b(paramJsonNode.get("last_name")); ; str2 = null)
      {
        boolean bool = paramJsonNode.has("name");
        String str3 = null;
        if (bool)
          str3 = JSONUtil.b(paramJsonNode.get("name"));
        return new Name(str1, str2, str3);
      }
    }
  }

  public User b(User.Type paramType, JsonNode paramJsonNode)
  {
    UserBuilder localUserBuilder = new UserBuilder();
    Preconditions.checkArgument(paramJsonNode.has("uid"), "Missing id field on profile");
    String str = JSONUtil.b(paramJsonNode.get("uid"));
    if (str == null)
      str = JSONUtil.b(paramJsonNode.get("id"));
    localUserBuilder.a(paramType, str);
    TriState localTriState;
    if (JSONUtil.a(paramJsonNode.get("contact_email")))
    {
      localUserBuilder.a(ImmutableList.a(new UserEmailAddress(JSONUtil.b(paramJsonNode.get("contact_email")), 0)));
      if (JSONUtil.a(paramJsonNode.get("phones")))
        localUserBuilder.b(d(paramJsonNode.get("phones")));
      localUserBuilder.a(b(paramJsonNode));
      localUserBuilder.a(e(paramJsonNode));
      if (paramJsonNode.has("pic_square"))
        localUserBuilder.d(a(JSONUtil.b(paramJsonNode.get("pic_square"))));
      if (paramJsonNode.has("pic_big"))
        localUserBuilder.e(a(JSONUtil.b(paramJsonNode.get("pic_big"))));
      if (paramJsonNode.has("pic_crop"))
        localUserBuilder.a(a(paramJsonNode.get("pic_crop")));
      if (paramJsonNode.has("rank"))
        localUserBuilder.a((float)JSONUtil.e(paramJsonNode.get("rank")));
      if (!paramJsonNode.has("is_pushable"))
        break label392;
      if (!paramJsonNode.get("is_pushable").booleanValue())
        break label384;
      localTriState = TriState.YES;
      label282: localUserBuilder.a(localTriState);
    }
    while (true)
    {
      if (!paramJsonNode.has("affiliations"))
        break label403;
      Iterator localIterator = paramJsonNode.get("affiliations").iterator();
      while (localIterator.hasNext())
      {
        if (JSONUtil.c(((JsonNode)localIterator.next()).get("nid")) != 50431648L)
          continue;
        localUserBuilder.a(true);
      }
      if (!paramJsonNode.has("emails"))
        break;
      localUserBuilder.a(c(paramJsonNode.get("emails")));
      break;
      label384: localTriState = TriState.NO;
      break label282;
      label392: localUserBuilder.a(TriState.UNSET);
    }
    label403: localUserBuilder.a(paramJsonNode.path("is_employee").asBoolean(false));
    if (paramJsonNode.has("last_active"))
      localUserBuilder.a(f(paramJsonNode.get("last_active")));
    if (paramJsonNode.has("mobile_app_data"))
      localUserBuilder.a(g(paramJsonNode.get("mobile_app_data")));
    if (paramJsonNode.has("type"))
      localUserBuilder.h(JSONUtil.b(paramJsonNode.get("type")));
    return localUserBuilder.w();
  }

  public JsonNode b(ImmutableList<UserPhoneNumber> paramImmutableList)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramImmutableList.iterator();
    if (localIterator.hasNext())
    {
      UserPhoneNumber localUserPhoneNumber = (UserPhoneNumber)localIterator.next();
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("full_number", localUserPhoneNumber.b());
      localObjectNode.put("display_number", localUserPhoneNumber.a());
      if (localUserPhoneNumber.g() != TriState.UNSET)
        if (localUserPhoneNumber.g() != TriState.YES)
          break label136;
      label136: for (boolean bool = true; ; bool = false)
      {
        localObjectNode.put("is_verified", bool);
        localObjectNode.put("android_type", localUserPhoneNumber.f());
        localArrayNode.add(localObjectNode);
        break;
      }
    }
    return localArrayNode;
  }

  public ImmutableList<UserEmailAddress> c(JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.iterator();
    while (localIterator.hasNext())
      localBuilder.b(new UserEmailAddress(JSONUtil.b((JsonNode)localIterator.next()), 0));
    return localBuilder.b();
  }

  public ImmutableList<UserPhoneNumber> d(JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.iterator();
    JsonNode localJsonNode;
    Object localObject;
    String str3;
    label66: TriState localTriState;
    label101: int i;
    if (localIterator.hasNext())
    {
      localJsonNode = (JsonNode)localIterator.next();
      if (localJsonNode.has("full_number"))
      {
        localObject = JSONUtil.b(localJsonNode.get("full_number"));
        str3 = JSONUtil.b(localJsonNode.get("display_number"));
        localTriState = TriState.UNSET;
        if (localJsonNode.has("is_verified"))
        {
          if (!localJsonNode.get("is_verified").booleanValue())
            break label209;
          localTriState = TriState.YES;
        }
        if (!localJsonNode.has("android_type"))
          break label217;
        i = JSONUtil.d(localJsonNode.get("android_type"));
      }
    }
    while (true)
    {
      localBuilder.b(new UserPhoneNumber(str3, (String)localObject, i, localTriState));
      break;
      String str1 = JSONUtil.b(localJsonNode.get("country_code"));
      String str2 = JSONUtil.b(localJsonNode.get("number"));
      str3 = "+" + str1 + str2;
      localObject = str3;
      break label66;
      label209: localTriState = TriState.NO;
      break label101;
      label217: if (localJsonNode.has("type"))
      {
        String str4 = JSONUtil.b(localJsonNode.get("type"));
        if ("other_phone".equals(str4))
        {
          i = 7;
          continue;
        }
        if ("cell".equals(str4))
        {
          i = 2;
          continue;
          return localBuilder.b();
        }
      }
      i = 0;
    }
  }

  public Birthday e(JsonNode paramJsonNode)
  {
    JsonNode localJsonNode = paramJsonNode.get("birthday_date");
    String str;
    int m;
    Date localDate2;
    int n;
    int i1;
    int i;
    int j;
    int k;
    if ((localJsonNode != null) && (!localJsonNode.isNull()))
    {
      str = localJsonNode.textValue();
      Date localDate1 = ((SimpleDateFormat)this.b.get()).parse(str, new ParsePosition(0));
      if (localDate1 != null)
      {
        m = 1;
        localDate2 = localDate1;
        if (localDate2 == null)
          break label163;
        n = 1 + localDate2.getMonth();
        i1 = localDate2.getDate();
        if (m == 0)
          break label150;
        i = 1900 + localDate2.getYear();
        j = i1;
        k = n;
      }
    }
    while (true)
    {
      return new Birthday(k, j, i);
      localDate2 = ((SimpleDateFormat)this.c.get()).parse(str, new ParsePosition(0));
      m = 0;
      break;
      label150: j = i1;
      k = n;
      i = 0;
      continue;
      label163: i = 0;
      j = 0;
      k = 0;
    }
  }

  public LastActive f(JsonNode paramJsonNode)
  {
    LastActive localLastActive = null;
    if (paramJsonNode == null);
    while (true)
    {
      return localLastActive;
      boolean bool1 = paramJsonNode.has("time");
      localLastActive = null;
      if (!bool1)
        continue;
      boolean bool2 = paramJsonNode.has("active");
      localLastActive = null;
      if (!bool2)
        continue;
      localLastActive = new LastActive(1000L * JSONUtil.c(paramJsonNode.get("time")), JSONUtil.f(paramJsonNode.get("active")));
    }
  }

  public MobileAppData g(JsonNode paramJsonNode)
  {
    Object localObject = null;
    if (paramJsonNode == null);
    while (true)
    {
      return localObject;
      boolean bool1 = paramJsonNode.has("has_push");
      localObject = null;
      if (!bool1)
        continue;
      boolean bool2 = paramJsonNode.has("is_installed");
      localObject = null;
      if (!bool2)
        continue;
      boolean bool3 = paramJsonNode.has("last_used");
      localObject = null;
      if (!bool3)
        continue;
      ObjectMapper localObjectMapper = new ObjectMapper();
      try
      {
        localMap1 = (Map)localObjectMapper.readValue(paramJsonNode.get("has_push").toString(), new UserSerialization.3(this));
        localMap2 = (Map)localObjectMapper.readValue(paramJsonNode.get("is_installed").toString(), new UserSerialization.4(this));
        localMap3 = (Map)localObjectMapper.readValue(paramJsonNode.get("last_used").toString(), new UserSerialization.5(this));
        Iterator localIterator = localMap3.entrySet().iterator();
        while (localIterator.hasNext())
        {
          if (((Map.Entry)localIterator.next()).getValue() != null)
            continue;
          localIterator.remove();
        }
      }
      catch (JsonParseException localJsonParseException)
      {
        Map localMap1;
        Map localMap2;
        Map localMap3;
        throw new RuntimeException("Unexpected serialization exception with mobile_app_data", localJsonParseException);
        MobileAppData localMobileAppData = new MobileAppData(ImmutableMap.a(localMap1), ImmutableMap.a(localMap2), ImmutableMap.a(localMap3));
        localObject = localMobileAppData;
      }
      catch (JsonMappingException localJsonMappingException)
      {
        throw new RuntimeException("Unexpected serialization exception with mobile_app_data", localJsonMappingException);
      }
      catch (IOException localIOException)
      {
      }
    }
    throw new RuntimeException("Unexpected serialization exception with mobile_app_data", localIOException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserSerialization
 * JD-Core Version:    0.6.0
 */