package com.facebook.photos.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public final class FetchPhotoParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchPhotoParams> CREATOR = new FetchPhotoParams.1();
  private final List<String> a;

  private FetchPhotoParams(Parcel paramParcel)
  {
    ArrayList localArrayList = Lists.a();
    paramParcel.readStringList(localArrayList);
    this.a = ImmutableList.a(localArrayList);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringList(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.method.FetchPhotoParams
 * JD-Core Version:    0.6.0
 */