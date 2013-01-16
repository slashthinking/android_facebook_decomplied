package com.google.i18n.phonenumbers;

public enum Phonenumber$PhoneNumber$CountryCodeSource
{
  static
  {
    FROM_NUMBER_WITH_IDD = new CountryCodeSource("FROM_NUMBER_WITH_IDD", 1);
    FROM_NUMBER_WITHOUT_PLUS_SIGN = new CountryCodeSource("FROM_NUMBER_WITHOUT_PLUS_SIGN", 2);
    FROM_DEFAULT_COUNTRY = new CountryCodeSource("FROM_DEFAULT_COUNTRY", 3);
    CountryCodeSource[] arrayOfCountryCodeSource = new CountryCodeSource[4];
    arrayOfCountryCodeSource[0] = FROM_NUMBER_WITH_PLUS_SIGN;
    arrayOfCountryCodeSource[1] = FROM_NUMBER_WITH_IDD;
    arrayOfCountryCodeSource[2] = FROM_NUMBER_WITHOUT_PLUS_SIGN;
    arrayOfCountryCodeSource[3] = FROM_DEFAULT_COUNTRY;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource
 * JD-Core Version:    0.6.2
 */