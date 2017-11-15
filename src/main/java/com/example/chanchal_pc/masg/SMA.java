package com.example.chanchal_pc.masg;

class SMA{
int m[],f=0,a[],q[],c=0,n=0,c1=0;
String w="";
void rs()  
{
	int i,f1; //int f,int a[],int q[] will be globally declared
	int a1[]=new int[this.n];
        int q1[]=new int[this.n];
        f1=this.f;
	for(i=0;i<=n-1;i++)
	{
		a1[i]=this.a[i];	
	}
	for(i=0;i<=n-2;i++)
	{
		q1[i]=this.q[i];	
	}
	this.a[0]=f1;
	for(i=0;i<=n-2;i++)
	{
		this.a[i+1]=a1[i];	
	}
	q[0]=a1[n-1];
	for(i=0;i<=n-2;i++)
	{
		this.q[i+1]=q1[i];	
	}
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
        return -1;
}
void fullAdder() 
{
	int i;
	for(i=n-1;i>=0;i--)
	{
		this.a[i]=halfAdder(this.a[i],this.m[i]);	//int a[],int m[],int c will be globally delclared
	}
	
}
int stepShow()//to print an single step of Algorithm
{
	String tmp="";
        int i;
	this.w+="\tM= ";
        tmp+="\tM= ";
	for(i=0;i<=n-1;i++)
	{
		this.w+=String.valueOf(this.m[i]);	// m[i]
                tmp+=String.valueOf(this.m[i]);
	}
	this.w+="\tF= ";
        tmp+="\tF= ";
	this.w+=String.valueOf(this.f); //f
        tmp+=String.valueOf(this.f);
	this.w+="\t\tA= ";
        tmp+="\tA= ";
	for(i=0;i<=n-1;i++)
	{
		this.w+=String.valueOf(this.a[i]); //a[i]
                tmp+=String.valueOf(this.a[i]);
	}
	this.w+="\t\tQ= ";
        tmp+="\tQ= ";
	for(i=0;i<=n-1;i++)
	{
		this.w+=String.valueOf(this.q[i]);	//q[i]
                tmp+=String.valueOf(this.q[i]);
	}
	this.w+="\t\tC= ";
        tmp+="\tC= ";
	this.w+=String.valueOf(this.c); //c
        tmp+=String.valueOf(this.c);
	this.w+="\n";
        return tmp.length();
}
void smt()  //sequential multiplication table
{
	int i,k,j=1,t=0;
	
	this.w+="\ninitial config";        
	t=stepShow();
	t+=20+15;
	
	for(k=0;k<t;k++)
		this.w+="-";
	this.w+="\n";
	while(c!=0)
	{
		if(q[n-1]==0)
		{
                    this.w+=String.valueOf(j)+" q[0]=0\n";        //"%d q[0]=0\n",j);	
                }
		else if(q[n-1]==1)
		{
			fullAdder();    //a=a+m
                        this.w+=String.valueOf(j)+" q[0]=1\n  A=A+M\t";  // printf("%d q[0]=1\n  A=A+M\t",j);
			stepShow();
		}
		rs();
		this.w+="  rs(F,A,Q)";
		stepShow();
		c=c-1;
		this.w+="  c=c-1\t\t";
		stepShow();
		for(k=0;k<t;k++)
			this.w+="-";
		this.w+="\n";	
		j++;	
	}
	if(c==0)
	{
		this.w+="\n\tresult(AQ):";
		this.w+="\t";
		for(i=0;i<=this.n-1;i++)
		{
			this.w+=String.valueOf(this.a[i]);	//a[i]
		}
		this.w+=" ";
		for(i=0;i<=this.n-1;i++)
		{
			this.w+=String.valueOf(this.q[i]);	///q[i]
		}
	}
	
}
//counts no of bits for a decimal: program for binary converter
void binaryConverter(int x,int y)
{
	int i,j,q1=0,cx=1,cy=1,r=0,tx=x,ty=y,tx1,ty1,temp;
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
	this.q=new int[cx+cy];
        this.m=new int[cx+cy];
        this.a=new int[cx+cy];
	
	this.n=cx+cy;
	this.c=this.n;
	i=cx+cy-1;
	if(ty>tx)
	{
		temp=tx;
		tx=ty;
		ty=temp;
	}
	tx1=tx;
	ty1=ty;
		while((tx/2)!=0)
		{
			r=tx%2;
			this.q[i]=r;
			i--;
			q1=tx/2;
			tx=q1;
			if(tx/2==0)
			{
				r=tx%2;
				this.q[i]=r;
			}
		}
		i=cx+cy-1;
		while((ty/2)!=0)
		{
			r=ty%2;
			this.m[i]=r;
			i--;
			q1=ty/2;
			ty=q1;
			if(ty/2==0)
			{
				r=ty%2;
				this.m[i]=r;
			}
		}
	if(tx1==1)
		this.q[n-1]=1;  //
	if(ty1==1)
		this.m[this.n-1]=1;	//
        this.w+="Multiplier (Q): "+String.valueOf(tx1)+" in binary: "; //("Multiplier (Q): %d in binary: ",tx1);
        for(i=0;i<=this.n-1;i++)
        {
                this.w+=String.valueOf(this.q[i]);	//q[i]
        }
        this.w+="\nMultiplicand (M):"+String.valueOf(ty1)+" in binary: ";  //("\nMultiplicand (M):%d in binary: ",ty1);
        for(i=0;i<=this.n-1;i++)
        {
                this.w+=String.valueOf(this.m[i]);	//m[i]
        }
        this.w+="\nAccumulator (A): ";
        for(i=0;i<=this.n-1;i++)
        {
                this.w+=String.valueOf(this.a[i]);	//a[i]
        }
        this.w+="\nSingle Bit Register (F): "+String.valueOf(this.f);   //printf("\nSingle Bit Register (F): %d",f);
        this.w+="\nCounter (C): "+String.valueOf(this.c);  //printf("\nCounter (C): %d",c);

	
}
String getData(int x,int y)
{
	int k;
        String tmp;
		
        tmp="\n\tSequential Multiplication Algorithm\n\t";
        this.w+=tmp;
        k=tmp.length();
        k=k-4;
        while(k--!=0)
                this.w+="-";

        this.w+="\n";

        binaryConverter(x,y);
        smt();
	this.w+="\t in Decimal "+String.valueOf(x*y);
	return w;
}

}