package com.facebook.appcenter.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

public class FetchAppListParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchAppListParams> CREATOR;
  public static String a = "allcategories";
  public static String b = "games";
  public static String c = "pageapps";
  public static String d = "entertainment";
  public static String e = "lifestyle";
  public static String f = "music";
  public static String g = "news";
  public static String h = "photovideo";
  public static String i = "sports";
  public static String j = "travel";
  public static String k = "utilities";
  public static String l = "facebook";
  public static String m = "curated";
  public static String n = "top";
  public static String o = "suggested";
  private String p;
  private String q;

  static
  {
    CREATOR = new FetchAppListParams.1();
  }

  public FetchAppListParams(Parcel paramParcel)
  {
    this.q = paramParcel.readString();
    this.p = paramParcel.readString();
  }

  public FetchAppListParams(String paramString1, String paramString2)
  {
    this.q = paramString1;
    this.p = paramString2;
  }

  public String a()
  {
    return this.q;
  }

  public String b()
  {
    return this.p;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i1 = 1;
    if (this == paramObject);
    while (true)
    {
      return i1;
      if ((paramObject == null) || (!(paramObject instanceof FetchAppListParams)))
      {
        i1 = 0;
        continue;
      }
      FetchAppListParams localFetchAppListParams = (FetchAppListParams)paramObject;
      if ((Objects.equal(this.p, localFetchAppListParams.b())) && (Objects.equal(this.q, localFetchAppListParams.a())))
        continue;
      i1 = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.p;
    arrayOfObject[1] = this.q;
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.p);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.service.FetchAppListParams
 * JD-Core Version:    0.6.0
 */