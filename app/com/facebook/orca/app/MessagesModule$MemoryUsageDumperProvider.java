package com.facebook.orca.app;

import com.facebook.orca.debug.MemoryUsageDumper;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$MemoryUsageDumperProvider extends AbstractProvider<MemoryUsageDumper>
{
  private MessagesModule$MemoryUsageDumperProvider(MessagesModule paramMessagesModule)
  {
  }

  public MemoryUsageDumper a()
  {
    return new MemoryUsageDumper((ImageCache)b(ImageCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MemoryUsageDumperProvider
 * JD-Core Version:    0.6.0
 */