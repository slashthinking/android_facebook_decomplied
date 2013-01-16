package com.facebook.orca.app;

import android.content.Context;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.common.dialogs.ErrorMessageGenerator;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$ErrorMessageGeneratorProvider extends AbstractProvider<ErrorMessageGenerator>
{
  private MessagesModule$ErrorMessageGeneratorProvider(MessagesModule paramMessagesModule)
  {
  }

  public ErrorMessageGenerator a()
  {
    return new ErrorMessageGenerator((Context)b(Context.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ErrorMessageGeneratorProvider
 * JD-Core Version:    0.6.0
 */