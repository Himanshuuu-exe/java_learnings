class eg91psp
{
public static void main(String gg[])
{
int x,y,z;
try{
x=Integer.parseInt(gg[0]);
y=Integer.parseInt(gg[1]);
z=x/y;
System.out.println(z);
}catch(ArrayIndexOutOfBoundsException aioobe){
System.out.println(aioobe);
}catch(NumberFormatException nfe){
System.out.println(nfe);
}catch(ArithmeticException ae){
System.out.println(ae);
}catch(Exception e){
System.out.println(e);
}
System.out.println("The end");
}
}