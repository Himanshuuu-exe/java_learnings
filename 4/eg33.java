// default value
class aaa
{
}
class bbb
{
// following are 9 object variables
private long a;
private int b;
private short c;
private byte d;
private double e;
private float f;
private char g;
private boolean h;
private aaa i;

public void sam()
{
// integral types (0)
// fractional (0.0 for double and 0.0f for float)
// char (0 as number) // null space
// boolean (false)
// pointer (null)
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
System.out.println(g);
System.out.println(h);
System.out.println(i);
}
}

class eg33psp
{
public static void main(String gg[])
{
bbb b=new bbb();
b.sam();
}
}

