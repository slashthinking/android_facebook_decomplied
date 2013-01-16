package com.facebook.orca.photos.picking;

public enum MediaChoiceDialog$ButtonOption
{
  private final int buttonId;
  private final MediaChoiceDialog.Result result;

  static
  {
    RECORD_AUDIO = new ButtonOption("RECORD_AUDIO", 4, 2131297334, MediaChoiceDialog.Result.RECORD_AUDIO);
    REMOVE = new ButtonOption("REMOVE", 5, 2131297335, MediaChoiceDialog.Result.REMOVE);
    ButtonOption[] arrayOfButtonOption = new ButtonOption[6];
    arrayOfButtonOption[0] = CAMERA;
    arrayOfButtonOption[1] = GALLERY;
    arrayOfButtonOption[2] = IMAGE_SEARCH;
    arrayOfButtonOption[3] = RECORD_VIDEO;
    arrayOfButtonOption[4] = RECORD_AUDIO;
    arrayOfButtonOption[5] = REMOVE;
    $VALUES = arrayOfButtonOption;
  }

  private MediaChoiceDialog$ButtonOption(int paramInt, MediaChoiceDialog.Result paramResult)
  {
    this.buttonId = paramInt;
    this.result = paramResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.picking.MediaChoiceDialog.ButtonOption
 * JD-Core Version:    0.6.0
 */