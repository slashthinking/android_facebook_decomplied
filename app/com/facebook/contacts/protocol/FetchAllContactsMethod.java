package com.facebook.contacts.protocol;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.graphql.ContactGraphQL.QueryType;
import com.facebook.contacts.models.ContactSummaryBuilder;
import com.facebook.contacts.server.FetchAllContactsParams;
import com.facebook.contacts.server.FetchAllContactsResult;
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
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

public class FetchAllContactsMethod
  implements ApiMethod<FetchAllContactsParams, FetchAllContactsResult>
{
  private static final Class<?> a = FetchAllContactsMethod.class;
  private final ContactGraphQL b;

  @Inject
  public FetchAllContactsMethod(ContactGraphQL paramContactGraphQL)
  {
    this.b = paramContactGraphQL;
  }

  public FetchAllContactsResult a(FetchAllContactsParams paramFetchAllContactsParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode1 = paramApiResponse.c();
    JsonNode localJsonNode2 = localJsonNode1.get((String)localJsonNode1.fieldNames().next()).get("contacts");
    JsonNode localJsonNode3 = localJsonNode2.get("page_info");
    String str1 = JSONUtil.b(localJsonNode3.get("end_cursor"));
    boolean bool = JSONUtil.f(localJsonNode3.get("has_next_page"));
    String str2 = JSONUtil.b(localJsonNode3.get("delta_cursor"));
    JsonNode localJsonNode4 = localJsonNode2.get("nodes");
    ImmutableList.Builder localBuilder = ImmutableList.e();
    for (int i = 0; i < localJsonNode4.size(); i++)
    {
      JsonNode localJsonNode5 = localJsonNode4.get(i);
      localBuilder.b(this.b.a(localJsonNode5).q());
    }
    ImmutableList localImmutableList = localBuilder.b();
    BLog.b(a, "Got result: " + localImmutableList);
    return new FetchAllContactsResult(DataFreshnessResult.FROM_SERVER, localImmutableList, str1, bool, str2, System.currentTimeMillis());
  }

  public ApiRequest a(FetchAllContactsParams paramFetchAllContactsParams)
  {
    ArrayList localArrayList = Lists.a();
    if (!paramFetchAllContactsParams.c())
      throw new UnsupportedOperationException("Complete contact sync not implemented.");
    String str = this.b.a(paramFetchAllContactsParams.a(), paramFetchAllContactsParams.b(), ContactGraphQL.QueryType.FULL);
    BLog.b(a, "Sending query: " + str);
    localArrayList.add(new BasicNameValuePair("q", str));
    return new ApiRequest("fetchContacts", "GET", "graphql", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.FetchAllContactsMethod
 * JD-Core Version:    0.6.0
 */