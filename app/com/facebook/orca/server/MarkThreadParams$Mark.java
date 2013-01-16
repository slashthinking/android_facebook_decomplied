package com.facebook.orca.server;

public enum MarkThreadParams$Mark
{
  private String apiName;

  static
  {
    ARCHIVED = new Mark("ARCHIVED", 1, "archived");
    SPAM = new Mark("SPAM", 2, "spam");
    Mark[] arrayOfMark = new Mark[3];
    arrayOfMark[0] = READ;
    arrayOfMark[1] = ARCHIVED;
    arrayOfMark[2] = SPAM;
    $VALUES = arrayOfMark;
  }

  private MarkThreadParams$Mark(String paramString)
  {
    this.apiName = paramString;
  }

  public String getApiName()
  {
    return this.apiName;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.MarkThreadParams.Mark
 * JD-Core Version:    0.6.0
 */