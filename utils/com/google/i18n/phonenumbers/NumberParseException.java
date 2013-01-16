package com.google.i18n.phonenumbers;

public class NumberParseException extends Exception
{
  private NumberParseException.ErrorType errorType;
  private String message;

  public NumberParseException(NumberParseException.ErrorType paramErrorType, String paramString)
  {
    super(paramString);
    this.message = paramString;
    this.errorType = paramErrorType;
  }

  public NumberParseException.ErrorType getErrorType()
  {
    return this.errorType;
  }

  public String toString()
  {
    return "Error type: " + this.errorType + ". " + this.message;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.NumberParseException
 * JD-Core Version:    0.6.2
 */