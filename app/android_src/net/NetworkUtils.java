package android_src.net;

public class NetworkUtils
{
  public static String a(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (true)
    {
      return paramString;
      String[] arrayOfString = paramString.split("\\.");
      if (arrayOfString.length != 4)
        continue;
      StringBuilder localStringBuilder = new StringBuilder(16);
      int i = 0;
      label33: if (i < 4);
      try
      {
        if (arrayOfString[i].length() > 3)
          continue;
        localStringBuilder.append(Integer.parseInt(arrayOfString[i]));
        if (i < 3)
          localStringBuilder.append('.');
        i++;
        break label33;
        paramString = localStringBuilder.toString();
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.net.NetworkUtils
 * JD-Core Version:    0.6.0
 */