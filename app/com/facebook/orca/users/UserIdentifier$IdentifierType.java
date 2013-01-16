package com.facebook.orca.users;

public enum UserIdentifier$IdentifierType
{
  static
  {
    FBID = new IdentifierType("FBID", 2);
    IdentifierType[] arrayOfIdentifierType = new IdentifierType[3];
    arrayOfIdentifierType[0] = EMAIL;
    arrayOfIdentifierType[1] = PHONE;
    arrayOfIdentifierType[2] = FBID;
    $VALUES = arrayOfIdentifierType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserIdentifier.IdentifierType
 * JD-Core Version:    0.6.0
 */