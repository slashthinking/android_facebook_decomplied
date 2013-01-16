package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.file.TempFileManager;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$TempFileManagerProvider extends AbstractProvider<TempFileManager>
{
  private MessagesModule$TempFileManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public TempFileManager a()
  {
    return new TempFileManager((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.TempFileManagerProvider
 * JD-Core Version:    0.6.0
 */