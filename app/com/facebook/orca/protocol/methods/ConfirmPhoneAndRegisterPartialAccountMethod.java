package com.facebook.orca.protocol.methods;

import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.ConfirmPhoneAndRegisterPartialAccountParams;
import com.facebook.orca.server.ConfirmPhoneAndRegisterPartialAccountResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class ConfirmPhoneAndRegisterPartialAccountMethod
  implements ApiMethod<ConfirmPhoneAndRegisterPartialAccountParams, ConfirmPhoneAndRegisterPartialAccountResult>
{
  private OrcaSharedPreferences a;

  public ConfirmPhoneAndRegisterPartialAccountMethod(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
  }

  public ApiRequest a(ConfirmPhoneAndRegisterPartialAccountParams paramConfirmPhoneAndRegisterPartialAccountParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("phone", paramConfirmPhoneAndRegisterPartialAccountParams.a()));
    if (paramConfirmPhoneAndRegisterPartialAccountParams.b() != null)
      localArrayList.add(new BasicNameValuePair("country_code", paramConfirmPhoneAndRegisterPartialAccountParams.b()));
    localArrayList.add(new BasicNameValuePair("code", paramConfirmPhoneAndRegisterPartialAccountParams.c()));
    localArrayList.add(new BasicNameValuePair("full_name", paramConfirmPhoneAndRegisterPartialAccountParams.d()));
    localArrayList.add(new BasicNameValuePair("first_name", paramConfirmPhoneAndRegisterPartialAccountParams.e()));
    localArrayList.add(new BasicNameValuePair("last_name", paramConfirmPhoneAndRegisterPartialAccountParams.f()));
    if (paramConfirmPhoneAndRegisterPartialAccountParams.g() != null)
      localArrayList.add(new BasicNameValuePair("machine_id", paramConfirmPhoneAndRegisterPartialAccountParams.g()));
    if (paramConfirmPhoneAndRegisterPartialAccountParams.h() != null)
      localArrayList.add(new BasicNameValuePair("generate_machine_id", paramConfirmPhoneAndRegisterPartialAccountParams.h()));
    localArrayList.add(new BasicNameValuePair("reg_instance", this.a.a(AuthPrefKeys.k, null)));
    return new ApiRequest("confirmPhoneAndRegisterPartialAccount", "POST", "method/user.confirmPhoneAndRegisterPartialAccount", localArrayList, ApiResponseType.JSON);
  }

  public ConfirmPhoneAndRegisterPartialAccountResult a(ConfirmPhoneAndRegisterPartialAccountParams paramConfirmPhoneAndRegisterPartialAccountParams, ApiResponse paramApiResponse)
  {
    JsonNode localJsonNode1 = paramApiResponse.c();
    String str1 = localJsonNode1.get("session_key").asText();
    int i = localJsonNode1.get("uid").asInt();
    String str2 = localJsonNode1.get("access_token").asText();
    if (localJsonNode1.has("machine_id"))
      localJsonNode1.get("machine_id").asText();
    boolean bool1 = localJsonNode1.has("confirmed");
    boolean bool2 = false;
    if (bool1)
    {
      JsonNode localJsonNode2 = localJsonNode1.get("confirmed");
      bool2 = false;
      if (localJsonNode2 != null)
        bool2 = localJsonNode1.get("confirmed").asBoolean(false);
    }
    return new ConfirmPhoneAndRegisterPartialAccountResult(DataFreshnessResult.FROM_SERVER, str1, i, str2, null, bool2, System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.ConfirmPhoneAndRegisterPartialAccountMethod
 * JD-Core Version:    0.6.0
 */