package com.facebook.orca.contacts.upload;

public enum ContactsUploadState$Status
{
  static
  {
    RUNNING = new Status("RUNNING", 2);
    SUCCEEDED = new Status("SUCCEEDED", 3);
    FAILED = new Status("FAILED", 4);
    Status[] arrayOfStatus = new Status[5];
    arrayOfStatus[0] = NOT_STARTED;
    arrayOfStatus[1] = STARTED;
    arrayOfStatus[2] = RUNNING;
    arrayOfStatus[3] = SUCCEEDED;
    arrayOfStatus[4] = FAILED;
    $VALUES = arrayOfStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.upload.ContactsUploadState.Status
 * JD-Core Version:    0.6.0
 */