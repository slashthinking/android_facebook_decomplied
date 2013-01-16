package com.facebook.orca.protocol.base;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.apache.http.entity.mime.MultipartEntity;
import com.facebook.apache.http.entity.mime.content.StringBody;
import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.common.util.SecureHashUtil;
import com.facebook.orca.config.PlatformAppConfig;
import com.facebook.orca.config.PlatformAppHttpConfig;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;

public class SingleMethodRunner
  implements ISingleMethodRunner
{
  private final Provider<PlatformAppHttpConfig> a;
  private final PlatformAppHttpConfig b;
  private final OrcaHttpRequestProcessor c;
  private final Provider<String> d;
  private final Provider<String> e;
  private final Provider<Boolean> f;
  private final Provider<Boolean> g;
  private final Provider<Boolean> h;
  private final PlatformAppConfig i;
  private final JsonFactory j;
  private final ObjectMapper k;
  private final ApiResponseChecker l;
  private final ApiRequestUtils m;

  public SingleMethodRunner(Provider<PlatformAppHttpConfig> paramProvider, PlatformAppHttpConfig paramPlatformAppHttpConfig, OrcaHttpRequestProcessor paramOrcaHttpRequestProcessor, Provider<String> paramProvider1, Provider<String> paramProvider2, Provider<Boolean> paramProvider3, Provider<Boolean> paramProvider4, Provider<Boolean> paramProvider5, PlatformAppConfig paramPlatformAppConfig, JsonFactory paramJsonFactory, ObjectMapper paramObjectMapper, ApiResponseChecker paramApiResponseChecker, ApiRequestUtils paramApiRequestUtils)
  {
    this.a = paramProvider;
    this.b = paramPlatformAppHttpConfig;
    this.c = paramOrcaHttpRequestProcessor;
    this.d = paramProvider1;
    this.e = paramProvider2;
    this.f = paramProvider3;
    this.g = paramProvider4;
    this.h = paramProvider5;
    this.i = paramPlatformAppConfig;
    this.j = paramJsonFactory;
    this.k = paramObjectMapper;
    this.l = paramApiResponseChecker;
    this.m = paramApiRequestUtils;
  }

  private void a(List<NameValuePair> paramList)
  {
    paramList.add(new BasicNameValuePair("api_key", this.i.c()));
    Collections.sort(paramList, new SingleMethodRunner.1(this));
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
      localStringBuilder.append(localNameValuePair.getName());
      localStringBuilder.append("=");
      localStringBuilder.append(localNameValuePair.getValue());
    }
    localStringBuilder.append(this.i.d());
    paramList.add(new BasicNameValuePair("sig", SecureHashUtil.b(localStringBuilder.toString())));
  }

  private MultipartEntity b(ApiRequest paramApiRequest)
  {
    MultipartEntity localMultipartEntity = new MultipartEntity();
    String str1 = paramApiRequest.c();
    if (c(paramApiRequest))
    {
      String str2 = (String)this.e.b();
      if (str2 == null)
        throw new SingleMethodRunner.AuthTokenNullException("auth token is null, user logged out?");
      localMultipartEntity.a("access_token", new StringBody(str2));
    }
    ArrayList localArrayList = Lists.a(this.m.a(paramApiRequest));
    if (str1.startsWith("method/"))
      localArrayList.add(new BasicNameValuePair("method", str1.substring(7)));
    while (true)
    {
      if (d(paramApiRequest))
        a(localArrayList);
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)localIterator1.next();
        localMultipartEntity.a(localNameValuePair.getName(), new StringBody(localNameValuePair.getValue(), Charsets.UTF_8));
      }
      if ("DELETE".equals(paramApiRequest.b()))
        localArrayList.add(new BasicNameValuePair("method", "DELETE"));
    }
    List localList = paramApiRequest.e();
    if ((localList != null) && (!localList.isEmpty()))
    {
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        FormBodyPart localFormBodyPart = (FormBodyPart)localIterator2.next();
        localMultipartEntity.a(localFormBodyPart.a(), localFormBodyPart.b());
      }
    }
    return localMultipartEntity;
  }

  private boolean c(ApiRequest paramApiRequest)
  {
    String str = paramApiRequest.c();
    if ((!"method/auth.login".equalsIgnoreCase(str)) && (!"method/auth.getSessionForApp".equalsIgnoreCase(str)) && (!"method/logging.mobilelogs".equalsIgnoreCase(str)) && (!"method/mobile.sendPhoneConfirmationCode".equalsIgnoreCase(str)) && (!"method/user.validateRegistrationData".equalsIgnoreCase(str)) && (!"method/user.confirmPhoneAndRegisterPartialAccount".equalsIgnoreCase(str)) && (!"method/app.loggedoutsettings".equalsIgnoreCase(str)) && (!"fetchSessionlessAppInfo".equalsIgnoreCase(paramApiRequest.a())) && (!"lookupUser".equalsIgnoreCase(paramApiRequest.a())));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private boolean d(ApiRequest paramApiRequest)
  {
    String str = paramApiRequest.c();
    if (("method/auth.login".equalsIgnoreCase(str)) || ("method/logging.mobilelogs".equalsIgnoreCase(str)) || ("method/mobile.sendPhoneConfirmationCode".equalsIgnoreCase(str)) || ("method/user.validateRegistrationData".equalsIgnoreCase(str)) || ("method/user.confirmPhoneAndRegisterPartialAccount".equalsIgnoreCase(str)) || ("method/app.loggedoutsettings".equalsIgnoreCase(str)) || ("fetchSessionlessAppInfo".equalsIgnoreCase(paramApiRequest.a())) || ("lookupUser".equalsIgnoreCase(paramApiRequest.a())));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public ApiResponse a(ApiRequest paramApiRequest)
  {
    String str1 = paramApiRequest.c();
    boolean bool1 = "method/auth.login".equals(str1);
    boolean bool2 = "method/auth.getSessionForApp".equals(str1);
    PlatformAppHttpConfig localPlatformAppHttpConfig = (PlatformAppHttpConfig)this.a.b();
    Uri.Builder localBuilder;
    if ((bool1) || (bool2))
      localBuilder = this.b.a();
    String str5;
    while (true)
    {
      localBuilder.appendEncodedPath(str1);
      if (!d(paramApiRequest))
      {
        if (((Boolean)this.f.b()).booleanValue())
        {
          localBuilder.appendQueryParameter("phprof_sample", "1");
          String str8 = (String)this.d.b();
          if (str8 != null)
            localBuilder.appendQueryParameter("phprof_user", str8);
        }
        if (((Boolean)this.g.b()).booleanValue())
        {
          localBuilder.appendQueryParameter("teak_sample", "1");
          String str7 = (String)this.d.b();
          if (str7 != null)
            localBuilder.appendQueryParameter("teak_user", str7);
        }
        if (((Boolean)this.h.b()).booleanValue())
        {
          localBuilder.appendQueryParameter("wirehog_sample", "1");
          String str6 = (String)this.d.b();
          if (str6 != null)
            localBuilder.appendQueryParameter("wirehog_user", str6);
        }
      }
      if (!"GET".equals(paramApiRequest.b()))
        break label591;
      if (!c(paramApiRequest))
        break label342;
      str5 = (String)this.e.b();
      if (str5 != null)
        break;
      throw new SingleMethodRunner.AuthTokenNullException("auth token is null, user logged out?");
      if (str1.startsWith("method"))
        localBuilder = localPlatformAppHttpConfig.a();
      else
        localBuilder = localPlatformAppHttpConfig.b();
    }
    localBuilder.appendQueryParameter("access_token", str5);
    label342: ArrayList localArrayList = Lists.a(this.m.a(paramApiRequest));
    if (d(paramApiRequest))
      a(localArrayList);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
      localBuilder.appendQueryParameter(localNameValuePair.getName(), localNameValuePair.getValue());
    }
    Object localObject = new HttpGet(localBuilder.build().toString());
    String str2 = localPlatformAppHttpConfig.c();
    if (str2 != null)
      ((HttpUriRequest)localObject).addHeader("User-Agent", str2);
    String str3 = localPlatformAppHttpConfig.d();
    if (str3 != null)
      ((HttpUriRequest)localObject).addHeader("X-FB-Connection-Type", str3);
    ApiResponse localApiResponse;
    if (paramApiRequest.f() == ApiResponseType.JSONPARSER)
    {
      HttpResponse localHttpResponse4 = this.c.a(paramApiRequest.a(), (HttpUriRequest)localObject);
      HttpEntity localHttpEntity = localHttpResponse4.getEntity();
      JsonParser localJsonParser = this.j.createJsonParser(localHttpEntity.getContent());
      localJsonParser.setCodec(this.k);
      localApiResponse = new ApiResponse(localHttpResponse4.getStatusLine().getStatusCode(), Arrays.asList(localHttpResponse4.getAllHeaders()), localJsonParser, this.l);
    }
    while (true)
    {
      return localApiResponse;
      label591: if (("POST".equals(paramApiRequest.b())) || ("DELETE".equals(paramApiRequest.b())))
      {
        MultipartEntity localMultipartEntity = b(paramApiRequest);
        localObject = new HttpPost(localBuilder.build().toString());
        ((HttpPost)localObject).setEntity(localMultipartEntity);
        break;
      }
      throw new Exception("Unsupported method: " + paramApiRequest.b());
      if (paramApiRequest.f() == ApiResponseType.JSON)
      {
        JsonResponseHandler localJsonResponseHandler = new JsonResponseHandler(this.k, this.l);
        JsonNode localJsonNode = (JsonNode)this.c.a(paramApiRequest.a(), (HttpUriRequest)localObject, localJsonResponseHandler);
        HttpResponse localHttpResponse1 = localJsonResponseHandler.a();
        localApiResponse = new ApiResponse(localHttpResponse1.getStatusLine().getStatusCode(), Arrays.asList(localHttpResponse1.getAllHeaders()), localJsonNode, this.l);
      }
      else if (paramApiRequest.f() == ApiResponseType.STRING)
      {
        StringResponseHandler localStringResponseHandler = new StringResponseHandler(this.l);
        String str4 = (String)this.c.a(paramApiRequest.a(), (HttpUriRequest)localObject, localStringResponseHandler);
        HttpResponse localHttpResponse2 = localStringResponseHandler.a();
        localApiResponse = new ApiResponse(localHttpResponse2.getStatusLine().getStatusCode(), Arrays.asList(localHttpResponse2.getAllHeaders()), str4, this.l);
      }
      else
      {
        if (paramApiRequest.f() != ApiResponseType.ENTITY)
          break label935;
        HttpResponse localHttpResponse3 = this.c.a(paramApiRequest.a(), (HttpUriRequest)localObject);
        localApiResponse = new ApiResponse(localHttpResponse3.getStatusLine().getStatusCode(), Arrays.asList(localHttpResponse3.getAllHeaders()), localHttpResponse3.getEntity(), this.l);
      }
    }
    label935: throw new IllegalArgumentException("Unknown api response type");
  }

  public <PARAMS, RESULT> RESULT a(ApiMethod<PARAMS, RESULT> paramApiMethod, PARAMS paramPARAMS)
  {
    ApiResponse localApiResponse = a(paramApiMethod.a(paramPARAMS));
    try
    {
      Object localObject2 = paramApiMethod.a(paramPARAMS, localApiResponse);
      return localObject2;
    }
    finally
    {
      localApiResponse.f();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.SingleMethodRunner
 * JD-Core Version:    0.6.2
 */