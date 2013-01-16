package com.facebook.analytics;

import android.util.Base64;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EncodingUtils;

public class SendAnalyticLogsMethod
  implements ApiMethod<String, Boolean>
{
  protected static String b(String paramString)
  {
    byte[] arrayOfByte = EncodingUtils.getBytes(paramString, "UTF-8");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    localDeflaterOutputStream.write(arrayOfByte);
    localDeflaterOutputStream.close();
    return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
  }

  public ApiRequest a(String paramString)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("message", b(paramString)));
    localArrayList.add(new BasicNameValuePair("compressed", "1"));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("sendAnaliyticsLog", "POST", "method/logging.mobilelogs", localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(String paramString, ApiResponse paramApiResponse)
  {
    boolean bool = true;
    if (paramApiResponse.c().booleanValue() == bool);
    while (true)
    {
      return Boolean.valueOf(bool);
      bool = false;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.SendAnalyticLogsMethod
 * JD-Core Version:    0.6.2
 */