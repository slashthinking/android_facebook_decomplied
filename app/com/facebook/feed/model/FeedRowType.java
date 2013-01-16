package com.facebook.feed.model;

public enum FeedRowType
{
  static
  {
    STORY_BASE = new FeedRowType("STORY_BASE", 1);
    STORY_EDGE_WIDE = new FeedRowType("STORY_EDGE_WIDE", 2);
    STORY_EDGE_NARROW_OR_AGG = new FeedRowType("STORY_EDGE_NARROW_OR_AGG", 3);
    APP_AD = new FeedRowType("APP_AD", 4);
    SCISSOR = new FeedRowType("SCISSOR", 5);
    PYMK = new FeedRowType("PYMK", 6);
    PYML = new FeedRowType("PYML", 7);
    CELEBRATIONS = new FeedRowType("CELEBRATIONS", 8);
    FIND_FRIENDS = new FeedRowType("FIND_FRIENDS", 9);
    LOAD_MORE = new FeedRowType("LOAD_MORE", 10);
    END_OF_FEED = new FeedRowType("END_OF_FEED", 11);
    MEGAPHONE = new FeedRowType("MEGAPHONE", 12);
    NEW_FEED_UNIT = new FeedRowType("NEW_FEED_UNIT", 13);
    UNKNOWN = new FeedRowType("UNKNOWN", 14);
    FeedRowType[] arrayOfFeedRowType = new FeedRowType[15];
    arrayOfFeedRowType[0] = TOP_PADDING;
    arrayOfFeedRowType[1] = STORY_BASE;
    arrayOfFeedRowType[2] = STORY_EDGE_WIDE;
    arrayOfFeedRowType[3] = STORY_EDGE_NARROW_OR_AGG;
    arrayOfFeedRowType[4] = APP_AD;
    arrayOfFeedRowType[5] = SCISSOR;
    arrayOfFeedRowType[6] = PYMK;
    arrayOfFeedRowType[7] = PYML;
    arrayOfFeedRowType[8] = CELEBRATIONS;
    arrayOfFeedRowType[9] = FIND_FRIENDS;
    arrayOfFeedRowType[10] = LOAD_MORE;
    arrayOfFeedRowType[11] = END_OF_FEED;
    arrayOfFeedRowType[12] = MEGAPHONE;
    arrayOfFeedRowType[13] = NEW_FEED_UNIT;
    arrayOfFeedRowType[14] = UNKNOWN;
    $VALUES = arrayOfFeedRowType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.model.FeedRowType
 * JD-Core Version:    0.6.0
 */