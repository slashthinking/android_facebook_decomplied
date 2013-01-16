package com.facebook.katana.service.vault.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public class VaultImageDeleteMethod
  implements ApiMethod<Long, Boolean>
{
  public ApiRequest a(Long paramLong)
  {
    ArrayList localArrayList = Lists.a();
    return new ApiRequest("vaultImageDelete", "DELETE", paramLong.toString(), localArrayList, ApiResponseType.STRING);
  }

  public Boolean a(Long paramLong, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf(paramApiResponse.b().equalsIgnoreCase("true"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultImageDeleteMethod
 * JD-Core Version:    0.6.0
 */