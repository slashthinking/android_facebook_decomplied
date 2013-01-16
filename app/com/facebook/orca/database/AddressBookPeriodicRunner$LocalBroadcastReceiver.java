package com.facebook.orca.database;

import com.facebook.content.SecureBroadcastReceiver;

public class AddressBookPeriodicRunner$LocalBroadcastReceiver extends SecureBroadcastReceiver
{
  public AddressBookPeriodicRunner$LocalBroadcastReceiver()
  {
    super("com.facebook.orca.database.ACTION_ALARM", new AddressBookPeriodicRunner.AlarmActionReceiver());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.AddressBookPeriodicRunner.LocalBroadcastReceiver
 * JD-Core Version:    0.6.0
 */