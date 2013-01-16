package com.facebook.katana.server.protocol;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;

public class AuthorizeAppMethod$Params$Builder
{
  private final String a;
  private final String b;
  private Optional<String> c;
  private Optional<String> d;
  private Optional<Boolean> e;

  public AuthorizeAppMethod$Params$Builder(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = Optional.absent();
    this.d = Optional.absent();
    this.e = Optional.absent();
  }

  public Builder a(Iterable<String> paramIterable)
  {
    this.c = Optional.fromNullable(Joiner.on(",").join(paramIterable));
    return this;
  }

  public Builder a(String paramString)
  {
    this.d = Optional.fromNullable(paramString);
    return this;
  }

  public Builder a(boolean paramBoolean)
  {
    this.e = Optional.of(Boolean.valueOf(paramBoolean));
    return this;
  }

  public AuthorizeAppMethod.Params a()
  {
    return new AuthorizeAppMethod.Params(this.a, this.b, this.c, this.d, this.e, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.AuthorizeAppMethod.Params.Builder
 * JD-Core Version:    0.6.0
 */