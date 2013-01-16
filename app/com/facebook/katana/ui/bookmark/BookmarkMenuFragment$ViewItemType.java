package com.facebook.katana.ui.bookmark;

import com.facebook.bookmark.ui.BookmarkAdapter.RowType;

 enum BookmarkMenuFragment$ViewItemType
  implements BookmarkAdapter.RowType
{
  static
  {
    NewsFeed = new ViewItemType("NewsFeed", 1);
    Bookmark = new ViewItemType("Bookmark", 2);
    Divider = new ViewItemType("Divider", 3);
    SeeAll = new ViewItemType("SeeAll", 4);
    EditFavorites = new ViewItemType("EditFavorites", 5);
    IconLable = new ViewItemType("IconLable", 6);
    Loader = new ViewItemType("Loader", 7);
    ViewItemType[] arrayOfViewItemType = new ViewItemType[8];
    arrayOfViewItemType[0] = Profile;
    arrayOfViewItemType[1] = NewsFeed;
    arrayOfViewItemType[2] = Bookmark;
    arrayOfViewItemType[3] = Divider;
    arrayOfViewItemType[4] = SeeAll;
    arrayOfViewItemType[5] = EditFavorites;
    arrayOfViewItemType[6] = IconLable;
    arrayOfViewItemType[7] = Loader;
    $VALUES = arrayOfViewItemType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkMenuFragment.ViewItemType
 * JD-Core Version:    0.6.0
 */