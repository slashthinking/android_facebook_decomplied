package com.facebook.orca.database;

 enum AddressBookPeriodicRunner$DownloadOrder
{
  static
  {
    FRIENDS_ONLY = new DownloadOrder("FRIENDS_ONLY", 2);
    DownloadOrder[] arrayOfDownloadOrder = new DownloadOrder[3];
    arrayOfDownloadOrder[0] = CONTACTS_THEN_FRIENDS;
    arrayOfDownloadOrder[1] = FRIENDS_THEN_CONTACTS;
    arrayOfDownloadOrder[2] = FRIENDS_ONLY;
    $VALUES = arrayOfDownloadOrder;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.AddressBookPeriodicRunner.DownloadOrder
 * JD-Core Version:    0.6.0
 */