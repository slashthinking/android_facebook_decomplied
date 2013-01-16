package com.facebook.nearby.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLPlace;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class NearbyTopic
  implements Parcelable
{
  public static final Parcelable.Creator<NearbyTopic> CREATOR = new NearbyTopic.1();
  public final String a;
  public final ImmutableSet<Long> b;

  private NearbyTopic(Parcel paramParcel)
  {
    this.b = ((ImmutableSet)paramParcel.readSerializable());
    this.a = paramParcel.readString();
  }

  public NearbyTopic(GraphQLPlace paramGraphQLPlace)
  {
    this.b = ImmutableSet.b(Long.valueOf(Long.parseLong(paramGraphQLPlace.id)));
    this.a = paramGraphQLPlace.name;
  }

  public NearbyTopic(Set<Long> paramSet, String paramString)
  {
    this.b = ImmutableSet.a(paramSet);
    this.a = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if (paramObject == null)
      {
        i = 0;
        continue;
      }
      if (!getClass().equals(paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      NearbyTopic localNearbyTopic = (NearbyTopic)paramObject;
      if ((Objects.equal(localNearbyTopic.b, this.b)) && (Objects.equal(localNearbyTopic.a, this.a)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = this.a;
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(this.b);
    paramParcel.writeString(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.model.NearbyTopic
 * JD-Core Version:    0.6.0
 */