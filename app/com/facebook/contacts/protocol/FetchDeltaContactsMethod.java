package com.facebook.contacts.protocol;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.graphql.ContactGraphQL.QueryType;
import com.facebook.contacts.models.ContactSummaryBuilder;
import com.facebook.contacts.server.FetchDeltaContactsParams;
import com.facebook.contacts.server.FetchDeltaContactsResult;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchDeltaContactsMethod
  implements ApiMethod<FetchDeltaContactsParams, FetchDeltaContactsResult>
{
  private static final Class<?> a = FetchDeltaContactsMethod.class;
  private final ContactGraphQL b;

  public FetchDeltaContactsMethod(ContactGraphQL paramContactGraphQL)
  {
    this.b = paramContactGraphQL;
  }

  public FetchDeltaContactsResult a(FetchDeltaContactsParams paramFetchDeltaContactsParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode1 = paramApiResponse.c();
    JsonNode localJsonNode2 = localJsonNode1.get((String)localJsonNode1.fieldNames().next()).get("contacts");
    ImmutableList.Builder localBuilder1 = ImmutableList.e();
    ImmutableList.Builder localBuilder2 = ImmutableList.e();
    JsonNode localJsonNode3 = localJsonNode2.get("deltas");
    Iterator localIterator = localJsonNode3.get("nodes").iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode5 = (JsonNode)localIterator.next();
      JsonNode localJsonNode6 = localJsonNode5.get("added");
      JsonNode localJsonNode7 = localJsonNode5.get("removed");
      if ((localJsonNode6 != null) && (!localJsonNode6.isNull()))
      {
        BLog.b(a, "Deserializing node: " + localJsonNode6);
        localBuilder1.b(this.b.a(localJsonNode6).q());
        continue;
      }
      if ((localJsonNode7 == null) || (localJsonNode7.isNull()))
        continue;
      localBuilder2.b(JSONUtil.b(localJsonNode7));
    }
    ImmutableList localImmutableList1 = localBuilder1.b();
    ImmutableList localImmutableList2 = localBuilder2.b();
    JsonNode localJsonNode4 = localJsonNode3.get("page_info");
    String str = JSONUtil.b(localJsonNode4.get("end_cursor"));
    boolean bool = JSONUtil.f(localJsonNode4.get("has_next_page"));
    BLog.b(a, "Got added contacts: " + localImmutableList1);
    BLog.b(a, "Got removed contact Ids: " + localImmutableList2);
    return new FetchDeltaContactsResult(DataFreshnessResult.FROM_SERVER, localImmutableList1, localImmutableList2, str, bool, System.currentTimeMillis());
  }

  public ApiRequest a(FetchDeltaContactsParams paramFetchDeltaContactsParams)
  {
    ArrayList localArrayList = Lists.a();
    String str = this.b.a(paramFetchDeltaContactsParams.a(), paramFetchDeltaContactsParams.b(), ContactGraphQL.QueryType.DELTA);
    BLog.b(a, "Sending query: " + str);
    localArrayList.add(new BasicNameValuePair("q", str));
    return new ApiRequest("fetchContactsDelta", "GET", "graphql", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.FetchDeltaContactsMethod
 * JD-Core Version:    0.6.0
 */