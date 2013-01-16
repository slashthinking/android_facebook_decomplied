package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Phonemetadata$PhoneNumberDesc
  implements Externalizable
{
  private static final long serialVersionUID = 1L;
  private String exampleNumber_ = "";
  private boolean hasExampleNumber;
  private boolean hasNationalNumberPattern;
  private boolean hasPossibleNumberPattern;
  private String nationalNumberPattern_ = "";
  private String possibleNumberPattern_ = "";

  public static Phonemetadata.PhoneNumberDesc.Builder newBuilder()
  {
    return new Phonemetadata.PhoneNumberDesc.Builder();
  }

  public String getNationalNumberPattern()
  {
    return this.nationalNumberPattern_;
  }

  public String getPossibleNumberPattern()
  {
    return this.possibleNumberPattern_;
  }

  public boolean hasNationalNumberPattern()
  {
    return this.hasNationalNumberPattern;
  }

  public void readExternal(ObjectInput paramObjectInput)
  {
    if (paramObjectInput.readBoolean())
      setNationalNumberPattern(paramObjectInput.readUTF());
    if (paramObjectInput.readBoolean())
      setPossibleNumberPattern(paramObjectInput.readUTF());
    if (paramObjectInput.readBoolean())
      setExampleNumber(paramObjectInput.readUTF());
  }

  public PhoneNumberDesc setExampleNumber(String paramString)
  {
    this.hasExampleNumber = true;
    this.exampleNumber_ = paramString;
    return this;
  }

  public PhoneNumberDesc setNationalNumberPattern(String paramString)
  {
    this.hasNationalNumberPattern = true;
    this.nationalNumberPattern_ = paramString;
    return this;
  }

  public PhoneNumberDesc setPossibleNumberPattern(String paramString)
  {
    this.hasPossibleNumberPattern = true;
    this.possibleNumberPattern_ = paramString;
    return this;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeBoolean(this.hasNationalNumberPattern);
    if (this.hasNationalNumberPattern)
      paramObjectOutput.writeUTF(this.nationalNumberPattern_);
    paramObjectOutput.writeBoolean(this.hasPossibleNumberPattern);
    if (this.hasPossibleNumberPattern)
      paramObjectOutput.writeUTF(this.possibleNumberPattern_);
    paramObjectOutput.writeBoolean(this.hasExampleNumber);
    if (this.hasExampleNumber)
      paramObjectOutput.writeUTF(this.exampleNumber_);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.Phonemetadata.PhoneNumberDesc
 * JD-Core Version:    0.6.2
 */