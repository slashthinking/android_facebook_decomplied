package org.json.simple.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONParser
{
  private LinkedList a;
  private Yylex b = new Yylex((Reader)null);
  private Yytoken c = null;
  private int d = 0;

  private int a(LinkedList paramLinkedList)
  {
    if (paramLinkedList.size() == 0);
    for (int i = -1; ; i = ((Integer)paramLinkedList.getFirst()).intValue())
      return i;
  }

  private Map a(ContainerFactory paramContainerFactory)
  {
    Object localObject;
    if (paramContainerFactory == null)
      localObject = new JSONObject();
    while (true)
    {
      return localObject;
      localObject = paramContainerFactory.a();
      if (localObject == null)
        localObject = new JSONObject();
    }
  }

  private List b(ContainerFactory paramContainerFactory)
  {
    Object localObject;
    if (paramContainerFactory == null)
      localObject = new JSONArray();
    while (true)
    {
      return localObject;
      localObject = paramContainerFactory.b();
      if (localObject == null)
        localObject = new JSONArray();
    }
  }

  private void c()
  {
    this.c = this.b.c();
    if (this.c == null)
      this.c = new Yytoken(-1, null);
  }

  public Object a(Reader paramReader, ContainerFactory paramContainerFactory)
  {
    a(paramReader);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    label935: int i;
    do
    {
      while (true)
      {
        try
        {
          c();
          switch (this.d)
          {
          default:
            if (this.d != -1)
              break label935;
            throw new ParseException(b(), 1, this.c);
          case 0:
          case 1:
          case 2:
          case 4:
          case 3:
          case -1:
          }
        }
        catch (IOException localIOException)
        {
          throw localIOException;
        }
        switch (this.c.a)
        {
        case 2:
        default:
          this.d = -1;
          break;
        case 0:
          this.d = 1;
          localLinkedList1.addFirst(new Integer(this.d));
          localLinkedList2.addFirst(this.c.b);
          break;
        case 1:
          this.d = 2;
          localLinkedList1.addFirst(new Integer(this.d));
          localLinkedList2.addFirst(a(paramContainerFactory));
          break;
        case 3:
          this.d = 3;
          localLinkedList1.addFirst(new Integer(this.d));
          localLinkedList2.addFirst(b(paramContainerFactory));
          continue;
          if (this.c.a == -1)
            return localLinkedList2.removeFirst();
          throw new ParseException(b(), 1, this.c);
          switch (this.c.a)
          {
          case 5:
          case 1:
          case 3:
          case 4:
          default:
            this.d = -1;
            break;
          case 0:
            if ((this.c.b instanceof String))
            {
              localLinkedList2.addFirst((String)this.c.b);
              this.d = 4;
              localLinkedList1.addFirst(new Integer(this.d));
            }
            else
            {
              this.d = -1;
            }
            break;
          case 2:
            if (localLinkedList2.size() > 1)
            {
              localLinkedList1.removeFirst();
              localLinkedList2.removeFirst();
              this.d = a(localLinkedList1);
            }
            else
            {
              this.d = 1;
              continue;
              switch (this.c.a)
              {
              case 6:
              case 2:
              case 4:
              case 5:
              default:
                this.d = -1;
                break;
              case 0:
                localLinkedList1.removeFirst();
                String str3 = (String)localLinkedList2.removeFirst();
                ((Map)localLinkedList2.getFirst()).put(str3, this.c.b);
                this.d = a(localLinkedList1);
                break;
              case 3:
                localLinkedList1.removeFirst();
                String str2 = (String)localLinkedList2.removeFirst();
                Map localMap4 = (Map)localLinkedList2.getFirst();
                List localList4 = b(paramContainerFactory);
                localMap4.put(str2, localList4);
                this.d = 3;
                localLinkedList1.addFirst(new Integer(this.d));
                localLinkedList2.addFirst(localList4);
                break;
              case 1:
                localLinkedList1.removeFirst();
                String str1 = (String)localLinkedList2.removeFirst();
                Map localMap2 = (Map)localLinkedList2.getFirst();
                Map localMap3 = a(paramContainerFactory);
                localMap2.put(str1, localMap3);
                this.d = 2;
                localLinkedList1.addFirst(new Integer(this.d));
                localLinkedList2.addFirst(localMap3);
                continue;
                switch (this.c.a)
                {
                case 5:
                case 2:
                default:
                  this.d = -1;
                  break;
                case 0:
                  ((List)localLinkedList2.getFirst()).add(this.c.b);
                  break;
                case 4:
                  if (localLinkedList2.size() > 1)
                  {
                    localLinkedList1.removeFirst();
                    localLinkedList2.removeFirst();
                    this.d = a(localLinkedList1);
                  }
                  else
                  {
                    this.d = 1;
                  }
                  break;
                case 1:
                  List localList3 = (List)localLinkedList2.getFirst();
                  Map localMap1 = a(paramContainerFactory);
                  localList3.add(localMap1);
                  this.d = 2;
                  localLinkedList1.addFirst(new Integer(this.d));
                  localLinkedList2.addFirst(localMap1);
                  break;
                case 3:
                  List localList1 = (List)localLinkedList2.getFirst();
                  List localList2 = b(paramContainerFactory);
                  localList1.add(localList2);
                  this.d = 3;
                  localLinkedList1.addFirst(new Integer(this.d));
                  localLinkedList2.addFirst(localList2);
                  continue;
                  throw new ParseException(b(), 1, this.c);
                }
                break;
              }
            }
            break;
          }
          break;
        }
      }
      i = this.c.a;
    }
    while (i != -1);
    throw new ParseException(b(), 1, this.c);
  }

  public Object a(String paramString)
  {
    return a(paramString, (ContainerFactory)null);
  }

  public Object a(String paramString, ContainerFactory paramContainerFactory)
  {
    StringReader localStringReader = new StringReader(paramString);
    try
    {
      Object localObject = a(localStringReader, paramContainerFactory);
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new ParseException(-1, 2, localIOException);
    }
  }

  public void a()
  {
    this.c = null;
    this.d = 0;
    this.a = null;
  }

  public void a(Reader paramReader)
  {
    this.b.a(paramReader);
    a();
  }

  public int b()
  {
    return this.b.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     org.json.simple.parser.JSONParser
 * JD-Core Version:    0.6.2
 */