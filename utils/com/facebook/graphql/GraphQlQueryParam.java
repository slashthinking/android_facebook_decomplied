package com.facebook.graphql;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class GraphQlQueryParam
{
  private final String a;

  private GraphQlQueryParam(String paramString)
  {
    this.a = ((String)Preconditions.checkNotNull(paramString));
  }

  public static GraphQlQueryParam a(String paramString)
  {
    return new GraphQlQueryParam(paramString);
  }

  public String a()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GraphQlQueryParam));
    GraphQlQueryParam localGraphQlQueryParam;
    for (boolean bool = false; ; bool = Objects.equal(this.a, localGraphQlQueryParam.a))
    {
      return bool;
      localGraphQlQueryParam = (GraphQlQueryParam)paramObject;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a;
    return Objects.hashCode(arrayOfObject);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryParam
 * JD-Core Version:    0.6.2
 */