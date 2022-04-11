%Jackie Gan
%MATH 3044
%Homework12_3, Hyperbolic Partial Differential Equations

%input l(endpoint), T(max time), alpha, m>=2, N>=2


%Wave Equation Finite-Difference
h=l/m;
k=T/N;
lambda = k*alpha/h;

for j=1:N
    w(0,j)=0;
    w(m,j)=0;
end

w(0,0)=ux(0);
w(m,0)=ux(l);
%step 4
for i = 1:m-1
    w(i,0)=ux(i*h);
    w(i,1)=(1-(lambda*lambda))*ux(i*h)+((lambda*lambda)*(ux((i+1)*h)+ux((i-1)*h)+k*g(i*h)));
end

for j=1:N-1
    for i = 1:m-1
        w(i,j+1)= 2*(1-alpha^2)*w(i,j)+alpha^2*(w(i+1,j)+w(i-1,j))-w(i,j-1);
    end
end

for j=0:N
    t(j)=j*k;
    for i=0:m
        x(i)=i*h;
        fprintf("x:%0.2f,\t t:%0.2f,\t w:%0.4f\n",x,t,w(i,j+1));
    end
end

