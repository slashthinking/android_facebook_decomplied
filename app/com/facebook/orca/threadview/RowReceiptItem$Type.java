package com.facebook.orca.threadview;

public enum RowReceiptItem$Type
{
  static
  {
    READ = new Type("READ", 1);
    DELIVERED = new Type("DELIVERED", 2);
    GROUP_READ = new Type("GROUP_READ", 3);
    Type[] arrayOfType = new Type[4];
    arrayOfType[0] = SENT;
    arrayOfType[1] = READ;
    arrayOfType[2] = DELIVERED;
    arrayOfType[3] = GROUP_READ;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.RowReceiptItem.Type
 * JD-Core Version:    0.6.0
 */