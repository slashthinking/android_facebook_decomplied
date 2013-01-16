package org.json.simple.parser;

import java.io.Reader;

class Yylex
{
  private static final int[] a = { 0, 0, 1, 1 };
  private static final char[] b = a("");
  private static final int[] c = d();
  private static final int[] d = e();
  private static final int[] e = { 2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final String[] f = { "Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large" };
  private static final int[] g = f();
  private Reader h;
  private int i;
  private int j = 0;
  private char[] k = new char[16384];
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private boolean s = true;
  private boolean t;
  private StringBuffer u = new StringBuffer();

  Yylex(Reader paramReader)
  {
    this.h = paramReader;
  }

  private static int a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i2 = paramString.length();
    int i3 = paramInt;
    int i5;
    int i6;
    int i7;
    if (i1 < i2)
    {
      int i4 = i1 + 1;
      i5 = paramString.charAt(i1);
      i6 = i4 + 1;
      i7 = paramString.charAt(i4);
    }
    while (true)
    {
      int i8 = i3 + 1;
      paramArrayOfInt[i3] = i7;
      i5--;
      if (i5 <= 0)
      {
        i3 = i8;
        i1 = i6;
        break;
        return i3;
      }
      i3 = i8;
    }
  }

  private static char[] a(String paramString)
  {
    int i1 = 0;
    char[] arrayOfChar = new char[65536];
    int i2 = 0;
    int i4;
    int i5;
    int i6;
    if (i2 < 90)
    {
      int i3 = i2 + 1;
      i4 = paramString.charAt(i2);
      i5 = i3 + 1;
      i6 = paramString.charAt(i3);
    }
    while (true)
    {
      int i7 = i1 + 1;
      arrayOfChar[i1] = i6;
      i4--;
      if (i4 <= 0)
      {
        i1 = i7;
        i2 = i5;
        break;
        return arrayOfChar;
      }
      i1 = i7;
    }
  }

  private static int b(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i2 = paramString.length();
    while (i1 < i2)
    {
      int i3 = i1 + 1;
      int i4 = paramString.charAt(i1) << '\020';
      int i5 = paramInt + 1;
      int i6 = i3 + 1;
      paramArrayOfInt[paramInt] = (i4 | paramString.charAt(i3));
      paramInt = i5;
      i1 = i6;
    }
    return paramInt;
  }

  private static int c(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i2 = paramString.length();
    int i3 = paramInt;
    int i5;
    int i6;
    int i7;
    if (i1 < i2)
    {
      int i4 = i1 + 1;
      i5 = paramString.charAt(i1);
      i6 = i4 + 1;
      i7 = paramString.charAt(i4);
    }
    while (true)
    {
      int i8 = i3 + 1;
      paramArrayOfInt[i3] = i7;
      i5--;
      if (i5 <= 0)
      {
        i3 = i8;
        i1 = i6;
        break;
        return i3;
      }
      i3 = i8;
    }
  }

  private void c(int paramInt)
  {
    try
    {
      str = f[paramInt];
      throw new Error(str);
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      while (true)
        String str = f[0];
    }
  }

  private static int[] d()
  {
    int[] arrayOfInt = new int[45];
    a("", 0, arrayOfInt);
    return arrayOfInt;
  }

  private static int[] e()
  {
    int[] arrayOfInt = new int[45];
    b("", 0, arrayOfInt);
    return arrayOfInt;
  }

  private static int[] f()
  {
    int[] arrayOfInt = new int[45];
    c("", 0, arrayOfInt);
    return arrayOfInt;
  }

  private boolean g()
  {
    boolean bool = false;
    if (this.n > 0)
    {
      System.arraycopy(this.k, this.n, this.k, 0, this.o - this.n);
      this.o -= this.n;
      this.m -= this.n;
      this.l -= this.n;
      this.n = 0;
    }
    if (this.m >= this.k.length)
    {
      char[] arrayOfChar2 = new char[2 * this.m];
      System.arraycopy(this.k, 0, arrayOfChar2, 0, this.k.length);
      this.k = arrayOfChar2;
    }
    int i1 = this.h.read(this.k, this.o, this.k.length - this.o);
    if (i1 > 0)
      this.o = (i1 + this.o);
    while (true)
    {
      return bool;
      if (i1 == 0)
      {
        int i2 = this.h.read();
        if (i2 == -1)
        {
          bool = true;
        }
        else
        {
          char[] arrayOfChar1 = this.k;
          int i3 = this.o;
          this.o = (i3 + 1);
          arrayOfChar1[i3] = ((char)i2);
          bool = false;
        }
      }
      else
      {
        bool = true;
      }
    }
  }

