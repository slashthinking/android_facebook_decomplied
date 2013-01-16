package com.facebook.orca.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;

public class Coordinates
  implements Parcelable
{
  public static final Parcelable.Creator<Coordinates> CREATOR = new Coordinates.1();
  private final double a;
  private final double b;
  private final Double c;
  private final Float d;
  private final Float e;
  private final Float f;
  private final Float g;

  private Coordinates(Parcel paramParcel)
  {
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readDouble();
    this.c = ((Double)paramParcel.readValue(null));
    this.d = ((Float)paramParcel.readValue(null));
    this.e = ((Float)paramParcel.readValue(null));
    this.f = ((Float)paramParcel.readValue(null));
    this.g = ((Float)paramParcel.readValue(null));
  }

  Coordinates(CoordinatesBuilder paramCoordinatesBuilder)
  {
    if ((paramCoordinatesBuilder.a() != null) && (paramCoordinatesBuilder.b() != null));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.a = paramCoordinatesBuilder.a().doubleValue();
      this.b = paramCoordinatesBuilder.b().doubleValue();
      this.c = paramCoordinatesBuilder.c();
      this.d = paramCoordinatesBuilder.d();
      this.e = paramCoordinatesBuilder.e();
      this.f = paramCoordinatesBuilder.f();
      this.g = paramCoordinatesBuilder.g();
      return;
    }
  }

  public static Coordinates a(Location paramLocation)
  {
    if (paramLocation == null);
    for (Coordinates localCoordinates = null; ; localCoordinates = newBuilder().a(Double.valueOf(paramLocation.getLatitude())).b(Double.valueOf(paramLocation.getLongitude())).c(Double.valueOf(paramLocation.getAltitude())).a(Float.valueOf(paramLocation.getAccuracy())).c(Float.valueOf(paramLocation.getBearing())).d(Float.valueOf(paramLocation.getSpeed())).h())
      return localCoordinates;
  }

  public static CoordinatesBuilder newBuilder()
  {
    return new CoordinatesBuilder();
  }

  public Location a()
  {
    Location localLocation = new Location("");
    localLocation.setLatitude(this.a);
    localLocation.setLongitude(this.b);
    if (this.c != null)
      localLocation.setAltitude(this.c.doubleValue());
    if (this.d != null)
      localLocation.setAccuracy(this.d.floatValue());
    if (this.g != null)
      localLocation.setSpeed(this.g.floatValue());
    return localLocation;
  }

  public double b()
  {
    return this.a;
  }

  public double c()
  {
    return this.b;
  }

  public Double d()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    if (this.c != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public Float f()
  {
    return this.d;
  }

  public boolean g()
  {
    if (this.d != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public Float h()
  {
    return this.e;
  }

  public boolean i()
  {
    if (this.e != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public Float j()
  {
    return this.f;
  }

  public boolean k()
  {
    if (this.f != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public Float l()
  {
    return this.g;
  }

  public boolean m()
  {
    if (this.g != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.b);
    paramParcel.writeValue(this.c);
    paramParcel.writeValue(this.d);
    paramParcel.writeValue(this.e);
    paramParcel.writeValue(this.f);
    paramParcel.writeValue(this.g);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.Coordinates
 * JD-Core Version:    0.6.0
 */