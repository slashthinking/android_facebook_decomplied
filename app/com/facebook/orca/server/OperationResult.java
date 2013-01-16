package com.facebook.orca.server;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import java.util.ArrayList;

public class OperationResult
  implements Parcelable
{
  public static final Parcelable.Creator<OperationResult> CREATOR;
  private static final OperationResult a = new OperationResult();
  private final boolean b;
  private final String c;
  private final Bundle d;
  private final ErrorCode e;
  private final String f;

  static
  {
    CREATOR = new OperationResult.1();
  }

  OperationResult()
  {
    this.b = true;
    this.c = null;
    this.d = null;
    this.e = ErrorCode.NO_ERROR;
    this.f = null;
  }

  private OperationResult(Parcel paramParcel)
  {
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      this.c = paramParcel.readString();
      this.d = ((Bundle)paramParcel.readParcelable(null));
      this.e = ErrorCode.valueOf(paramParcel.readString());
      this.f = paramParcel.readString();
      return;
    }
  }

  private OperationResult(ErrorCode paramErrorCode, String paramString, Bundle paramBundle)
  {
    this.b = false;
    this.c = null;
    this.d = paramBundle;
    this.e = paramErrorCode;
    this.f = paramString;
  }

  private OperationResult(String paramString, Bundle paramBundle)
  {
    this.b = true;
    this.c = paramString;
    this.d = paramBundle;
    this.e = ErrorCode.NO_ERROR;
    this.f = null;
  }

  public static OperationResult a(Parcelable paramParcelable)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("result", paramParcelable);
    return new OperationResult(null, localBundle);
  }

  public static OperationResult a(Parcelable paramParcelable, Pair<String, Parcelable>[] paramArrayOfPair)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("result", paramParcelable);
    int i = paramArrayOfPair.length;
    for (int j = 0; j < i; j++)
    {
      Pair<String, Parcelable> localPair = paramArrayOfPair[j];
      localBundle.putParcelable((String)localPair.first, (Parcelable)localPair.second);
    }
    return new OperationResult(null, localBundle);
  }

  public static OperationResult a(ErrorCode paramErrorCode, Bundle paramBundle)
  {
    return new OperationResult(paramErrorCode, paramErrorCode.toString(), paramBundle);
  }

  public static OperationResult a(ErrorCode paramErrorCode, String paramString)
  {
    return new OperationResult(paramErrorCode, paramString, null);
  }

  public static OperationResult a(String paramString)
  {
    return new OperationResult(paramString, null);
  }

  public static OperationResult a(ArrayList<? extends Parcelable> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("result", paramArrayList);
    return new OperationResult(null, localBundle);
  }

  public static OperationResult b()
  {
    return a;
  }

  public <T extends Parcelable> T b(String paramString)
  {
    if (this.d != null)
      this.d.setClassLoader(getClass().getClassLoader());
    if (this.d != null);
    for (Parcelable localParcelable = this.d.getParcelable(paramString); ; localParcelable = null)
      return localParcelable;
  }

  public boolean c()
  {
    return this.b;
  }

  public ErrorCode d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.f;
  }

  public String f()
  {
    return this.c;
  }

  public Bundle g()
  {
    if (this.d != null)
      this.d.setClassLoader(getClass().getClassLoader());
    return this.d;
  }

  public <T extends Parcelable> T h()
  {
    if (this.d != null)
      this.d.setClassLoader(getClass().getClassLoader());
    if (this.d != null);
    for (Parcelable localParcelable = this.d.getParcelable("result"); ; localParcelable = null)
      return localParcelable;
  }

  public <T extends Parcelable> ArrayList<T> i()
  {
    if (this.d != null);
    for (ArrayList localArrayList = this.d.getParcelableArrayList("result"); ; localArrayList = null)
      return localArrayList;
  }

  public Bundle j()
  {
    return this.d;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.c);
      paramParcel.writeParcelable(this.d, paramInt);
      paramParcel.writeString(this.e.toString());
      paramParcel.writeString(this.f);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OperationResult
 * JD-Core Version:    0.6.0
 */