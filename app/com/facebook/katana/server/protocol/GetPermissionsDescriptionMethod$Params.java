package com.facebook.katana.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import java.util.List;
import java.util.Locale;

public class GetPermissionsDescriptionMethod$Params
  implements Parcelable
{
  public static Parcelable.Creator<Params> CREATOR = new GetPermissionsDescriptionMethod.Params.1();
  private final String a;
  private final Optional<String> b;
  private final Optional<Locale> c;

  private GetPermissionsDescriptionMethod$Params(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = Optional.fromNullable(paramParcel.readString());
    String str = paramParcel.readString();
    if (str != null);
    for (this.c = Optional.fromNullable(new Locale(str)); ; this.c = Optional.absent())
      return;
  }

  public GetPermissionsDescriptionMethod$Params(List<String> paramList, String paramString, Locale paramLocale)
  {
    this.a = Joiner.on(",").join(paramList);
    this.b = Optional.fromNullable(paramString);
    this.c = Optional.fromNullable(paramLocale);
  }

  public String a()
  {
    return this.a;
  }

  public Optional<String> b()
  {
    return this.b;
  }

  public Optional<Locale> c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString((String)this.b.get());
    if (this.c.isPresent())
      paramParcel.writeString(((Locale)this.c.get()).toString());
    while (true)
    {
      return;
      paramParcel.writeString(null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.protocol.GetPermissionsDescriptionMethod.Params
 * JD-Core Version:    0.6.0
 */