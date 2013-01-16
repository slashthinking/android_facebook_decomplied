package com.google.inject.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import javax.inject.Provider;

public class MoreTypes
{
  public static final Type[] a = new Type[0];
  private static final Map<TypeLiteral<?>, TypeLiteral<?>> b = new ImmutableMap.Builder().b(TypeLiteral.c(Boolean.TYPE), TypeLiteral.c(Boolean.class)).b(TypeLiteral.c(Byte.TYPE), TypeLiteral.c(Byte.class)).b(TypeLiteral.c(Short.TYPE), TypeLiteral.c(Short.class)).b(TypeLiteral.c(Integer.TYPE), TypeLiteral.c(Integer.class)).b(TypeLiteral.c(Long.TYPE), TypeLiteral.c(Long.class)).b(TypeLiteral.c(Float.TYPE), TypeLiteral.c(Float.class)).b(TypeLiteral.c(Double.TYPE), TypeLiteral.c(Double.class)).b(TypeLiteral.c(Character.TYPE), TypeLiteral.c(Character.class)).b(TypeLiteral.c(Void.TYPE), TypeLiteral.c(Void.class)).b();

  public static <T> TypeLiteral<T> a(TypeLiteral<T> paramTypeLiteral)
  {
    Type localType = paramTypeLiteral.b();
    if (!e(localType))
      throw new RuntimeException("Key not fully specified " + paramTypeLiteral);
    Object localObject;
    if (paramTypeLiteral.a() == Provider.class)
      localObject = TypeLiteral.a(Types.a(((ParameterizedType)localType).getActualTypeArguments()[0]));
    while (true)
    {
      return localObject;
      localObject = (TypeLiteral)b.get(paramTypeLiteral);
      if (localObject != null)
        continue;
      localObject = paramTypeLiteral;
    }
  }

