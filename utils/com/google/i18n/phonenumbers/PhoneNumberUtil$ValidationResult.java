package com.google.i18n.phonenumbers;

public enum PhoneNumberUtil$ValidationResult
{
  static
  {
    INVALID_COUNTRY_CODE = new ValidationResult("INVALID_COUNTRY_CODE", 1);
    TOO_SHORT = new ValidationResult("TOO_SHORT", 2);
    TOO_LONG = new ValidationResult("TOO_LONG", 3);
    ValidationResult[] arrayOfValidationResult = new ValidationResult[4];
    arrayOfValidationResult[0] = IS_POSSIBLE;
    arrayOfValidationResult[1] = INVALID_COUNTRY_CODE;
    arrayOfValidationResult[2] = TOO_SHORT;
    arrayOfValidationResult[3] = TOO_LONG;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult
 * JD-Core Version:    0.6.2
 */