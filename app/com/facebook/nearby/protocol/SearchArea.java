package com.facebook.nearby.protocol;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.common.util.StringUtil;

public class SearchArea
  implements Parcelable
{
  public static final Parcelable.Creator<SearchArea> CREATOR = new SearchArea.1();
  public final Location a;
  public final int b;

  public SearchArea(Location paramLocation)
  {
    this.a = paramLocation;
    this.b = -1;
  }

  public SearchArea(Location paramLocation, int paramInt)
  {
    this.a = paramLocation;
    this.b = paramInt;
  }

  private SearchArea(Parcel paramParcel)
  {
    this.a = ((Location)paramParcel.readParcelable(Location.class.getClassLoader()));
    this.b = paramParcel.readInt();
  }

  public String a()
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Double.valueOf(this.a.getLatitude());
    String str1 = StringUtil.a("%f", arrayOfObject1).replace(".", "\\.");
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Double.valueOf(this.a.getLongitude());
    String str2 = StringUtil.a("%f", arrayOfObject2).replace(".", "\\.");
    Object[] arrayOfObject3;
    if (this.b != -1)
    {
      arrayOfObject3 = new Object[3];
      arrayOfObject3[0] = str1;
      arrayOfObject3[1] = str2;
      arrayOfObject3[2] = Integer.valueOf(this.b);
    }
    for (String str3 = StringUtil.a("center(%s,%s,%d)", arrayOfObject3); ; str3 = StringUtil.a("center(%s,%s)", new Object[] { str1, str2 }))
      return str3;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeInt(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.protocol.SearchArea
 * JD-Core Version:    0.6.0
 */