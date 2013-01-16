package com.facebook.orca.app;

import com.facebook.orca.annotations.IsDeliveredReadReceiptEnabled;
import com.facebook.orca.annotations.IsLastActiveEnabled;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchThreadsFqlHelper;
import com.facebook.orca.protocol.methods.MessageDeserializer;
import com.facebook.orca.protocol.methods.ThreadSummaryDeserializer;
import com.facebook.orca.protocol.methods.UserFqlHelper;
import com.facebook.orca.users.UserSerialization;

class MessagesModule$FetchThreadsFqlHelperProvider extends AbstractProvider<FetchThreadsFqlHelper>
{
  private MessagesModule$FetchThreadsFqlHelperProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchThreadsFqlHelper a()
  {
    return new FetchThreadsFqlHelper((ThreadSummaryDeserializer)b(ThreadSummaryDeserializer.class), (UserFqlHelper)b(UserFqlHelper.class), (UserSerialization)b(UserSerialization.class), (MessageDeserializer)b(MessageDeserializer.class), a(Boolean.class, IsDeliveredReadReceiptEnabled.class), a(Boolean.class, IsLastActiveEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchThreadsFqlHelperProvider
 * JD-Core Version:    0.6.0
 */