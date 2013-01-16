package com.facebook.orca.protocol.base;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Closeables;
import java.io.IOException;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class ApiResponse
{
  private final int a;
  private final ImmutableList<Header> b;
  private final String c;
  private final JsonNode d;
  private final JsonParser e;
  private final HttpEntity f;
  private final ApiResponseChecker g;

  public ApiResponse(int paramInt, List<Header> paramList, JsonParser paramJsonParser, ApiResponseChecker paramApiResponseChecker)
  {
    this.a = paramInt;
    this.b = ImmutableList.a(paramList);
    this.c = null;
    this.d = null;
    this.e = paramJsonParser;
    this.f = null;
    this.g = paramApiResponseChecker;
  }

  public ApiResponse(int paramInt, List<Header> paramList, JsonNode paramJsonNode, ApiResponseChecker paramApiResponseChecker)
  {
    this.a = paramInt;
    this.b = ImmutableList.a(paramList);
    this.c = null;
    this.d = paramJsonNode;
    this.e = null;
    this.f = null;
    this.g = paramApiResponseChecker;
  }

  public ApiResponse(int paramInt, List<Header> paramList, String paramString, ApiResponseChecker paramApiResponseChecker)
  {
    this.a = paramInt;
    this.b = ImmutableList.a(paramList);
    this.c = paramString;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = paramApiResponseChecker;
  }

  public ApiResponse(int paramInt, List<Header> paramList, HttpEntity paramHttpEntity, ApiResponseChecker paramApiResponseChecker)
  {
    this.a = paramInt;
    this.b = ImmutableList.a(paramList);
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = paramHttpEntity;
    this.g = paramApiResponseChecker;
  }

  public int a()
  {
    return this.a;
  }

  public String b()
  {
    if (this.c != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "No response body.");
      g();
      return this.c;
    }
  }

  public JsonNode c()
  {
    if (this.d != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "No response json node.");
      g();
      return this.d;
    }
  }

  public JsonParser d()
  {
    if (this.e != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "No response json pasrser.");
      return this.e;
    }
  }

  public Object e()
  {
    if (this.c != null);
    for (Object localObject = b(); ; localObject = c())
    {
      return localObject;
      if (this.d == null)
        break;
    }
    throw new IllegalStateException("No response json or body");
  }

  public void f()
  {
    if (this.f != null);
    try
    {
      this.f.consumeContent();
      label16: Closeables.a(this.e);
      return;
    }
    catch (IOException localIOException)
    {
      break label16;
    }
  }

  public void g()
  {
    if (this.d != null)
      this.g.a(this.d);
    while (true)
    {
      return;
      if (this.c != null)
        this.g.a(this.c);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ApiResponse
 * JD-Core Version:    0.6.2
 */