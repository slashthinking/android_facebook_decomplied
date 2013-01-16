package com.google.i18n.phonenumbers;

import java.io.Serializable;

public class Phonenumber$PhoneNumber
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Phonenumber.PhoneNumber.CountryCodeSource countryCodeSource_ = Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
  private int countryCode_ = 0;
  private String extension_ = "";
  private boolean hasCountryCode;
  private boolean hasCountryCodeSource;
  private boolean hasExtension;
  private boolean hasItalianLeadingZero;
  private boolean hasNationalNumber;
  private boolean hasPreferredDomesticCarrierCode;
  private boolean hasRawInput;
  private boolean italianLeadingZero_ = false;
  private long nationalNumber_ = 0L;
  private String preferredDomesticCarrierCode_ = "";
  private String rawInput_ = "";

  public PhoneNumber clearCountryCodeSource()
  {
    this.hasCountryCodeSource = false;
    this.countryCodeSource_ = Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
    return this;
  }

  public PhoneNumber clearExtension()
  {
    this.hasExtension = false;
    this.extension_ = "";
    return this;
  }

  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof PhoneNumber)) && (exactlySameAs((PhoneNumber)paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean exactlySameAs(PhoneNumber paramPhoneNumber)
  {
    boolean bool = true;
    if (paramPhoneNumber == null);
    for (bool = false; ; bool = false)
      do
        return bool;
      while ((this == paramPhoneNumber) || ((this.countryCode_ == paramPhoneNumber.countryCode_) && (this.nationalNumber_ == paramPhoneNumber.nationalNumber_) && (this.extension_.equals(paramPhoneNumber.extension_)) && (this.italianLeadingZero_ == paramPhoneNumber.italianLeadingZero_) && (this.rawInput_.equals(paramPhoneNumber.rawInput_)) && (this.countryCodeSource_ == paramPhoneNumber.countryCodeSource_) && (this.preferredDomesticCarrierCode_.equals(paramPhoneNumber.preferredDomesticCarrierCode_)) && (hasPreferredDomesticCarrierCode() == paramPhoneNumber.hasPreferredDomesticCarrierCode())));
  }

  public int getCountryCode()
  {
    return this.countryCode_;
  }

  public Phonenumber.PhoneNumber.CountryCodeSource getCountryCodeSource()
  {
    return this.countryCodeSource_;
  }

  public String getExtension()
  {
    return this.extension_;
  }

  public long getNationalNumber()
  {
    return this.nationalNumber_;
  }

  public String getPreferredDomesticCarrierCode()
  {
    return this.preferredDomesticCarrierCode_;
  }

  public String getRawInput()
  {
    return this.rawInput_;
  }

  public boolean hasCountryCode()
  {
    return this.hasCountryCode;
  }

  public boolean hasCountryCodeSource()
  {
    return this.hasCountryCodeSource;
  }

  public boolean hasExtension()
  {
    return this.hasExtension;
  }

  public boolean hasItalianLeadingZero()
  {
    return this.hasItalianLeadingZero;
  }

  public boolean hasNationalNumber()
  {
    return this.hasNationalNumber;
  }

  public boolean hasPreferredDomesticCarrierCode()
  {
    return this.hasPreferredDomesticCarrierCode;
  }

  public boolean hasRawInput()
  {
    return this.hasRawInput;
  }

  public int hashCode()
  {
    int i = 1231;
    int j = 53 * (53 * (53 * (2173 + getCountryCode()) + Long.valueOf(getNationalNumber()).hashCode()) + getExtension().hashCode());
    int k;
    int m;
    if (isItalianLeadingZero())
    {
      k = i;
      m = 53 * (53 * (53 * (53 * (k + j) + getRawInput().hashCode()) + getCountryCodeSource().hashCode()) + getPreferredDomesticCarrierCode().hashCode());
      if (!hasPreferredDomesticCarrierCode())
        break label110;
    }
    while (true)
    {
      return m + i;
      k = 1237;
      break;
      label110: i = 1237;
    }
  }

  public boolean isItalianLeadingZero()
  {
    return this.italianLeadingZero_;
  }

  public PhoneNumber mergeFrom(PhoneNumber paramPhoneNumber)
  {
    if (paramPhoneNumber.hasCountryCode())
      setCountryCode(paramPhoneNumber.getCountryCode());
    if (paramPhoneNumber.hasNationalNumber())
      setNationalNumber(paramPhoneNumber.getNationalNumber());
    if (paramPhoneNumber.hasExtension())
      setExtension(paramPhoneNumber.getExtension());
    if (paramPhoneNumber.hasItalianLeadingZero())
      setItalianLeadingZero(paramPhoneNumber.isItalianLeadingZero());
    if (paramPhoneNumber.hasRawInput())
      setRawInput(paramPhoneNumber.getRawInput());
    if (paramPhoneNumber.hasCountryCodeSource())
      setCountryCodeSource(paramPhoneNumber.getCountryCodeSource());
    if (paramPhoneNumber.hasPreferredDomesticCarrierCode())
      setPreferredDomesticCarrierCode(paramPhoneNumber.getPreferredDomesticCarrierCode());
    return this;
  }

  public PhoneNumber setCountryCode(int paramInt)
  {
    this.hasCountryCode = true;
    this.countryCode_ = paramInt;
    return this;
  }

  public PhoneNumber setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource paramCountryCodeSource)
  {
    if (paramCountryCodeSource == null)
      throw new NullPointerException();
    this.hasCountryCodeSource = true;
    this.countryCodeSource_ = paramCountryCodeSource;
    return this;
  }

  public PhoneNumber setExtension(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.hasExtension = true;
    this.extension_ = paramString;
    return this;
  }

  public PhoneNumber setItalianLeadingZero(boolean paramBoolean)
  {
    this.hasItalianLeadingZero = true;
    this.italianLeadingZero_ = paramBoolean;
    return this;
  }

  public PhoneNumber setNationalNumber(long paramLong)
  {
    this.hasNationalNumber = true;
    this.nationalNumber_ = paramLong;
    return this;
  }

  public PhoneNumber setPreferredDomesticCarrierCode(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.hasPreferredDomesticCarrierCode = true;
    this.preferredDomesticCarrierCode_ = paramString;
    return this;
  }

  public PhoneNumber setRawInput(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.hasRawInput = true;
    this.rawInput_ = paramString;
    return this;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Country Code: ").append(this.countryCode_);
    localStringBuilder.append(" National Number: ").append(this.nationalNumber_);
    if ((hasItalianLeadingZero()) && (isItalianLeadingZero()))
      localStringBuilder.append(" Leading Zero: true");
    if (hasExtension())
      localStringBuilder.append(" Extension: ").append(this.extension_);
    if (hasCountryCodeSource())
      localStringBuilder.append(" Country Code Source: ").append(this.countryCodeSource_);
    if (hasPreferredDomesticCarrierCode())
      localStringBuilder.append(" Preferred Domestic Carrier Code: ").append(this.preferredDomesticCarrierCode_);
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.Phonenumber.PhoneNumber
 * JD-Core Version:    0.6.2
 */