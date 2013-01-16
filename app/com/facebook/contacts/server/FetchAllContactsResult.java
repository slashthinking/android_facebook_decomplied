package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class FetchAllContactsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchAllContactsResult> CREATOR = new FetchAllContactsResult.1();
  private final ImmutableList<ContactSummary> a;
  private final String b;
  private final boolean c;
  private final String d;

  private FetchAllContactsResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ImmutableList.a(paramParcel.readArrayList(ContactSummary.class.getClassLoader()));
    this.b = paramParcel.readString();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.c = i;
      this.d = paramParcel.readString();
      return;
      i = 0;
    }
  }

  public FetchAllContactsResult(DataFreshnessResult paramDataFreshnessResult, ImmutableList<ContactSummary> paramImmutableList, String paramString1, boolean paramBoolean, String paramString2, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    Preconditions.checkNotNull(paramImmutableList);
    this.a = paramImmutableList;
    this.b = paramString1;
    this.c = paramBoolean;
    this.d = paramString2;
  }

  public ImmutableList<ContactSummary> a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public boolean c()
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
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.a);
    paramParcel.writeString(this.b);
    if (this.c);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.d);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchAllContactsResult
 * JD-Core Version:    0.6.0
 */