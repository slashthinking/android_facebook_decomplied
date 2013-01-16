package com.facebook.widget;

import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;

class SimpleVariableTextLayoutView$Computer
  implements VariableTextLayoutComputer<String>
{
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

  private SimpleVariableTextLayoutView.Result a(List<TextPaint> paramList, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = paramList.iterator();
    TextPaint localTextPaint;
    do
    {
      if (!localIterator.hasNext())
        break;
      localTextPaint = (TextPaint)localIterator.next();
    }
    while (!a(localTextPaint, paramString, paramInt1));
    for (SimpleVariableTextLayoutView.Result localResult = new SimpleVariableTextLayoutView.Result(localTextPaint, ImmutableList.a(paramString)); ; localResult = new SimpleVariableTextLayoutView.Result((TextPaint)paramList.get(-1 + paramList.size()), ImmutableList.a(paramString)))
      return localResult;
  }

  private boolean a(TextPaint paramTextPaint, String paramString, int paramInt)
  {
    if (paramTextPaint.measureText(paramString) <= paramInt);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Layout a(String paramString, List<TextPaint> paramList, int paramInt1, Layout.Alignment paramAlignment, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (paramInt2 == i);
    while (true)
    {
      Preconditions.checkArgument(i);
      SimpleVariableTextLayoutView.Result localResult = a(paramList, paramString, paramInt1, paramInt2, paramInt3);
      return a(localResult.b, localResult.a, paramInt1, paramAlignment);
      i = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.SimpleVariableTextLayoutView.Computer
 * JD-Core Version:    0.6.2
 */