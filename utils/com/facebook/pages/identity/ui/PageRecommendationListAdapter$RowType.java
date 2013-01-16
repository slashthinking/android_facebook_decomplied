package com.facebook.pages.identity.ui;

 enum PageRecommendationListAdapter$RowType
{
  static
  {
    FRIENDS_RATING_HEADING = new RowType("FRIENDS_RATING_HEADING", 2);
    FRIENDS_RATING = new RowType("FRIENDS_RATING", 3);
    NONFRIENDS_COMMENDATION_HEADING = new RowType("NONFRIENDS_COMMENDATION_HEADING", 4);
    NONFRIENDS_RECOMMENDATION = new RowType("NONFRIENDS_RECOMMENDATION", 5);
    RowType[] arrayOfRowType = new RowType[6];
    arrayOfRowType[0] = FRIENDS_COMMENDATION_HEADING;
    arrayOfRowType[1] = FRIENDS_RECOMMENDATION;
    arrayOfRowType[2] = FRIENDS_RATING_HEADING;
    arrayOfRowType[3] = FRIENDS_RATING;
    arrayOfRowType[4] = NONFRIENDS_COMMENDATION_HEADING;
    arrayOfRowType[5] = NONFRIENDS_RECOMMENDATION;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageRecommendationListAdapter.RowType
 * JD-Core Version:    0.6.2
 */