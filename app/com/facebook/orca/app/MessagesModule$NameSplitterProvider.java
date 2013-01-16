package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.common.names.NameSplitter;
import com.facebook.orca.inject.AbstractProvider;
import java.util.Locale;

class MessagesModule$NameSplitterProvider extends AbstractProvider<NameSplitter>
{
  private MessagesModule$NameSplitterProvider(MessagesModule paramMessagesModule)
  {
  }

  public NameSplitter a()
  {
    return new NameSplitter(MessagesModule.a(this.a).getString(2131362746), MessagesModule.a(this.a).getString(2131362748), MessagesModule.a(this.a).getString(2131362747), MessagesModule.a(this.a).getString(2131362749), Locale.getDefault());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.NameSplitterProvider
 * JD-Core Version:    0.6.0
 */