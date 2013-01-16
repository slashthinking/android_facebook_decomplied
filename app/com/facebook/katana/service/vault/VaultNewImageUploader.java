package com.facebook.katana.service.vault;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.features.vault.VaultConstants;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.provider.VaultImageProvider;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.katana.service.vault.methods.VaultImageUploadMethod;
import com.facebook.katana.service.vault.methods.VaultImageUploadParams;
import com.facebook.katana.service.vault.methods.VaultImageUploadResult;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageException;
import com.facebook.katana.util.ImageUtils.ImageIOException;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.VaultLogger;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.base.SingleMethodRunner.AuthTokenNullException;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

public class VaultNewImageUploader
{
  private static final Class<?> a = VaultNewImageUploader.class;
  private static final String b = a.getSimpleName();
  private final Context c;
  private final SingleMethodRunner d;
  private final VaultImageUploadMethod e;
  private final VaultLocalImageFetcher f;
  private final VaultLogger g;

  public VaultNewImageUploader(Context paramContext, SingleMethodRunner paramSingleMethodRunner, VaultImageUploadMethod paramVaultImageUploadMethod, VaultLocalImageFetcher paramVaultLocalImageFetcher)
  {
    this.c = paramContext;
    this.d = paramSingleMethodRunner;
    this.e = paramVaultImageUploadMethod;
    this.f = paramVaultLocalImageFetcher;
    this.g = new VaultLogger(paramContext);
  }

  private static File a(Context paramContext)
  {
    return paramContext.getDir("vault_temp", 0);
  }

  private File a(String paramString, VaultImageProviderRow paramVaultImageProviderRow, boolean paramBoolean)
  {
    int i;
    if ((paramBoolean) && (paramVaultImageProviderRow.f != 1))
    {
      i = VaultConstants.b;
      com.facebook.common.util.Log.d(a, StringUtil.a("uploading %s in high res", new Object[] { paramString }));
    }
    try
    {
      localFile1 = new File(a(this.c), "resized_" + StringUtils.a(6));
      File localFile2 = new File(paramString);
      boolean bool3;
      if (paramBoolean)
      {
        Context localContext = this.c;
        int j = VaultConstants.c;
        bool3 = ImageUtils.a(localContext, localFile2, localFile1, i, i, j);
      }
      boolean bool1;
      for (boolean bool2 = bool3; ; bool2 = bool1)
      {
        if (!bool2)
          break label302;
        while (true)
        {
          return localFile1;
          if ((!paramBoolean) && (paramVaultImageProviderRow.f != 1) && (paramVaultImageProviderRow.f != 0))
          {
            i = VaultConstants.a;
            com.facebook.common.util.Log.d(a, StringUtil.a("uploading %s in low res", new Object[] { paramString }));
            break;
          }
          Class localClass = a;
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = Boolean.valueOf(paramBoolean);
          arrayOfObject[2] = paramVaultImageProviderRow;
          com.facebook.common.util.Log.c(localClass, StringUtil.a("no need to upload file: %s, need_high_res: %b, row: %s", arrayOfObject));
          localFile1 = null;
        }
        bool1 = ImageUtils.a(this.c, localFile2, localFile1, i, VaultConstants.c);
      }
    }
    catch (ImageUtils.ImageException localImageException)
    {
      while (true)
      {
        if ((localImageException instanceof ImageUtils.ImageIOException))
        {
          localFile1 = null;
          continue;
        }
        ErrorReporting.a("vault_image_upload_resize exception", "resize of " + paramString + " failed: " + localImageException.getMessage(), localImageException);
        label302: File localFile1 = null;
      }
    }
  }

  private void a(VaultImageProviderRow paramVaultImageProviderRow)
  {
    paramVaultImageProviderRow.h = 0;
    ContentValues localContentValues = paramVaultImageProviderRow.c();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramVaultImageProviderRow.a;
    this.c.getContentResolver().update(VaultImageProvider.a, localContentValues, StringUtil.a("%s = ?", new Object[] { "image_hash" }), arrayOfString);
    b(paramVaultImageProviderRow);
  }

  private void a(VaultImageProviderRow paramVaultImageProviderRow, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, String paramString)
  {
    ((VaultNotificationManager)FbInjector.a(this.c).a(VaultNotificationManager.class)).a(paramVaultImageProviderRow, 100);
    paramVaultImageProviderRow.b = paramLong1;
    paramVaultImageProviderRow.d = System.currentTimeMillis();
    boolean bool;
    if ((paramVaultImageProviderRow.f == 0) && (paramBoolean))
    {
      bool = true;
      if (!paramBoolean)
        break label192;
    }
    label192: for (paramVaultImageProviderRow.f = 1; ; paramVaultImageProviderRow.f = 0)
    {
      paramVaultImageProviderRow.h = 0;
      Class localClass = a;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(paramLong3);
      arrayOfObject[1] = Long.valueOf(paramLong2);
      arrayOfObject[2] = paramVaultImageProviderRow.toString();
      com.facebook.common.util.Log.d(localClass, StringUtil.a("upload success, file size: %d, time taken (mili): %d, row: %s", arrayOfObject));
      ContentValues localContentValues = paramVaultImageProviderRow.c();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramVaultImageProviderRow.a;
      this.c.getContentResolver().update(VaultImageProvider.a, localContentValues, StringUtil.a("%s = ?", new Object[] { "image_hash" }), arrayOfString);
      this.g.a(paramVaultImageProviderRow, paramLong2, paramLong3, bool, paramString);
      b(paramVaultImageProviderRow);
      return;
      bool = false;
      break;
    }
  }

