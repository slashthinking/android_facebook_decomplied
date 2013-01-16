package com.facebook.common.db;

import com.google.common.base.Preconditions;

public class Table$Column
{
  public final String a;
  public final Table.ColumnType b;
  public final boolean c;

  public Table$Column(String paramString, Table.ColumnType paramColumnType)
  {
    this(paramString, paramColumnType, false);
  }

  public Table$Column(String paramString, Table.ColumnType paramColumnType, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramString, "name of column should not be null");
    Preconditions.checkNotNull(paramColumnType, "type of column should not be null");
    this.a = paramString;
    this.b = paramColumnType;
    this.c = paramBoolean;
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.a).append(" ").append(this.b.getSqlType());
    if (this.c);
    for (String str = " PRIMARY KEY"; ; str = "")
      return str;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.db.Table.Column
 * JD-Core Version:    0.6.2
 */