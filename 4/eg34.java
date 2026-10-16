// default value
class aaa
{
}
class bbb
{
// following are 9 class variables
static private long a;
static private int b;
static private short c;
static private byte d;
static private double e;
static private float f;
static private char g;
static private boolean h;
static private aaa i;
static public void sam()
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
class eg34psp
{
public static void main(String gg[])
{
bbb.sam();
}
}