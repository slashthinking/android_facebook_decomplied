package com.facebook.orca.common.names;

import com.facebook.orca.common.util.Hex;
import com.facebook.orca.common.util.StringUtil;
import java.text.CollationKey;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.Locale;

public class NameNormalizer
{
  private static final RuleBasedCollator a = (RuleBasedCollator)Collator.getInstance(Locale.getDefault());
  private static final RuleBasedCollator b;

  static
  {
    a.setStrength(0);
    a.setDecomposition(1);
    b = (RuleBasedCollator)Collator.getInstance(Locale.getDefault());
    b.setStrength(2);
  }

  public static String a(String paramString)
  {
    String str = StringUtil.b(paramString);
    return Hex.a(a.getCollationKey(b(str)).toByteArray(), true);
  }

  private static String b(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int j = 0;
    while (i < arrayOfChar.length)
    {
      char c = arrayOfChar[i];
      if (Character.isLetterOrDigit(c))
      {
        int k = j + 1;
        arrayOfChar[j] = c;
        j = k;
      }
      i++;
    }
    if (j != arrayOfChar.length)
      paramString = new String(arrayOfChar, 0, j);
    return paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.names.NameNormalizer
 * JD-Core Version:    0.6.0
 */