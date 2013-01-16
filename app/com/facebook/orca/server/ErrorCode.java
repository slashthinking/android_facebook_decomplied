package com.facebook.orca.server;

public enum ErrorCode
{
  static
  {
    API_ERROR = new ErrorCode("API_ERROR", 1);
    HTTP_400_AUTHENTICATION = new ErrorCode("HTTP_400_AUTHENTICATION", 2);
    HTTP_400_OTHER = new ErrorCode("HTTP_400_OTHER", 3);
    HTTP_500_CLASS = new ErrorCode("HTTP_500_CLASS", 4);
    CONNECTION_FAILURE = new ErrorCode("CONNECTION_FAILURE", 5);
    ORCA_SERVICE_UNKNOWN_OPERATION = new ErrorCode("ORCA_SERVICE_UNKNOWN_OPERATION", 6);
    ORCA_SERVICE_IPC_FAILURE = new ErrorCode("ORCA_SERVICE_IPC_FAILURE", 7);
    OTHER = new ErrorCode("OTHER", 8);
    ErrorCode[] arrayOfErrorCode = new ErrorCode[9];
    arrayOfErrorCode[0] = NO_ERROR;
    arrayOfErrorCode[1] = API_ERROR;
    arrayOfErrorCode[2] = HTTP_400_AUTHENTICATION;
    arrayOfErrorCode[3] = HTTP_400_OTHER;
    arrayOfErrorCode[4] = HTTP_500_CLASS;
    arrayOfErrorCode[5] = CONNECTION_FAILURE;
    arrayOfErrorCode[6] = ORCA_SERVICE_UNKNOWN_OPERATION;
    arrayOfErrorCode[7] = ORCA_SERVICE_IPC_FAILURE;
    arrayOfErrorCode[8] = OTHER;
    $VALUES = arrayOfErrorCode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ErrorCode
 * JD-Core Version:    0.6.0
 */