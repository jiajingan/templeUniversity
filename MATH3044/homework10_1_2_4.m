%Jackie Gan
%MATH 3044
%Homework10.1,10.2,10.4

format long

close all
clear
clc

%system equation
x = @(y) (1/2)-y^2;
y = @(x) 4-x^2;

x0 = 0;
y0 = 0;
n=3;

fixedPoint(x0,y0,x,y,n);
%so we see that after the third iterations it starts to diverage
%the answer is between x1 to x2, 0 to 0.5
function fixedPoint(x0,y0,x,y,n)
    fixPointX(1)=x0;
    fixPointY(1)=y0;
    for i=1:n
        fixPointX(i+1) = x(fixPointY(i));
        fixPointY(i+1) = y(fixPointX(i));
    end
    disp(fixPointX)
    disp(fixPointY)
end

