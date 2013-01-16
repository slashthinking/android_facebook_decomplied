package com.facebook.katana.service.vault.methods;

import com.facebook.common.util.Log;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import java.util.List;

public class VaultDeviceUpdateMethod
  implements ApiMethod<VaultDeviceUpdateParams, Boolean>
{
  public ApiRequest a(VaultDeviceUpdateParams paramVaultDeviceUpdateParams)
  {
    List localList = paramVaultDeviceUpdateParams.b();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(paramVaultDeviceUpdateParams.a());
    arrayOfObject[1] = localList.toString();
    Log.e(StringLocaleUtil.a("updating device id: %d, params: %s", arrayOfObject));
    return new ApiRequest("vaultDeviceUpdate", "POST", Long.toString(paramVaultDeviceUpdateParams.a()), localList, ApiResponseType.JSON);
  }

  public Boolean a(VaultDeviceUpdateParams paramVaultDeviceUpdateParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return Boolean.valueOf(true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultDeviceUpdateMethod
 * JD-Core Version:    0.6.0
 */