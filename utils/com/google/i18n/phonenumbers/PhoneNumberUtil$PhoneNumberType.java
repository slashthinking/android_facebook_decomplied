package com.google.i18n.phonenumbers;

public enum PhoneNumberUtil$PhoneNumberType
{
  static
  {
    FIXED_LINE_OR_MOBILE = new PhoneNumberType("FIXED_LINE_OR_MOBILE", 2);
    TOLL_FREE = new PhoneNumberType("TOLL_FREE", 3);
    PREMIUM_RATE = new PhoneNumberType("PREMIUM_RATE", 4);
    SHARED_COST = new PhoneNumberType("SHARED_COST", 5);
    VOIP = new PhoneNumberType("VOIP", 6);
    PERSONAL_NUMBER = new PhoneNumberType("PERSONAL_NUMBER", 7);
    PAGER = new PhoneNumberType("PAGER", 8);
    UAN = new PhoneNumberType("UAN", 9);
    UNKNOWN = new PhoneNumberType("UNKNOWN", 10);
    PhoneNumberType[] arrayOfPhoneNumberType = new PhoneNumberType[11];
    arrayOfPhoneNumberType[0] = FIXED_LINE;
    arrayOfPhoneNumberType[1] = MOBILE;
    arrayOfPhoneNumberType[2] = FIXED_LINE_OR_MOBILE;
    arrayOfPhoneNumberType[3] = TOLL_FREE;
    arrayOfPhoneNumberType[4] = PREMIUM_RATE;
    arrayOfPhoneNumberType[5] = SHARED_COST;
    arrayOfPhoneNumberType[6] = VOIP;
    arrayOfPhoneNumberType[7] = PERSONAL_NUMBER;
    arrayOfPhoneNumberType[8] = PAGER;
    arrayOfPhoneNumberType[9] = UAN;
    arrayOfPhoneNumberType[10] = UNKNOWN;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType
 * JD-Core Version:    0.6.2
 */