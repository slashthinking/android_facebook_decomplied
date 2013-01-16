package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class FetchContactsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchContactsResult> CREATOR = new FetchContactsResult.1();
  private final ImmutableList<ContactSummary> a;

  private FetchContactsResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ImmutableList.a(paramParcel.readArrayList(ContactSummary.class.getClassLoader()));
  }

  public FetchContactsResult(DataFreshnessResult paramDataFreshnessResult, long paramLong, ImmutableList<ContactSummary> paramImmutableList)
  {
    super(paramDataFreshnessResult, paramLong);
    Preconditions.checkNotNull(paramImmutableList);
    this.a = paramImmutableList;
  }

  public ImmutableList<ContactSummary> a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "FetchContactsResult: " + this.a;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchContactsResult
 * JD-Core Version:    0.6.0
 */