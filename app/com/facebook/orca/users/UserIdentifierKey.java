package com.facebook.orca.users;

public class UserIdentifierKey
{
  public final UserIdentifier.IdentifierType a;
  public final String b;

  public UserIdentifierKey(UserIdentifier.IdentifierType paramIdentifierType, String paramString)
  {
    this.a = paramIdentifierType;
    this.b = paramString;
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
      UserIdentifierKey localUserIdentifierKey = (UserIdentifierKey)paramObject;
      if (this.b != null)
      {
        if (this.b.equals(localUserIdentifierKey.b));
      }
      else
        do
        {
          i = 0;
          break;
        }
        while (localUserIdentifierKey.b != null);
      if (this.a == localUserIdentifierKey.a)
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.b;
      int k = 0;
      if (str != null)
        k = this.b.hashCode();
      return j + k;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserIdentifierKey
 * JD-Core Version:    0.6.0
 */