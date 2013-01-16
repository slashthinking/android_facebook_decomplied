package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GraphQLPoint2D$1
  implements Parcelable.Creator<GraphQLPoint2D>
{
  public GraphQLPoint2D a(Parcel paramParcel)
  {
    return new GraphQLPoint2D(paramParcel, null);
  }

  public GraphQLPoint2D[] a(int paramInt)
  {
    return new GraphQLPoint2D[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLPoint2D.1
 * JD-Core Version:    0.6.2
 */