package com.facebook.contacts.protocol;

import com.facebook.contacts.server.UploadBulkContactChange;
import com.facebook.contacts.server.UploadBulkContactChangeResult;
import com.facebook.contacts.server.UploadBulkContactChangeResult.Confidence;
import com.facebook.contacts.server.UploadBulkContactChangeResult.Type;
import com.facebook.contacts.server.UploadBulkContactFieldMatch;
import com.facebook.contacts.server.UploadBulkContactFieldMatch.MatchType;
import com.facebook.contacts.server.UploadBulkContactFieldMatch.ValueType;
import com.facebook.contacts.server.UploadBulkContactsParams;
import com.facebook.contacts.server.UploadBulkContactsResult;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserEmailAddress;
import com.facebook.orca.users.UserPhoneNumber;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

public class UploadBulkContactsMethod
  implements ApiMethod<UploadBulkContactsParams, UploadBulkContactsResult>
{
  private static final Class<?> a = UploadBulkContactsMethod.class;
  private final JsonFactory b;

  @Inject
  public UploadBulkContactsMethod(JsonFactory paramJsonFactory)
  {
    this.b = paramJsonFactory;
  }

  private String a(UploadBulkContactChange paramUploadBulkContactChange)
  {
    String str;
    switch (UploadBulkContactsMethod.1.a[paramUploadBulkContactChange.c().ordinal()])
    {
    default:
      str = null;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return str;
      str = "add";
      continue;
      str = "modify";
      continue;
      str = "delete";
    }
  }

  private String a(UserEmailAddress paramUserEmailAddress)
  {
    int i = paramUserEmailAddress.b();
    String str;
    if (i == 1)
      str = "home";
    while (true)
    {
      return str;
      if (i == 2)
      {
        str = "work";
        continue;
      }
      str = "other";
    }
  }

  private String a(UserPhoneNumber paramUserPhoneNumber)
  {
    int i = paramUserPhoneNumber.f();
    String str;
    if (i == 1)
      str = "home";
    while (true)
    {
      return str;
      if (i == 3)
      {
        str = "work";
        continue;
      }
      if (i == 2)
      {
        str = "mobile";
        continue;
      }
      if (i == 5)
      {
        str = "fax_home";
        continue;
      }
      if (i == 4)
      {
        str = "fax_work";
        continue;
      }
      if (i == 13)
      {
        str = "fax_other";
        continue;
      }
      if (i == 6)
      {
        str = "pager";
        continue;
      }
      str = "other";
    }
  }

  private String a(ImmutableList<UploadBulkContactChange> paramImmutableList)
  {
    StringWriter localStringWriter = new StringWriter();
    JsonGenerator localJsonGenerator = this.b.createJsonGenerator(localStringWriter);
    localJsonGenerator.writeStartArray();
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
      a((UploadBulkContactChange)localIterator.next(), localJsonGenerator);
    localJsonGenerator.writeEndArray();
    localJsonGenerator.flush();
    return localStringWriter.toString();
  }

  private void a(UploadBulkContactChange paramUploadBulkContactChange, JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeStringField("client_contact_id", paramUploadBulkContactChange.a());
    paramJsonGenerator.writeStringField("update_type", a(paramUploadBulkContactChange));
    a(paramUploadBulkContactChange.b(), paramJsonGenerator);
    paramJsonGenerator.writeEndObject();
  }

  private void a(User paramUser, JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeObjectFieldStart("contact");
    paramJsonGenerator.writeObjectFieldStart("name");
    Name localName = paramUser.d();
    paramJsonGenerator.writeStringField("formatted", localName.f());
    if (localName.a())
      paramJsonGenerator.writeStringField("first", localName.getFirstName());
    if (localName.b())
      paramJsonGenerator.writeStringField("last", localName.getLastName());
    paramJsonGenerator.writeEndObject();
    ImmutableList localImmutableList1 = paramUser.i();
    if (!localImmutableList1.isEmpty())
    {
      paramJsonGenerator.writeArrayFieldStart("emails");
      Iterator localIterator2 = localImmutableList1.iterator();
      while (localIterator2.hasNext())
      {
        UserEmailAddress localUserEmailAddress = (UserEmailAddress)localIterator2.next();
        paramJsonGenerator.writeStartObject();
        paramJsonGenerator.writeStringField("type", a(localUserEmailAddress));
        paramJsonGenerator.writeStringField("email", localUserEmailAddress.a());
        paramJsonGenerator.writeEndObject();
      }
      paramJsonGenerator.writeEndArray();
    }
    ImmutableList localImmutableList2 = paramUser.j();
    if (!localImmutableList2.isEmpty())
    {
      paramJsonGenerator.writeArrayFieldStart("phones");
      Iterator localIterator1 = localImmutableList2.iterator();
      while (localIterator1.hasNext())
      {
        UserPhoneNumber localUserPhoneNumber = (UserPhoneNumber)localIterator1.next();
        paramJsonGenerator.writeStartObject();
        paramJsonGenerator.writeStringField("type", a(localUserPhoneNumber));
        paramJsonGenerator.writeStringField("number", localUserPhoneNumber.b());
        paramJsonGenerator.writeEndObject();
      }
      paramJsonGenerator.writeEndArray();
    }
    paramJsonGenerator.writeEndObject();
  }

  public UploadBulkContactsResult a(UploadBulkContactsParams paramUploadBulkContactsParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode1 = paramApiResponse.c();
    BLog.b(a, "Got response: " + localJsonNode1);
    String str1 = JSONUtil.b(localJsonNode1.get("import_id"));
    ImmutableList.Builder localBuilder1 = ImmutableList.e();
    Iterator localIterator1 = localJsonNode1.get("contact_changes").fields();
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      String str2 = (String)localEntry.getKey();
      JsonNode localJsonNode2 = (JsonNode)localEntry.getValue();
      String str3 = JSONUtil.b(localJsonNode2.get("update_type"));
      UploadBulkContactChangeResult.Type localType;
      label130: String str4;
      ImmutableList.Builder localBuilder2;
      Iterator localIterator2;
      if (str3.equals("add"))
      {
        localType = UploadBulkContactChangeResult.Type.ADD;
        str4 = JSONUtil.b(localJsonNode2.get("contact").get("id"));
        localBuilder2 = ImmutableList.e();
        localIterator2 = localJsonNode2.get("field_matches").iterator();
      }
      while (true)
      {
        label166: if (!localIterator2.hasNext())
          break label523;
        JsonNode localJsonNode3 = (JsonNode)localIterator2.next();
        String str6 = JSONUtil.b(localJsonNode3.get("match_type"));
        UploadBulkContactFieldMatch.MatchType localMatchType;
        label217: String str7;
        UploadBulkContactFieldMatch.ValueType localValueType;
        if (str6.equals("hard"))
        {
          localMatchType = UploadBulkContactFieldMatch.MatchType.HARD;
          str7 = JSONUtil.b(localJsonNode3.get("value_type"));
          if (!str7.equals("name"))
            break label412;
          localValueType = UploadBulkContactFieldMatch.ValueType.NAME;
        }
        while (true)
        {
          localBuilder2.b(new UploadBulkContactFieldMatch(localMatchType, localValueType));
          break label166;
          if (str3.equals("modify"))
          {
            localType = UploadBulkContactChangeResult.Type.MODIFY;
            break label130;
          }
          if (str3.equals("remove"))
          {
            localType = UploadBulkContactChangeResult.Type.REMOVE;
            break label130;
          }
          if (str3.equals("none"))
          {
            localType = UploadBulkContactChangeResult.Type.NONE;
            break label130;
          }
          BLog.e(a, "Unrecognized contact change type: " + str3 + ", skipping");
          break;
          if (str6.equals("soft"))
          {
            localMatchType = UploadBulkContactFieldMatch.MatchType.SOFT;
            break label217;
          }
          BLog.e(a, "Unrecognized contact field match type: " + str6 + ", skipping");
          break label166;
          label412: if (str7.equals("email"))
          {
            localValueType = UploadBulkContactFieldMatch.ValueType.EMAIL;
            continue;
          }
          if (str7.equals("phone"))
          {
            localValueType = UploadBulkContactFieldMatch.ValueType.PHONE;
            continue;
          }
          if (str7.equals("email_public_hash"))
          {
            localValueType = UploadBulkContactFieldMatch.ValueType.EMAIL_PUBLIC_HASH;
            continue;
          }
          if (!str7.equals("phone_public_hash"))
            break label487;
          localValueType = UploadBulkContactFieldMatch.ValueType.PHONE_PUBLIC_HASH;
        }
        label487: BLog.e(a, "Unrecognized contact field value type: " + str7 + ", skipping");
      }
      label523: String str5 = JSONUtil.b(localJsonNode2.get("match_confidence"));
      UploadBulkContactChangeResult.Confidence localConfidence;
      if (str5.equals("high"))
        localConfidence = UploadBulkContactChangeResult.Confidence.HIGH;
      while (true)
      {
        localBuilder1.b(new UploadBulkContactChangeResult(localType, str2, str4, localBuilder2.b(), localConfidence));
        break;
        if (str5.equals("medium"))
        {
          localConfidence = UploadBulkContactChangeResult.Confidence.MEDIUM;
          continue;
        }
        if (str5.equals("low"))
        {
          localConfidence = UploadBulkContactChangeResult.Confidence.LOW;
          continue;
        }
        if (str5.equals("very_low"))
        {
          localConfidence = UploadBulkContactChangeResult.Confidence.VERY_LOW;
          continue;
        }
        if (str5.equals("unknown"))
        {
          localConfidence = UploadBulkContactChangeResult.Confidence.UNKNOWN;
          continue;
        }
        BLog.e(a, "Unrecognized confidence type: " + str5);
        localConfidence = UploadBulkContactChangeResult.Confidence.UNKNOWN;
      }
    }
    return new UploadBulkContactsResult(str1, localBuilder1.b(), DataFreshnessResult.FROM_SERVER, System.currentTimeMillis());
  }

  public ApiRequest a(UploadBulkContactsParams paramUploadBulkContactsParams)
  {
    ArrayList localArrayList = Lists.a();
    if (paramUploadBulkContactsParams.a() != null)
      localArrayList.add(new BasicNameValuePair("import_id", paramUploadBulkContactsParams.a()));
    localArrayList.add(new BasicNameValuePair("contact_changes", a(paramUploadBulkContactsParams.b())));
    BLog.b(a, "Uploading contacts: " + localArrayList);
    return new ApiRequest("graphUploadBulkContacts", "POST", "me/bulkcontacts", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.UploadBulkContactsMethod
 * JD-Core Version:    0.6.0
 */