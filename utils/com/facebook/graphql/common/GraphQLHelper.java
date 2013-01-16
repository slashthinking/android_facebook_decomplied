package com.facebook.graphql.common;

import com.facebook.graphql.model.GraphQLError;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class GraphQLHelper
{
  private final ObjectMapper a;

  public GraphQLHelper(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  public ApiRequest a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, ApiResponseType.JSONPARSER);
  }

  public ApiRequest a(String paramString1, String paramString2, ApiResponseType paramApiResponseType)
  {
    Tracer localTracer = Tracer.a(paramString1 + ".getApiRequest");
    try
    {
      ArrayList localArrayList = Lists.a();
      localArrayList.add(new BasicNameValuePair("q", paramString2));
      localArrayList.add(new BasicNameValuePair("method", "get"));
      ApiRequest localApiRequest = new ApiRequest(paramString1, "POST", "graphql", localArrayList, paramApiResponseType);
      return localApiRequest;
    }
    finally
    {
      localTracer.a();
    }
  }

  public JsonParser a(String paramString, int paramInt, JsonParser paramJsonParser)
  {
    Tracer localTracer = Tracer.a(paramString + ".getResponse");
    try
    {
      localJsonToken = paramJsonParser.nextToken();
      if (paramInt <= 0)
        break label126;
      if ((paramJsonParser.nextToken() == JsonToken.FIELD_NAME) && (paramJsonParser.getText().equals("error")))
        throw new GraphQLException((GraphQLError)this.a.readValue(paramJsonParser, GraphQLError.class));
    }
    finally
    {
      localTracer.a();
    }
    JsonToken localJsonToken = paramJsonParser.nextToken();
    for (int i = paramInt - 1; i > 0; i--)
    {
      paramJsonParser.nextToken();
      localJsonToken = paramJsonParser.nextToken();
    }
    label126: if ((localJsonToken != JsonToken.VALUE_NULL) && (localJsonToken != JsonToken.START_OBJECT) && (localJsonToken != JsonToken.START_ARRAY))
      throw new Exception("Unexpected json token");
    localTracer.a();
    return paramJsonParser;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.common.GraphQLHelper
 * JD-Core Version:    0.6.2
 */