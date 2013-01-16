package com.facebook.uri;

 enum UriTemplateMap$TemplateValueType
{
  static
  {
    LONG = new TemplateValueType("LONG", 1);
    BOOLEAN = new TemplateValueType("BOOLEAN", 2);
    TemplateValueType[] arrayOfTemplateValueType = new TemplateValueType[3];
    arrayOfTemplateValueType[0] = STRING;
    arrayOfTemplateValueType[1] = LONG;
    arrayOfTemplateValueType[2] = BOOLEAN;
    $VALUES = arrayOfTemplateValueType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.uri.UriTemplateMap.TemplateValueType
 * JD-Core Version:    0.6.0
 */