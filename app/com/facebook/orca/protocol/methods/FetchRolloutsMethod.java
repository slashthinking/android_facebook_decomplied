package com.facebook.orca.protocol.methods;

import android.os.Bundle;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.rollout.OrcaRolloutManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchRolloutsMethod
  implements ApiMethod<Void, Bundle>
{
  private final OrcaRolloutManager a;

  public FetchRolloutsMethod(OrcaRolloutManager paramOrcaRolloutManager)
  {
    this.a = paramOrcaRolloutManager;
  }

  public Bundle a(Void paramVoid, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode1 = new FqlResultHelper(paramApiResponse.c()).a("rollouts");
    Bundle localBundle = new Bundle();
    for (int i = 0; i < localJsonNode1.size(); i++)
    {
      JsonNode localJsonNode2 = localJsonNode1.get(i);
      localBundle.putString(JSONUtil.b(localJsonNode2.get("experiment")), JSONUtil.b(localJsonNode2.get("condition")));
    }
    return localBundle;
  }

  public ApiRequest a(Void paramVoid)
  {
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    localFqlMultiQueryHelper.a("rollouts", "SELECT experiment, condition FROM rollout WHERE experiment IN " + SqlUtil.b(this.a.a()));
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("queries", localFqlMultiQueryHelper.a().toString()));
    return new ApiRequest("fetchRollouts", "GET", "method/fql.multiquery", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchRolloutsMethod
 * JD-Core Version:    0.6.0
 */