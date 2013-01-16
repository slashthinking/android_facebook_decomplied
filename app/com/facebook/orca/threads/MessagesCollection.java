package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public class MessagesCollection
  implements Parcelable
{
  public static final Parcelable.Creator<MessagesCollection> CREATOR;
  private static final Class<?> a = MessagesCollection.class;
  private static final WtfToken b = new WtfToken();
  private final String c;
  private final ImmutableList<Message> d;
  private final boolean e;

  static
  {
    CREATOR = new MessagesCollection.1();
  }

  private MessagesCollection(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = ImmutableList.a(paramParcel.createTypedArrayList(Message.CREATOR));
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.e = bool;
      a(this.d);
      return;
    }
  }

  public MessagesCollection(String paramString, ImmutableList<Message> paramImmutableList, boolean paramBoolean)
  {
    this.c = paramString;
    this.d = paramImmutableList;
    this.e = paramBoolean;
    a(paramImmutableList);
  }

  public static MessagesCollection a(Message paramMessage)
  {
    return new MessagesCollection(paramMessage.b(), ImmutableList.a(paramMessage), false);
  }

  private static void a(ImmutableList<Message> paramImmutableList)
  {
    Iterator localIterator = paramImmutableList.iterator();
    long l1 = 9223372036854775807L;
    long l2 = 9223372036854775807L;
    while (true)
    {
      Message localMessage;
      if (localIterator.hasNext())
      {
        localMessage = (Message)localIterator.next();
        if (localMessage.v())
          continue;
        if ((localMessage.c() > l1) && (b(localMessage) > l2))
          BLog.a(b, a, "Thread messages were not in order");
      }
      else
      {
        return;
      }
      long l3 = localMessage.c();
      long l4 = b(localMessage);
      l1 = l3;
      l2 = l4;
    }
  }

  private static long b(Message paramMessage)
  {
    long l;
    if (paramMessage.d())
      l = paramMessage.e();
    while (true)
    {
      return l;
      l = paramMessage.c();
    }
  }

  public Message a(int paramInt)
  {
    return (Message)this.d.get(paramInt);
  }

  public String a()
  {
    return this.c;
  }

  public ImmutableList<Message> b()
  {
    return this.d;
  }

  public Message c()
  {
    if (this.d.isEmpty());
    for (Message localMessage = null; ; localMessage = (Message)this.d.get(0))
      return localMessage;
  }

  public boolean d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    return this.d.isEmpty();
  }

  public int f()
  {
    return this.d.size();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeTypedList(this.d);
    if (this.e);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.MessagesCollection
 * JD-Core Version:    0.6.0
 */