package com.facebook.katana.activity.media;

public enum PendingUploadActivity$UploadStatus
{
  static
  {
    CANCELED = new UploadStatus("CANCELED", 1);
    SUCCESS = new UploadStatus("SUCCESS", 2);
    ERROR = new UploadStatus("ERROR", 3);
    UploadStatus[] arrayOfUploadStatus = new UploadStatus[4];
    arrayOfUploadStatus[0] = IN_PROGRESS;
    arrayOfUploadStatus[1] = CANCELED;
    arrayOfUploadStatus[2] = SUCCESS;
    arrayOfUploadStatus[3] = ERROR;
    $VALUES = arrayOfUploadStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PendingUploadActivity.UploadStatus
 * JD-Core Version:    0.6.0
 */