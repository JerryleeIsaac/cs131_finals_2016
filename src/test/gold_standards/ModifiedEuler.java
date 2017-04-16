/*
 * SOURCE: http://www.lehigh.edu/~wes1/books/ode_pde/java_new/ode1x1/Euler.java
*/


//package mol;

import java.math.*;
import java.io.*;

public class ModifiedEuler extends DEF implements EulerInterface
{

  public Euler()
  {

  }
 
public void euler2a(int neqn, double t0, double tf, double u[], 
		    double u0[],int nsteps)
/*
  Function euler2a computes an ODE solution by the fixed step 
  modified Euler method for a series of points along the solution 
  by repeatedly calling function sseuler for a single modified 
  Euler step.

  Argument list

    neqn     number of first order ODEs

    t0       initial value of independent variable

    tf       final value of independent variable

    u0       initial condition vector of length neqn

    nsteps   number of modified Euler steps

    u        ODE solution vector of length neqn after
             nsteps steps
*/
{
  /* Type variables */
  double ut0[],ut[];
  double h,t;
  int i,j;

  /* Integration step */
  h=(tf-t0)/nsteps;

  /* nsteps modified Euler steps */	
  for(i=1;i<=nsteps;i++)
    {
    /* Single modified Euler step */
    t=sseuler(neqn,t0,u0,h,u,e);   

    /* Reset base point values for next modified Euler step */
    for(j=1;j<=neqn;j++)
      {
        u0[j]=u[j];
      }
      t0=t;
   
    /* End for */
    }

/* End of euler2a */
}
       
public void euler2b(int neqn, double t0, double tf, double u[], 
		    double u0[], int nsteps, double abserr, double relerr)
/*
  Function euler2b computes an ODE solution by the variable step 
  modified Euler method for a series of points along the solution
  by repeatedly calling function sseuler for a single modified
  Euler step.  The truncation error is estimated along the solution 
  to adjust the integration step according to a specified error 
  tolerance.

  Argument list

    neqn     number of first order ODEs

    t0       initial value of independent variable

    tf       final value of independent variable

    u0       initial condition vector of length neqn

    nsteps   number of modified Euler steps

    u        ODE solution vector of length neqn after
             nsteps steps
*/
{
  /* Type variables */
  double e[]=new double[SIZE]; 
  double hmin, h, t;
  int i, nfin1;

  /* Integration step */
  h=(tf-t0)/8.0;

  /* Minimum allowable step */
  hmin=(tf-t0)/(float)(nsteps);

  /* Start integration */
  t=t0;
	
  /* While independent variable is less than the final
  value, continue the integration */
  while (t<= tf*0.999)
    {
    /* If the next along the solution will go past the
    final value of the independent variable, set the
    step to the remaining distance to the final value */
    if((t+h) > tf)
      {
	h=tf-t;
      }

    /* Single modified Euler step */
    t=sseuler(neqn,t0,u0,h,u,e);   

    /* Flag for the end of the integration */ 
    nfin1=1;
	
    /* Check if any of the ODEs have violated the error
    criterion */	
    for(i=1;i<=neqn;i++)
      {
        if( Math.abs(e[i]) > (Math.abs(u[i])*relerr+abserr))
	
          /* Error violation, so integration is incomplete.
          Reduce integration step because of error violation
          and repeat integration from base point */
	  {
	     nfin1=0;
	     h=h/2.0;

             /* If the current step is less than the minimum
             allowable step, set the step to the minimum
             allowable value and continue integration from
             new base point */
	     if( h < hmin )
	       {
		  h=hmin;
		  nfin1=1;
               } 
	     break;
          }
       }

    /* If there is no error violation, continue the integration
    from the new base point */
    if(nfin1 == 1 )
      {
        for(i=1;i<=neqn;i++)
	  {
	    u0[i]=u[i]; 
          }
	  t0=t;

	  /* Test if integration step can be increased */
	  for(i=1;i<=neqn;i++)
	    {
	      if( Math.abs(e[i]) > ((Math.abs(u[i])*relerr+abserr)/4.0) )
		{
		  /* Integration step cannot be increased */
		  nfin1=0;
		  break;
		}
	     }
       
	   /* Increase integration step */
	   if(nfin1 == 1 )
	     {
	       h=h*2.0;
	     }

      /* End if */
      }

   /* End while */
   }

/* End of euler2b */
}    

public double sseuler(int neqn, double t0, double u0[], double h, 
		       double u[],double e[])
/*
  Function sseuler computes an ODE solution by the modified Euler 
  method for one step along the solution (by calls to derv to define 
  the ODE derivative vector).  It also estimates the truncation error 
  of the solution, and applies this estimate as a correction to the 
  solution vector.

  Argument list

    neqn     number of first order ODEs

    t0       initial value of independent variable

    u0       initial condition vector of length neqn

    h        integration step

    t        independent variable

    u        ODE solution vector of length neqn after
             one modified Euler step
    
    e        estimate of truncation error of the solu-
             tion vector
*/
{
  /* Type variables */
  double ut0[], ut[];
  double t;
  int j;
	
  /* Declare arrays */
  ut0=new double[SIZE];
  ut=new double[SIZE];

  /* Derivative vector at initial (base) point */
  derv(ut0,t0,u0);
	
  /* First order (Euler) step */
  for(j=1;j<=neqn;j++)
    {
      u[j]=u0[j]+ut0[j]*h;
    }	
    t=t0+h;

  /* Derivative at advance point */	
  derv(ut,t,u);

  /* Second order (modified Euler) step */
  for(j=1;j<=neqn;j++)
    {
      /* Truncation error estimate */
      e[j]=(ut[j]-ut0[j])*h/2.0;

      /* Second order (modified Euler) solution vector */
      u[j]=u[j]+e[j];
    }
    return t;

  /* End of sseuler */
  }

/* End of public class Euler */  
}