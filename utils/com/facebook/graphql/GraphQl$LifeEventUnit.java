package com.facebook.graphql;

public class GraphQl$LifeEventUnit
{
  public static final GraphQlQueryLifeEventUnit.LifeEventUnitField a = new GraphQlQueryLifeEventUnit.LifeEventUnitField("id");
  public static final GraphQlQueryLifeEventUnit.LifeEventUnitField b = new GraphQlQueryLifeEventUnit.LifeEventUnitField("url.site(mobile)");

  public static GraphQlQueryLifeEventUnit.LifeEventUnitField a(GraphQlQueryIcon paramGraphQlQueryIcon)
  {
    return new GraphQlQueryLifeEventUnit.LifeEventUnitField("icon", paramGraphQlQueryIcon);
  }

  public static GraphQlQueryLifeEventUnit.LifeEventUnitField a(GraphQlQueryPhoto paramGraphQlQueryPhoto)
  {
    return new GraphQlQueryLifeEventUnit.LifeEventUnitField("unit_photos", paramGraphQlQueryPhoto);
  }

  public static GraphQlQueryLifeEventUnit.LifeEventUnitField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryLifeEventUnit.LifeEventUnitField("subtitle", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryLifeEventUnit.LifeEventUnitField b(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryLifeEventUnit.LifeEventUnitField("under_subtitle", paramGraphQlQueryTextWithEntities);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.LifeEventUnit
 * JD-Core Version:    0.6.2
 */