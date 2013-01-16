package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Phonemetadata$NumberFormat
  implements Externalizable
{
  private static final long serialVersionUID = 1L;
  private String domesticCarrierCodeFormattingRule_ = "";
  private String format_ = "";
  private boolean hasDomesticCarrierCodeFormattingRule;
  private boolean hasFormat;
  private boolean hasNationalPrefixFormattingRule;
  private boolean hasPattern;
  private List<String> leadingDigitsPattern_ = new ArrayList();
  private String nationalPrefixFormattingRule_ = "";
  private String pattern_ = "";

  public static Phonemetadata.NumberFormat.Builder newBuilder()
  {
    return new Phonemetadata.NumberFormat.Builder();
  }

  public String getDomesticCarrierCodeFormattingRule()
  {
    return this.domesticCarrierCodeFormattingRule_;
  }

  public String getFormat()
  {
    return this.format_;
  }

  public String getLeadingDigitsPattern(int paramInt)
  {
    return (String)this.leadingDigitsPattern_.get(paramInt);
  }

  public String getNationalPrefixFormattingRule()
  {
    return this.nationalPrefixFormattingRule_;
  }

  public String getPattern()
  {
    return this.pattern_;
  }

  public int leadingDigitsPatternSize()
  {
    return this.leadingDigitsPattern_.size();
  }

  public void readExternal(ObjectInput paramObjectInput)
  {
    setPattern(paramObjectInput.readUTF());
    setFormat(paramObjectInput.readUTF());
    int i = paramObjectInput.readInt();
    for (int j = 0; j < i; j++)
      this.leadingDigitsPattern_.add(paramObjectInput.readUTF());
    if (paramObjectInput.readBoolean())
      setNationalPrefixFormattingRule(paramObjectInput.readUTF());
    if (paramObjectInput.readBoolean())
      setDomesticCarrierCodeFormattingRule(paramObjectInput.readUTF());
  }

  public NumberFormat setDomesticCarrierCodeFormattingRule(String paramString)
  {
    this.hasDomesticCarrierCodeFormattingRule = true;
    this.domesticCarrierCodeFormattingRule_ = paramString;
    return this;
  }

  public NumberFormat setFormat(String paramString)
  {
    this.hasFormat = true;
    this.format_ = paramString;
    return this;
  }

  public NumberFormat setNationalPrefixFormattingRule(String paramString)
  {
    this.hasNationalPrefixFormattingRule = true;
    this.nationalPrefixFormattingRule_ = paramString;
    return this;
  }

  public NumberFormat setPattern(String paramString)
  {
    this.hasPattern = true;
    this.pattern_ = paramString;
    return this;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.pattern_);
    paramObjectOutput.writeUTF(this.format_);
    int i = leadingDigitsPatternSize();
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeUTF((String)this.leadingDigitsPattern_.get(j));
    paramObjectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
    if (this.hasNationalPrefixFormattingRule)
      paramObjectOutput.writeUTF(this.nationalPrefixFormattingRule_);
    paramObjectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
    if (this.hasDomesticCarrierCodeFormattingRule)
      paramObjectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.Phonemetadata.NumberFormat
 * JD-Core Version:    0.6.2
 */