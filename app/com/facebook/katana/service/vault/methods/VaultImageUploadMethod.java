package com.facebook.katana.service.vault.methods;

import android.content.Context;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.common.util.ErrorReporting;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.protocol.base.ProgressDataStreamBody;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class VaultImageUploadMethod
  implements ApiMethod<VaultImageUploadParams, VaultImageUploadResult>
{
  private final Context a;

  public VaultImageUploadMethod(Context paramContext)
  {
    this.a = paramContext;
  }

  public VaultImageUploadResult a(VaultImageUploadParams paramVaultImageUploadParams, ApiResponse paramApiResponse)
  {
    long l = JSONUtil.c(paramApiResponse.c().get("id"));
    if (l == 0L)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramApiResponse.e().toString();
      ErrorReporting.a("vault_image_upload_api missing id", StringLocaleUtil.a("missing id in response: %s", arrayOfObject));
    }
    return new VaultImageUploadResult(l);
  }

  public ApiRequest a(VaultImageUploadParams paramVaultImageUploadParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("client_image_hash", paramVaultImageUploadParams.b()));
    localArrayList.add(new BasicNameValuePair("date_taken", paramVaultImageUploadParams.f()));
    localArrayList.add(new BasicNameValuePair("device_oid", paramVaultImageUploadParams.c()));
    long l = paramVaultImageUploadParams.d();
    if (l > 0L)
      localArrayList.add(new BasicNameValuePair("existing_fbid", Long.toString(l)));
    File localFile = paramVaultImageUploadParams.a();
    FormBodyPart localFormBodyPart = new FormBodyPart("source", new ProgressDataStreamBody(localFile, "image/jpeg", localFile.getName(), paramVaultImageUploadParams.e()));
    return new ApiRequest("vaultImageUpload", "POST", "me/vaultimages", localArrayList, ApiResponseType.JSON, localFormBodyPart);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultImageUploadMethod
 * JD-Core Version:    0.6.0
 */