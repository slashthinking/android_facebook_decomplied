package com.facebook.katana.service.vault.methods;

import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.Log;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

public class VaultGetSyncedImageStatusMethod
  implements ApiMethod<VaultGetSyncedImageStatusParams, VaultGetSyncedImageStatusResult>
{
  public VaultGetSyncedImageStatusResult a(VaultGetSyncedImageStatusParams paramVaultGetSyncedImageStatusParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return (VaultGetSyncedImageStatusResult)JMParser.a(new JsonFactory().createJsonParser(paramApiResponse.b()), VaultGetSyncedImageStatusResult.class);
  }

  public ApiRequest a(VaultGetSyncedImageStatusParams paramVaultGetSyncedImageStatusParams)
  {
    ArrayList localArrayList = Lists.a();
    JSONArray localJSONArray = new JSONArray(paramVaultGetSyncedImageStatusParams.b());
    localArrayList.add(new BasicNameValuePair("hashes", localJSONArray.toString()));
    localArrayList.add(new BasicNameValuePair("time_start", paramVaultGetSyncedImageStatusParams.c()));
    if (Log.a("vault", 2))
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramVaultGetSyncedImageStatusParams.c();
      arrayOfObject2[1] = localJSONArray.toString();
      Log.d(StringLocaleUtil.a("Checking synced images since %s: %s", arrayOfObject2));
    }
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = paramVaultGetSyncedImageStatusParams.a();
    return new ApiRequest("vaultGetSyncedImageStatus", "GET", StringLocaleUtil.a("%s/vaultlocalimages", arrayOfObject1), localArrayList, ApiResponseType.STRING);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatusMethod
 * JD-Core Version:    0.6.0
 */