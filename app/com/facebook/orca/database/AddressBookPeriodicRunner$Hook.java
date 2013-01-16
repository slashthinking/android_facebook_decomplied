package com.facebook.orca.database;

import com.facebook.orca.server.AbstractOrcaServiceHandlerHook;
import java.util.concurrent.ExecutorService;

public class AddressBookPeriodicRunner$Hook extends AbstractOrcaServiceHandlerHook
{
  public AddressBookPeriodicRunner$Hook(AddressBookPeriodicRunner paramAddressBookPeriodicRunner)
  {
  }

  public void a()
  {
    AddressBookPeriodicRunner.a(this.a).submit(new AddressBookPeriodicRunner.Hook.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.AddressBookPeriodicRunner.Hook
 * JD-Core Version:    0.6.0
 */