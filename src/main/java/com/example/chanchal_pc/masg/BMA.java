package com.example.chanchal_pc.masg;

class BMA{
int m[],q_1=0,a[],q[],c=0,n=0,c1=0;
int xq_val,ym_val;
char xq_s,ym_s;
String w="";
void rs1()  
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
	a[1]=a[0];
	for(i=0;i<=n-2;i++)
	{
		a[i+1]=a1[i];	
	}
	q[0]=a1[n-1];
	for(i=0;i<=n-2;i++)
	{
		q[i+1]=q1[i];	
	}
	q_1=q1[n-1];
	
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
	q=new int[cx+cy];
	m=new int[cx+cy];
	a=new int[cx+cy];
	temp1=new int[cx+cy];
	pq=new int[cx+cy];
	pm=new int[cx+cy];
	//temp1[n-1]=1;
	n=cx+cy;
	c=n;
	i=cx+cy-1;
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
		i=cx+cy-1;
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
		w+="Multiplier (Q): "+String.valueOf(xq_s)+String.valueOf(tx1)+" in binary: ";//printf("Multiplier (Q): %c%d in binary: ",xq_s,tx1);
		for(i=0;i<=n-1;i++)
		{
			w+=String.valueOf(q[i]);//printf("%d",q[i]);	
		}
		w+="\nMultiplicand (M): "+String.valueOf(ym_s)+String.valueOf(ty1)+" in binary: ";//printf("\nMultiplicand (M): %c%d in binary: ",ym_s,ty1);
		for(i=0;i<=n-1;i++)
		{
			w+=String.valueOf(m[i]);//printf("%d",m[i]);	
		}
		w+="\nAccumulator (A): ";
		for(i=0;i<=n-1;i++)
		{
			w+=String.valueOf(a[i]);//printf("%d",a[i]);	
		}
			w+="\nSingle Bit Register (Q[-1]): "+String.valueOf(q_1);//printf("\nSingle Bit Register (Q[-1]): %d",q_1);
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
void bmt()
{
	int i,k,j=1,t=0;
	
	w+="\ninitial config";
	t=stepShow1();
	t+=35;
	
	for(k=0;k<t;k++)
		w+="-";
	w+="\n";
	while(c!=0)
	{
		if(q[n-1]==0 && q_1==0)
		{
                    w+=String.valueOf(j)+" q[0]=0\n q[-1]=0\n";	//printf("%d q[0]=0\n q[-1]=0\n",j);	
	    }
		else if(q[n-1]==0 && q_1==1)
		{
			fullAdder();    //a=a+m
                    w+=String.valueOf(j)+" q[0]=0\n q[-1]=1\n A=A+M\t\t";	//printf("%d q[0]=0\n q[-1]=1\n A=A+M\t",j);
			stepShow1();
		}
		else if(q[n-1]==1 && q_1==0)
		{
			fullSubstractor();    //a=a-m
			w+=String.valueOf(j)+" q[0]=1\n q[-1]=0\n A=A-M\t\t";//printf("%d q[0]=1\n q[-1]=0\n A=A-M\t",j);
			stepShow1();
		}
		else if(q[n-1]==1 && q_1==1)
		{
			w+=String.valueOf(j)+" q[0]=1\n q[-1]=1\n";//printf("%d q[0]=1\n q[-1]=1\n",j);	
	    }
		rs1();
		w+=" rs(A,Q,Q-1)";
		stepShow1();
		c=c-1;
		w+=" c=c-1\t\t\t";
		stepShow1();
		for(k=0;k<t;k++)
			w+="-";
		w+="\n";	
		j++;	
	}
	if(c==0)
	{
		w+="\n\tresult(AQ):";
		w+="\t";
		for(i=0;i<=n-1;i++)
		{
			w+=String.valueOf(a[i]); //printf("%d",a[i]);	
		}
		w+=" ";
		for(i=0;i<=n-1;i++)
		{
			w+=String.valueOf(q[i]);//printf("%d",q[i]);	
		}
		c1=0;
		q_1=0;
	}
	
}
int stepShow1()//to print an single step of Algorithm
{
	int i,tmp;
        tmp=w.length();
	w+="\tM= ";
	for(i=0;i<=n-1;i++)
	{
		w+=String.valueOf(m[i]);//"%d",m[i];	
	}
	
	w+="\t\tA= ";
	for(i=0;i<=n-1;i++)
	{
		w+=String.valueOf(a[i]);//printf("%d",a[i]);	
	}
	w+="\t\tQ= ";
	for(i=0;i<=n-1;i++)
	{
		w+=String.valueOf(q[i]);//printf("%d",q[i]);	
	}
	w+="\t\tQ[-1]= "+String.valueOf(q_1);//printf("\tQ[-1]= %d",q_1);
	w+="\tC= ";
	w+=String.valueOf(c);//printf("%d",c);
        tmp = (w.length())-tmp;
	w+="\n";
	return tmp;
}
String getData(int x,int y)
{
	int k;
        String tmp;
		
        tmp="\n\tBooth's Multiplication Algorithm\n\t";
        this.w+=tmp;
        k=tmp.length();
        k=k-4;
        while(k--!=0)
                this.w+="-";

        this.w+="\n";

        binaryConverter1(x,y);
        bmt();
	this.w+="\t in Decimal "+String.valueOf(x*y);
	return w;
}

}














