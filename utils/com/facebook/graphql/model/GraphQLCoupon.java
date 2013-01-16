package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLCoupon
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLCoupon> CREATOR = new GraphQLCoupon.1();

  @JsonProperty("claim_count")
  public final int claimCount;

  @JsonProperty("expiration_date")
  public final long expirationDate;

  @JsonProperty("has_viewer_claimed")
  public boolean hasViewerClaimed;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("is_active")
  public final boolean isActive;

  @JsonProperty("is_expired")
  public final boolean isExpired;

  @JsonProperty("is_stopped")
  public final boolean isStopped;

  @JsonProperty("mobile_post_claim_message")
  public final String mobilePostClaimMessage;

  @JsonProperty("name")
  public final String name;

  @JsonProperty("owning_page")
  public final GraphQLProfile owningPage;

  @JsonProperty("__type__")
  public final GraphQLObjectType type;

  @JsonProperty("url")
  public final String url;

  protected GraphQLCoupon()
  {
    this.id = null;
    this.type = null;
    this.owningPage = null;
    this.url = null;
    this.isActive = false;
    this.hasViewerClaimed = false;
    this.name = null;
    this.isExpired = false;
    this.isStopped = false;
    this.claimCount = 0;
    this.expirationDate = 0L;
    this.mobilePostClaimMessage = null;
  }

  private GraphQLCoupon(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.type = ((GraphQLObjectType)paramParcel.readParcelable(GraphQLObjectType.class.getClassLoader()));
    this.owningPage = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    this.url = paramParcel.readString();
    boolean bool2;
    boolean bool3;
    label78: boolean bool4;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.isActive = bool2;
      if (paramParcel.readByte() == 0)
        break label150;
      bool3 = bool1;
      this.hasViewerClaimed = bool3;
      if (paramParcel.readByte() == 0)
        break label156;
      bool4 = bool1;
      label94: this.isExpired = bool4;
      if (paramParcel.readByte() == 0)
        break label162;
    }
    while (true)
    {
      this.isStopped = bool1;
      this.name = paramParcel.readString();
      this.claimCount = paramParcel.readInt();
      this.expirationDate = paramParcel.readLong();
      this.mobilePostClaimMessage = paramParcel.readString();
      return;
      bool2 = false;
      break;
      label150: bool3 = false;
      break label78;
      label156: bool4 = false;
      break label94;
      label162: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GraphQLCoupon));
    for (boolean bool = false; ; bool = this.id.equals(((GraphQLCoupon)paramObject).id))
      return bool;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.type, paramInt);
    paramParcel.writeParcelable(this.owningPage, paramInt);
    paramParcel.writeString(this.url);
    int j;
    int k;
    label63: int m;
    if (this.isActive)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.hasViewerClaimed)
        break label139;
      k = i;
      paramParcel.writeByte((byte)k);
      if (!this.isExpired)
        break label145;
      m = i;
      label80: paramParcel.writeByte((byte)m);
      if (!this.isStopped)
        break label151;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.name);
      paramParcel.writeInt(this.claimCount);
      paramParcel.writeLong(this.expirationDate);
      paramParcel.writeString(this.mobilePostClaimMessage);
      return;
      j = 0;
      break;
      label139: k = 0;
      break label63;
      label145: m = 0;
      break label80;
      label151: i = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLCoupon
 * JD-Core Version:    0.6.2
 */