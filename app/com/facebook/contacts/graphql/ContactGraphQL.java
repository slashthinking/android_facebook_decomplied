package com.facebook.contacts.graphql;

import com.facebook.common.util.TriState;
import com.facebook.contacts.models.ContactPhone;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.models.ContactSummaryBuilder;
import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.contacts.pictures.ContactPictureSizes.Size;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.users.Name;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import java.util.Iterator;
import javax.inject.Inject;

public final class ContactGraphQL
{
  private final ContactPictureSizes a;

  @Inject
  public ContactGraphQL(ContactPictureSizes paramContactPictureSizes)
  {
    this.a = paramContactPictureSizes;
  }

  public ContactSummaryBuilder a(JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (paramJsonNode.isNull()))
      throw new IOException("Server sent a null response for a contact");
    Name localName1 = b(paramJsonNode.get("structured_name"));
    Name localName2 = b(paramJsonNode.get("phonetic_name"));
    ContactSummaryBuilder localContactSummaryBuilder = ContactSummary.newBuilder().a(JSONUtil.b(paramJsonNode.get("id"))).c(JSONUtil.b(paramJsonNode.get("graph_api_write_id"))).a(localName1).b(localName2).e(JSONUtil.b(paramJsonNode.path("small_picture_url").get("uri"))).f(JSONUtil.b(paramJsonNode.path("big_picture_url").get("uri")));
    JsonNode localJsonNode1 = paramJsonNode.get("represented_profile");
    TriState localTriState;
    if (localJsonNode1 != null)
    {
      localContactSummaryBuilder.b(JSONUtil.b(localJsonNode1.get("id")));
      localContactSummaryBuilder.a((float)JSONUtil.e(localJsonNode1.get("rank")));
      localContactSummaryBuilder.a(JSONUtil.f(localJsonNode1.get("can_message")));
      if (!JSONUtil.f(localJsonNode1.get("is_mobile_pushable")))
        break label357;
      localTriState = TriState.YES;
    }
    while (true)
    {
      localContactSummaryBuilder.a(localTriState);
      localContactSummaryBuilder.b(JSONUtil.f(localJsonNode1.get("is_memorialized")));
      ImmutableList.Builder localBuilder = ImmutableList.e();
      JsonNode localJsonNode2 = paramJsonNode.get("phones");
      if ((localJsonNode2 == null) || (localJsonNode2.isNull()))
        break;
      Iterator localIterator = localJsonNode2.elements();
      while (true)
        if (localIterator.hasNext())
        {
          JsonNode localJsonNode3 = (JsonNode)localIterator.next();
          JsonNode localJsonNode4 = localJsonNode3.get("primary_field");
          JsonNode localJsonNode5 = localJsonNode4.get("phone");
          localBuilder.b(new ContactPhone(JSONUtil.b(localJsonNode4.get("id")), JSONUtil.b(localJsonNode4.get("label")), JSONUtil.b(localJsonNode5.get("display_number")), JSONUtil.b(localJsonNode5.get("universal_number")), JSONUtil.f(localJsonNode3.get("is_verified"))));
          continue;
          label357: localTriState = TriState.NO;
          break;
        }
      localContactSummaryBuilder.a(localBuilder.b());
    }
    return localContactSummaryBuilder;
  }

  public String a(int paramInt, String paramString, ContactGraphQL.QueryType paramQueryType)
  {
    boolean bool;
    GraphQLQueryBuilder localGraphQLQueryBuilder1;
    GraphQLQueryBuilder localGraphQLQueryBuilder2;
    Object localObject;
    GraphQLQueryBuilder localGraphQLQueryBuilder4;
    if (paramQueryType == ContactGraphQL.QueryType.DELTA)
    {
      if (paramString != null)
      {
        bool = true;
        Preconditions.checkArgument(bool);
      }
    }
    else
    {
      localGraphQLQueryBuilder1 = GraphQLQuery.b("contacts");
      if (paramQueryType == ContactGraphQL.QueryType.FULL)
        localGraphQLQueryBuilder1.a("contact_profile_type", new Object[] { "user,unmatched" }).a("high_quality", new Object[0]).a("orderby", new Object[] { "communication" });
      localGraphQLQueryBuilder2 = GraphQLQuery.b("page_info").c("end_cursor").c("has_next_page");
      if (paramQueryType != ContactGraphQL.QueryType.FULL)
        break label247;
      GraphQLQueryBuilder localGraphQLQueryBuilder5 = GraphQLQuery.b("nodes");
      a(localGraphQLQueryBuilder5);
      localGraphQLQueryBuilder2.c("delta_cursor");
      localObject = localGraphQLQueryBuilder5;
      localGraphQLQueryBuilder4 = localGraphQLQueryBuilder1;
    }
    while (true)
    {
      if (paramString != null)
      {
        localGraphQLQueryBuilder4.a("after", new Object[] { paramString });
        if (paramQueryType == ContactGraphQL.QueryType.DELTA)
          localGraphQLQueryBuilder4.a("high_quality", new Object[0]).a("contact_profile_type", new Object[] { "user,unmatched" });
      }
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localGraphQLQueryBuilder4.a("first", arrayOfObject).a(localGraphQLQueryBuilder2.f());
      GraphQLQuery localGraphQLQuery = localGraphQLQueryBuilder1.a(((GraphQLQueryBuilder)localObject).f()).f();
      return GraphQLQuery.a().a(localGraphQLQuery).f().toString();
      bool = false;
      break;
      label247: GraphQLQueryBuilder localGraphQLQueryBuilder3 = GraphQLQuery.b("added");
      a(localGraphQLQueryBuilder3);
      localGraphQLQueryBuilder4 = GraphQLQuery.b("deltas").a(GraphQLQuery.b("nodes").a(localGraphQLQueryBuilder3.f()).c("removed").f());
      localObject = localGraphQLQueryBuilder4;
    }
  }

  public void a(GraphQLQueryBuilder paramGraphQLQueryBuilder)
  {
    GraphQLQuery localGraphQLQuery = GraphQLQuery.b("parts").c("offset").c("length").c("part").f();
    GraphQLQueryBuilder localGraphQLQueryBuilder1 = paramGraphQLQueryBuilder.c("id").c("graph_api_write_id").a(GraphQLQuery.b("represented_profile").c("id").c("birthday").a(GraphQLQuery.b("rank").a("coeff_rank", new Object[] { "communication" }).f()).c("can_message").c("is_mobile_pushable").c("is_memorialized").f()).a(GraphQLQuery.b("structured_name").a(localGraphQLQuery).c("text").f()).a(GraphQLQuery.b("phonetic_name").a(localGraphQLQuery).c("text").f()).a(GraphQLQuery.b("phones").c("is_verified").a(GraphQLQuery.b("primary_field").c("id").c("label").a(GraphQLQuery.b("phone").c("display_number").c("universal_number").f()).f()).f()).a(GraphQLQuery.b("emails").a(GraphQLQuery.b("primary_field").c("id").c("label").c("value").f()).f());
    GraphQLQueryBuilder localGraphQLQueryBuilder2 = GraphQLQuery.b("profile_picture");
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(this.a.a(ContactPictureSizes.Size.SMALL));
    GraphQLQueryBuilder localGraphQLQueryBuilder3 = localGraphQLQueryBuilder1.a(localGraphQLQueryBuilder2.a("size", arrayOfObject1).c("uri").d("small_picture_url").f());
    GraphQLQueryBuilder localGraphQLQueryBuilder4 = GraphQLQuery.b("profile_picture");
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Integer.valueOf(this.a.a(ContactPictureSizes.Size.BIG));
    localGraphQLQueryBuilder3.a(localGraphQLQueryBuilder4.a("size", arrayOfObject2).c("uri").d("big_picture_url").f());
  }

  public Name b(JsonNode paramJsonNode)
  {
    Object localObject1 = null;
    if ((paramJsonNode == null) || (paramJsonNode.isNull()));
    String str1;
    JsonNode localJsonNode1;
    for (Name localName = new Name(null, null); ; localName = new Name(null, null, str1))
    {
      return localName;
      str1 = JSONUtil.b(paramJsonNode.get("text"));
      localJsonNode1 = paramJsonNode.get("parts");
      if ((str1 != null) && (localJsonNode1 != null))
        break;
    }
    Iterator localIterator = localJsonNode1.iterator();
    Object localObject2 = null;
    label80: String str2;
    Object localObject3;
    Object localObject4;
    if (localIterator.hasNext())
    {
      JsonNode localJsonNode2 = (JsonNode)localIterator.next();
      int i = JSONUtil.d(localJsonNode2.get("offset"));
      int j = JSONUtil.d(localJsonNode2.get("length"));
      str2 = JSONUtil.b(localJsonNode2.get("part"));
      int k = str1.offsetByCodePoints(0, i);
      localObject3 = str1.substring(k, str1.offsetByCodePoints(k, j));
      if (Objects.equal(str2, "first"))
      {
        Object localObject5 = localObject1;
        localObject4 = localObject3;
        localObject3 = localObject5;
      }
    }
    while (true)
    {
      localObject2 = localObject4;
      localObject1 = localObject3;
      break label80;
      if (Objects.equal(str2, "last"))
      {
        localObject4 = localObject2;
        continue;
        localName = new Name(localObject2, localObject1, str1);
        break;
      }
      localObject3 = localObject1;
      localObject4 = localObject2;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.graphql.ContactGraphQL
 * JD-Core Version:    0.6.0
 */