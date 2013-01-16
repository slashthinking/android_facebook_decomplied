package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$ErrorDialogBuilderProvider extends AbstractProvider<ErrorDialogBuilder>
{
  private MessagesModule$ErrorDialogBuilderProvider(MessagesModule paramMessagesModule)
  {
  }

  public ErrorDialogBuilder a()
  {
    return ErrorDialogBuilder.a((Context)b(Context.class)).a(2131362339);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ErrorDialogBuilderProvider
 * JD-Core Version:    0.6.0
 */