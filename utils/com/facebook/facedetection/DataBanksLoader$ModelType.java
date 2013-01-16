package com.facebook.facedetection;

 enum DataBanksLoader$ModelType
{
  private int mClassId;
  private int mRefClassId;

  static
  {
    FRONTAL_TILT_LEFT = new ModelType("FRONTAL_TILT_LEFT", 2, 6, 8);
    FRONTAL_MODEL = new ModelType("FRONTAL_MODEL", 3, 7, 7);
    FRONTAL_TILT_RIGHT = new ModelType("FRONTAL_TILT_RIGHT", 4, 8, 6);
    RIGHT_HALF_PROFILE = new ModelType("RIGHT_HALF_PROFILE", 5, 10, 4);
    RIGHT_FULL_PROFILE = new ModelType("RIGHT_FULL_PROFILE", 6, 13, 1);
    ModelType[] arrayOfModelType = new ModelType[7];
    arrayOfModelType[0] = LEFT_FULL_PROFILE;
    arrayOfModelType[1] = LEFT_HALF_PROFILE;
    arrayOfModelType[2] = FRONTAL_TILT_LEFT;
    arrayOfModelType[3] = FRONTAL_MODEL;
    arrayOfModelType[4] = FRONTAL_TILT_RIGHT;
    arrayOfModelType[5] = RIGHT_HALF_PROFILE;
    arrayOfModelType[6] = RIGHT_FULL_PROFILE;
  }

  private DataBanksLoader$ModelType(int paramInt1, int paramInt2)
  {
    this.mClassId = paramInt1;
    this.mRefClassId = paramInt2;
  }

  public int id()
  {
    return this.mClassId;
  }

  public int reflectedId()
  {
    return this.mRefClassId;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.facedetection.DataBanksLoader.ModelType
 * JD-Core Version:    0.6.2
 */