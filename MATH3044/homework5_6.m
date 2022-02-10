%Jackie Gan
%Numerical Analysis 2, Math 3044
%Professor Guan
format long
clc

%problem 2a
    F = @(t,y)1+(y/t)+(y/t)^2;    
    h=0.1;
    t=1:h:1.5; 
    y0=0;
    Ft=@(t)t*tan(log(t));

%problem 2b
%     F = @(t,y)sin(t)+exp(-t);    
%     h=0.1;
%     t=0:h:0.5; 
%     y0=0;
%     Ft=@(t)2-cos(t)-exp(-t);

%(1) Adams-Bashforth Two-Step Explicit Method
% error = zeros(size(t));
% y = zeros(size(t));
% y(1)=y0;
% y(2)=Ft(t(1)+h);
% 
% for i=3:length(t)
%     y(i)=y(i-1)+((h/2)*((3*F(t(i-1),y(i-1))-F(t(i-2),y(i-2)))));
%error(i)=abs(y(i)-Ft(t(i)));
% end
% disp(y)
% disp(error)

%(2) Adams-Bashforth Three-Step Explicit Method
% error = zeros(size(t));
% y = zeros(size(t));
% y(1)=y0;
% y(2)=Ft(t(1)+h);
% y(3)=Ft(t(2)+h);
% %disp(t)
% 
% for i=4:length(t)
% %    y(i)=y(i-1)+((h/12)*((23*F(t(i-1),y(i-1)))-(16*F(t(i-2,y(i-2))))+(5*F(t(i-3),y(i-3)))));
% y(i)=y(i-1)+((h/12)*(23*F(t(i-1),(y(i-1)))-(16*F(t(i-2),y(i-2))+(5*F(t(i-3),y(i-3))))));
%error(i)=abs(y(i)-Ft(t(i)));
% %disp(i)
% end
% disp(y)
%disp(error)

%(3) Adams-Moulton Two-Step Implicit Method
error = zeros(size(t));
y = zeros(size(t));
y(1)=y0;
y(2)=Ft(t(1)+h);

for i=3:length(t)
%fixed point iteration
ytemp1 = y(i-1);
ytemp = ytemp1;

while (abs(ytemp1-ytemp) >= 1*10^-8)
    ytemp=ytemp1;
    ytemp1=F(t(i),ytemp);
    y(i)=ytemp;
end


y(i) = y(i-1) + h/12*((5*F(t(i),y(i))) + (8*F(t(i-1),y(i-1))) - (F(t(i-2),y(i-2))));
error(i)=abs(y(i)-Ft(t(i)));

end
disp(y)
disp(error)