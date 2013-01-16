package com.facebook.appcenter.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class AppCenterCategory
  implements Parcelable
{
  public static final Parcelable.Creator<AppCenterCategory> CREATOR = new AppCenterCategory.1();
  public int a;

  @JsonProperty("label")
  public final String label;

  @JsonProperty("name")
  public final String name;

  public AppCenterCategory()
  {
    this.name = "";
    this.label = "";
    this.a = 0;
  }

  public AppCenterCategory(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.a = paramParcel.readInt();
    this.label = paramParcel.readString();
  }

  public AppCenterCategory(String paramString1, int paramInt, String paramString2)
  {
    this.name = paramString1;
    this.a = paramInt;
    this.label = paramString2;
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (!(paramObject instanceof AppCenterCategory)))
      {
        i = 0;
        continue;
      }
      AppCenterCategory localAppCenterCategory = (AppCenterCategory)paramObject;
      if ((Objects.equal(this.name, localAppCenterCategory.name)) && (Objects.equal(Integer.valueOf(this.a), Integer.valueOf(localAppCenterCategory.a))) && (Objects.equal(this.label, localAppCenterCategory.label)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.name;
    arrayOfObject[1] = this.label;
    arrayOfObject[2] = Integer.valueOf(this.a);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return "app center category: label =" + this.label + " name=" + this.name + " order=" + Integer.toString(this.a);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.label);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.graphql.model.AppCenterCategory
 * JD-Core Version:    0.6.0
 */