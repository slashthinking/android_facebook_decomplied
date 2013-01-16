package com.facebook.abtest.qe.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class SyncQuickExperimentResult
  implements Parcelable
{
  public static final Parcelable.Creator<SyncQuickExperimentResult> CREATOR = new SyncQuickExperimentResult.1();
  private final String a;
  private final String b;
  private final boolean c;
  private final ImmutableMap<String, String> d;

  public SyncQuickExperimentResult(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.c = i;
      this.d = ImmutableMap.a(paramParcel.readHashMap(SyncQuickExperimentResult.class.getClassLoader()));
      return;
      i = 0;
    }
  }

  public SyncQuickExperimentResult(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap)
  {
    this.a = ((String)Preconditions.checkNotNull(paramString1));
    this.b = ((String)Preconditions.checkNotNull(paramString2));
    this.c = paramBoolean;
    this.d = ImmutableMap.a((Map)Preconditions.checkNotNull(paramMap));
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public ImmutableMap<String, String> d()
  {
    return ImmutableMap.a(this.d);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    if (this.c);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeMap(this.d);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.protocol.SyncQuickExperimentResult
 * JD-Core Version:    0.6.2
 */