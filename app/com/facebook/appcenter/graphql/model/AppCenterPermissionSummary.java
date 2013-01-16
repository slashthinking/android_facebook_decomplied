package com.facebook.appcenter.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppCenterPermissionSummary
  implements Parcelable
{
  public static final Parcelable.Creator<AppCenterPermissionSummary> CREATOR = new AppCenterPermissionSummary.1();
  private List<AppCenterPermission> a = null;

  @JsonProperty("additional_permissions")
  public final List<AppCenterPermission> additionalPermissions;
  private List<AppCenterPermission> b = null;
  private List<AppCenterPermission> c = null;
  private List<AppCenterPermission> d = null;
  private List<AppCenterPermission> e = null;

  @JsonProperty("required_permissions")
  public final List<AppCenterPermission> requiredPermissions;

  protected AppCenterPermissionSummary()
  {
    this.requiredPermissions = new ArrayList();
    this.additionalPermissions = new ArrayList();
  }

  public AppCenterPermissionSummary(Parcel paramParcel)
  {
    this.requiredPermissions = paramParcel.readArrayList(AppCenterPermission.class.getClassLoader());
    this.additionalPermissions = paramParcel.readArrayList(AppCenterPermission.class.getClassLoader());
  }

  public List<AppCenterPermission> a()
  {
    if (this.a == null)
    {
      this.a = new ArrayList();
      Iterator localIterator = this.requiredPermissions.iterator();
      while (localIterator.hasNext())
      {
        AppCenterPermission localAppCenterPermission = (AppCenterPermission)localIterator.next();
        if ((!localAppCenterPermission.important) || (localAppCenterPermission.write))
          continue;
        this.a.add(localAppCenterPermission);
      }
    }
    return this.a;
  }

  public List<AppCenterPermission> b()
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      Iterator localIterator = this.requiredPermissions.iterator();
      while (localIterator.hasNext())
      {
        AppCenterPermission localAppCenterPermission = (AppCenterPermission)localIterator.next();
        if ((localAppCenterPermission.important) || (localAppCenterPermission.write))
          continue;
        this.b.add(localAppCenterPermission);
      }
    }
    return this.b;
  }

  public List<AppCenterPermission> c()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      Iterator localIterator = this.requiredPermissions.iterator();
      while (localIterator.hasNext())
      {
        AppCenterPermission localAppCenterPermission = (AppCenterPermission)localIterator.next();
        if (!localAppCenterPermission.write)
          continue;
        this.c.add(localAppCenterPermission);
      }
    }
    return this.c;
  }

  public List<AppCenterPermission> d()
  {
    if (this.d == null)
    {
      this.d = new ArrayList();
      Iterator localIterator = this.requiredPermissions.iterator();
      while (localIterator.hasNext())
      {
        AppCenterPermission localAppCenterPermission = (AppCenterPermission)localIterator.next();
        if (localAppCenterPermission.granted)
          continue;
        this.d.add(localAppCenterPermission);
      }
    }
    return this.d;
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
      if ((paramObject == null) || (!(paramObject instanceof AppCenterPermissionSummary)))
      {
        i = 0;
        continue;
      }
      AppCenterPermissionSummary localAppCenterPermissionSummary = (AppCenterPermissionSummary)paramObject;
      if ((Objects.equal(this.requiredPermissions, localAppCenterPermissionSummary.requiredPermissions)) && (Objects.equal(this.additionalPermissions, localAppCenterPermissionSummary.additionalPermissions)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.requiredPermissions;
    arrayOfObject[1] = this.additionalPermissions;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return " required permissions : " + this.requiredPermissions + " additional_permissions : " + this.additionalPermissions;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.requiredPermissions);
    paramParcel.writeList(this.additionalPermissions);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.graphql.model.AppCenterPermissionSummary
 * JD-Core Version:    0.6.0
 */