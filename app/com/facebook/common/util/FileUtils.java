package com.facebook.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils
{
  // ERROR //
  public static int a(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 14	java/io/FileOutputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 17	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   10: astore_3
    //   11: sipush 1024
    //   14: newarray byte
    //   16: astore 7
    //   18: aload_0
    //   19: aload 7
    //   21: invokevirtual 23	java/io/InputStream:read	([B)I
    //   24: istore 8
    //   26: iload 8
    //   28: ifle +53 -> 81
    //   31: iload_2
    //   32: iload 8
    //   34: iadd
    //   35: istore_2
    //   36: aload_3
    //   37: aload 7
    //   39: iconst_0
    //   40: iload 8
    //   42: invokevirtual 27	java/io/FileOutputStream:write	([BII)V
    //   45: goto -27 -> 18
    //   48: astore 4
    //   50: aload_3
    //   51: ifnull +7 -> 58
    //   54: aload_3
    //   55: invokevirtual 30	java/io/FileOutputStream:close	()V
    //   58: aload_1
    //   59: ifnull +15 -> 74
    //   62: aload_1
    //   63: invokevirtual 36	java/io/File:exists	()Z
    //   66: ifeq +8 -> 74
    //   69: aload_1
    //   70: invokevirtual 39	java/io/File:delete	()Z
    //   73: pop
    //   74: aload_0
    //   75: invokevirtual 40	java/io/InputStream:close	()V
    //   78: aload 4
    //   80: athrow
    //   81: aload_3
    //   82: invokevirtual 30	java/io/FileOutputStream:close	()V
    //   85: iconst_0
    //   86: ifeq +7 -> 93
    //   89: aconst_null
    //   90: invokevirtual 30	java/io/FileOutputStream:close	()V
    //   93: iconst_0
    //   94: ifeq +15 -> 109
    //   97: aconst_null
    //   98: invokevirtual 36	java/io/File:exists	()Z
    //   101: ifeq +8 -> 109
    //   104: aconst_null
    //   105: invokevirtual 39	java/io/File:delete	()Z
    //   108: pop
    //   109: aload_0
    //   110: invokevirtual 40	java/io/InputStream:close	()V
    //   113: iload_2
    //   114: ireturn
    //   115: astore 10
    //   117: goto -24 -> 93
    //   120: astore 6
    //   122: goto -64 -> 58
    //   125: astore 4
    //   127: aconst_null
    //   128: astore_3
    //   129: goto -79 -> 50
    //
    // Exception table:
    //   from	to	target	type
    //   11	45	48	finally
    //   89	93	115	java/io/IOException
    //   54	58	120	java/io/IOException
    //   2	11	125	finally
    //   81	85	125	finally
  }

  public static void a(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      File[] arrayOfFile = localFile.listFiles();
      if (arrayOfFile != null)
        for (int i = 0; i < arrayOfFile.length; i++)
          arrayOfFile[i].delete();
    }
  }

  public static void a(String paramString, FileUtils.deleteFilesCallback paramdeleteFilesCallback)
  {
    new FileUtils.1(paramString, System.currentTimeMillis(), paramdeleteFilesCallback).start();
  }

  // ERROR //
  public static void a(byte[] paramArrayOfByte, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +13 -> 16
    //   6: new 12	java/io/IOException
    //   9: dup
    //   10: ldc 65
    //   12: invokespecial 66	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: new 14	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 17	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: astore_3
    //   25: aload_3
    //   26: aload_0
    //   27: iconst_0
    //   28: aload_0
    //   29: arraylength
    //   30: invokevirtual 27	java/io/FileOutputStream:write	([BII)V
    //   33: aload_3
    //   34: invokevirtual 30	java/io/FileOutputStream:close	()V
    //   37: iconst_0
    //   38: ifeq +7 -> 45
    //   41: aconst_null
    //   42: invokevirtual 30	java/io/FileOutputStream:close	()V
    //   45: iconst_0
    //   46: ifeq +15 -> 61
    //   49: aconst_null
    //   50: invokevirtual 36	java/io/File:exists	()Z
    //   53: ifeq +8 -> 61
    //   56: aconst_null
    //   57: invokevirtual 39	java/io/File:delete	()Z
    //   60: pop
    //   61: return
    //   62: astore 4
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 30	java/io/FileOutputStream:close	()V
    //   72: aload_1
    //   73: ifnull +15 -> 88
    //   76: aload_1
    //   77: invokevirtual 36	java/io/File:exists	()Z
    //   80: ifeq +8 -> 88
    //   83: aload_1
    //   84: invokevirtual 39	java/io/File:delete	()Z
    //   87: pop
    //   88: aload 4
    //   90: athrow
    //   91: astore 8
    //   93: goto -48 -> 45
    //   96: astore 6
    //   98: goto -26 -> 72
    //   101: astore 4
    //   103: aload_3
    //   104: astore_2
    //   105: goto -41 -> 64
    //
    // Exception table:
    //   from	to	target	type
    //   16	25	62	finally
    //   33	37	62	finally
    //   41	45	91	java/io/IOException
    //   68	72	96	java/io/IOException
    //   25	33	101	finally
  }

  public static byte[] a(File paramFile)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    long l = paramFile.length();
    if (l > 2147483647L);
    byte[] arrayOfByte = new byte[(int)l];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int j = localFileInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
      if (j < 0)
        break;
      i += j;
    }
    if (i < arrayOfByte.length)
      throw new IOException("Could not completely read file " + paramFile.getName());
    localFileInputStream.close();
    return arrayOfByte;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FileUtils
 * JD-Core Version:    0.6.0
 */