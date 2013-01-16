package com.facebook.contacts.server;

public enum UploadBulkContactChange$Type
{
  static
  {
    DELETE = new Type("DELETE", 2);
    Type[] arrayOfType = new Type[3];
    arrayOfType[0] = ADD;
    arrayOfType[1] = MODIFY;
    arrayOfType[2] = DELETE;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactChange.Type
 * JD-Core Version:    0.6.0
 */