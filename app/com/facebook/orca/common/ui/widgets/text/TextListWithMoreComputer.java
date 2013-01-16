package com.facebook.orca.common.ui.widgets.text;

import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class TextListWithMoreComputer
{
  private final StringBuilder a = new StringBuilder(30);

  private float a(CharSequence paramCharSequence, boolean paramBoolean, TextPaint paramTextPaint)
  {
    this.a.setLength(0);
    if (paramBoolean)
      this.a.append(", ").append(paramCharSequence);
    while (true)
    {
      return paramTextPaint.measureText(this.a, 0, this.a.length());
      this.a.append(paramCharSequence);
    }
  }

  private int a(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      i = 0;
      if (j != 0)
        break label19;
    }
    while (true)
    {
      return i;
      label19: if ((paramArrayOfInt.length == 1) || (paramInt < 10))
      {
        i = paramArrayOfInt[0];
        continue;
      }
      if ((paramArrayOfInt.length == 2) || (paramInt < 100))
      {
        i = paramArrayOfInt[1];
        continue;
      }
      i = paramArrayOfInt[2];
    }
  }

  private String a(String paramString, TextPaint paramTextPaint, float paramFloat)
  {
    float f1 = paramTextPaint.measureText("…, ");
    int i = paramString.length();
    float f2 = paramTextPaint.measureText(paramString);
    while ((paramFloat < f2) && (i > 3))
    {
      i -= Character.charCount(paramString.codePointBefore(i));
      f2 = f1 + paramTextPaint.measureText(paramString, 0, i);
    }
    if (paramFloat >= f2);
    for (String str = paramString.substring(0, i); ; str = null)
      return str;
  }

  private void a(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
      paramStringBuilder.append(", ");
    paramStringBuilder.append(paramString);
  }

  public TextListWithMoreComputer.Result a(List<String> paramList, int paramInt1, int paramInt2, int paramInt3, TextPaint paramTextPaint, int[] paramArrayOfInt)
  {
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = Math.max(paramInt3, f1);
    ArrayList localArrayList = Lists.a();
    TextListWithMoreComputer.PeekingIteratorWithCount localPeekingIteratorWithCount = TextListWithMoreComputer.PeekingIteratorWithCount.a(paramList);
    int i = -1;
    float f3 = paramTextPaint.measureText(",");
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    float f4;
    float f6;
    int j;
    String str1;
    boolean bool1;
    label141: float f7;
    float f8;
    if ((paramInt2 > 0) && (localPeekingIteratorWithCount.b() > 0) && (f2 >= f1))
    {
      paramInt2--;
      f4 = f2 - f1;
      float f5 = paramInt1;
      localStringBuilder1.setLength(0);
      f6 = f5;
      j = i;
      if (localPeekingIteratorWithCount.hasNext())
      {
        str1 = (String)localPeekingIteratorWithCount.a();
        if (localStringBuilder1.length() != 0)
        {
          bool1 = true;
          f7 = a(str1, bool1, paramTextPaint);
          if ((localPeekingIteratorWithCount.b() <= 1) || (paramInt2 <= 0))
            break label599;
          f8 = f7 + f3;
        }
      }
    }
    while (true)
    {
      int n;
      if ((paramInt2 > 0) && (f4 >= f1))
      {
        if (f8 < f6)
        {
          localPeekingIteratorWithCount.next();
          if (localStringBuilder1.length() > 0);
          for (boolean bool5 = true; ; bool5 = false)
          {
            a(localStringBuilder1, str1, bool5);
            n = j;
            label224: f6 -= f7;
            j = n;
            break;
            bool1 = false;
            break label141;
          }
        }
        localStringBuilder1.append(",");
      }
      label258: int k;
      int m;
      while (true)
      {
        if (localStringBuilder1.length() != 0)
          localArrayList.add(localStringBuilder1.toString());
        i = j;
        f2 = f4;
        break;
        if (localPeekingIteratorWithCount.b() == 1)
        {
          if (f6 < f7)
          {
            j = 1;
            localPeekingIteratorWithCount.next();
            n = j;
            break label224;
          }
          if (localStringBuilder1.length() > 0);
          for (boolean bool4 = true; ; bool4 = false)
          {
            a(localStringBuilder1, str1, bool4);
            break;
          }
        }
        k = localPeekingIteratorWithCount.b();
        m = a(paramArrayOfInt, localPeekingIteratorWithCount.b());
        if (f6 - f7 >= m)
          break label540;
        if (k >= 5)
          break label482;
        StringBuilder localStringBuilder2 = new StringBuilder();
        if (localPeekingIteratorWithCount.hasNext())
        {
          String str3 = (String)localPeekingIteratorWithCount.next();
          if ((localStringBuilder1.length() != 0) || (localStringBuilder2.length() != 0));
          for (boolean bool3 = true; ; bool3 = false)
          {
            a(localStringBuilder2, str3, bool3);
            break;
          }
        }
        if (a(localStringBuilder2, false, paramTextPaint) > f6)
          break label482;
        localStringBuilder1.append(localStringBuilder2);
      }
      label482: if (localStringBuilder1.length() == 0)
      {
        String str2 = a(str1, paramTextPaint, f6 - m);
        if (str2 != null)
        {
          localStringBuilder1.append(str2);
          localStringBuilder1.append("…");
        }
      }
      for (int i1 = k - 1; ; i1 = k)
      {
        j = i1;
        break label258;
        label540: localPeekingIteratorWithCount.next();
        if (localStringBuilder1.length() > 0);
        for (boolean bool2 = true; ; bool2 = false)
        {
          a(localStringBuilder1, str1, bool2);
          n = j;
          break;
        }
        return new TextListWithMoreComputer.Result(localArrayList, i);
      }
      label599: f8 = f7;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.TextListWithMoreComputer
 * JD-Core Version:    0.6.0
 */