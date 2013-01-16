package com.facebook.uberbar.resolvers;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;

public class DataQuery
  implements Parcelable
{
  public static final Parcelable.Creator<DataQuery> CREATOR = new DataQuery.1();
  private final Uri a;
  private final ImmutableList<String> b;
  private final String c;
  private final String d;

  private DataQuery(DataQuery.Builder paramBuilder)
  {
    this.a = paramBuilder.a();
    this.b = ImmutableList.a(paramBuilder.b());
    this.c = paramBuilder.c();
    this.d = paramBuilder.d();
  }

  public String[] a()
  {
    return (String[])this.b.toArray(new String[this.b.size()]);
  }

  public Uri b()
  {
    return this.a;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeList(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.resolvers.DataQuery
 * JD-Core Version:    0.6.2
 */