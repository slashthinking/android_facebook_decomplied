package com.facebook.orca.threadview;

import com.facebook.orca.attachments.AudioAttachmentData;
import com.facebook.orca.attachments.ImageAttachmentData;
import com.facebook.orca.attachments.ImageAttachmentData.Orientation;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class RowMessageItem extends RowItem
{
  private final Message a;
  private final String b;
  private final RowReceiptItem c;
  private final List<ImageAttachmentData> d;
  private final AudioAttachmentData e;
  private boolean f;

  public RowMessageItem(Message paramMessage, String paramString)
  {
    this(paramMessage, paramString, null);
  }

  public RowMessageItem(Message paramMessage, String paramString, List<ImageAttachmentData> paramList)
  {
    this(paramMessage, paramString, paramList, null);
  }

  public RowMessageItem(Message paramMessage, String paramString, List<ImageAttachmentData> paramList, AudioAttachmentData paramAudioAttachmentData)
  {
    this(paramMessage, paramString, paramList, paramAudioAttachmentData, null);
  }

  public RowMessageItem(Message paramMessage, String paramString, List<ImageAttachmentData> paramList, AudioAttachmentData paramAudioAttachmentData, RowReceiptItem paramRowReceiptItem)
  {
    this.a = paramMessage;
    this.b = paramString;
    this.d = paramList;
    this.e = paramAudioAttachmentData;
    this.c = paramRowReceiptItem;
  }

  private int e()
  {
    ImageAttachmentData.Orientation localOrientation = ((ImageAttachmentData)this.d.get(0)).f();
    int i;
    if ((localOrientation == ImageAttachmentData.Orientation.PORTRAIT) || (localOrientation == ImageAttachmentData.Orientation.SQUARE) || (localOrientation == ImageAttachmentData.Orientation.UNKNOWN))
      if (f())
        i = 16;
    while (true)
    {
      return i;
      i = 7;
      continue;
      if (f())
      {
        i = 17;
        continue;
      }
      i = 8;
    }
  }

  private boolean f()
  {
    if ((this.a.f() != null) && (this.a.f().e() != null) && (Objects.equal(this.a.f().e().b(), this.b)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public int a()
  {
    int i = 6;
    if (this.a.q())
      i = 0;
    while (true)
    {
      return i;
      if (this.e != null)
      {
        if (f())
        {
          i = 23;
          continue;
        }
        i = 14;
        continue;
      }
      if ((this.d == null) || (this.d.isEmpty()))
      {
        if (!f())
          continue;
        i = 15;
        continue;
      }
      if (this.d.size() == 1)
      {
        i = e();
        continue;
      }
      int j = -2 + Math.min(this.d.size(), i);
      if (f())
      {
        i = j + 18;
        continue;
      }
      i = j + 9;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public Message b()
  {
    return this.a;
  }

  public boolean c()
  {
    return this.f;
  }

  public RowReceiptItem d()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = paramObject instanceof RowMessageItem;
    int i = 0;
    if (!bool2)
      return i;
    Message localMessage1 = b();
    Message localMessage2 = ((RowMessageItem)paramObject).b();
    boolean bool3;
    if ((localMessage1.a() != null) && (localMessage2.a() != null) && (Objects.equal(localMessage1.a(), localMessage2.a())))
      bool3 = bool1;
    while (true)
    {
      label67: RowReceiptItem localRowReceiptItem1 = d();
      RowReceiptItem localRowReceiptItem2 = ((RowMessageItem)paramObject).d();
      int j;
      label115: int k;
      if (((localRowReceiptItem1 == null) && (localRowReceiptItem2 == null)) || ((localRowReceiptItem1 != null) && (localRowReceiptItem2 != null) && (localRowReceiptItem1.equals(localRowReceiptItem2))))
      {
        j = bool1;
        if (((localMessage1.m() != null) || (localMessage2.m() != null)) && ((localMessage1.m() == null) || (localMessage2.m() == null) || (localMessage1.m().size() != localMessage2.m().size())))
          break label284;
        k = bool1;
        label169: if ((!bool3) || (j == 0) || (k == 0) || (localMessage1.c() != localMessage2.c()) || (localMessage1.e() != localMessage2.e()) || (localMessage1.r() != localMessage2.r()) || (localMessage1.x() != localMessage2.x()))
          break label290;
      }
      while (true)
      {
        i = bool1;
        break;
        if ((localMessage1.t() == null) || (localMessage2.t() == null))
          break label295;
        bool3 = Objects.equal(localMessage1.t(), localMessage2.t());
        break label67;
        j = 0;
        break label115;
        label284: k = 0;
        break label169;
        label290: bool1 = false;
      }
      label295: bool3 = false;
    }
  }

  public int hashCode()
  {
    if (b().a() != null);
    for (int i = b().a().hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = b().t();
      int k = 0;
      if (str != null)
        k = b().t().hashCode();
      return j + k;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("RowMessageItem{message=").append(this.a).append(", rowReceiptItem=");
    if (this.c != null);
    for (Object localObject = this.c; ; localObject = "")
      return localObject + '}';
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.RowMessageItem
 * JD-Core Version:    0.6.0
 */