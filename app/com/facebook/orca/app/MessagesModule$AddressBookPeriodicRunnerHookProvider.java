package com.facebook.orca.app;

import com.facebook.orca.database.AddressBookPeriodicRunner;
import com.facebook.orca.database.AddressBookPeriodicRunner.Hook;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$AddressBookPeriodicRunnerHookProvider extends AbstractProvider<AddressBookPeriodicRunner.Hook>
{
  private MessagesModule$AddressBookPeriodicRunnerHookProvider(MessagesModule paramMessagesModule)
  {
  }

  public AddressBookPeriodicRunner.Hook a()
  {
    return ((AddressBookPeriodicRunner)b(AddressBookPeriodicRunner.class)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AddressBookPeriodicRunnerHookProvider
 * JD-Core Version:    0.6.0
 */