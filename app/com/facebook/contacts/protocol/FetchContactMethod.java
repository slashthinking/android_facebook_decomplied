package com.facebook.contacts.protocol;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.graphql.GraphQLQuery;
import com.facebook.contacts.graphql.GraphQLQueryBuilder;
import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.models.ContactSummaryBuilder;
import com.facebook.contacts.models.EntrySection;
import com.facebook.contacts.models.entry.Entry;
import com.facebook.contacts.models.entry.PhoneEntry;
import com.facebook.contacts.server.FetchContactParams;
import com.facebook.contacts.server.FetchContactResult;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

public class FetchContactMethod
  implements ApiMethod<FetchContactParams, FetchContactResult>
{
  private final ContactGraphQL a;

  @Inject
  public FetchContactMethod(ContactGraphQL paramContactGraphQL)
  {
    this.a = paramContactGraphQL;
  }

  private GraphQLQueryBuilder a(GraphQLQueryBuilder paramGraphQLQueryBuilder)
  {
    this.a.a(paramGraphQLQueryBuilder);
    GraphQLQuery localGraphQLQuery = GraphQLQuery.b("rows").a(GraphQLQuery.b("nodes").c("label").a(b(GraphQLQuery.b("entries")).f()).a(b(GraphQLQuery.b("hidden_entries")).f()).f()).f();
    paramGraphQLQueryBuilder.a(GraphQLQuery.b("represented_profile").c("has_timeline").d("complete_represented_profile").f()).a(GraphQLQuery.b("info_sections").a(GraphQLQuery.b("nodes").a(localGraphQLQuery).c("label").f()).f());
    return paramGraphQLQueryBuilder;
  }

  private ContactSummary a(JsonNode paramJsonNode)
  {
    return this.a.a(paramJsonNode).q();
  }

  private JsonNode a(User.Type paramType, JsonNode paramJsonNode)
  {
    JsonNode localJsonNode = paramJsonNode.get((String)paramJsonNode.fieldNames().next());
    if (paramType == User.Type.FACEBOOK)
      localJsonNode = localJsonNode.get("contact");
    return localJsonNode;
  }

  private String a(UserKey paramUserKey)
  {
    boolean bool;
    String str;
    GraphQLQuery localGraphQLQuery2;
    if ((paramUserKey.a() == User.Type.FACEBOOK) || (paramUserKey.a() == User.Type.FACEBOOK_CONTACT))
    {
      bool = true;
      Preconditions.checkArgument(bool);
      if (paramUserKey.a() != User.Type.FACEBOOK)
        break label80;
      str = paramUserKey.b();
      localGraphQLQuery2 = a(GraphQLQuery.b("contact")).f();
    }
    label80: for (GraphQLQuery localGraphQLQuery1 = GraphQLQuery.a(str).a(localGraphQLQuery2).f(); ; localGraphQLQuery1 = a(GraphQLQuery.a(paramUserKey.b())).f())
    {
      return localGraphQLQuery1.toString();
      bool = false;
      break;
    }
  }

  private void a(ImmutableList.Builder<Entry> paramBuilder1, ImmutableList.Builder<Entry> paramBuilder2, JsonNode paramJsonNode)
  {
    paramJsonNode.get("label").textValue();
    JsonNode localJsonNode1 = paramJsonNode.get("entries");
    JsonNode localJsonNode2 = paramJsonNode.get("hidden_entries");
    Iterator localIterator1 = localJsonNode1.iterator();
    while (localIterator1.hasNext())
    {
      Entry localEntry2 = d((JsonNode)localIterator1.next());
      if (localEntry2 == null)
        continue;
      paramBuilder1.b(localEntry2);
    }
    Iterator localIterator2 = localJsonNode2.iterator();
    while (localIterator2.hasNext())
    {
      Entry localEntry1 = d((JsonNode)localIterator2.next());
      if (localEntry1 == null)
        continue;
      paramBuilder2.b(localEntry1);
    }
  }

  private GraphQLQueryBuilder b(GraphQLQueryBuilder paramGraphQLQueryBuilder)
  {
    return paramGraphQLQueryBuilder.c("graph_api_write_id").a(GraphQLQuery.b("primary_field").c("value").c("source").c("creation_time").c("__type__").a(GraphQLQuery.b("phone").c("display_number").c("universal_number").f()).f());
  }

  private ContactDetails b(JsonNode paramJsonNode)
  {
    String str = JSONUtil.b(paramJsonNode.get("id"));
    JsonNode localJsonNode = paramJsonNode.get("info_sections");
    boolean bool = JSONUtil.f(paramJsonNode.path("complete_represented_profile").get("has_timeline"));
    return new ContactDetails(str, c(localJsonNode.get("nodes")), bool);
  }

  private EntrySection c(JsonNode paramJsonNode)
  {
    String str;
    ImmutableList.Builder localBuilder1;
    ImmutableList.Builder localBuilder2;
    if (paramJsonNode.size() > 0)
    {
      JsonNode localJsonNode1 = paramJsonNode.get(0);
      str = localJsonNode1.get("label").textValue();
      JsonNode localJsonNode2 = localJsonNode1.get("rows").get("nodes");
      localBuilder1 = ImmutableList.e();
      localBuilder2 = ImmutableList.e();
      Iterator localIterator = localJsonNode2.iterator();
      while (localIterator.hasNext())
        a(localBuilder1, localBuilder2, (JsonNode)localIterator.next());
    }
    for (EntrySection localEntrySection = new EntrySection(str, localBuilder1.b(), localBuilder2.b()); ; localEntrySection = new EntrySection(null, ImmutableList.d(), ImmutableList.d()))
      return localEntrySection;
  }

  private Entry d(JsonNode paramJsonNode)
  {
    boolean bool = JSONUtil.f(paramJsonNode.get("is_verified"));
    String str1 = JSONUtil.b(paramJsonNode.get("graph_api_write_id"));
    JsonNode localJsonNode1 = paramJsonNode.get("primary_field");
    JsonNode localJsonNode2 = localJsonNode1.get("__type__");
    if (localJsonNode2 != null);
    for (String str2 = JSONUtil.b(localJsonNode2.get("name")); ; str2 = null)
    {
      JsonNode localJsonNode3 = localJsonNode1.get("source");
      if (localJsonNode3 != null);
      for (String str3 = JSONUtil.b(localJsonNode3.get("text")); ; str3 = null)
      {
        long l = JSONUtil.c(localJsonNode1.get("creation_time"));
        if ("ContactPhone".equals(str2));
        for (PhoneEntry localPhoneEntry = new PhoneEntry(str1, bool, str3, l, JSONUtil.b(localJsonNode1.get("phone").get("universal_number")), 2); ; localPhoneEntry = null)
          return localPhoneEntry;
      }
    }
  }

  public FetchContactResult a(FetchContactParams paramFetchContactParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode1 = paramApiResponse.c();
    JsonNode localJsonNode2 = a(paramFetchContactParams.a().a(), localJsonNode1);
    ContactSummary localContactSummary = a(localJsonNode2);
    ContactDetails localContactDetails = b(localJsonNode2);
    return new FetchContactResult(DataFreshnessResult.FROM_SERVER, System.currentTimeMillis(), localContactSummary, localContactDetails);
  }

  public ApiRequest a(FetchContactParams paramFetchContactParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("q", a(paramFetchContactParams.a())));
    return new ApiRequest("fetchContact", "GET", "graphql", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.FetchContactMethod
 * JD-Core Version:    0.6.0
 */