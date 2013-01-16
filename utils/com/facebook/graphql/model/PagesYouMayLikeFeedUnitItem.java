package com.facebook.graphql.model;

import android.text.Spannable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class PagesYouMayLikeFeedUnitItem
{
  private Spannable a;
  private ArrayNode b;
  private PagesYouMayLikeFeedUnit c;

  @JsonProperty("profile")
  public final GraphQLProfile page = null;

  @JsonProperty("social_context")
  public final GraphQLTextWithEntities socialContext = null;

  @JsonProperty("sponsored_data")
  public final FeedStorySponsoredData sponsoredData = null;

  @JsonProperty("tracking")
  public final String tracking = null;

  private void d()
  {
    if (this.b == null)
    {
      this.b = new ArrayNode(JsonNodeFactory.instance);
      this.b.add(this.tracking);
      if ((this.c != null) && (this.c.tracking != null))
        this.b.add(this.c.tracking);
    }
  }

  @JsonIgnore
  public ArrayNode a()
  {
    d();
    return this.b;
  }

  public void a(Spannable paramSpannable)
  {
    this.a = paramSpannable;
  }

  public void a(PagesYouMayLikeFeedUnit paramPagesYouMayLikeFeedUnit)
  {
    this.c = paramPagesYouMayLikeFeedUnit;
    d();
  }

  @JsonIgnore
  public Spannable b()
  {
    return this.a;
  }

  @JsonIgnore
  public boolean c()
  {
    if ((this.page == null) || (this.page.id == null) || (this.page.name == null) || (this.page.profilePicture == null) || (!this.page.profilePicture.a()) || (this.socialContext == null) || (this.socialContext.text == null));
    for (boolean bool = false; ; bool = true)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PagesYouMayLikeFeedUnitItem
 * JD-Core Version:    0.6.2
 */