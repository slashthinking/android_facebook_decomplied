package com.facebook.orca.app;

import com.facebook.orca.database.DbClock;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$DbClockProvider extends AbstractProvider<DbClock>
{
  private MessagesModule$DbClockProvider(MessagesModule paramMessagesModule)
  {
  }

  public DbClock a()
  {
    return new DbClock();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DbClockProvider
 * JD-Core Version:    0.6.0
 */