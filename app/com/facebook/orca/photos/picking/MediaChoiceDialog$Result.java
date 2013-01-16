package com.facebook.orca.photos.picking;

public enum MediaChoiceDialog$Result
{
  static
  {
    RECORD_AUDIO = new Result("RECORD_AUDIO", 4);
    REMOVE = new Result("REMOVE", 5);
    CANCEL = new Result("CANCEL", 6);
    Result[] arrayOfResult = new Result[7];
    arrayOfResult[0] = CAMERA;
    arrayOfResult[1] = GALLERY;
    arrayOfResult[2] = IMAGE_SEARCH;
    arrayOfResult[3] = RECORD_VIDEO;
    arrayOfResult[4] = RECORD_AUDIO;
    arrayOfResult[5] = REMOVE;
    arrayOfResult[6] = CANCEL;
    $VALUES = arrayOfResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.picking.MediaChoiceDialog.Result
 * JD-Core Version:    0.6.0
 */