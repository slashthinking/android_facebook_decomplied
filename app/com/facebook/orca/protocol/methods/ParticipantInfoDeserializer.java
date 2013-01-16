package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

public class ParticipantInfoDeserializer
{
  private static String a(String paramString)
  {
    if ("0".equals(paramString))
      paramString = null;
    return paramString;
  }

  public ImmutableList<ParticipantInfo> a(JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.iterator();
    while (localIterator.hasNext())
      localBuilder.b(b((JsonNode)localIterator.next()));
    return localBuilder.b();
  }

  public ParticipantInfo b(JsonNode paramJsonNode)
  {
    String str1 = JSONUtil.b(paramJsonNode.get("email"));
    UserKey localUserKey;
    if (paramJsonNode.has("user_id"))
    {
      String str3 = a(JSONUtil.b(paramJsonNode.get("user_id")));
      if (str3 != null)
        localUserKey = new UserKey(User.Type.FACEBOOK, str3);
    }
    while (true)
    {
      return new ParticipantInfo(localUserKey, JSONUtil.b(paramJsonNode.get("name")), str1);
      localUserKey = new UserKey(User.Type.EMAIL, str1);
      continue;
      String str2 = JSONUtil.b(paramJsonNode.get("id"));
      localUserKey = new UserKey(User.Type.FACEBOOK_OBJECT, str2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.ParticipantInfoDeserializer
 * JD-Core Version:    0.6.0
 */