package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLBirthdate
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLBirthdate> CREATOR = new GraphQLBirthdate.1();

  @JsonProperty("day")
  public final int day;

  @JsonProperty("month")
  public final int month;

  @JsonProperty("year")
  public final int year;

  protected GraphQLBirthdate()
  {
    this.year = 0;
    this.month = 0;
    this.day = 0;
  }

  private GraphQLBirthdate(Parcel paramParcel)
  {
    this.year = paramParcel.readInt();
    this.month = paramParcel.readInt();
    this.day = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.year);
    paramParcel.writeInt(this.month);
    paramParcel.writeInt(this.day);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLBirthdate
 * JD-Core Version:    0.6.2
 */