package com.facebook.orca.common.util;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StyledStringBuilder
{
  private final Resources a;
  private SpannableStringBuilder b = new SpannableStringBuilder();
  private LinkedList<StyledStringBuilder.SpanStart> c = Lists.b();

  public StyledStringBuilder(Resources paramResources)
  {
    this.a = paramResources;
  }

  public StyledStringBuilder a()
  {
    if (!this.c.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      StyledStringBuilder.SpanStart localSpanStart = (StyledStringBuilder.SpanStart)this.c.removeFirst();
      this.b.setSpan(localSpanStart.b, localSpanStart.a, this.b.length(), localSpanStart.c);
      return this;
    }
  }

  public StyledStringBuilder a(int paramInt)
  {
    this.b.append(this.a.getString(paramInt));
    return this;
  }

  public StyledStringBuilder a(Object paramObject, int paramInt)
  {
    this.c.addFirst(new StyledStringBuilder.SpanStart(this.b.length(), paramObject, paramInt));
    return this;
  }

  public StyledStringBuilder a(String paramString)
  {
    this.b.append(paramString);
    return this;
  }

  public StyledStringBuilder a(String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    Preconditions.checkState(this.c.isEmpty());
    Matcher localMatcher = Pattern.compile(Pattern.quote(paramString1)).matcher(this.b);
    if (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      this.b.replace(i, j, paramString2);
      this.b.setSpan(paramObject, i, i + paramString2.length(), paramInt);
    }
    return this;
  }

  public SpannableString b()
  {
    return new SpannableString(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.StyledStringBuilder
 * JD-Core Version:    0.6.2
 */