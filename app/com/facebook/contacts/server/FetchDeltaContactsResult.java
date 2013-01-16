package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class FetchDeltaContactsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchDeltaContactsResult> CREATOR = new FetchDeltaContactsResult.1();
  private final ImmutableList<ContactSummary> a;
  private final ImmutableList<String> b;
  private final String c;
  private final boolean d;

  private FetchDeltaContactsResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ImmutableList.a(paramParcel.readArrayList(ContactSummary.class.getClassLoader()));
    this.b = ImmutableList.a(paramParcel.createStringArrayList());
    this.c = paramParcel.readString();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.d = i;
      return;
      i = 0;
    }
  }

  public FetchDeltaContactsResult(DataFreshnessResult paramDataFreshnessResult, ImmutableList<ContactSummary> paramImmutableList, ImmutableList<String> paramImmutableList1, String paramString, boolean paramBoolean, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    Preconditions.checkNotNull(paramImmutableList);
    Preconditions.checkNotNull(paramImmutableList1);
    this.a = paramImmutableList;
    this.b = paramImmutableList1;
    this.c = paramString;
    this.d = paramBoolean;
  }

  public ImmutableList<ContactSummary> a()
  {
    return this.a;
  }

  public ImmutableList<String> b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.a);
    paramParcel.writeList(this.b);
    paramParcel.writeString(this.c);
    if (this.d);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchDeltaContactsResult
 * JD-Core Version:    0.6.0
 */