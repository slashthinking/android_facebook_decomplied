package com.facebook.orca.protocol.base;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ApiResponseChecker
{
  private final ObjectMapper a;

  public ApiResponseChecker(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  private static void b(JsonNode paramJsonNode)
  {
    if (paramJsonNode == null);
    label283: 
    while (true)
    {
      return;
      ApiErrorResult localApiErrorResult;
      if (paramJsonNode.isObject())
        if (paramJsonNode.has("error_code"))
          localApiErrorResult = new ApiErrorResult(JSONUtil.d(paramJsonNode.path("error_code")), JSONUtil.b(paramJsonNode.path("error_msg")), JSONUtil.b(paramJsonNode.path("error_data")), ApiErrorResult.ErrorDomain.API_EC_DOMAIN);
      while (true)
      {
        if (localApiErrorResult == null)
          break label283;
        throw new ApiException(localApiErrorResult);
        if ((paramJsonNode.has("error")) && (paramJsonNode.path("error").isInt()))
        {
          localApiErrorResult = new ApiErrorResult(JSONUtil.d(paramJsonNode.path("error")), JSONUtil.b(paramJsonNode.path("error_description")), null, ApiErrorResult.ErrorDomain.API_EC_DOMAIN);
        }
        else
        {
          if ((paramJsonNode.has("error")) && (paramJsonNode.path("error").isObject()))
          {
            JsonNode localJsonNode = paramJsonNode.path("error");
            if ((localJsonNode.has("code")) && (localJsonNode.has("description")))
            {
              localApiErrorResult = new ApiErrorResult(JSONUtil.d(localJsonNode.path("code")), JSONUtil.b(localJsonNode.path("description")), null, ApiErrorResult.ErrorDomain.GRAPHQL_KERROR_DOMAIN);
              continue;
            }
            if (localJsonNode.has("message"))
            {
              if (localJsonNode.has("code"));
              for (int i = JSONUtil.d(localJsonNode.path("code")); ; i = 0)
              {
                localApiErrorResult = new ApiErrorResult(i, JSONUtil.b(localJsonNode.path("message")), null, ApiErrorResult.ErrorDomain.API_EC_DOMAIN);
                break;
              }
              if (paramJsonNode.isArray())
                break;
              throw new JsonMappingException("Response was neither an array or a dictionary");
            }
          }
          localApiErrorResult = null;
        }
      }
    }
  }

  private void b(String paramString)
  {
    b(this.a.readTree(paramString));
  }

  public void a(JsonNode paramJsonNode)
  {
    if (paramJsonNode == null);
    while (true)
    {
      return;
      try
      {
        b(paramJsonNode);
      }
      catch (ApiException localApiException)
      {
        throw localApiException;
      }
      catch (JsonProcessingException localJsonProcessingException)
      {
      }
      catch (IOException localIOException)
      {
      }
    }
  }

  public void a(String paramString)
  {
    if (StringUtil.a(paramString));
    while (true)
    {
      return;
      try
      {
        b(paramString);
      }
      catch (ApiException localApiException)
      {
        throw localApiException;
      }
      catch (JsonProcessingException localJsonProcessingException)
      {
      }
      catch (IOException localIOException)
      {
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ApiResponseChecker
 * JD-Core Version:    0.6.2
 */