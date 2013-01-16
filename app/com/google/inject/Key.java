package com.google.inject;

import com.google.common.base.Preconditions;
import com.google.inject.internal.Annotations;
import com.google.inject.internal.MoreTypes;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class Key<T>
{
  private final Key.AnnotationStrategy a;
  private final TypeLiteral<T> b;
  private final int c;

  private Key()
  {
    this.a = Key.NullAnnotationStrategy.INSTANCE;
    this.b = TypeLiteral.b(getClass());
    this.c = d();
  }

  private Key(TypeLiteral<T> paramTypeLiteral, Key.AnnotationStrategy paramAnnotationStrategy)
  {
    this.a = paramAnnotationStrategy;
    this.b = MoreTypes.a(paramTypeLiteral);
    this.c = d();
  }

  private Key(Type paramType, Key.AnnotationStrategy paramAnnotationStrategy)
  {
    this.a = paramAnnotationStrategy;
    this.b = MoreTypes.a(TypeLiteral.a(paramType));
    this.c = d();
  }

  static Key.AnnotationStrategy a(Annotation paramAnnotation)
  {
    Preconditions.checkNotNull(paramAnnotation, "annotation");
    Class localClass = paramAnnotation.annotationType();
    if (Annotations.a(localClass));
    for (Object localObject = new Key.AnnotationTypeStrategy(localClass, paramAnnotation); ; localObject = new Key.AnnotationInstanceStrategy(Annotations.a(paramAnnotation)))
      return localObject;
  }

  public static <S> Key<S> a(TypeLiteral<S> paramTypeLiteral)
  {
    return new Key(paramTypeLiteral, Key.NullAnnotationStrategy.INSTANCE);
  }

  public static <S> Key<S> a(TypeLiteral<S> paramTypeLiteral, Class<? extends Annotation> paramClass)
  {
    return new Key(paramTypeLiteral, b(paramClass));
  }

  public static <S> Key<S> a(TypeLiteral<S> paramTypeLiteral, Annotation paramAnnotation)
  {
    return new Key(paramTypeLiteral, a(paramAnnotation));
  }

  public static <T> Key<T> a(Class<T> paramClass)
  {
    return new Key(paramClass, Key.NullAnnotationStrategy.INSTANCE);
  }

  public static <S> Key<S> a(Class<S> paramClass, Class<? extends Annotation> paramClass1)
  {
    return new Key(paramClass, b(paramClass1));
  }

  public static Key<?> a(Type paramType)
  {
    return new Key(paramType, Key.NullAnnotationStrategy.INSTANCE);
  }

  public static Key<?> a(Type paramType, Class<? extends Annotation> paramClass)
  {
    return new Key(paramType, b(paramClass));
  }

  public static Key<?> a(Type paramType, Annotation paramAnnotation)
  {
    return new Key(paramType, a(paramAnnotation));
  }

  static Key.AnnotationStrategy b(Class<? extends Annotation> paramClass)
  {
    Preconditions.checkNotNull(paramClass, "annotation type");
    return new Key.AnnotationTypeStrategy(Annotations.c(paramClass), null);
  }

  private int d()
  {
    return 31 * this.b.hashCode() + this.a.hashCode();
  }

  public final TypeLiteral<T> a()
  {
    return this.b;
  }

  public final Class<? extends Annotation> b()
  {
    return this.a.getAnnotationType();
  }

  public final Annotation c()
  {
    return this.a.getAnnotation();
  }

  public final boolean equals(Object paramObject)
  {
    int i = 1;
    if (paramObject == this);
    while (true)
    {
      return i;
      if (!(paramObject instanceof Key))
      {
        i = 0;
        continue;
      }
      Key localKey = (Key)paramObject;
      if ((this.a.equals(localKey.a)) && (this.b.equals(localKey.b)))
        continue;
      i = 0;
    }
  }

  public final int hashCode()
  {
    return this.c;
  }

  public final String toString()
  {
    return "Key[type=" + this.b + ", annotation=" + this.a + "]";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.Key
 * JD-Core Version:    0.6.0
 */