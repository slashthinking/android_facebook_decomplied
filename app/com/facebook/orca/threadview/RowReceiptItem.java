package com.facebook.orca.threadview;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.google.common.base.Objects;
import java.util.List;

public class RowReceiptItem extends RowItem
{
  private final List<RowReceiptParticipant> a;
  private final ParticipantInfo b;
  private final String c;
  private final RowReceiptItem.Type d;
  private final String e;
  private final String f;
  private final long g;
  private final long h;
  private final long i;
  private final Coordinates j;
  private final boolean k;
  private final int l;

  private RowReceiptItem(ParticipantInfo paramParticipantInfo, RowReceiptItem.Type paramType, Message paramMessage)
  {
    this.b = paramParticipantInfo;
    this.c = paramMessage.w();
    this.d = paramType;
    this.a = null;
    this.e = paramMessage.a();
    this.f = paramMessage.t();
    this.g = paramMessage.c();
    this.h = paramMessage.e();
    this.i = -1L;
    this.j = paramMessage.k();
    this.k = false;
    this.l = 0;
  }

  private RowReceiptItem(List<RowReceiptParticipant> paramList, RowReceiptItem.Type paramType, Message paramMessage, long paramLong)
  {
    this(paramList, paramType, paramMessage, paramLong, false, 0);
  }

  private RowReceiptItem(List<RowReceiptParticipant> paramList, RowReceiptItem.Type paramType, Message paramMessage, long paramLong, boolean paramBoolean, int paramInt)
  {
    this.a = paramList;
    this.d = paramType;
    this.b = null;
    this.c = null;
    this.e = paramMessage.a();
    this.f = paramMessage.t();
    this.g = paramMessage.c();
    this.h = paramMessage.e();
    this.i = paramLong;
    this.j = paramMessage.k();
    this.k = paramBoolean;
    this.l = paramInt;
  }

  private RowReceiptItem(List<RowReceiptParticipant> paramList, RowReceiptItem.Type paramType, Message paramMessage, boolean paramBoolean, int paramInt)
  {
    this(paramList, paramType, paramMessage, -1L, paramBoolean, paramInt);
  }

  public static RowReceiptItem a(ParticipantInfo paramParticipantInfo, Message paramMessage)
  {
    return new RowReceiptItem(paramParticipantInfo, RowReceiptItem.Type.SENT, paramMessage);
  }

  public static RowReceiptItem a(List<RowReceiptParticipant> paramList, Message paramMessage, long paramLong)
  {
    return new RowReceiptItem(paramList, RowReceiptItem.Type.READ, paramMessage, paramLong);
  }

  public static RowReceiptItem a(List<RowReceiptParticipant> paramList, Message paramMessage, boolean paramBoolean, int paramInt)
  {
    return new RowReceiptItem(paramList, RowReceiptItem.Type.GROUP_READ, paramMessage, paramBoolean, paramInt);
  }

  public static RowReceiptItem b(ParticipantInfo paramParticipantInfo, Message paramMessage)
  {
    return new RowReceiptItem(paramParticipantInfo, RowReceiptItem.Type.DELIVERED, paramMessage);
  }

  public int a()
  {
    return 4;
  }

  public boolean a(ParticipantInfo paramParticipantInfo1, ParticipantInfo paramParticipantInfo2)
  {
    if ((Objects.equal(paramParticipantInfo1.a(), paramParticipantInfo2.a())) && (Objects.equal(paramParticipantInfo1.e(), paramParticipantInfo2.e())) && (Objects.equal(paramParticipantInfo1.d(), paramParticipantInfo2.d())));
    for (int m = 1; ; m = 0)
      return m;
  }

  public boolean a(RowReceiptItem paramRowReceiptItem)
  {
    List localList1 = paramRowReceiptItem.c();
    int m;
    if ((c() == null) && (localList1 == null))
      m = 1;
    while (true)
    {
      return m;
      List localList2 = c();
      m = 0;
      if (localList2 == null)
        continue;
      m = 0;
      if (localList1 == null)
        continue;
      int n = c().size();
      int i1 = localList1.size();
      m = 0;
      if (n != i1)
        continue;
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= c().size())
          break label138;
        boolean bool = a(((RowReceiptParticipant)c().get(i2)).a(), ((RowReceiptParticipant)localList1.get(i2)).a());
        m = 0;
        if (!bool)
          break;
      }
      label138: m = 1;
    }
  }

  public RowReceiptItem.Type b()
  {
    return this.d;
  }

  public List<RowReceiptParticipant> c()
  {
    return this.a;
  }

  public String d()
  {
    return this.c;
  }

  public String e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = paramObject instanceof RowReceiptItem;
    int m = 0;
    if (!bool2)
      return m;
    RowReceiptItem localRowReceiptItem = (RowReceiptItem)paramObject;
    boolean bool3;
    if ((!StringUtil.a(e())) && (!StringUtil.a(localRowReceiptItem.e())) && (Objects.equal(e(), localRowReceiptItem.e())))
      bool3 = bool1;
    while (true)
    {
      label62: if ((bool3) && (b().equals(localRowReceiptItem.b())) && (a(localRowReceiptItem)));
      while (true)
      {
        m = bool1;
        break;
        if ((StringUtil.a(f())) || (StringUtil.a(localRowReceiptItem.f())))
          break label140;
        bool3 = Objects.equal(f(), localRowReceiptItem.f());
        break label62;
        bool1 = false;
      }
      label140: bool3 = false;
    }
  }

  public String f()
  {
    return this.f;
  }

  public long g()
  {
    return this.i;
  }

  public Coordinates h()
  {
    return this.j;
  }

  public int hashCode()
  {
    if (e() != null);
    for (int m = e().hashCode(); ; m = 0)
    {
      int n = m * 31;
      String str = f();
      int i1 = 0;
      if (str != null)
        i1 = f().hashCode();
      return n + i1;
    }
  }

  public boolean i()
  {
    return this.k;
  }

  public int j()
  {
    return this.l;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("RowReceiptItem{, readers=");
    Object localObject1;
    Object localObject2;
    label49: String str1;
    label75: String str2;
    label119: StringBuilder localStringBuilder5;
    if (this.a != null)
    {
      localObject1 = this.a;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(localObject1).append(", senderOrDeliveree=");
      if (this.b == null)
        break label214;
      localObject2 = this.b;
      StringBuilder localStringBuilder3 = localStringBuilder2.append(localObject2).append(", messageSource='");
      if (this.c == null)
        break label221;
      str1 = this.c;
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str1).append('\'').append(", type=").append(this.d).append(", messageId='");
      if (this.e == null)
        break label228;
      str2 = this.e;
      localStringBuilder5 = localStringBuilder4.append(str2).append('\'').append(", offlineThreadingId='");
      if (this.f == null)
        break label235;
    }
    label214: label221: label228: label235: for (String str3 = this.f; ; str3 = "")
    {
      return str3 + '\'' + ", timestampMs=" + this.g + ", sentTimestampMs=" + this.h + ", receiptTimestampMs=" + this.i + '}';
      localObject1 = "";
      break;
      localObject2 = "";
      break label49;
      str1 = "";
      break label75;
      str2 = "";
      break label119;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.RowReceiptItem
 * JD-Core Version:    0.6.0
 */