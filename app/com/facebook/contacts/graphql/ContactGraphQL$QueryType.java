package com.facebook.contacts.graphql;

public enum ContactGraphQL$QueryType
{
  static
  {
    DELTA = new QueryType("DELTA", 1);
    QueryType[] arrayOfQueryType = new QueryType[2];
    arrayOfQueryType[0] = FULL;
    arrayOfQueryType[1] = DELTA;
    $VALUES = arrayOfQueryType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.graphql.ContactGraphQL.QueryType
 * JD-Core Version:    0.6.0
 */