  private void a(VaultImageProviderRow paramVaultImageProviderRow, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    paramVaultImageProviderRow.e = (1 + paramVaultImageProviderRow.e);
    if (paramVaultImageProviderRow.e == 8)
    {
      this.g.b(paramVaultImageProviderRow, paramLong2);
      paramVaultImageProviderRow.f = 6;
    }
    Class localClass = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramVaultImageProviderRow.toString();
    com.facebook.common.util.Log.d(localClass, StringUtil.a("Recording upload failure for row: %s", arrayOfObject));
    this.g.a(paramVaultImageProviderRow, paramString1, paramLong1, paramLong2, paramString2);
    a(paramVaultImageProviderRow);
  }

  private void a(VaultImageProviderRow paramVaultImageProviderRow, boolean paramBoolean, long paramLong)
  {
    Class localClass = a;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Boolean.valueOf(paramBoolean);
    arrayOfObject[1] = Long.valueOf(paramLong);
    arrayOfObject[2] = paramVaultImageProviderRow.toString();
    com.facebook.common.util.Log.d(localClass, StringUtil.a("uploading file, highRes: %b, size: %d, row: %s", arrayOfObject));
    ContentValues localContentValues = paramVaultImageProviderRow.c();
    this.c.getContentResolver().insert(VaultImageProvider.a, localContentValues);
    VaultNotificationManager localVaultNotificationManager = (VaultNotificationManager)FbInjector.a(this.c).a(VaultNotificationManager.class);
    this.g.a(paramVaultImageProviderRow, paramBoolean, paramLong);
    if (paramVaultImageProviderRow.e == 0)
      this.g.a(paramVaultImageProviderRow, paramLong);
    localVaultNotificationManager.a(paramVaultImageProviderRow);
  }

  private boolean a(Exception paramException)
  {
    if (((paramException instanceof SingleMethodRunner.AuthTokenNullException)) || ((paramException instanceof UnknownHostException)) || ((paramException instanceof SSLException)) || ((paramException instanceof SocketException)) || ((paramException instanceof SocketTimeoutException)) || ((paramException instanceof ConnectTimeoutException)) || ((paramException instanceof HttpHostConnectException)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private void b(VaultImageProviderRow paramVaultImageProviderRow)
  {
    ((VaultNotificationManager)FbInjector.a(this.c).a(VaultNotificationManager.class)).b(paramVaultImageProviderRow);
  }

  public boolean a(VaultImageProviderRow paramVaultImageProviderRow, int paramInt)
  {
    boolean bool = VaultHelpers.d(this.c);
    long l1 = UserValuesManager.g(this.c);
    VaultNotificationManager localVaultNotificationManager = (VaultNotificationManager)FbInjector.a(this.c).a(VaultNotificationManager.class);
    int i;
    if (!VaultHelpers.a(this.c, paramInt))
    {
      com.facebook.common.util.Log.e(a, "row upload aborted because shouldRunSync no longer passes");
      ((VaultTable)FbInjector.a(this.c).a(VaultTable.class)).b(paramVaultImageProviderRow.a);
      a(paramVaultImageProviderRow);
      i = 0;
    }
    while (true)
    {
      return i;
      String str1 = paramVaultImageProviderRow.a;
      String str2 = this.f.a(str1);
      if (str2 == null)
      {
        localVaultNotificationManager.a(str1);
        i = 0;
        continue;
      }
      if (bool);
      for (File localFile = new File(str2); ; localFile = a(str2, paramVaultImageProviderRow, bool))
      {
        if ((localFile != null) && (localFile.exists()))
          break label199;
        com.facebook.common.util.Log.c(a, StringUtil.a("skipping image %s for whatever reason", new Object[] { str1 }));
        localVaultNotificationManager.a(str1);
        i = 0;
        break;
      }
      label199: long l2 = localFile.length();
      VaultNewImageUploader.VaultUploadProgressListener localVaultUploadProgressListener = new VaultNewImageUploader.VaultUploadProgressListener(this, l2, paramVaultImageProviderRow, localVaultNotificationManager, null);
      String str3 = Long.toString(l1);
      long l3 = paramVaultImageProviderRow.b;
      VaultImageUploadParams localVaultImageUploadParams = new VaultImageUploadParams(localFile, str1, str3, l3, localVaultUploadProgressListener);
      a(paramVaultImageProviderRow, bool, l2);
      long l4 = System.currentTimeMillis();
      try
      {
        VaultImageUploadResult localVaultImageUploadResult = (VaultImageUploadResult)this.d.a(this.e, localVaultImageUploadParams);
        long l5 = System.currentTimeMillis() - l4;
        if (localVaultImageUploadResult.a() > 0L)
        {
          a(paramVaultImageProviderRow, localVaultImageUploadResult.a(), bool, l5, l2, str2);
          i = 0;
          if (bool)
            continue;
          localFile.delete();
          i = 0;
          continue;
        }
        a(paramVaultImageProviderRow, "upload result missing fbid", l5, l2, str2);
        i = 1;
        if (bool)
          continue;
        localFile.delete();
        continue;
      }
      catch (Exception localException)
      {
        com.facebook.common.util.Log.a(b, localException);
        if (a(localException))
          a(paramVaultImageProviderRow);
        while (true)
        {
          i = 1;
          if (bool)
            break;
          localFile.delete();
          break;
          String str4 = localException.getMessage();
          if (str4 == null)
            str4 = android.util.Log.getStackTraceString(localException).substring(0, 100);
          ErrorReporting.a("vault_image_upload_api exception: " + str4, "", localException, false);
          a(paramVaultImageProviderRow, localException.getMessage(), System.currentTimeMillis() - l4, l2, str2);
        }
      }
      finally
      {
        if (bool)
          break;
        localFile.delete();
      }
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultNewImageUploader
 * JD-Core Version:    0.6.0
 */