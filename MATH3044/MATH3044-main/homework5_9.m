%Jackie Gan
%Numerical Analysis 2, Math 3044
%Professor Guan
format long


FX = @(x,y) (10-y)*x;
FY = @(x,y) ((0.1*x)-10)*y;
n=1000000;
T=10;
x0=400;
y0=5;
h=T/n;
t=0:h:T;

%initialize values
x = zeros(size(t));
x(1)=x0;
y = zeros(size(t));
y(1)=y0;

% (1) Forward Euler's Method
% for i = 2:length(t)
%     x(i) = x(i-1)+(h*FX(x(i-1),y(i-1)));
%     y(i) = y(i-1)+(h*FY(x(i-1),y(i-1)));
% end


% (2) Backward Euler's Method


for i = 2:length(t)
    xtemp1=x(i-1);
    ytemp1=y(i-1);
    xtemp=xtemp1;
    ytemp=ytemp1;

    for j = 1:20
        xtemp = xtemp1 + (h*FX(xtemp1,ytemp1));
        ytemp = ytemp1 + (h*FY(xtemp1,ytemp1));
    end
    
    x(i)=xtemp;
    y(i)=ytemp;
end

% (3) Midpoint Runge-Kutta Mehtod
% k = zeros(1,4); %for runge-kutta
% kx = zeros(1,4);
% 
% for i=2:length(t)
%     %X ODE
%     kx(1)=h*FX(x(i-1),y(i-1));
%     kx(2)=h*FX(x(i-1)+(h/2),y(i-1)+((1/2)*kx(1)));
%     kx(3)=h*FX(x(i-1)+(h/2),y(i-1)+((1/2)*kx(2)));
%     kx(4)=h*FX(x(i),y(i-1)+kx(3));
%     x(i)=x(i-1)+((1/6)*(kx(1)+(2*kx(2))+(2*kx(3))+kx(4)));
% 
% %     %Y ODE
%     k(1)=h*FY(x(i-1),y(i-1));
%     k(2)=h*FY(x(i-1)+(h/2),y(i-1)+((1/2)*k(1)));
%     k(3)=h*FY(x(i-1)+(h/2),y(i-1)+((1/2)*k(2)));
%     k(4)=h*FY(x(i),y(i-1)+k(3));
%     y(i)=y(i-1)+((1/6)*(k(1)+(2*k(2))+(2*k(3))+k(4)));
% 
%     
% end

%displaying output
plot(x,y)
