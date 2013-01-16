package com.facebook.katana.features;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchAppLoggedOutSettingsMethod
  implements ApiMethod<FetchAppLoggedOutSettingsMethod.Params, FetchAppLoggedOutSettingsMethod.Result>
{
  private FetchAppLoggedOutSettingsMethod.Result a;

  public final FetchAppLoggedOutSettingsMethod.Result a(FetchAppLoggedOutSettingsMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    if (paramApiResponse.a() == 200)
      this.a = ((FetchAppLoggedOutSettingsMethod.Result)paramApiResponse.d().readValueAs(FetchAppLoggedOutSettingsMethod.Result.class));
    return this.a;
  }

  public ApiRequest a(FetchAppLoggedOutSettingsMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("device_id", paramParams.a()));
    return new ApiRequest("AppLoggedOutSettings", "POST", "method/app.loggedoutsettings", localArrayList, ApiResponseType.JSONPARSER);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.FetchAppLoggedOutSettingsMethod
 * JD-Core Version:    0.6.0
 */