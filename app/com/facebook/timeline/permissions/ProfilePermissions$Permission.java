package com.facebook.timeline.permissions;

public enum ProfilePermissions$Permission
{
  private int mPermissionBit;

  static
  {
    CREATE_CONTENT = new Permission("CREATE_CONTENT", 2, 2);
    MODERATE_CONTENT = new Permission("MODERATE_CONTENT", 3, 3);
    CREATE_ADS = new Permission("CREATE_ADS", 4, 4);
    BASIC_ADMIN = new Permission("BASIC_ADMIN", 5, 5);
    Permission[] arrayOfPermission = new Permission[6];
    arrayOfPermission[0] = ADMINISTER;
    arrayOfPermission[1] = EDIT_PROFILE;
    arrayOfPermission[2] = CREATE_CONTENT;
    arrayOfPermission[3] = MODERATE_CONTENT;
    arrayOfPermission[4] = CREATE_ADS;
    arrayOfPermission[5] = BASIC_ADMIN;
    $VALUES = arrayOfPermission;
  }

  private ProfilePermissions$Permission(int paramInt)
  {
    this.mPermissionBit = paramInt;
  }

  public int getBit()
  {
    return this.mPermissionBit;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.permissions.ProfilePermissions.Permission
 * JD-Core Version:    0.6.0
 */