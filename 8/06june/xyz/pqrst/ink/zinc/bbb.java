package pqrst.ink.zinc;
public class bbb
{
public void sam()
{
aaa a=new aaa();
// a.a=10; // incorrect 
a.b=20; 		// same package member can access no modifier 
a.c=30; 		// same package member, even if not inheriting
					// can access protected
a.d=40;   // public can be accessed from anywhere
}
}