package com.facebook.orca.protocol.base;

import com.facebook.orca.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.client.HttpResponseException;
import org.apache.http.message.BasicHeader;

public class CustomResponseHandlerForBatch
{
  private final ApiResponseChecker a;
  private int b;
  private List<Header> c;

  public CustomResponseHandlerForBatch(ApiResponseChecker paramApiResponseChecker)
  {
    this.a = paramApiResponseChecker;
  }

  private List<Header> b(JsonNode paramJsonNode)
  {
    ArrayList localArrayList = Lists.a();
    for (int i = 0; i < paramJsonNode.size(); i++)
    {
      JsonNode localJsonNode = paramJsonNode.get(i);
      localArrayList.add(new BasicHeader(JSONUtil.b(localJsonNode.get("name")), JSONUtil.b(localJsonNode.get("value"))));
    }
    return localArrayList;
  }

  public String a(JsonNode paramJsonNode)
  {
    this.c = b(paramJsonNode.get("headers"));
    this.b = JSONUtil.d(paramJsonNode.get("code"));
    String str = JSONUtil.b(paramJsonNode.get("body"));
    if (this.b >= 300)
    {
      if (this.b == 400)
        this.a.a(str);
      throw new HttpResponseException(this.b, null);
    }
    return str;
  }

  public List<Header> a()
  {
    return this.c;
  }

  public int b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.CustomResponseHandlerForBatch
 * JD-Core Version:    0.6.2
 */