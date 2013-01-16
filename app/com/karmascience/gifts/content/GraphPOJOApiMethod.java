package com.karmascience.gifts.content;

import com.facebook.common.util.Log;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.karmascience.gifts.ThreadingService;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public abstract class GraphPOJOApiMethod<T>
  implements ApiMethod<String, Object>
{
  private final ThreadingService a;
  private final String b;
  private final int c;
  private final GraphQLHelper d = new GraphQLHelper(new ObjectMapper());
  private final Class<T> e;
  private final List<NameValuePair> f;
  private final String g;
  private final String h;

  public GraphPOJOApiMethod(String paramString, ThreadingService paramThreadingService, int paramInt, Class<T> paramClass)
  {
    this(paramString, paramThreadingService, paramInt, paramClass, null, null);
  }

  public GraphPOJOApiMethod(String paramString1, ThreadingService paramThreadingService, int paramInt, Class<T> paramClass, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.a = paramThreadingService;
    this.c = paramInt;
    this.e = paramClass;
    this.g = paramString2;
    this.h = paramString3;
    this.f = Lists.a();
  }

  public final ApiRequest a(String paramString)
  {
    if (this.h == null);
    for (ApiRequest localApiRequest = this.d.a(this.b, paramString); ; localApiRequest = new ApiRequest(this.b, this.g, this.h, this.f, ApiResponseType.JSONPARSER))
    {
      return localApiRequest;
      if (paramString == null)
        continue;
      this.f.add(new BasicNameValuePair("q", paramString));
    }
  }

  public final Object a(String paramString, ApiResponse paramApiResponse)
  {
    if (paramApiResponse.a() == 200);
    while (true)
    {
      try
      {
        Object localObject = this.d.a(this.b, this.c, paramApiResponse.d()).readValueAs(this.e);
        this.a.a(new GraphPOJOApiMethod.1(this, localObject));
        return null;
      }
      catch (Exception localException)
      {
        Log.b("Can't parse POJO", localException);
        this.a.a(new GraphPOJOApiMethod.2(this, paramApiResponse));
        continue;
      }
      this.a.a(new GraphPOJOApiMethod.3(this, paramApiResponse));
    }
  }

  protected final void a(int paramInt, String paramString)
  {
    this.a.a(new GraphPOJOApiMethod.4(this, paramInt, paramString));
  }

  protected void a(String paramString1, String paramString2)
  {
    this.f.add(new BasicNameValuePair(paramString1, paramString2));
  }

  public abstract void b(int paramInt, String paramString);

  public abstract void b(T paramT);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.GraphPOJOApiMethod
 * JD-Core Version:    0.6.0
 */