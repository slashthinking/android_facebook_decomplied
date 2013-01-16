package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.notify.NotificationSetting;
import com.google.common.base.Preconditions;

public class ModifyThreadParams
  implements Parcelable
{
  public static final Parcelable.Creator<ModifyThreadParams> CREATOR = new ModifyThreadParams.1();
  private final String a;
  private final boolean b;
  private final String c;
  private final MediaResource d;
  private final boolean e;
  private final boolean f;
  private final NotificationSetting g;

  private ModifyThreadParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    boolean bool2;
    boolean bool3;
    if (paramParcel.readInt() != 0)
    {
      bool2 = bool1;
      this.b = bool2;
      this.c = paramParcel.readString();
      if (paramParcel.readInt() == 0)
        break label102;
      bool3 = bool1;
      label46: this.e = bool3;
      this.d = ((MediaResource)paramParcel.readParcelable(MediaResource.class.getClassLoader()));
      if (paramParcel.readInt() == 0)
        break label108;
    }
    while (true)
    {
      this.f = bool1;
      this.g = ((NotificationSetting)paramParcel.readParcelable(NotificationSetting.class.getClassLoader()));
      return;
      bool2 = false;
      break;
      label102: bool3 = false;
      break label46;
      label108: bool1 = false;
    }
  }

  ModifyThreadParams(ModifyThreadParamsBuilder paramModifyThreadParamsBuilder)
  {
    Preconditions.checkNotNull(paramModifyThreadParamsBuilder.a(), "threadid must be specified");
    this.a = paramModifyThreadParamsBuilder.a();
    this.b = paramModifyThreadParamsBuilder.b();
    this.c = paramModifyThreadParamsBuilder.c();
    this.e = paramModifyThreadParamsBuilder.d();
    this.d = paramModifyThreadParamsBuilder.e();
    this.f = paramModifyThreadParamsBuilder.f();
    this.g = paramModifyThreadParamsBuilder.g();
  }

  public String a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public MediaResource e()
  {
    return this.d;
  }

  public boolean f()
  {
    return this.f;
  }

  public NotificationSetting g()
  {
    return this.g;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.a);
    int j;
    int k;
    if (this.b)
    {
      j = i;
      paramParcel.writeInt(j);
      paramParcel.writeString(this.c);
      if (!this.e)
        break label87;
      k = i;
      label44: paramParcel.writeInt(k);
      paramParcel.writeParcelable(this.d, paramInt);
      if (!this.f)
        break label93;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.g, paramInt);
      return;
      j = 0;
      break;
      label87: k = 0;
      break label44;
      label93: i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ModifyThreadParams
 * JD-Core Version:    0.6.0
 */