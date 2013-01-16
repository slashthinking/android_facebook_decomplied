package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.MessagesCollection;

public class FetchMoreMessagesResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMoreMessagesResult> CREATOR;
  public static final FetchMoreMessagesResult a = new FetchMoreMessagesResult(DataFreshnessResult.NO_DATA, null, -1L);
  private final MessagesCollection b;

  static
  {
    CREATOR = new FetchMoreMessagesResult.1();
  }

  private FetchMoreMessagesResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = ((MessagesCollection)paramParcel.readParcelable(MessagesCollection.class.getClassLoader()));
  }

  public FetchMoreMessagesResult(DataFreshnessResult paramDataFreshnessResult, MessagesCollection paramMessagesCollection, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.b = paramMessagesCollection;
  }

  public MessagesCollection a()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchMoreMessagesResult
 * JD-Core Version:    0.6.0
 */