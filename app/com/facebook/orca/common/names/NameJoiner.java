package com.facebook.orca.common.names;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import java.util.Locale;
import javax.inject.Provider;

public final class NameJoiner
{
  private final Provider<Locale> a;

  public NameJoiner(Provider<Locale> paramProvider)
  {
    this.a = paramProvider;
  }

  public String a(String paramString1, String paramString2)
  {
    String str1 = ((Locale)this.a.b()).getLanguage();
    Joiner localJoiner;
    if (LanguageNameFormats.b.contains(str1))
    {
      localJoiner = Joiner.on("");
      if (!LanguageNameFormats.a.contains(str1))
        break label69;
    }
    label69: for (String str2 = localJoiner.join(paramString2, paramString1, new Object[0]); ; str2 = localJoiner.join(paramString1, paramString2, new Object[0]))
    {
      return str2;
      localJoiner = Joiner.on(" ");
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.names.NameJoiner
 * JD-Core Version:    0.6.0
 */