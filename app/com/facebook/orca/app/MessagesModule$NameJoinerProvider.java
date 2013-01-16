package com.facebook.orca.app;

import com.facebook.orca.common.names.NameJoiner;
import com.facebook.orca.inject.AbstractProvider;
import java.util.Locale;

class MessagesModule$NameJoinerProvider extends AbstractProvider<NameJoiner>
{
  private MessagesModule$NameJoinerProvider(MessagesModule paramMessagesModule)
  {
  }

  public NameJoiner a()
  {
    return new NameJoiner(a(Locale.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.NameJoinerProvider
 * JD-Core Version:    0.6.0
 */