package com.facebook.feed.ui.permalink;

 enum PermalinkAdapter$PermalinkViewTypes
{
  static
  {
    LIKES = new PermalinkViewTypes("LIKES", 1);
    MORE_COMMENTS = new PermalinkViewTypes("MORE_COMMENTS", 2);
    COMMENT_MIDDLE = new PermalinkViewTypes("COMMENT_MIDDLE", 3);
    COMMENT_LAST = new PermalinkViewTypes("COMMENT_LAST", 4);
    PermalinkViewTypes[] arrayOfPermalinkViewTypes = new PermalinkViewTypes[5];
    arrayOfPermalinkViewTypes[0] = STORY;
    arrayOfPermalinkViewTypes[1] = LIKES;
    arrayOfPermalinkViewTypes[2] = MORE_COMMENTS;
    arrayOfPermalinkViewTypes[3] = COMMENT_MIDDLE;
    arrayOfPermalinkViewTypes[4] = COMMENT_LAST;
    $VALUES = arrayOfPermalinkViewTypes;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkAdapter.PermalinkViewTypes
 * JD-Core Version:    0.6.0
 */