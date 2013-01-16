package com.facebook.orca.protocol.base;

public enum ApiResponseType
{
  static
  {
    JSON = new ApiResponseType("JSON", 1);
    JSONPARSER = new ApiResponseType("JSONPARSER", 2);
    ENTITY = new ApiResponseType("ENTITY", 3);
    ApiResponseType[] arrayOfApiResponseType = new ApiResponseType[4];
    arrayOfApiResponseType[0] = STRING;
    arrayOfApiResponseType[1] = JSON;
    arrayOfApiResponseType[2] = JSONPARSER;
    arrayOfApiResponseType[3] = ENTITY;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ApiResponseType
 * JD-Core Version:    0.6.2
 */