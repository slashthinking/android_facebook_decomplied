package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.auth.AuthDataStore;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.config.PlatformAppHttpConfig;
import com.facebook.orca.file.TempFileManager;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$AttachmentDataFactoryProvider extends AbstractProvider<AttachmentDataFactory>
{
  private MessagesModule$AttachmentDataFactoryProvider(MessagesModule paramMessagesModule)
  {
  }

  public AttachmentDataFactory a()
  {
    return new AttachmentDataFactory(a(PlatformAppHttpConfig.class), (AuthDataStore)b(MeUserAuthDataStore.class), (Context)b(Context.class, FromApplication.class), (TempFileManager)b(TempFileManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AttachmentDataFactoryProvider
 * JD-Core Version:    0.6.0
 */