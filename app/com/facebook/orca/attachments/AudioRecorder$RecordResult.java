package com.facebook.orca.attachments;

 enum AudioRecorder$RecordResult
{
  static
  {
    ERROR = new RecordResult("ERROR", 1);
    INTERRUPTED = new RecordResult("INTERRUPTED", 2);
    RecordResult[] arrayOfRecordResult = new RecordResult[3];
    arrayOfRecordResult[0] = SUCCESS;
    arrayOfRecordResult[1] = ERROR;
    arrayOfRecordResult[2] = INTERRUPTED;
    $VALUES = arrayOfRecordResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.AudioRecorder.RecordResult
 * JD-Core Version:    0.6.0
 */