package com.google.i18n.phonenumbers;

public enum NumberParseException$ErrorType
{
  static
  {
    TOO_LONG = new ErrorType("TOO_LONG", 4);
    ErrorType[] arrayOfErrorType = new ErrorType[5];
    arrayOfErrorType[0] = INVALID_COUNTRY_CODE;
    arrayOfErrorType[1] = NOT_A_NUMBER;
    arrayOfErrorType[2] = TOO_SHORT_AFTER_IDD;
    arrayOfErrorType[3] = TOO_SHORT_NSN;
    arrayOfErrorType[4] = TOO_LONG;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.NumberParseException.ErrorType
 * JD-Core Version:    0.6.2
 */