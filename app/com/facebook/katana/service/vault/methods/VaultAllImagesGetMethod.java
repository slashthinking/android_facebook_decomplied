package com.facebook.katana.service.vault.methods;

import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class VaultAllImagesGetMethod
  implements ApiMethod<VaultAllImagesGetParams, VaultAllImagesGetResult>
{
  public VaultAllImagesGetResult a(VaultAllImagesGetParams paramVaultAllImagesGetParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return (VaultAllImagesGetResult)JMParser.a(new JsonFactory().createJsonParser(paramApiResponse.b()), VaultAllImagesGetResult.class);
  }

  public ApiRequest a(VaultAllImagesGetParams paramVaultAllImagesGetParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("limit", Integer.toString(paramVaultAllImagesGetParams.b())));
    localArrayList.add(new BasicNameValuePair("after", paramVaultAllImagesGetParams.a()));
    return new ApiRequest("vaultGetSyncedImageStatus", "GET", "me/vaultimages", localArrayList, ApiResponseType.STRING);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultAllImagesGetMethod
 * JD-Core Version:    0.6.0
 */