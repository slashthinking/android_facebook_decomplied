package com.facebook.katana.service.method;

import com.google.common.collect.Maps;
import java.util.Map;

public enum MediaUploaderController$MediaUnpublishedPhoto$SourceType
{
  private static Map<Integer, SourceType> mValueMap;
  private final int mTypeId;

  static
  {
    int i = 0;
    INVALID_SOURCE = new SourceType("INVALID_SOURCE", 0, -1);
    FROM_LOCAL_FILE = new SourceType("FROM_LOCAL_FILE", 1, 0);
    FROM_VAULT = new SourceType("FROM_VAULT", 2, 1);
    SourceType[] arrayOfSourceType1 = new SourceType[3];
    arrayOfSourceType1[0] = INVALID_SOURCE;
    arrayOfSourceType1[1] = FROM_LOCAL_FILE;
    arrayOfSourceType1[2] = FROM_VAULT;
    $VALUES = arrayOfSourceType1;
    mValueMap = Maps.a();
    SourceType[] arrayOfSourceType2 = values();
    int j = arrayOfSourceType2.length;
    while (i < j)
    {
      SourceType localSourceType = arrayOfSourceType2[i];
      mValueMap.put(Integer.valueOf(localSourceType.getValue()), localSourceType);
      i++;
    }
  }

  private MediaUploaderController$MediaUnpublishedPhoto$SourceType(int paramInt)
  {
    this.mTypeId = paramInt;
  }

  public static SourceType fromInt(int paramInt)
  {
    if (mValueMap.containsKey(Integer.valueOf(paramInt)));
    for (SourceType localSourceType = (SourceType)mValueMap.get(Integer.valueOf(paramInt)); ; localSourceType = INVALID_SOURCE)
      return localSourceType;
  }

  public int getValue()
  {
    return this.mTypeId;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaUploaderController.MediaUnpublishedPhoto.SourceType
 * JD-Core Version:    0.6.0
 */