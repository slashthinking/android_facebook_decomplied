package com.facebook.orca.protocol.methods;

import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.appconfig.AppConfig;
import com.facebook.orca.appconfig.AppConfigSerialization;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchAppConfigMethod
  implements ApiMethod<Void, AppConfig>
{
  private final OrcaAppType a;
  private final AppConfigSerialization b;

  public FetchAppConfigMethod(OrcaAppType paramOrcaAppType, AppConfigSerialization paramAppConfigSerialization)
  {
    this.a = paramOrcaAppType;
    this.b = paramAppConfigSerialization;
  }

  public AppConfig a(Void paramVoid, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode1 = new FqlResultHelper(paramApiResponse.c()).a("info");
    if ((localJsonNode1 == null) || (localJsonNode1.size() != 1))
      throw new Exception("Invalid api response - missing row");
    JsonNode localJsonNode2 = localJsonNode1.get(0);
    boolean bool1 = JSONUtil.a(localJsonNode2.get("client_config"));
    AppConfig localAppConfig = null;
    if (!bool1);
    while (true)
    {
      return localAppConfig;
      boolean bool2 = localJsonNode2.has("client_config");
      localAppConfig = null;
      if (!bool2)
        continue;
      boolean bool3 = localJsonNode2.get("client_config").isObject();
      localAppConfig = null;
      if (!bool3)
        continue;
      JsonNode localJsonNode3 = localJsonNode2.get("client_config");
      localAppConfig = this.b.a(localJsonNode3);
    }
  }

  public ApiRequest a(Void paramVoid)
  {
    FqlMultiQueryHelper localFqlMultiQueryHelper = new FqlMultiQueryHelper();
    localFqlMultiQueryHelper.a("info", "SELECT client_config FROM application WHERE app_id='" + this.a.b() + "'");
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("queries", localFqlMultiQueryHelper.a().toString()));
    return new ApiRequest("fetchAppInfo", "GET", "method/fql.multiquery", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchAppConfigMethod
 * JD-Core Version:    0.6.0
 */