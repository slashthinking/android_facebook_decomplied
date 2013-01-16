package com.facebook.contacts.server;

public enum UploadBulkContactChangeResult$Type
{
  static
  {
    NONE = new Type("NONE", 3);
    Type[] arrayOfType = new Type[4];
    arrayOfType[0] = ADD;
    arrayOfType[1] = MODIFY;
    arrayOfType[2] = REMOVE;
    arrayOfType[3] = NONE;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactChangeResult.Type
 * JD-Core Version:    0.6.0
 */