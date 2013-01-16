package com.facebook.orca.protocol.base;

import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.apache.http.NameValuePair;

public class ApiRequest
{
  private final String a;
  private final String b;
  private final String c;
  private final ImmutableList<NameValuePair> d;
  private final ApiResponseType e;
  private final List<FormBodyPart> f;

  public ApiRequest(String paramString1, String paramString2, String paramString3, List<NameValuePair> paramList, ApiResponseType paramApiResponseType)
  {
    this(paramString1, paramString2, paramString3, paramList, paramApiResponseType, (FormBodyPart)null);
  }

  public ApiRequest(String paramString1, String paramString2, String paramString3, List<NameValuePair> paramList, ApiResponseType paramApiResponseType, FormBodyPart paramFormBodyPart)
  {
  }

  public ApiRequest(String paramString1, String paramString2, String paramString3, List<NameValuePair> paramList, ApiResponseType paramApiResponseType, List<FormBodyPart> paramList1)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = ImmutableList.a(paramList);
    this.e = paramApiResponseType;
    this.f = paramList1;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public ImmutableList<NameValuePair> d()
  {
    return this.d;
  }

  public List<FormBodyPart> e()
  {
    if ((this.f == null) || (this.f.isEmpty()));
    for (Object localObject = null; ; localObject = this.f)
      return localObject;
  }

  public ApiResponseType f()
  {
    return this.e;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ApiRequest
 * JD-Core Version:    0.6.2
 */