import java.util.Scanner;

public class IntegrationProject {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		double start, stop, deltaX;
		int n;
		double A=0.0, B=0.0, C=0.0, D=0.0, E=0.0, F=0.0,act=0.0; 
		System.out.println("The start limit of the integration");
		start=input.nextDouble();
		System.out.println("The end limit of the integration");
		stop=input.nextDouble();
		System.out.println("Enter the Interval");
		n=input.nextInt();
		System.out.println("For Ax^5+Bx^4+Cx^3+Dx^2+Ex+F");
		System.out.println("Enter the A");
		A=input.nextInt();
		System.out.println("Enter the B");
		B=input.nextInt();
		System.out.println("Enter the C");
		C=input.nextInt();
		System.out.println("Enter the D");
		D=input.nextInt();
		System.out.println("Enter the E");
		E=input.nextInt();
		System.out.println("Enter the F");
		F=input.nextInt();
		System.out.println("Enter the Actual Intergral ");
		act=input.nextInt();
		deltaX=((stop-start)/n);
		System.out.println(deltaX);
		double m=midpoint (deltaX,n,A,B,C,D,E,F,start,stop);
		System.out.println("Midpoint Methods Answer is "+m);
		System.out.println("For the Midpoint percent error is "+pError(m,act)+"%");
		double t=trap(deltaX,n,A,B,C,D,E,F,start,stop);
		System.out.println("Trap Method Answer is "+t);
		System.out.println("For the Trapezoid percent error is "+pError(t,act)+"%");
		double s=simp(m,t);
		System.out.println("Simpson Method is "+s);
		System.out.println("For the Simpsons percent error is "+pError(s,act)+"%");
	
	}
	public static Double midpoint (double deltaX,int n,double A, double B, double C,double D,double E,double F, double a, double b) {

		double x, xstart = a, x1;
		 double dx=(b-a)/n;
	       double sum = 0;
	       for (int i = 1; i <= n; i++){
	           x1 = xstart + dx;
	           x =(xstart + x1)/2;
	           sum += f(x, n, A, B, C, D, E, F);
	           xstart = x1;
	       }
	       return sum * dx;

	   }
		
		
		//		double m,mTot=0;
//		double x=deltaX;
//		for (int i=-3;i<n+1;i++){
//		m=f(x,n,A,B,C,D,E,F);
//		mTot=mTot+m;
//		x=x+deltaX;
//		}
//		return (mTot*deltaX)+12;
	
	
	public static Double  trap(double deltaX,int n,double A, double B, double C,double D,double E,double F, double start, double stop) { 
		double t,f1,f2,x,a;
		double x1=deltaX;
		double x2=deltaX*2;
		 double area;
	     
	    
	       area = (f(start,n,A,B,C,D,E,F)+f(stop,n,A,B,C,D,E,F))/2.0;
	       for (int i=1;i<=n-1;i++){
	           x=start+i*deltaX;
	           area= area+f(x,n,A,B,C,D,E,F);
	       }
	       area=area*deltaX;
	       return area;
		
			}
	public static double  simp(double m,double t) {
		double s=0;
		s=((2*m)+t)/3;
		return s;
	}	
	public static double  pError(double z, double actual) { 
		double e;
		e=(Math.abs(z-actual)/actual)*100;
		return e;
	}
	
	public static Double f(double deltaX,int n,double A, double B, double C,double D,double E,double F) {
		double val=0;
		double x=deltaX;
		val=((A*(Math.pow(x, 5))+(B*(Math.pow(x, 4)))+(C*(Math.pow(x, 3)))+(D*(Math.pow(x, 2)))+(E*x)+(F)));
		return val; 
	}



}


