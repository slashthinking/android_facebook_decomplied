package com.facebook.abtest.qe.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;

public class SyncQuickExperimentParams
  implements Parcelable
{
  public static Parcelable.Creator<SyncQuickExperimentParams> CREATOR = new SyncQuickExperimentParams.1();
  private final String a;
  private final String b;

  public SyncQuickExperimentParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }

  public SyncQuickExperimentParams(String paramString1, String paramString2)
  {
    this.a = ((String)Preconditions.checkNotNull(paramString1));
    this.b = ((String)Preconditions.checkNotNull(paramString2));
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return this.a + " : " + this.b;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.protocol.SyncQuickExperimentParams
 * JD-Core Version:    0.6.2
 */