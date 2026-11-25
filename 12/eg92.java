class eg92psp
{
public static void main(String gg[])
{
int x,y,z;
try{
x=Integer.parseInt(gg[0]);
y=Integer.parseInt(gg[1]);
z=x/y;
System.out.println(z);
}catch(Exception e){
System.out.println(e);
}
System.out.println("The end");
}
}