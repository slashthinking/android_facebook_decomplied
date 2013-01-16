package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLBaseRange
  implements Parcelable, Comparable<GraphQLBaseRange>
{
  public static final Parcelable.Creator<GraphQLBaseRange> CREATOR = new GraphQLBaseRange.1();

  @JsonProperty("length")
  public final int length;

  @JsonProperty("offset")
  public final int offset;

  protected GraphQLBaseRange()
  {
    this.offset = 0;
    this.length = 0;
  }

  public GraphQLBaseRange(int paramInt1, int paramInt2)
  {
    this.offset = paramInt1;
    this.length = paramInt2;
  }

  public GraphQLBaseRange(Parcel paramParcel)
  {
    this.offset = paramParcel.readInt();
    this.length = paramParcel.readInt();
  }

  public int a(GraphQLBaseRange paramGraphQLBaseRange)
  {
    return this.offset - paramGraphQLBaseRange.offset;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.offset);
    paramParcel.writeInt(this.length);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLBaseRange
 * JD-Core Version:    0.6.2
 */