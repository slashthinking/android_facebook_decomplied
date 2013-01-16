package com.facebook.katana.nux.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.BaseResult;
import java.util.List;

public class FetchNuxStepsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchNuxStepsResult> CREATOR = new FetchNuxStepsResult.1();
  private List<String> a = null;

  private FetchNuxStepsResult(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.model.FetchNuxStepsResult
 * JD-Core Version:    0.6.0
 */