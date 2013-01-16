package com.facebook.orca.messageview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadDateUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.RowReceiptParticipant;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;

public class MessageReaderListView extends CustomViewGroup
{
  private ThreadDateUtil a;
  private ReadView b;
  private LinearLayout c;
  private ReadView d;
  private MessageReaderListView.Parameters e;

  public MessageReaderListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public MessageReaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public MessageReaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private String a(RowReceiptParticipant paramRowReceiptParticipant)
  {
    StringBuilder localStringBuilder = new StringBuilder(30);
    localStringBuilder.append(paramRowReceiptParticipant.a().d());
    localStringBuilder.append(" · ");
    localStringBuilder.append(this.a.c(paramRowReceiptParticipant.b()));
    return localStringBuilder.toString();
  }

  private void a()
  {
    int i;
    int j;
    if (this.e.a() != null)
    {
      i = this.e.a().size();
      if (this.e.b() == null)
        break label121;
      j = this.e.b().size();
      label46: int k = i + j;
      this.b.setVisibility(0);
      if ((-1 + this.e.c().i().size() != k) || (!a(this.e.a())))
        break label126;
      this.b.setText(getContext().getString(2131362684));
      this.b.setShowReadReceiptIcon(true);
    }
    while (true)
    {
      return;
      i = 0;
      break;
      label121: j = 0;
      break label46;
      label126: if (b(this.e.a()))
        b();
      if (!b(this.e.b()))
        continue;
      c();
    }
  }

  private void a(Context paramContext)
  {
    setContentView(2130903376);
    this.a = ((ThreadDateUtil)getInjector().a(ThreadDateUtil.class));
    this.b = ((ReadView)getView(2131297355));
    this.c = ((LinearLayout)getView(2131297356));
    this.d = ((ReadView)getView(2131297357));
  }

  private boolean a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean a(List paramList1, List paramList2)
  {
    int i = 1;
    if ((a(paramList1)) && (paramList2.size() == i));
    while (true)
    {
      return i;
      i = 0;
    }
  }

  private void b()
  {
    this.b.setText(getContext().getString(2131362683));
    this.b.setShowReadReceiptIcon(false);
    if (a(this.e.b(), this.e.a()))
    {
      ReadView localReadView2 = this.b;
      Context localContext = getContext();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a((RowReceiptParticipant)this.e.a().get(0));
      localReadView2.setText(localContext.getString(2131362685, arrayOfObject));
      this.b.setShowReadReceiptIcon(true);
    }
    while (true)
    {
      return;
      Iterator localIterator = this.e.a().iterator();
      while (localIterator.hasNext())
      {
        RowReceiptParticipant localRowReceiptParticipant = (RowReceiptParticipant)localIterator.next();
        ReadView localReadView1 = new ReadView(getContext());
        localReadView1.setText(a(localRowReceiptParticipant));
        this.c.addView(localReadView1);
      }
      this.c.setVisibility(0);
    }
  }

  private boolean b(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private void c()
  {
    if (d())
      if (!b(this.e.a()))
        this.b.setVisibility(8);
    while (true)
    {
      return;
      if (a(this.e.a(), this.e.b()))
      {
        ReadView localReadView2 = this.b;
        Context localContext2 = getContext();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = ((ParticipantInfo)this.e.b().get(0)).d();
        localReadView2.setText(localContext2.getString(2131362685, arrayOfObject2));
        this.b.setShowReadReceiptIcon(true);
        continue;
      }
      StringBuilder localStringBuilder = new StringBuilder(50);
      Iterator localIterator = this.e.b().iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        ParticipantInfo localParticipantInfo = (ParticipantInfo)localIterator.next();
        if (Objects.equal(localParticipantInfo.e(), this.e.d().f().e()))
          continue;
        if (i == 0)
          localStringBuilder.append(", ");
        while (true)
        {
          localStringBuilder.append(localParticipantInfo.d());
          break;
          i = 0;
        }
      }
      if (b(this.e.a()))
      {
        this.b.setShowReadReceiptIcon(false);
        this.d.setText(localStringBuilder.toString());
        this.d.setVisibility(0);
        continue;
      }
      ReadView localReadView1 = this.b;
      Context localContext1 = getContext();
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = localStringBuilder.toString();
      localReadView1.setText(localContext1.getString(2131362686, arrayOfObject1));
      this.b.setShowReadReceiptIcon(true);
    }
  }

  private boolean d()
  {
    if ((this.e.b().size() == 1) && (Objects.equal(((ParticipantInfo)this.e.b().get(0)).e(), this.e.d().f().e())));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void setParameters(MessageReaderListView.Parameters paramParameters)
  {
    Preconditions.checkNotNull("Message cannot be null", paramParameters.d());
    Preconditions.checkNotNull("ThreadSummary cannot be null", paramParameters.c());
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    if ((b(paramParameters.a())) || (b(paramParameters.b())))
    {
      this.e = paramParameters;
      a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.messageview.MessageReaderListView
 * JD-Core Version:    0.6.0
 */