package com.example.chanchal_pc.masg;

class NRDA{
int m[],q_1=0,a[],q[],c=0,n=0,c1=0,output=0;
int xq_val,ym_val;
char xq_s,ym_s;
String w="";
void ls1()  
{
	int i;
        int a1[]=new int[this.n];
        int q1[]=new int[this.n];
	for(i=0;i<=n-1;i++)
	{
		a1[i]=a[i];	
	}
	for(i=0;i<=n-1;i++)
	{
		q1[i]=q[i];	
	}
	
	q[n-1]=0;
	for(i=n-1;i>=1;i--)
	{
		q[i-1]=q1[i];	
	}
	a[n-1]=q[0];
	for(i=n-1;i>=1;i--)
	{
		a[i-1]=a1[i];	
	}
	
		
}
int halfSubstractor(int a,int b)
{
	if(a==0 && c1==0 && b==0)
	{
		c1=0;
		return 0;
	}
	if(a==0 && c1==0 && b==1)
	{
		c1=1;
		return 1;
	}
	if(a==0 && c1==1 && b==0)
	{
		c1=1;
		return 1;
	}
	if(a==0 && c1==1 && b==1)
	{
		c1=1;
		return 0;
	}
	if(a==1 && c1==0 && b==0)
	{
		c1=0;
		return 1;
	}
	if(a==1 && c1==0 && b==1)
	{
		c1=0;
		return 0;
	}
	if(a==1 && c1==1 && b==0)
	{
		c1=0;
		return 0;
	}
	if(a==1 && c1==1 && b==1)
	{
		c1=1;
		return 1;
	}
        return -10;
}
void fullSubstractor() 
{
	int i;
	for(i=n-1;i>=0;i--)
	{
		a[i]=halfSubstractor(a[i],m[i]);	//int a[],int m[],int c will be globally delclared
	}
	c1=0;
	
}
//counts no of bits for a decimal: program for binary converter
void binaryConverter1(int x,int y)
{
	int i,j,q1=0,cx=1,cy=1,r=0,tx,ty,tx1,ty1,temp,temp1[],pq[],pm[];
	char temps;
	tx=mod(x,1);
	ty=mod(y,2);
	while((x/2)!=0)
	{
		q1=x/2;
		x=q1;
		cx=cx+1;
	}
	while((y/2)!=0)
	{
		q1=y/2;
		y=q1;
		cy=cy+1;
	}

	if(cx>cy && ((cx>=5)||(cy>=5)))
		n=cx+1;
	else if(cx<=cy && ((cx>=5)||(cy>=5)))
		n=cy+1;
	else
		n=5;

	q=new int[n];
	m=new int[n];
	a=new int[n];
	temp1=new int[n];
	pq=new int[n];
	pm=new int[n];
	//temp1[n-1]=1;
	//n=cx+cy-1;
	//nq=cx+cy-2;
	c=n-1;
	i=n-1;
	if(ty>tx)
	{
		temp=tx;
		tx=ty;
		ty=temp;
	}
	tx1=tx;   //tx->q
	ty1=ty;		//ty->m
	if(tx!=xq_val)
	{
		temp=xq_val;
		temps=xq_s;
		xq_val=ym_val;
		xq_s=ym_s;
		ym_val=temp;
		ym_s=temps;
	}

		while((tx/2)!=0)
		{
			r=tx%2;
			q[i]=r;
			i--;
			q1=tx/2;
			tx=q1;
			if(tx/2==0)
			{
				r=tx%2;
				q[i]=r;
			}
		}
		i=n-1;
		while((ty/2)!=0)
		{
			r=ty%2;
			m[i]=r;
			i--;
			q1=ty/2;
			ty=q1;
			if(ty/2==0)
			{
				r=ty%2;
				m[i]=r;
			}
		}

	if(tx1==1)
		q[n-1]=1;  //
	if(ty1==1)
		m[n-1]=1;	//

	if(xq_s=='-')
	{
		
		for(i=n-1;i>=0;i--)
		{
			q[i]=halfSubstractor(temp1[i],q[i]);	
		}
		c1=0;
	}	
	if(ym_s=='-')
	{
		for(i=n-1;i>=0;i--)
		{
			m[i]=halfSubstractor(temp1[i],m[i]);	
		}
		
		c1=0;
	}
		output=(int)tx1/ty1;
		w+="Dividend (Q): "+String.valueOf(tx1)+" in binary: "; //String.valueOf(xq_s)
		for(i=1;i<=n-1;i++)
		{
			w+=String.valueOf(q[i]);//printf("%d",q[i]);	
		}
		w+="\nDivisor (M): "+String.valueOf(ty1)+" in binary: "; //String.valueOf(ym_s)
		for(i=1;i<=n-1;i++)
		{
			w+=String.valueOf(m[i]);//printf("%d",m[i]);	
		}
		w+="\nAccumulator (A): ";
		for(i=1;i<=n-1;i++)
		{
			w+=String.valueOf(a[i]);//printf("%d",a[i]);	
		}
			
		w+="\nCounter (C): "+String.valueOf(c);//printf("\nCounter (C): %d",c);
	
}
int mod(int a,int x_or_y)	
{							
    if(x_or_y==1){
        if(a<0)
	{
		xq_s='-';
		xq_val=-1*a;		
		return (-1*a);
	}
	else if(a>=0)
	{
		xq_s='+';
		xq_val=a;
		return (a);
	}
    }
    else
    {
       if(a<0)
	{
		ym_s='-';
		ym_val=-1*a;		
		return (-1*a);
	}
	else if(a>=0)
	{
		ym_s='+';
		ym_val=a;
		return (a);
	} 
    }
    return -9999;
}
int halfAdder(int a,int b)//a=a[i]&b=m[i],c1 is carry
{
	if(a==0&&b==0)
	{
		if(c1==0)
			 return 0;
		else if(c1==1)	
		{
			c1=0;
			return 1;
		}
	}
	else if((a==1&&b==0)||(a==0&&b==1))	
	{
		if(c1==0)
			return 1;
		else if(c1==1)
			return 0;
	}
	if(a==1&&b==1)
	{
		if(c1==0)
		{
			c1=1;
			return 0;
		}
		else if(c1==1)
		return 1;	
	}
        return -2;
}
void fullAdder() 
{
	int i;
	for(i=n-1;i>=0;i--)
	{
		a[i]=halfAdder(a[i],m[i]);	//int a[],int m[],int c will be globally delclared
	}
	c1=0;
	
}
void nrdt()
{
	int i,k,j=1,t=0;
	
	w+="\ninitial config";
	t=stepShow1(true);
	t+=35;
	
	for(k=0;k<t;k++)
		w+="-";
	w+="\n";
	while(c!=0)
	{
		
		if(a[0]==0)
		{
            w+=String.valueOf(j)+" a>0\n";	//printf("%d q[0]=0\n q[-1]=0\n",j);
			ls1();
			w+=" ls(A,Q)\t";
			stepShow1(false);
			fullSubstractor();
			w+=" A=A-M\t";
			stepShow1(false);
	    }
		else if(a[1]==1)
		{
			w+=String.valueOf(j)+" a<0\n";
			ls1();
			w+=" ls(A,Q)\t";
			stepShow1(false);
			fullAdder();
			w+=" A=A+M\t";
			stepShow1(false);
		}
	
		if(a[0]==0)
		{
			q[n-1]=1;
			w+=" a>0\n q[0]=1\t\t";
			stepShow1(true);
		}
		else if(a[0]==1)
		{
			q[n-1]=0;
			w+=" a<0\n q[0]=0\t\t";
			stepShow1(true);
		}	
		c=c-1;
		w+=" c=c-1\t\t";
		stepShow1(true);
		//---
		for(k=0;k<t;k++)
			w+="-";
		w+="\n";	
		j++;	
	}
	if(c==0)
	{
		if(a[0]==1)
		{	
			fullAdder();
			w+="\tCounter has reached at zero so final step\n";
			w+=String.valueOf(j)+" a<0\n A=A+M\t";
			stepShow1(true);
			for(k=0;k<t;k++)
			w+="-";
		
		}
		w+="\n\n\tresult(Q):";
		w+="\t";
		/*for(i=1;i<=n-1;i++)
		{
			w+=String.valueOf(a[i]); //printf("%d",a[i]);	
		}
		w+=" ";*/
		for(i=1;i<=n-1;i++)
		{
			w+=String.valueOf(q[i]);//printf("%d",q[i]);	
		}
		c1=0;
		
	}
	
}
int stepShow1(boolean flag)//to print an single step of Algorithm
{
	int i,tmp;
        tmp=w.length();
	w+="\tM= ";
	for(i=1;i<=n-1;i++)
	{
		w+=String.valueOf(m[i]);//"%d",m[i];	
	}
	
	w+="\t\tA= ";
	for(i=1;i<=n-1;i++)
	{
		w+=String.valueOf(a[i]);//printf("%d",a[i]);	
	}
	w+="\t\tQ= ";
	for(i=1;i<n-1;i++)
	{
		w+=String.valueOf(q[i]);//printf("%d",q[i]);	
	}
	if(flag)
		w+=String.valueOf(q[n-1]);
	else
		w+="_";
	w+="\t\tC= ";
	w+=String.valueOf(c);//printf("%d",c);
        tmp = (w.length())-tmp;
	w+="\n";
	return tmp;
}
String getData(int x,int y)
{
	int k;
        String tmp;
		
        tmp="\n\tNon-Restoring Division Algorithm\n\t";
        this.w+=tmp;
        k=tmp.length();
        k=k-4;
        while(k--!=0)
                this.w+="-";

        this.w+="\n";

        binaryConverter1(x,y);
       nrdt();
	this.w+="\t in Decimal "+String.valueOf(output);
	return w;
}

}














