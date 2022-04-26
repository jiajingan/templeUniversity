%Jackie Gan
%MATH 3044
%Homework12_3, Hyperbolic Partial Differential Equations
format long

close all
clear
clc


%input l(endpoint), T(max time), alpha, m>=2, N>=2
l=0.5;
T=0.5;
m=4;
N=4;

alpha = 0.5;

ux = @(x)sin(x);
g = @(x)0;
 
%m=m-1; N=N-1;

%Wave Equation Finite-Difference
h=l/m;
k=T/N;
lambda = k*alpha/h;

for j=2:N
    w(1,j)=0;
    w(m,j)=0;
end

w(1,1)=ux(1);
w(m,1)=ux(l);
%step 4
for i = 2:m-1
%     t=0;
%     t=k;
    w(i,1)=ux(i*h);
    w(i,2)=(1-(lambda*lambda))*ux(i*h)+((lambda*lambda)*(ux((i+1)*h)+ux((i-1)*h)+k*g(i*h)));
end

for j=2:N-1
    for i = 2:m-1
        w(i,j+1)= 2*(1-alpha^2)*w(i,j)+alpha^2*(w(i+1,j)+w(i-1,j))-w(i,j-1);
    end
end

for j=1:N-1
    t(j)=j*k;
    for i=1:m
        x(i)=i*h;
        fprintf("x:%0.2f,\t",x);
        fprintf("t:%0.2f,\t",t);
        fprintf("w:%0.4f\n",w(i,j+1));
    end
end

freal = @(x,t)sin(t)*sin(4*pi*x);
treal = 0.5;
tspan = [0 treal];
y0 = 0.5;
[t,y] = ode45(freal, tspan, y0);
plot(t,y,'-o')
