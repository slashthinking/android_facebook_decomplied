package com.facebook.bugreporter;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;

public class BugReport
  implements Parcelable
{
  public static final Parcelable.Creator<BugReport> CREATOR = new BugReport.1();
  private final Uri a;
  private final String b;
  private final Uri c;
  private final Uri d;
  private final String e;
  private final ImmutableList<Long> f;
  private final String g;
  private final String h;

  private BugReport(Parcel paramParcel)
  {
    this.a = ((Uri)paramParcel.readParcelable(null));
    this.b = paramParcel.readString();
    this.c = ((Uri)paramParcel.readParcelable(null));
    this.d = ((Uri)paramParcel.readParcelable(null));
    this.e = paramParcel.readString();
    this.f = ImmutableList.a(Longs.a(paramParcel.createLongArray()));
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }

  BugReport(BugReportBuilder paramBugReportBuilder)
  {
    this.a = paramBugReportBuilder.a();
    this.b = paramBugReportBuilder.b();
    this.c = paramBugReportBuilder.c();
    this.d = paramBugReportBuilder.d();
    this.e = paramBugReportBuilder.e();
    this.f = ImmutableList.a(paramBugReportBuilder.f());
    this.g = paramBugReportBuilder.g();
    this.h = paramBugReportBuilder.h();
    a(this.a, false);
    a(this.d, true);
    a(this.c, true);
    Preconditions.checkNotNull(this.e);
  }

  private void a(Uri paramUri, boolean paramBoolean)
  {
    if (!paramBoolean)
      Preconditions.checkNotNull(paramUri);
    if (paramUri != null)
    {
      Preconditions.checkArgument("file".equals(paramUri.getScheme()));
      Preconditions.checkArgument(paramUri.isAbsolute());
    }
  }

  public static BugReportBuilder newBuilder()
  {
    return new BugReportBuilder();
  }

  public Uri a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public Uri c()
  {
    return this.c;
  }

  public Uri d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.e;
  }

  public ImmutableList<Long> f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }

  public String h()
  {
    return this.h;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
    paramParcel.writeParcelable(this.d, paramInt);
    paramParcel.writeString(this.e);
    paramParcel.writeLongArray(Longs.a(this.f));
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReport
 * JD-Core Version:    0.6.0
 */