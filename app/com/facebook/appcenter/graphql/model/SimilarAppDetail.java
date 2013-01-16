package com.facebook.appcenter.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.graphql.model.GraphQLImage;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SimilarAppDetail
  implements Parcelable
{

  @JsonProperty("banner_logo")
  public final List<GraphQLImage> bannerLogo = null;

  @JsonProperty("id")
  public final String id = "";

  @JsonProperty("name")
  public final String name = "";

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeList(this.bannerLogo);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.graphql.model.SimilarAppDetail
 * JD-Core Version:    0.6.0
 */