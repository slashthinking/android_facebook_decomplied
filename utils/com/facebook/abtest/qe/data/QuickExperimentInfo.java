package com.facebook.abtest.qe.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class QuickExperimentInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QuickExperimentInfo> CREATOR = new QuickExperimentInfo.1();
  public static final Class<?> a = QuickExperimentInfo.class;
  private final String b;
  private final String c;
  private final boolean d;
  private final String e;
  private final ImmutableMap<String, String> f;

  private QuickExperimentInfo(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.d = i;
      this.e = paramParcel.readString();
      this.f = ImmutableMap.a(paramParcel.readHashMap(QuickExperimentInfo.class.getClassLoader()));
      return;
      i = 0;
    }
  }

  public QuickExperimentInfo(String paramString1, String paramString2, boolean paramBoolean, String paramString3, Map<String, String> paramMap)
  {
    this.b = ((String)Preconditions.checkNotNull(paramString1));
    this.c = ((String)Preconditions.checkNotNull(paramString2));
    this.d = paramBoolean;
    this.e = ((String)Preconditions.checkNotNull(paramString3));
    this.f = ImmutableMap.a((Map)Preconditions.checkNotNull(paramMap));
  }

  public static QuickExperimentInfo b(String paramString)
  {
    return new QuickExperimentInfo(paramString, "local_default_group", false, Locale.getDefault().toString(), ImmutableMap.j());
  }

  public Optional<String> a(String paramString)
  {
    if (this.c.equals("local_default_group"));
    for (Optional localOptional = Optional.absent(); ; localOptional = Optional.fromNullable(this.f.get(paramString)))
      return localOptional;
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public boolean c()
  {
    return this.d;
  }

  public String d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public ImmutableMap<String, String> e()
  {
    return this.f;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b).append("/Group: ").append(this.c).append("/Logging:").append(this.d).append("/Locale:").append(this.e).append("/customStrings: ");
    Iterator localIterator = this.f.a().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("\n").append((String)localEntry.getKey()).append(": ").append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    if (this.d);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.e);
      paramParcel.writeMap(this.f);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.data.QuickExperimentInfo
 * JD-Core Version:    0.6.2
 */