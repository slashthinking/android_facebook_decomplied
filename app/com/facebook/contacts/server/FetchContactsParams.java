package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

public class FetchContactsParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchContactsParams> CREATOR = new FetchContactsParams.1();
  private final ImmutableSet<String> a;

  private FetchContactsParams(Parcel paramParcel)
  {
    this.a = ImmutableSet.a(paramParcel.createStringArrayList());
  }

  public FetchContactsParams(ImmutableSet<String> paramImmutableSet)
  {
    this.a = paramImmutableSet;
  }

  public ImmutableSet<String> a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringList(Lists.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchContactsParams
 * JD-Core Version:    0.6.0
 */