package com.facebook.uberbar.resolvers;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

final class DataQuery$1
  implements Parcelable.Creator<DataQuery>
{
  public DataQuery a(Parcel paramParcel)
  {
    Uri localUri = (Uri)paramParcel.readParcelable(null);
    ArrayList localArrayList = paramParcel.readArrayList(null);
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    return new DataQuery.Builder().a(localUri).a(ImmutableList.a(localArrayList)).a(str1).b(str2).e();
  }

  public DataQuery[] a(int paramInt)
  {
    return new DataQuery[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.resolvers.DataQuery.1
 * JD-Core Version:    0.6.2
 */