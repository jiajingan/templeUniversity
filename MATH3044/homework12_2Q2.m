%Jackie Gan
%MATH 3044
%Homework12_2, Parabolic Partial Differential Equations
%Q2, 5a
format long

close all
clear
clc

%Backward difference methods, Q2
Freal = @(x,t)2*exp(-1*(pi^2/4)*t)*sin(2*pi*x);
m=3; T=0.1; N=2;

ut0 = 0; ut1 = 0;
ux =@(x) 2*sin(2*pi*x);


%heat equations Backward-Difference 
m=10; T=0.1; N=2; l = 1;

%set alpha 
lalpha = 0.1;

% m=m-1; N=N-1;
%step 1
h=l/m; k=T/N; lambda = (lalpha*lalpha*k)/(h*h);
w = zeros(m,N);
%step 2 
for i = 1:m-1
    w(i,1) = ux(i*h);
end

l(1) = 1+(2*lambda);
u(1) = -lambda/l(1);

for i=2:m-2
    l(i) = 1+(2*lambda)+(lambda*u(i-1));
    u(i) = -lambda/l(i);
end
%step 5
l(m-1) = 1+(2*lambda)+(lambda*u(m-2));
%step 6
for j = 1:N-1
    t(j) = j*k;
    z(1) = w(1,j)/l(1);
    for i = 2:m-1
        z(i)= (w(i,j)+(lambda*z(i-1)))/l(i);
    end
    w(m-1,j+1) = z(m-1);
    for i = m-2:-1:1
        w(i,j+1) = z(i)-(u(i)*w(i+1,j+1));
    end
    fprintf("t: %0.2f\n",t);
    for i = 1:m-1
        x = i*h;
        fprintf("x:%0.2f,\t w:%0.4f\n",x,w(i,j+1));
%         fprintf();
    end
end


