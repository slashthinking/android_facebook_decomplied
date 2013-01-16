package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.collect.ImmutableList;

public class UploadBulkContactsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<UploadBulkContactsResult> CREATOR = new UploadBulkContactsResult.1();
  private final String a;
  private final ImmutableList<UploadBulkContactChangeResult> b;

  private UploadBulkContactsResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = ImmutableList.a(paramParcel.readArrayList(UploadBulkContactsResult.class.getClassLoader()));
  }

  public UploadBulkContactsResult(String paramString, ImmutableList<UploadBulkContactChangeResult> paramImmutableList, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramString;
    this.b = paramImmutableList;
  }

  public String a()
  {
    return this.a;
  }

  public ImmutableList<UploadBulkContactChangeResult> b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "UploadBulkContactsResult<" + this.a + ">: " + this.b;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeList(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactsResult
 * JD-Core Version:    0.6.0
 */