package com.facebook.composer.protocol;

import com.facebook.composer.model.LinksPreview;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class LinksPreviewMethod
  implements ApiMethod<LinksPreviewParams, LinksPreview>
{
  public LinksPreview a(LinksPreviewParams paramLinksPreviewParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    JsonParser localJsonParser = paramApiResponse.c().traverse();
    ObjectMapper localObjectMapper = new ObjectMapper();
    localObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    localJsonParser.setCodec(localObjectMapper);
    return (LinksPreview)localJsonParser.readValueAs(LinksPreview.class);
  }

  public ApiRequest a(LinksPreviewParams paramLinksPreviewParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    if (paramLinksPreviewParams.b != null)
      localArrayList.add(new BasicNameValuePair("url", paramLinksPreviewParams.b));
    if (paramLinksPreviewParams.a != null)
      localArrayList.add(new BasicNameValuePair("id", paramLinksPreviewParams.a));
    return new ApiRequest("links.preview", "GET", "method/links.preview", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.LinksPreviewMethod
 * JD-Core Version:    0.6.2
 */