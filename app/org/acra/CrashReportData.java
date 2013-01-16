package org.acra;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class CrashReportData extends EnumMap<ReportField, String>
{
  private static final int CONTINUE = 3;
  private static final int IGNORE = 5;
  private static final int KEY_DONE = 4;
  private static final int NONE = 0;
  private static final String PROP_DTD_NAME = "http://java.sun.com/dtd/properties.dtd";
  private static final int SLASH = 1;
  private static final int UNICODE = 2;
  private static String lineSeparator = "\n";
  private static final long serialVersionUID = 4112578634029874840L;
  protected CrashReportData defaults;

  public CrashReportData()
  {
    super(ReportField.class);
  }

  public CrashReportData(CrashReportData paramCrashReportData)
  {
    super(ReportField.class);
    this.defaults = paramCrashReportData;
  }

  private void dumpString(Writer paramWriter, String paramString, boolean paramBoolean)
  {
    int i;
    if ((!paramBoolean) && (paramString.length() < 0) && (paramString.charAt(0) == ' '))
    {
      paramWriter.write("\\ ");
      i = 1;
    }
    while (true)
    {
      if (i < paramString.length())
      {
        int j = paramString.charAt(i);
        switch (j)
        {
        case 11:
        default:
          if (("\\#!=:".indexOf(j) >= 0) || ((paramBoolean) && (j == 32)))
            paramWriter.write(92);
          if ((j < 32) || (j > 126))
            break;
          paramWriter.write(j);
        case 9:
        case 10:
        case 12:
        case 13:
        }
        while (true)
        {
          i++;
          break;
          paramWriter.write("\\t");
          continue;
          paramWriter.write("\\n");
          continue;
          paramWriter.write("\\f");
          continue;
          paramWriter.write("\\r");
          continue;
          String str = Integer.toHexString(j);
          paramWriter.write("\\u");
          for (int k = 0; k < 4 - str.length(); k++)
            paramWriter.write("0");
          paramWriter.write(str);
        }
      }
      return;
      i = 0;
    }
  }

  public static Writer getWriter(OutputStream paramOutputStream)
  {
    try
    {
      localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, "ISO8859_1");
      return localOutputStreamWriter;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        OutputStreamWriter localOutputStreamWriter = null;
    }
  }

  private boolean isEbcdic(BufferedInputStream paramBufferedInputStream)
  {
    int i = (byte)paramBufferedInputStream.read();
    int j = 0;
    if (i != -1)
    {
      j = 0;
      if (i != 35)
      {
        j = 0;
        if (i != 10)
        {
          j = 0;
          if (i != 61)
            break label39;
        }
      }
    }
    while (true)
    {
      return j;
      label39: if (i != 21)
        break;
      j = 1;
    }
  }

  private Enumeration<ReportField> keys()
  {
    return Collections.enumeration(keySet());
  }

  private String substitutePredefinedEntries(String paramString)
  {
    return paramString.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("'", "&apos;").replaceAll("\"", "&quot;");
  }

  public String getProperty(ReportField paramReportField)
  {
    String str = (String)super.get(paramReportField);
    if ((str == null) && (this.defaults != null))
      str = this.defaults.getProperty(paramReportField);
    return str;
  }

  public String getProperty(ReportField paramReportField, String paramString)
  {
    String str = (String)super.get(paramReportField);
    if ((str == null) && (this.defaults != null))
      str = this.defaults.getProperty(paramReportField);
    if (str == null);
    while (true)
    {
      return paramString;
      paramString = str;
    }
  }

  public void list(PrintStream paramPrintStream)
  {
    if (paramPrintStream == null)
      throw new NullPointerException();
    StringBuilder localStringBuilder = new StringBuilder(80);
    Enumeration localEnumeration = keys();
    if (localEnumeration.hasMoreElements())
    {
      ReportField localReportField = (ReportField)localEnumeration.nextElement();
      localStringBuilder.append(localReportField);
      localStringBuilder.append('=');
      String str = (String)super.get(localReportField);
      for (CrashReportData localCrashReportData = this.defaults; str == null; localCrashReportData = localCrashReportData.defaults)
        str = (String)localCrashReportData.get(localReportField);
      if (str.length() > 40)
      {
        localStringBuilder.append(str.substring(0, 37));
        localStringBuilder.append("...");
      }
      while (true)
      {
        paramPrintStream.println(localStringBuilder.toString());
        localStringBuilder.setLength(0);
        break;
        localStringBuilder.append(str);
      }
    }
  }

  public void list(PrintWriter paramPrintWriter)
  {
    if (paramPrintWriter == null)
      throw new NullPointerException();
    StringBuilder localStringBuilder = new StringBuilder(80);
    Enumeration localEnumeration = keys();
    if (localEnumeration.hasMoreElements())
    {
      ReportField localReportField = (ReportField)localEnumeration.nextElement();
      localStringBuilder.append(localReportField);
      localStringBuilder.append('=');
      String str = (String)super.get(localReportField);
      for (CrashReportData localCrashReportData = this.defaults; str == null; localCrashReportData = localCrashReportData.defaults)
        str = (String)localCrashReportData.get(localReportField);
      if (str.length() > 40)
      {
        localStringBuilder.append(str.substring(0, 37));
        localStringBuilder.append("...");
      }
      while (true)
      {
        paramPrintWriter.println(localStringBuilder.toString());
        localStringBuilder.setLength(0);
        break;
        localStringBuilder.append(str);
      }
    }
  }

  public void load(InputStream paramInputStream)
  {
    monitorenter;
    if (paramInputStream == null)
      try
      {
        throw new NullPointerException();
      }
      finally
      {
        monitorexit;
      }
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream);
    localBufferedInputStream.mark(2147483647);
    boolean bool = isEbcdic(localBufferedInputStream);
    localBufferedInputStream.reset();
    if (!bool)
      load(new InputStreamReader(localBufferedInputStream, "ISO8859-1"));
    while (true)
    {
      monitorexit;
      return;
      load(new InputStreamReader(localBufferedInputStream));
    }
  }

  public void load(Reader paramReader)
  {
    monitorenter;
    Object localObject2;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    char c1;
    int i26;
    int i6;
    label177: int i25;
    int i5;
    label223: int i8;
    int i9;
    label257: int i4;
    label277: int i18;
    while (true)
    {
      BufferedReader localBufferedReader;
      int i2;
      try
      {
        localObject2 = new char[40];
        i = 0;
        j = -1;
        localBufferedReader = new BufferedReader(paramReader);
        k = 1;
        m = 0;
        n = 0;
        i1 = 0;
        i2 = localBufferedReader.read();
        if (i2 == -1)
        {
          if ((n != 2) || (i1 > 4))
            break label1076;
          throw new IllegalArgumentException("luni.08");
        }
      }
      finally
      {
        monitorexit;
      }
      c1 = (char)i2;
      if (i == localObject2.length)
      {
        char[] arrayOfChar = new char[2 * localObject2.length];
        System.arraycopy(localObject2, 0, arrayOfChar, 0, i);
        localObject2 = arrayOfChar;
      }
      if (n != 2)
        break label484;
      int i24 = Character.digit(c1, 16);
      if (i24 >= 0)
      {
        i26 = i24 + (m << 4);
        i6 = i1 + 1;
        if (i6 >= 4)
          break;
        i1 = i6;
        m = i26;
        continue;
      }
      else
      {
        if (i1 > 4)
          break label503;
        throw new IllegalArgumentException("luni.09");
        i25 = i + 1;
        localObject2[i] = (char)i5;
        if ((c1 == '\n') || (c1 == ''))
          break label514;
        i = i25;
        i1 = i6;
        m = i5;
        n = 0;
        continue;
        int i10 = i + 1;
        localObject2[i] = i8;
        i = i10;
        i1 = i6;
        m = i5;
        n = i9;
        k = 0;
        continue;
        if (!Character.isWhitespace(c1))
          break label1054;
        if (i4 != 3)
          break label800;
        i4 = 5;
        break label800;
        i18 = localBufferedReader.read();
        if (i18 != -1)
          break label845;
        int i21 = i6;
        m = i5;
        n = i4;
        i1 = i21;
        continue;
        label309: String str1 = new String(localObject2, 0, i);
        put(Enum.valueOf(ReportField.class, str1.substring(0, j)), str1.substring(j));
        break label943;
      }
    }
    while (true)
    {
      if (j >= 0)
      {
        String str2 = new String(localObject2, 0, i);
        ReportField localReportField = (ReportField)Enum.valueOf(ReportField.class, str2.substring(0, j));
        String str3 = str2.substring(j);
        if (n == 1)
          str3 = str3 + "";
        put(localReportField, str3);
      }
      monitorexit;
      return;
      label436: char c2 = c1;
      i9 = i4;
      i8 = c2;
      break label623;
      label451: int i11 = i6;
      m = i5;
      n = i4;
      i1 = i11;
      break;
      label470: int i14 = j;
      break label980;
      i5 = i26;
      break label177;
      label484: int i3 = i1;
      i4 = n;
      i5 = m;
      i6 = i3;
      break label521;
      label503: i5 = m;
      i6 = i1;
      break label177;
      label514: i = i25;
      i4 = 0;
      label521: if (i4 == 1)
        switch (c1)
        {
        default:
          label612: char c3 = c1;
          i9 = 0;
          i8 = c3;
        case '\r':
        case '\n':
        case '':
        case 'b':
        case 'f':
        case 'n':
        case 'r':
        case 't':
        case 'u':
        }
      while (true)
      {
        label623: if (i9 != 4)
          break label223;
        j = i;
        i9 = 0;
        break label223;
        int i23 = i6;
        m = i5;
        n = 3;
        i1 = i23;
        break;
        int i22 = i6;
        m = i5;
        n = 5;
        i1 = i22;
        break;
        c1 = '\b';
        break label612;
        c1 = '\f';
        break label612;
        c1 = '\n';
        break label612;
        c1 = '\r';
        break label612;
        c1 = '\t';
        break label612;
        n = 2;
        i1 = 0;
        m = 0;
        break;
        switch (c1)
        {
        default:
          if ((i == 0) || (i == j))
            break label451;
          if (i4 == 5)
          {
            int i13 = i6;
            m = i5;
            n = i4;
            i1 = i13;
          }
          break;
        case '!':
        case '#':
          if (k == 0)
            break label257;
          break label277;
          int i19 = (char)i18;
          if ((i19 == 13) || (i19 == 10))
            break label451;
          if (i19 != 133)
            break label277;
          int i20 = i6;
          m = i5;
          n = i4;
          i1 = i20;
          break;
        case '\n':
          if (i4 == 3)
          {
            int i17 = i6;
            m = i5;
            n = 5;
            i1 = i17;
          }
          break;
        case '\r':
        case '':
          if ((i > 0) || ((i == 0) && (j == 0)))
          {
            if (j != -1)
              break label309;
            j = i;
            break label309;
          }
          j = -1;
          k = 1;
          int i16 = i6;
          m = i5;
          i1 = i16;
          i = 0;
          n = 0;
          break;
        case '\\':
          if (i4 != 4)
            break label470;
          i14 = i;
          j = i14;
          int i15 = i6;
          m = i5;
          n = 1;
          i1 = i15;
          break;
        case ':':
        case '=':
          label800: label845: label980: if (j != -1)
            break label257;
          label943: j = i;
          int i7 = i6;
          m = i5;
          i1 = i7;
          n = 0;
          break;
          if (j == -1)
          {
            int i12 = i6;
            m = i5;
            n = 4;
            i1 = i12;
            break;
          }
          label1054: if ((i4 != 5) && (i4 != 3))
            break label436;
          i8 = c1;
          i9 = 0;
        }
      }
      label1076: if ((j != -1) || (i <= 0))
        continue;
      j = i;
    }
  }

  public String put(ReportField paramReportField, String paramString, Writer paramWriter)
  {
    if (paramWriter != null)
      storeKeyValuePair(paramWriter, paramReportField, paramString);
    return (String)put(paramReportField, paramString);
  }

  @Deprecated
  public void save(OutputStream paramOutputStream, String paramString)
  {
    try
    {
      store(paramOutputStream, paramString);
      label6: return;
    }
    catch (IOException localIOException)
    {
      break label6;
    }
  }

  public Object setProperty(ReportField paramReportField, String paramString)
  {
    return put(paramReportField, paramString);
  }

  public void store(OutputStream paramOutputStream, String paramString)
  {
    monitorenter;
    try
    {
      store(getWriter(paramOutputStream), paramString);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void store(Writer paramWriter, String paramString)
  {
    monitorenter;
    if (paramString != null);
    try
    {
      storeComment(paramWriter, paramString);
      Iterator localIterator = entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        storeKeyValuePair(paramWriter, (ReportField)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    finally
    {
      monitorexit;
    }
    paramWriter.flush();
    monitorexit;
  }

  public void storeComment(Writer paramWriter, String paramString)
  {
    monitorenter;
    try
    {
      paramWriter.write("#");
      paramWriter.write(paramString);
      paramWriter.write(lineSeparator);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void storeKeyValuePair(Writer paramWriter, ReportField paramReportField, String paramString)
  {
    monitorenter;
    try
    {
      dumpString(paramWriter, paramReportField.toString(), true);
      paramWriter.write("=");
      dumpString(paramWriter, paramString, false);
      paramWriter.write(lineSeparator);
      paramWriter.flush();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void storeToXML(OutputStream paramOutputStream, String paramString)
  {
    storeToXML(paramOutputStream, paramString, "UTF-8");
  }

  public void storeToXML(OutputStream paramOutputStream, String paramString1, String paramString2)
  {
    monitorenter;
    if ((paramOutputStream == null) || (paramString2 == null))
      try
      {
        throw new NullPointerException();
      }
      finally
      {
        monitorexit;
      }
    try
    {
      String str4 = Charset.forName(paramString2).name();
      str1 = str4;
      localPrintStream = new PrintStream(paramOutputStream, false, str1);
      localPrintStream.print("<?xml version=\"1.0\" encoding=\"");
      localPrintStream.print(str1);
      localPrintStream.println("\"?>");
      localPrintStream.print("<!DOCTYPE properties SYSTEM \"");
      localPrintStream.print("http://java.sun.com/dtd/properties.dtd");
      localPrintStream.println("\">");
      localPrintStream.println("<properties>");
      if (paramString1 != null)
      {
        localPrintStream.print("<comment>");
        localPrintStream.print(substitutePredefinedEntries(paramString1));
        localPrintStream.println("</comment>");
      }
      Iterator localIterator = entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str2 = ((ReportField)localEntry.getKey()).toString();
        String str3 = (String)localEntry.getValue();
        localPrintStream.print("<entry key=\"");
        localPrintStream.print(substitutePredefinedEntries(str2));
        localPrintStream.print("\">");
        localPrintStream.print(substitutePredefinedEntries(str3));
        localPrintStream.println("</entry>");
      }
    }
    catch (IllegalCharsetNameException localIllegalCharsetNameException)
    {
      while (true)
      {
        System.out.println("Warning: encoding name " + paramString2 + " is illegal, using UTF-8 as default encoding");
        str1 = "UTF-8";
      }
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      PrintStream localPrintStream;
      while (true)
      {
        System.out.println("Warning: encoding " + paramString2 + " is not supported, using UTF-8 as default encoding");
        String str1 = "UTF-8";
      }
      localPrintStream.println("</properties>");
      localPrintStream.flush();
      monitorexit;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.CrashReportData
 * JD-Core Version:    0.6.0
 */