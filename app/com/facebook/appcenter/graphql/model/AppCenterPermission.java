package com.facebook.appcenter.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class AppCenterPermission
  implements Parcelable
{
  public static final Parcelable.Creator<AppCenterPermission> CREATOR = new AppCenterPermission.1();

  @JsonProperty("granted")
  public final boolean granted;

  @JsonProperty("important")
  public final boolean important;

  @JsonProperty("name")
  public final String name;

  @JsonProperty("text")
  public final String text;

  @JsonProperty("write")
  public final boolean write;

  protected AppCenterPermission()
  {
    this.name = null;
    this.text = null;
    this.important = false;
    this.write = false;
    this.granted = false;
  }

  public AppCenterPermission(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.text = paramParcel.readString();
    int j;
    int k;
    if (paramParcel.readInt() == i)
    {
      j = i;
      this.important = j;
      if (paramParcel.readInt() != i)
        break label73;
      k = i;
      label48: this.write = k;
      if (paramParcel.readInt() != i)
        break label79;
    }
    while (true)
    {
      this.granted = i;
      return;
      j = 0;
      break;
      label73: k = 0;
      break label48;
      label79: i = 0;
    }
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
      if ((paramObject == null) || (!(paramObject instanceof AppCenterPermission)))
      {
        i = 0;
        continue;
      }
      AppCenterPermission localAppCenterPermission = (AppCenterPermission)paramObject;
      if ((Objects.equal(this.name, localAppCenterPermission.name)) && (Objects.equal(this.text, localAppCenterPermission.text)) && (Objects.equal(Boolean.valueOf(this.important), Boolean.valueOf(localAppCenterPermission.important))) && (Objects.equal(Boolean.valueOf(this.write), Boolean.valueOf(localAppCenterPermission.write))) && (Objects.equal(Boolean.valueOf(this.granted), Boolean.valueOf(localAppCenterPermission.granted))))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.name;
    arrayOfObject[1] = this.text;
    arrayOfObject[2] = Boolean.valueOf(this.important);
    arrayOfObject[3] = Boolean.valueOf(this.write);
    arrayOfObject[4] = Boolean.valueOf(this.granted);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return " name : " + this.name + " text : " + this.text + " important : " + this.important + " write : " + this.write + " granted : " + this.granted;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.text);
    int j;
    int k;
    if (this.important)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.write)
        break label69;
      k = i;
      label44: paramParcel.writeInt(k);
      if (!this.granted)
        break label75;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      return;
      j = 0;
      break;
      label69: k = 0;
      break label44;
      label75: i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.graphql.model.AppCenterPermission
 * JD-Core Version:    0.6.0
 */