package com.facebook.task;

import android.os.Handler;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.app.UserInteractionListener;
import com.facebook.orca.common.util.Clock;
import java.util.LinkedList;

public class IncrementalTaskExecutor
{
  private final LinkedList<IncrementalTask> a = new LinkedList();
  private final Handler b;
  private final Clock c;
  private final UserInteractionListener d;
  private long e = 4L;
  private long f = 17L;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;

  public IncrementalTaskExecutor(Clock paramClock, UserInteractionController paramUserInteractionController)
  {
    this.c = paramClock;
    this.b = new Handler(new IncrementalTaskExecutor.1(this));
    if (paramUserInteractionController != null)
    {
      this.d = new IncrementalTaskExecutor.2(this);
      paramUserInteractionController.a(this.d);
    }
    while (true)
    {
      return;
      this.d = null;
    }
  }

  private void a()
  {
    if ((this.h) && (!this.i));
    label140: 
    while (true)
    {
      return;
      long l1 = this.c.a();
      this.h = false;
      long l2 = this.c.a() + this.e;
      while (true)
      {
        if (this.a.isEmpty())
          break label140;
        long l3 = this.c.a();
        if (l3 >= l2)
        {
          a(Math.max(l1 + this.f - l3, 0L));
          break;
        }
        this.g = true;
        IncrementalTask localIncrementalTask = (IncrementalTask)this.a.getFirst();
        a(localIncrementalTask, l2);
        if (localIncrementalTask.e())
          this.a.removeFirst();
        this.g = false;
      }
    }
  }

  private void a(long paramLong)
  {
    if ((!this.b.hasMessages(0)) && (!this.a.isEmpty()))
      this.b.sendEmptyMessageDelayed(0, paramLong);
  }

  private boolean a(IncrementalTask paramIncrementalTask, long paramLong)
  {
    int j;
    if (!paramIncrementalTask.e())
    {
      this.c.a();
      if (this.c.a() >= paramLong)
        j = 1;
    }
    while (true)
    {
      return j;
      LinkedList localLinkedList = paramIncrementalTask.g();
      if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
      {
        IncrementalTask localIncrementalTask = (IncrementalTask)localLinkedList.getFirst();
        while (true)
          if (a(localIncrementalTask, paramLong))
          {
            if (this.c.a() < paramLong)
              continue;
            j = 1;
            break;
          }
        localLinkedList.removeFirst();
      }
      while (true)
      {
        this.c.a();
        break;
        paramIncrementalTask.c();
      }
      j = 0;
    }
  }

  public void a(IncrementalTask paramIncrementalTask)
  {
    if (this.g)
    {
      IncrementalTask localIncrementalTask1 = (IncrementalTask)this.a.getFirst();
      LinkedList localLinkedList1 = localIncrementalTask1.g();
      Object localObject1 = localIncrementalTask1;
      LinkedList localLinkedList2;
      for (Object localObject2 = localLinkedList1; (localObject2 != null) && (!((LinkedList)localObject2).isEmpty()); localObject2 = localLinkedList2)
      {
        IncrementalTask localIncrementalTask2 = (IncrementalTask)((LinkedList)localObject2).getFirst();
        localLinkedList2 = localIncrementalTask2.g();
        localObject1 = localIncrementalTask2;
      }
      ((IncrementalTask)localObject1).b(paramIncrementalTask);
    }
    while (true)
    {
      return;
      c(paramIncrementalTask);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void b(IncrementalTask paramIncrementalTask)
  {
    if (this.g)
      a(paramIncrementalTask);
    while (true)
    {
      return;
      paramIncrementalTask.f();
    }
  }

  public void c(IncrementalTask paramIncrementalTask)
  {
    this.a.addLast(paramIncrementalTask);
    a(0L);
  }

  public boolean d(IncrementalTask paramIncrementalTask)
  {
    return this.a.remove(paramIncrementalTask);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.task.IncrementalTaskExecutor
 * JD-Core Version:    0.6.0
 */