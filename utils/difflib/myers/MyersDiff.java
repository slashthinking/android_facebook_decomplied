package difflib.myers;

import difflib.ChangeDelta;
import difflib.Chunk;
import difflib.DeleteDelta;
import difflib.Delta;
import difflib.DiffAlgorithm;
import difflib.InsertDelta;
import difflib.Patch;
import java.lang.reflect.Array;
import java.util.List;

public class MyersDiff
  implements DiffAlgorithm
{
  public static Patch a(PathNode paramPathNode, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramPathNode == null)
      throw new IllegalArgumentException("path is null");
    if (paramArrayOfObject1 == null)
      throw new IllegalArgumentException("original sequence is null");
    if (paramArrayOfObject2 == null)
      throw new IllegalArgumentException("revised sequence is null");
    Patch localPatch = new Patch();
    Object localObject1;
    if (paramPathNode.a())
      localObject1 = paramPathNode.c;
    while (true)
    {
      PathNode localPathNode;
      if ((localObject1 != null) && (((PathNode)localObject1).c != null) && (((PathNode)localObject1).c.b >= 0))
      {
        if (((PathNode)localObject1).a())
          throw new IllegalStateException("bad diffpath: found snake when looking for diff");
        int i = ((PathNode)localObject1).a;
        int j = ((PathNode)localObject1).b;
        localPathNode = ((PathNode)localObject1).c;
        int k = localPathNode.a;
        int m = localPathNode.b;
        Chunk localChunk1 = new Chunk(k, a(paramArrayOfObject1, k, i));
        Chunk localChunk2 = new Chunk(m, a(paramArrayOfObject2, m, j));
        Object localObject2;
        if ((localChunk1.c() == 0) && (localChunk2.c() != 0))
          localObject2 = new InsertDelta(localChunk1, localChunk2);
        while (true)
        {
          localPatch.a((Delta)localObject2);
          if (!localPathNode.a())
            break label281;
          localObject1 = localPathNode.c;
          break;
          if ((localChunk1.c() > 0) && (localChunk2.c() == 0))
            localObject2 = new DeleteDelta(localChunk1, localChunk2);
          else
            localObject2 = new ChangeDelta(localChunk1, localChunk2);
        }
      }
      return localPatch;
      label281: localObject1 = localPathNode;
      continue;
      localObject1 = paramPathNode;
    }
  }

  public static <T> T[] a(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    return a(paramArrayOfT, paramInt1, paramInt2, paramArrayOfT.getClass());
  }

  public static <T, U> T[] a(U[] paramArrayOfU, int paramInt1, int paramInt2, Class<? extends T[]> paramClass)
  {
    int i = paramInt2 - paramInt1;
    if (i < 0)
      throw new IllegalArgumentException(paramInt1 + " > " + paramInt2);
    if (paramClass == [Ljava.lang.Object.class);
    for (Object[] arrayOfObject = (Object[])new Object[i]; ; arrayOfObject = (Object[])Array.newInstance(paramClass.getComponentType(), i))
    {
      System.arraycopy(paramArrayOfU, paramInt1, arrayOfObject, 0, Math.min(paramArrayOfU.length - paramInt1, i));
      return arrayOfObject;
    }
  }

  public static PathNode b(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramArrayOfObject1 == null)
      throw new IllegalArgumentException("original sequence is null");
    if (paramArrayOfObject2 == null)
      throw new IllegalArgumentException("revised sequence is null");
    int i = paramArrayOfObject1.length;
    int j = paramArrayOfObject2.length;
    int k = 1 + (i + j);
    int m = 1 + k * 2;
    int n = m / 2;
    PathNode[] arrayOfPathNode = new PathNode[m];
    arrayOfPathNode[(n + 1)] = new Snake(0, -1, null);
    int i1 = 0;
    int i2;
    label94: int i3;
    DiffNode localDiffNode;
    int i8;
    int i9;
    if (i1 < k)
    {
      i2 = -i1;
      if (i2 <= i1)
      {
        i3 = n + i2;
        int i4 = i3 + 1;
        int i5 = i3 - 1;
        int i6;
        if ((i2 == -i1) || ((i2 != i1) && (arrayOfPathNode[i5].a < arrayOfPathNode[i4].a)))
          i6 = arrayOfPathNode[i4].a;
        for (PathNode localPathNode = arrayOfPathNode[i4]; ; localPathNode = arrayOfPathNode[i5])
        {
          arrayOfPathNode[i5] = null;
          int i7 = i6 - i2;
          localDiffNode = new DiffNode(i6, i7, localPathNode);
          i8 = i7;
          i9 = i6;
          while ((i9 < i) && (i8 < j) && (paramArrayOfObject1[i9].equals(paramArrayOfObject2[i8])))
          {
            i9++;
            i8++;
          }
          i6 = 1 + arrayOfPathNode[i5].a;
        }
        if (i9 <= localDiffNode.a)
          break label347;
      }
    }
    label347: for (Object localObject = new Snake(i9, i8, localDiffNode); ; localObject = localDiffNode)
    {
      arrayOfPathNode[i3] = localObject;
      if ((i9 >= i) && (i8 >= j))
        return arrayOfPathNode[i3];
      i2 += 2;
      break label94;
      arrayOfPathNode[(-1 + (n + i1))] = null;
      i1++;
      break;
      throw new DifferentiationFailedException("could not find a diff path");
    }
  }

  public Patch a(List<?> paramList1, List<?> paramList2)
  {
    return a(paramList1.toArray(), paramList2.toArray());
  }

  public Patch a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    try
    {
      Patch localPatch2 = a(b(paramArrayOfObject1, paramArrayOfObject2), paramArrayOfObject1, paramArrayOfObject2);
      localPatch1 = localPatch2;
      return localPatch1;
    }
    catch (DifferentiationFailedException localDifferentiationFailedException)
    {
      while (true)
      {
        localDifferentiationFailedException.printStackTrace();
        Patch localPatch1 = new Patch();
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.myers.MyersDiff
 * JD-Core Version:    0.6.2
 */