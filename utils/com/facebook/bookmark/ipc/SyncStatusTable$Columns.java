package com.facebook.bookmark.ipc;

import com.facebook.common.db.Table.Column;
import com.facebook.common.db.Table.ColumnType;

public final class SyncStatusTable$Columns
{
  public static final Table.Column a = new Table.Column("last_sync_timestamp", Table.ColumnType.INTEGER);
  public static final Table.Column b = new Table.Column("local_update_timestamp", Table.ColumnType.INTEGER);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ipc.SyncStatusTable.Columns
 * JD-Core Version:    0.6.2
 */