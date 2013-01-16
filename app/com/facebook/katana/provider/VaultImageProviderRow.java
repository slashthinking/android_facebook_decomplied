package com.facebook.katana.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.common.util.StringLocaleUtil;

public final class VaultImageProviderRow
  implements Parcelable
{
  public static final Parcelable.Creator<VaultImageProviderRow> CREATOR = new VaultImageProviderRow.1();
  public String a;
  public long b;
  public long c;
  public long d;
  public int e;
  public int f;
  public int g;
  public int h;
  public long i;

  public VaultImageProviderRow(Cursor paramCursor)
  {
    this.a = paramCursor.getString(paramCursor.getColumnIndex("image_hash"));
    this.b = paramCursor.getLong(paramCursor.getColumnIndex("image_fbid"));
    this.c = Math.max(0L, paramCursor.getLong(paramCursor.getColumnIndex("date_taken")));
    this.d = paramCursor.getLong(paramCursor.getColumnIndex("upload_date"));
    this.e = paramCursor.getInt(paramCursor.getColumnIndex("failure_count"));
    this.f = paramCursor.getInt(paramCursor.getColumnIndex("upload_state"));
    this.g = paramCursor.getInt(paramCursor.getColumnIndex("shared"));
    this.h = paramCursor.getInt(paramCursor.getColumnIndex("queue_state"));
    this.i = paramCursor.getLong(paramCursor.getColumnIndex("last_attempt"));
  }

  private VaultImageProviderRow(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readLong();
  }

  public VaultImageProviderRow(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong4)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = Math.max(0L, paramLong2);
    this.d = paramLong3;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    this.i = paramLong4;
  }

  public boolean a()
  {
    int j = 1;
    if ((this.f == j) || (this.f == 0));
    while (true)
    {
      return j;
      j = 0;
    }
  }

  public boolean b()
  {
    if ((!a()) && (this.e > 0));
    for (int j = 1; ; j = 0)
      return j;
  }

  public ContentValues c()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("image_hash", this.a);
    localContentValues.put("image_fbid", Long.valueOf(this.b));
    localContentValues.put("date_taken", Long.valueOf(this.c));
    localContentValues.put("upload_date", Long.valueOf(this.d));
    localContentValues.put("failure_count", Integer.valueOf(this.e));
    localContentValues.put("upload_state", Integer.valueOf(this.f));
    localContentValues.put("shared", Integer.valueOf(this.g));
    localContentValues.put("queue_state", Integer.valueOf(this.h));
    localContentValues.put("last_attempt", Long.valueOf(this.i));
    return localContentValues;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = Long.valueOf(this.b);
    arrayOfObject[2] = Long.valueOf(this.d);
    arrayOfObject[3] = Long.valueOf(this.c);
    arrayOfObject[4] = Integer.valueOf(this.e);
    arrayOfObject[5] = Integer.valueOf(this.f);
    arrayOfObject[6] = Integer.valueOf(this.h);
    arrayOfObject[7] = Long.valueOf(this.i);
    return StringLocaleUtil.a("image_hash: %s, fbid: %d, upload_date: %d, date_taken: %d, failure#: %d, upload_state: %d, queued: %d, last_attempt: %d", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeLong(this.i);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.VaultImageProviderRow
 * JD-Core Version:    0.6.0
 */