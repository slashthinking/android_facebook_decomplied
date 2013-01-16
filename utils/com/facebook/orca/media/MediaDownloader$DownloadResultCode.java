package com.facebook.orca.media;

public enum MediaDownloader$DownloadResultCode
{
  static
  {
    IO_EXCEPTION = new DownloadResultCode("IO_EXCEPTION", 1);
    DECODE_ERROR = new DownloadResultCode("DECODE_ERROR", 2);
    NOT_FOUND = new DownloadResultCode("NOT_FOUND", 3);
    UNSUPPORTED_URI = new DownloadResultCode("UNSUPPORTED_URI", 4);
    FORBIDDEN = new DownloadResultCode("FORBIDDEN", 5);
    OTHER = new DownloadResultCode("OTHER", 6);
    DownloadResultCode[] arrayOfDownloadResultCode = new DownloadResultCode[7];
    arrayOfDownloadResultCode[0] = SUCCESS;
    arrayOfDownloadResultCode[1] = IO_EXCEPTION;
    arrayOfDownloadResultCode[2] = DECODE_ERROR;
    arrayOfDownloadResultCode[3] = NOT_FOUND;
    arrayOfDownloadResultCode[4] = UNSUPPORTED_URI;
    arrayOfDownloadResultCode[5] = FORBIDDEN;
    arrayOfDownloadResultCode[6] = OTHER;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaDownloader.DownloadResultCode
 * JD-Core Version:    0.6.2
 */