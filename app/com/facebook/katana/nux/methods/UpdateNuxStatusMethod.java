package com.facebook.katana.nux.methods;

import com.facebook.katana.nux.model.NuxStepResult;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class UpdateNuxStatusMethod
  implements ApiMethod<Void, Boolean>
{
  private String a;
  private String b;

  public UpdateNuxStatusMethod(String paramString, NuxStepResult paramNuxStepResult)
  {
    this.a = paramString;
    this.b = paramNuxStepResult.name();
  }

  public ApiRequest a(Void paramVoid)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "JSON"));
    localArrayList.add(new BasicNameValuePair("step", this.a));
    localArrayList.add(new BasicNameValuePair("status", this.b));
    localArrayList.add(new BasicNameValuePair("nux_id", "ANDROID_NEW_ACCOUNT_WIZARD"));
    return new ApiRequest("updateNuxStatus", "GET", "method/user.updateNuxStatus", localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(Void paramVoid, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf(paramApiResponse.c().asBoolean(false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.methods.UpdateNuxStatusMethod
 * JD-Core Version:    0.6.0
 */