package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GraphQLPlace extends GraphQLProfile
{
  public static final Parcelable.Creator<GraphQLPlace> CREATOR = new GraphQLPlace.1();

  @JsonProperty("address")
  public final GraphQLAddress address;

  @JsonProperty("average_rating")
  public final float averageRating;

  @JsonProperty("categories")
  public final List<String> categories;

  @JsonProperty("location")
  public final GraphQLLocation location;

  @JsonProperty("page_likers")
  public final GraphQLProfileList pageLikers;

  @JsonProperty("page_visits")
  public final GraphQLProfileList pageVisits;

  @JsonProperty("raters")
  public final GraphQLProfileList raters;

  @JsonProperty("url")
  public final String url;

  protected GraphQLPlace()
  {
    this(new GraphQLPlace.Builder());
  }

  public GraphQLPlace(Parcel paramParcel)
  {
    super(paramParcel);
    this.location = ((GraphQLLocation)paramParcel.readParcelable(GraphQLLocation.class.getClassLoader()));
    this.url = paramParcel.readString();
    this.address = ((GraphQLAddress)paramParcel.readParcelable(GraphQLAddress.class.getClassLoader()));
    this.categories = paramParcel.readArrayList(String.class.getClassLoader());
    this.averageRating = paramParcel.readFloat();
    this.raters = ((GraphQLProfileList)paramParcel.readParcelable(GraphQLProfileList.class.getClassLoader()));
    this.pageVisits = ((GraphQLProfileList)paramParcel.readParcelable(GraphQLProfileList.class.getClassLoader()));
    this.pageLikers = ((GraphQLProfileList)paramParcel.readParcelable(GraphQLProfileList.class.getClassLoader()));
  }

  protected GraphQLPlace(GraphQLPlace.Builder paramBuilder)
  {
    super(paramBuilder);
    this.location = GraphQLPlace.Builder.a(paramBuilder);
    this.url = GraphQLPlace.Builder.b(paramBuilder);
    this.address = GraphQLPlace.Builder.c(paramBuilder);
    this.categories = GraphQLPlace.Builder.d(paramBuilder);
    this.averageRating = GraphQLPlace.Builder.e(paramBuilder);
    this.raters = GraphQLPlace.Builder.f(paramBuilder);
    this.pageVisits = GraphQLPlace.Builder.g(paramBuilder);
    this.pageLikers = GraphQLPlace.Builder.h(paramBuilder);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.location, paramInt);
    paramParcel.writeString(this.url);
    paramParcel.writeParcelable(this.address, paramInt);
    paramParcel.writeList(this.categories);
    paramParcel.writeFloat(this.averageRating);
    paramParcel.writeParcelable(this.raters, paramInt);
    paramParcel.writeParcelable(this.pageVisits, paramInt);
    paramParcel.writeParcelable(this.pageLikers, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLPlace
 * JD-Core Version:    0.6.2
 */