  int a()
  {
    return this.q;
  }

  public final void a(int paramInt)
  {
    this.j = paramInt;
  }

  public final void a(Reader paramReader)
  {
    this.h = paramReader;
    this.s = true;
    this.t = false;
    this.n = 0;
    this.o = 0;
    this.l = 0;
    this.m = 0;
    this.r = 0;
    this.q = 0;
    this.p = 0;
    this.j = 0;
  }

  public final char b(int paramInt)
  {
    return this.k[(paramInt + this.n)];
  }

  public final String b()
  {
    return new String(this.k, this.n, this.l - this.n);
  }

  public Yytoken c()
  {
    int i1 = this.o;
    char[] arrayOfChar1 = this.k;
    char[] arrayOfChar2 = b;
    int[] arrayOfInt1 = e;
    int[] arrayOfInt2 = d;
    int[] arrayOfInt3 = g;
    int i2 = this.l;
    this.q += i2 - this.n;
    int i3 = -1;
    this.n = i2;
    this.m = i2;
    this.i = a[this.j];
    int i4 = i2;
    label82: int i6;
    int i7;
    label100: int i8;
    if (i4 < i1)
    {
      i6 = i4 + 1;
      i7 = arrayOfChar1[i4];
      i8 = arrayOfInt1[(arrayOfInt2[this.i] + arrayOfChar2[i7])];
      if (i8 != -1)
        break label451;
    }
    label134: Yytoken localYytoken;
    label369: int i11;
    while (true)
    {
      this.l = i2;
      if (i3 >= 0)
        break label520;
      switch (i3)
      {
      case 3:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 48:
      default:
        if ((i7 != -1) || (this.n != this.m))
          break label929;
        this.t = true;
        localYytoken = null;
        return localYytoken;
        if (this.t)
        {
          i7 = -1;
        }
        else
        {
          this.m = i4;
          this.l = i2;
          boolean bool = g();
          int i5 = this.m;
          i2 = this.l;
          arrayOfChar1 = this.k;
          i1 = this.o;
          if (bool)
          {
            i7 = -1;
          }
          else
          {
            i6 = i5 + 1;
            i7 = arrayOfChar1[i5];
            break label100;
            label451: this.i = i8;
            int i9 = arrayOfInt3[this.i];
            if ((i9 & 0x1) != 1)
              break label937;
            i11 = this.i;
            if ((i9 & 0x8) != 8)
              break label501;
            i3 = i11;
            i2 = i6;
          }
        }
        break;
      case 11:
      case 4:
      case 16:
      case 6:
      case 23:
      case 22:
      case 13:
      case 12:
      case 21:
      case 1:
      case 8:
      case 19:
      case 15:
      case 10:
      case 14:
      case 5:
      case 17:
      case 24:
      case 20:
      case 7:
      case 2:
      case 18:
      case 9:
      }
    }
    label501: int i10 = i11;
    i2 = i6;
    while (true)
    {
      while (true)
      {
        i3 = i10;
        i4 = i6;
        break label82;
        label520: i3 = c[i3];
        break label134;
        this.u.append(b());
        break;
        this.u.delete(0, this.u.length());
        a(2);
        break;
        this.u.append('\b');
        break;
        localYytoken = new Yytoken(2, null);
        break label369;
        localYytoken = new Yytoken(0, Boolean.valueOf(b()));
        break label369;
        localYytoken = new Yytoken(0, null);
        break label369;
        a(0);
        localYytoken = new Yytoken(0, this.u.toString());
        break label369;
        this.u.append('\\');
        break;
        localYytoken = new Yytoken(0, Double.valueOf(b()));
        break label369;
        throw new ParseException(this.q, 0, new Character(b(0)));
        localYytoken = new Yytoken(4, null);
        break label369;
        this.u.append('\r');
        break;
        this.u.append('/');
        break;
        localYytoken = new Yytoken(6, null);
        break label369;
        this.u.append('"');
        break;
        localYytoken = new Yytoken(1, null);
        break label369;
        this.u.append('\f');
        break;
        try
        {
          int i12 = Integer.parseInt(b().substring(2), 16);
          this.u.append((char)i12);
        }
        catch (Exception localException)
        {
          throw new ParseException(this.q, 2, localException);
        }
      }
      this.u.append('\t');
      break;
      localYytoken = new Yytoken(3, null);
      break label369;
      localYytoken = new Yytoken(0, Long.valueOf(b()));
      break label369;
      this.u.append('\n');
      break;
      localYytoken = new Yytoken(5, null);
      break label369;
      label929: c(1);
      break;
      label937: i10 = i3;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     org.json.simple.parser.Yylex
 * JD-Core Version:    0.6.2
 */