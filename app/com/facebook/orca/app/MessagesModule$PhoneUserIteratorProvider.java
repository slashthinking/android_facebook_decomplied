package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.PhoneUserIterator;

class MessagesModule$PhoneUserIteratorProvider extends AbstractProvider<PhoneUserIterator>
{
  private MessagesModule$PhoneUserIteratorProvider(MessagesModule paramMessagesModule)
  {
  }

  public PhoneUserIterator a()
  {
    return new PhoneUserIterator(MessagesModule.a(this.a).getContentResolver(), (OrcaPhoneNumberUtil)b(OrcaPhoneNumberUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.PhoneUserIteratorProvider
 * JD-Core Version:    0.6.0
 */