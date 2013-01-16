package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PageRecommendation
  implements Parcelable
{
  public static final Parcelable.Creator<PageRecommendation> CREATOR = new PageRecommendation.1();

  @JsonProperty("creation_time")
  public final long creationTime;

  @JsonProperty("creator")
  public final GraphQLProfile creator;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("page_rating")
  public final int pageRating;

  @JsonProperty("value")
  public final GraphQLTextWithEntities value;

  protected PageRecommendation()
  {
    this.id = null;
    this.creationTime = -1L;
    this.creator = null;
    this.value = null;
    this.pageRating = 0;
  }

  private PageRecommendation(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.creationTime = paramParcel.readLong();
    this.creator = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    this.value = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
    this.pageRating = paramParcel.readInt();
  }

  public PageRecommendation(String paramString, long paramLong, GraphQLProfile paramGraphQLProfile, GraphQLTextWithEntities paramGraphQLTextWithEntities, int paramInt)
  {
    this.id = paramString;
    this.creationTime = paramLong;
    this.creator = paramGraphQLProfile;
    this.value = paramGraphQLTextWithEntities;
    this.pageRating = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeLong(this.creationTime);
    paramParcel.writeParcelable(this.creator, paramInt);
    paramParcel.writeParcelable(this.value, paramInt);
    paramParcel.writeInt(this.pageRating);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PageRecommendation
 * JD-Core Version:    0.6.2
 */