  public static Type a(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (paramType.isArray())
        paramType = new MoreTypes.GenericArrayTypeImpl(a(paramType.getComponentType()));
    }
    while (true)
    {
      return paramType;
      if ((paramType instanceof MoreTypes.CompositeType))
        continue;
      if ((paramType instanceof ParameterizedType))
      {
        ParameterizedType localParameterizedType = (ParameterizedType)paramType;
        paramType = new MoreTypes.ParameterizedTypeImpl(localParameterizedType.getOwnerType(), localParameterizedType.getRawType(), localParameterizedType.getActualTypeArguments());
        continue;
      }
      if ((paramType instanceof GenericArrayType))
      {
        paramType = new MoreTypes.GenericArrayTypeImpl(((GenericArrayType)paramType).getGenericComponentType());
        continue;
      }
      if (!(paramType instanceof WildcardType))
        continue;
      WildcardType localWildcardType = (WildcardType)paramType;
      paramType = new MoreTypes.WildcardTypeImpl(localWildcardType.getUpperBounds(), localWildcardType.getLowerBounds());
    }
  }

  public static boolean a(Type paramType1, Type paramType2)
  {
    boolean bool1 = true;
    boolean bool3;
    if (paramType1 == paramType2)
      bool3 = bool1;
    boolean bool4;
    do
    {
      boolean bool2;
      do
      {
        while (true)
        {
          return bool3;
          if ((paramType1 instanceof Class))
          {
            bool3 = paramType1.equals(paramType2);
            continue;
          }
          if ((paramType1 instanceof ParameterizedType))
          {
            boolean bool7 = paramType2 instanceof ParameterizedType;
            bool3 = false;
            if (!bool7)
              continue;
            ParameterizedType localParameterizedType1 = (ParameterizedType)paramType1;
            ParameterizedType localParameterizedType2 = (ParameterizedType)paramType2;
            if ((Objects.equal(localParameterizedType1.getOwnerType(), localParameterizedType2.getOwnerType())) && (localParameterizedType1.getRawType().equals(localParameterizedType2.getRawType())) && (Arrays.equals(localParameterizedType1.getActualTypeArguments(), localParameterizedType2.getActualTypeArguments())));
            while (true)
            {
              bool3 = bool1;
              break;
              bool1 = false;
            }
          }
          if ((paramType1 instanceof GenericArrayType))
          {
            boolean bool6 = paramType2 instanceof GenericArrayType;
            bool3 = false;
            if (!bool6)
              continue;
            GenericArrayType localGenericArrayType1 = (GenericArrayType)paramType1;
            GenericArrayType localGenericArrayType2 = (GenericArrayType)paramType2;
            bool3 = a(localGenericArrayType1.getGenericComponentType(), localGenericArrayType2.getGenericComponentType());
            continue;
          }
          if (!(paramType1 instanceof WildcardType))
            break;
          boolean bool5 = paramType2 instanceof WildcardType;
          bool3 = false;
          if (!bool5)
            continue;
          WildcardType localWildcardType1 = (WildcardType)paramType1;
          WildcardType localWildcardType2 = (WildcardType)paramType2;
          if ((Arrays.equals(localWildcardType1.getUpperBounds(), localWildcardType2.getUpperBounds())) && (Arrays.equals(localWildcardType1.getLowerBounds(), localWildcardType2.getLowerBounds())));
          while (true)
          {
            bool3 = bool1;
            break;
            bool1 = false;
          }
        }
        bool2 = paramType1 instanceof TypeVariable;
        bool3 = false;
      }
      while (!bool2);
      bool4 = paramType2 instanceof TypeVariable;
      bool3 = false;
    }
    while (!bool4);
    TypeVariable localTypeVariable1 = (TypeVariable)paramType1;
    TypeVariable localTypeVariable2 = (TypeVariable)paramType2;
    if ((localTypeVariable1.getGenericDeclaration() == localTypeVariable2.getGenericDeclaration()) && (localTypeVariable1.getName().equals(localTypeVariable2.getName())));
    while (true)
    {
      bool3 = bool1;
      break;
      bool1 = false;
    }
  }

  private static int b(Object paramObject)
  {
    if (paramObject != null);
    for (int i = paramObject.hashCode(); ; i = 0)
      return i;
  }

  public static Class<?> b(Type paramType)
  {
    Object localObject;
    if ((paramType instanceof Class))
      localObject = (Class)paramType;
    while (true)
    {
      return localObject;
      if ((paramType instanceof ParameterizedType))
      {
        Type localType = ((ParameterizedType)paramType).getRawType();
        boolean bool = localType instanceof Class;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramType;
        arrayOfObject[1] = paramType.getClass().getName();
        Preconditions.checkArgument(bool, "Expected a Class, but <%s> is of type %s", arrayOfObject);
        localObject = (Class)localType;
        continue;
      }
      if ((paramType instanceof GenericArrayType))
      {
        localObject = Array.newInstance(b(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
        continue;
      }
      if (!(paramType instanceof TypeVariable))
        break;
      localObject = Object.class;
    }
    throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + paramType.getClass().getName());
  }

  private static void b(Type paramType, String paramString)
  {
    if ((!(paramType instanceof Class)) || (!((Class)paramType).isPrimitive()));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Primitive types are not allowed in %s: %s", new Object[] { paramString, paramType });
      return;
    }
  }

  public static String c(Type paramType)
  {
    if ((paramType instanceof Class));
    for (String str = ((Class)paramType).getName(); ; str = paramType.toString())
      return str;
  }

  private static boolean e(Type paramType)
  {
    boolean bool;
    if ((paramType instanceof Class))
      bool = true;
    while (true)
    {
      return bool;
      if ((paramType instanceof MoreTypes.CompositeType))
      {
        bool = ((MoreTypes.CompositeType)paramType).a();
        continue;
      }
      if ((paramType instanceof TypeVariable))
      {
        bool = false;
        continue;
      }
      bool = ((MoreTypes.CompositeType)a(paramType)).a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.internal.MoreTypes
 * JD-Core Version:    0.6.0
 */