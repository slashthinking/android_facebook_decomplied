package com.facebook.feed.ui;

public enum FeedImageLoader$FeedImageType
{
  static
  {
    PagesYouMayLike = new FeedImageType("PagesYouMayLike", 5);
    Share = new FeedImageType("Share", 6);
    Video = new FeedImageType("Video", 7);
    FeedImageType[] arrayOfFeedImageType = new FeedImageType[8];
    arrayOfFeedImageType[0] = AddFriend;
    arrayOfFeedImageType[1] = Album;
    arrayOfFeedImageType[2] = AvatarList;
    arrayOfFeedImageType[3] = Celebrations;
    arrayOfFeedImageType[4] = Photo;
    arrayOfFeedImageType[5] = PagesYouMayLike;
    arrayOfFeedImageType[6] = Share;
    arrayOfFeedImageType[7] = Video;
    $VALUES = arrayOfFeedImageType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FeedImageLoader.FeedImageType
 * JD-Core Version:    0.6.0
 */