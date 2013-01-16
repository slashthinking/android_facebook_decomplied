package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.Message;

public class FetchMessageResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMessageResult> CREATOR = new FetchMessageResult.1();
  private final Message a;

  private FetchMessageResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((Message)paramParcel.readParcelable(Message.class.getClassLoader()));
  }

  public FetchMessageResult(DataFreshnessResult paramDataFreshnessResult, Message paramMessage, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramMessage;
  }

  public Message a()
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
 * Qualified Name:     com.facebook.orca.server.FetchMessageResult
 * JD-Core Version:    0.6.0
 */