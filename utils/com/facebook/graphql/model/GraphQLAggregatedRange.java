package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import java.util.List;

public class GraphQLAggregatedRange extends GraphQLBaseRange
{
  public static final Parcelable.Creator<GraphQLAggregatedRange> CREATOR = new GraphQLAggregatedRange.1();

  @JsonProperty("count")
  public final int count;

  @JsonProperty("sample_entities")
  public final List<GraphQLProfile> entities;

  private GraphQLAggregatedRange()
  {
    this.count = 0;
    this.entities = null;
  }

  public GraphQLAggregatedRange(int paramInt1, int paramInt2, int paramInt3, List<GraphQLProfile> paramList)
  {
    super(paramInt1, paramInt2);
    this.count = paramInt3;
    this.entities = paramList;
  }

  public GraphQLAggregatedRange(Parcel paramParcel)
  {
    super(paramParcel);
    this.count = paramParcel.readInt();
    this.entities = Lists.a();
    paramParcel.readTypedList(this.entities, GraphQLProfile.CREATOR);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.count);
    paramParcel.writeTypedList(this.entities);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLAggregatedRange
 * JD-Core Version:    0.6.2
 */