package com.facebook.orca.app;

import android.content.res.Resources;
import com.facebook.common.util.FileSizeUtil;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$FileSizeUtilProvider extends AbstractProvider<FileSizeUtil>
{
  private MessagesModule$FileSizeUtilProvider(MessagesModule paramMessagesModule)
  {
  }

  public FileSizeUtil a()
  {
    return new FileSizeUtil((Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FileSizeUtilProvider
 * JD-Core Version:    0.6.0
 */