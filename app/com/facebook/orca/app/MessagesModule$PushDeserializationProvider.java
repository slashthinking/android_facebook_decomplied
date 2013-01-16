package com.facebook.orca.app;

import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.database.DbClock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.location.CoordinatesDeserializer;
import com.facebook.orca.protocol.methods.SourceDeserializer;
import com.facebook.orca.push.common.PushDeserialization;
import com.facebook.orca.sms.MmsSmsUserUtils;
import com.facebook.orca.sms.SmsContentResolverHandler;
import com.facebook.orca.users.User;

class MessagesModule$PushDeserializationProvider extends AbstractProvider<PushDeserialization>
{
  private MessagesModule$PushDeserializationProvider(MessagesModule paramMessagesModule)
  {
  }

  public PushDeserialization a()
  {
    return new PushDeserialization(a(User.class, MeUser.class), (CoordinatesDeserializer)b(CoordinatesDeserializer.class), (SourceDeserializer)b(SourceDeserializer.class), (Clock)b(DbClock.class), (SmsContentResolverHandler)b(SmsContentResolverHandler.class), (MmsSmsUserUtils)b(MmsSmsUserUtils.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.PushDeserializationProvider
 * JD-Core Version:    0.6.0
 */