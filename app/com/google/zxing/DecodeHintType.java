package com.google.zxing;

public enum DecodeHintType
{
  static
  {
    POSSIBLE_FORMATS = new DecodeHintType("POSSIBLE_FORMATS", 2);
    TRY_HARDER = new DecodeHintType("TRY_HARDER", 3);
    CHARACTER_SET = new DecodeHintType("CHARACTER_SET", 4);
    ALLOWED_LENGTHS = new DecodeHintType("ALLOWED_LENGTHS", 5);
    ASSUME_CODE_39_CHECK_DIGIT = new DecodeHintType("ASSUME_CODE_39_CHECK_DIGIT", 6);
    NEED_RESULT_POINT_CALLBACK = new DecodeHintType("NEED_RESULT_POINT_CALLBACK", 7);
    DecodeHintType[] arrayOfDecodeHintType = new DecodeHintType[8];
    arrayOfDecodeHintType[0] = OTHER;
    arrayOfDecodeHintType[1] = PURE_BARCODE;
    arrayOfDecodeHintType[2] = POSSIBLE_FORMATS;
    arrayOfDecodeHintType[3] = TRY_HARDER;
    arrayOfDecodeHintType[4] = CHARACTER_SET;
    arrayOfDecodeHintType[5] = ALLOWED_LENGTHS;
    arrayOfDecodeHintType[6] = ASSUME_CODE_39_CHECK_DIGIT;
    arrayOfDecodeHintType[7] = NEED_RESULT_POINT_CALLBACK;
    $VALUES = arrayOfDecodeHintType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.DecodeHintType
 * JD-Core Version:    0.6.0
 */