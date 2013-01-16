package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.photos.picking.OldPhotoCleaner;

class MessagesModule$OldPhotoCleanerProvider extends AbstractProvider<OldPhotoCleaner>
{
  private MessagesModule$OldPhotoCleanerProvider(MessagesModule paramMessagesModule)
  {
  }

  public OldPhotoCleaner a()
  {
    return new OldPhotoCleaner(MessagesModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OldPhotoCleanerProvider
 * JD-Core Version:    0.6.0
 */