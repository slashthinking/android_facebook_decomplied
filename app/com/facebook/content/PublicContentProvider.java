package com.facebook.content;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.util.ArrayList;

public abstract class PublicContentProvider extends ContentProvider
{
  protected abstract int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);

  protected abstract int a(Uri paramUri, String paramString, String[] paramArrayOfString);

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    return super.bulkInsert(paramUri, paramArrayOfContentValues);
  }

  protected AssetFileDescriptor a(Uri paramUri, String paramString, Bundle paramBundle)
  {
    return null;
  }

  protected abstract Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal)
  {
    return a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }

  protected abstract Uri a(Uri paramUri, ContentValues paramContentValues);

  protected Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return null;
  }

  protected abstract String a(Uri paramUri);

  protected ContentProviderResult[] a(ArrayList<ContentProviderOperation> paramArrayList)
  {
    return super.applyBatch(paramArrayList);
  }

  protected String[] a(Uri paramUri, String paramString)
  {
    return null;
  }

  public final ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
  {
    return a(paramArrayList);
  }

  protected AssetFileDescriptor b(Uri paramUri, String paramString)
  {
    return super.openAssetFile(paramUri, paramString);
  }

  public final int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    return a(paramUri, paramArrayOfContentValues);
  }

  protected ParcelFileDescriptor c(Uri paramUri, String paramString)
  {
    return super.openFile(paramUri, paramString);
  }

  public final Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramBundle);
  }

  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return a(paramUri, paramString, paramArrayOfString);
  }

  public final String[] getStreamTypes(Uri paramUri, String paramString)
  {
    return a(paramUri, paramString);
  }

  public final String getType(Uri paramUri)
  {
    return a(paramUri);
  }

  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return a(paramUri, paramContentValues);
  }

  public final AssetFileDescriptor openAssetFile(Uri paramUri, String paramString)
  {
    return b(paramUri, paramString);
  }

  public final ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    return c(paramUri, paramString);
  }

  public final AssetFileDescriptor openTypedAssetFile(Uri paramUri, String paramString, Bundle paramBundle)
  {
    return a(paramUri, paramString, paramBundle);
  }

  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }

  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal)
  {
    return a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramCancellationSignal);
  }

  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return a(paramUri, paramContentValues, paramString, paramArrayOfString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.content.PublicContentProvider
 * JD-Core Version:    0.6.0
 */