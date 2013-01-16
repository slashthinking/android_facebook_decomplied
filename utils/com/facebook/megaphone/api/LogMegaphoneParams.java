package com.facebook.megaphone.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Maps;
import java.util.Map;

public class LogMegaphoneParams
  implements Parcelable
{
  public static final Parcelable.Creator<LogMegaphoneParams> CREATOR = new LogMegaphoneParams.1();
  public final String a;
  public final String b;
  public final Map<String, String> c;

  private LogMegaphoneParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((Map)paramParcel.readSerializable());
  }

  public LogMegaphoneParams(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, Maps.a());
  }

  public LogMegaphoneParams(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramMap;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeSerializable(Maps.a(this.c));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.api.LogMegaphoneParams
 * JD-Core Version:    0.6.2
 */