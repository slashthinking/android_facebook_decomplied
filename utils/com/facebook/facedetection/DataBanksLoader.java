package com.facebook.facedetection;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class DataBanksLoader
{
  public DataBanksLoader(Context paramContext)
  {
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    DataBanksLoader.ModelType[] arrayOfModelType;
    AssetManager localAssetManager;
    try
    {
      arrayOfModelType = new DataBanksLoader.ModelType[4];
      arrayOfModelType[0] = DataBanksLoader.ModelType.LEFT_FULL_PROFILE;
      arrayOfModelType[1] = DataBanksLoader.ModelType.LEFT_HALF_PROFILE;
      arrayOfModelType[2] = DataBanksLoader.ModelType.FRONTAL_TILT_LEFT;
      arrayOfModelType[3] = DataBanksLoader.ModelType.FRONTAL_MODEL;
      if (!init(-1 + 2 * arrayOfModelType.length))
      {
        Log.w("DataBanksLoader", "Detector's data files already loaded, skipping");
        break label440;
      }
      localAssetManager = paramContext.getAssets();
      loadWfsMeta(a(localAssetManager, "sImeta.bin.gz.jet"));
      i = 0;
      if (i < arrayOfModelType.length)
      {
        DataBanksLoader.ModelType localModelType2 = arrayOfModelType[i];
        String str = "sIcls" + localModelType2.id() + ".bin.gz.jet";
        byte[] arrayOfByte2 = a(localAssetManager, str);
        Log.d("DataBanksLoader", "loading class: " + localModelType2.id() + ", reflected: " + localModelType2.reflectedId() + ", filename: " + str);
        if (!loadWfsClass(arrayOfByte2, i, localModelType2.id(), localModelType2.reflectedId()))
          throw new OutOfMemoryError("StageI allocation");
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        int i;
        Log.e("DataBanksLoader", "while loading data banks: " + localIOException.getMessage());
        dealloc();
        throw localIOException;
        i++;
      }
      if (!finalizeWfsTree())
        throw new OutOfMemoryError("finalizeWfsTree");
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e("DataBanksLoader", "OutOfMemoryError while loading data banks");
      dealloc();
      throw localOutOfMemoryError;
    }
    boolean bool = initStageIIData(arrayOfModelType.length);
    int j = 0;
    if (!bool)
      throw new OutOfMemoryError("initStageII");
    while (true)
    {
      if (j < arrayOfModelType.length)
      {
        DataBanksLoader.ModelType localModelType1 = arrayOfModelType[j];
        byte[] arrayOfByte1 = a(localAssetManager, "sIIcls" + localModelType1.id() + ".bin.gz.jet");
        Log.d("DataBanksLoader", "loading class: " + localModelType1.id());
        if (!loadStageIIClass(arrayOfByte1, j))
          throw new OutOfMemoryError("loadStageIIClass " + j);
      }
      else
      {
        label440: return;
      }
      j++;
    }
  }

  private byte[] a(AssetManager paramAssetManager, String paramString)
  {
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(new BufferedInputStream(paramAssetManager.open(paramString)));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      byte[] arrayOfByte1 = new byte[1024];
      int i = localGZIPInputStream.read(arrayOfByte1, 0, 1024);
      if (i != -1)
        localByteArrayOutputStream.write(arrayOfByte1, 0, i);
    }
    finally
    {
      localGZIPInputStream.close();
    }
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return arrayOfByte2;
  }

  private native void dealloc();

  private native boolean finalizeWfsTree();

  private native boolean init(int paramInt);

  private native boolean initStageIIData(int paramInt);

  private native boolean loadStageIIClass(byte[] paramArrayOfByte, int paramInt);

  private native boolean loadWfsClass(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);

  private native void loadWfsMeta(byte[] paramArrayOfByte);

  protected void finalize()
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.facedetection.DataBanksLoader
 * JD-Core Version:    0.6.2
 */