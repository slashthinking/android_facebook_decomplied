package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

class ValueAnimator$AnimationHandler extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    ArrayList localArrayList1 = (ArrayList)ValueAnimator.q().get();
    ArrayList localArrayList2 = (ArrayList)ValueAnimator.r().get();
    ArrayList localArrayList5;
    int i;
    switch (paramMessage.what)
    {
    default:
      return;
    case 0:
      localArrayList5 = (ArrayList)ValueAnimator.s().get();
      if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0))
        i = 0;
      break;
    case 1:
    }
    while (true)
      if (localArrayList5.size() > 0)
      {
        ArrayList localArrayList6 = (ArrayList)localArrayList5.clone();
        localArrayList5.clear();
        int i7 = localArrayList6.size();
        int i8 = 0;
        if (i8 < i7)
        {
          ValueAnimator localValueAnimator4 = (ValueAnimator)localArrayList6.get(i8);
          if (ValueAnimator.a(localValueAnimator4) == 0L)
            ValueAnimator.b(localValueAnimator4);
          while (true)
          {
            i8++;
            break;
            localArrayList2.add(localValueAnimator4);
          }
          i = 1;
        }
      }
      else
      {
        long l = AnimationUtils.currentAnimationTimeMillis();
        ArrayList localArrayList3 = (ArrayList)ValueAnimator.t().get();
        ArrayList localArrayList4 = (ArrayList)ValueAnimator.u().get();
        int j = localArrayList2.size();
        for (int k = 0; k < j; k++)
        {
          ValueAnimator localValueAnimator3 = (ValueAnimator)localArrayList2.get(k);
          if (ValueAnimator.a(localValueAnimator3, l))
            localArrayList3.add(localValueAnimator3);
        }
        int m = localArrayList3.size();
        if (m > 0)
        {
          for (int i6 = 0; i6 < m; i6++)
          {
            ValueAnimator localValueAnimator2 = (ValueAnimator)localArrayList3.get(i6);
            ValueAnimator.b(localValueAnimator2);
            ValueAnimator.a(localValueAnimator2, true);
            localArrayList2.remove(localValueAnimator2);
          }
          localArrayList3.clear();
        }
        int n = localArrayList1.size();
        int i1 = 0;
        if (i1 < n)
        {
          ValueAnimator localValueAnimator1 = (ValueAnimator)localArrayList1.get(i1);
          if (localValueAnimator1.f(l))
            localArrayList4.add(localValueAnimator1);
          int i4;
          if (localArrayList1.size() == n)
            i4 = i1 + 1;
          int i3;
          for (int i5 = n; ; i5 = i3)
          {
            n = i5;
            i1 = i4;
            break;
            i3 = n - 1;
            localArrayList4.remove(localValueAnimator1);
            i4 = i1;
          }
        }
        if (localArrayList4.size() > 0)
        {
          for (int i2 = 0; i2 < localArrayList4.size(); i2++)
            ValueAnimator.c((ValueAnimator)localArrayList4.get(i2));
          localArrayList4.clear();
        }
        if ((i == 0) || ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty())))
          break;
        sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.v() - (AnimationUtils.currentAnimationTimeMillis() - l)));
        break;
        i = 1;
      }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.ValueAnimator.AnimationHandler
 * JD-Core Version:    0.6.2
 */