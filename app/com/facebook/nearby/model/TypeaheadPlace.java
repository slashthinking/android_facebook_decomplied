package com.facebook.nearby.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLAddress;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPlace;
import java.util.List;

public class TypeaheadPlace
  implements Parcelable
{
  public static final Parcelable.Creator<TypeaheadPlace> CREATOR = new TypeaheadPlace.1();
  public final String a;
  public final String b;
  public final float c;
  public final String d;
  public final GraphQLLocation e;
  public final List<String> f;
  public final GraphQLAddress g;

  private TypeaheadPlace(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.f = paramParcel.readArrayList(String.class.getClassLoader());
    this.g = ((GraphQLAddress)paramParcel.readParcelable(GraphQLAddress.class.getClassLoader()));
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readString();
    this.e = ((GraphQLLocation)paramParcel.readParcelable(GraphQLLocation.class.getClassLoader()));
  }

  public TypeaheadPlace(GraphQLPlace paramGraphQLPlace)
  {
    this.a = paramGraphQLPlace.id;
    this.b = paramGraphQLPlace.name;
    this.f = paramGraphQLPlace.categories;
    this.g = paramGraphQLPlace.address;
    this.c = paramGraphQLPlace.averageRating;
    this.d = paramGraphQLPlace.profilePicture.uri;
    this.e = paramGraphQLPlace.location;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeList(this.f);
    paramParcel.writeParcelable(this.g, paramInt);
    paramParcel.writeFloat(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.model.TypeaheadPlace
 * JD-Core Version:    0.6.0
 */