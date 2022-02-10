close all
clear
clc
%% Forward Euler Scheme for Predator-Prey Model
n=1000000;
T = 10;
h=T/n;
b=10;
p=1;
r=.1;
d=10;
x=zeros(1,n);
y=zeros(1,n);
y(1)=5;
x(1)=400;
for i=2:n
    x(i)=x(i-1)+h*(b-p*y(i-1))*x(i-1);
    y(i)=y(i-1)+h*(r*x(i-1)-d)*y(i-1);
end

%forward method plot
figure 
t=linspace(0,T,n);
plot(t,y,'r',t,x,'b')

%% Backward Euler Scheme for Predator-Prey Model
% n=1000000;
T = 10;
h = T/n;
X=zeros(1,n);
Y=zeros(1,n);
Y(1)=5;
X(1)=400;
b=10;
p=1;
r=.1;
d=10;
u=0;
v=0;
for i=2:n
    u0=X(i-1);
    v0=Y(i-1);
    %% fixed point iterations, 20 iterations
    u=u0;
    v=v0;
    for j=1:20
        u=u0+h*(b-p*v)*u;
        v=v0+h*(r*u-d)*v;
    end
    %% end of iterations
    X(i)=u;  
    Y(i)=v;  
end

%backward method plot
figure 
t=linspace(0,T,n);
plot(t,Y,'r',t,X,'b')

