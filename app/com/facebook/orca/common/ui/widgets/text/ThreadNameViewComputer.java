package com.facebook.orca.common.ui.widgets.text;

import android.content.res.Resources;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.widget.VariableTextLayoutComputer;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;

public class ThreadNameViewComputer
  implements VariableTextLayoutComputer<ThreadSummary>
{
  private final ThreadDisplayCache a;
  private final Resources b;
  private final TextListWithMoreComputer c;
  private final ThreadNameView.TextOptions d;

  public ThreadNameViewComputer(ThreadDisplayCache paramThreadDisplayCache, Resources paramResources, TextListWithMoreComputer paramTextListWithMoreComputer, ThreadNameView.TextOptions paramTextOptions)
  {
    this.a = paramThreadDisplayCache;
    this.b = paramResources;
    this.c = paramTextListWithMoreComputer;
    this.d = paramTextOptions;
  }

  private StaticLayout a(List<String> paramList, TextPaint paramTextPaint, int paramInt, Layout.Alignment paramAlignment)
  {
    if (paramList == null);
    String str1;
    for (StaticLayout localStaticLayout = null; ; localStaticLayout = new StaticLayout(str1, 0, str1.length(), paramTextPaint, 16384, paramAlignment, 1.0F, 0.0F, false, TextUtils.TruncateAt.END, paramInt))
    {
      return localStaticLayout;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      for (int i = 1; localIterator.hasNext(); i = 0)
      {
        String str2 = (String)localIterator.next();
        if (i == 0)
          localStringBuilder.append("\n");
        localStringBuilder.append(str2);
      }
      str1 = localStringBuilder.toString();
    }
  }

  private ThreadNameViewComputer.Result a(TextPaint paramTextPaint, String paramString, int paramInt)
  {
    if (paramTextPaint.measureText(paramString) <= paramInt);
    for (ThreadNameViewComputer.Result localResult = new ThreadNameViewComputer.Result(paramTextPaint, ImmutableList.a(paramString)); ; localResult = null)
      return localResult;
  }

  private ThreadNameViewComputer.Result a(List<TextPaint> paramList, List<String> paramList1, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = a(paramList1);
    Iterator localIterator = paramList.iterator();
    ThreadNameViewComputer.Result localResult;
    while (localIterator.hasNext())
    {
      localResult = a((TextPaint)localIterator.next(), str, paramInt1);
      if (localResult != null)
        return localResult;
    }
    if (paramInt3 < 0);
    for (int i = 2147483647; ; i = paramInt3)
    {
      TextPaint localTextPaint = (TextPaint)paramList.get(-1 + paramList.size());
      if (paramList1.size() < 2)
      {
        localResult = new ThreadNameViewComputer.Result(localTextPaint, ImmutableList.a(str));
        break;
      }
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = (int)localTextPaint.measureText(a(8));
      arrayOfInt[1] = (int)localTextPaint.measureText(a(88));
      arrayOfInt[2] = (int)localTextPaint.measureText(a(888));
      TextListWithMoreComputer.Result localResult1 = this.c.a(paramList1, paramInt1, paramInt2, i, localTextPaint, arrayOfInt);
      List localList = localResult1.a();
      int j = localList.size();
      if ((localList.size() > 0) && (localResult1.b() > 0))
        localList.set(j - 1, (String)localList.get(j - 1) + a(localResult1.b()));
      localResult = new ThreadNameViewComputer.Result(localTextPaint, localList);
      break;
    }
  }

  private String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(", ");
    Resources localResources = this.b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return localResources.getString(2131362432, arrayOfObject);
  }

  private String a(List<String> paramList)
  {
    if (!paramList.isEmpty());
    for (String str = Joiner.on(", ").join(paramList); ; str = this.b.getString(2131362431))
      return str;
  }

  public Layout a(ThreadSummary paramThreadSummary, List<TextPaint> paramList, int paramInt1, Layout.Alignment paramAlignment, int paramInt2, int paramInt3)
  {
    TextPaint localTextPaint = (TextPaint)paramList.get(0);
    StaticLayout localStaticLayout;
    if (paramThreadSummary == null)
      localStaticLayout = a(ImmutableList.d(), localTextPaint, paramInt1, paramAlignment);
    while (true)
    {
      return localStaticLayout;
      if ((this.d == ThreadNameView.TextOptions.USE_THREAD_NAME_IF_AVAILABLE) && (paramThreadSummary.e()))
      {
        localStaticLayout = a(ImmutableList.a(paramThreadSummary.f()), localTextPaint, paramInt1, paramAlignment);
        continue;
      }
      ThreadNameViewComputer.Result localResult = a(paramList, this.a.a(paramThreadSummary), paramInt1, paramInt2, paramInt3);
      localStaticLayout = a(localResult.b, localResult.a, paramInt1, paramAlignment);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.ThreadNameViewComputer
 * JD-Core Version:    0.6.0
 */