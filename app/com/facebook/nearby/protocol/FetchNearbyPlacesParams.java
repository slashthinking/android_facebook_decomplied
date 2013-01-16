package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.orca.common.util.StringUtil;
import com.google.common.collect.Lists;
import java.util.List;

public class FetchNearbyPlacesParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchNearbyPlacesParams> CREATOR = new FetchNearbyPlacesParams.1();
  private final SearchArea a;
  private final List<Long> b;

  private FetchNearbyPlacesParams(Parcel paramParcel)
  {
    this.a = ((SearchArea)paramParcel.readParcelable(SearchArea.class.getClassLoader()));
    this.b = paramParcel.readArrayList(Long.class.getClassLoader());
  }

  public FetchNearbyPlacesParams(SearchArea paramSearchArea)
  {
    this.a = paramSearchArea;
    this.b = null;
  }

  public FetchNearbyPlacesParams(SearchArea paramSearchArea, List<Long> paramList)
  {
    this.a = paramSearchArea;
    this.b = Lists.a(paramList);
  }

  public String a()
  {
    Object[] arrayOfObject;
    if ((this.b != null) && (this.b.size() > 0))
    {
      arrayOfObject = new Object[2];
      arrayOfObject[0] = this.a.a();
      arrayOfObject[1] = TextUtils.join(",", this.b.toArray());
    }
    for (String str = StringUtil.a("%s.topic(%s)", arrayOfObject); ; str = this.a.a())
      return str;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeList(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.protocol.FetchNearbyPlacesParams
 * JD-Core Version:    0.6.0
 */