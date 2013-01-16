package com.facebook.feed.module;

import com.facebook.feed.photos.AlbumIndexCache;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$AlbumIndexCacheProvider extends AbstractProvider<AlbumIndexCache>
{
  private NewsFeedModule$AlbumIndexCacheProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public AlbumIndexCache a()
  {
    return new AlbumIndexCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.AlbumIndexCacheProvider
 * JD-Core Version:    0.6.0
 */