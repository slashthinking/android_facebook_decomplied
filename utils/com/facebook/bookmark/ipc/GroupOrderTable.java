package com.facebook.bookmark.ipc;

import com.facebook.common.db.Table;
import com.facebook.common.db.Table.Column;
import com.google.common.collect.Lists;
import java.util.List;

public class GroupOrderTable extends Table
{
  public static final List<Table.Column> a = Lists.a(arrayOfColumn);
  public static final String[] b = a(a);

  static
  {
    Table.Column[] arrayOfColumn = new Table.Column[2];
    arrayOfColumn[0] = GroupOrderTable.Columns.a;
    arrayOfColumn[1] = GroupOrderTable.Columns.b;
  }

  public int a()
  {
    return 1;
  }

  public String b()
  {
    return "bookmark_group_order";
  }

  public List<Table.Column> c()
  {
    return a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ipc.GroupOrderTable
 * JD-Core Version:    0.6.2
 */