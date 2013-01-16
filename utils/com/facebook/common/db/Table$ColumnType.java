package com.facebook.common.db;

public enum Table$ColumnType
{
  private final String mSqlType;

  static
  {
    INTEGER = new ColumnType("INTEGER", 2, "INTEGER");
    REAL = new ColumnType("REAL", 3, "REAL");
    BLOB = new ColumnType("BLOB", 4, "BLOB");
    ColumnType[] arrayOfColumnType = new ColumnType[5];
    arrayOfColumnType[0] = NULL;
    arrayOfColumnType[1] = TEXT;
    arrayOfColumnType[2] = INTEGER;
    arrayOfColumnType[3] = REAL;
    arrayOfColumnType[4] = BLOB;
  }

  private Table$ColumnType(String paramString)
  {
    this.mSqlType = paramString;
  }

  public String getSqlType()
  {
    return this.mSqlType;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.db.Table.ColumnType
 * JD-Core Version:    0.6.2
 */