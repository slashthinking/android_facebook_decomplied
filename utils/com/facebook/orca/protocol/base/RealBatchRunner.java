package com.facebook.orca.protocol.base;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.apache.http.entity.mime.MultipartEntity;
import com.facebook.apache.http.entity.mime.content.StringBody;
import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.config.PlatformAppHttpConfig;
import com.facebook.orca.debug.BLog;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class RealBatchRunner extends BatchRunner
{
  private final Provider<PlatformAppHttpConfig> a;
  private final OrcaHttpRequestProcessor b;
  private final Provider<String> c;
  private final Provider<String> d;
  private final Provider<Boolean> e;
  private final Provider<Boolean> f;
  private final Provider<Boolean> g;
  private final JsonFactory h;
  private final ObjectMapper i;
  private final ApiResponseChecker j;
  private final ApiRequestUtils k;

  public RealBatchRunner(Provider<PlatformAppHttpConfig> paramProvider, OrcaHttpRequestProcessor paramOrcaHttpRequestProcessor, Provider<String> paramProvider1, Provider<String> paramProvider2, Provider<Boolean> paramProvider3, Provider<Boolean> paramProvider4, Provider<Boolean> paramProvider5, JsonFactory paramJsonFactory, ObjectMapper paramObjectMapper, ApiResponseChecker paramApiResponseChecker, ApiRequestUtils paramApiRequestUtils)
  {
    this.a = paramProvider;
    this.b = paramOrcaHttpRequestProcessor;
    this.c = paramProvider1;
    this.d = paramProvider2;
    this.e = paramProvider3;
    this.f = paramProvider4;
    this.g = paramProvider5;
    this.h = paramJsonFactory;
    this.i = paramObjectMapper;
    this.j = paramApiResponseChecker;
    this.k = paramApiRequestUtils;
  }

  private void a(JsonParser paramJsonParser)
  {
    if (paramJsonParser.getCurrentToken() != JsonToken.START_ARRAY)
    {
      JsonNode localJsonNode = (JsonNode)this.i.readTree(paramJsonParser);
      this.j.a(localJsonNode);
      throw new JsonMappingException("Batch request must return an array");
    }
  }

  public void b(String paramString)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    List localList1 = a();
    ArrayList localArrayList1 = Lists.a();
    ArrayList localArrayList2 = Lists.a();
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      BatchOperation localBatchOperation2 = (BatchOperation)localIterator1.next();
      ApiRequest localApiRequest2 = localBatchOperation2.a().a(localBatchOperation2.b());
      ObjectNode localObjectNode1 = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode1.put("method", localApiRequest2.b());
      List localList2 = this.k.a(localApiRequest2);
      if (((Boolean)this.e.b()).booleanValue())
      {
        localList2.add(new BasicNameValuePair("phprof_sample", "1"));
        String str14 = (String)this.c.b();
        if (str14 != null)
          localList2.add(new BasicNameValuePair("phprof_user", str14));
      }
      if (((Boolean)this.f.b()).booleanValue())
      {
        localList2.add(new BasicNameValuePair("teak_sample", "1"));
        String str13 = (String)this.c.b();
        if (str13 != null)
          localList2.add(new BasicNameValuePair("teak_user", str13));
      }
      if (((Boolean)this.g.b()).booleanValue())
      {
        localList2.add(new BasicNameValuePair("wirehog_sample", "1"));
        String str12 = (String)this.c.b();
        if (str12 != null)
          localList2.add(new BasicNameValuePair("wirehog_user", str12));
      }
      String str9 = localApiRequest2.c();
      if ("GET".equals(localApiRequest2.b()))
      {
        String str11 = URLEncodedUtils.format(localList2, "UTF-8");
        str9 = str9 + "?" + str11;
      }
      ObjectNode localObjectNode2;
      while (true)
      {
        if (localBatchOperation2.c() != null)
          localObjectNode1.put("name", localBatchOperation2.c());
        if (localBatchOperation2.d() != null)
          localObjectNode1.put("depends_on", localBatchOperation2.d());
        if (localApiRequest2.e() == null)
          break label639;
        localObjectNode2 = new ObjectNode(JsonNodeFactory.instance);
        Iterator localIterator3 = localApiRequest2.e().iterator();
        while (localIterator3.hasNext())
        {
          FormBodyPart localFormBodyPart2 = (FormBodyPart)localIterator3.next();
          localObjectNode2.put(localFormBodyPart2.a(), localFormBodyPart2.d());
          localArrayList1.add(localFormBodyPart2);
        }
        if ("POST".equals(localApiRequest2.b()))
        {
          localObjectNode1.put("body", URLEncodedUtils.format(localList2, "UTF-8"));
        }
        else
        {
          if (!"DELETE".equals(localApiRequest2.b()))
            break;
          String str10 = URLEncodedUtils.format(localList2, "UTF-8");
          str9 = str9 + "?" + str10;
        }
      }
      throw new Exception("Unsupported method: " + localApiRequest2.b());
      localObjectNode1.put("attached_files", localObjectNode2);
      label639: localObjectNode1.put("omit_response_on_success", false);
      localObjectNode1.put("relative_url", str9);
      localArrayNode.add(localObjectNode1);
      localArrayList2.add(localApiRequest2);
    }
    MultipartEntity localMultipartEntity = new MultipartEntity();
    localMultipartEntity.a("access_token", new StringBody((String)this.d.b()));
    String str1 = localArrayNode.toString();
    if (BLog.b(2))
      BLog.a("RealBatchRunner", "Request JSON: " + str1);
    localMultipartEntity.a("batch", new StringBody(str1, Charsets.UTF_8));
    Iterator localIterator2 = localArrayList1.iterator();
    while (localIterator2.hasNext())
    {
      FormBodyPart localFormBodyPart1 = (FormBodyPart)localIterator2.next();
      localMultipartEntity.a(localFormBodyPart1.a(), localFormBodyPart1.b());
    }
    PlatformAppHttpConfig localPlatformAppHttpConfig = (PlatformAppHttpConfig)this.a.b();
    Uri.Builder localBuilder = localPlatformAppHttpConfig.b();
    if (((Boolean)this.e.b()).booleanValue())
    {
      localBuilder.appendQueryParameter("phprof_sample", "1");
      String str8 = (String)this.c.b();
      if (str8 != null)
        localBuilder.appendQueryParameter("phprof_user", str8);
    }
    if (((Boolean)this.g.b()).booleanValue())
    {
      localBuilder.appendQueryParameter("wirehog_sample", "1");
      String str7 = (String)this.c.b();
      if (str7 != null)
        localBuilder.appendQueryParameter("wirehog_user", str7);
    }
    this.k.a(localBuilder);
    HttpPost localHttpPost = new HttpPost(localBuilder.build().toString());
    localHttpPost.setEntity(localMultipartEntity);
    String str2 = localPlatformAppHttpConfig.c();
    if (str2 != null)
      localHttpPost.addHeader("User-Agent", str2);
    String str3 = localPlatformAppHttpConfig.d();
    if (str3 != null)
      localHttpPost.addHeader("X-FB-Connection-Type", str3);
    HttpResponse localHttpResponse = this.b.a(paramString, localHttpPost);
    HttpEntity localHttpEntity = localHttpResponse.getEntity();
    while (true)
    {
      try
      {
        StatusLine localStatusLine = localHttpResponse.getStatusLine();
        int m = localStatusLine.getStatusCode();
        if (m <= 300)
          break;
        String str5 = localStatusLine.getReasonPhrase();
        if (localHttpEntity == null)
        {
          str6 = null;
          if (str6 != null)
            str5 = str5 + "\n" + str6;
          throw new HttpResponseException(m, str5);
        }
      }
      finally
      {
        localHttpEntity.consumeContent();
      }
      String str6 = EntityUtils.toString(localHttpEntity);
    }
    JsonParser localJsonParser1 = this.h.createJsonParser(localHttpEntity.getContent());
    localJsonParser1.nextToken();
    a(localJsonParser1);
    MappingIterator localMappingIterator = this.i.readValues(localJsonParser1, JsonNode.class);
    int n = 0;
    if (localMappingIterator.hasNextValue())
    {
      JsonNode localJsonNode = (JsonNode)localMappingIterator.nextValue();
      BatchOperation localBatchOperation1 = (BatchOperation)localList1.get(n);
      ApiMethod localApiMethod = localBatchOperation1.a();
      ApiRequest localApiRequest1 = (ApiRequest)localArrayList2.get(n);
      CustomResponseHandlerForBatch localCustomResponseHandlerForBatch = new CustomResponseHandlerForBatch(this.j);
      String str4 = localCustomResponseHandlerForBatch.a(localJsonNode);
      ApiResponse localApiResponse;
      if (localApiRequest1.f() == ApiResponseType.JSONPARSER)
      {
        JsonParser localJsonParser2 = this.h.createJsonParser(str4);
        localJsonParser2.setCodec(this.i);
        localApiResponse = new ApiResponse(localCustomResponseHandlerForBatch.b(), localCustomResponseHandlerForBatch.a(), localJsonParser2, this.j);
      }
      while (true)
      {
        Object localObject2 = localApiMethod.a(localBatchOperation1.b(), localApiResponse);
        a(localBatchOperation1.c(), localObject2);
        n++;
        break;
        if (localApiRequest1.f() == ApiResponseType.JSON)
        {
          localApiResponse = new ApiResponse(localCustomResponseHandlerForBatch.b(), localCustomResponseHandlerForBatch.a(), this.i.readTree(str4), this.j);
        }
        else
        {
          if (localApiRequest1.f() != ApiResponseType.STRING)
            break label1464;
          localApiResponse = new ApiResponse(localCustomResponseHandlerForBatch.b(), localCustomResponseHandlerForBatch.a(), str4, this.j);
        }
      }
      label1464: if (localApiRequest1.f() == ApiResponseType.ENTITY)
        throw new IllegalArgumentException("Response type entity not supported for batch requests");
      throw new IllegalArgumentException("Unknown api response type");
    }
    if (n != localList1.size())
      throw new Exception("Received wrong number of batches in response");
    localHttpEntity.consumeContent();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.RealBatchRunner
 * JD-Core Version:    0.6.2
 */