package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GraphQLAddress$1
  implements Parcelable.Creator<GraphQLAddress>
{
  public GraphQLAddress a(Parcel paramParcel)
  {
    return new GraphQLAddress(paramParcel, null);
  }

  public GraphQLAddress[] a(int paramInt)
  {
    return new GraphQLAddress[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLAddress.1
 * JD-Core Version:    0.6.2
 */