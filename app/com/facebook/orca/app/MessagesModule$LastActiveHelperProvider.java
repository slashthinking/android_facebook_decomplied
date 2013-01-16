package com.facebook.orca.app;

import android.content.res.Resources;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.LastActiveHelper;

class MessagesModule$LastActiveHelperProvider extends AbstractProvider<LastActiveHelper>
{
  private MessagesModule$LastActiveHelperProvider(MessagesModule paramMessagesModule)
  {
  }

  public LastActiveHelper a()
  {
    return new LastActiveHelper((Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.LastActiveHelperProvider
 * JD-Core Version:    0.6.0
 */