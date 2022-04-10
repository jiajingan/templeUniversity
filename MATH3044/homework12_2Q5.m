%Jackie Gan
%MATH 3044
%Homework12_2, Parabolic Partial Differential Equations
%Q5a
format long

close all
clear
clc

%Forward difference method, Q5a
Freal = @(x,t)exp(-4*pi*pi*t)*sin(2*pi*x);
hreal = 0.4;
kreal = 0.05;

%Crank-Nicolson Method
% h = 0.4;
% k = 0.1;
% t= 0.5;
ux = @(x) sin(2*pi*x);
%input l(endpoint), maxTime T, choose alpha,m>=3, N>=1
l=2;
T=2;
N=1;
m=3;

alpha = 0.5;

h = l/m; k = T/N; lambda = (alpha*alpha*k)/(h*h);
%w = zeros(m,N);

for i=1:m-1
    w(i,1) = ux(i*h);
end

l(1)= 1+lambda;
u(1)= -lambda/(2*l(1));

for i= 2:m-2
    l(i)=1+lambda+(lambda*u(i-1))/2;
    u(i)=-lambda/(2*l(i));
end

l(m-1)=(1+lambda+(lambda*u(m-2)))/2;
for j=1:N
    t(j)=j*k;
    z(1)=(((1-lambda)*w(1,))*((lambda/2)*w(1,2)));
    for i = 2:m-1
        z(i)=(((1-lambda)*w(i,j))+((lambda/2)*(w(i+1,j)+w(i-1,j)+z(i-1))))/l(i);
    end
    w(m-1)=z(m-1);
    for i = m-2:-1:1
        w(i,j)=z(i)+u(i)*w(i+1,j);
    end

    for i=1:m-1
        x=i*h;
        fprintf("x:%0.2f,\t w:%0.4f\n",x,w(i,j));
    end
end



