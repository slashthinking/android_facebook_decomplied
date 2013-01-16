package com.facebook.bookmark.ipc;

import com.facebook.common.db.Table.Column;
import com.facebook.common.db.Table.ColumnType;

public final class BookmarkTable$Columns
{
  public static final Table.Column a = new Table.Column("_id", Table.ColumnType.INTEGER, true);
  public static final Table.Column b = new Table.Column("bookmark_fbid", Table.ColumnType.INTEGER);
  public static final Table.Column c = new Table.Column("bookmark_name", Table.ColumnType.TEXT);
  public static final Table.Column d = new Table.Column("bookmark_url", Table.ColumnType.TEXT);
  public static final Table.Column e = new Table.Column("bookmark_icon", Table.ColumnType.TEXT);
  public static final Table.Column f = new Table.Column("bookmark_pic", Table.ColumnType.TEXT);
  public static final Table.Column g = new Table.Column("bookmark_type", Table.ColumnType.TEXT);
  public static final Table.Column h = new Table.Column("bookmark_unread_count", Table.ColumnType.INTEGER);
  public static final Table.Column i = new Table.Column("group_id", Table.ColumnType.TEXT);
  public static final Table.Column j = new Table.Column("group_name", Table.ColumnType.TEXT);
  public static final Table.Column k = new Table.Column("group_index", Table.ColumnType.INTEGER);
  public static final Table.Column l = new Table.Column("visible_in_group", Table.ColumnType.INTEGER);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ipc.BookmarkTable.Columns
 * JD-Core Version:    0.6.2
 */