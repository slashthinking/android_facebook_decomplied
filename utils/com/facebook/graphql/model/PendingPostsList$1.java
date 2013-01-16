package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PendingPostsList$1
  implements Parcelable.Creator<PendingPostsList>
{
  public PendingPostsList a(Parcel paramParcel)
  {
    return new PendingPostsList(paramParcel);
  }

  public PendingPostsList[] a(int paramInt)
  {
    return new PendingPostsList[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PendingPostsList.1
 * JD-Core Version:    0.6.2
 */