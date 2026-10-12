class aaa
{
public aaa()
{
System.out.println("default constructor of aaa");
}
}

class bbb extends aaa
{
/* following default constructor,
will be introduced by the compiler super() to invoke base class zero parameter constructor
bbb()
{
super();
}
*/
}

class eg19psp
{
public void main(String gg[])
{
bbb b;
b=new bbb();
}
}