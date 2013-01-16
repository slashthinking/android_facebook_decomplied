package com.facebook.composer.model;

public enum ImplicitLocation
{
  private int mCode;

  static
  {
    ENABLED = new ImplicitLocation("ENABLED", 1, 1);
    DISABLED = new ImplicitLocation("DISABLED", 2, 2);
    ImplicitLocation[] arrayOfImplicitLocation = new ImplicitLocation[3];
    arrayOfImplicitLocation[0] = UNKNOWN;
    arrayOfImplicitLocation[1] = ENABLED;
    arrayOfImplicitLocation[2] = DISABLED;
  }

  private ImplicitLocation(int paramInt)
  {
    this.mCode = paramInt;
  }

  public int getCode()
  {
    return this.mCode;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.model.ImplicitLocation
 * JD-Core Version:    0.6.2
 */