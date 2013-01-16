package com.facebook.orca.protocol.methods;

import com.facebook.orca.users.User;
import com.facebook.orca.users.UserFbidIdentifier;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserIdentifier.IdentifierType;
import com.facebook.orca.users.UserPhoneNumber;
import com.facebook.orca.users.UserWithIdentifier;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class PickedUserUtils
{
  private JsonNode b(UserWithIdentifier paramUserWithIdentifier)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    UserIdentifier localUserIdentifier = paramUserWithIdentifier.b();
    if (localUserIdentifier.e() == UserIdentifier.IdentifierType.FBID)
    {
      UserFbidIdentifier localUserFbidIdentifier = (UserFbidIdentifier)localUserIdentifier;
      localObjectNode.put("type", "id");
      localObjectNode.put("id", localUserFbidIdentifier.a());
    }
    while (true)
    {
      return localObjectNode;
      if (localUserIdentifier.e() != UserIdentifier.IdentifierType.PHONE)
        continue;
      UserPhoneNumber localUserPhoneNumber = (UserPhoneNumber)localUserIdentifier;
      localObjectNode.put("type", "phone");
      localObjectNode.put("phone", localUserPhoneNumber.d());
      localObjectNode.put("country", Locale.getDefault().getCountry());
      localObjectNode.put("name", paramUserWithIdentifier.a().f());
    }
  }

  public UserPhoneNumber a(UserWithIdentifier paramUserWithIdentifier)
  {
    UserIdentifier localUserIdentifier = paramUserWithIdentifier.b();
    if ((localUserIdentifier instanceof UserPhoneNumber));
    for (UserPhoneNumber localUserPhoneNumber = (UserPhoneNumber)localUserIdentifier; ; localUserPhoneNumber = null)
      return localUserPhoneNumber;
  }

  JsonNode a(List<UserWithIdentifier> paramList)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayNode.add(b((UserWithIdentifier)localIterator.next()));
    return localArrayNode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.PickedUserUtils
 * JD-Core Version:    0.6.0
 */