package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GraphQLError$1
  implements Parcelable.Creator<GraphQLError>
{
  public GraphQLError a(Parcel paramParcel)
  {
    return new GraphQLError(paramParcel, null);
  }

  public GraphQLError[] a(int paramInt)
  {
    return new GraphQLError[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLError.1
 * JD-Core Version:    0.6.2
 */