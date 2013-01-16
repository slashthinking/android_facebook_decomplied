package com.facebook.bookmark.service;

import com.facebook.orca.inject.AbstractProvider;

class BookmarkServiceModule$BroadcastSenderProvider extends AbstractProvider<BroadcastSender>
{
  private BookmarkServiceModule$BroadcastSenderProvider(BookmarkServiceModule paramBookmarkServiceModule)
  {
  }

  public BroadcastSender a()
  {
    return new BroadcastSender(BookmarkServiceModule.a(this.a), BookmarkServiceModule.b(this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.BookmarkServiceModule.BroadcastSenderProvider
 * JD-Core Version:    0.6.2
 */