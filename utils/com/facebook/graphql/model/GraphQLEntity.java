package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLEntity
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLEntity> CREATOR = new GraphQLEntity.1();

  @JsonProperty("id")
  public final String id;

  @JsonProperty("location")
  public final GraphQLLocation location;

  @JsonProperty("name")
  public final String name;

  @JsonProperty("__type__")
  public final GraphQLObjectType objectType;

  @JsonProperty("url")
  public final String url;

  protected GraphQLEntity()
  {
    this.id = null;
    this.name = null;
    this.url = null;
    this.location = null;
    this.objectType = null;
  }

  public GraphQLEntity(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.name = paramParcel.readString();
    this.url = paramParcel.readString();
    this.location = ((GraphQLLocation)paramParcel.readParcelable(GraphQLLocation.class.getClassLoader()));
    this.objectType = ((GraphQLObjectType)paramParcel.readParcelable(GraphQLObjectType.class.getClassLoader()));
  }

  public GraphQLEntity(String paramString, GraphQLObjectType paramGraphQLObjectType)
  {
    this.id = paramString;
    this.name = null;
    this.url = null;
    this.location = null;
    this.objectType = paramGraphQLObjectType;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    paramParcel.writeParcelable(this.location, paramInt);
    paramParcel.writeParcelable(this.objectType, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLEntity
 * JD-Core Version:    0.6.2
 */