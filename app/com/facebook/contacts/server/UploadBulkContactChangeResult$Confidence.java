package com.facebook.contacts.server;

public enum UploadBulkContactChangeResult$Confidence
{
  static
  {
    LOW = new Confidence("LOW", 2);
    VERY_LOW = new Confidence("VERY_LOW", 3);
    UNKNOWN = new Confidence("UNKNOWN", 4);
    Confidence[] arrayOfConfidence = new Confidence[5];
    arrayOfConfidence[0] = HIGH;
    arrayOfConfidence[1] = MEDIUM;
    arrayOfConfidence[2] = LOW;
    arrayOfConfidence[3] = VERY_LOW;
    arrayOfConfidence[4] = UNKNOWN;
    $VALUES = arrayOfConfidence;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactChangeResult.Confidence
 * JD-Core Version:    0.6.0
 */