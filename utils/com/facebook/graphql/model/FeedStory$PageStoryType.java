package com.facebook.graphql.model;

public enum FeedStory$PageStoryType
{
  static
  {
    GROUPER = new PageStoryType("GROUPER", 1);
    OFFER = new PageStoryType("OFFER", 2);
    GROUPER_WITH_OFFER = new PageStoryType("GROUPER_WITH_OFFER", 3);
    GROUPER_ATTACHED_STORY = new PageStoryType("GROUPER_ATTACHED_STORY", 4);
    PAGE_LIKE = new PageStoryType("PAGE_LIKE", 5);
    NCPP = new PageStoryType("NCPP", 6);
    OTHER = new PageStoryType("OTHER", 7);
    PageStoryType[] arrayOfPageStoryType = new PageStoryType[8];
    arrayOfPageStoryType[0] = UNSET;
    arrayOfPageStoryType[1] = GROUPER;
    arrayOfPageStoryType[2] = OFFER;
    arrayOfPageStoryType[3] = GROUPER_WITH_OFFER;
    arrayOfPageStoryType[4] = GROUPER_ATTACHED_STORY;
    arrayOfPageStoryType[5] = PAGE_LIKE;
    arrayOfPageStoryType[6] = NCPP;
    arrayOfPageStoryType[7] = OTHER;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStory.PageStoryType
 * JD-Core Version:    0.6.2
 */