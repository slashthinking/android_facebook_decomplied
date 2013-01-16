package com.facebook.orca.protocol.methods;

import android.os.Bundle;
import com.facebook.base.GatekeeperSetProvider;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.FetchGatekeepersParams;
import com.facebook.orca.server.FetchGatekeepersParams.Session;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;

public class FetchGatekeepersMethod
  implements ApiMethod<FetchGatekeepersParams, Bundle>
{
  private ImmutableSet<String> a = a(paramSet);

  public FetchGatekeepersMethod(Set<GatekeeperSetProvider> paramSet)
  {
  }

  private ImmutableSet<String> a(Set<GatekeeperSetProvider> paramSet)
  {
    Preconditions.checkNotNull(paramSet);
    ImmutableSet.Builder localBuilder = ImmutableSet.e();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
      localBuilder.b(((GatekeeperSetProvider)localIterator.next()).a());
    return localBuilder.b();
  }

  public Bundle a(FetchGatekeepersParams paramFetchGatekeepersParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode1 = new FqlResultHelper(paramApiResponse.c()).a("gk");
    Bundle localBundle = new Bundle();
    for (int i = 0; i < localJsonNode1.size(); i++)
    {
      JsonNode localJsonNode2 = localJsonNode1.get(i);
      localBundle.putBoolean(JSONUtil.b(localJsonNode2.get("project_name")), localJsonNode2.get("result").booleanValue());
    }
    return localBundle;
  }

  public ApiRequest a(FetchGatekeepersParams paramFetchGatekeepersParams)
  {
    ImmutableSet localImmutableSet1 = this.a;
    int i;
    ImmutableSet localImmutableSet2;
    if (paramFetchGatekeepersParams != null)
    {
      ImmutableSet localImmutableSet3 = a(ImmutableSet.b(paramFetchGatekeepersParams.a));
      FetchGatekeepersParams.Session localSession1 = paramFetchGatekeepersParams.b;
      FetchGatekeepersParams.Session localSession2 = FetchGatekeepersParams.Session.IS_SESSIONLESS;
      int j = 0;
      if (localSession1 == localSession2)
        j = 1;
      i = j;
      localImmutableSet2 = localImmutableSet3;
    }
    while (true)
    {
      FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
      localFqlMultiQueryHelper.a("gk", "SELECT project_name, result FROM project_gating WHERE project_name IN " + SqlUtil.b(localImmutableSet2));
      ArrayList localArrayList = Lists.a();
      localArrayList.add(new BasicNameValuePair("format", "json"));
      localArrayList.add(new BasicNameValuePair("queries", localFqlMultiQueryHelper.a().toString()));
      String str1;
      if (i != 0)
      {
        str1 = "fetchSessionlessAppInfo";
        if (i == 0)
          break label184;
      }
      label184: for (String str2 = "POST"; ; str2 = "GET")
      {
        return new ApiRequest(str1, str2, "method/fql.multiquery", localArrayList, ApiResponseType.JSON);
        str1 = "fetchAppInfo";
        break;
      }
      localImmutableSet2 = localImmutableSet1;
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchGatekeepersMethod
 * JD-Core Version:    0.6.0
 */