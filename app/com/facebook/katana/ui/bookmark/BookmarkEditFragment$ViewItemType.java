package com.facebook.katana.ui.bookmark;

import com.facebook.bookmark.ui.BookmarkAdapter.RowType;

 enum BookmarkEditFragment$ViewItemType
  implements BookmarkAdapter.RowType
{
  static
  {
    Editable = new ViewItemType("Editable", 1);
    Divider = new ViewItemType("Divider", 2);
    ViewItemType[] arrayOfViewItemType = new ViewItemType[3];
    arrayOfViewItemType[0] = Pinned;
    arrayOfViewItemType[1] = Editable;
    arrayOfViewItemType[2] = Divider;
    $VALUES = arrayOfViewItemType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkEditFragment.ViewItemType
 * JD-Core Version:    0.6.0
 */