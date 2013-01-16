package android_src.mms.dom;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListImpl
  implements NodeList
{
  private ArrayList<Node> a;
  private ArrayList<Node> b;
  private Node c;
  private String d;
  private boolean e;

  public NodeListImpl(Node paramNode, String paramString, boolean paramBoolean)
  {
    this.c = paramNode;
    this.d = paramString;
    this.e = paramBoolean;
  }

  private void a(Node paramNode)
  {
    Node localNode;
    if (paramNode == this.c)
    {
      this.a = new ArrayList();
      localNode = paramNode.getFirstChild();
      label26: if (localNode == null)
        return;
      if (!this.e)
        break label87;
      a(localNode);
    }
    while (true)
    {
      localNode = localNode.getNextSibling();
      break label26;
      if ((this.d != null) && (!paramNode.getNodeName().equals(this.d)))
        break;
      this.a.add(paramNode);
      break;
      label87: if ((this.d != null) && (!localNode.getNodeName().equals(this.d)))
        continue;
      this.a.add(localNode);
    }
  }

  public int getLength()
  {
    if (this.b == null)
      a(this.c);
    for (int i = this.a.size(); ; i = this.b.size())
      return i;
  }

  public Node item(int paramInt)
  {
    if (this.b == null)
      a(this.c);
    while (true)
    {
      Node localNode;
      try
      {
        localNode = (Node)this.a.get(paramInt);
        return localNode;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
      {
        localNode = null;
        continue;
      }
      try
      {
        localNode = (Node)this.b.get(paramInt);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
      {
        localNode = null;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.NodeListImpl
 * JD-Core Version:    0.6.0
 */