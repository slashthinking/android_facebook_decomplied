package com.facebook.katana.service.vault.methods;

import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.Log;
import com.facebook.katana.model.FacebookVaultDevice;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class VaultDeviceGetMethod
  implements ApiMethod<VaultDeviceGetParams, FacebookVaultDevice>
{
  public FacebookVaultDevice a(VaultDeviceGetParams paramVaultDeviceGetParams, ApiResponse paramApiResponse)
  {
    VaultDeviceGetResult localVaultDeviceGetResult = (VaultDeviceGetResult)JMParser.a(new JsonFactory().createJsonParser(paramApiResponse.b()), VaultDeviceGetResult.class);
    if ((localVaultDeviceGetResult != null) && (localVaultDeviceGetResult.data.size() > 0));
    for (FacebookVaultDevice localFacebookVaultDevice = (FacebookVaultDevice)localVaultDeviceGetResult.data.get(0); ; localFacebookVaultDevice = null)
      return localFacebookVaultDevice;
  }

  public ApiRequest a(VaultDeviceGetParams paramVaultDeviceGetParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("identifier_value", paramVaultDeviceGetParams.a()));
    Log.e("vault device GET: " + localArrayList.toString());
    return new ApiRequest("vaultDeviceGet", "GET", "me/vaultdevices", localArrayList, ApiResponseType.STRING);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultDeviceGetMethod
 * JD-Core Version:    0.6.0
 */