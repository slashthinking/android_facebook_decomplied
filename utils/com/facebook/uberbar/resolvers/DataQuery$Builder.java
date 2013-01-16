package com.facebook.uberbar.resolvers;

import android.net.Uri;
import com.google.common.collect.ImmutableList;

public class DataQuery$Builder
{
  private Uri a;
  private ImmutableList<String> b;
  private String c;
  private String d;

  public Uri a()
  {
    return this.a;
  }

  public Builder a(Uri paramUri)
  {
    this.a = paramUri;
    return this;
  }

  public Builder a(ImmutableList<String> paramImmutableList)
  {
    this.b = paramImmutableList;
    return this;
  }

  public Builder a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public Builder a(String[] paramArrayOfString)
  {
    this.b = ImmutableList.a(paramArrayOfString);
    return this;
  }

  public Builder b(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public ImmutableList<String> b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public DataQuery e()
  {
    return new DataQuery(this, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.resolvers.DataQuery.Builder
 * JD-Core Version:    0.6.2
 */