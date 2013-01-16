package com.facebook.feed.ui.permalink;

 enum PermalinkFragment$ErrorBannerType
{
  static
  {
    COMMENT_FETCH_FAILED = new ErrorBannerType("COMMENT_FETCH_FAILED", 2);
    COMMENT_POST_FAILED = new ErrorBannerType("COMMENT_POST_FAILED", 3);
    FETCH_STORY_FAILED = new ErrorBannerType("FETCH_STORY_FAILED", 4);
    ErrorBannerType[] arrayOfErrorBannerType = new ErrorBannerType[5];
    arrayOfErrorBannerType[0] = NONE;
    arrayOfErrorBannerType[1] = NO_CONNECTION;
    arrayOfErrorBannerType[2] = COMMENT_FETCH_FAILED;
    arrayOfErrorBannerType[3] = COMMENT_POST_FAILED;
    arrayOfErrorBannerType[4] = FETCH_STORY_FAILED;
    $VALUES = arrayOfErrorBannerType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.ErrorBannerType
 * JD-Core Version:    0.6.0
 */