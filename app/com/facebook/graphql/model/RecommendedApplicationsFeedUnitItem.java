package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class RecommendedApplicationsFeedUnitItem
  implements Parcelable
{

  @JsonIgnore
  private ArrayNode a;

  @JsonProperty("profile")
  public final PlatformApplication application = null;

  @JsonProperty("banner")
  public final GraphQLImage banner = null;

  @JsonProperty("body")
  public final GraphQLTextWithEntities body = null;

  @JsonProperty("icon")
  public final GraphQLImage icon = null;

  @JsonProperty("sponsored_data")
  public final FeedStorySponsoredData sponsoredData = null;

  @JsonProperty("tracking")
  public final String tracking = null;

  private void b()
  {
    if (this.a == null)
    {
      this.a = new ArrayNode(JsonNodeFactory.instance);
      this.a.add(this.tracking);
    }
  }

  @JsonIgnore
  public ArrayNode a()
  {
    b();
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.RecommendedApplicationsFeedUnitItem
 * JD-Core Version:    0.6.0
 */