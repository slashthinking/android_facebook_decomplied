package com.facebook.photos.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.photos.model.FbPhoto;
import com.google.common.collect.Maps;
import java.util.Map;

public class FetchPhotosResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchPhotosResult> CREATOR = new FetchPhotosResult.1();
  private final Map<String, FbPhoto> a = Maps.a();

  private FetchPhotosResult(Parcel paramParcel)
  {
    paramParcel.readMap(this.a, getClass().getClassLoader());
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.method.FetchPhotosResult
 * JD-Core Version:    0.6.0
 */