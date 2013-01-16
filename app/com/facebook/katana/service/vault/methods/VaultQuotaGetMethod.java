package com.facebook.katana.service.vault.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class VaultQuotaGetMethod
  implements ApiMethod<Void, VaultQuotaGetResult>
{
  public VaultQuotaGetResult a(Void paramVoid, ApiResponse paramApiResponse)
  {
    return new VaultQuotaGetResult(((JSONObject)((JSONArray)new JSONTokener(paramApiResponse.b()).nextValue()).get(0)).getJSONObject("vault_quota"));
  }

  public ApiRequest a(Void paramVoid)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("query", "SELECT vault_quota FROM user WHERE uid=me()"));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("vaultQuotaFQLGet", "GET", "method/fql.query", localArrayList, ApiResponseType.STRING);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultQuotaGetMethod
 * JD-Core Version:    0.6.0
 */