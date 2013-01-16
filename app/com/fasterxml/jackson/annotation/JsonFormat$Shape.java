package com.fasterxml.jackson.annotation;

public enum JsonFormat$Shape
{
  static
  {
    ARRAY = new Shape("ARRAY", 2);
    OBJECT = new Shape("OBJECT", 3);
    NUMBER = new Shape("NUMBER", 4);
    NUMBER_FLOAT = new Shape("NUMBER_FLOAT", 5);
    NUMBER_INT = new Shape("NUMBER_INT", 6);
    STRING = new Shape("STRING", 7);
    BOOLEAN = new Shape("BOOLEAN", 8);
    Shape[] arrayOfShape = new Shape[9];
    arrayOfShape[0] = ANY;
    arrayOfShape[1] = SCALAR;
    arrayOfShape[2] = ARRAY;
    arrayOfShape[3] = OBJECT;
    arrayOfShape[4] = NUMBER;
    arrayOfShape[5] = NUMBER_FLOAT;
    arrayOfShape[6] = NUMBER_INT;
    arrayOfShape[7] = STRING;
    arrayOfShape[8] = BOOLEAN;
    $VALUES = arrayOfShape;
  }

  public boolean isNumeric()
  {
    if ((this == NUMBER) || (this == NUMBER_INT) || (this == NUMBER_FLOAT));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean isStructured()
  {
    if ((this == OBJECT) || (this == ARRAY));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonFormat.Shape
 * JD-Core Version:    0.6.0
 */