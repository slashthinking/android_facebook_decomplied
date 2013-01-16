package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLEntityRange extends GraphQLBaseRange
{
  public static final Parcelable.Creator<GraphQLEntityRange> CREATOR = new GraphQLEntityRange.1();

  @JsonProperty("entity")
  public final GraphQLEntity entity;

  protected GraphQLEntityRange()
  {
    this.entity = null;
  }

  public GraphQLEntityRange(Parcel paramParcel)
  {
    super(paramParcel);
    this.entity = ((GraphQLEntity)paramParcel.readParcelable(GraphQLEntity.class.getClassLoader()));
  }

  public GraphQLEntityRange(GraphQLEntity paramGraphQLEntity, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.entity = paramGraphQLEntity;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.entity, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLEntityRange
 * JD-Core Version:    0.6.2
 */