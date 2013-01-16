package com.facebook.graphql.model;

public enum TimelineAppSection$AppSectionType
{
  static
  {
    ABOUT = new AppSectionType("ABOUT", 1);
    FRIENDS = new AppSectionType("FRIENDS", 2);
    LIKES = new AppSectionType("LIKES", 3);
    SUBSCRIPTIONS = new AppSectionType("SUBSCRIPTIONS", 4);
    PHOTOS = new AppSectionType("PHOTOS", 5);
    MAP = new AppSectionType("MAP", 6);
    SUBSCRIBERS = new AppSectionType("SUBSCRIBERS", 7);
    PAGE_LIKES = new AppSectionType("PAGE_LIKES", 8);
    UNKNOWN = new AppSectionType("UNKNOWN", 9);
    AppSectionType[] arrayOfAppSectionType = new AppSectionType[10];
    arrayOfAppSectionType[0] = APP;
    arrayOfAppSectionType[1] = ABOUT;
    arrayOfAppSectionType[2] = FRIENDS;
    arrayOfAppSectionType[3] = LIKES;
    arrayOfAppSectionType[4] = SUBSCRIPTIONS;
    arrayOfAppSectionType[5] = PHOTOS;
    arrayOfAppSectionType[6] = MAP;
    arrayOfAppSectionType[7] = SUBSCRIBERS;
    arrayOfAppSectionType[8] = PAGE_LIKES;
    arrayOfAppSectionType[9] = UNKNOWN;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.TimelineAppSection.AppSectionType
 * JD-Core Version:    0.6.2
 */