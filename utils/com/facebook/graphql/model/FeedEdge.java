package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract interface FeedEdge extends Dedupable
{
  @JsonIgnore
  public abstract void a(boolean paramBoolean);

  @JsonIgnore
  public abstract FeedUnit b();

  public abstract String c();

  @JsonIgnore
  public abstract boolean d();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedEdge
 * JD-Core Version:    0.6.2
 */