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

public class VaultDevicePostMethod
  implements ApiMethod<VaultDevicePostParams, FacebookVaultDevice>
{
  public FacebookVaultDevice a(VaultDevicePostParams paramVaultDevicePostParams, ApiResponse paramApiResponse)
  {
    return (FacebookVaultDevice)JMParser.a(new JsonFactory().createJsonParser(paramApiResponse.b()), FacebookVaultDevice.class);
  }

  public ApiRequest a(VaultDevicePostParams paramVaultDevicePostParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("identifier_value", paramVaultDevicePostParams.a()));
    localArrayList.add(new BasicNameValuePair("name", paramVaultDevicePostParams.b()));
    if (paramVaultDevicePostParams.c() != null)
      localArrayList.add(new BasicNameValuePair("enabled", Boolean.toString(paramVaultDevicePostParams.c().booleanValue())));
    if (paramVaultDevicePostParams.d() != null)
      localArrayList.add(new BasicNameValuePair("sync_mode", paramVaultDevicePostParams.d()));
    if (paramVaultDevicePostParams.e() != null)
      localArrayList.add(new BasicNameValuePair("sync_older_photos", Boolean.toString(paramVaultDevicePostParams.e().booleanValue())));
    Log.e("vault device post: " + localArrayList.toString());
    return new ApiRequest("vaultDeviceGet", "POST", "me/vaultdevices", localArrayList, ApiResponseType.STRING);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultDevicePostMethod
 * JD-Core Version:    0.6.0
 */