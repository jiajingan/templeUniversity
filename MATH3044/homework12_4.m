%Jackie Gan
%MATH 3044
%Homework12_4, An Introduction to the Finite-Element Method

format long

close all
clear
clc

%the code doesn't correct correctly not sure what's wrong
%the code is also from the textbook

%input n>=1, x0 = 0, bound 0 - 1
ux = @(x)sin(x);
x0=0;
h=1/20;
%maybe this will work?
x=0:h:1;
n=20;
phi = zeros(n+1,n+1);

%step 1
for i=1:n
    h(i)=x(i+1)-x(i);
end
%step 2 the hat function here
for i=2:n-1
    for index=1:n
       if(0 <= x(index) <= x(i-1))
           phi(i,index) = 0;
       elseif(x(i-1) < x(index) <= x(i))
           phi(i,index) = (x(index)-x(i-1))/h(i-1);
       elseif(x(i)<x(index)<=x(i+1))
           phi(i,index)=(x(i+1)-x(index))/h(i);
       elseif(x(i+1)<x(index)<=1)
           phi(i,index)=0;
       end
    end
end
%step 3
%q=0, p=0
%these came from the d.e.
p=@(x)1;
q=@(x)0;
for i=2:n
    Q1(i)=(h(i)/12)*(p(x(i))+q(x(i+1)));
    Q2(i)=(h(i-1)/12)*(3*q(x(i))+q(x(i-1)));
    Q3(i)=(h(i)/12)*(3*q(x(i))+q(x(i+1)));
    Q4(i)=(h(i-1)/2)*(p(x(i))+p(x(i-1)));
    Q5(i)=(h(i-1)/6)*(2*ux(i)+ux(i-1));
    Q6(i)=(h(i)/6)*(2*ux(i)+ux(i+1));
end

%compute n+1
%Q1(n+1)=(h(n-1)/12)*(3*q(x(n))+q(x(n-1)));
Q2(n+1)=(h(n-2)/12)*(3*q(x(n-1))+q(x(n-2)));
Q3(n+1)=(h(n)/12)*(3*q(x(n-1))+q(x(n)));

Q4(n+1)=(h(n-2)/2)*(p(x(n-1)) + p(x(n-2)));
%Q4(n+2)=(h(n-1)/2)*(p(x(n)) + p(x(n-1)));
Q5(n+1)=(h(n-1)/6)*(2*ux(x(n-1))+ux(x(n-2)));
Q6(n+1)=(h(n)/6)*(2*ux(x(n-1))+ux(x(n)));

%step 4
for i = 2:n
    alpha(i)= Q4(i) + Q4(i+1) + Q2(i) + Q3(i);
    beta(i) = Q1(i) - Q4(i+1);
    b(i) = Q5(i) + Q6(i);
end

alpha(n+1)=Q4(n)+Q4(n+1)+Q2(n)+Q3(n);
b(n+1)=Q5(n)+Q6(n);
%step6
a(1)=alpha(1);
zeta(1) = beta(1)/alpha(1);
z(1) = b(1)/a(1);
%step7
for i=2:n-1
    a(i)=alpha(i)-beta(i-1)*zeta(i-1);
    zeta(i)=beta(i)/a(i);
    z(i)=(b(i)-beta(i-1)*z(i-1))/a(i);
end
%step8
a(n)=alpha(n)-beta(n-1)*zeta(n-1);
z(n)=(b(n)-beta(n-1)*z(n-1))/a(n);

%step9
c(n)=z(n);

for i=n-1:-1:1
    c(i)=z(i)-zeta(i)*c(i+1);
    disp(c(i))
end
h=1/20;
f = @(x)sin(x);
t = 0:.1:1;
u0=0;

