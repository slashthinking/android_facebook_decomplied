package com.facebook.orca.users;

import android.content.res.Resources;
import android.os.Parcelable;

public abstract class UserIdentifier
  implements Parcelable
{
  public abstract String a(Resources paramResources);

  public abstract UserIdentifierKey c();

  public abstract String d();

  public abstract UserIdentifier.IdentifierType e();

  public String toString()
  {
    return d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserIdentifier
 * JD-Core Version:    0.6.0
 */