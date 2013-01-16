package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;

public class FetchFeedbackResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchFeedbackResult> CREATOR = new FetchFeedbackResult.1();
  public final Feedback a;

  public FetchFeedbackResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((Feedback)paramParcel.readParcelable(Feedback.class.getClassLoader()));
  }

  public FetchFeedbackResult(Feedback paramFeedback, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramFeedback;
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
 * Qualified Name:     com.facebook.feed.protocol.FetchFeedbackResult
 * JD-Core Version:    0.6.0
 */