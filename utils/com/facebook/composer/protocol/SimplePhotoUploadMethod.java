package com.facebook.composer.protocol;

import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.protocol.base.DataStreamBody;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SimplePhotoUploadMethod
  implements ApiMethod<SimplePhotoUploadParams, String>
{
  public ApiRequest a(SimplePhotoUploadParams paramSimplePhotoUploadParams)
  {
    String str1 = paramSimplePhotoUploadParams.a();
    Long localLong = Long.valueOf(paramSimplePhotoUploadParams.c());
    boolean bool1;
    if (!StringUtil.a(str1))
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (localLong.longValue() == -1L)
        break label193;
    }
    label193: for (boolean bool2 = true; ; bool2 = false)
    {
      Preconditions.checkArgument(bool2);
      ArrayList localArrayList = Lists.a();
      String str2 = paramSimplePhotoUploadParams.b();
      if (!StringUtil.a(str2))
        localArrayList.add(new BasicNameValuePair("caption", str2));
      String str3 = paramSimplePhotoUploadParams.d();
      if (!StringUtil.a(str3))
        localArrayList.add(new BasicNameValuePair("access_token", str3));
      File localFile = new File(str1);
      FormBodyPart localFormBodyPart = new FormBodyPart("source", new DataStreamBody(localFile, "image/jpeg", localFile.getName()));
      return new ApiRequest("graphObjectPhoto", "POST", StringUtil.a("/%d/photos", new Object[] { localLong }), localArrayList, ApiResponseType.JSON, localFormBodyPart);
      bool1 = false;
      break;
    }
  }

  public String a(SimplePhotoUploadParams paramSimplePhotoUploadParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return paramApiResponse.c().get("id").asText();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.SimplePhotoUploadMethod
 * JD-Core Version:    0.6.2
 */