package com.facebook.orca.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Collections2;
import java.util.Collection;

public class UserKey
{
  private final User.Type a;
  private final String b;

  @JsonIgnore
  private final String c;

  @JsonCreator
  public UserKey(@JsonProperty("type") User.Type paramType, @JsonProperty("id") String paramString)
  {
    this.a = paramType;
    this.b = paramString;
    this.c = (paramType + ":" + paramString);
  }

  public static UserKey a(String paramString)
  {
    if (paramString == null);
    String[] arrayOfString;
    for (UserKey localUserKey = null; ; localUserKey = new UserKey(User.Type.valueOf(arrayOfString[0]), arrayOfString[1]))
    {
      return localUserKey;
      arrayOfString = paramString.split(":", 2);
      if (arrayOfString.length == 2)
        continue;
      throw new IllegalArgumentException("Cannot parse user key: " + paramString);
    }
  }

  public static Collection<String> a(Collection<UserKey> paramCollection)
  {
    return Collections2.a(paramCollection, new UserKey.1());
  }

  public static Collection<String> b(Collection<UserKey> paramCollection)
  {
    return Collections2.a(paramCollection, new UserKey.2());
  }

  public User.Type a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public boolean d()
  {
    if ((this.a != null) && (this.b != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      UserKey localUserKey = (UserKey)paramObject;
      if (!this.b.equals(localUserKey.b))
      {
        i = 0;
        continue;
      }
      if (this.a == localUserKey.a)
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    return 31 * this.b.hashCode() + this.a.hashCode();
  }

  public String toString()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserKey
 * JD-Core Version:    0.6.0
 */