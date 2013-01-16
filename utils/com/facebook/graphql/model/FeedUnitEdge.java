package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class FeedUnitEdge
  implements Dedupable, FeedEdge
{

  @JsonIgnore
  private boolean a = true;

  @JsonProperty("deduplication_key")
  public final String dedupKey;

  @JsonProperty("sort_key")
  public final String sortKey;

  @JsonProperty("node")
  public final FeedUnit story;

  public FeedUnitEdge()
  {
    this.story = null;
    this.dedupKey = null;
    this.sortKey = null;
  }

  public FeedUnitEdge(FeedUnit paramFeedUnit, String paramString1, String paramString2)
  {
    this.story = paramFeedUnit;
    this.dedupKey = paramString1;
    this.sortKey = paramString2;
  }

  public String a()
  {
    if ((this.dedupKey == null) && ((this.story instanceof FeedStory)));
    for (String str = this.sortKey; ; str = this.dedupKey)
      return str;
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public FeedUnit b()
  {
    return this.story;
  }

  public String c()
  {
    return this.sortKey;
  }

  public boolean d()
  {
    return this.a;
  }

  @JsonIgnore
  public String e()
  {
    if ((this.story instanceof FeedStory));
    for (String str = ((FeedStory)this.story).cacheId; ; str = this.dedupKey)
      return str;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FeedUnitEdge));
    FeedUnitEdge localFeedUnitEdge;
    for (boolean bool = false; ; bool = Objects.equal(a(), localFeedUnitEdge.a()))
    {
      return bool;
      localFeedUnitEdge = (FeedUnitEdge)paramObject;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.dedupKey;
    return Objects.hashCode(arrayOfObject);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedUnitEdge
 * JD-Core Version:    0.6.2
 */