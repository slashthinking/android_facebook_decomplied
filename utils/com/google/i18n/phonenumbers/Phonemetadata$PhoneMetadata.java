package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Phonemetadata$PhoneMetadata
  implements Externalizable
{
  private static final long serialVersionUID = 1L;
  private int countryCode_ = 0;
  private Phonemetadata.PhoneNumberDesc emergency_ = null;
  private Phonemetadata.PhoneNumberDesc fixedLine_ = null;
  private Phonemetadata.PhoneNumberDesc generalDesc_ = null;
  private boolean hasCountryCode;
  private boolean hasEmergency;
  private boolean hasFixedLine;
  private boolean hasGeneralDesc;
  private boolean hasId;
  private boolean hasInternationalPrefix;
  private boolean hasLeadingDigits;
  private boolean hasLeadingZeroPossible;
  private boolean hasMainCountryForCode;
  private boolean hasMobile;
  private boolean hasNationalPrefix;
  private boolean hasNationalPrefixForParsing;
  private boolean hasNationalPrefixTransformRule;
  private boolean hasNoInternationalDialling;
  private boolean hasPager;
  private boolean hasPersonalNumber;
  private boolean hasPreferredExtnPrefix;
  private boolean hasPreferredInternationalPrefix;
  private boolean hasPremiumRate;
  private boolean hasSameMobileAndFixedLinePattern;
  private boolean hasSharedCost;
  private boolean hasTollFree;
  private boolean hasUan;
  private boolean hasVoip;
  private String id_ = "";
  private String internationalPrefix_ = "";
  private List<Phonemetadata.NumberFormat> intlNumberFormat_ = new ArrayList();
  private String leadingDigits_ = "";
  private boolean leadingZeroPossible_ = false;
  private boolean mainCountryForCode_ = false;
  private Phonemetadata.PhoneNumberDesc mobile_ = null;
  private String nationalPrefixForParsing_ = "";
  private String nationalPrefixTransformRule_ = "";
  private String nationalPrefix_ = "";
  private Phonemetadata.PhoneNumberDesc noInternationalDialling_ = null;
  private List<Phonemetadata.NumberFormat> numberFormat_ = new ArrayList();
  private Phonemetadata.PhoneNumberDesc pager_ = null;
  private Phonemetadata.PhoneNumberDesc personalNumber_ = null;
  private String preferredExtnPrefix_ = "";
  private String preferredInternationalPrefix_ = "";
  private Phonemetadata.PhoneNumberDesc premiumRate_ = null;
  private boolean sameMobileAndFixedLinePattern_ = false;
  private Phonemetadata.PhoneNumberDesc sharedCost_ = null;
  private Phonemetadata.PhoneNumberDesc tollFree_ = null;
  private Phonemetadata.PhoneNumberDesc uan_ = null;
  private Phonemetadata.PhoneNumberDesc voip_ = null;

  public static Phonemetadata.PhoneMetadata.Builder newBuilder()
  {
    return new Phonemetadata.PhoneMetadata.Builder();
  }

  public int getCountryCode()
  {
    return this.countryCode_;
  }

  public Phonemetadata.PhoneNumberDesc getFixedLine()
  {
    return this.fixedLine_;
  }

  public Phonemetadata.PhoneNumberDesc getGeneralDesc()
  {
    return this.generalDesc_;
  }

  public String getInternationalPrefix()
  {
    return this.internationalPrefix_;
  }

  public String getLeadingDigits()
  {
    return this.leadingDigits_;
  }

  public Phonemetadata.PhoneNumberDesc getMobile()
  {
    return this.mobile_;
  }

  public String getNationalPrefixForParsing()
  {
    return this.nationalPrefixForParsing_;
  }

  public String getNationalPrefixTransformRule()
  {
    return this.nationalPrefixTransformRule_;
  }

  public Phonemetadata.PhoneNumberDesc getPager()
  {
    return this.pager_;
  }

  public Phonemetadata.PhoneNumberDesc getPersonalNumber()
  {
    return this.personalNumber_;
  }

  public String getPreferredExtnPrefix()
  {
    return this.preferredExtnPrefix_;
  }

  public Phonemetadata.PhoneNumberDesc getPremiumRate()
  {
    return this.premiumRate_;
  }

  public Phonemetadata.PhoneNumberDesc getSharedCost()
  {
    return this.sharedCost_;
  }

  public Phonemetadata.PhoneNumberDesc getTollFree()
  {
    return this.tollFree_;
  }

  public Phonemetadata.PhoneNumberDesc getUan()
  {
    return this.uan_;
  }

  public Phonemetadata.PhoneNumberDesc getVoip()
  {
    return this.voip_;
  }

  public boolean hasLeadingDigits()
  {
    return this.hasLeadingDigits;
  }

  public boolean hasNationalPrefix()
  {
    return this.hasNationalPrefix;
  }

  public boolean hasNationalPrefixForParsing()
  {
    return this.hasNationalPrefixForParsing;
  }

  public boolean hasPreferredExtnPrefix()
  {
    return this.hasPreferredExtnPrefix;
  }

  public int intlNumberFormatSize()
  {
    return this.intlNumberFormat_.size();
  }

  public List<Phonemetadata.NumberFormat> intlNumberFormats()
  {
    return this.intlNumberFormat_;
  }

  public boolean isSameMobileAndFixedLinePattern()
  {
    return this.sameMobileAndFixedLinePattern_;
  }

  public int numberFormatSize()
  {
    return this.numberFormat_.size();
  }

  public List<Phonemetadata.NumberFormat> numberFormats()
  {
    return this.numberFormat_;
  }

  public void readExternal(ObjectInput paramObjectInput)
  {
    int i = 0;
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc1 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc1.readExternal(paramObjectInput);
      setGeneralDesc(localPhoneNumberDesc1);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc2 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc2.readExternal(paramObjectInput);
      setFixedLine(localPhoneNumberDesc2);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc3 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc3.readExternal(paramObjectInput);
      setMobile(localPhoneNumberDesc3);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc4 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc4.readExternal(paramObjectInput);
      setTollFree(localPhoneNumberDesc4);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc5 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc5.readExternal(paramObjectInput);
      setPremiumRate(localPhoneNumberDesc5);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc6 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc6.readExternal(paramObjectInput);
      setSharedCost(localPhoneNumberDesc6);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc7 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc7.readExternal(paramObjectInput);
      setPersonalNumber(localPhoneNumberDesc7);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc8 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc8.readExternal(paramObjectInput);
      setVoip(localPhoneNumberDesc8);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc9 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc9.readExternal(paramObjectInput);
      setPager(localPhoneNumberDesc9);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc10 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc10.readExternal(paramObjectInput);
      setUan(localPhoneNumberDesc10);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc11 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc11.readExternal(paramObjectInput);
      setEmergency(localPhoneNumberDesc11);
    }
    if (paramObjectInput.readBoolean())
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc12 = new Phonemetadata.PhoneNumberDesc();
      localPhoneNumberDesc12.readExternal(paramObjectInput);
      setNoInternationalDialling(localPhoneNumberDesc12);
    }
    setId(paramObjectInput.readUTF());
    setCountryCode(paramObjectInput.readInt());
    setInternationalPrefix(paramObjectInput.readUTF());
    if (paramObjectInput.readBoolean())
      setPreferredInternationalPrefix(paramObjectInput.readUTF());
    if (paramObjectInput.readBoolean())
      setNationalPrefix(paramObjectInput.readUTF());
    if (paramObjectInput.readBoolean())
      setPreferredExtnPrefix(paramObjectInput.readUTF());
    if (paramObjectInput.readBoolean())
      setNationalPrefixForParsing(paramObjectInput.readUTF());
    if (paramObjectInput.readBoolean())
      setNationalPrefixTransformRule(paramObjectInput.readUTF());
    setSameMobileAndFixedLinePattern(paramObjectInput.readBoolean());
    int j = paramObjectInput.readInt();
    for (int k = 0; k < j; k++)
    {
      Phonemetadata.NumberFormat localNumberFormat1 = new Phonemetadata.NumberFormat();
      localNumberFormat1.readExternal(paramObjectInput);
      this.numberFormat_.add(localNumberFormat1);
    }
    int m = paramObjectInput.readInt();
    while (i < m)
    {
      Phonemetadata.NumberFormat localNumberFormat2 = new Phonemetadata.NumberFormat();
      localNumberFormat2.readExternal(paramObjectInput);
      this.intlNumberFormat_.add(localNumberFormat2);
      i++;
    }
    setMainCountryForCode(paramObjectInput.readBoolean());
    if (paramObjectInput.readBoolean())
      setLeadingDigits(paramObjectInput.readUTF());
    setLeadingZeroPossible(paramObjectInput.readBoolean());
  }

  public PhoneMetadata setCountryCode(int paramInt)
  {
    this.hasCountryCode = true;
    this.countryCode_ = paramInt;
    return this;
  }

  public PhoneMetadata setEmergency(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasEmergency = true;
    this.emergency_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setFixedLine(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasFixedLine = true;
    this.fixedLine_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setGeneralDesc(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasGeneralDesc = true;
    this.generalDesc_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setId(String paramString)
  {
    this.hasId = true;
    this.id_ = paramString;
    return this;
  }

  public PhoneMetadata setInternationalPrefix(String paramString)
  {
    this.hasInternationalPrefix = true;
    this.internationalPrefix_ = paramString;
    return this;
  }

  public PhoneMetadata setLeadingDigits(String paramString)
  {
    this.hasLeadingDigits = true;
    this.leadingDigits_ = paramString;
    return this;
  }

  public PhoneMetadata setLeadingZeroPossible(boolean paramBoolean)
  {
    this.hasLeadingZeroPossible = true;
    this.leadingZeroPossible_ = paramBoolean;
    return this;
  }

  public PhoneMetadata setMainCountryForCode(boolean paramBoolean)
  {
    this.hasMainCountryForCode = true;
    this.mainCountryForCode_ = paramBoolean;
    return this;
  }

  public PhoneMetadata setMobile(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasMobile = true;
    this.mobile_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setNationalPrefix(String paramString)
  {
    this.hasNationalPrefix = true;
    this.nationalPrefix_ = paramString;
    return this;
  }

  public PhoneMetadata setNationalPrefixForParsing(String paramString)
  {
    this.hasNationalPrefixForParsing = true;
    this.nationalPrefixForParsing_ = paramString;
    return this;
  }

  public PhoneMetadata setNationalPrefixTransformRule(String paramString)
  {
    this.hasNationalPrefixTransformRule = true;
    this.nationalPrefixTransformRule_ = paramString;
    return this;
  }

  public PhoneMetadata setNoInternationalDialling(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasNoInternationalDialling = true;
    this.noInternationalDialling_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setPager(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasPager = true;
    this.pager_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setPersonalNumber(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasPersonalNumber = true;
    this.personalNumber_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setPreferredExtnPrefix(String paramString)
  {
    this.hasPreferredExtnPrefix = true;
    this.preferredExtnPrefix_ = paramString;
    return this;
  }

  public PhoneMetadata setPreferredInternationalPrefix(String paramString)
  {
    this.hasPreferredInternationalPrefix = true;
    this.preferredInternationalPrefix_ = paramString;
    return this;
  }

  public PhoneMetadata setPremiumRate(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasPremiumRate = true;
    this.premiumRate_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setSameMobileAndFixedLinePattern(boolean paramBoolean)
  {
    this.hasSameMobileAndFixedLinePattern = true;
    this.sameMobileAndFixedLinePattern_ = paramBoolean;
    return this;
  }

  public PhoneMetadata setSharedCost(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasSharedCost = true;
    this.sharedCost_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setTollFree(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasTollFree = true;
    this.tollFree_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setUan(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasUan = true;
    this.uan_ = paramPhoneNumberDesc;
    return this;
  }

  public PhoneMetadata setVoip(Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    if (paramPhoneNumberDesc == null)
      throw new NullPointerException();
    this.hasVoip = true;
    this.voip_ = paramPhoneNumberDesc;
    return this;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    int i = 0;
    paramObjectOutput.writeBoolean(this.hasGeneralDesc);
    if (this.hasGeneralDesc)
      this.generalDesc_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasFixedLine);
    if (this.hasFixedLine)
      this.fixedLine_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasMobile);
    if (this.hasMobile)
      this.mobile_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasTollFree);
    if (this.hasTollFree)
      this.tollFree_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasPremiumRate);
    if (this.hasPremiumRate)
      this.premiumRate_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasSharedCost);
    if (this.hasSharedCost)
      this.sharedCost_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasPersonalNumber);
    if (this.hasPersonalNumber)
      this.personalNumber_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasVoip);
    if (this.hasVoip)
      this.voip_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasPager);
    if (this.hasPager)
      this.pager_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasUan);
    if (this.hasUan)
      this.uan_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasEmergency);
    if (this.hasEmergency)
      this.emergency_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.hasNoInternationalDialling);
    if (this.hasNoInternationalDialling)
      this.noInternationalDialling_.writeExternal(paramObjectOutput);
    paramObjectOutput.writeUTF(this.id_);
    paramObjectOutput.writeInt(this.countryCode_);
    paramObjectOutput.writeUTF(this.internationalPrefix_);
    paramObjectOutput.writeBoolean(this.hasPreferredInternationalPrefix);
    if (this.hasPreferredInternationalPrefix)
      paramObjectOutput.writeUTF(this.preferredInternationalPrefix_);
    paramObjectOutput.writeBoolean(this.hasNationalPrefix);
    if (this.hasNationalPrefix)
      paramObjectOutput.writeUTF(this.nationalPrefix_);
    paramObjectOutput.writeBoolean(this.hasPreferredExtnPrefix);
    if (this.hasPreferredExtnPrefix)
      paramObjectOutput.writeUTF(this.preferredExtnPrefix_);
    paramObjectOutput.writeBoolean(this.hasNationalPrefixForParsing);
    if (this.hasNationalPrefixForParsing)
      paramObjectOutput.writeUTF(this.nationalPrefixForParsing_);
    paramObjectOutput.writeBoolean(this.hasNationalPrefixTransformRule);
    if (this.hasNationalPrefixTransformRule)
      paramObjectOutput.writeUTF(this.nationalPrefixTransformRule_);
    paramObjectOutput.writeBoolean(this.sameMobileAndFixedLinePattern_);
    int j = numberFormatSize();
    paramObjectOutput.writeInt(j);
    for (int k = 0; k < j; k++)
      ((Phonemetadata.NumberFormat)this.numberFormat_.get(k)).writeExternal(paramObjectOutput);
    int m = intlNumberFormatSize();
    paramObjectOutput.writeInt(m);
    while (i < m)
    {
      ((Phonemetadata.NumberFormat)this.intlNumberFormat_.get(i)).writeExternal(paramObjectOutput);
      i++;
    }
    paramObjectOutput.writeBoolean(this.mainCountryForCode_);
    paramObjectOutput.writeBoolean(this.hasLeadingDigits);
    if (this.hasLeadingDigits)
      paramObjectOutput.writeUTF(this.leadingDigits_);
    paramObjectOutput.writeBoolean(this.leadingZeroPossible_);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata
 * JD-Core Version:    0.6.2
 */