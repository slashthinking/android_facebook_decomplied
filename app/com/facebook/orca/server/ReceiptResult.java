package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.ThreadSummary;

public class ReceiptResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<ReceiptResult> CREATOR = new ReceiptResult.1();
  private ThreadSummary a;

  public ReceiptResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((ThreadSummary)paramParcel.readParcelable(ThreadSummary.class.getClassLoader()));
  }

  public ReceiptResult(DataFreshnessResult paramDataFreshnessResult, ThreadSummary paramThreadSummary, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramThreadSummary;
  }

  public ThreadSummary a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ReceiptResult
 * JD-Core Version:    0.6.0
 */