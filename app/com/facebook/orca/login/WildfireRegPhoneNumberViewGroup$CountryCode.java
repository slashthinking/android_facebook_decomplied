package com.facebook.orca.login;

class WildfireRegPhoneNumberViewGroup$CountryCode
  implements Comparable<CountryCode>
{
  final String a;
  final String b;
  final String c;

  public WildfireRegPhoneNumberViewGroup$CountryCode(WildfireRegPhoneNumberViewGroup paramWildfireRegPhoneNumberViewGroup, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }

  public int a(CountryCode paramCountryCode)
  {
    return toString().compareTo(paramCountryCode.toString());
  }

  public String toString()
  {
    return this.c + " (" + this.b + ")";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegPhoneNumberViewGroup.CountryCode
 * JD-Core Version:    0.6.0
 */