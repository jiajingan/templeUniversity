%Jackie Gan
%Numerical Analysis 2, Math 3044
%Professor Guan
format long
%homework 5_4, 6 and 14
%just uncomment the method and the question you want to use

%Midpoint method question 6
    %question 2a
%     F = @(t,y)exp(t-y);    
%     h=0.5;
%     t=0:h:1; 
%     y0=1;
%     Ft=@(t)log(exp(t)+exp(1)-1);

    %question 2b
%     F=@(t,y)(1+t)/(1+y);
%     h=0.5;
%     t=1:h:2;
%     y0=2;
%     Ft=@(t)sqrt(t^2+(2*t)+6)-1;

    %question 2c
%     F=@(t,y)-y+(t*y^(1/2));
%     h=0.25;
%     t=2:h:3;
%     y0=2;
%     Ft=@(t)(t-2+sqrt(2)*exp(1)*exp(-t/2))^2;

    %question 2d
    F=@(t,y)(t^-2)*(sin(2*t)-2*t*y);
    h=0.25;
    t=1:h:2;
    y0=2;
    Ft=@(t)(4+cos(2)-cos(2*t))/(2*t^2);

%midpoint method
% error = zeros(size(t));
% y = zeros(size(t));
% y(1)=y0;
% for i=2:length(t)
%     y(i)=y(i-1)+h*F(t(i-1)+(h/2),y(i-1)+(h/2)*F(t(i-1),y(i-1)));
% 
%     %calculating error in percentage
%     error(i)=abs(y(i)-Ft(t(i)));
% end
% disp(y)
% disp(error)

%Runge-Kutta Method of order 4
k = zeros(1,4);
y = zeros(size(t));
error = zeros(size(t));
y(1)=y0;
for i=2:length(t)

        k(1)=h*F(t(i-1),y(i-1));
        k(2)=h*F(t(i-1)+(h/2),y(i-1)+((1/2)*k(1)));
        k(3)=h*F(t(i-1)+(h/2),y(i-1)+((1/2)*k(2)));
        k(4)=h*F(t(i),y(i-1)+k(3));
        y(i)=y(i-1)+((1/6)*(k(1)+(2*k(2))+(2*k(3))+k(4)));
        
        %calculating error 
        error(i)=abs(y(i)-Ft(t(i)));
end
disp(y)
disp(error)